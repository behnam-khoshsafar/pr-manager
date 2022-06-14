package com.bkh.prmanager.interceptor

import com.bkh.prmanager.exception.AuthenticationFailedException
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.stereotype.Component
import org.springframework.web.context.annotation.RequestScope


@Component
@RequestScope
class GithubClientInterceptor(val oauth2AuthorizedClientService: OAuth2AuthorizedClientService) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(getRequest(chain))
    }

    private fun getRequest(chain: Interceptor.Chain): Request {
        val accessToken = oAuth2AccessToken()
        return chain.request().newBuilder()
            .addHeader("Authorization", "token $accessToken")
            .addHeader("Accept", "application/vnd.github.v3+json")
            .build()
    }

    private fun oAuth2AccessToken(): String {
        val authentication: OAuth2AuthenticationToken = getOAuth2AuthenticationToken()
        validateAuthenticate(authentication)
        return getAccessToken(authentication)
    }

    private fun getOAuth2AuthenticationToken(): OAuth2AuthenticationToken {
        return SecurityContextHolder
            .getContext()
            .authentication as OAuth2AuthenticationToken
    }

    private fun validateAuthenticate(authentication: OAuth2AuthenticationToken) {
        if (!authentication.isAuthenticated)
            throw AuthenticationFailedException("Authentication Failed")
    }

    private fun getAccessToken(authentication: OAuth2AuthenticationToken): String {
        val client: OAuth2AuthorizedClient = oauth2AuthorizedClientService.loadAuthorizedClient(
            authentication.authorizedClientRegistrationId,
            authentication.name
        )
        return client.accessToken.tokenValue
    }
}
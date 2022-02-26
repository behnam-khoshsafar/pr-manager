package com.bkh.prmanager.interceptor

import com.bkh.prmanager.exception.AuthenticationFailedException
import okhttp3.Interceptor
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
        val accessToken = oAuth2AccessToken()
        val request = chain.request()
        val builder = request.newBuilder()
            .addHeader("Authorization", "token $accessToken")
            .addHeader("Accept", "application/vnd.github.v3+json")
        return chain.proceed(builder.build());
    }

    private fun oAuth2AccessToken(): String {
        val authentication: OAuth2AuthenticationToken = SecurityContextHolder
            .getContext()
            .authentication as OAuth2AuthenticationToken

        if (!authentication.isAuthenticated)
            throw AuthenticationFailedException("Authentication Failed")

        val client: OAuth2AuthorizedClient = oauth2AuthorizedClientService.loadAuthorizedClient(
            authentication.authorizedClientRegistrationId,
            authentication.name
        )
        return client.accessToken.tokenValue
    }
}
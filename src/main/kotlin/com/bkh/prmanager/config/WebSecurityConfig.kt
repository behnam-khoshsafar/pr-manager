package com.bkh.prmanager.config

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus.UNAUTHORIZED
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.HttpStatusEntryPoint
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler
import org.springframework.security.web.csrf.CookieCsrfTokenRepository


@Configuration
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        val handler = SimpleUrlAuthenticationFailureHandler("/")
        http
            .authorizeRequests {
                it
                    .antMatchers("/", "/error").permitAll()
                    .anyRequest().authenticated()
            }
            .exceptionHandling {
                it.authenticationEntryPoint(HttpStatusEntryPoint(UNAUTHORIZED))
            }
            .csrf {
                it.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            }
            .logout {
                it.logoutSuccessUrl("/").permitAll()
            }
            .oauth2Login {
                it.failureHandler { request, response, exception ->
                    request.session.setAttribute("error.message", exception.message)
                    handler.onAuthenticationFailure(request, response, exception)
                }
            }
    }
}
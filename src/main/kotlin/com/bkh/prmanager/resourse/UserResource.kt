package com.bkh.prmanager.resourse

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest


@RestController
class UserResource {

    @GetMapping("/user")
    fun getUser(@AuthenticationPrincipal user: OAuth2User): Map<String, String> {
        val userName = user.getAttribute("login") ?: "";
        return mapOf("name" to userName)
    }

    @GetMapping("/error")
    fun error(request: HttpServletRequest): String? {
        val message = request.session.getAttribute("error.message") as String?
        request.session.removeAttribute("error.message")
        return message
    }
}
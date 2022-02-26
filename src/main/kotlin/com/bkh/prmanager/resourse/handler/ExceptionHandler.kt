package com.bkh.prmanager.resourse.handler

import com.bkh.prmanager.exception.AuthenticationFailedException
import com.bkh.prmanager.exception.GithubClientException
import com.bkh.prmanager.model.ErrorResponse
import org.springframework.http.HttpStatus.UNAUTHORIZED
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(GithubClientException::class)
    fun githubClientExceptionHandler(exception: GithubClientException): ResponseEntity<ErrorResponse> {
        return ResponseEntity
            .status(exception.httpStatus)
            .body(ErrorResponse(exception.httpStatus, exception.message))
    }

    @ExceptionHandler(AuthenticationFailedException::class)
    fun authenticationFailedExceptionHandler(exception: AuthenticationFailedException): ResponseEntity<ErrorResponse> {
        return ResponseEntity
            .status(UNAUTHORIZED)
            .body(ErrorResponse(UNAUTHORIZED.value(), exception.message))
    }

}
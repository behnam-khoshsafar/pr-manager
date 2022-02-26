package com.bkh.prmanager.resourse

import com.bkh.prmanager.model.Repository
import com.bkh.prmanager.service.UserService
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RepositoryResource(val userService: UserService) {

    @GetMapping(
        path = ["/user/repos"],
        produces = [APPLICATION_JSON_VALUE]
    )
    fun getRepositories(): ResponseEntity<List<Repository>> {
        return ResponseEntity
            .ok()
            .body(userService.getUserRepositories())
    }
}
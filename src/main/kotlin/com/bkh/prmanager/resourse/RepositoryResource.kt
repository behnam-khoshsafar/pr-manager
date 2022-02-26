package com.bkh.prmanager.resourse

import com.bkh.prmanager.resourse.dto.RepositoryDto
import com.bkh.prmanager.service.github.GithubUserService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RepositoryResource(val githubUserService: GithubUserService) {

    @GetMapping(
        path = ["/user/repos"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getRepositories(): ResponseEntity<List<RepositoryDto>> {
        val userRepositories = githubUserService.getUserRepositories()
        return ResponseEntity
            .ok()
            .body(userRepositories.stream()
                .map { RepositoryDto(it.id, it.name, it.user.login) }
                .toList())
    }
}
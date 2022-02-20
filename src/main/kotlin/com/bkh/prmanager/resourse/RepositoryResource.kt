package com.bkh.prmanager.resourse

import com.bkh.prmanager.resourse.dto.RepositoryDto
import com.bkh.prmanager.service.github.GithubService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RepositoryResource(val githubService: GithubService) {

    @GetMapping(
        path = ["/user/repos"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getRepositories(): ResponseEntity<List<RepositoryDto>> {
        val userRepositories = githubService.getUserRepositories()
        return ResponseEntity
            .ok()
            .body(userRepositories.stream()
                .map { RepositoryDto(it.id, it.name) }
                .toList())
    }
}
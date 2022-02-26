package com.bkh.prmanager.resourse

import com.bkh.prmanager.model.PullRequest
import com.bkh.prmanager.service.PullRequestService
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class PullRequestResource(val pullRequestService: PullRequestService) {

    @GetMapping(path = ["/repos/{owner}/{repo}/pulls"], produces = [APPLICATION_JSON_VALUE])
    fun getPullRequests(
        @PathVariable("owner") owner: String,
        @PathVariable("repo") repo: String
    ): ResponseEntity<List<PullRequest>> {
        return ResponseEntity
            .ok()
            .body(pullRequestService.getPullRequest(owner, repo))
    }
}
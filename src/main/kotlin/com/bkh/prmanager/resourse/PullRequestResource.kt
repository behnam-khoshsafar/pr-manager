package com.bkh.prmanager.resourse

import com.bkh.prmanager.resourse.dto.PullRequestDto
import com.bkh.prmanager.service.github.GithubPullRequestService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.stream.Collectors

@RestController
class PullRequestResource(val githubPullRequestService: GithubPullRequestService) {

    @GetMapping(path = ["/repos/{owner}/{repo}/pulls"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getPullRequests(
        @PathVariable("owner") owner: String,
        @PathVariable("repo") repo: String
    ): List<PullRequestDto> {

        val pullRequests = githubPullRequestService.getPullRequest(owner, repo)

        return pullRequests.stream().map {
            PullRequestDto(
                it.id,
                it.title,
                it.user.login,
                it.updatedAt,
                it.head.ref,
                it.base.ref,
                it.requestedReviewers.stream().map { user -> user.login }.collect(Collectors.toList()),
                it.state
            )
        }.collect(Collectors.toList())
    }

}
package com.bkh.prmanager.service.github.impl

import com.bkh.prmanager.client.github.GithubClient
import com.bkh.prmanager.exception.GithubClientException
import com.bkh.prmanager.model.pullrequest.PullRequest
import com.bkh.prmanager.service.github.GithubPullRequestService
import org.springframework.stereotype.Service

@Service
class GithubPullRequestServiceImpl(val githubClient: GithubClient) : GithubPullRequestService {

    override fun getPullRequest(owner: String, repo: String): List<PullRequest> {
        val pullRequests = githubClient.getPullRequests(owner, repo)
        val response = pullRequests.execute()

        if (!response.isSuccessful) {
            throw GithubClientException(response.code(), response.message())
        }
        return response.body() ?: emptyList()
    }
}
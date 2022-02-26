package com.bkh.prmanager.service.github.impl

import com.bkh.prmanager.client.github.GithubClient
import com.bkh.prmanager.client.model.github.pullrequest.GithubPullRequest
import com.bkh.prmanager.exception.GithubClientException
import com.bkh.prmanager.model.PullRequest
import com.bkh.prmanager.service.PullRequestService
import org.springframework.stereotype.Service
import retrofit2.Response

@Service
class GithubPullRequestServiceImpl(val githubClient: GithubClient) : PullRequestService {

    override fun getPullRequest(owner: String, repo: String): List<PullRequest> {
        val response = executeRequest(owner, repo)
        return handleResponse(response)
    }

    private fun executeRequest(owner: String, repo: String): Response<List<GithubPullRequest>> {
        return githubClient
            .getPullRequests(owner, repo)
            .execute()
    }

    private fun handleResponse(response: Response<List<GithubPullRequest>>): List<PullRequest> {
        if (!response.isSuccessful)
            throw GithubClientException(response.code(), response.message())

        return response.body()?.let { getPullRequests(it) } ?: emptyList()
    }

    private fun getPullRequests(pullRequests: List<GithubPullRequest>): List<PullRequest> {
        return pullRequests.stream()
            .map { mapToPullRequest(it) }
            .toList()
    }

    private fun mapToPullRequest(pullRequest: GithubPullRequest) = PullRequest(
        pullRequest.id,
        pullRequest.title,
        pullRequest.user.login,
        pullRequest.updatedAt,
        pullRequest.head.ref,
        pullRequest.base.ref,
        getReviewers(pullRequest),
        pullRequest.state
    )

    private fun getReviewers(pullRequest: GithubPullRequest) =
        pullRequest.requestedReviewers.stream()
            .map { user -> user.login }
            .toList()
}
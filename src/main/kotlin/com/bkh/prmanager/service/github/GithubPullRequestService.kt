package com.bkh.prmanager.service.github

import com.bkh.prmanager.model.pullrequest.PullRequest

interface GithubPullRequestService {

    fun getPullRequest(owner: String, repo: String): List<PullRequest>

}
package com.bkh.prmanager.service

import com.bkh.prmanager.model.PullRequest

interface PullRequestService {

    fun getPullRequest(owner: String, repo: String): List<PullRequest>

}
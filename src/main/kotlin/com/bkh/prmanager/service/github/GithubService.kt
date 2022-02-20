package com.bkh.prmanager.service.github

import com.bkh.prmanager.model.GithubRepository

interface GithubService {

    fun getUserRepositories(): List<GithubRepository>

}
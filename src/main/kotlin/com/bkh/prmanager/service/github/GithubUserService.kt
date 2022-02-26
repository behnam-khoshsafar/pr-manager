package com.bkh.prmanager.service.github

import com.bkh.prmanager.model.Repo

interface GithubUserService {

    fun getUserRepositories(): List<Repo>

}
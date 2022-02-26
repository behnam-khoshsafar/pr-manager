package com.bkh.prmanager.service.github.impl

import com.bkh.prmanager.client.github.GithubClient
import com.bkh.prmanager.exception.GithubClientException
import com.bkh.prmanager.model.Repo
import com.bkh.prmanager.service.github.GithubUserService
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service


@Service
@Slf4j
class GithubUserServiceImpl(val githubClient: GithubClient) : GithubUserService {

    override fun getUserRepositories(): List<Repo> {
        val repos = githubClient.getRepos()
        val response = repos.execute()

        if (!response.isSuccessful) {
            throw GithubClientException(response.code(), response.message())
        }
        return response.body() ?: emptyList()
    }
}
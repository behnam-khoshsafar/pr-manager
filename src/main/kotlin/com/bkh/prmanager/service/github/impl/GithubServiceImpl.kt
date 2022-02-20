package com.bkh.prmanager.service.github.impl

import com.bkh.prmanager.client.github.GithubClient
import com.bkh.prmanager.exception.GithubClientException
import com.bkh.prmanager.model.GithubRepository
import com.bkh.prmanager.service.github.GithubService
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service


@Service
@Slf4j
class GithubServiceImpl(val githubClient: GithubClient) : GithubService {

    override fun getUserRepositories(): List<GithubRepository> {
        val repos = githubClient.getRepos()
        val response = repos.execute()

        if (!response.isSuccessful) {
            throw GithubClientException(response.code(), response.message())
        }
        return response.body() ?: emptyList()
    }
}
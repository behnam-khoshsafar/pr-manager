package com.bkh.prmanager.service.github.impl

import com.bkh.prmanager.client.github.GithubClient
import com.bkh.prmanager.client.model.github.GithubRepo
import com.bkh.prmanager.exception.GithubClientException
import com.bkh.prmanager.model.Repository
import com.bkh.prmanager.service.UserService
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service
import retrofit2.Response


@Service
@Slf4j
class GithubUserServiceImpl(val githubClient: GithubClient) : UserService {

    override fun getUserRepositories(): List<Repository> {
        val response = executeRequest()
        return handleResponse(response)
    }

    private fun executeRequest(): Response<List<GithubRepo>> {
        return githubClient.getRepos().execute()
    }

    private fun handleResponse(response: Response<List<GithubRepo>>): List<Repository> {
        if (!response.isSuccessful)
            throw GithubClientException(response.code(), response.message())

        return response.body()?.let { getRepositories(it) } ?: emptyList()
    }

    private fun getRepositories(githubRepositories: List<GithubRepo>): List<Repository> {
        return githubRepositories.stream()
            .map { Repository(it.id, it.name, it.user.login) }
            .toList()
    }
}
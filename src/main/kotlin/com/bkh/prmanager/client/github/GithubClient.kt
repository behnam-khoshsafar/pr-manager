package com.bkh.prmanager.client.github

import com.bkh.prmanager.model.GithubRepository
import retrofit2.Call
import retrofit2.http.GET


interface GithubClient {

    @GET("user/repos")
    fun getRepos(): Call<List<GithubRepository>>

}
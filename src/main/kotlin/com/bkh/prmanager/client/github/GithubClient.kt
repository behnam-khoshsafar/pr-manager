package com.bkh.prmanager.client.github

import com.bkh.prmanager.client.model.github.GithubRepo
import com.bkh.prmanager.client.model.github.pullrequest.GithubPullRequest
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubClient {

    @GET("user/repos")
    fun getRepos(): Call<List<GithubRepo>>

    @GET("/repos/{owner}/{repo}/pulls")
    fun getPullRequests(@Path("owner") owner: String, @Path("repo") repo: String): Call<List<GithubPullRequest>>

}
package com.bkh.prmanager.client.github

import com.bkh.prmanager.model.Repo
import com.bkh.prmanager.model.pullrequest.PullRequest
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubClient {

    @GET("user/repos")
    fun getRepos(): Call<List<Repo>>

    @GET("/repos/{owner}/{repo}/pulls")
    fun getPullRequests(@Path("owner") owner: String, @Path("repo") repo: String): Call<List<PullRequest>>;

}
package com.bkh.prmanager.client.model.github.pullrequest


import com.bkh.prmanager.client.model.github.GithubRepo
import com.bkh.prmanager.client.model.github.User
import com.fasterxml.jackson.annotation.JsonProperty

data class HeadRepository(
    @JsonProperty("label")
    val label: String,
    @JsonProperty("ref")
    val ref: String,
    @JsonProperty("repo")
    val repo: GithubRepo,
    @JsonProperty("sha")
    val sha: String,
    @JsonProperty("user")
    val user: User?
)
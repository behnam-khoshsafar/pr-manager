package com.bkh.prmanager.model.pullrequest


import com.bkh.prmanager.model.Repo
import com.bkh.prmanager.model.User
import com.fasterxml.jackson.annotation.JsonProperty

data class BaseRepository(
    @JsonProperty("label")
    val label: String,
    @JsonProperty("ref")
    val ref: String,
    @JsonProperty("repo")
    val repo: Repo,
    @JsonProperty("sha")
    val sha: String,
    @JsonProperty("user")
    val user: User?
)
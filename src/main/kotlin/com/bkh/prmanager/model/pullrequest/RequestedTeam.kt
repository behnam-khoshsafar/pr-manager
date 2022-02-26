package com.bkh.prmanager.model.pullrequest


import com.fasterxml.jackson.annotation.JsonProperty

data class RequestedTeam(
    @JsonProperty("description")
    val description: String?,
    @JsonProperty("html_url")
    val htmlUrl: String,
    @JsonProperty("id")
    val id: Int,
    @JsonProperty("members_url")
    val membersUrl: String,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("node_id")
    val nodeId: String,
    @JsonProperty("parent")
    val parent: Team?,
    @JsonProperty("permission")
    val permission: String,
    @JsonProperty("privacy")
    val privacy: String,
    @JsonProperty("repositories_url")
    val repositoriesUrl: String,
    @JsonProperty("slug")
    val slug: String,
    @JsonProperty("url")
    val url: String
)
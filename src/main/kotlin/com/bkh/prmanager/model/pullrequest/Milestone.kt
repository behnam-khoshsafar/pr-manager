package com.bkh.prmanager.model.pullrequest


import com.bkh.prmanager.model.User
import com.fasterxml.jackson.annotation.JsonProperty

data class Milestone(
    @JsonProperty("closed_at")
    val closedAt: String?,
    @JsonProperty("closed_issues")
    val closedIssues: Int,
    @JsonProperty("created_at")
    val createdAt: String?,
    @JsonProperty("creator")
    val creator: User?,
    @JsonProperty("description")
    val description: String?,
    @JsonProperty("due_on")
    val dueOn: String,
    @JsonProperty("html_url")
    val htmlUrl: String,
    @JsonProperty("id")
    val id: Int,
    @JsonProperty("labels_url")
    val labelsUrl: String,
    @JsonProperty("node_id")
    val nodeId: String,
    @JsonProperty("number")
    val number: Int,
    @JsonProperty("open_issues")
    val openIssues: Int,
    @JsonProperty("state")
    val state: String,
    @JsonProperty("title")
    val title: String,
    @JsonProperty("updated_at")
    val updatedAt: String?,
    @JsonProperty("url")
    val url: String
)
package com.bkh.prmanager.model.pullrequest


import com.fasterxml.jackson.annotation.JsonProperty

data class Links(
    @JsonProperty("comments")
    val comments: Link,
    @JsonProperty("commits")
    val commits: Link,
    @JsonProperty("html")
    val html: Link,
    @JsonProperty("issue")
    val issue: Link,
    @JsonProperty("review_comment")
    val reviewComment: Link,
    @JsonProperty("review_comments")
    val reviewComments: Link,
    @JsonProperty("self")
    val self: Link,
    @JsonProperty("statuses")
    val statuses: Link
)
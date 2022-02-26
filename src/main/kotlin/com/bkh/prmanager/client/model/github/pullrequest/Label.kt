package com.bkh.prmanager.client.model.github.pullrequest


import com.fasterxml.jackson.annotation.JsonProperty

data class Label(
    @JsonProperty("color")
    val color: String,
    @JsonProperty("default")
    val default: Boolean,
    @JsonProperty("description")
    val description: String,
    @JsonProperty("id")
    val id: Int,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("node_id")
    val nodeId: String,
    @JsonProperty("url")
    val url: String
)
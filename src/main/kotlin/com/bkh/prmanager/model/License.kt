package com.bkh.prmanager.model


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class License(
    @JsonProperty("html_url")
    val htmlUrl: String?,
    @JsonProperty("key")
    val key: String,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("node_id")
    val nodeId: String,
    @JsonProperty("spdx_id")
    val spdxId: String?,
    @JsonProperty("url")
    val url: String?
)
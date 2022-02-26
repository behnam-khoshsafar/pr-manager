package com.bkh.prmanager.client.model.github.pullrequest


import com.fasterxml.jackson.annotation.JsonProperty

data class Link(
    @JsonProperty("href")
    val href: String
)
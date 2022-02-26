package com.bkh.prmanager.model.pullrequest


import com.fasterxml.jackson.annotation.JsonProperty

data class Link(
    @JsonProperty("href")
    val href: String
)
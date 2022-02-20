package com.bkh.prmanager.model


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Permissions(
    @JsonProperty("admin")
    val admin: Boolean,
    @JsonProperty("pull")
    val pull: Boolean,
    @JsonProperty("push")
    val push: Boolean
)
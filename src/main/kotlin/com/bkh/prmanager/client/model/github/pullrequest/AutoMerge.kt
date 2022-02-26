package com.bkh.prmanager.client.model.github.pullrequest

import com.bkh.prmanager.client.model.github.User
import com.fasterxml.jackson.annotation.JsonProperty

data class AutoMerge(
    @JsonProperty("enabled_by")
    var enabledBy: User,
    @JsonProperty("merge_method")
    var mergeMethod: String,
    @JsonProperty("commit_title")
    var commitTitle: String,
    @JsonProperty("commit_message")
    var commitMessage: String
)

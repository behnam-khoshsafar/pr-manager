package com.bkh.prmanager.model.pullrequest

import com.bkh.prmanager.model.User
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

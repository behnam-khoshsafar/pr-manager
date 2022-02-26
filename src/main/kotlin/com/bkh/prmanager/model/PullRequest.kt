package com.bkh.prmanager.model

data class PullRequest(
    val id: Int,
    val title: String,
    val owner: String,
    val updatedAt: String?,
    val headBranchName: String,
    val baseBranchName: String,
    val reviewers: List<String>,
    val state:String
)
package com.bkh.prmanager.client.model.github.pullrequest


import com.bkh.prmanager.client.model.github.User
import com.fasterxml.jackson.annotation.JsonProperty

data class GithubPullRequest(
    @JsonProperty("active_lock_reason")
    val activeLockReason: String?,
    @JsonProperty("assignee")
    val assignee: User?,
    @JsonProperty("assignees")
    val assignees: List<User>?,
    @JsonProperty("author_association")
    val authorAssociation: String,
    @JsonProperty("auto_merge")
    val autoMerge: AutoMerge?,
    @JsonProperty("base")
    val base: BaseRepository,
    @JsonProperty("body")
    val body: String?,
    @JsonProperty("closed_at")
    val closedAt: String?,
    @JsonProperty("comments_url")
    val commentsUrl: String,
    @JsonProperty("commits_url")
    val commitsUrl: String,
    @JsonProperty("created_at")
    val createdAt: String?,
    @JsonProperty("diff_url")
    val diffUrl: String,
    @JsonProperty("draft")
    val draft: Boolean,
    @JsonProperty("head")
    val head: HeadRepository,
    @JsonProperty("html_url")
    val htmlUrl: String,
    @JsonProperty("id")
    val id: Int,
    @JsonProperty("issue_url")
    val issueUrl: String,
    @JsonProperty("labels")
    val labels: List<Label>,
    @JsonProperty("_links")
    val links: Links,
    @JsonProperty("locked")
    val locked: Boolean,
    @JsonProperty("merge_commit_sha")
    val mergeCommitSha: String?,
    @JsonProperty("merged_at")
    val mergedAt: String?,
    @JsonProperty("milestone")
    val milestone: Milestone?,
    @JsonProperty("node_id")
    val nodeId: String,
    @JsonProperty("number")
    val number: Int,
    @JsonProperty("patch_url")
    val patchUrl: String,
    @JsonProperty("requested_reviewers")
    val requestedReviewers: List<User>,
    @JsonProperty("requested_teams")
    val requestedTeams: List<RequestedTeam>?,
    @JsonProperty("review_comment_url")
    val reviewCommentUrl: String,
    @JsonProperty("review_comments_url")
    val reviewCommentsUrl: String,
    @JsonProperty("state")
    val state: String,
    @JsonProperty("statuses_url")
    val statusesUrl: String,
    @JsonProperty("title")
    val title: String,
    @JsonProperty("updated_at")
    val updatedAt: String?,
    @JsonProperty("url")
    val url: String,
    @JsonProperty("user")
    val user: User
)
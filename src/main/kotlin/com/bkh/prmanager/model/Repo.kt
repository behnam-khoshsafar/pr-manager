package com.bkh.prmanager.model


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Repo(
    @JsonProperty("allow_auto_merge")
    val allowAutoMerge: Boolean?,
    @JsonProperty("allow_merge_commit")
    val allowMergeCommit: Boolean?,
    @JsonProperty("allow_rebase_merge")
    val allowRebaseMerge: Boolean?,
    @JsonProperty("allow_squash_merge")
    val allowSquashMerge: Boolean?,
    @JsonProperty("archive_url")
    val archiveUrl: String,
    @JsonProperty("archived")
    val archived: Boolean,
    @JsonProperty("assignees_url")
    val assigneesUrl: String,
    @JsonProperty("blobs_url")
    val blobsUrl: String,
    @JsonProperty("branches_url")
    val branchesUrl: String,
    @JsonProperty("clone_url")
    val cloneUrl: String,
    @JsonProperty("collaborators_url")
    val collaboratorsUrl: String,
    @JsonProperty("comments_url")
    val commentsUrl: String,
    @JsonProperty("commits_url")
    val commitsUrl: String,
    @JsonProperty("compare_url")
    val compareUrl: String,
    @JsonProperty("contents_url")
    val contentsUrl: String,
    @JsonProperty("contributors_url")
    val contributorsUrl: String,
    @JsonProperty("created_at")
    val createdAt: String?,
    @JsonProperty("default_branch")
    val defaultBranch: String,
    @JsonProperty("delete_branch_on_merge")
    val deleteBranchOnMerge: Boolean?,
    @JsonProperty("deployments_url")
    val deploymentsUrl: String,
    @JsonProperty("description")
    val description: String?,
    @JsonProperty("disabled")
    val disabled: Boolean,
    @JsonProperty("downloads_url")
    val downloadsUrl: String,
    @JsonProperty("events_url")
    val eventsUrl: String,
    @JsonProperty("fork")
    val fork: Boolean,
    @JsonProperty("forks")
    val forks: Int,
    @JsonProperty("forks_count")
    val forksCount: Int,
    @JsonProperty("forks_url")
    val forksUrl: String,
    @JsonProperty("full_name")
    val fullName: String,
    @JsonProperty("git_commits_url")
    val gitCommitsUrl: String,
    @JsonProperty("git_refs_url")
    val gitRefsUrl: String,
    @JsonProperty("git_tags_url")
    val gitTagsUrl: String,
    @JsonProperty("git_url")
    val gitUrl: String,
    @JsonProperty("has_downloads")
    val hasDownloads: Boolean,
    @JsonProperty("has_issues")
    val hasIssues: Boolean,
    @JsonProperty("has_pages")
    val hasPages: Boolean,
    @JsonProperty("has_projects")
    val hasProjects: Boolean,
    @JsonProperty("has_wiki")
    val hasWiki: Boolean,
    @JsonProperty("homepage")
    val homepage: String?,
    @JsonProperty("hooks_url")
    val hooksUrl: String,
    @JsonProperty("html_url")
    val htmlUrl: String,
    @JsonProperty("id")
    val id: Int,
    @JsonProperty("is_template")
    val isTemplate: Boolean?,
    @JsonProperty("issue_comment_url")
    val issueCommentUrl: String,
    @JsonProperty("issue_events_url")
    val issueEventsUrl: String,
    @JsonProperty("issues_url")
    val issuesUrl: String,
    @JsonProperty("keys_url")
    val keysUrl: String,
    @JsonProperty("labels_url")
    val labelsUrl: String,
    @JsonProperty("language")
    val language: String?,
    @JsonProperty("languages_url")
    val languagesUrl: String,
    @JsonProperty("license")
    val license: License?,
    @JsonProperty("merges_url")
    val mergesUrl: String,
    @JsonProperty("milestones_url")
    val milestonesUrl: String,
    @JsonProperty("mirror_url")
    val mirrorUrl: String?,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("network_count")
    val networkCount: Int?,
    @JsonProperty("node_id")
    val nodeId: String,
    @JsonProperty("notifications_url")
    val notificationsUrl: String,
    @JsonProperty("open_issues")
    val openIssues: Int,
    @JsonProperty("open_issues_count")
    val openIssuesCount: Int,
    @JsonProperty("owner")
    val user: User,
    @JsonProperty("permissions")
    val permissions: Permissions?,
    @JsonProperty("private")
    val `private`: Boolean,
    @JsonProperty("pulls_url")
    val pullsUrl: String,
    @JsonProperty("pushed_at")
    val pushedAt: String?,
    @JsonProperty("releases_url")
    val releasesUrl: String,
    @JsonProperty("size")
    val size: Int,
    @JsonProperty("ssh_url")
    val sshUrl: String,
    @JsonProperty("stargazers_count")
    val stargazersCount: Int,
    @JsonProperty("stargazers_url")
    val stargazersUrl: String,
    @JsonProperty("statuses_url")
    val statusesUrl: String,
    @JsonProperty("subscribers_count")
    val subscribersCount: Int?,
    @JsonProperty("subscribers_url")
    val subscribersUrl: String,
    @JsonProperty("subscription_url")
    val subscriptionUrl: String,
    @JsonProperty("svn_url")
    val svnUrl: String,
    @JsonProperty("tags_url")
    val tagsUrl: String,
    @JsonProperty("teams_url")
    val teamsUrl: String,
    @JsonProperty("temp_clone_token")
    val tempCloneToken: String?,
    @JsonProperty("template_repository")
    val templateRepository: Repo?,
    @JsonProperty("topics")
    val topics: List<String>?,
    @JsonProperty("trees_url")
    val treesUrl: String,
    @JsonProperty("updated_at")
    val updatedAt: String?,
    @JsonProperty("url")
    val url: String,
    @JsonProperty("visibility")
    val visibility: String?,
    @JsonProperty("watchers")
    val watchers: Int,
    @JsonProperty("watchers_count")
    val watchersCount: Int
)
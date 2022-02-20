package com.bkh.prmanager.exception

class GithubClientException(val httpStatus: Int, message: String) : RuntimeException(message)

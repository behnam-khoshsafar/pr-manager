package com.bkh.prmanager.service

import com.bkh.prmanager.model.Repository

interface UserService {

    fun getUserRepositories(): List<Repository>

}
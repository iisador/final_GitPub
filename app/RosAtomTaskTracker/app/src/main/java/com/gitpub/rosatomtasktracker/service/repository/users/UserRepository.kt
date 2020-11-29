package com.gitpub.rosatomtasktracker.service.repository.users

import com.gitpub.rosatomtasktracker.model.domain.User
import com.gitpub.rosatomtasktracker.model.util.Result

interface UserRepository {

    suspend fun getUserById(id: Long): Result<User>
}
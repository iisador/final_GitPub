package com.gitpub.rosatomtasktracker.service.repository.users

import com.gitpub.rosatomtasktracker.model.domain.Position
import com.gitpub.rosatomtasktracker.model.domain.User
import com.gitpub.rosatomtasktracker.model.util.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MockUserRepositoryImpl : UserRepository {

    override suspend fun getUserById(id: Long): Result<User> {
        return withContext(Dispatchers.IO) {
            when (id) {
                1L -> Result.Success(
                    User(
                        1,
                        "Lexa",
                        Position(1, "Tsar"),
                        0
                    )
                )
                else -> Result.Error(NoSuchElementException("No user with id $id was found"))
            }
        }
    }
}
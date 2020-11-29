package com.gitpub.rosatomtasktracker.service.repository.tasks

import com.gitpub.rosatom.apis.DefaultApi
import com.gitpub.rosatomtasktracker.model.domain.Task
import com.gitpub.rosatomtasktracker.model.util.Result
import com.gitpub.rosatomtasktracker.model.util.map
import com.gitpub.rosatomtasktracker.model.util.mapToResult
import com.gitpub.rosatomtasktracker.service.api.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ServerTaskRepositoryImpl(private val api: DefaultApi) : TaskRepository {

    override suspend fun getTaskById(id: Long): Result<Task> {
        return withContext(Dispatchers.IO) {
            api.getUsingGET(id).mapToResult().map { it?.toDomain()!! }
        }
    }

    override suspend fun getTasks(): Result<List<Task>> {
        return withContext(Dispatchers.IO) {
            api.listUsingGET6().mapToResult().map { it?.toDomain()!! }
        }
    }
}
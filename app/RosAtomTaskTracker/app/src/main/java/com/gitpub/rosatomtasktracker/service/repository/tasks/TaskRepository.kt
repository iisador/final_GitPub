package com.gitpub.rosatomtasktracker.service.repository.tasks

import com.gitpub.rosatomtasktracker.model.domain.Task
import com.gitpub.rosatomtasktracker.model.util.Result

interface TaskRepository {

    suspend fun getTaskById(id: Long): Result<Task>

    suspend fun getTasks(): Result<List<Task>>
}

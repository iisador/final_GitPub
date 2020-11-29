package com.gitpub.rosatomtasktracker.service.tasks

import com.gitpub.rosatomtasktracker.model.domain.Task
import com.gitpub.rosatomtasktracker.model.domain.TaskListType
import com.gitpub.rosatomtasktracker.model.domain.isFor
import com.gitpub.rosatomtasktracker.model.util.Result
import com.gitpub.rosatomtasktracker.model.util.map
import com.gitpub.rosatomtasktracker.service.repository.tasks.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ServerTaskServiceImpl(private val taskRepository: TaskRepository) : TaskService {

    override suspend fun getMyTasks(taskListType: TaskListType): Result<List<Task>> {
        return withContext(Dispatchers.IO) {
            taskRepository.getTasks().map { list -> list.filter { taskListType.isFor(it.group) } }
        }
    }
}
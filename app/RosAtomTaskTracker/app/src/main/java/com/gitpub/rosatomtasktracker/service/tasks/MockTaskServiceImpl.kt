package com.gitpub.rosatomtasktracker.service.tasks

import com.gitpub.rosatomtasktracker.model.domain.Task
import com.gitpub.rosatomtasktracker.model.domain.TaskListType
import com.gitpub.rosatomtasktracker.model.util.Result
import com.gitpub.rosatomtasktracker.service.repository.tasks.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MockTaskServiceImpl(private val taskRepository: TaskRepository) : TaskService {

    override suspend fun getMyTasks(taskListType: TaskListType): Result<List<Task>> {
        return withContext(Dispatchers.IO) {
            val regularTask = taskRepository.getTaskById(1) as Result.Success
            val irregularTask = taskRepository.getTaskById(2) as Result.Success
            when (taskListType) {
                TaskListType.Regular -> Result.Success(listOf(regularTask.data))
                TaskListType.Irregular -> Result.Success(listOf(irregularTask.data))
            }
        }
    }
}
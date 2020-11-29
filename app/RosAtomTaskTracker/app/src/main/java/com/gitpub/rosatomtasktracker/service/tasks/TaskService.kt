package com.gitpub.rosatomtasktracker.service.tasks

import com.gitpub.rosatomtasktracker.model.domain.Task
import com.gitpub.rosatomtasktracker.model.domain.TaskListType
import com.gitpub.rosatomtasktracker.model.util.Result

interface TaskService {

    suspend fun getMyTasks(taskListType: TaskListType): Result<List<Task>>
}
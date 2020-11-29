package com.gitpub.rosatomtasktracker.ui.main.tasklist

import androidx.lifecycle.*
import com.gitpub.rosatomtasktracker.model.domain.Task
import com.gitpub.rosatomtasktracker.model.domain.TaskListType
import com.gitpub.rosatomtasktracker.model.util.Result
import com.gitpub.rosatomtasktracker.service.tasks.TaskService

open class TaskListViewModel(
    private val taskService: TaskService,
    private val taskListType: TaskListType
) : ViewModel() {

    private val mRefreshData = MutableLiveData<Unit>()
    val taskList: LiveData<Result<List<Task>>> = mRefreshData.switchMap {
        liveData {
            val data = taskService.getMyTasks(taskListType)
            emit(data)
        }
    }

    fun refresh() {
        mRefreshData.postValue(Unit)
    }
}

class RegularTaskListViewModel(
    taskService: TaskService
) : TaskListViewModel(taskService, TaskListType.Regular)

class IrregularTaskListViewModel(
    taskService: TaskService,
) : TaskListViewModel(taskService, TaskListType.Irregular)

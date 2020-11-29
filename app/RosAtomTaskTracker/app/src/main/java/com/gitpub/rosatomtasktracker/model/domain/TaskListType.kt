package com.gitpub.rosatomtasktracker.model.domain

sealed class TaskListType {
    object Regular : TaskListType()
    object Irregular : TaskListType()
}

fun TaskListType.isFor(group: TaskGroup) = when (this) {
    TaskListType.Regular -> group.id == 0L
    TaskListType.Irregular -> group.id == 1L
}

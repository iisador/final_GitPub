package com.gitpub.rosatomtasktracker.model.items

import com.gitpub.rosatomtasktracker.model.domain.Priorities
import com.gitpub.rosatomtasktracker.model.domain.Task
import com.gitpub.rosatomtasktracker.model.domain.TaskStatus
import com.gitpub.rosatomtasktracker.model.domain.TaskType
import org.joda.time.DateTime

data class TaskOfListItem(
    val id: Long,
    val title: String,
    val status: TaskStatus,
    val type: TaskType,
    val isUrgent: Boolean,
    val dateTimeCreated: DateTime,
    val onClick: (TaskOfListItem) -> Unit
) : ListItem {
    companion object {
        fun fromTask(task: Task, onClick: (TaskOfListItem) -> Unit) = TaskOfListItem(
            id = task.id,
            title = task.header,
            status = task.status,
            type = task.type,
            isUrgent = task.priority == Priorities.TopPriority,
            dateTimeCreated = task.createdAt,
            onClick = onClick
        )
    }
}
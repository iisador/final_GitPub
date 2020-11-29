package com.gitpub.rosatomtasktracker.model.domain

import org.joda.time.DateTime

data class Task(
    val id: Long,
    val type: TaskType,
    val assignee: User,
    val dateTo: DateTime,
    val dateFact: DateTime?,
    val createdAt: DateTime,
    val author: User,
    val header: String,
    val info: String,
    val status: TaskStatus,
    val priority: Priority,
    val group: TaskGroup,
    val attachments: List<Attachment>?,
    val comments: List<Comment>?
)
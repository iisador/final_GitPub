package com.gitpub.rosatomtasktracker.model.domain

import org.joda.time.DateTime

data class Comment(
    val id: Long,
    val author: User,
    val content: String,
    val createdAt: DateTime,
    val attachments: List<Attachment>? = null,
    val isClosing: Boolean
)

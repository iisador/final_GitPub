package com.gitpub.rosatomtasktracker.model.items

import com.gitpub.rosatomtasktracker.model.domain.Attachment
import com.gitpub.rosatomtasktracker.model.domain.Comment
import org.joda.time.DateTime

data class TaskCommentItem(
    val id: Long,
    val authorName: String,
    val createdAt: DateTime,
    val commentBody: String,
    val attachments: List<Attachment>?,
    val isClosing: Boolean,
    val onAnswer: (TaskCommentItem) -> Unit
) : ListItem {
    companion object {
        fun fromDomain(comment: Comment, onAnswer: (TaskCommentItem) -> Unit) = TaskCommentItem(
            id = comment.id,
            authorName = comment.author.name,
            createdAt = comment.createdAt,
            commentBody = comment.content,
            attachments = comment.attachments,
            isClosing = comment.isClosing,
            onAnswer = onAnswer
        )
    }
}
package com.gitpub.rosatomtasktracker.model.domain

data class Attachment(
    val id: Long,
    val author: User,
    val name: String,
    val url: String
)

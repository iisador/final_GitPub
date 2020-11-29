package com.gitpub.rosatomtasktracker.model.domain

data class User(
    val id: Long,
    val name: String,
    val position: Position,
    val type: Long
)

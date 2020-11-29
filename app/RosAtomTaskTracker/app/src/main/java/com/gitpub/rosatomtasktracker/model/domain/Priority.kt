package com.gitpub.rosatomtasktracker.model.domain

data class Priority(
    val id: Int,
    val name: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Priority

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id
    }
}

package com.gitpub.rosatomtasktracker.model.domain

object TaskStatuses {
    val New = TaskStatus(0, "Ожидание")
    val Active = TaskStatus(1, "В работе")
    val Review = TaskStatus(2, "На проверке")
    val Closed = TaskStatus(3, "Завершена")
    val Cancelled = TaskStatus(3, "Отменена")
}

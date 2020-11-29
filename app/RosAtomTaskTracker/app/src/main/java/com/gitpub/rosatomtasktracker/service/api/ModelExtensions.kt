package com.gitpub.rosatomtasktracker.service.api

import com.gitpub.rosatom.models.*
import com.gitpub.rosatomtasktracker.model.domain.*


fun TaskModel.toDomain(): Task? {
    return Task(
        id = id ?: return null,
        type = type?.toDomain() ?: return null,
        assignee = assignee?.toDomain() ?: return null,
        dateTo = dateTo ?: return null,
        dateFact = dateFact,
        createdAt = tstmpCreate ?: return null,
        author = author?.toDomain() ?: return null,
        header = header ?: return null,
        info = info ?: return null,
        status = status?.toDomain() ?: return null,
        priority = priority?.toDomain() ?: return null,
        group = group?.toDomain() ?: return null,
        attachments = attachments?.mapNotNull { it.toDomain() },
        comments = comments?.mapNotNull { it.toDomain() }
    )
}

fun CommentModel.toDomain(): Comment? {
    return Comment(
        id = id ?: return null,
        author = author?.toDomain() ?: return null,
        content = content ?: "",
        createdAt = tstmpCreate ?: return null,
        attachments = attachments?.mapNotNull { it.toDomain() },
        isClosing = isClosing ?: return null
    )
}

fun AttachmentModel.toDomain(): Attachment? {
    return Attachment(
        id = id ?: return null,
        author = author?.toDomain() ?: return null,
        name = name ?: "Приложение",
        url = url ?: return null
    )
}

fun UserModel.toDomain(): User? {
    return User(
        id = id ?: return null,
        name = name ?: return null,
        position = position?.toDomain() ?: return null,
        type = type ?: return null
    )
}

fun PositionModel.toDomain(): Position? {
    return Position(
        id = id ?: return null,
        code = code ?: return null
    )
}

fun PriorityModel.toDomain(): Priority? {
    return Priority(
        id = id?.toInt() ?: return null,
        name = code ?: return null
    )
}


fun StatusTypeModel.toDomain(): TaskStatus? {
    return TaskStatus(
        id = id ?: return null,
        code = code ?: return null
    )
}

fun TaskTypeModel.toDomain(): TaskType? {
    return TaskType(
        id = id ?: return null,
        code = code ?: return null
    )
}

fun PageTaskModel.toDomain(): List<Task>? {
    return content?.mapNotNull { it.toDomain() }
}

fun GroupModel.toDomain(): TaskGroup? {
    return TaskGroup(
        id = id ?: return null,
        code = code ?: return null
    )
}

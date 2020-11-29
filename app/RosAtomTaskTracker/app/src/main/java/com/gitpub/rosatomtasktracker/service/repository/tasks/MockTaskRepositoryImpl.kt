package com.gitpub.rosatomtasktracker.service.repository.tasks

import com.gitpub.rosatomtasktracker.model.domain.*
import com.gitpub.rosatomtasktracker.model.util.Result
import com.gitpub.rosatomtasktracker.model.util.map
import com.gitpub.rosatomtasktracker.service.repository.users.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.joda.time.DateTime

class MockTaskRepositoryImpl(private val userRepository: UserRepository) : TaskRepository {

    override suspend fun getTaskById(id: Long): Result<Task> =
        withContext(Dispatchers.IO) {
            val lexa = userRepository.getUserById(1) as Result.Success
            if (id == 1L)
                Result.Success(
                    Task(
                        1,
                        TaskTypes.Technological,
                        lexa.data,
                        DateTime.now(),
                        null,
                        DateTime.now(),
                        lexa.data,
                        "Помой посуду",
                        "Иди на кухню и помой посуду",
                        TaskStatuses.New,
                        Priorities.TopPriority,
                        TaskGroup(0, "Регулярные"),
                        null,
                        null
                    )
                )
            else
                Result.Success(
                    Task(
                        2,
                        TaskTypes.Technological,
                        lexa.data,
                        DateTime.now(),
                        null,
                        DateTime.now(),
                        lexa.data,
                        "Уберись на хате",
                        "Пропылессось, собери носки и так далее",
                        TaskStatuses.Active,
                        Priorities.LowPriority,
                        TaskGroup(1, "Нерегулярные"),
                        null,
                        null
                    )
                )
        }

    override suspend fun getTasks(): Result<List<Task>> =
        getTaskById(1).map { listOf(it) }

}
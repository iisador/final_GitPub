package com.gitpub.rosatomtasktracker.di.modules

import com.gitpub.rosatomtasktracker.service.repository.tasks.ServerTaskRepositoryImpl
import com.gitpub.rosatomtasktracker.service.repository.tasks.TaskRepository
import com.gitpub.rosatomtasktracker.service.repository.users.MockUserRepositoryImpl
import com.gitpub.rosatomtasktracker.service.repository.users.UserRepository
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val repositoryModule = DI.Module("repository") {

    bind<UserRepository>() with singleton { MockUserRepositoryImpl() }
    bind<TaskRepository>() with singleton { ServerTaskRepositoryImpl(instance()) }
}
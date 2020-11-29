package com.gitpub.rosatomtasktracker.di.modules

import com.gitpub.rosatomtasktracker.service.tasks.ServerTaskServiceImpl
import com.gitpub.rosatomtasktracker.service.tasks.TaskService
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val serviceModule = DI.Module("service") {
    bind<TaskService>() with singleton { ServerTaskServiceImpl(instance()) }
}
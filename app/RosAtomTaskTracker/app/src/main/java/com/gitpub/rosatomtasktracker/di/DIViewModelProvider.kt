package com.gitpub.rosatomtasktracker.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.DI
import org.kodein.di.instance

class DIViewModelProvider(private val injector: DI) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return when (modelClass) {
//            RegularTaskListViewModel::class.java -> {
//                val taskService: TaskService by injector.instance()
//                RegularTaskListViewModel(
//                    taskService
//                ) as T
//            }
//            IrregularTaskListViewModel::class.java -> {
//                val taskService: TaskService by injector.instance()
//                IrregularTaskListViewModel(
//                    taskService
//                ) as T
//            }
//            else -> {
        val vm by injector.instance<ViewModel>(tag = modelClass.simpleName)
        @Suppress("UNCHECKED_CAST")
        return vm as T
//            }
//        }
    }
}

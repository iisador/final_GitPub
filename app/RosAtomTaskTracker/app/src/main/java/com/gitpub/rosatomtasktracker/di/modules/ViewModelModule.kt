package com.gitpub.rosatomtasktracker.di.modules

import androidx.lifecycle.ViewModelProvider
import com.gitpub.rosatomtasktracker.di.DIViewModelProvider
import com.gitpub.rosatomtasktracker.di.bindViewModel
import com.gitpub.rosatomtasktracker.ui.main.submittask.SubmitTaskViewModel
import com.gitpub.rosatomtasktracker.ui.main.tasklist.IrregularTaskListViewModel
import com.gitpub.rosatomtasktracker.ui.main.tasklist.RegularTaskListViewModel
import com.gitpub.rosatomtasktracker.ui.main.taskpage.TaskPageViewModel
import org.kodein.di.*

val viewModelModule = DI.Module("viewModel") {
    bindViewModel<RegularTaskListViewModel>() with provider {
        RegularTaskListViewModel(instance())
    }
    bindViewModel<IrregularTaskListViewModel>() with provider {
        IrregularTaskListViewModel(instance())
    }
    bindViewModel<SubmitTaskViewModel>() with singleton {
        SubmitTaskViewModel(instance())
    }
    bindViewModel<TaskPageViewModel>() with singleton {
        TaskPageViewModel(instance(), instance())
    }
    bind<ViewModelProvider.Factory>() with singleton { DIViewModelProvider(di) }

}
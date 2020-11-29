package com.gitpub.rosatomtasktracker

import android.app.Application
import com.gitpub.rosatomtasktracker.di.modules.apiModule
import com.gitpub.rosatomtasktracker.di.modules.repositoryModule
import com.gitpub.rosatomtasktracker.di.modules.serviceModule
import com.gitpub.rosatomtasktracker.di.modules.viewModelModule
import org.kodein.di.DI
import org.kodein.di.DIAware

class App : Application(), DIAware {

    override val di by DI.lazy {
        import(apiModule)
        import(repositoryModule)
        import(serviceModule)
        import(viewModelModule)
    }
}

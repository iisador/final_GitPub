package com.gitpub.rosatomtasktracker.di.modules

import com.gitpub.rosatom.apis.DefaultApi
import com.gitpub.rosatom.infrastructure.ApiClient
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

val apiModule = DI.Module("client") {

    val apiClient = ApiClient()
    val api = apiClient.createService(DefaultApi::class.java)

    bind<DefaultApi>() with singleton { api }
}
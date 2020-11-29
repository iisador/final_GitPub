package com.gitpub.rosatom.infrastructure

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.joda.time.DateTime
import java.util.*

object Serializer {
    @JvmStatic
    val gsonBuilder: GsonBuilder = GsonBuilder()
        .registerTypeAdapter(Date::class.java, DateAdapter())
        .registerTypeAdapter(DateTime::class.java, DateTimeAdapter())
        .registerTypeAdapter(ByteArray::class.java, ByteArrayAdapter())

    @JvmStatic
    val gson: Gson by lazy {
        gsonBuilder.create()
    }
}

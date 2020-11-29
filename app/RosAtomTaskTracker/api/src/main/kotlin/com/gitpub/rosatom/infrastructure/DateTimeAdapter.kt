package com.gitpub.rosatom.infrastructure

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken.NULL
import com.google.gson.stream.JsonWriter
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import java.io.IOException

class DateTimeAdapter : TypeAdapter<DateTime>() {
    @Throws(IOException::class)
    override fun write(out: JsonWriter?, value: DateTime?) {
        if (value == null) {
            out?.nullValue()
        } else {
            out?.value(value.toString(DateTimeFormat.forPattern("dd.MM.yyyy HH:mm")))
        }
    }

    @Throws(IOException::class)
    override fun read(out: JsonReader?): DateTime? {
        out ?: return null
        return when (out.peek()) {
            NULL -> {
                out.nextNull()
                null
            }
            else -> {
                DateTime.parse(out.nextString(), DateTimeFormat.forPattern("dd.MM.yyyy HH:mm"))
            }
        }
    }
}

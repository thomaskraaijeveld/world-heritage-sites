package com.example.worldheritagesites.utils

import android.content.Context
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import okio.buffer
import okio.source

object JsonFileUtils {
    inline fun <reified T> parseJsonFile(
        fileName: String,
        context: Context,
        moshi: Moshi
    ): List<T> {
        context.assets.open(fileName).use { inputStream ->
            val bufferedSource = inputStream.source().buffer()
            val jsonAdapter = moshi.adapter(T::class.java)
            val results = mutableListOf<T>()
            JsonReader.of(bufferedSource).use { jsonReader ->
                jsonReader.beginArray()
                while (jsonReader.hasNext()) {
                    jsonAdapter.fromJson(jsonReader)?.let { results.add(it) }
                }
                jsonReader.endArray()
            }
            return results
        }
    }
}
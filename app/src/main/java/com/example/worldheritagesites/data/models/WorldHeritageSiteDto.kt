package com.example.worldheritagesites.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WorldHeritageSiteDto(
    val id: String,
    val year: Int,
    val target: String,
    val name: String,
    val type: String,
    val region: String,
    val regionLong: String,
    val coordinates: String? = null,
    val lat: Double,
    val lng: Double,
    val page: String,
    val image: String,
    val imageAuthor: String,
    val shortInfo: String,
    val longInfo: String? = null
)
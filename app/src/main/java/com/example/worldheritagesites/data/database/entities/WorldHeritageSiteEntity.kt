package com.example.worldheritagesites.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "world_heritage_sites")
data class WorldHeritageSiteEntity(
    @PrimaryKey
    val id: String,
    val year: Int,
    val target: String,
    val name: String,
    val type: String,
    val region: String,
    val regionLong: String,
    val coordinates: String?,
    val lat: Double,
    val lng: Double,
    val page: String,
    val image: String,
    val imageAuthor: String,
    val shortInfo: String,
    val longInfo: String?
)
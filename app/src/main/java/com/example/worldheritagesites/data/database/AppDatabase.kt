package com.example.worldheritagesites.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.worldheritagesites.data.database.daos.WorldHeritageSiteDao
import com.example.worldheritagesites.data.database.entities.WorldHeritageSiteEntity

@Database(entities = [WorldHeritageSiteEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun worldHeritageSiteDao(): WorldHeritageSiteDao
}
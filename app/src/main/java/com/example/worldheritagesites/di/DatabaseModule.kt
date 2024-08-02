package com.example.worldheritagesites.di

import android.content.Context
import androidx.room.Room
import com.example.worldheritagesites.data.database.AppDatabase
import com.example.worldheritagesites.data.database.daos.WorldHeritageSiteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val ROOM_DATABASE_NAME = "WorldHeritageSitesDatabase"

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideAppDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, ROOM_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideWorldHeritageSiteDao(appDatabase: AppDatabase): WorldHeritageSiteDao = appDatabase.worldHeritageSiteDao()
}
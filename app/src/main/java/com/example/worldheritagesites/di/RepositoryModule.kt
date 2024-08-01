package com.example.worldheritagesites.di

import com.example.worldheritagesites.data.repositories.WorldHeritageSiteRepositoryImpl
import com.example.worldheritagesites.domain.repositories.WorldHeritageSiteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideWorldHeritageSiteRepository(): WorldHeritageSiteRepository = WorldHeritageSiteRepositoryImpl()
}
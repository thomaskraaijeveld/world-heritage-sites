package com.example.worldheritagesites.di

import android.content.Context
import com.example.worldheritagesites.data.repositories.WorldHeritageSiteRepositoryImpl
import com.example.worldheritagesites.domain.repositories.WorldHeritageSiteRepository
import com.squareup.moshi.Moshi
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
    fun provideWorldHeritageSiteRepository(context: Context, moshi: Moshi): WorldHeritageSiteRepository =
        WorldHeritageSiteRepositoryImpl(context, moshi)
}
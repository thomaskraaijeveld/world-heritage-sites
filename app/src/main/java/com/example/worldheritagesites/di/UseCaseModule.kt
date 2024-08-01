package com.example.worldheritagesites.di

import com.example.worldheritagesites.domain.repositories.WorldHeritageSiteRepository
import com.example.worldheritagesites.domain.usecases.GetWorldHeritageSitesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetWorldHeritageSitesUseCase(worldHeritageSiteRepository: WorldHeritageSiteRepository): GetWorldHeritageSitesUseCase =
        GetWorldHeritageSitesUseCase(worldHeritageSiteRepository)
}
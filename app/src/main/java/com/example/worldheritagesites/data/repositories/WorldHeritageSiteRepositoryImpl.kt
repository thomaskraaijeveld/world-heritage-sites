package com.example.worldheritagesites.data.repositories

import com.example.worldheritagesites.domain.models.WorldHeritageSite
import com.example.worldheritagesites.domain.repositories.WorldHeritageSiteRepository

class WorldHeritageSiteRepositoryImpl : WorldHeritageSiteRepository {
    override suspend fun getWorldHeritageSites(): List<WorldHeritageSite> {
        TODO("Not yet implemented")
    }
}
package com.example.worldheritagesites.domain.repositories

import com.example.worldheritagesites.domain.models.WorldHeritageSite

interface WorldHeritageSiteRepository {
    suspend fun getWorldHeritageSites(searchQuery: String): List<WorldHeritageSite>
}
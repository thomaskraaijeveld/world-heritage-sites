package com.example.worldheritagesites.domain.usecases

import com.example.worldheritagesites.domain.models.WorldHeritageSite
import com.example.worldheritagesites.domain.repositories.WorldHeritageSiteRepository
import javax.inject.Inject

class GetWorldHeritageSitesUseCase @Inject constructor(private val worldHeritageSiteRepository: WorldHeritageSiteRepository) {
    suspend operator fun invoke(searchQuery: String): List<WorldHeritageSite> =
        worldHeritageSiteRepository.getWorldHeritageSites(searchQuery)
}
package com.example.worldheritagesites.data.repositories

import android.content.Context
import com.example.worldheritagesites.data.database.daos.WorldHeritageSiteDao
import com.example.worldheritagesites.data.mappers.WorldHeritageSiteMapper.toDomain
import com.example.worldheritagesites.data.mappers.WorldHeritageSiteMapper.toEntity
import com.example.worldheritagesites.data.models.WorldHeritageSiteDto
import com.example.worldheritagesites.domain.models.WorldHeritageSite
import com.example.worldheritagesites.domain.repositories.WorldHeritageSiteRepository
import com.example.worldheritagesites.utils.JsonFileUtils.parseJsonFile
import com.squareup.moshi.Moshi
import timber.log.Timber
import javax.inject.Inject

private const val WORLD_HERITAGE_SITES_FILE_NAME = "real.planet.world-heritage.json"

class WorldHeritageSiteRepositoryImpl @Inject constructor(
    private val context: Context,
    private val moshi: Moshi,
    private val dao: WorldHeritageSiteDao
) : WorldHeritageSiteRepository {
    override suspend fun getWorldHeritageSites(searchQuery: String): List<WorldHeritageSite> {
        return try {
            if (dao.getCount() == 0) {
                populateDatabaseFromJsonFile()
            }
            if (searchQuery.isBlank()) {
                dao.getAll().map { it.toDomain() }
            } else {
                dao.searchByName(searchQuery).map { it.toDomain() }
            }
        } catch (exception: Exception) {
            Timber.e(exception, "Error fetching world heritage sites")
            throw exception
        }
    }

    private suspend fun populateDatabaseFromJsonFile() {
        try {
            val worldHeritageSiteEntities = parseJsonFile<WorldHeritageSiteDto>(
                fileName = WORLD_HERITAGE_SITES_FILE_NAME,
                context = context,
                moshi = moshi
            ).map { it.toEntity() }
            dao.insertAll(worldHeritageSiteEntities)
        } catch (exception: Exception) {
            Timber.e(exception, "Error populating database from JSON file")
            throw exception
        }
    }
}
package com.example.worldheritagesites.data.repositories

import android.content.Context
import com.example.worldheritagesites.data.mappers.WorldHeritageSiteMapper.toDomainModel
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
    private val moshi: Moshi
) : WorldHeritageSiteRepository {
    override suspend fun getWorldHeritageSites(): List<WorldHeritageSite> =
        try {
            parseJsonFile<WorldHeritageSiteDto>(
                fileName = WORLD_HERITAGE_SITES_FILE_NAME,
                context = context,
                moshi = moshi
            ).map { it.toDomainModel() }
        } catch (exception: Exception) {
            Timber.e(exception)
            throw exception
        }
}
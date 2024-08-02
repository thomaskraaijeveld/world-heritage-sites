package com.example.worldheritagesites.data.mappers

import com.example.worldheritagesites.data.database.entities.WorldHeritageSiteEntity
import com.example.worldheritagesites.data.models.WorldHeritageSiteDto
import com.example.worldheritagesites.domain.models.WorldHeritageSite

object WorldHeritageSiteMapper {
    fun WorldHeritageSiteDto.toEntity() = WorldHeritageSiteEntity(
        id = id,
        year = year,
        target = target,
        name = name,
        type = type,
        region = region,
        regionLong = regionLong,
        coordinates = coordinates,
        lat = lat,
        lng = lng,
        page = page,
        image = image,
        imageAuthor = imageAuthor,
        shortInfo = shortInfo,
        longInfo = longInfo
    )

    fun WorldHeritageSiteEntity.toDomain() = WorldHeritageSite(
        id = id,
        year = year,
        target = target,
        name = name,
        type = type,
        region = region,
        regionLong = regionLong,
        coordinates = coordinates,
        lat = lat,
        lng = lng,
        page = page,
        image = image,
        imageAuthor = imageAuthor,
        shortInfo = shortInfo,
        longInfo = longInfo
    )
}
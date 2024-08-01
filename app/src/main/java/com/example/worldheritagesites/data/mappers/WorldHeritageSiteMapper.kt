package com.example.worldheritagesites.data.mappers

import com.example.worldheritagesites.data.models.WorldHeritageSiteDto
import com.example.worldheritagesites.domain.models.WorldHeritageSite

object WorldHeritageSiteMapper {
    fun WorldHeritageSiteDto.toDomainModel() = WorldHeritageSite(
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
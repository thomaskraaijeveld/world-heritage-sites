package com.example.worldheritagesites.data.repositories

import android.content.Context
import com.example.worldheritagesites.data.database.daos.WorldHeritageSiteDao
import com.example.worldheritagesites.data.database.entities.WorldHeritageSiteEntity
import com.squareup.moshi.Moshi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class WorldHeritageSiteRepositoryImplTest {
    @Mock
    private lateinit var context: Context

    @Mock
    private lateinit var moshi: Moshi

    @Mock
    private lateinit var dao: WorldHeritageSiteDao

    private lateinit var repository: WorldHeritageSiteRepositoryImpl

    private val worldHeritageSiteEntities = listOf(
        WorldHeritageSiteEntity(
            id = "1",
            year = 1978,
            target = "ECU",
            name = "Galápagos Islands",
            type = "Natural",
            region = "LAC",
            regionLong = "Latin America and the Caribbean",
            coordinates = "N0 49 0.012 W91 0 0",
            lat = 0.81667,
            lng = -91.0,
            page = "http://whc.unesco.org/en/list/1",
            image = "http://whc.unesco.org//uploads/thumbs/site_0001_0002-750-0-20100729045519.jpg",
            imageAuthor = "Galápagos Islands © UNESCO",
            shortInfo = "Short info",
            longInfo = "Long info"
        ),
        WorldHeritageSiteEntity(
            id = "2",
            year = 1978,
            target = "ECU",
            name = "City of Quito",
            type = "Cultural",
            region = "LAC",
            regionLong = "Latin America and the Caribbean",
            coordinates = "N0 0 14 W78 30 0",
            lat = 0.0038888888888888888,
            lng = -78.5,
            page = "http://whc.unesco.org/en/list/2",
            image = "http://whc.unesco.org//uploads/thumbs/site_0002_0001-750-0-20061215143310.jpg",
            imageAuthor = "© UNESCO",
            shortInfo = "Short info",
            longInfo = "Long info"
        )
    )

    @Before
    fun setup() {
        repository = WorldHeritageSiteRepositoryImpl(context, moshi, dao)
    }

    @Test
    fun `getWorldHeritageSites returns all world heritage sites when searchQuery is blank`() = runTest {
        // Given
        `when`(dao.getCount()).thenReturn(2)
        `when`(dao.getAll()).thenReturn(worldHeritageSiteEntities)

        // When
        val result = repository.getWorldHeritageSites("")

        // Then
        verify(dao, times(1)).getAll()
        assertEquals(2, result.size)
        assertEquals(worldHeritageSiteEntities[0].name, result[0].name)
        assertEquals(worldHeritageSiteEntities[1].name, result[1].name)
    }

    @Test
    fun `getWorldHeritageSites returns filtered world heritage sites when searchQuery is provided`() = runTest {
        val searchQuery = "Quito"

        // Given
        `when`(dao.getCount()).thenReturn(2)
        `when`(dao.searchByName(searchQuery)).thenReturn(listOf(worldHeritageSiteEntities[1]))

        // When
        val result = repository.getWorldHeritageSites(searchQuery)

        // Then
        verify(dao, times(1)).searchByName(searchQuery)
        assertEquals(1, result.size)
        assertEquals(worldHeritageSiteEntities[1].name, result[0].name)
    }
}
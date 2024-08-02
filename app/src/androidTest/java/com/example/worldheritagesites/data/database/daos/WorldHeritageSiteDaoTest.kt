package com.example.worldheritagesites.data.database.daos

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.worldheritagesites.data.database.AppDatabase
import com.example.worldheritagesites.data.database.entities.WorldHeritageSiteEntity
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WorldHeritageSiteDaoTest {
    private lateinit var database: AppDatabase
    private lateinit var dao: WorldHeritageSiteDao

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
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).build()
        dao = database.worldHeritageSiteDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertAll_insertsWorldHeritageSitesCorrectly() = runTest {
        //Given

        // When
        dao.insertAll(worldHeritageSiteEntities)

        // Then
        val retrievedWorldHeritageSiteEntities = dao.getAll()
        assertEquals(worldHeritageSiteEntities.size, retrievedWorldHeritageSiteEntities.size)
        assertEquals(worldHeritageSiteEntities[0], retrievedWorldHeritageSiteEntities[0])
        assertEquals(worldHeritageSiteEntities[1], retrievedWorldHeritageSiteEntities[1])
    }

    @Test
    fun getAll_returnsAllWorldHeritageSites() = runTest {
        // Given
        dao.insertAll(worldHeritageSiteEntities)

        // When
        val retrievedWorldHeritageSiteEntities = dao.getAll()

        // Then
        assertEquals(worldHeritageSiteEntities.size, retrievedWorldHeritageSiteEntities.size)
        assertEquals(worldHeritageSiteEntities[0], retrievedWorldHeritageSiteEntities[0])
        assertEquals(worldHeritageSiteEntities[1], retrievedWorldHeritageSiteEntities[1])
    }

    @Test
    fun searchByName_returnsMatchingWorldHeritageSites() = runTest {
        // Given
        val searchQuery = "Quito"
        dao.insertAll(worldHeritageSiteEntities)

        // When
        val searchResults = dao.searchByName(searchQuery)

        // Then
        assertEquals(1, searchResults.size)
        assertEquals(worldHeritageSiteEntities[1], searchResults[0])
    }

    @Test
    fun getCount_returnsCorrectCount() = runTest {
        // Given
        dao.insertAll(worldHeritageSiteEntities)

        // When
        val count = dao.getCount()

        // Then
        assertEquals(worldHeritageSiteEntities.size, count)
    }
}
package com.example.worldheritagesites.data.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.worldheritagesites.data.database.entities.WorldHeritageSiteEntity

@Dao
interface WorldHeritageSiteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(worldHeritageSiteEntities: List<WorldHeritageSiteEntity>)

    @Query("SELECT * FROM world_heritage_sites")
    suspend fun getAll(): List<WorldHeritageSiteEntity>

    @Query("SELECT * FROM world_heritage_sites WHERE name LIKE '%' || :searchQuery || '%'")
    suspend fun searchByName(searchQuery: String): List<WorldHeritageSiteEntity>

    @Query("SELECT COUNT(*) FROM world_heritage_sites")
    suspend fun getCount(): Int
}
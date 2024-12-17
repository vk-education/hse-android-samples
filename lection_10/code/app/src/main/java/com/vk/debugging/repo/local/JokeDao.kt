package com.vk.debugging.repo.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.vk.debugging.repo.JokeEntity

@Dao
interface JokeDao {
    @Query("SELECT * FROM joke")
    suspend fun getAll(): List<JokeEntity>

    @Update
    suspend fun insert(joke: JokeEntity)
}
package com.example.githubapplication

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(GitHubRepo::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun githubDao(): GithubStorage
}
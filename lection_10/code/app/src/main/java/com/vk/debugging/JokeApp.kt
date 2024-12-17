package com.vk.debugging

import android.app.Application
import com.vk.debugging.repo.JokeRepository
import com.vk.debugging.repo.local.LocalSource
import com.vk.debugging.repo.remote.RemoteSource
import com.vk.debugging.repo.local.JokeDatabase

class JokeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Di.jokeRepository = JokeRepository(
            remoteSource = RemoteSource(),
            localSource = LocalSource(JokeDatabase.getDatabase(context = this)),
        )
    }
}
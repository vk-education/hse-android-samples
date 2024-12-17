package com.vk.debugging.repo

import com.vk.debugging.repo.local.LocalSource
import com.vk.debugging.repo.remote.RemoteSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class JokeRepository(
    private val remoteSource: RemoteSource,
    private val localSource: LocalSource,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) {
    suspend fun loadJoke(): JokeEntity {
        return withContext(dispatcher) {
            val jokeDto = when (val result = remoteSource.requestJoke()) {
                is RemoteSource.RequestResult.Error -> null
                is RemoteSource.RequestResult.Ok -> result.joke
            }
            jokeDto?.let {
                localSource.saveJoke(it.mapToEntity())
            }
            localSource.loadJokes().last()
        }
    }
}
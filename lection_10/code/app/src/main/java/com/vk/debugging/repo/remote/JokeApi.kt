package com.vk.debugging.repo.remote

import com.vk.debugging.repo.JokeDto
import retrofit2.Response
import retrofit2.http.GET

interface JokeApi {
    @GET("jokes/random")
    suspend fun joke(): Response<JokeDto>
}
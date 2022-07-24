package com.example.pokecompose.data.remote

import com.example.pokecompose.data.remote.dto.PokeSimpleListDto
import retrofit2.http.GET

interface PokeApi {

    @GET("pokemon?offset=20&limit=20")
    suspend fun getAllPokes() : PokeSimpleListDto
}
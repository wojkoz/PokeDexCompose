package com.example.pokecompose.domain.repository

import com.example.pokecompose.domain.model.PokeSimpleItem
import com.example.pokecompose.util.Resource
import kotlinx.coroutines.flow.Flow

interface PokeRepository {
    suspend fun getPokeSimpleList(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<PokeSimpleItem>>>
}
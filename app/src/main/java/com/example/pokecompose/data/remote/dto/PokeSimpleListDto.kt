package com.example.pokecompose.data.remote.dto

data class PokeSimpleListDto(
    val count: Long,
    val next: String?,
    val previous: String?,
    val results: List<PokeSimpleItemDto>
)
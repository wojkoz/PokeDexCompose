package com.example.pokecompose.presentation.poke_listings

import com.example.pokecompose.domain.model.PokeSimpleItem

data class PokeListingsState(
    val pokes: List<PokeSimpleItem> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val searchQuery: String = ""
)

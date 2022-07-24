package com.example.pokecompose.presentation.poke_listings

sealed class PokeListingsEvent {
    object Refresh : PokeListingsEvent()
    data class OnSearchQueryChanged(val query: String) : PokeListingsEvent()
}

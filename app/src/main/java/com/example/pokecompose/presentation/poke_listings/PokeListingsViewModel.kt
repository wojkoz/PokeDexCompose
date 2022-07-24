package com.example.pokecompose.presentation.poke_listings

import androidx.lifecycle.ViewModel
import com.example.pokecompose.domain.repository.PokeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokeListingsViewModel @Inject constructor(
    private val repository: PokeRepository,
): ViewModel(){
}
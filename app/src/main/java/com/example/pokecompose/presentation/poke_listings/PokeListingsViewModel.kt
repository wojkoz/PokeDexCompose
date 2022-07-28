package com.example.pokecompose.presentation.poke_listings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokecompose.domain.repository.PokeRepository
import com.example.pokecompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokeListingsViewModel @Inject constructor(
    private val repository: PokeRepository,
) : ViewModel() {

    var state by mutableStateOf(PokeListingsState())
    private set

    private var searchJob: Job? = null

    init {
        getPokeListings()
    }

    fun onEvent(event: PokeListingsEvent) {
        when (event) {
            is PokeListingsEvent.OnSearchQueryChanged -> {
                state = state.copy(searchQuery = event.query)
                searchJob?.cancel()
                searchJob = viewModelScope.launch {
                    delay(500L)
                    getPokeListings()
                }
            }
            PokeListingsEvent.Refresh -> {
                getPokeListings(fetchFromRemote = true)
            }
        }
    }

    private fun getPokeListings(
        query: String = state.searchQuery.lowercase(),
        fetchFromRemote: Boolean = false
    ) {
        viewModelScope.launch {
            repository
                .getPokeSimpleList(fetchFromRemote, query)
                .collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            result.data?.let {
                                state = state.copy(pokes = it)
                            }
                        }
                        is Resource.Error -> Unit
                        is Resource.Loading -> {
                            state = state.copy(isLoading = result.isLoading)
                        }
                    }
                }
        }
    }
}
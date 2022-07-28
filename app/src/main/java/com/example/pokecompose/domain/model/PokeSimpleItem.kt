package com.example.pokecompose.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokeSimpleItem(
    val name: String,
    val url: String,
) : Parcelable

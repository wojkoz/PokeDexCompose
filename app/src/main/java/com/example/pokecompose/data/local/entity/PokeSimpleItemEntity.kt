package com.example.pokecompose.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokeSimpleItemEntity(
    @PrimaryKey val id: Int? = null,
    val name: String,
    val url: String,
)

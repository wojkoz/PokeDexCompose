package com.example.pokecompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pokecompose.data.local.dao.PokeDao
import com.example.pokecompose.data.local.entity.PokeSimpleItemEntity

@Database(
    entities = [PokeSimpleItemEntity::class],
    version = 1
)
abstract class PokeDatabase: RoomDatabase() {
    abstract val pokeDao: PokeDao
}
package com.example.pokecompose.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokecompose.data.local.entity.PokeSimpleItemEntity

@Dao
interface PokeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokeSimpleList(
        pokeSimpleItemEntity: List<PokeSimpleItemEntity>
    )

    @Query("""
        SELECT *
        FROM pokesimpleitementity
        WHERE LOWER(name) LIKE '%' || LOWER(:query) || '%'
    """)
    suspend fun searchPokeSimpleList(query: String) : List<PokeSimpleItemEntity>
}
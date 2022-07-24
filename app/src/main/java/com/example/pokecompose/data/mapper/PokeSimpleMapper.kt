package com.example.pokecompose.data.mapper

import com.example.pokecompose.data.local.entity.PokeSimpleItemEntity
import com.example.pokecompose.data.remote.dto.PokeSimpleItemDto
import com.example.pokecompose.domain.model.PokeSimpleItem

fun PokeSimpleItemEntity.toPokeSimpleItem(): PokeSimpleItem {
    return PokeSimpleItem(
        name = name,
        url = url,
    )
}

fun PokeSimpleItem.toPokeSimpleItemEntity(): PokeSimpleItemEntity {
    return PokeSimpleItemEntity(
        name = name,
        url = url,
    )
}

fun PokeSimpleItemDto.toPokeSimpleItemEntity(): PokeSimpleItemEntity{
    return PokeSimpleItemEntity(
        name = name,
        url = url,
    )
}
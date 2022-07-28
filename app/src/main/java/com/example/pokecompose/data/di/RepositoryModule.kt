package com.example.pokecompose.data.di

import com.example.pokecompose.data.repository.PokeRepositoryImpl
import com.example.pokecompose.domain.repository.PokeRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun providesPokeRepository(
        pokeRepositoryImpl: PokeRepositoryImpl
    ): PokeRepository
}
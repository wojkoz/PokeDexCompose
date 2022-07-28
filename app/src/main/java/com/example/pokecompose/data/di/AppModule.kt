package com.example.pokecompose.data.di

import android.app.Application
import androidx.room.Room
import com.example.pokecompose.data.local.PokeDatabase
import com.example.pokecompose.data.remote.PokeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePokeApi(): PokeApi {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun providePokeDatabase(
        app: Application,
    ): PokeDatabase {
        return Room.databaseBuilder(
            app,
            PokeDatabase::class.java,
            "poke_db.db"
        )
            .build()
    }
}
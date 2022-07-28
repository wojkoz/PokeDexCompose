package com.example.pokecompose.data.repository

import com.example.pokecompose.data.local.PokeDatabase
import com.example.pokecompose.data.local.dao.PokeDao
import com.example.pokecompose.data.mapper.toPokeSimpleItem
import com.example.pokecompose.data.mapper.toPokeSimpleItemEntity
import com.example.pokecompose.data.remote.PokeApi
import com.example.pokecompose.domain.model.PokeSimpleItem
import com.example.pokecompose.domain.repository.PokeRepository
import com.example.pokecompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokeRepositoryImpl @Inject constructor(
    db: PokeDatabase,
    private val api: PokeApi,
): PokeRepository {

    private val dao = db.pokeDao

    override suspend fun getPokeSimpleList(fetchFromRemote: Boolean, query: String): Flow<Resource<List<PokeSimpleItem>>> {
        return flow {
            emit(Resource.Loading(true))
            val localListings = dao.searchPokeSimpleList(query)
            emit(Resource.Success(data = localListings.map { it.toPokeSimpleItem() }))

            val isDbEmpty = localListings.isEmpty() && query.isBlank()
            val shouldLoadOnlyFromCache = !isDbEmpty && !fetchFromRemote

            if(shouldLoadOnlyFromCache){
                emit(Resource.Loading(false))
                return@flow
            }

            val remoteListings = try {
                val response = api.getAllPokes()
                response.results.map { it.toPokeSimpleItemEntity() }
            }catch (e: IOException){
                emit(Resource.Error(e.message))
                null
            }catch (e: HttpException){
                emit(Resource.Error(e.message))
                null
            }

            remoteListings?.let { listings ->
                dao.insertPokeSimpleList(listings)
                emit(Resource.Success(
                    dao.searchPokeSimpleList(query = "").map { it.toPokeSimpleItem() }
                ))
                emit(Resource.Loading(false))
            }
        }
    }
}
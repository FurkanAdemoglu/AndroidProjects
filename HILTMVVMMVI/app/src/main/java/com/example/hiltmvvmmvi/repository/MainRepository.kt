package com.example.hiltmvvmmvi.repository

import android.provider.ContactsContract
import com.example.hiltmvvmmvi.model.Blog
import com.example.hiltmvvmmvi.retrofit.BlogRetrofit
import com.example.hiltmvvmmvi.retrofit.NetworkMapper
import com.example.hiltmvvmmvi.room.BlogDao
import com.example.hiltmvvmmvi.room.CacheMapper
import com.example.hiltmvvmmvi.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception


class MainRepository constructor(
    private val blogDao: BlogDao,
    private val blogRetrofit: BlogRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper

) {
    suspend fun getBlog(): Flow<DataState<List<Blog>>> = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val networkBlogs=blogRetrofit.get()
            val blogs=networkMapper.mapFromEntityList(networkBlogs)
            for (blog in blogs){
                blogDao.insert(cacheMapper.mapToEntity(blog))
            }
            val cachedBlogs=blogDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedBlogs)))
        }catch (e:Exception){
            emit(DataState.Error(e))
        }
    }
}
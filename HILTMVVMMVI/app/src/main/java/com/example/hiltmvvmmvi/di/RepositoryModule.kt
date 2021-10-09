package com.example.hiltmvvmmvi.di

import com.example.hiltmvvmmvi.repository.MainRepository
import com.example.hiltmvvmmvi.retrofit.BlogRetrofit
import com.example.hiltmvvmmvi.retrofit.NetworkMapper
import com.example.hiltmvvmmvi.room.BlogDao
import com.example.hiltmvvmmvi.room.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        blogDao: BlogDao,
        retrofit: BlogRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ):MainRepository{
        return MainRepository(blogDao,retrofit,cacheMapper,networkMapper)
    }
}
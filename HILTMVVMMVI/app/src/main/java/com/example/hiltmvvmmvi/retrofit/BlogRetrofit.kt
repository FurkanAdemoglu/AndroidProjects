package com.example.hiltmvvmmvi.retrofit

import retrofit2.http.GET

interface BlogRetrofit {

    @GET
    suspend fun get():List<BlogNetworkEntity>
}
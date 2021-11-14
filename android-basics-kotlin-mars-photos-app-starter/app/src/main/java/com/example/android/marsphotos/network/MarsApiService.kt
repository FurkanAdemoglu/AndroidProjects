package com.example.android.marsphotos.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

import retrofit2.http.GET


/**
 * Object declarations
In kotlin, object declarations are used to declare singleton objects. Singleton pattern ensures that one, and only one, instance of an object is created, has one global point of access to that object. Object declaration's initialization is thread-safe and done at first access.

Kotlin makes it easy to declare singletons. Following is an example of an object declaration and its access. Object declaration always has a name following the object keyword.
 */
private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}

object MarsApi {
    /**
     * Note: Remember "lazy instantiation" is when object creation is purposely delayed until you actually need that object to avoid unnecessary computation or use of other computing resources. Kotlin has first-class support for lazy instantiation.
     *
     */
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}
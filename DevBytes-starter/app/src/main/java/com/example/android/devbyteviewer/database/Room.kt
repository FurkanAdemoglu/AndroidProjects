/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * The repository pattern
The repository pattern is a design pattern that isolates data sources from the rest of the app.

A repository mediates between data sources (such as persistent models, web services, and caches) and the rest of the app. The diagram below shows how app components such as activities that use LiveData might interact with data sources by way of a repository.

 */

/**
 * Advantages of using a repository
A repository module handles data operations and allows you to use multiple backends. In a typical real-world app, the repository implements the logic for deciding whether to fetch data from a network or use results that are cached in a local database. This helps make your code modular and testable. You can easily mock up the repository and test the rest of the code.

 */

package com.example.android.devbyteviewer.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface VideoDao {

    @Query("select * from databasevideo")
    fun getVideos(): LiveData<List<DatabaseVideo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll( videos: List<DatabaseVideo>)
}

@Database(entities = [DatabaseVideo::class], version = 1)
abstract class VideosDatabase: RoomDatabase() {
    abstract val videoDao: VideoDao
}

private lateinit var INSTANCE: VideosDatabase

fun getDatabase(context: Context): VideosDatabase {
    synchronized(VideosDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                VideosDatabase::class.java,
                "videos").build()
        }
    }
    return INSTANCE
}
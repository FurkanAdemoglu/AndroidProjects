/*
 * Copyright 2019, The Android Open Source Project
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

package com.example.android.trackmysleepquality.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * An entity represents an object or a concept, along with its properties, to store in the database. In our application code, we need an entity class that defines a table, and each instance of that class represents a row in that table. The entity class has mappings to tell Room how it intends to present and interact with the information in the database. In your app, the entity is going to hold information about a night of sleep.
A query is a request for data or information from a database table or combination of tables, or a request to perform an action on the data. Common queries are for creating, reading, updating and deleting entities. For example, you could execute a query to read all the sleep nights on record, sorted by start time.

 */

/**
 * Before the class declaration, annotate the data class with @Entity. This annotation has several possible arguments. By default (no arguments to @Entity), the table name will be the same as the class. But let's use a helpful table name of daily_sleep_quality_table. This argument for the tableName is optional, but highly recommended. There are several other arguments for @Entity you can investigate in the documentation
 *
 */
@Entity(tableName = "daily_sleep_quality_table")
data class SleepNight(
    @PrimaryKey(autoGenerate = true)
    var nightId: Long = 0L,

    @ColumnInfo(name = "start_time_milli")
    val startTimeMilli: Long = System.currentTimeMillis(),

    @ColumnInfo(name = "end_time_milli")
    var endTimeMilli: Long = startTimeMilli,

    @ColumnInfo(name = "quality_rating")
    var sleepQuality: Int = -1
)
package com.example.android.devbyteviewer

/**
 * Caching is a process of storing data fetched from a network on a device's storage. Caching lets your app access data when the device is offline, or if your app needs to access the same data again.
The best way for your app to store structured data on a device's file system is to use a local SQLite database. Room is an SQLite object-mapping library, meaning that it provides an abstraction layer over SQLite. Using Room is the recommended best practice for implementing offline caching.
A repository class isolates data sources, such as Room database and web services, from the rest of the app. The repository class provides a clean API for data access to the rest of the app.
Using repositories is a recommended best practice for code separation and architecture.
When you design an offline cache, it's a best practice to separate the app's network, domain, and database objects. This strategy is an example of separation of concerns.
To add offline-support to an app, add a local database using Room. Implement a repository to manage and access the Room database. In the ViewModel, fetch and display the data directly from the repository instead of fetching the data from the network.
Use a database refresh strategy to insert and update the data in the local database. In a database refresh, the local database is updated or refreshed to keep it in sync with data from the network.
To update your app's UI data automatically when the data in the database changes, use observable queries with a return value of type LiveData in the DAO. When the Room database is updated, Room runs the query in background to update the associated LiveData.

        */

/**
 * 4. Concept: WorkManager
WorkManager is one of the Android Architecture Components and part of Android Jetpack. WorkManager is for background work that's deferrable and requires guaranteed execution:

Deferrable means that the work is not required to run immediately. For example, sending analytical data to the server or syncing the database in the background is work that can be deferred.
Guaranteed execution means that the task will run even if the app exits or the device restarts.

        */
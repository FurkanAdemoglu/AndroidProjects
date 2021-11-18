package com.example.android.dagger.di

import com.example.android.dagger.storage.SharedPreferencesStorage
import com.example.android.dagger.storage.Storage
import dagger.Binds
import dagger.Module


/**
 * The way we tell Dagger how to provide Storage is different because Storage is an interface and as such cannot be instantiated directly. We need to tell Dagger what implementation of Storage we want to use. In this case it's SharedPreferencesStorage.

To do this we will use a Dagger Module. A Dagger Module is a class that is annotated with @Module.

Similar to Components, Dagger Modules tell Dagger how to provide instances of a certain type. Dependencies are defined using the @Provides and @Binds annotations.

 */
// Tells Dagger this is a Dagger module
// Because of @Binds, StorageModule needs to be an abstract class
@Module
abstract class StorageModule {

    /**
     * @Binds annotation
    Use @Binds to tell Dagger which implementation it needs to use when providing an interface.

    @Binds must annotate an abstract function. The return type of the abstract function is the interface we want to provide an implementation for (i.e. Storage). The implementation is specified by adding a parameter with the interface implementation type (i.e. SharedPreferencesStorage).

     */
    // Makes Dagger provide SharedPreferencesStorage when a Storage type is requested
    @Binds
    abstract fun provideStorage(storage: SharedPreferencesStorage): Storage
}
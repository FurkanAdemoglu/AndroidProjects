package com.example.daggerhiltinjectionsparttwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println(someClass.doAThing())
    }
}

class SomeClass
@Inject
constructor(
    private val someInterfaceImpl: SomeInterface,
    private val gson: Gson
){
    fun doAThing(): String{
        return "Look I got: ${someInterfaceImpl.getAThing()}"

    }
}

class SomeInterfaceImpl
@Inject
constructor(
    private val someDependency:String
):SomeInterface{
    override fun getAThing(): String {
        return "A thing, ${someDependency}"
    }

}

interface SomeInterface{
    fun getAThing():String
}

/*@InstallIn(ActivityComponent::class)
@Module
abstract class MyModule{

    @ActivityScoped
    @Binds
    abstract fun bindSomeDependency(
        someImpl:SomeInterfaceImpl
    ):SomeInterface

    @ActivityScoped
    @Binds
    abstract fun bindGson(
        gson: Gson
    ):Gson
}*/

@InstallIn(ApplicationComponentManager::class)
@Module
class MyModule{

    @Singleton
    @Provides
    fun provideSomeString():String{
        return "some string"
    }
    @Singleton
    @Provides
    fun provideSomeInterface(
        someString: String
    ):SomeInterface{
        return SomeInterfaceImpl(someString)
    }

    @Singleton
    @Provides
    fun provideGson():Gson{
        return Gson()
    }

}
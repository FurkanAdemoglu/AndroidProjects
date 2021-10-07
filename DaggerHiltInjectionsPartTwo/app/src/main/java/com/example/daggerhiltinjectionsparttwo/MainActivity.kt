package com.example.daggerhiltinjectionsparttwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

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
    //private val someInterfaceImpl: SomeInterface,
    private val gson:Gson
){
    fun doAThing(): String{
       // return "Look I got: ${someInterfaceImpl.getAThing()}"
        return "somethng"
    }
}

class SomeInterfaceImpl
@Inject
constructor():SomeInterface{
    override fun getAThing(): String {
        return "A thing"
    }

}

interface SomeInterface{
    fun getAThing():String
}
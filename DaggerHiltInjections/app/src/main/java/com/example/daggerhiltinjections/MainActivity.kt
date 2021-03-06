package com.example.daggerhiltinjections

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Singleton


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //Field Injection
    @Inject
    lateinit var someClass: SomeClass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println(someClass.doAThing())
       // println(someClass.doOtherThing())
    }
}

@AndroidEntryPoint
class MyFragment: Fragment(){

    @Inject
    lateinit var someClass: SomeClass
}
//Burada dagger arka tarafta bu dependency i compile time da yaratıyor
//ve bizim için runtime da available duruma geçiriyor

@Singleton
class SomeClass @Inject constructor(
    //private val someOtherClass: SomeOtherClass//constructor injection
){
    fun doAThing():String{
        return "Look I did a thing!"
    }


}

/*class SomeOtherClass @Inject constructor(){
    fun doSomeOtherThing():String{
        return "Look I did some other thing!"
    }
}*/

//Yukarıdaki classlarda dagger arka tarafta bizim için neler yapıyor
//Some other class  ın instance ını compile time da yaratıyor
//Ardından someclass ın instance ını compile time da yaratıyor
//bU yaratılan instance ı someotherclass constructorına pass ediyor
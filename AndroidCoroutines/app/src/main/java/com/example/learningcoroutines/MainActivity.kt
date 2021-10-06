package com.example.learningcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val TAG="MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Burada uygulama ekrana geldikten sonra eğer uygulamayı kapatırsak coroutine
        //içindeki log kısmı da gelmez çünkü main thread de bitmiştir.
        //İlk ders kodları
       /* GlobalScope.launch {
            delay(3000L)
            Log.d(TAG,"Coroutine says hello from thread ${Thread.currentThread().name}")
        }

        Log.d(TAG,"Hello from thread ${Thread.currentThread().name}")*/
        //Bu dersteki öenmli nokta suspend fonksiyonlar sadece coroutineler içinden
        //ya da başka bir suspend fonksiyon içinden çağıralabilirler
        //Suspend fonksiyonlar mevcut threadi bloke etmeden coroutinin yürütülmesini
        //askıya alır. Böylelikle thread başka bir coroutinen işletilmesine başlar ve
        //cpu daha verimli kullanılır
        GlobalScope.launch {
            val networkCallAnswer=doNetworkCall()
            val networkCallAnswer2=doNetworkCall2()
            Log.d(TAG,networkCallAnswer)
            Log.d(TAG,networkCallAnswer2)
        }
    }

    suspend fun doNetworkCall():String{
        delay(3000L)
        return "This is the answer"
    }

    suspend fun doNetworkCall2():String{
        delay(3000L)
        return "This is the answer"
    }
}
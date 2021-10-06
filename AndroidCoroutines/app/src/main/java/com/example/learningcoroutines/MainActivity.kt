package com.example.learningcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

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
        //2. ders kodları
        /*GlobalScope.launch {
            val networkCallAnswer=doNetworkCall()
            val networkCallAnswer2=doNetworkCall2()
            Log.d(TAG,networkCallAnswer)
            Log.d(TAG,networkCallAnswer2)
        }*/


        //3. ders kodları
        //Dispatcher.Main => Coroutine i main threadinde başlatır. UI operasyonları coroutinede yapmak
        //istediğimiz zaman kullanabiliriz.Çünkü UI ı sadece main threadinden değiştirebiliriz

        //Dispatcher.IO => Data operasyonlarında kullanılır(Ör: API den veri çekme database e veri yazma )
        //Dispatcher.Default=> Uzun hesaplama sıralama işlemlerinde kullanılır
        //Dispatcher.Unconfined
        GlobalScope.launch(Dispatchers.IO) {

            //Network den istek alığımız gibi düşündüğümüz için bu dispatcher ı kullandık
        Log.d(TAG,"Starting coroutine in the thread ${Thread.currentThread().name}")
            val answer=doNetworkCall()
            withContext(Dispatchers.Main){
                //Burada UI işlemlerı yaptığımız için withContext ile main thread e geçtik
                Log.d(TAG,"Setting text in thread ${Thread.currentThread().name}")
                //textDummy.text=answer
            }
        }

    }

    //2. ders kodları
    suspend fun doNetworkCall():String{
        delay(3000L)
        return "This is the answer"
    }

   /* suspend fun doNetworkCall2():String{
        delay(3000L)
        return "This is the answer"
    }*/


}
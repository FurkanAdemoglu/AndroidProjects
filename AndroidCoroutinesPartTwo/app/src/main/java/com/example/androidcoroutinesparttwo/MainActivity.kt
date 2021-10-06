package com.example.androidcoroutinesparttwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    val TAG="MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //5. Lesson
       /* val job=GlobalScope.launch(Dispatchers.Default) {
          /*  repeat(5){
                Log.d(TAG,"Coroutine is still working...")
                delay(1000L)
            }*/

            Log.d(TAG,"Starting long running calculation....")

            withTimeout(3000L){//=>withTimeout 3 saniye sürelğine çalışacak bu yüzden run blocking kısmını oddan kaldırdık

                for(i in 30..40){
                    if(isActive){
                        Log.d(TAG,"Result for i = $i : ${fib(i)}")
                    }

                }
            }
            Log.d(TAG,"Ending long running calculation...")
        }*/

      /*  runBlocking {
            delay(2000L)
            //job.join()
            job.cancel()
            //Log.d(TAG,"Main Thread is continuing...")
            Log.d(TAG,"Canceled job!")
        }*/

        GlobalScope.launch(Dispatchers.IO) {
            val time= measureTimeMillis {

                //BU kurulan yapıda yaklaşık 9000ms sürüyo bu da verimli bir yol değil onun için async
                //await yapısı kullanacağız

                //val answer1=networkCall1()
                //val answer2=networkCall2()
                val answer1=async { networkCall1() }
                val answer2=async { networkCall2() }
                Log.d(TAG,"Answer1 is ${answer1.await()}")
                Log.d(TAG,"Answer2 is ${answer2.await()}")
            }
            Log.d(TAG,"Requests took $time ms.")
        }
    }
suspend fun networkCall1():String{
    delay(3000L)
    return "Answer 1"
}
    suspend fun networkCall2():String{
        delay(3000L)
        return "Answer 2"
    }
   /* fun fib(n:Int):Long{
        return if(n==0) 0
        else if(n==1) 1
        else fib(n-1)+fib(n-2)
    }*/
}
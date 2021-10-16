package com.example.scopefunctions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private var number:Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //let has used null checks kotlin
        /*if(number!=null){
            /**
             * number val number2=number+1 burada hata verir çünkü biz bu değişkeni
             * global olarak tanımladık başka bir thread de bu number ın değişip
             * değişmediğini bilmiyoruz bu sebeple burada hata veriyor yani if içine
             * girdiğimizde başka bir thread bu number ı null a tekrar eşitlemiş olabilir
             * bu durumda let ikullanırız
             */
            val number2=number+1
        }*/

        /**
         * let burada çağırdığımız zamanda number ın değerine ulaşıyor
         * number ı değiştisek bile bu zamanda it e etkisi olmuyor
         *burada x in değeri unit olur sebebi ise let son satırdaki
         * kısmı return eder
         */
        val x=number?.let {
            val number2=it+1
            number2
        }?:3

    }
}
package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


/**
 * AppCompatActivty Android'in eski sürümleriyle
 * geriye dönük uyumluluk sağlarken tüm modern android özelliklerini destekleyen bir
 * activity alt sınıfıdır uygulamayı mümkün olan en fazla sayıda cihaza ve kullanıcıya sunmak
 * için her zaman appcompatactivity kullanılmalır
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
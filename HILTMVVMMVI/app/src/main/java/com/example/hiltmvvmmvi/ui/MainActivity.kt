package com.example.hiltmvvmmvi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hiltmvvmmvi.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG:String="AppDebug"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
package com.example.coroutinescopes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val TAG="MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button=findViewById<Button>(R.id.btnStartActivity)
        button.setOnClickListener {
            lifecycleScope.launch {//Burada lifecycle scope kullanmalıyız çünkü eğer global
                //scope kullanılırsa main activity destroy olup diğer activity e
                //geçtiğimizde bile loop devam eder ve memory leak oluşur.
                while (true){
                    delay(1000L)
                    Log.d(TAG,"Still running...")
                }
            }
        }

        GlobalScope.launch {
            delay(5000L)
            Intent(this@MainActivity,SecondActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }

    }
}
package com.example.learndaggerhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class WaterTrackerActivity : AppCompatActivity(),WaterintakePreferencesListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water_tracker)
    }

    override fun onWaterIntakeChanged(waterIntake: Int) {
        //waterCountText.text=waterIntake.toString()
    }
}
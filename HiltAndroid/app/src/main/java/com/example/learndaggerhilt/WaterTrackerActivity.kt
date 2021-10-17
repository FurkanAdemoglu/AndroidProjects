package com.example.learndaggerhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint//this lets hilt know that our activity is to be enabled for
//dependency injection
class WaterTrackerActivity : AppCompatActivity(),WaterintakePreferencesListener {

    @Inject lateinit var preferencesHelper: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water_tracker)

       // waterCountText.text=preferencesHelper.getWaterIntake().toString()

        /*trackWaterButton.setOnClickListener{
            preferencesHelper.incrementWaterIntake()
        }*/

        preferencesHelper.subscribeToWaterIntakeChanges(this)
    }

    override fun onDestroy() {
        preferencesHelper.unsubscribeFromWaterIntakeChanges()
        super.onDestroy()
    }

    override fun onWaterIntakeChanged(waterIntake: Int) {
        //waterCountText.text=waterIntake.toString()
    }
}
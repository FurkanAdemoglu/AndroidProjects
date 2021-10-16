package com.example.learndaggerhilt

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp//=>Bu annotation bizim için arka tarafda uygulama için gerekli
//code generationlarını yapıyor
class WaterTrackerApplication:Application() {

    //Logger ı inject eddikten sonra istediğimiz fonksiyonu
    //create ettikten sonra çağırabiliriz
    @Inject lateinit var logger:Logger


    override fun onCreate() {
        super.onCreate()
        logger.configure()
    }
}
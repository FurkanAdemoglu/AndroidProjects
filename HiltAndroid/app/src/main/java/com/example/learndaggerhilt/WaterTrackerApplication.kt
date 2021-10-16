package com.example.learndaggerhilt

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp//=>Bu annotation bizim için arka tarafda uygulama için gerekli
//code generationlarını yapıyor
class WaterTrackerApplication:Application() {
}
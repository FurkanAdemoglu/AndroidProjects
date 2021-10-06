package com.example.daggerhiltinjections

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp //=> Genereate that app component and prepare everything  to do use hilt for the applicaiton
class MyApplication:Application() {
}
package com.example.learndaggerhilt

import timber.log.Timber
import javax.inject.Inject

class Logger @Inject constructor() {

    fun configure()= Timber.plant(Timber.DebugTree())

    fun log(message:String)=Timber.d(message)
}
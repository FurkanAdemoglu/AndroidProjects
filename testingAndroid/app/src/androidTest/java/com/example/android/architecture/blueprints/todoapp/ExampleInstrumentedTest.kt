package com.example.android.architecture.blueprints.todoapp

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

/**
 * What makes this an instrumented test?

A test is an instrumented test if it needs or benefits from being run on an emulated or real device. Instrumented tests almost always use the Android OS or Android framework. In this test, you're getting a Context, using InstrumentationRegistry. This allows you to get the package name and do a comparison.

The difference between this test and the last test is that you're using Android Framework code.
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.android.architecture.blueprints.reactive",
            appContext.packageName)
    }
}

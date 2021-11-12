TO-DO Notes - Code for 5.1-5.3 Testing Codelab
============================================================================

Code for the Advanced Android Kotlin Testing Codelab 5.1-5.3

Introduction
------------

TO-DO Notes is an app where you to write down tasks to complete. The app displays them in a list.
You can then mark them as completed or not, filter them and delete them.

![App main screen, screenshot](screenshot.png)

This codelab has four branches, representing different code states:

* [starter_code](https://github.com/googlecodelabs/android-testing/tree/starter_code)
* [end_codelab_1](https://github.com/googlecodelabs/android-testing/tree/end_codelab_1)
* [end_codelab_2](https://github.com/googlecodelabs/android-testing/tree/end_codelab_2)
* [end_codelab_3](https://github.com/googlecodelabs/android-testing/tree/end_codelab_3)

The codelabs in this series are:
* [Testing Basics](https://codelabs.developers.google.com/codelabs/advanced-android-kotlin-training-testing-basics)
* [Introduction to Test Doubles and Dependency Injection](https://codelabs.developers.google.com/codelabs/advanced-android-kotlin-training-testing-test-doubles)
* [Survey of Testing Topics](https://codelabs.developers.google.com/codelabs/advanced-android-kotlin-training-testing-survey)


Pre-requisites
--------------

You should be familiar with:

* The Kotlin programming language, including [Kotlin coroutines](https://developer.android.com/kotlin/coroutines) and their interaction with [Android Jetpack components](https://developer.android.com/topic/libraries/architecture/coroutines).
* The following core Android Jetpack libraries: [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel),
 [LiveData](https://developer.android.com/topic/libraries/architecture/livedata),
  [Navigation Component](https://developer.android.com/guide/navigation) and 
  [Data Binding](https://developer.android.com/topic/libraries/data-binding).
* Application architecture, following the pattern from the [Guide to app architecture](https://developer.android.com/jetpack/docs/guide) and [Android Fundamentals codelabs](https://developer.android.com/courses/kotlin-android-fundamentals/toc).


Getting Started
---------------

1. Download and run the app.
2. Check out one of the codelabs mentioned above.

License
-------

Copyright 2019 Google, Inc.

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.


Notes Which I taken
---------------

## Running Test Task
These folders are known as source sets. Source sets are folders containing source code for your app. The source sets, which are colored green (androidTest and test) contain your tests. When you create a new Android project, you get the following three source sets by default. They are:

main: Contains your app code. This code is shared amongst all different versions of the app you can build (known as build variants)
androidTest: Contains tests known as instrumented tests.
test: Contains tests known as local tests.
The difference between local tests and instrumented tests is in the way they are run.

Local tests (test source set)
These tests are run locally on your development machine's JVM and do not require an emulator or physical device. Because of this, they run fast, but their fidelity is lower, meaning they act less like they would in the real world.

In Android Studio local tests are represented by a green and red triangle icon.

What makes this an instrumented test?

A test is an instrumented test if it needs or benefits from being run on an emulated or real device. Instrumented tests almost always use the Android OS or Android framework. In this test, you're getting a Context, using InstrumentationRegistry. This allows you to get the package name and do a comparison.

The difference between this test and the last test is that you're using Android Framework code.

Instrumented tests (androidTest source set)
These tests run on real or emulated Android devices, so they reflect what will happen in the real world, but are also much slower.

In Android Studio instrumented tests are represented by an Android with a green and red triangle icon.

# Writing your first tests
Usually, you use implementation when adding a dependency, yet here you're using testImplementation. When you're ready to share your app with the world, it is best not to bloat the size of your APK with any of the test code or dependencies in your app. You can designate whether a library should be included in the main or test code by using gradle configurations. The most common configurations are:

implementation—The dependency is available in all source sets, including the test source sets.
testImplementation—The dependency is only available in the test source set.
androidTestImplementation—The dependency is only available in the androidTest source set.


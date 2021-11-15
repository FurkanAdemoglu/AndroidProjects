/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.guesstheword.screens.score

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ScoreViewModelFactory (private val finalScore: Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoreViewModel::class.java)) {
            return ScoreViewModel(finalScore) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}

/**
 * 11. Summary
LiveData
LiveData is an observable data holder class that is lifecycle-aware, one of the Android Architecture Components.
You can use LiveData to enable your UI to update automatically when the data updates.
LiveData is observable, which means that an observer like an activity or an fragment can be notified when the data held by the LiveData object changes.
LiveData holds data; it is a wrapper that can be used with any data.
LiveData is lifecycle-aware, meaning that it only updates observers that are in an active lifecycle state such as STARTED or RESUMED.
To add LiveData
Change the type of the data variables in ViewModel to LiveData or MutableLiveData.
MutableLiveData is a LiveData object whose value can be changed. MutableLiveData is a generic class, so you need to specify the type of data that it holds.

To change the value of the data held by the LiveData, use the setValue() method on the LiveData variable.
To encapsulate LiveData
The LiveData inside the ViewModel should be editable. Outside the ViewModel, the LiveData should be readable. This can be implemented using a Kotlin backing property.
A Kotlin backing property allows you to return something from a getter other than the exact object.
To encapsulate the LiveData, use private MutableLiveData inside the ViewModel and return a LiveData backing property outside the ViewModel.
Observable LiveData
LiveData follows an observer pattern. The "observable" is the LiveData object, and the observers are the methods in the UI controllers, like fragments. Whenever the data wrapped inside LiveData changes, the observer methods in the UI controllers are notified.
To make the LiveData observable, attach an observer object to the LiveData reference in the observers (such as activities and fragments) using the observe() method.
This LiveData observer pattern can be used to communicate from the ViewModel to the UI controllers.
 */

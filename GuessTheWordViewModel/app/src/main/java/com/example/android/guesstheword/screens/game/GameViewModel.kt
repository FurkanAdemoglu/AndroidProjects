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

package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * ViewModel containing all the logic needed to run the game
 */

/**
 * LiveData is an observable data holder class that is lifecycle-aware. For example, you can wrap a LiveData around the current score in the GuessTheWord app. In this codelab, you learn about several characteristics of LiveData:

LiveData is observable, which means that an observer is notified when the data held by the LiveData object changes.
LiveData holds data; LiveData is a wrapper that can be used with any data
LiveData is lifecycle-aware. When you attach an observer to the LiveData, the observer is associated with a LifecycleOwner (usually an Activity or Fragment). The LiveData only updates observers that are in an active lifecycle state such as STARTED or RESUMED.
 */
class GameViewModel : ViewModel() {

    // The current word
    private val _word = MutableLiveData<String>()
    val word: LiveData<String>
        get() = _word

    // The current score
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    // Event which triggers the end of the game
    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>


    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }

    init {
        _word.value = ""
        _score.value = 0
        Log.i("GameViewModel", "GameViewModel created!")
        resetList()
        nextWord()
    }

    /**
     * Callback called when the ViewModel is destroyed
     */
    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }

    /** Methods for updating the UI **/
    fun onSkip() {
        _score.value = (score.value)?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        _score.value = (score.value)?.plus(1)
        nextWord()
    }

    /**
     * Moves to the next word in the list.
     */
    private fun nextWord() {
        if (wordList.isEmpty()) {
            onGameFinish()
        } else {
            //Select and remove a _word from the list
            _word.value = wordList.removeAt(0)
        }
    }

    /** Method for the game completed event **/
    fun onGameFinish() {
        _eventGameFinish.value = true
    }
    fun onGameFinishComplete() {
        _eventGameFinish.value = false
    }
}
/**
 * MutableLiveData vs. LiveData:

Data in a MutableLiveData object can be changed, as the name implies. Inside the ViewModel, the data should be editable, so it uses MutableLiveData.
Data in a LiveData object can be read, but not changed. From outside the ViewModel, data should be readable, but not editable, so the data should be exposed as LiveData.
 */

/**
 * The observer pattern
The observer pattern is a software design pattern. It specifies communication between objects: an observable (the "subject" of observation) and observers.
An observable is an object that notifies observers about the changes in its state.
        */
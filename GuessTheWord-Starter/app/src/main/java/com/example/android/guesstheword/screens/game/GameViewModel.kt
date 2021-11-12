package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {

    // The current word
    var word = ""
    // The current score
    var score = 0
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
        resetList()
        nextWord()
        Log.i("GameViewModel", "GameViewModel created!")
    }
    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        if (!wordList.isEmpty()) {
            //Select and remove a word from the list
            word = wordList.removeAt(0)
        }

    }
    /** Methods for buttons presses **/
    fun onSkip() {
        score--
        nextWord()
    }

    fun onCorrect() {
        score++
        nextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }

    init {
        Log.i("GameViewModel", "GameViewModel created!")
    }


}

/**
 * App architecture
App architecture is a way of designing your apps' classes, and the relationships between them, such that the code is organized, performs well in particular scenarios, and is easy to work with. In this set of four codelabs, the improvements that you make to the GuessTheWord app follow the Android app architecture guidelines, and you use Android Architecture Components. The Android app architecture is similar to the MVVM (model-view-viewmodel) architectural pattern.

The GuessTheWord app follows the separation of concerns design principle and is divided into classes, with each class addressing a separate concern. In this first codelab of the lesson, the classes you work with are a UI controller, a ViewModel, and a ViewModelFactory.

UI controller
A UI controller is a UI-based class such as Activity or Fragment. A UI controller should only contain logic that handles UI and operating-system interactions such as displaying views and capturing user input. Don't put decision-making logic, such as logic that determines the text to display, into the UI controller.

In the GuessTheWord starter code, the UI controllers are the three fragments: GameFragment, ScoreFragment, and TitleFragment. Following the "separation of concerns" design principle, the GameFragment is only responsible for drawing game elements to the screen and knowing when the user taps the buttons, and nothing more. When the user taps a button, this information is passed to the GameViewModel.

ViewModel
A ViewModel holds data to be displayed in a fragment or activity associated with the ViewModel. A ViewModel can do simple calculations and transformations on data to prepare the data to be displayed by the UI controller. In this architecture, the ViewModel performs the decision-making.

The GameViewModel holds data like the score value, the list of words, and the current word, because this is the data to be displayed on the screen. The GameViewModel also contains the business logic to perform simple calculations to decide what the current state of the data is.

ViewModelFactory
A ViewModelFactory instantiates ViewModel objects, with or without constructor parameters.
 */
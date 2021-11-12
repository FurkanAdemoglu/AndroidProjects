package com.example.android.guesstheword.screens.score

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


/**
 * During configuration changes such as screen rotations, UI controllers such as fragments are re-created. However, ViewModel instances survive.
 * If you create the ViewModel instance using the ViewModel class, a new object is created every time the fragment is re-created.
 * Instead, create the ViewModel instance using a ViewModelProvider.
 */
class ScoreViewModelFactory(private val finalScore: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoreViewModel::class.java)) {
            return ScoreViewModel(finalScore) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

/**
 * How ViewModelProvider works:

ViewModelProvider returns an existing ViewModel if one exists, or it creates a new one if it does not already exist.
ViewModelProvider creates a ViewModel instance in association with the given scope (an activity or a fragment).
The created ViewModel is retained as long as the scope is alive. For example, if the scope is a fragment, the ViewModel is retained until the fragment is detached.
        */
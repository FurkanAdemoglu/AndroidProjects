/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.wordsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordsapp.databinding.ActivityDetailBinding

/**
 * While you could just create a constant called "letter", this could get unwieldy as you add more intent extras to your app. And in which class would you put this constant? Remember that the string is used in both DetailActivity and MainActivity. You need a way to define a constant that can be used across multiple classes, while keeping your code organized.

Thankfully, there's a handy Kotlin feature that can be used to separate your constants and make them usable without a particular instance of the class called companion objects. A companion object is similar to other objects, such as instances of a class. However, only a single instance of a companion object will exist for the duration of your program, which is why this is sometimes called the singleton pattern. While there are numerous use cases for singletons beyond the scope of this codelab, for now, you'll use a companion object as a way to organize constants and make them accessible outside of the DetailActivity. You'll start by using a companion object to refactor the code for the "letter" extra.
 */

class DetailActivity : AppCompatActivity() {

    companion object {
        const val LETTER = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)

        // Retrieve a binding object that allows you to refer to views by id name
        // Names are converted from snake case to camel case.
        // For example, a View with the id word_one is referenced as binding.wordOne
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve the LETTER from the Intent extras
        // intent.extras.getString returns String? (String or null)
        // so toString() guarantees that the value will be a String
        val letterId = intent?.extras?.getString(LETTER).toString()

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = WordAdapter(letterId, this)

        // Adds a [DividerItemDecoration] between items
        recyclerView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )

        title = getString(R.string.detail_prefix) + " " + letterId
    }
}
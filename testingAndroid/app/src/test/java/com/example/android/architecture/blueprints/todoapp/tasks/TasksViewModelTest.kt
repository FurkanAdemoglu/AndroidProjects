package com.example.android.architecture.blueprints.todoapp.tasks


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.architecture.blueprints.todoapp.data.Task
import com.example.android.architecture.blueprints.todoapp.data.source.FakeTestRepository
import com.example.android.architecture.blueprints.todoapp.getOrAwaitValue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.not
import org.hamcrest.Matchers.nullValue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Why make the view model test a local test?

Pure view model tests usually go in the test source set because the view model code shouldn't rely on the Android framework or OS.
As a local test, it will also run faster because you run the tests on your local machine and not on an emulator or device.
 */

/**
 * What is AndroidX Test?
AndroidX Test is a collection of libraries for testing. It includes classes and methods that give you versions of components like Applications and Activities, that are meant for tests.
As an example, this code you wrote is an example of an AndroidX Test function for getting an application context.
 */

/**
 * What is Robolectric?
The simulated Android environment that AndroidX Test uses for local tests is provided by Robolectric. Robolectric is a library that creates a simulated Android environment for tests and runs faster than booting up an emulator or running on a device.
Without the Robolectric dependency, you'll get this error:
 */

@RunWith(AndroidJUnit4::class)
class TasksViewModelTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    // Use a fake repository to be injected into the viewmodel
    private lateinit var tasksRepository: FakeTestRepository

    @Before
    fun setupViewModel() {
        // We initialise the tasks to 3, with one active and two completed
        tasksRepository = FakeTestRepository()
        val task1 = Task("Title1", "Description1")
        val task2 = Task("Title2", "Description2", true)
        val task3 = Task("Title3", "Description3", true)
        tasksRepository.addTasks(task1, task2, task3)

        //tasksViewModel = TasksViewModel(tasksRepository)

    }
    /**
     * This rule runs all Architecture Components-related background jobs in the same thread so that the test results happen synchronously, and in a repeatable order.
     * When you write tests that include testing LiveData, use this rule!
     */

    @Test
    fun addNewTask_setsNewTaskEvent() {
        // Given a fresh ViewModel
        val tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())


        // When adding a new task
        tasksViewModel.addNewTask()

        // Then the new task event is triggered
        val value = tasksViewModel.newTaskEvent.getOrAwaitValue()

        assertThat(value.getContentIfNotHandled(), not(nullValue()))

    }

}
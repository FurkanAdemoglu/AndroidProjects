package com.example.android.architecture.blueprints.todoapp.taskdetail

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.example.android.architecture.blueprints.todoapp.R
import com.example.android.architecture.blueprints.todoapp.ServiceLocator
import com.example.android.architecture.blueprints.todoapp.data.Task
import com.example.android.architecture.blueprints.todoapp.data.source.FakeAndroidTestRepository
import com.example.android.architecture.blueprints.todoapp.data.source.TasksRepository
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isChecked
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.core.IsNot.not

/**
 * Why put this test in the androidTest source set?

Fragments (at least the ones you'll be testing) are visual and make up the user interface. Because of this, when testing them, it helps to render them on a screen, as they would when the app is running. Thus when testing fragments, you usually write instrumented tests, which live in the androidTest source set.

As a general rule of thumb, if you are testing something visual, run it as an instrumented test.
 */


/**
 * @MediumTest—Marks the test as a "medium run-time" integration test
 * (versus @SmallTest unit tests and @LargeTest end-to-end tests). This helps you group and choose which size of test to run.
@RunWith(AndroidJUnit4::class)—Used in any class using AndroidX Test.
 */
@MediumTest
@RunWith(AndroidJUnit4::class)
class TaskDetailFragmentTest{

    private lateinit var repository: TasksRepository

    @Before
    fun initRepository() {
        repository = FakeAndroidTestRepository()
        ServiceLocator.tasksRepository = repository
    }

    @After
    fun cleanupDb() = runBlockingTest {
        ServiceLocator.resetRepository()
    }

    @Test
    fun activeTaskDetails_DisplayedInUi() = runBlockingTest{
        // GIVEN - Add active (incomplete) task to the DB
        val activeTask = Task("Active Task", "AndroidX Rocks", false)

        repository.saveTask(activeTask)

        // WHEN - Details fragment launched to display task
        val bundle = TaskDetailFragmentArgs(activeTask.id).toBundle()
        launchFragmentInContainer<TaskDetailFragment>(bundle, R.style.AppTheme)
        /**
         * This code above:

        Creates a task.
        Creates a Bundle, which represents the fragment arguments for the task that get passed into the fragment).
        The launchFragmentInContainer function creates a FragmentScenario, with this bundle and a theme.
         */


        /**
         * Before you write an Espresso test, take a look at some Espresso code.


        onView(withId(R.id.task_detail_complete_checkbox)).perform(click()).check(matches(isChecked()))

        Static Espresso method

        onView
        onView is an example of a static Espresso method that starts an Espresso statement. onView is one of the most common ones, but there are other options, such as onData.

        ViewMatcher

        withId(R.id.task_detail_title_text)
        withId is an example of a ViewMatcher which gets a view by its ID. There are other view matchers which you can look up in the documentation.

        ViewAction

        perform(click())
        The perform method which takes a ViewAction. A ViewAction is something that can be done to the view, for example here, it's clicking the view.

        ViewAssertion

        check(matches(isChecked()))
        check which takes a ViewAssertion. ViewAssertions check or assert something about the view. The most common ViewAssertion you'll use is the matches assertion. To finish the assertion, use another ViewMatcher, in this case isChecked.
         */
        // THEN - Task details are displayed on the screen
        // make sure that the title/description are both shown and correct
        onView(withId(R.id.task_detail_title_text)).check(matches(isDisplayed()))
        onView(withId(R.id.task_detail_title_text)).check(matches(withText("Active Task")))
        onView(withId(R.id.task_detail_description_text)).check(matches(isDisplayed()))
        onView(withId(R.id.task_detail_description_text)).check(matches(withText("AndroidX Rocks")))
        // and make sure the "active" checkbox is shown unchecked
        onView(withId(R.id.task_detail_complete_checkbox)).check(matches(isDisplayed()))
        onView(withId(R.id.task_detail_complete_checkbox)).check(matches(not(isChecked())))

    }

    @Test
    fun completedTaskDetails_DisplayedInUi() = runBlockingTest{
        // GIVEN - Add completed task to the DB
        val completedTask = Task("Completed Task", "AndroidX Rocks", true)
        repository.saveTask(completedTask)

        // WHEN - Details fragment launched to display task
        val bundle = TaskDetailFragmentArgs(completedTask.id).toBundle()
        launchFragmentInContainer<TaskDetailFragment>(bundle, R.style.AppTheme)

        // THEN - Task details are displayed on the screen
        // make sure that the title/description are both shown and correct
        onView(withId(R.id.task_detail_title_text)).check(matches(isDisplayed()))
        onView(withId(R.id.task_detail_title_text)).check(matches(withText("Completed Task")))
        onView(withId(R.id.task_detail_description_text)).check(matches(isDisplayed()))
        onView(withId(R.id.task_detail_description_text)).check(matches(withText("AndroidX Rocks")))
        // and make sure the "active" checkbox is shown unchecked
        onView(withId(R.id.task_detail_complete_checkbox)).check(matches(isDisplayed()))
        onView(withId(R.id.task_detail_complete_checkbox)).check(matches(isChecked()))
    }


}
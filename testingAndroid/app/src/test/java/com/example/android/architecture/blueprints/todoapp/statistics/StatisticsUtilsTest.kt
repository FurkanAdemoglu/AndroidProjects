package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import junit.framework.Assert.assertEquals
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`

import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
        // Create an active task (the false makes this active)
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = false)
        )
        // Call your function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertEquals(result.completedTasksPercent, 0f)
        assertThat(result.activeTasksPercent, `is`(100f))
        assertThat(result.completedTasksPercent, `is`(0f))
        assertEquals(result.activeTasksPercent, 100f)
    }
}
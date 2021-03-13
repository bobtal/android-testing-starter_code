package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest {

    // If there's no completed task and one active task,
    // then there are 100% active tasks and 0% completed tasks.
    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsZeroHundred() {
        val tasks = listOf<Task>(
                Task("title", "description", isCompleted = false)
        )

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(0f, result.completedTasksPercent)
        assertEquals(100f, result.activeTasksPercent)
    }

    // If there's 1 completed task and no active tasks,
    // then there are 100% completed tasks and 0% active tasks.
    @Test
    fun getActiveAndCompletedStats_noActive_returnsHundredZero() {
        val tasks = listOf<Task>(
                Task("title", "description", isCompleted = true)
        )

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(100f, result.completedTasksPercent)
        assertEquals(0f, result.activeTasksPercent)
    }

    // If there's 2 completed tasks and 3 active tasks,
    // then there are 40% completed tasks and 60% active tasks.
    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty() {
        val tasks = listOf<Task>(
                Task("title", "description", isCompleted = true),
                Task("title", "description", isCompleted = true),
                Task("title", "description", isCompleted = false),
                Task("title", "description", isCompleted = false),
                Task("title", "description", isCompleted = false)
        )

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(40f, result.completedTasksPercent)
        assertEquals(60f, result.activeTasksPercent)
    }

    // If there's no task at all,
    // then there are 0% active tasks and 0% completed tasks.
    @Test
    fun getActiveAndCompletedStats_empty_returnsZeroes() {
        val tasks = emptyList<Task>()

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(0f, result.completedTasksPercent)
        assertEquals(0f, result.activeTasksPercent)
    }

    // If there's no task list at all (it's null),
    // then there are 0% active tasks and 0% completed tasks.
    @Test
    fun getActiveAndCompletedStats_error_returnsZeroes() {
        val tasks = emptyList<Task>()

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(0f, result.completedTasksPercent)
        assertEquals(0f, result.activeTasksPercent)
    }
}
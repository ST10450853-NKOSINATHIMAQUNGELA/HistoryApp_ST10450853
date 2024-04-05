package com.example.myapplication

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.not
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MyUnitTest {


    @Before
    fun setUp() {
        // Initialize ActivityScenario
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun testGenerateButtonClicked() {
        // Input an age
        onView(withId(R.id.edtNumber)).perform(replaceText("46"), closeSoftKeyboard())

        // Click on the generate button
        onView(withId(R.id.generateButton)).perform(click())

        // Check if the result view displays the correct message
        onView(withId(R.id.resultsView)).check(matches(withText("You are 46 years old, the same age as John F. Kennedy who was the 35th president of the United States of America. He died at the age of 46.")))
    }

    @Test
    fun testClearButtonClicked() {
        // Input an age
        onView(withId(R.id.edtNumber)).perform(replaceText("46"), closeSoftKeyboard())

        // Click on the generate button
        onView(withId(R.id.generateButton)).perform(click())

        // Check if the result view is not empty
        onView(withId(R.id.resultsView)).check(matches(not(withText(""))))

        // Click on the clear button
        onView(withId(R.id.clearButton)).perform(click())

        // Check if the edit text is cleared and the result view is empty
        onView(withId(R.id.edtNumber)).check(matches(withText("")))
        onView(withId(R.id.resultsView)).check(matches(withText("")))
    }
}

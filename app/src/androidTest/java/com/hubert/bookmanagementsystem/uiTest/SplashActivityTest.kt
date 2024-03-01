package com.hubert.bookmanagementsystem.uiTest;

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.hubert.bookmanagementsystem.ui.SplashActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SplashActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(SplashActivity::class.java)

    private lateinit var launchedActivity: SplashActivity

    @Before
    fun setUp() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        launchedActivity = activityRule.launchActivity(intent)
    }

    @Test
    fun test() {
        onView(withText("图书管理系统")).check(matches(isDisplayed()))
    }
}

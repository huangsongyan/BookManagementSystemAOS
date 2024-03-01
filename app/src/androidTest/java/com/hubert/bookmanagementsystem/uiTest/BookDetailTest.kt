package com.hubert.bookmanagementsystem.uiTest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.hubert.bookmanagementsystem.ui.BookDetailActivity
import org.junit.Rule
import org.junit.Test

@LargeTest
class BookDetailTest {

    @Rule
    @JvmField
    var activityActivityTestRule = ActivityTestRule(BookDetailActivity::class.java)

    @Test
    @LargeTest
    fun showBookDetailRight() {
        //TODO
    }
}
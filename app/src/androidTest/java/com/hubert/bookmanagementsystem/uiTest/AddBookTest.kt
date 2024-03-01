package com.hubert.bookmanagementsystem.uiTest

import androidx.test.rule.ActivityTestRule
import com.hubert.bookmanagementsystem.ui.AddBookActivity
import org.junit.Rule

class AddBookTest {
    @Rule
    @JvmField
    var activityActivityTestRule = ActivityTestRule(AddBookActivity::class.java)
}
package com.hubert.bookmanagementsystem.uiTest


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.hubert.bookmanagementsystem.R
import com.hubert.bookmanagementsystem.ui.BookActivity
import com.hubert.bookmanagementsystem.ui.adapter.BookAdapter
import org.junit.Rule
import org.junit.Test

@LargeTest
class BookActivityTest {

    @Rule
    @JvmField
    var activityActivityTestRule = ActivityTestRule(BookActivity::class.java)

    @LargeTest
    @Test
    fun testRecyclerView()  {
        Thread.sleep(1000)
        // RecyclerView滚动到position位置，这里的scrollTo()方法定义在espresso-core的ViewActioin内
        onView(withId(R.id.recyclerView)).perform(actionOnItemAtPosition<BookAdapter.BookViewHolder>(4, scrollTo()))
        Thread.sleep(200); // 为了执行速度慢些设置Thread sleep
        // RecyclerView滚动到position是1的位置，这里的scrollToPosition()方法定义在RecyclerViewActions内
        onView(withId(R.id.recyclerView)).perform(scrollToPosition<BookAdapter.BookViewHolder>(1));
        Thread.sleep(500);
        // RecyclerView滚动到positioin位置，并且执行click操作
        onView(withId(R.id.recyclerView)).perform(scrollToPosition<BookAdapter.BookViewHolder>(2), actionOnItemAtPosition<BookAdapter.BookViewHolder>(19, click()));
    }


    @Test
    fun showRightBookList() {
        Thread.sleep(1000)
//        onView(withId(R.id.recyclerView)).check()
    }
}
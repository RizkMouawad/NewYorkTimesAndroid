package com.example.newyorktimesandroid

import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.newyorktimesandroid.news.presentation.ui.fragments.NewsFragment
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class AppInstrumentedTest {
    @Test
    fun testFragment() {
        val scenario = launchFragmentInContainer<NewsFragment>()
        try {
            Thread.sleep(5000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        if (getCountFromRecyclerView(R.id.rvNews) > 4) {
            // Click the item on position 1 in recycler view
            onView(withId(R.id.rvNews))
                .perform(
                    RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                        1,
                        ViewActions.click()
                    )
                )

            // Go to details activity and sleep for 3000 ms

            // Go to details activity and sleep for 3000 ms
            try {
                Thread.sleep(3000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

            //go back to home activity

            //go back to home activity
            Espresso.pressBack()

            // Click the item on position 2 in recycler view

            // Click the item on position 2 in recycler view
            onView(withId(R.id.rvNews))
                .perform(
                    RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                        2,
                        ViewActions.click()
                    )
                )

            // Go to details activity and sleep for 3000 ms

            // Go to details activity and sleep for 3000 ms
            try {
                Thread.sleep(3000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

            //go back to home activity

            //go back to home activity
            Espresso.pressBack()

            // Click the item on position 3 in recycler view

            // Click the item on position 3 in recycler view
            onView(withId(R.id.rvNews))
                .perform(
                    RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                        3,
                        ViewActions.click()
                    )
                )

            // Go to details activity and sleep for 3000 ms

            // Go to details activity and sleep for 3000 ms
            try {
                Thread.sleep(3000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

            //go back to home activity

            //go back to home activity
            Espresso.pressBack()

            //Swipe refresh layout to refresh data
            //Swipe refresh layout to refresh data
            Espresso.onView(withId(R.id.srlNews))
                .perform(
                    withCustomConstraints(
                        ViewActions.swipeDown(),
                        ViewMatchers.isDisplayingAtLeast(85)
                    )
                )

            //sleep for 5000 ms then exit

            //sleep for 5000 ms then exit
            try {
                Thread.sleep(5000)
            } catch (e: java.lang.InterruptedException) {
                e.printStackTrace()
            }
        }
    }

    fun getCountFromRecyclerView(@IdRes RecyclerViewId: Int): Int {
        val COUNT = intArrayOf(0)
        val matcher: Matcher<*> =
            object : TypeSafeMatcher<View>() {
                override fun matchesSafely(item: View): Boolean {
                    COUNT[0] = (item as RecyclerView).adapter!!.itemCount
                    return true
                }

                override fun describeTo(description: Description) {}
            }
        onView(
            Matchers.allOf(
                withId(RecyclerViewId),
                ViewMatchers.isDisplayed()
            )
        ).check(ViewAssertions.matches(matcher as Matcher<in View>?))
        return COUNT[0]
    }

    fun withCustomConstraints(
        action: ViewAction,
        constraints: Matcher<View>
    ): ViewAction? {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return constraints
            }

            override fun getDescription(): String {
                return action.description
            }

            override fun perform(
                uiController: UiController,
                view: View
            ) {
                action.perform(uiController, view)
            }
        }
    }

}

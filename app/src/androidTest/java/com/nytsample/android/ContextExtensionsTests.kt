package com.nytsample.android

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.runner.AndroidJUnit4
import com.nytsample.android.utils.isNetworkConnected
import com.nytsample.android.utils.toast
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import android.support.test.espresso.matcher.RootMatchers.withDecorView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.rule.ActivityTestRule
import com.nytsample.android.view.MainActivity
import org.junit.Rule
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.not


@RunWith(AndroidJUnit4::class)
class ContextExtensionsTests {
    @Test
    fun test_isNetworkConnected() {
        val appContext = InstrumentationRegistry.getTargetContext()
        Assert.assertTrue(appContext.isNetworkConnected())
    }

    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun test_toast() {
        val appContext = InstrumentationRegistry.getTargetContext()
        activityTestRule.activity.runOnUiThread { appContext.toast(activityTestRule.activity.getString(R.string.api_error_no_network)) }
        onView(withText(R.string.api_error_no_network)).inRoot(withDecorView(not(`is`(activityTestRule.activity.window.decorView)))).check(matches(isDisplayed()))
    }
}
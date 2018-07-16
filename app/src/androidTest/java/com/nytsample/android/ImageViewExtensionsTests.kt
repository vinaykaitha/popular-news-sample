package com.nytsample.android

import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.widget.ImageView
import com.nytsample.android.utils.isValidContextForGlide
import com.nytsample.android.view.MainActivity
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ImageViewExtensionsTests {

    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun test_isValidContextForGlide() {
        val appContext = InstrumentationRegistry.getContext()
        val imageViewWithApplicationContext = ImageView(appContext)
        assertTrue(imageViewWithApplicationContext.isValidContextForGlide())

        val imageViewWithActivityContext = ImageView(activityTestRule.activity)
        assertTrue(imageViewWithActivityContext.isValidContextForGlide())
    }
}
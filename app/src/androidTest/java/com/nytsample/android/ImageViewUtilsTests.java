package com.nytsample.android;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.ImageView;

import com.nytsample.android.utils.ImageViewUtils;
import com.nytsample.android.view.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class ImageViewUtilsTests {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void test_isValidContextForGlide() {
        Context appContext = InstrumentationRegistry.getContext();
        ImageView imageViewWithApplicationContext = new ImageView(appContext);
        assertTrue(ImageViewUtils.isValidContextForGlide(imageViewWithApplicationContext));

        ImageView imageViewWithActivityContext = new ImageView(activityTestRule.getActivity());
        assertTrue(ImageViewUtils.isValidContextForGlide(imageViewWithActivityContext));
    }
}

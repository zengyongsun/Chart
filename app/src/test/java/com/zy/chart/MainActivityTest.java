package com.zy.chart;

import android.app.Activity;
import android.widget.TextView;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class,sdk = 25)
public class MainActivityTest {

    @Test
    public void testMainActivity(){

//        Activity activity = Robolectric.buildActivity(MainActivity.class).create().get();
//
//        Activity activity1 = Robolectric.setupActivity(MainActivity.class);



        ActivityController controller = Robolectric.buildActivity(MainActivity.class).create().start();
        Activity activity = (Activity) controller.get();
        TextView textView = (TextView) activity.findViewById(R.id.tv);
        //断言事情没有发生
        Assert.assertEquals("onCreate",textView.getText().toString());
        controller.resume();
        Assert.assertEquals("onResume",textView.getText().toString());
        controller.destroy();
        Assert.assertEquals("onDestroy",textView.getText().toString());
        //断言它发生

    }

}

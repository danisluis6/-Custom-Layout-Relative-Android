package com.example.lorence.vel1.ui;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.lorence.vel1.utilities.Utils;

/**
 * @Run: https://github.com/andreasschrade/android-design-template/blob/master/app/src/main/java/de/andreasschrade/androidtemplate/ui/base/BaseActivity.java
 * @Run: https://stackoverflow.com/questions/34331284/best-example-of-abstract-class-in-android
 * => How to create Class Abstract Activity in Android
 *
 * @Run: https://stackoverflow.com/questions/33295477/how-to-implement-singleton-pattern-in-android/33295561
 * => Done Singleton successfully
 *
 * @Run: https://stackoverflow.com/questions/5702086/how-to-fix-layout-orientation-to-vertical
 * => Done Vertical successfully
 */

public abstract class BaseActivity extends AppCompatActivity {

    /**
     * @Run: https://stackoverflow.com/questions/15078935/what-does-class-mean-in-java
     * =>  is an object that represents the class BaseActivity on runtime.
     */
    private static String TAG = Utils.makeLogTag(BaseActivity.class);

    private Context mInstance;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(myView());
        activityCreated();
    }

    public synchronized Context getInstance() {
        if (mInstance == null) {
            mInstance = this;
        }
        return mInstance;
    }

    public abstract int myView();
    public abstract void activityCreated();

}

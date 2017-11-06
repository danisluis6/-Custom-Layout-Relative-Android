package com.example.lorence.vel1.ui.activities;

import com.example.lorence.vel1.R;
import com.example.lorence.vel1.ui.BaseActivity;
import com.example.lorence.vel1.ui.activities.interfaces.IHomeScreen;

/**
 * Configure these folders in Project Android Studio
 * @Run: https://stackoverflow.com/questions/18071293/android-project-how-best-to-organize-the-files
 * => Done: Organize
 *
 * @Run: https://github.com/andreasschrade/android-design-template/blob/master/app/src/main/java/de/andreasschrade/androidtemplate/ui/base/BaseActivity.java
 * => Done: Configure BaseActivity
 *
 * @Run: https://developer.android.com/guide/topics/ui/declaring-layout.html
 * => home_screen.xml : Done
 *
 * @Run: https://stackoverflow.com/questions/3631982/change-applications-starting-activity
 * => ACTION_LAUNCH in AndroidManifest.xml
 *
 * @Run: https://www.google.com.vn/search?q=icon+level1&source=lnms&tbm=isch&sa=X&ved=0ahUKEwiZq5rDuKnXAhVLm5QKHQIAC-sQ_AUICigB&biw=1855&bih=966
 * => Change icon level1: DONE
 *
 * @Run: ui/views/...
 */

public class HomeScreen extends BaseActivity implements IHomeScreen {

    @Override
    public int myView() {
        return R.layout.home_screen;
    }

    @Override
    public void activityCreated() {

    }
}

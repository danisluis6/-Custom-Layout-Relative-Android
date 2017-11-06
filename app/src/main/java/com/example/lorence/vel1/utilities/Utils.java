package com.example.lorence.vel1.utilities;

import com.example.lorence.vel1.ui.BaseActivity;

/**
 *
 * Created by lorence on 06/11/2017.
 */

public class Utils {

    public static String makeLogTag(Class<BaseActivity> objActivityClass) {
        return objActivityClass.getSimpleName();
    }

}

/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.multiwindowplayground;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.multiwindowplayground.activities.AdjacentActivity;
import com.android.multiwindowplayground.activities.BasicActivity;
import com.android.multiwindowplayground.activities.CustomConfigurationChangeActivity;
import com.android.multiwindowplayground.activities.NotificationsActivity;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void onStartAdjacentActivity(View view) {
        Log.d(TAG, "** starting AdjacentActivity");

        /*
         * Start this activity adjacent to the focused activity (ie. this activity) if possible.
         * Note that this flag is just a hint to the system and may be ignored. For example,
         * if the activity is launched within the same task, it will be launched on top of the
         * previous activity that started the Intent. That's why the Intent.FLAG_ACTIVITY_NEW_TASK
         * flag is specified here in the intent - this will start the activity in a new task.
         */
        Intent intent = new Intent(this, AdjacentActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


    public void onStartBasicActivity(View view) {
        Log.d(TAG, "** starting BasicActivity");

        // Start an Activity with the default options in the 'singleTask' launch mode as defined in
        // the AndroidManifest.xml.
        startActivity(new Intent(this, BasicActivity.class));

    }

    public void onStartCustomConfigurationActivity(View view) {
        Log.d(TAG, "** starting CustomConfigurationChangeActivity");

        // Start an Activity that handles all configuration changes itself.
        startActivity(new Intent(this, CustomConfigurationChangeActivity.class));

    }

    public void onGenerateNotification(View view) {
        startActivity(new Intent(this, NotificationsActivity.class));
    }
}

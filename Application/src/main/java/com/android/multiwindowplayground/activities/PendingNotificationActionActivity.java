package com.android.multiwindowplayground.activities;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;

import com.android.multiwindowplayground.R;

public class PendingNotificationActionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generic_layout);
        NotificationManager notificationManager =
            (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(0);
    }
}

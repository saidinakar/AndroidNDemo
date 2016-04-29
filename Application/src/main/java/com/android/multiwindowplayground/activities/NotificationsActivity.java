package com.android.multiwindowplayground.activities;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Intent;
import android.os.Bundle;

import com.android.multiwindowplayground.MainActivity;
import com.android.multiwindowplayground.R;

public class NotificationsActivity extends Activity {

    // Key for the string that's delivered in the action's intent.
    private static final String KEY_TEXT_REPLY = "key_text_reply";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generic_layout);
        String replyLabel = getResources().getString(R.string.reply_label);
        RemoteInput remoteInput = new RemoteInput.Builder(KEY_TEXT_REPLY).setLabel(replyLabel).build();
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent replyPendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);
        Notification.Action action =
            new Notification.Action.Builder(R.mipmap.replyimage,
                getString(R.string.reply_label), replyPendingIntent)
                .addRemoteInput(remoteInput)
                .build();
        // Build the notification and add the action.
        Notification newMessageNotification =
            new Notification.Builder(getApplicationContext())
                .setSmallIcon(R.mipmap.message)
                .setContentTitle(getString(R.string.label))
                .setContentText(getString(R.string.content))
                .addAction(action).build();

// Issue the notification.
        NotificationManager notificationManager =
            (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, newMessageNotification);
    }
}

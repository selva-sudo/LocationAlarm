package com.selvaraj.locationalarm;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

/**
 * <p>Created by Selvaraj on 22/02/17.</p>
 */
public class App extends Application {

    public static final String PACKAGE = "com.Selvarajsstyl.locationreminder";
    public static final String ACTION_REMINDER_EDITED = "ACTION_REMINDER_EDITED";

    @Override
    public void onCreate() {
        super.onCreate();

    }

    public static void broadcastOnReminderCreated(Context context) {
        Intent intent = new Intent(ACTION_REMINDER_EDITED);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }
}

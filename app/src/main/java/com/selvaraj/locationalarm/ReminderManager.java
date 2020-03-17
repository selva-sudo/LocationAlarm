package com.selvaraj.locationalarm;

import android.content.Context;

/**
 * <p>Created by Selvaraj on 24/02/17.</p>
 */
final public class ReminderManager {

    private static ReminderManager sInstance;

    private Context mContext;

    private ReminderManager(Context context) {
        this.mContext = context.getApplicationContext();
    }


    public static ReminderManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new ReminderManager(context);
        }
        return sInstance;
    }

    public void cancelReminder(long id) {

    }
}

package com.selvaraj.locationalarm.ui.fragment;

import android.content.Context;

import com.selvaraj.locationalarm.R;

/**
 * <p>Created by Selvaraj on 24/02/17.</p>
 */
final public class AppConfigs {
    public static boolean setListOrderedByDistance(Context activity, boolean sortByDistance) {
        return activity.getSharedPreferences(activity.getString(R.string.file_userpreferences), Context.MODE_PRIVATE)
                .edit()
                .putBoolean(activity.getString(R.string.key_sort_order), sortByDistance).commit();
    }

    /**
     * Returns whether the reminder list needs to be sorted by dinstance or not
     * @param context
     * @return
     */
    public static boolean getListOrderedByDistance(Context context) {
        return context.getSharedPreferences(context.getString(R.string.file_userpreferences), Context.MODE_PRIVATE)
                .getBoolean(context.getString(R.string.key_sort_order), false);
    }
}

package com.selvaraj.locationalarm.ui.loader;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.selvaraj.locationalarm.App;
import com.selvaraj.locationalarm.db.DBHelper;
import com.selvaraj.locationalarm.entity.StoredReminder;
import com.selvaraj.locationalarm.ui.fragment.AppConfigs;
import com.selvaraj.locationalarm.util.DistanceComparator;

import java.util.ArrayList;
import java.util.Collections;

/**
 * <p>Created by Selvaraj on 21/02/17.</p>
 */
public class ReminderListLoader extends SimpleAsyncTaskLoader<ArrayList<StoredReminder>> {

    private EventEdited mReceiver;

    public ReminderListLoader(Context context) {
        super(context);
        mReceiver = new EventEdited();
        IntentFilter filter = new IntentFilter(App.ACTION_REMINDER_EDITED);
        getContext().registerReceiver(mReceiver, filter);
    }

    @Override
    protected void onAbandon() {
        super.onAbandon();
        getContext().unregisterReceiver(mReceiver);
    }

    @SuppressLint("MissingPermission")
    @Override
    public ArrayList<StoredReminder> loadInBackground() {

        ArrayList<StoredReminder> mList = DBHelper.getInstance(getContext()).getAllReminders();
        if (AppConfigs.getListOrderedByDistance(getContext())) {
            LocationManager manager = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);
            DistanceComparator.getInstance().setLastKnownLocation(manager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER));
            Collections.sort(mList, DistanceComparator.getInstance());
        } else {
            Collections.sort(mList);
        }

        return mList;
    }


    private class EventEdited extends BroadcastReceiver {


        public EventEdited() {
            IntentFilter filter = new IntentFilter();
            filter.addAction(App.ACTION_REMINDER_EDITED);
            LocalBroadcastManager.getInstance(getContext()).registerReceiver(this, filter);

        }

        @Override
        public void onReceive(Context context, Intent intent) {
            onContentChanged();
        }
    }


}

package com.selvaraj.locationalarm.util;

import android.location.Location;

import com.selvaraj.locationalarm.entity.StoredReminder;

import java.util.Comparator;

/**
 * <p>Created by Selvaraj on 24/02/17.</p>
 */
public class DistanceComparator implements Comparator<StoredReminder> {

    private static DistanceComparator sInstance;

    public static DistanceComparator getInstance() {
        if (sInstance == null) {
            sInstance = new DistanceComparator();
        }
        return sInstance;
    }

    private Location mLastLocation;


    @Override
    public int compare(StoredReminder lhs, StoredReminder rhs) {
        Location lloc = lhs.makeLocation();
        Location rloc = rhs.makeLocation();
        return (int) (lloc.distanceTo(mLastLocation) -
                        rloc.distanceTo(mLastLocation));
    }


    public void setLastKnownLocation(Location lastKnownLocation) {
        this.mLastLocation = lastKnownLocation;
    }
}

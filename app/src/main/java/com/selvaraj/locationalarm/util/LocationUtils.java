package com.selvaraj.locationalarm.util;

/**
 * <p>Created by Selvaraj on 23/02/17.</p>
 */
final public class LocationUtils {
    public static String createLocationString(double latitude, double longtitude) {
        return String.format("(%f, %f)", latitude, longtitude);
    }
}

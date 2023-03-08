package com.example.scouting_2023;

import android.os.Bundle;

public class BundleUtils {

    public static void resetBundleValues(final Bundle b) {
        int resetValue = 0;
        for (final bundleValues val : bundleValues.values()) {
            b.putInt(val.name(), resetValue);
        }
    }
}


package com.example.scouting_2023;

import android.os.Bundle;

public class BundleUtils {

    public static void resetBundleValues(final Bundle b) {
        for (final bundleValues val : bundleValues.values()) {
            switch (val) {

                //case AUTO_LINE:
             /*   case FinalWinCheck:
                    //case TELEOP_SPIN:
                case TeleOpColorCheck:
                    b.putBoolean(val.toString(), false);
                    break;
                //case AUTO_POWERCELL_INNER:
                //case AUTO_POWERCELL_LOWER:
                //case AUTO_POWERCELL_OUTER:
                //case STARTUP_BALLS:
                case BasicRoundNum:
                case BasicTeamNum:
                case TeleOpLowerTicker:
                case TeleOpUpperTicker:
                    //case TELEOP_OUTER_BALLS:
                    //case TELEOP_STAGE_LEVEL:
                    b.putInt(val.toString(), 0);
                    break;
                case BasicColorDropdown:
                    b.putString(val.toString(), TeamColors.BLUE.toString());
                    break;
                case TeleOpHeightDropdown:
                    b.putString(val.toString(), BarGrabPosition.NONE.getLabel());
                    break;

              */
            }
        }
    }
}

package com.kwad.components.core.s;

import BPw6Q8.ASJ6gh;
import android.content.Context;
import android.location.LocationManager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class o {
    public static boolean aH(Context context) {
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            if (locationManager != null) {
                if (locationManager.isProviderEnabled("gps")) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private static boolean aI(Context context) {
        try {
            if (ASJ6gh.A2egSU(context, com.kuaishou.weapon.p0.g.g) != 0) {
                return ASJ6gh.A2egSU(context, com.kuaishou.weapon.p0.g.h) == 0;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}

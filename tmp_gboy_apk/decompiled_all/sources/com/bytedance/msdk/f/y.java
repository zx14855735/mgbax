package com.bytedance.msdk.f;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y {
    private static Handler hf = new Handler(Looper.getMainLooper());
    private static long xj = 1800000;

    public static class xj implements Callable<Location> {
        private String hf;
        private LocationManager xj;

        public xj(LocationManager locationManager, String str) {
            this.xj = locationManager;
            this.hf = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Location call() {
            long currentTimeMillis = System.currentTimeMillis();
            Location lastKnownLocation = this.xj.getLastKnownLocation(this.hf);
            com.bytedance.msdk.xj.kd.w.xj("AdLocationUtils", "location:" + lastKnownLocation + ",getLastKnownLocation use time :" + (System.currentTimeMillis() - currentTimeMillis));
            return lastKnownLocation;
        }
    }

    static {
        iWZhC();
    }

    private static boolean hf(Context context) {
        long hf2 = ai.xj((String) null, context).hf("lbstime", -1L);
        return hf2 == -1 || System.currentTimeMillis() - hf2 > xj;
    }

    private static /* synthetic */ void iWZhC() {
        char[] charArray = "mac iock law }fkbb D`gL|gjik".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 14);
        }
        String str = new String(charArray);
        char[] charArray2 = "mbg`gz".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 14);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static kd u(final Context context) {
        final LocationManager locationManager = (LocationManager) context.getSystemService("location");
        kd kdVar = null;
        if (locationManager != null) {
            try {
                Location xj2 = xj(locationManager);
                if (xj2 != null && hf(xj2)) {
                    hf(context, xj2);
                    kdVar = new kd((float) xj2.getLatitude(), (float) xj2.getLongitude());
                }
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.msdk.f.y.1
                        @Override // java.lang.Runnable
                        public void run() {
                            y.hf(context, locationManager);
                        }
                    });
                    return kdVar;
                }
                hf(context, locationManager);
                return kdVar;
            } catch (Throwable th) {
                if (com.bytedance.msdk.xj.kd.w.hf()) {
                    com.bytedance.sdk.component.utils.pl.xj(th);
                }
            }
        }
        return null;
    }

    private static kd w(Context context) {
        ai xj2 = ai.xj((String) null, context);
        float hf2 = xj2.hf("latitude", -1.0f);
        float hf3 = xj2.hf("longitude", -1.0f);
        if (hf2 == -1.0f || hf3 == -1.0f) {
            return null;
        }
        return new kd(hf2, hf3);
    }

    private static String hf(LocationManager locationManager) {
        if (locationManager.isProviderEnabled("gps")) {
            return "gps";
        }
        if (locationManager.isProviderEnabled("network")) {
            return "network";
        }
        if (locationManager.isProviderEnabled("passive")) {
            return "passive";
        }
        return null;
    }

    public static kd xj(Context context) {
        if (!com.bytedance.msdk.core.xj.p().ra().xj()) {
            return null;
        }
        Context context2 = context == null ? com.bytedance.msdk.core.hf.getContext() : context.getApplicationContext();
        if (context2 == null) {
            return null;
        }
        kd w = w(context2);
        if (!hf(context2)) {
            return w;
        }
        int xj2 = com.bytedance.msdk.core.pl.w.xj(context2, com.kuaishou.weapon.p0.g.g);
        int xj3 = com.bytedance.msdk.core.pl.w.xj(context2, com.kuaishou.weapon.p0.g.h);
        if (xj2 == 0 || xj3 == 0) {
            return u(context2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(final Context context, final LocationManager locationManager) {
        if (context == null || locationManager == null) {
            return;
        }
        final LocationListener locationListener = new LocationListener() { // from class: com.bytedance.msdk.f.y.2
            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                if (location != null && y.hf(location)) {
                    y.hf(context, location);
                }
                y.hf(locationManager, this);
            }

            @Override // android.location.LocationListener
            public void onProviderDisabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onProviderEnabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onStatusChanged(String str, int i, Bundle bundle) {
            }
        };
        try {
            String hf2 = hf(locationManager);
            if (TextUtils.isEmpty(hf2)) {
                return;
            }
            locationManager.requestSingleUpdate(hf2, locationListener, Looper.getMainLooper());
            hf.postDelayed(new Runnable() { // from class: com.bytedance.msdk.f.y.3
                @Override // java.lang.Runnable
                public void run() {
                    y.hf(locationManager, locationListener);
                }
            }, 30000L);
        } catch (Throwable th) {
            if (com.bytedance.msdk.xj.kd.w.hf()) {
                com.bytedance.sdk.component.utils.pl.xj(th);
            }
            hf(locationManager, locationListener);
        }
    }

    private static Location xj(LocationManager locationManager) {
        Location xj2 = xj(locationManager, "gps");
        if (xj2 == null) {
            xj2 = xj(locationManager, "network");
        }
        return xj2 == null ? xj(locationManager, "passive") : xj2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(LocationManager locationManager, LocationListener locationListener) {
        if (locationManager == null || locationListener == null) {
            return;
        }
        try {
            locationManager.removeUpdates(locationListener);
        } catch (Throwable th) {
            if (com.bytedance.msdk.xj.kd.w.hf()) {
                com.bytedance.sdk.component.utils.pl.xj(th);
            }
        }
    }

    private static Location xj(LocationManager locationManager, String str) {
        try {
            FutureTask futureTask = new FutureTask(new xj(locationManager, str));
            com.bytedance.msdk.xj.kd.y.u(futureTask);
            Location location = (Location) futureTask.get(1L, TimeUnit.SECONDS);
            com.bytedance.msdk.xj.kd.w.xj("AdLocationUtils", "location:".concat(String.valueOf(location)));
            return location;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(Context context, Location location) {
        if (hf(location)) {
            ai xj2 = ai.xj((String) null, context);
            xj2.xj("latitude", (float) location.getLatitude());
            xj2.xj("longitude", (float) location.getLongitude());
            xj2.xj("lbstime", System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hf(Location location) {
        return (location.getLatitude() == 0.0d || location.getLongitude() == 0.0d) ? false : true;
    }
}

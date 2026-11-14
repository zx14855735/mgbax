package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u {
    private static long hf = 60000;
    private static volatile long kd = 0;
    private static volatile long u = 0;
    private static volatile w w = null;
    private static long xj = 1800000;

    public static class hf implements Callable<Location> {
        private String hf;
        private LocationManager xj;

        public hf(LocationManager locationManager, String str) {
            this.xj = locationManager;
            this.hf = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Location call() {
            System.currentTimeMillis();
            Location lastKnownLocation = this.xj.getLastKnownLocation(this.hf);
            System.currentTimeMillis();
            return lastKnownLocation;
        }
    }

    public static class xj implements Callable<com.bytedance.sdk.openadsdk.zg.w.w.w> {
        private xj() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.bytedance.sdk.openadsdk.zg.w.w.w call() {
            return com.bytedance.sdk.openadsdk.core.f.zg().e().d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static w kd(final Context context) {
        w wVar = null;
        if (!com.bytedance.sdk.openadsdk.core.f.zg().e().xj()) {
            try {
                com.bytedance.sdk.openadsdk.zg.w.w.w w2 = w();
                if (w2 != null) {
                    return new w(Double.valueOf(w2.xj()).floatValue(), Double.valueOf(w2.hf()).floatValue(), System.currentTimeMillis());
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        final LocationManager y = y(context);
        if (y != null) {
            try {
                Location xj2 = xj(y);
                if (xj2 != null && hf(xj2)) {
                    wVar = new w((float) xj2.getLatitude(), (float) xj2.getLongitude(), System.currentTimeMillis());
                }
                com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.u.4
                    @Override // java.lang.Runnable
                    public void run() {
                        u.hf(context, y);
                    }
                });
                return wVar;
            } catch (Throwable th) {
                if (com.bytedance.sdk.component.utils.pl.w()) {
                    com.bytedance.sdk.component.utils.pl.xj(th);
                }
            }
        }
        return wVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void u(final Context context) {
        com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d("getLocation c") { // from class: com.bytedance.sdk.openadsdk.core.a.u.3
            @Override // java.lang.Runnable
            public void run() {
                Context context2 = context;
                w kd2 = u.kd(context2 == null ? com.bytedance.sdk.openadsdk.core.pz.getContext() : context2.getApplicationContext());
                long unused = u.u = 0L;
                if (kd2 != null) {
                    w unused2 = u.w = kd2;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("latitude", Float.toString(kd2.xj));
                        jSONObject.put("longitude", Float.toString(kd2.hf));
                        jSONObject.put("lbstime", kd2.w);
                        String jSONObject2 = jSONObject.toString();
                        String hf2 = com.bytedance.sdk.component.utils.xj.hf(jSONObject2);
                        com.bytedance.sdk.openadsdk.core.w.u.xj().u("sdk_ad_location", jSONObject2);
                        com.bytedance.sdk.openadsdk.core.w.u.xj().u("new_sdk_ad_location", hf2);
                    } catch (JSONException e) {
                        com.bytedance.sdk.component.utils.pl.xj(e);
                    }
                }
            }
        });
    }

    private static LocationManager y(Context context) {
        try {
            return (LocationManager) context.getSystemService("location");
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean hf() {
        return System.currentTimeMillis() - u > hf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static com.bytedance.sdk.openadsdk.zg.w.w.w w() {
        try {
            final com.bytedance.sdk.component.tf.f fVar = new com.bytedance.sdk.component.tf.f(new xj(), 1, 2);
            com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d("getLastKnownLocation") { // from class: com.bytedance.sdk.openadsdk.core.a.u.6
                @Override // java.lang.Runnable
                public void run() {
                    fVar.run();
                }
            });
            return (com.bytedance.sdk.openadsdk.zg.w.w.w) fVar.get(1L, TimeUnit.SECONDS);
        } catch (Throwable unused) {
            return null;
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(Context context, final LocationManager locationManager) {
        if (context == null || locationManager == null) {
            return;
        }
        final LocationListener locationListener = new LocationListener() { // from class: com.bytedance.sdk.openadsdk.core.a.u.7
            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                if (location != null) {
                    u.hf(location);
                }
                u.hf(locationManager, this);
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
            if (TextUtils.isEmpty(hf(locationManager))) {
                return;
            }
            locationManager.requestSingleUpdate("network", locationListener, Looper.myLooper());
            com.bytedance.sdk.component.utils.f.xj().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.u.8
                @Override // java.lang.Runnable
                public void run() {
                    u.hf(locationManager, locationListener);
                }
            }, 30000L);
        } catch (Throwable th) {
            if (com.bytedance.sdk.component.utils.pl.w()) {
                com.bytedance.sdk.component.utils.pl.xj(th);
            }
            hf(locationManager, locationListener);
        }
    }

    public static com.bytedance.sdk.component.u.xj.w xj(Context context) {
        return xj(context, !com.bytedance.sdk.openadsdk.core.w.xj.hf());
    }

    public static w xj(final Context context, boolean z) {
        if ((w != null && !xj()) || !hf()) {
            return w;
        }
        String w2 = com.bytedance.sdk.component.utils.xj.w(com.bytedance.sdk.openadsdk.core.w.u.xj().u("new_sdk_ad_location", 2147483647L));
        if (w2 != null) {
            try {
                JSONObject jSONObject = new JSONObject(w2);
                String optString = jSONObject.optString("latitude");
                String optString2 = jSONObject.optString("longitude");
                long optLong = jSONObject.optLong("lbstime");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    w = new w(Float.valueOf(optString).floatValue(), Float.valueOf(optString2).floatValue(), optLong);
                    kd = optLong;
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.pl.xj(th);
            }
            if (z) {
                return w;
            }
        }
        if (w != null && !xj()) {
            return w;
        }
        com.bytedance.sdk.openadsdk.zg.w.w.u e = com.bytedance.sdk.openadsdk.core.f.zg().e();
        if (!e.xj()) {
            com.bytedance.sdk.openadsdk.zg.w.w.w d = e.d();
            if (d != null) {
                kd = System.currentTimeMillis();
                w = new w((float) d.xj(), (float) d.hf(), System.currentTimeMillis());
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                if (w != null) {
                    jSONObject2.put("latitude", Float.toString(w.xj));
                    jSONObject2.put("longitude", Float.toString(w.hf));
                    jSONObject2.put("lbstime", w.w);
                }
                String jSONObject3 = jSONObject2.toString();
                String hf2 = com.bytedance.sdk.component.utils.xj.hf(jSONObject3);
                com.bytedance.sdk.openadsdk.core.w.u.xj().u("sdk_ad_location", jSONObject3);
                com.bytedance.sdk.openadsdk.core.w.u.xj().u("new_sdk_ad_location", hf2);
            } catch (Exception e2) {
                com.bytedance.sdk.component.utils.pl.xj(e2);
            }
            return w;
        }
        kd = System.currentTimeMillis();
        u = System.currentTimeMillis();
        if (com.bytedance.sdk.openadsdk.core.u.xj.f()) {
            new com.bytedance.sdk.openadsdk.core.u.hf("device_locate").xj(5).xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.u.2
                @Override // java.lang.Runnable
                public void run() {
                    long unused = u.u = 0L;
                }
            }).hf(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.u.1
                @Override // java.lang.Runnable
                public void run() {
                    u.u(context);
                }
            });
        } else {
            u(context);
        }
        return w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(LocationManager locationManager, LocationListener locationListener) {
        if (locationManager == null || locationListener == null) {
            return;
        }
        try {
            locationManager.removeUpdates(locationListener);
        } catch (Throwable th) {
            if (com.bytedance.sdk.component.utils.pl.w()) {
                com.bytedance.sdk.component.utils.pl.xj(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hf(Location location) {
        return (location.getLatitude() == 0.0d || location.getLongitude() == 0.0d) ? false : true;
    }

    private static boolean xj() {
        return System.currentTimeMillis() - kd > xj;
    }

    private static Location xj(LocationManager locationManager) {
        Location xj2 = xj(locationManager, "gps");
        if (xj2 == null) {
            xj2 = xj(locationManager, "network");
        }
        return xj2 == null ? xj(locationManager, "passive") : xj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Location xj(LocationManager locationManager, String str) {
        try {
            final com.bytedance.sdk.component.tf.f fVar = new com.bytedance.sdk.component.tf.f(new hf(locationManager, str), 1, 2);
            com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d("getLastKnownLocation") { // from class: com.bytedance.sdk.openadsdk.core.a.u.5
                @Override // java.lang.Runnable
                public void run() {
                    fVar.run();
                }
            });
            return (Location) fVar.get(1L, TimeUnit.SECONDS);
        } catch (Throwable unused) {
            return null;
        }
    }
}

package com.bytedance.sdk.component.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class et {
    private static final Object xj = new Object();
    private static final Map<xj, Object> hf = new ConcurrentHashMap();
    private static AtomicBoolean w = new AtomicBoolean(false);
    private static volatile int u = -1;
    private static volatile long kd = 0;
    private static volatile int y = BaseConstants.Time.MINUTE;
    private static qt c = null;
    private static final AtomicBoolean f = new AtomicBoolean(false);

    public static class hf extends BroadcastReceiver {
        private hf() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = false;
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            if (et.hf != null && et.hf.size() > 0) {
                z = true;
            }
            et.hf(context, intent, z, booleanExtra);
        }
    }

    public interface xj {
        void xj(Context context, Intent intent, boolean z, int i);
    }

    static {
        cMHE();
    }

    private static /* synthetic */ void cMHE() {
        char[] charArray = "åéë¨áçëã¨äéÿ¨õîãêê¨ÌèïÄôïâáã".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 134);
        }
        String str = new String(charArray);
        char[] charArray2 = "åêïèïò".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 134);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(final Context context, final Intent intent, final boolean z, final boolean z2) {
        if (!z && z2) {
            u = 0;
        } else if (f.compareAndSet(false, true)) {
            com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d("getNetworkType") { // from class: com.bytedance.sdk.component.utils.et.1
                @Override // java.lang.Runnable
                public void run() {
                    int unused = et.u = z2 ? 0 : et.hf(context);
                    if (z) {
                        et.hf(context, intent, et.u, z2);
                    }
                    et.f.set(false);
                }
            });
        }
    }

    private static int w(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    return type != 1 ? 1 : 4;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return 3;
                    case 13:
                    case 18:
                    case 19:
                        qt qtVar = c;
                        return (qtVar == null || !qtVar.xj(context, telephonyManager)) ? 5 : 6;
                    case 20:
                        return 6;
                    default:
                        String subtypeName = activeNetworkInfo.getSubtypeName();
                        return (TextUtils.isEmpty(subtypeName) || !(subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000"))) ? 1 : 3;
                }
            }
            return 0;
        } catch (Throwable unused) {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(Context context, Intent intent, int i, boolean z) {
        Map<xj, Object> map = hf;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (xj xjVar : map.keySet()) {
            if (xjVar != null) {
                xjVar.xj(context, intent, !z, i);
            }
        }
    }

    public static void xj(qt qtVar) {
        c = qtVar;
    }

    public static int xj(Context context, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (kd + j <= elapsedRealtime) {
            return hf(context);
        }
        if (u == -1) {
            return hf(context);
        }
        if (elapsedRealtime - kd >= y) {
            hf(context, (Intent) null, false, false);
        }
        return u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int hf(Context context) {
        u = w(context);
        kd = SystemClock.elapsedRealtime();
        return u;
    }

    public static void xj(xj xjVar, Context context) {
        if (xjVar == null) {
            return;
        }
        if (!w.get()) {
            try {
                context.registerReceiver(new hf(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                w.set(true);
            } catch (Throwable unused) {
            }
        }
        hf.put(xjVar, xj);
    }

    public static void xj(xj xjVar) {
        if (xjVar == null) {
            return;
        }
        hf.remove(xjVar);
    }
}

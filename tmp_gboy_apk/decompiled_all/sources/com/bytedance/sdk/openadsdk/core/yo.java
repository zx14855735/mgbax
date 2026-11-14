package com.bytedance.sdk.openadsdk.core;

import BPw6Q8.AMqCpz;
import android.annotation.SuppressLint;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class yo {

    /* renamed from: a, reason: collision with root package name */
    private static volatile long f10465a = 0;
    private static volatile boolean ai = false;
    private static volatile String am = null;
    private static volatile WifiManager b = null;
    private static volatile String c = null;
    private static volatile String d = null;
    private static volatile boolean dk = false;
    private static volatile String e = null;
    private static volatile boolean en = false;
    private static volatile boolean et = false;
    private static volatile String ff = null;
    private static volatile String g = null;
    private static volatile String hf = "";
    private static volatile boolean ht;

    /* renamed from: io, reason: collision with root package name */
    private static volatile boolean f10466io;
    private static volatile boolean j;
    private static volatile String kd;
    private static volatile boolean q;
    private static volatile String qt;
    private static volatile TelephonyManager r;
    private static volatile boolean ra;
    private static volatile String u;
    private static volatile String v;
    private static volatile String w;
    private static volatile boolean wo;
    private static volatile WifiInfo ws;
    private static volatile boolean x;
    private static String xj;
    private static volatile String y;
    private static volatile String yo;
    private static volatile boolean z;
    private static volatile String zg;
    private static AtomicBoolean f = new AtomicBoolean(false);
    private static volatile String tf = "";
    private static volatile String p = "";

    /* renamed from: pl, reason: collision with root package name */
    private static volatile boolean f10467pl = true;
    private static volatile String jk = null;
    private static AtomicBoolean pz = new AtomicBoolean(false);
    private static AtomicBoolean l = new AtomicBoolean(false);

    static {
        SJqAEnv();
    }

    private static /* synthetic */ void SJqAEnv() {
        char[] charArray = "^RP\u0013Z\\PX\u0013_RD\u0013NUXQQ\u0013wST\u007fOTYZX".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '=');
        }
        String str = new String(charArray);
        char[] charArray2 = "^QTSTI".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '=');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static String a() {
        String str = null;
        try {
            String w2 = com.bytedance.sdk.openadsdk.core.w.u.xj().w("new_mac_address", "");
            if (!TextUtils.isEmpty(w2)) {
                JSONObject jSONObject = new JSONObject(w2);
                long j2 = jSONObject.getLong("time");
                str = com.bytedance.sdk.component.utils.xj.w(jSONObject.getString("value"));
                if (System.currentTimeMillis() - j2 <= 864000000) {
                    if (!TextUtils.isEmpty(str)) {
                        return str;
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (com.bytedance.sdk.openadsdk.core.u.xj.f()) {
            if (!TextUtils.isEmpty(jk)) {
                str = jk;
            }
            if (!TextUtils.isEmpty(str)) {
                if (!pz.get()) {
                    new com.bytedance.sdk.openadsdk.core.u.hf("device_get_macaddress").xj(5).xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.yo.6
                        @Override // java.lang.Runnable
                        public void run() {
                            yo.pz.set(false);
                        }
                    }).hf(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.yo.5
                        @Override // java.lang.Runnable
                        public void run() {
                            yo.pz.set(false);
                            yo.l();
                        }
                    });
                }
                pz.set(true);
                return str;
            }
        }
        l();
        return jk;
    }

    private static String ai() {
        WifiInfo hf2;
        if (et) {
            return y;
        }
        synchronized (yo.class) {
            if (et) {
                return y;
            }
            try {
                hf2 = hf();
            } catch (Throwable unused) {
            }
            if (hf2 == null) {
                return y;
            }
            y = hf2.getSSID();
            et = true;
            return y;
        }
    }

    public static String am() {
        z();
        return am;
    }

    public static String c() {
        if (!TextUtils.isEmpty(c) || f10466io) {
            return c;
        }
        if (f.get()) {
            return null;
        }
        f.set(true);
        com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d("") { // from class: com.bytedance.sdk.openadsdk.core.yo.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.a.tf.d();
                yo.f.set(false);
            }
        });
        return null;
    }

    public static String d() {
        if (!com.bytedance.sdk.openadsdk.core.u.xj.f()) {
            return u("02:00:00:00:00:00");
        }
        new com.bytedance.sdk.openadsdk.core.u.hf("device_get_bssid").xj(3).hf(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.yo.4
            @Override // java.lang.Runnable
            public void run() {
                String unused = yo.c = yo.u("02:00:00:00:00:00");
            }
        });
        return TextUtils.isEmpty(c) ? "02:00:00:00:00:00" : c;
    }

    private static WifiManager dk() {
        if (b != null) {
            return b;
        }
        synchronized (yo.class) {
            try {
                if (b != null) {
                    return b;
                }
                b = (WifiManager) pz.getContext().getApplicationContext().getSystemService("wifi");
                return b;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String e() {
        z();
        return e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
    
        if (r2.length() < 13) goto L17;
     */
    @android.annotation.SuppressLint({"TrulyRandom", "HardwareIds"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static synchronized java.lang.String en() {
        /*
            java.lang.Class<com.bytedance.sdk.openadsdk.core.yo> r0 = com.bytedance.sdk.openadsdk.core.yo.class
            monitor-enter(r0)
            android.content.Context r1 = com.bytedance.sdk.openadsdk.core.pz.getContext()     // Catch: java.lang.Throwable -> L1a
            r2 = 0
            if (r1 != 0) goto Lc
            monitor-exit(r0)
            return r2
        Lc:
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            java.lang.String r3 = "android_id"
            java.lang.String r2 = android.provider.Settings.Secure.getString(r1, r3)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            r1 = 1
            com.bytedance.sdk.openadsdk.core.yo.ht = r1     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            goto L1c
        L1a:
            r1 = move-exception
            goto L2e
        L1c:
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L1a
            if (r1 != 0) goto L2a
            int r1 = r2.length()     // Catch: java.lang.Throwable -> L1a
            r3 = 13
            if (r1 >= r3) goto L2c
        L2a:
            java.lang.String r2 = ""
        L2c:
            monitor-exit(r0)
            return r2
        L2e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1a
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.yo.en():java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void et() {
        synchronized (yo.class) {
            try {
                if (ht) {
                    return;
                }
                u = en();
                com.bytedance.sdk.openadsdk.tools.hf.hf(9, u);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String f() {
        String serial;
        com.bytedance.sdk.openadsdk.zg.w.w.u e2 = f.zg().e();
        if (e2 != null && !e2.w()) {
            return null;
        }
        if (!TextUtils.isEmpty(v)) {
            return v;
        }
        if (j) {
            return v;
        }
        synchronized (yo.class) {
            try {
                if (j) {
                    return v;
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    try {
                        serial = Build.getSerial();
                        v = serial;
                    } catch (Throwable unused) {
                    }
                } else {
                    v = Build.SERIAL;
                }
                j = true;
                return v;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static String ff() {
        if (en) {
            return jk;
        }
        synchronized (yo.class) {
            try {
                if (en) {
                    return jk;
                }
                jk = a();
                en = true;
                return jk;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String g() {
        try {
            z();
            if (!TextUtils.isEmpty(g)) {
                return g;
            }
            if (!xj(f10465a, 60000L)) {
                return ff;
            }
            if (!pl()) {
                return null;
            }
            int i = pz.getContext().getResources().getConfiguration().mcc;
            String valueOf = i != 0 ? String.valueOf(i) : g;
            ff = valueOf;
            f10465a = System.currentTimeMillis();
            return valueOf;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void io() {
        String imei;
        synchronized (yo.class) {
            try {
                if (ra) {
                    return;
                }
                if (dk) {
                    return;
                }
                if (com.bytedance.sdk.openadsdk.core.io.hf.xj(pz.getContext(), com.kuaishou.weapon.p0.g.c) == 0) {
                    dk = true;
                    TelephonyManager xj2 = xj();
                    if (xj2 == null) {
                        return;
                    }
                    try {
                        if (Build.VERSION.SDK_INT >= 26) {
                            imei = xj2.getImei();
                            kd = imei;
                        } else {
                            kd = xj2.getDeviceId();
                        }
                    } catch (Throwable unused) {
                    }
                    ra = true;
                    com.bytedance.sdk.openadsdk.tools.hf.hf(6, kd);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static synchronized void j() {
        int activeSubscriptionInfoCount;
        List activeSubscriptionInfoList;
        int mcc;
        String valueOf;
        int mnc;
        String valueOf2;
        synchronized (yo.class) {
            if (wo) {
                return;
            }
            if (Build.VERSION.SDK_INT < 22) {
                return;
            }
            synchronized (yo.class) {
                wo = true;
                SubscriptionManager ASJ6gh2 = AMqCpz.ASJ6gh(pz.getContext().getSystemService("telephony_subscription_service"));
                activeSubscriptionInfoCount = ASJ6gh2.getActiveSubscriptionInfoCount();
                if (activeSubscriptionInfoCount < 2) {
                    return;
                }
                activeSubscriptionInfoList = ASJ6gh2.getActiveSubscriptionInfoList();
                if (activeSubscriptionInfoList.size() < 2) {
                    return;
                }
                for (int i = 0; i < 2; i++) {
                    SubscriptionInfo ARc23Z2 = AMqCpz.ARc23Z(activeSubscriptionInfoList.get(i));
                    if (Build.VERSION.SDK_INT >= 29) {
                        valueOf = ARc23Z2.getMccString();
                        valueOf2 = ARc23Z2.getMncString();
                    } else {
                        mcc = ARc23Z2.getMcc();
                        valueOf = String.valueOf(mcc);
                        mnc = ARc23Z2.getMnc();
                        valueOf2 = String.valueOf(mnc);
                    }
                    if (i == 0) {
                        if (!TextUtils.isEmpty(valueOf)) {
                            g = valueOf;
                        }
                        if (!TextUtils.isEmpty(valueOf2)) {
                            qt = valueOf2;
                        }
                    } else {
                        if (!TextUtils.isEmpty(valueOf)) {
                            am = valueOf;
                        }
                        if (!TextUtils.isEmpty(valueOf2)) {
                            zg = valueOf2;
                        }
                    }
                }
            }
        }
    }

    public static boolean kd() {
        return ht;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        String kd2 = kd("wlan0");
        if (TextUtils.isEmpty(kd2)) {
            kd2 = kd("eth0");
        }
        if (TextUtils.isEmpty(kd2)) {
            kd2 = "DU:MM:YA:DD:RE:SS";
        }
        com.bytedance.sdk.openadsdk.core.w.u.xj().u("mac_address", kd2);
        com.bytedance.sdk.openadsdk.core.w.u.xj().u("new_mac_address", com.bytedance.sdk.component.utils.xj.hf(kd2));
        jk = kd2;
    }

    public static String p() {
        com.bytedance.sdk.openadsdk.zg.w.w.u e2 = f.zg().e();
        if (e2 != null && !e2.w()) {
            return "";
        }
        if (!TextUtils.isEmpty(tf)) {
            return tf;
        }
        if (ai) {
            return tf;
        }
        synchronized (yo.class) {
            try {
                if (ai) {
                    return tf;
                }
                TelephonyManager xj2 = xj();
                if (xj2 == null) {
                    return tf;
                }
                try {
                    tf = xj2.getSimOperator();
                } catch (Throwable unused) {
                }
                ai = true;
                return tf;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean pl() {
        if (q) {
            return f10467pl;
        }
        synchronized (yo.class) {
            if (q) {
                return f10467pl;
            }
            try {
                int simState = xj().getSimState();
                if (1 == simState) {
                    f10467pl = false;
                }
                if (simState == 0) {
                    f10467pl = false;
                }
                q = true;
            } catch (Throwable unused) {
            }
            return f10467pl;
        }
    }

    private static String q() {
        if (f10466io) {
            return c;
        }
        synchronized (yo.class) {
            try {
                if (f10466io) {
                    return c;
                }
                c = d();
                f10466io = true;
                return c;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String qt() {
        z();
        return qt;
    }

    public static void tf() {
        TelephonyManager xj2;
        String imei;
        if (dk) {
            return;
        }
        com.bytedance.sdk.openadsdk.zg.w.w.u e2 = f.zg().e();
        if ((e2 == null || e2.w()) && com.bytedance.sdk.openadsdk.core.io.hf.xj(pz.getContext(), com.kuaishou.weapon.p0.g.c) == 0 && (xj2 = xj()) != null) {
            synchronized (yo.class) {
                try {
                    dk = true;
                    if (TextUtils.isEmpty(kd)) {
                        try {
                            if (Build.VERSION.SDK_INT >= 26) {
                                imei = xj2.getImei();
                                kd = imei;
                            } else {
                                kd = xj2.getDeviceId();
                            }
                        } catch (Throwable unused) {
                        }
                        com.bytedance.sdk.openadsdk.tools.hf.hf(6, kd);
                    }
                    if (TextUtils.isEmpty(d)) {
                        try {
                            d = xj2.getSubscriberId();
                        } catch (Throwable unused2) {
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static String u() {
        if (!TextUtils.isEmpty(yo)) {
            return yo;
        }
        String valueOf = String.valueOf(Build.TIME);
        yo = valueOf;
        return valueOf;
    }

    private static String x() {
        if (x) {
            return d;
        }
        synchronized (yo.class) {
            try {
                if (x) {
                    return d;
                }
                if (dk) {
                    return kd;
                }
                TelephonyManager xj2 = xj();
                if (xj2 == null) {
                    return d;
                }
                try {
                    d = xj2.getSubscriberId();
                } catch (Throwable unused) {
                }
                x = true;
                return d;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static TelephonyManager xj() {
        if (r != null) {
            return r;
        }
        synchronized (yo.class) {
            try {
                if (r != null) {
                    return r;
                }
                r = (TelephonyManager) pz.getContext().getSystemService("phone");
                return r;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String y() {
        if (!TextUtils.isEmpty(u)) {
            return u;
        }
        com.bytedance.sdk.openadsdk.zg.w.w.u e2 = f.zg().e();
        if (e2 != null && ai.w >= 4600 && !e2.y()) {
            if (ai.w >= 4900) {
                return e2.am();
            }
            return null;
        }
        if (ht) {
            return u;
        }
        if (com.bytedance.sdk.openadsdk.core.u.xj.f()) {
            String c2 = com.bytedance.sdk.openadsdk.core.w.u.xj().c();
            if (!TextUtils.isEmpty(c2)) {
                u = c2;
                new com.bytedance.sdk.openadsdk.core.u.hf("device_get_android_id").xj(5).hf(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.yo.1
                    @Override // java.lang.Runnable
                    public void run() {
                        yo.et();
                    }
                });
                return u;
            }
        }
        et();
        return u;
    }

    public static String yo() {
        if (!TextUtils.isEmpty(hf)) {
            return hf;
        }
        String xj2 = com.bytedance.sdk.component.utils.dk.xj();
        hf = xj2;
        return xj2;
    }

    private static void z() {
        String str;
        String str2;
        String str3;
        if (z) {
            return;
        }
        synchronized (yo.class) {
            try {
                if (z) {
                    return;
                }
                TelephonyManager xj2 = xj();
                String str4 = null;
                try {
                    str = xj2.getNetworkOperator();
                } catch (Throwable unused) {
                    str = null;
                }
                if (TextUtils.isEmpty(str) || str.length() < 5) {
                    str = p();
                }
                try {
                    str2 = xj2.getSimOperatorName();
                } catch (Throwable unused2) {
                    str2 = null;
                }
                if (TextUtils.isEmpty(str) || str.length() <= 4) {
                    str3 = null;
                } else {
                    str4 = str.substring(0, 3);
                    str3 = str.substring(3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    g = str4;
                }
                if (!TextUtils.isEmpty(str3)) {
                    qt = str3;
                }
                if (!TextUtils.isEmpty(str2)) {
                    e = str2;
                }
                try {
                    j();
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.pl.xj(th);
                }
                z = true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static String zg() {
        z();
        return zg;
    }

    public static WifiInfo hf() {
        com.bytedance.sdk.openadsdk.zg.w.w.u e2 = f.zg().e();
        if (e2 != null && (!e2.u() || !e2.xj())) {
            return ws;
        }
        if (ws != null) {
            return ws;
        }
        synchronized (yo.class) {
            try {
                if (ws != null) {
                    return ws;
                }
                WifiManager dk2 = dk();
                if (dk2 == null) {
                    return ws;
                }
                ws = dk2.getConnectionInfo();
                return ws;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String kd(Boolean bool) {
        if (!TextUtils.isEmpty(jk)) {
            return jk;
        }
        com.bytedance.sdk.openadsdk.zg.w.w.u e2 = f.zg().e();
        if (bool == null) {
            if (e2 != null && !e2.u()) {
                return e2.p();
            }
        } else {
            if (en) {
                return jk;
            }
            if (e2 != null && !bool.booleanValue()) {
                return e2.p();
            }
        }
        return ff();
    }

    public static String w() {
        if (!TextUtils.isEmpty(w)) {
            return w;
        }
        String str = hf.xj().get("did", xj);
        w = str;
        return str;
    }

    public static String u(Boolean bool) {
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        if (bool == null) {
            com.bytedance.sdk.openadsdk.zg.w.w.u e2 = f.zg().e();
            if (e2 != null && (!e2.u() || !e2.xj())) {
                return null;
            }
        } else {
            if (f10466io) {
                return c;
            }
            if (bool.booleanValue()) {
                return null;
            }
        }
        return q();
    }

    public static String w(Boolean bool) {
        if (!TextUtils.isEmpty(y)) {
            return y;
        }
        if (bool == null) {
            com.bytedance.sdk.openadsdk.zg.w.w.u e2 = f.zg().e();
            if (e2 != null && (!e2.u() || !e2.xj())) {
                return null;
            }
        } else {
            if (et) {
                return y;
            }
            if (bool.booleanValue()) {
                return null;
            }
        }
        return ai();
    }

    public static void xj(String str) {
        if (com.bytedance.sdk.openadsdk.xj.xj.xj.xj() != null) {
            com.bytedance.sdk.openadsdk.xj.xj.xj.xj().xj(str);
        }
        if (TextUtils.isEmpty(str) || str.equals(w)) {
            return;
        }
        hf.xj().put("did", str);
        w = str;
    }

    @SuppressLint({"NewApi"})
    private static String kd(String str) {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (str == null || networkInterface.getName().equalsIgnoreCase(str)) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : hardwareAddress) {
                        sb.append(String.format("%02X:", Byte.valueOf(b2)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String u(String str) {
        try {
            WifiInfo hf2 = hf();
            if (hf2 != null) {
                String bssid = hf2.getBSSID();
                if (!TextUtils.isEmpty(bssid)) {
                    return bssid;
                }
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    public static String xj(Boolean bool) {
        if (!TextUtils.isEmpty(kd)) {
            return kd;
        }
        com.bytedance.sdk.openadsdk.zg.w.w.u e2 = f.zg().e();
        if (bool == null) {
            return xj(e2, e2 != null && e2.w());
        }
        if (ra) {
            return kd;
        }
        return xj(e2, bool.booleanValue());
    }

    public static String hf(Boolean bool) {
        if (!TextUtils.isEmpty(d)) {
            return d;
        }
        if (bool == null) {
            com.bytedance.sdk.openadsdk.zg.w.w.u e2 = f.zg().e();
            if (e2 != null && !e2.w()) {
                return null;
            }
        } else if (!x && !dk) {
            if (!bool.booleanValue()) {
                return null;
            }
        } else {
            return d;
        }
        return x();
    }

    private static String xj(com.bytedance.sdk.openadsdk.zg.w.w.u uVar, boolean z2) {
        if (uVar != null && !z2) {
            String tf2 = uVar.tf();
            kd = tf2;
            com.bytedance.sdk.openadsdk.tools.hf.hf(6, tf2);
            return tf2;
        }
        if (ra) {
            return kd;
        }
        if (com.bytedance.sdk.openadsdk.core.u.xj.f()) {
            String p2 = TextUtils.isEmpty(kd) ? com.bytedance.sdk.openadsdk.core.w.u.xj().p(null) : kd;
            if (!TextUtils.isEmpty(p2)) {
                new com.bytedance.sdk.openadsdk.core.u.hf("device_get_imei").xj(5).hf(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.yo.2
                    @Override // java.lang.Runnable
                    public void run() {
                        yo.io();
                    }
                });
                return p2;
            }
        }
        io();
        return kd;
    }

    private static boolean xj(long j2, long j3) {
        return System.currentTimeMillis() - j2 > j3;
    }
}

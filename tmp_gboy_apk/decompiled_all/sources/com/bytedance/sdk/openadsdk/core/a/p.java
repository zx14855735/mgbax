package com.bytedance.sdk.openadsdk.core.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.system.OsConstants;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrength;
import android.telephony.CellSignalStrengthTdscdma;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.pangle.wrapper.ADYaiT;
import com.bytedance.sdk.component.utils.et;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.n;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class p {
    private static volatile long am;
    private static volatile long dk;
    private static volatile long e;
    private static volatile String et;
    private static String hf;
    private static volatile String ht;

    /* renamed from: io, reason: collision with root package name */
    private static volatile long f10275io;
    private static volatile hf j;
    private static volatile String jk;
    private static volatile String pz;
    private static volatile long qt;
    private static volatile String ra;
    private static volatile boolean u;
    private static volatile long v;
    private static volatile boolean w;
    private static volatile u z;
    private static AtomicBoolean kd = new AtomicBoolean(false);
    private static AtomicBoolean y = new AtomicBoolean(false);
    private static AtomicInteger c = new AtomicInteger(-1);
    private static volatile boolean f = true;
    private static long d = 0;
    private static volatile int tf = -1;
    private static volatile int p = -1;

    /* renamed from: pl, reason: collision with root package name */
    private static volatile String f10276pl = null;
    private static volatile String g = null;
    private static volatile float zg = -2.0f;
    private static volatile int yo = -1;
    private static volatile long x = -1;
    private static volatile long ai = System.currentTimeMillis();
    public static final AtomicLong xj = new AtomicLong();
    private static volatile int q = -1;

    public static class hf extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            if (intent == null) {
                return;
            }
            com.bytedance.sdk.component.utils.f.w().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.p.hf.1
                @Override // java.lang.Runnable
                public void run() {
                    hf.this.xj(intent);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void xj(Intent intent) {
            int i = -1;
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                boolean booleanExtra = intent.getBooleanExtra("present", false);
                if (booleanExtra) {
                    int intExtra = intent.getIntExtra("status", -1);
                    if (intExtra == -1) {
                        xj.xj = intExtra;
                    } else if (intExtra == 2) {
                        xj.xj = 1;
                    } else {
                        xj.xj = 0;
                    }
                } else {
                    xj.xj = 2;
                }
                xj.hf = (intent.getIntExtra("level", -1) * 100) / intent.getIntExtra("scale", -1);
                if (!com.bytedance.sdk.openadsdk.core.f.zg().z()) {
                    com.bytedance.sdk.openadsdk.xj.hf.hf.xj(booleanExtra);
                }
            }
            try {
                i = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1);
            } catch (Exception unused) {
            }
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && i == 3) {
                com.bytedance.sdk.component.utils.f.xj().post(new com.bytedance.sdk.component.tf.d("tt_vol") { // from class: com.bytedance.sdk.openadsdk.core.a.p.hf.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AudioManager audioManager = (AudioManager) com.bytedance.sdk.openadsdk.core.pz.getContext().getSystemService(MediaFormat.KEY_AUDIO);
                            if (audioManager == null) {
                                return;
                            }
                            int unused2 = p.q = audioManager.getStreamVolume(3);
                        } catch (Exception unused3) {
                        }
                    }
                });
            }
        }
    }

    public static class u extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            com.bytedance.sdk.component.utils.f.hf().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.p.u.1
                @Override // java.lang.Runnable
                public void run() {
                    u.this.xj(intent);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void xj(final Intent intent) {
            if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                boolean unused = p.f = true;
                com.bytedance.sdk.component.utils.pl.xj("DeviceUtils", PointCategory.SCREEN_ON);
            } else if (!"android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                    long unused2 = p.ai = System.currentTimeMillis();
                }
            } else {
                boolean unused3 = p.f = false;
                com.bytedance.sdk.component.utils.pl.xj("DeviceUtils", "screen_off");
                if (com.bytedance.sdk.openadsdk.core.f.zg().z()) {
                    return;
                }
                com.bytedance.sdk.openadsdk.x.c.xj(new com.bytedance.sdk.component.tf.d("updateScreenStatus") { // from class: com.bytedance.sdk.openadsdk.core.a.p.u.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.sdk.component.u.xj hf = dk.hf();
                        if (hf != null) {
                            hf.updateScreenStatus(intent.getAction());
                        }
                    }
                });
            }
        }
    }

    public static class w implements et.xj {
        @Override // com.bytedance.sdk.component.utils.et.xj
        public void xj(Context context, Intent intent, boolean z, int i) {
            if (p.c.get() == i) {
                return;
            }
            p.c.set(i);
            p.kd.set(true);
            p.y.set(true);
            com.bytedance.sdk.component.u.xj hf = dk.hf();
            if (com.bytedance.sdk.openadsdk.core.f.zg().z() || hf == null) {
                return;
            }
            hf.updateNetworkStatus(i);
        }
    }

    public static class xj {
        static float hf = 0.0f;
        static int xj = -1;

        public static float hf(Context context) {
            com.bytedance.sdk.openadsdk.xj.hf.hf.hf(context);
            return hf;
        }

        public static int xj(Context context) {
            com.bytedance.sdk.openadsdk.xj.hf.hf.xj(context);
            return xj;
        }
    }

    static {
        BmyJHf();
    }

    private static /* synthetic */ void BmyJHf() {
        char[] charArray = "\u0007\u000b\tJ\u0003\u0005\t\u0001J\u0006\u000b\u001dJ\u0017\f\u0001\b\bJ.\n\r&\u0016\r\u0000\u0003\u0001".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'd');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0007\b\r\n\r\u0010".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'd');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static int am() {
        if (yo != -1 && !xj(v, 60000L)) {
            return yo;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) com.bytedance.sdk.openadsdk.core.pz.getContext().getSystemService("accessibility");
        if (accessibilityManager == null) {
            return -1;
        }
        yo = accessibilityManager.isEnabled() ? 1 : 0;
        v = System.currentTimeMillis();
        return yo;
    }

    public static String c() {
        return ra() ? ht : tf.hf(false)[1];
    }

    public static String[] d() {
        if (!tf()) {
            return new String[]{"", ""};
        }
        if (!com.bytedance.sdk.openadsdk.core.u.xj.f() || TextUtils.isEmpty(pz) || TextUtils.isEmpty(ra)) {
            return et();
        }
        new com.bytedance.sdk.openadsdk.core.u.hf("device_get_ip").xj(5).hf(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.a.p.1
            @Override // java.lang.Runnable
            public void run() {
                p.et();
            }
        });
        return new String[]{pz, ra};
    }

    private static String[] dk() {
        String[] d2 = d();
        if (TextUtils.isEmpty(d2[0]) && TextUtils.isEmpty(d2[1])) {
            com.bytedance.sdk.openadsdk.core.w.u.xj().g("");
        }
        return d2;
    }

    public static long e() {
        return x != -1 ? x : com.bytedance.sdk.openadsdk.core.w.u.xj().hf("dev19", -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String[] et() {
        String[] strArr = {"", ""};
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            boolean z2 = false;
            boolean z3 = false;
            loop0: while (it.hasNext()) {
                for (InetAddress inetAddress : xj((NetworkInterface) it.next())) {
                    boolean z4 = inetAddress instanceof Inet4Address;
                    if (!z4 || !z2) {
                        if (z4 || !z3) {
                            if (hf(z4, inetAddress, strArr)) {
                                if (!TextUtils.isEmpty(strArr[0]) && !TextUtils.isEmpty(strArr[1])) {
                                    break loop0;
                                }
                            } else {
                                String hostAddress = inetAddress.getHostAddress();
                                if (!TextUtils.isEmpty(hostAddress) && !hostAddress.startsWith("127")) {
                                    if (z4) {
                                        com.bytedance.sdk.openadsdk.core.w.u.xj().g(com.bytedance.sdk.component.utils.xj.hf(hostAddress));
                                        strArr[0] = hostAddress;
                                        pz = hostAddress;
                                        jk = hostAddress;
                                        if (z3) {
                                            break loop0;
                                        }
                                        z2 = true;
                                    } else {
                                        int indexOf = hostAddress.indexOf(37);
                                        if (indexOf >= 0) {
                                            hostAddress = hostAddress.substring(0, indexOf);
                                        }
                                        if (w(hostAddress)) {
                                            com.bytedance.sdk.openadsdk.core.w.u.xj().am(com.bytedance.sdk.component.utils.xj.hf(hostAddress));
                                            strArr[1] = hostAddress;
                                            ra = hostAddress;
                                            ht = hostAddress;
                                            if (z2) {
                                                break loop0;
                                            }
                                            z3 = true;
                                        } else {
                                            continue;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return strArr;
    }

    public static JSONArray f() {
        JSONArray jSONArray = new JSONArray();
        try {
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.pl.xj(e2);
        }
        if (!tf()) {
            return new JSONArray();
        }
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        if (networkInterfaces == null) {
            return new JSONArray();
        }
        Iterator it = Collections.list(networkInterfaces).iterator();
        while (it.hasNext()) {
            NetworkInterface networkInterface = (NetworkInterface) it.next();
            String name = networkInterface.getName();
            if ("dummy0".equals(name) || "wlan0".equals(name)) {
                Iterator it2 = Collections.list(networkInterface.getInetAddresses()).iterator();
                while (it2.hasNext()) {
                    String hostAddress = ((InetAddress) it2.next()).getHostAddress();
                    if (!TextUtils.isEmpty(hostAddress) && hostAddress.indexOf(58) >= 0) {
                        int indexOf = hostAddress.indexOf(37);
                        if ("dummy0".equals(name)) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(PointParamKey.TYPE, "client_tun");
                            if (indexOf >= 0) {
                                hostAddress = hostAddress.substring(0, indexOf);
                            }
                            jSONObject.put("value", hostAddress.toUpperCase());
                            jSONArray.put(jSONObject);
                        } else if ("wlan0".equals(name) || "fe80".equalsIgnoreCase(hostAddress.split("::")[0])) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(PointParamKey.TYPE, "client_anpi");
                            if (indexOf >= 0) {
                                hostAddress = hostAddress.substring(0, indexOf);
                            }
                            jSONObject2.put("value", hostAddress.toUpperCase());
                            jSONArray.put(jSONObject2);
                        }
                    }
                }
            }
        }
        return jSONArray;
    }

    public static void g() {
        try {
            if (u && j != null) {
                com.bytedance.sdk.openadsdk.core.pz.getContext().getApplicationContext().unregisterReceiver(j);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    public static void kd() {
        try {
            if (w && z != null) {
                com.bytedance.sdk.openadsdk.core.pz.getContext().getApplicationContext().unregisterReceiver(z);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    public static String p() {
        String languageTag = Locale.getDefault().toLanguageTag();
        return !TextUtils.isEmpty(languageTag) ? languageTag : "";
    }

    public static float pl() {
        if (zg != -2.0f && !xj(e, 30000L)) {
            return zg;
        }
        int i = -1;
        try {
            Context context = com.bytedance.sdk.openadsdk.core.pz.getContext();
            if (context != null) {
                i = Settings.System.getInt(context.getContentResolver(), "screen_brightness", -1);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.u("DeviceUtils", th.getMessage());
        }
        if (i < 0) {
            zg = -1.0f;
        } else {
            zg = Math.round((i / 255.0f) * 10.0f) / 10.0f;
        }
        e = System.currentTimeMillis();
        return zg;
    }

    public static void qt() {
        Context context = com.bytedance.sdk.openadsdk.core.pz.getContext();
        if (context != null) {
            int g2 = wo.g();
            com.bytedance.sdk.openadsdk.core.w.u.xj().xj("cpu_cnt", g2);
            wo.xj = g2;
            int w2 = wo.w(wo.g());
            com.bytedance.sdk.openadsdk.core.w.u.xj().xj("cpu_max_freq", w2);
            wo.hf = w2;
            int u2 = wo.u(wo.g());
            com.bytedance.sdk.openadsdk.core.w.u.xj().xj("cpu_min_freq", u2);
            wo.w = u2;
            String u3 = wo.u(context, "MemTotal");
            if (u3 != null) {
                com.bytedance.sdk.openadsdk.core.w.u.xj().hf("total_memory", u3);
                wo.u = u3;
            }
            long yo2 = wo.yo();
            com.bytedance.sdk.openadsdk.core.w.u.xj().xj("internal_storage", yo2);
            wo.kd = yo2;
            long xj2 = com.bytedance.sdk.component.utils.g.xj();
            com.bytedance.sdk.openadsdk.core.w.u.xj().xj("free_storage", xj2);
            wo.y = xj2;
            long pz2 = wo.pz();
            com.bytedance.sdk.openadsdk.core.w.u.xj().xj("sdcard_storage", pz2);
            wo.c = pz2;
            boolean ra2 = wo.ra();
            com.bytedance.sdk.openadsdk.core.w.u.xj().xj("is_root", ra2 ? 1 : 0);
            wo.f = ra2 ? 1 : 0;
        }
    }

    private static boolean ra() {
        return (kd.get() || xj(dk, 1800000L) || TextUtils.isEmpty(jk)) ? false : true;
    }

    public static boolean tf() {
        if (!com.bytedance.sdk.openadsdk.core.pz.hf().su()) {
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(com.bytedance.sdk.openadsdk.core.f.zg().io());
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null && !optJSONObject.isNull("name") && "tt_inner_isw".equals(optJSONObject.optString("name"))) {
                    return optJSONObject.optBoolean("value", true);
                }
            }
        } catch (JSONException unused) {
        }
        return true;
    }

    public static int u() {
        if (tf == -1 || y.getAndSet(false)) {
            tf = com.bytedance.sdk.component.utils.am.hf(com.bytedance.sdk.openadsdk.core.pz.getContext());
        }
        return tf;
    }

    public static void w() {
        c.set(com.bytedance.sdk.component.utils.am.w(com.bytedance.sdk.openadsdk.core.pz.getContext()));
        u();
        pl();
        am();
        xj(0);
        xj(1);
        tf.hf(false);
        xj((String) null);
    }

    public static boolean xj() {
        if (!f && SystemClock.elapsedRealtime() - d >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            d = SystemClock.elapsedRealtime();
            try {
                PowerManager powerManager = (PowerManager) com.bytedance.sdk.openadsdk.core.pz.getContext().getSystemService("power");
                if (powerManager != null) {
                    f = powerManager.isInteractive();
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.pl.xj(th);
            }
        }
        return f;
    }

    public static String y() {
        return ra() ? jk : tf.hf(false)[0];
    }

    public static int yo() {
        if (q >= 0) {
            return q;
        }
        try {
            AudioManager audioManager = (AudioManager) com.bytedance.sdk.openadsdk.core.pz.getContext().getSystemService(MediaFormat.KEY_AUDIO);
            if (audioManager == null) {
                return 0;
            }
            q = audioManager.getStreamVolume(3);
            return q;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int zg() {
        return (int) (com.bytedance.sdk.openadsdk.core.pz.getContext().getResources().getConfiguration().fontScale * 16.0f);
    }

    public static long hf() {
        return ai;
    }

    public static void u(Context context) {
        if (u) {
            return;
        }
        try {
            j = new hf();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            context.getApplicationContext().registerReceiver(j, intentFilter);
            u = true;
        } catch (Throwable unused) {
        }
    }

    public static void hf(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.w.u.xj().u("dev14", com.bytedance.sdk.component.utils.xj.hf(str));
        et = str;
        f10275io = System.currentTimeMillis();
    }

    public static void kd(Context context) {
        com.bytedance.sdk.component.utils.et.xj(new w(), context);
    }

    public static void xj(Context context) {
        if (w) {
            return;
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                f = powerManager.isScreenOn();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
        try {
            z = new u();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            context.getApplicationContext().registerReceiver(z, intentFilter);
            w = true;
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.pl.xj(th2);
        }
    }

    private static boolean w(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char charAt = str.charAt(0);
        if ((charAt != '2' && charAt != '3' && charAt != '5') || str.length() < 2) {
            return false;
        }
        char charAt2 = str.charAt(1);
        if (charAt2 >= '0' && charAt2 <= '9') {
            return true;
        }
        if (charAt2 < 'a' || charAt2 > 'f') {
            return charAt2 >= 'A' && charAt2 <= 'F';
        }
        return true;
    }

    private static boolean hf(boolean z2, InetAddress inetAddress, String[] strArr) {
        Field declaredField;
        if (z2) {
            try {
                if (!TextUtils.isEmpty(strArr[0])) {
                    return true;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        if (!z2 && !TextUtils.isEmpty(strArr[1])) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 24) {
            return xj(z2, inetAddress, strArr);
        }
        if (z2) {
            declaredField = InetAddress.class.getDeclaredField("holder");
        } else {
            declaredField = Inet6Address.class.getDeclaredField("holder6");
        }
        declaredField.setAccessible(true);
        Object obj = declaredField.get(inetAddress);
        Class<?> cls = obj.getClass();
        if (z2) {
            Field declaredField2 = cls.getDeclaredField("address");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            int intValue = obj2 instanceof Integer ? ((Integer) obj2).intValue() : 0;
            byte[] bArr = {(byte) ((intValue >>> 24) & 255), (byte) ((intValue >>> 16) & 255), (byte) ((intValue >>> 8) & 255), (byte) (intValue & 255)};
            String hf2 = hf(bArr);
            if (bArr[0] != Byte.MAX_VALUE) {
                strArr[0] = hf2;
            }
        } else {
            Field declaredField3 = cls.getDeclaredField("ipaddress");
            declaredField3.setAccessible(true);
            Object obj3 = declaredField3.get(obj);
            if (obj3 instanceof byte[]) {
                String xj2 = xj((byte[]) obj3);
                if (!w(xj2)) {
                    return true;
                }
                strArr[1] = xj2;
            }
        }
        return true;
    }

    public static boolean w(Context context) {
        return (context.getResources().getConfiguration().uiMode & 15) == 4;
    }

    private static String w(int i) {
        List<CellInfo> allCellInfo;
        CellSignalStrengthTdscdma cellSignalStrength;
        int dbm;
        CellSignalStrength cellSignalStrength2;
        WifiInfo hf2;
        int w2 = com.bytedance.sdk.component.utils.am.w(com.bytedance.sdk.openadsdk.core.pz.getContext());
        com.bytedance.sdk.openadsdk.zg.w.w.u e2 = com.bytedance.sdk.openadsdk.core.f.zg().e();
        try {
            if (w2 == 4) {
                if (i == 0 && e2.u() && (hf2 = com.bytedance.sdk.openadsdk.core.yo.hf()) != null) {
                    return hf2.getRssi() + "dBm";
                }
                return MediationConfigUserInfoForSegment.GENDER_UNKNOWN;
            }
            if (e2.w() && e2.xj() && i == 1 && com.bytedance.sdk.openadsdk.core.yo.pl()) {
                TelephonyManager xj2 = com.bytedance.sdk.openadsdk.core.yo.xj();
                int i2 = Build.VERSION.SDK_INT;
                if (xj2 != null && (allCellInfo = xj2.getAllCellInfo()) != null) {
                    CellInfo cellInfo = allCellInfo.get(0);
                    if (cellInfo instanceof CellInfoGsm) {
                        dbm = ((CellInfoGsm) cellInfo).getCellSignalStrength().getDbm();
                    } else if (cellInfo instanceof CellInfoCdma) {
                        dbm = ((CellInfoCdma) cellInfo).getCellSignalStrength().getDbm();
                    } else if (cellInfo instanceof CellInfoLte) {
                        dbm = ((CellInfoLte) cellInfo).getCellSignalStrength().getDbm();
                    } else if (cellInfo instanceof CellInfoWcdma) {
                        dbm = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getDbm();
                    } else if (i2 >= 29 && ADYaiT.B4ZgIw(cellInfo)) {
                        cellSignalStrength2 = ADYaiT.A4TApA(cellInfo).getCellSignalStrength();
                        dbm = cellSignalStrength2.getDbm();
                    } else if (i2 >= 29 && ADYaiT.BChYOn(cellInfo)) {
                        cellSignalStrength = ADYaiT.A5SV6n(cellInfo).getCellSignalStrength();
                        dbm = cellSignalStrength.getDbm();
                    } else {
                        return MediationConfigUserInfoForSegment.GENDER_UNKNOWN;
                    }
                    if (Integer.MIN_VALUE != dbm) {
                        return dbm + "dBm";
                    }
                    return MediationConfigUserInfoForSegment.GENDER_UNKNOWN;
                }
                return MediationConfigUserInfoForSegment.GENDER_UNKNOWN;
            }
            return MediationConfigUserInfoForSegment.GENDER_UNKNOWN;
        } catch (Throwable unused) {
            return MediationConfigUserInfoForSegment.GENDER_UNKNOWN;
        }
    }

    public static String xj(String str) {
        if (!TextUtils.isEmpty(et) && !xj(f10275io, 1800000L)) {
            return et;
        }
        String w2 = com.bytedance.sdk.openadsdk.core.w.u.xj().w("dev14", 1800000L);
        if (TextUtils.isEmpty(w2)) {
            if (str == null) {
                str = tf.am();
            }
            et = str;
        } else {
            et = com.bytedance.sdk.component.utils.xj.w(w2);
        }
        f10275io = System.currentTimeMillis();
        return et;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0075 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String[] xj(boolean r16) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.a.p.xj(boolean):java.lang.String[]");
    }

    private static String hf(byte[] bArr) {
        return (bArr[0] & 255) + "." + (bArr[1] & 255) + "." + (bArr[2] & 255) + "." + (bArr[3] & 255);
    }

    public static boolean hf(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    private static void hf(JSONObject jSONObject) {
        try {
            jSONObject.put(n.p, wo.d());
            jSONObject.put("version_code", wo.tf());
            jSONObject.put("version", wo.p());
        } catch (Exception unused) {
        }
    }

    private static List<InetAddress> xj(NetworkInterface networkInterface) {
        if (networkInterface == null) {
            return Collections.EMPTY_LIST;
        }
        try {
            if (Build.VERSION.SDK_INT < 24) {
                Object xj2 = et.xj(networkInterface, "java.net.NetworkInterface", "addresses", null);
                if (!(xj2 instanceof List)) {
                    return Collections.list(networkInterface.getInetAddresses());
                }
                return (List) xj2;
            }
            Object xj3 = et.xj(networkInterface, "java.net.NetworkInterface", "addrs", null);
            if (!(xj3 instanceof InetAddress[])) {
                return Collections.list(networkInterface.getInetAddresses());
            }
            return Arrays.asList((InetAddress[]) xj3);
        } catch (Throwable unused) {
            return Collections.list(networkInterface.getInetAddresses());
        }
    }

    private static boolean xj(boolean z2, InetAddress inetAddress, String[] strArr) {
        if (z2) {
            try {
                if (!TextUtils.isEmpty(strArr[0])) {
                    return true;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        if (!z2 && !TextUtils.isEmpty(strArr[1])) {
            return true;
        }
        Class<?> cls = Class.forName("libcore.io.Libcore");
        Field declaredField = cls.getDeclaredField("os");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(cls);
        Method method = obj.getClass().getMethod("getnameinfo", InetAddress.class, Integer.TYPE);
        method.setAccessible(true);
        Object invoke = method.invoke(obj, inetAddress, Integer.valueOf(OsConstants.NI_NUMERICHOST));
        if (invoke == null) {
            return false;
        }
        String str = (String) invoke;
        if (str.startsWith("127")) {
            return true;
        }
        if (z2) {
            strArr[0] = str;
            return true;
        }
        int indexOf = str.indexOf(37);
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        if (!w(str)) {
            return true;
        }
        strArr[1] = str;
        return true;
    }

    private static String xj(byte[] bArr) {
        StringBuilder sb = new StringBuilder(39);
        for (int i = 0; i < 8; i++) {
            int i2 = i << 1;
            sb.append(Integer.toHexString(((bArr[i2] << 8) & 65280) | (bArr[i2 + 1] & 255)));
            if (i < 7) {
                sb.append(":");
            }
        }
        return sb.toString();
    }

    public static int xj(Context context, boolean z2) {
        if (p != -1) {
            return p;
        }
        if (z2) {
            String w2 = com.bytedance.sdk.openadsdk.core.w.u.xj().w("dev06", 2592000000L);
            try {
                if (!TextUtils.isEmpty(w2)) {
                    p = Integer.parseInt(w2);
                }
            } catch (Exception unused) {
            }
            if (p != -1) {
                return p;
            }
        }
        if (w(context)) {
            p = 3;
        } else if (hf(context)) {
            p = 2;
        } else {
            p = 1;
        }
        if (z2) {
            com.bytedance.sdk.openadsdk.core.w.u.xj().u("dev06", String.valueOf(p));
        }
        return p;
    }

    public static void xj(JSONObject jSONObject) {
        if (am.hf()) {
            jSONObject.putOpt("os_new", "harmony");
            jSONObject.putOpt("harmonyos_api", am.kd());
            jSONObject.putOpt("harmonyos_version", am.y());
            jSONObject.putOpt("harmonyos_release_type", am.c());
            jSONObject.putOpt("harmonyos_build_version", am.f());
            jSONObject.putOpt("pure_mode", Integer.valueOf(am.xj(com.bytedance.sdk.openadsdk.core.pz.getContext()) ? 1 : 2));
        } else {
            jSONObject.putOpt("os_new", "android");
        }
        jSONObject.putOpt("rom_name", Build.BRAND);
    }

    public static String xj(int i) {
        if (i == 0 && !TextUtils.isEmpty(f10276pl) && !xj(am, 60000L)) {
            return f10276pl;
        }
        if (i == 1 && !TextUtils.isEmpty(g) && !xj(qt, 60000L)) {
            return g;
        }
        String w2 = w(i);
        if (i == 0) {
            f10276pl = w2;
            am = System.currentTimeMillis();
            return w2;
        }
        if (i == 1) {
            g = w2;
            qt = System.currentTimeMillis();
        }
        return w2;
    }

    private static boolean xj(long j2, long j3) {
        return System.currentTimeMillis() - j2 > j3;
    }

    public static JSONObject xj(int i, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", com.bytedance.sdk.openadsdk.core.f.zg().pz());
            jSONObject.put("name", com.bytedance.sdk.openadsdk.core.f.zg().ht());
            hf(jSONObject);
            com.bytedance.sdk.openadsdk.qt.hf.xj(jSONObject, i);
            jSONObject.put("is_paid_app", com.bytedance.sdk.openadsdk.core.f.zg().ra());
            if (!com.bytedance.sdk.openadsdk.core.w.u.xj().c(i)) {
                jSONObject.put("network_speed", com.bytedance.sdk.openadsdk.core.et.xj.xj());
            }
            jSONObject.put("apk_sign", com.bytedance.sdk.openadsdk.core.f.xj.f());
            jSONObject.put("useful_open_sdk", com.bytedance.sdk.openadsdk.core.hf.xj.hf.u.w().hf());
            jSONObject.put("real_app_name", com.bytedance.sdk.openadsdk.core.f.xj.hf(com.bytedance.sdk.openadsdk.core.pz.getContext()));
            jSONObject.put("app_cold_startup_time", com.bytedance.sdk.openadsdk.core.qt.w.kd().w());
            jSONObject.put("sdk_init_timestamp", com.bytedance.sdk.openadsdk.core.qt.w.kd().u());
            if (z2) {
                jSONObject.put("session_ad_index", xj.addAndGet(1L));
                if (com.bytedance.sdk.openadsdk.core.pz.hf().kr()) {
                    long w2 = com.bytedance.sdk.openadsdk.core.qt.xj.w();
                    jSONObject.put("app_total_7_duration", com.bytedance.sdk.openadsdk.core.qt.xj.u() + w2);
                    jSONObject.put("app_use_7_duration", w2);
                    jSONObject.put("start_session", com.bytedance.sdk.openadsdk.core.qt.xj.kd());
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static void xj(long j2) {
        if (j2 == -1 || x == j2) {
            return;
        }
        x = j2;
        com.bytedance.sdk.openadsdk.core.w.u.xj().xj("dev19", j2);
    }
}

package com.bytedance.sdk.component.panglearmor;

import ADYaiT.CtFAbx;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import com.czhj.sdk.common.Constants;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.kwad.components.core.s.t;
import com.sigmob.sdk.archives.tar.e;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class SoftDecTool {
    public static final String SP_NAME = "softdec";

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f10211a = false;
    public static volatile double acs = -1.0d;
    public static volatile long act = 0;
    public static volatile boolean f = false;
    public static volatile boolean h = false;
    private static volatile int hf = 0;
    private static volatile boolean w = true;
    private static SharedPreferences xj;

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b5, code lost:
    
        if (r3 == null) goto L52;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int b() {
        /*
            java.lang.String r0 = com.bytedance.sdk.component.panglearmor.y.y()
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto Lc
            r0 = 1
            return r0
        Lc:
            java.lang.String r1 = "/apk/base-1.apk"
            java.lang.String r0 = r0.concat(r1)
            r1 = 11
            r2 = 0
            java.util.zip.ZipFile r3 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8f
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8f
            java.lang.String r0 = "classes.dex"
            java.util.zip.ZipEntry r0 = r3.getEntry(r0)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
            java.io.InputStream r0 = r3.getInputStream(r0)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
            java.lang.String r4 = xj(r0)     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L70
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L70
            r5.<init>()     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L70
            int r6 = r4.length()     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L70
            int r6 = r6 / 2
            java.lang.String r6 = r4.substring(r6)     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L70
            r5.append(r6)     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L70
            int r6 = r4.length()     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L70
            int r6 = r6 / 2
            r7 = 0
            java.lang.String r4 = r4.substring(r7, r6)     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L70
            r5.append(r4)     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L70
            java.lang.String r4 = r5.toString()     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L70
            java.lang.String r5 = "assets/pangle_vp_config.db"
            java.util.zip.ZipEntry r5 = r3.getEntry(r5)     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L70
            if (r5 == 0) goto L75
            java.io.InputStream r2 = r3.getInputStream(r5)     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L70
            int r5 = r2.available()     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L70
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L70
            r2.read(r5)     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L70
            java.lang.String r6 = new java.lang.String     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L70
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L70
            boolean r1 = r6.equals(r4)     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L70
            goto L75
        L6b:
            r1 = move-exception
            r8 = r2
            r2 = r0
            r0 = r8
            goto L91
        L70:
            r8 = r2
            r2 = r0
            r0 = r8
            goto La7
        L75:
            if (r0 == 0) goto L7c
            r0.close()     // Catch: java.io.IOException -> L7b
            goto L7c
        L7b:
        L7c:
            if (r2 == 0) goto L81
            r2.close()     // Catch: java.io.IOException -> L81
        L81:
            r3.close()     // Catch: java.io.IOException -> Lb8
            goto Lb8
        L85:
            r1 = move-exception
            r0 = r2
            goto L91
        L88:
            r0 = r2
            goto La7
        L8b:
            r1 = move-exception
            r0 = r2
            r3 = r0
            goto L91
        L8f:
            goto La5
        L91:
            if (r2 == 0) goto L98
            r2.close()     // Catch: java.io.IOException -> L97
            goto L98
        L97:
        L98:
            if (r0 == 0) goto L9f
            r0.close()     // Catch: java.io.IOException -> L9e
            goto L9f
        L9e:
        L9f:
            if (r3 == 0) goto La4
            r3.close()     // Catch: java.io.IOException -> La4
        La4:
            throw r1
        La5:
            r0 = r2
            r3 = r0
        La7:
            if (r2 == 0) goto Lae
            r2.close()     // Catch: java.io.IOException -> Lad
            goto Lae
        Lad:
        Lae:
            if (r0 == 0) goto Lb5
            r0.close()     // Catch: java.io.IOException -> Lb4
            goto Lb5
        Lb4:
        Lb5:
            if (r3 == 0) goto Lb8
            goto L81
        Lb8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.panglearmor.SoftDecTool.b():int");
    }

    public static native Object b(int i, Object[] objArr);

    public static native byte[] bc(int i, byte[] bArr);

    public static synchronized Object cn(int i, Object[] objArr) {
        synchronized (SoftDecTool.class) {
            if (!d.hf()) {
                return null;
            }
            return b(i, objArr);
        }
    }

    public static void cs(String str) {
        SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("sofchara", str).putLong(t.TAG, System.currentTimeMillis()).apply();
        }
    }

    public static String dgb() {
        StringBuilder sb = new StringBuilder();
        sb.append(xj(Build.BOARD, "ro.product.board"));
        sb.append(xj(Build.MODEL, "ro.product.model"));
        sb.append(xj(Build.VERSION.RELEASE, "ro.build.version.release"));
        sb.append(xj(Build.MANUFACTURER, "ro.product.manufacturer"));
        sb.append(xj(Build.DISPLAY, "ro.build.display.id"));
        long j = Build.TIME;
        long parseLong = Long.parseLong(y.xj("ro.build.date.utc", "-1"));
        if (j == -1000 || parseLong == -1) {
            sb.append(e.V);
        } else {
            if (String.valueOf(j).length() >= 10) {
                sb.append(Long.parseLong(String.valueOf(j).substring(0, 10)) == parseLong ? 0 : 1);
            } else {
                sb.append(1);
            }
            sb.append(j == parseLong * 1000 ? 0 : 1);
        }
        return sb.toString();
    }

    public static String dn() {
        try {
            return !w ? "no_collection_allowed" : Settings.Secure.getString(y.u().getContentResolver(), "bluetooth_name");
        } catch (Throwable unused) {
            return "-1";
        }
    }

    public static long fi() {
        try {
            return y.u().getPackageManager().getPackageInfo(y.u().getPackageName(), 0).firstInstallTime / 1000;
        } catch (PackageManager.NameNotFoundException e) {
            pl.xj(e);
            return 0L;
        }
    }

    public static long fr() {
        SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
        if (sharedPreferences == null) {
            return 0L;
        }
        long j = sharedPreferences.getLong("frt", 0L);
        if (j != 0) {
            return j;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        sharedPreferences.edit().putLong("frt", currentTimeMillis).apply();
        return currentTimeMillis;
    }

    public static String gc() {
        SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("sofchara", "");
            long j = sharedPreferences.getLong(t.TAG, 0L);
            if (j != 0 && !TextUtils.isEmpty(string) && System.currentTimeMillis() - j <= 300000) {
                return string;
            }
        }
        return "";
    }

    public static JSONObject gdh() {
        List<Sensor> sensorList;
        try {
            SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
            if (sharedPreferences == null || sharedPreferences.getBoolean("reported_devicehardware_2", false) || y.u() == null || xj(y.u().getPackageManager().getPackageInfo(y.u().getPackageName(), 0).firstInstallTime, System.currentTimeMillis())) {
                return null;
            }
            TreeSet treeSet = new TreeSet();
            SensorManager sensorManager = (SensorManager) y.u().getSystemService("sensor");
            if (sensorManager != null && (sensorList = sensorManager.getSensorList(-1)) != null) {
                for (Sensor sensor : sensorList) {
                    if (sensor != null) {
                        treeSet.add(String.format(Locale.getDefault(), "%s###%s###%d", sensor.getName(), sensor.getVendor(), Integer.valueOf(sensor.getType())));
                    }
                }
            }
            String xj2 = y.xj("gsm.version.baseband", "");
            String xj3 = y.xj("ro.build.fingerprint", "");
            String property = System.getProperty("os.version");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sensors", treeSet);
            jSONObject.put("radio", xj2);
            jSONObject.put("fp", xj3);
            jSONObject.put("kernel", property);
            jSONObject.put("rom_version", y.xj("ro.build.display.id", ""));
            jSONObject.put("build_id", y.xj("ro.build.id", ""));
            jSONObject.put("incremental", y.xj("ro.build.version.incremental", ""));
            jSONObject.put("compiling_time", y.xj("ro.build.date.utc", ""));
            sharedPreferences.edit().putBoolean("reported_devicehardware_2", true).apply();
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static SharedPreferences getSharedPreferences(String str) {
        Context createDeviceProtectedStorageContext;
        boolean moveSharedPreferencesFrom;
        if (xj == null) {
            try {
                Context u = y.u();
                if (u != null && str != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        createDeviceProtectedStorageContext = u.createDeviceProtectedStorageContext();
                        moveSharedPreferencesFrom = createDeviceProtectedStorageContext.moveSharedPreferencesFrom(u, str);
                        if (!moveSharedPreferencesFrom) {
                            pl.hf("HARLOG", "Failed to move shared preferences.");
                        }
                        u = createDeviceProtectedStorageContext;
                    }
                    xj = com.bytedance.sdk.openadsdk.api.plugin.hf.hf(u, str, 0);
                }
                return null;
            } catch (Exception unused) {
            }
        }
        return xj;
    }

    public static synchronized int h(String str, boolean z) {
        synchronized (SoftDecTool.class) {
            try {
                SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
                int i = sharedPreferences.getInt(str, 0);
                if (!z) {
                    return i;
                }
                int i2 = i + 1;
                sharedPreferences.edit().putInt(str, i2).apply();
                return i2;
            } catch (Throwable th) {
                pl.xj(th);
                return -1;
            }
        }
    }

    public static int hv() {
        Network activeNetwork;
        if (Build.VERSION.SDK_INT < 23) {
            return -1;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) y.u().getSystemService("connectivity");
            activeNetwork = connectivityManager.getActiveNetwork();
            return connectivityManager.getNetworkCapabilities(activeNetwork).hasCapability(15) ? 0 : 1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String i() {
        int i = hf + 1;
        hf = i;
        if (i != 2) {
            return "2";
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) y.u().getSystemService("accessibility");
            TreeSet treeSet = new TreeSet();
            for (AccessibilityServiceInfo accessibilityServiceInfo : accessibilityManager.getInstalledAccessibilityServiceList()) {
                treeSet.add(accessibilityServiceInfo.getResolveInfo().serviceInfo.packageName + "#" + accessibilityServiceInfo.getResolveInfo().serviceInfo.name);
            }
            JSONArray jSONArray = new JSONArray((Collection) treeSet);
            SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
            String jSONArray2 = jSONArray.toString();
            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String string = sharedPreferences.getString("iacba", "");
            String string2 = sharedPreferences.getString("date", "1970-01-01");
            if (string.equals(jSONArray.toString()) && format.equals(string2)) {
                return "2";
            }
            sharedPreferences.edit().putString("iacba", jSONArray2).apply();
            sharedPreferences.edit().putString("date", format).apply();
            return jSONArray2;
        } catch (Throwable th) {
            pl.xj(th);
            return "-1";
        }
    }

    public static String kv() {
        return System.getProperty("os.version");
    }

    public static String p() {
        return com.bytedance.sdk.openadsdk.api.plugin.hf.xj(y.u()).getPath();
    }

    public static String prx() {
        String property = System.getProperty("http.proxyHost");
        String property2 = System.getProperty("http.proxyPort");
        return (TextUtils.isEmpty(property) && TextUtils.isEmpty(property2)) ? "" : CtFAbx.AlLFFp(property, ":", property2);
    }

    public static void rsd(final String str) {
        com.bytedance.sdk.component.utils.f.xj().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.panglearmor.SoftDecTool.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    f c = y.c();
                    if (c != null) {
                        JSONObject gdh = SoftDecTool.gdh();
                        if (gdh == null && !TextUtils.isEmpty(str)) {
                            gdh = new JSONObject();
                        }
                        if (gdh != null) {
                            if (!TextUtils.isEmpty(str)) {
                                gdh.put("rd2", str);
                            }
                            c.xj("device_hardware", gdh);
                        }
                    }
                } catch (Throwable th) {
                    pl.xj(th);
                }
            }
        }, 20000L);
    }

    public static void setBlt(boolean z) {
        w = z;
    }

    public static long tft() {
        return y.f();
    }

    public static int trc() {
        return y.d();
    }

    public static int u() {
        UsbAccessory[] accessoryList = ((UsbManager) y.u().getSystemService("usb")).getAccessoryList();
        return (accessoryList == null || accessoryList.length == 0) ? 0 : 1;
    }

    public static void ua() {
        SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
        if (sharedPreferences != null) {
            acs = sharedPreferences.getFloat("acs", -1.0f);
            act = sharedPreferences.getLong("act", 0L);
        }
    }

    private static String xj(InputStream inputStream) {
        int i;
        try {
            byte[] bArr = new byte[ProxyCacheUtils.DEFAULT_BUFFER_SIZE];
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                int i2 = b & 255;
                if (i2 < 16) {
                    sb.append(Constants.FAIL);
                }
                sb.append(Integer.toHexString(i2));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UnsupportedEncodingException", e);
        } catch (IOException e2) {
            pl.xj(e2);
            return "";
        } catch (NoSuchAlgorithmException e3) {
            throw new RuntimeException("NoSuchAlgorithmException", e3);
        }
    }

    public static void ua(double d, long j) {
        acs = d;
        act = j;
        SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putFloat("acs", (float) d).putLong("act", j).apply();
        }
    }

    private static boolean xj(long j, long j2) {
        long j3 = j2 - j;
        return j3 < 86400000 && j3 > -86400000 && xj(j) == xj(j2);
    }

    private static long xj(long j) {
        return (j + TimeZone.getDefault().getOffset(j)) / 86400000;
    }

    private static int xj(String str, String str2) {
        String xj2 = y.xj(str2, MediationConfigUserInfoForSegment.GENDER_UNKNOWN);
        return (str.equals(MediationConfigUserInfoForSegment.GENDER_UNKNOWN) || xj2.equals(MediationConfigUserInfoForSegment.GENDER_UNKNOWN) || str.equals(xj2)) ? 0 : 1;
    }
}

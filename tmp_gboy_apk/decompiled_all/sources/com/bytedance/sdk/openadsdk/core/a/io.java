package com.bytedance.sdk.openadsdk.core.a;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class io {
    private static String c = null;
    private static String d = null;
    private static int f = Integer.MAX_VALUE;
    public static int hf;
    public static int xj;
    private static final CharSequence w = "sony";
    private static final CharSequence u = "amigo";
    private static final CharSequence kd = "funtouch";
    private static final CharSequence y = LiveConfigKey.ORIGIN;

    public static class xj implements Callable<String> {
        private String xj;

        public xj(String str) {
            this.xj = str;
        }

        @Override // java.util.concurrent.Callable
        public String call() {
            System.currentTimeMillis();
            String hf = io.hf(this.xj);
            System.currentTimeMillis();
            if (!TextUtils.isEmpty(hf)) {
                try {
                    j.xj("rom_info").put("rom_property_info", hf);
                } catch (Throwable unused) {
                }
            }
            return hf;
        }
    }

    static {
        wiLU();
    }

    public static boolean am() {
        return !TextUtils.isEmpty(hf("ro.letv.release.version"));
    }

    public static boolean c() {
        String hf2 = hf("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(hf2)) {
            return false;
        }
        return hf2.toLowerCase().contains(kd) || hf2.toLowerCase().contains(LiveConfigKey.ORIGIN);
    }

    public static boolean d() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(u);
    }

    public static boolean dk() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("honor")) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        return (!TextUtils.isEmpty(str2) && str2.toLowerCase().startsWith("honor")) || "HONOR".equalsIgnoreCase(str2);
    }

    public static boolean e() {
        if (hf == 0) {
            try {
                Class.forName("com.huawei.system.BuildEx");
                hf = 1;
            } catch (Exception unused) {
            }
        }
        return hf == 1;
    }

    private static String et() {
        if (zg()) {
            return w();
        }
        if (jk()) {
            return u();
        }
        if (ht()) {
            return kd();
        }
        String y2 = y();
        if (!TextUtils.isEmpty(y2)) {
            return y2;
        }
        if (c()) {
            return f();
        }
        if (d()) {
            return p();
        }
        if (pl()) {
            return hf();
        }
        String g = g();
        if (!TextUtils.isEmpty(g)) {
            return g;
        }
        if (Build.MANUFACTURER.toLowerCase(Locale.ROOT).contains("oneplus")) {
            return "oneplus_" + Build.DISPLAY + "_" + Build.VERSION.INCREMENTAL;
        }
        if (dk()) {
            return "honor_" + pz();
        }
        if (tf()) {
            return "freeme_" + pz();
        }
        return Build.DISPLAY + "_" + Build.VERSION.INCREMENTAL;
    }

    public static String f() {
        return "vivo_" + hf("ro.vivo.os.build.display.id") + "_" + hf("ro.vivo.product.version");
    }

    public static String g() {
        if (!am()) {
            return "";
        }
        return "eui_" + hf("ro.letv.release.version") + "_" + Build.DISPLAY;
    }

    public static String hf() {
        return hf("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean ht() {
        if (f == Integer.MAX_VALUE) {
            String str = Build.MANUFACTURER;
            String tf = wo.tf("kllk");
            if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.ROOT).contains(tf)) {
                f = 0;
            } else {
                f = 1;
            }
        }
        return f == 1;
    }

    private static String io() {
        String AlLFFp2 = CtFAbx.AlLFFp(Build.DISPLAY, "_", Build.VERSION.INCREMENTAL);
        String str = Build.MANUFACTURER;
        if (zg()) {
            return "miui_".concat(String.valueOf(AlLFFp2));
        }
        if (e()) {
            return "huawei_".concat(String.valueOf(AlLFFp2));
        }
        Locale locale = Locale.ROOT;
        return str.toLowerCase(locale).contains("oppo") ? "oppo_".concat(String.valueOf(AlLFFp2)) : str.toLowerCase(locale).contains("vivo") ? "vivo_".concat(String.valueOf(AlLFFp2)) : str.toLowerCase(locale).contains("oneplus") ? "oneplus_".concat(String.valueOf(AlLFFp2)) : AlLFFp2;
    }

    public static boolean jk() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static String kd() {
        if (!ht()) {
            return "";
        }
        return "coloros_" + hf("ro.build.version.kllkrom") + "_" + Build.DISPLAY;
    }

    public static String p() {
        return Build.DISPLAY + "_" + hf("ro.gn.sv.version");
    }

    public static boolean pl() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String pz() {
        return w("ro.build.version.emui");
    }

    public static String qt() {
        if (TextUtils.isEmpty(d)) {
            d = et();
        }
        return d;
    }

    public static boolean ra() {
        try {
            String str = Build.BRAND;
            if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("huawei")) {
                String str2 = Build.MANUFACTURER;
                if (TextUtils.isEmpty(str2)) {
                    return false;
                }
                if (!str2.toLowerCase().startsWith("huawei")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean tf() {
        try {
            return "FreemeOS".equalsIgnoreCase(hf("ro.build.freemeos_label"));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String u() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static boolean v() {
        try {
            String str = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.toLowerCase().contains("vivo");
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.u("romUtils", e.getMessage());
            return false;
        }
    }

    public static String w() {
        if (!zg()) {
            return "";
        }
        return "miui_" + hf("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    private static /* synthetic */ void wiLU() {
        char[] charArray = "âîì¯æàìä¯ãîø¯òéäíí¯ËïèÃóèåæä".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 129);
        }
        String str = new String(charArray);
        char[] charArray2 = "âíèïèõ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 129);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static String x() {
        try {
            return j.xj("rom_info").get("rom_property_info", "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String xj() {
        if (TextUtils.isEmpty(c)) {
            c = io();
        }
        return c;
    }

    public static String y() {
        String pz = pz();
        if (pz == null) {
            return "";
        }
        if (!pz.toLowerCase().contains("emotionui") && !pz.toLowerCase().contains("magicui")) {
            return "";
        }
        StringBuilder A5SV6n2 = AYUAbz.A5SV6n(pz, "_");
        A5SV6n2.append(Build.DISPLAY);
        return A5SV6n2.toString();
    }

    public static boolean yo() {
        try {
            String str = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str)) {
                if (str.toLowerCase().contains("oppo")) {
                    return true;
                }
                return str.toLowerCase().contains("realme");
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.u("romUtil", e.getMessage());
        }
        return false;
    }

    public static boolean zg() {
        if (xj == 0) {
            try {
                Class.forName("miui.os.Build");
                xj = 1;
            } catch (Exception unused) {
            }
        }
        return xj == 1;
    }

    public static String hf(String str) {
        com.bytedance.sdk.component.u.p pVar = (com.bytedance.sdk.component.u.p) com.bytedance.sdk.openadsdk.ats.w.xj("system_info");
        return pVar != null ? pVar.get(str) : "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static String w(String str) {
        String str2;
        try {
            str2 = x();
            try {
                if (TextUtils.isEmpty(str2)) {
                    final com.bytedance.sdk.component.tf.f fVar = new com.bytedance.sdk.component.tf.f(new xj(str), 5, 2);
                    com.bytedance.sdk.component.tf.c.w(new com.bytedance.sdk.component.tf.d("getSystemPropertyTask") { // from class: com.bytedance.sdk.openadsdk.core.a.io.1
                        @Override // java.lang.Runnable
                        public void run() {
                            fVar.run();
                        }
                    });
                    str2 = (String) fVar.get(1L, TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            str2 = "";
        }
        return str2 == null ? "" : str2;
    }

    public static boolean xj(String str) {
        if (TextUtils.isEmpty(str)) {
            str = pz();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || ra();
    }
}

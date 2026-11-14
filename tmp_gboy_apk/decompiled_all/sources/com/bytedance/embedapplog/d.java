package com.bytedance.embedapplog;

import B4ZgIw.AYUAbz;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.octopus.ad.ADBidEvent;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d {
    private static final CharSequence xj = "sony";
    private static final CharSequence hf = "amigo";
    private static final CharSequence w = "funtouch";
    private static final xj<Boolean> u = new xj<Boolean>() { // from class: com.bytedance.embedapplog.d.1
        @Override // com.bytedance.embedapplog.d.xj
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public Boolean hf(Object... objArr) {
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                return Boolean.valueOf("harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
            } catch (Throwable unused) {
                return Boolean.FALSE;
            }
        }
    };

    public static abstract class xj<T> {
        private volatile T xj;

        public abstract T hf(Object... objArr);

        public final T w(Object... objArr) {
            if (this.xj == null) {
                synchronized (this) {
                    try {
                        if (this.xj == null) {
                            this.xj = hf(objArr);
                        }
                    } finally {
                    }
                }
            }
            return this.xj;
        }
    }

    static {
        YDdQhhK();
    }

    private static /* synthetic */ void YDdQhhK() {
        char[] charArray = ", \"a(.\"*a- 6a<'*##a\u0005!&\r=&+(*".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'O');
        }
        String str = new String(charArray);
        char[] charArray2 = ",#&!&;".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'O');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static String ai() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    public static boolean am() {
        Class<?> cls;
        try {
            cls = Class.forName("android.os.SystemProperties");
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.u("Honor", e.getMessage());
        }
        return !TextUtils.isEmpty((String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.build.version.emui"));
    }

    public static boolean c() {
        String hf2 = hf("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(hf2) && hf2.toLowerCase().contains(w);
    }

    public static String d() {
        return Build.DISPLAY + "_" + hf("ro.gn.sv.version");
    }

    public static boolean dk() {
        return "samsung".equalsIgnoreCase(Build.BRAND) || "samsung".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static String e() {
        String xj2 = xj();
        if (xj2 == null) {
            return "";
        }
        if (!xj2.toLowerCase().contains("emotionui") && !xj2.toLowerCase().contains("magicui")) {
            return "";
        }
        StringBuilder A5SV6n2 = AYUAbz.A5SV6n(xj2, "_");
        A5SV6n2.append(Build.DISPLAY);
        return A5SV6n2.toString();
    }

    public static boolean et() {
        String str = Build.FINGERPRINT;
        if (!TextUtils.isEmpty(str)) {
            return str.contains("VIBEUI_V2");
        }
        String hf2 = hf("ro.build.version.incremental");
        return !TextUtils.isEmpty(hf2) && hf2.contains("VIBEUI_V2");
    }

    public static boolean f() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(hf);
    }

    public static boolean g() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("honor")) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        return (!TextUtils.isEmpty(str2) && str2.toLowerCase().startsWith("honor")) || "HONOR".equalsIgnoreCase(str2);
    }

    public static String hf() {
        if (qt()) {
            return zg();
        }
        if (y()) {
            return yo();
        }
        if (v()) {
            return pz();
        }
        String e = e();
        if (!TextUtils.isEmpty(e)) {
            return e;
        }
        if (c()) {
            return kd();
        }
        if (f()) {
            return d();
        }
        if (u()) {
            return w();
        }
        String tf = tf();
        return !TextUtils.isEmpty(tf) ? tf : Build.DISPLAY;
    }

    public static boolean ht() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        return str.toLowerCase(Locale.ENGLISH).contains("meizu");
    }

    public static boolean io() {
        return ai().toUpperCase().contains("NUBIA");
    }

    public static boolean jk() {
        if (Build.MANUFACTURER.equalsIgnoreCase(ADBidEvent.XIAOMI)) {
            return true;
        }
        String str = Build.BRAND;
        return str.equalsIgnoreCase(ADBidEvent.XIAOMI) || str.equalsIgnoreCase("REDMI");
    }

    public static String kd() {
        return hf("ro.vivo.os.build.display.id") + "_" + hf("ro.vivo.product.version");
    }

    public static boolean p() {
        return !TextUtils.isEmpty(hf("ro.letv.release.version"));
    }

    public static boolean pl() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("huawei")) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str2) && str2.toLowerCase().startsWith("huawei");
    }

    public static String pz() {
        if (!v()) {
            return "";
        }
        return "coloros_" + hf("ro.build.version.opporom") + "_" + Build.DISPLAY;
    }

    public static boolean qt() {
        try {
            return Class.forName("miui.os.Build").getName().length() > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean ra() {
        return "OnePlus".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static String tf() {
        if (!p()) {
            return "";
        }
        return "eui_" + hf("ro.letv.release.version") + "_" + Build.DISPLAY;
    }

    public static boolean u() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static boolean v() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme");
    }

    public static String w() {
        return hf("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean x() {
        return ai().toUpperCase().contains("ASUS");
    }

    public static String xj() {
        return hf("ro.build.version.emui");
    }

    public static boolean y() {
        String str = Build.DISPLAY;
        return (!TextUtils.isEmpty(str) && str.contains("Flyme")) || "flyme".equals(Build.USER);
    }

    public static String yo() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static String zg() {
        if (!qt()) {
            return "";
        }
        return "miui_" + hf("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    public static boolean xj(String str) {
        if (TextUtils.isEmpty(str)) {
            str = xj();
        }
        return (!TextUtils.isEmpty(str) && (str.toLowerCase().contains("emotionui") || str.toLowerCase().contains("magicui"))) || pl() || g();
    }

    public static boolean xj(Context context) {
        return ai().toUpperCase().contains(ADBidEvent.HUAWEI);
    }

    private static String hf(String str) {
        String xj2 = vi.xj(str);
        return !TextUtils.isEmpty(xj2) ? xj2 : no.xj(str);
    }
}

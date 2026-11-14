package com.bytedance.msdk.f;

import B4ZgIw.AYUAbz;
import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class x {
    private static final CharSequence w = "sony";
    private static final CharSequence u = "amigo";
    private static final CharSequence kd = "funtouch";
    private static final ExecutorService y = com.bytedance.msdk.xj.kd.y.xj("romutils", 2, new RejectedExecutionHandler() { // from class: com.bytedance.msdk.f.x.1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    });
    public static boolean xj = false;
    public static boolean hf = false;

    public static class xj implements Callable<String> {
        private final String xj;

        public xj(String str) {
            this.xj = str;
        }

        @Override // java.util.concurrent.Callable
        public String call() {
            long currentTimeMillis = System.currentTimeMillis();
            String hf = x.hf(this.xj);
            com.bytedance.msdk.xj.kd.w.xj("RomUtils", "property:" + hf + ",getSystemProperty use time :" + (System.currentTimeMillis() - currentTimeMillis));
            if (!TextUtils.isEmpty(hf)) {
                try {
                    com.bytedance.msdk.xj.kd.w.w("RomUtils", "SP-getPropertyFromSP:".concat(String.valueOf(hf)));
                    ai.xj("rom_info", com.bytedance.msdk.core.hf.getContext()).xj("rom_property_info", hf);
                } catch (Throwable unused) {
                }
            }
            return hf;
        }
    }

    static {
        tGGgPJ();
    }

    public static String am() {
        return w("ro.build.version.emui");
    }

    public static boolean c() {
        String w2 = w("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(w2) && w2.toLowerCase().contains(kd);
    }

    public static String d() {
        return Build.DISPLAY + "_" + w("ro.gn.sv.version");
    }

    public static String e() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static boolean f() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(u);
    }

    public static String g() {
        String am = am();
        if (am == null || !am.toLowerCase().contains("emotionui")) {
            return "";
        }
        StringBuilder A5SV6n2 = AYUAbz.A5SV6n(am, "_");
        A5SV6n2.append(Build.DISPLAY);
        return A5SV6n2.toString();
    }

    public static boolean hf() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    private static String jk() {
        try {
            String hf2 = ai.xj("rom_info", com.bytedance.msdk.core.hf.getContext()).hf("rom_property_info", "");
            com.bytedance.msdk.xj.kd.w.hf("RomUtils", "get Property From SP...=".concat(String.valueOf(hf2)));
            return hf2;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean kd() {
        if (!hf) {
            try {
                Class.forName("miui.os.Build");
                xj = true;
                hf = true;
                return true;
            } catch (Exception unused) {
                hf = true;
            }
        }
        return xj;
    }

    public static boolean p() {
        return !TextUtils.isEmpty(w("ro.letv.release.version"));
    }

    public static String pl() {
        if (!kd()) {
            return "";
        }
        return "miui_" + w("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    public static boolean qt() {
        return "smartisan".equalsIgnoreCase(Build.MANUFACTURER) || "smartisan".equalsIgnoreCase(Build.BRAND);
    }

    private static /* synthetic */ void tGGgPJ() {
        char[] charArray = "<02q8>2:q=0&q,7:33q\u001516\u001d-6;8:".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '_');
        }
        String str = new String(charArray);
        char[] charArray2 = "<3616+".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '_');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static String tf() {
        if (!p()) {
            return "";
        }
        return "eui_" + w("ro.letv.release.version") + "_" + Build.DISPLAY;
    }

    public static boolean u() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String v() {
        if (!yo()) {
            return "";
        }
        return "coloros_" + w("ro.build.version.opporom") + "_" + Build.DISPLAY;
    }

    public static String w() {
        return w("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static String y() {
        return w("ro.vivo.os.build.display.id") + "_" + w("ro.vivo.product.version");
    }

    public static boolean yo() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains("oppo");
    }

    public static String zg() {
        if (qt()) {
            try {
                return "smartisan_".concat(String.valueOf(w("ro.smartisan.version")));
            } catch (Throwable unused) {
            }
        }
        return Build.DISPLAY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String hf(String str) {
        com.bytedance.sdk.component.u.p pVar = (com.bytedance.sdk.component.u.p) com.bytedance.sdk.openadsdk.ats.w.xj("system_info");
        return pVar != null ? pVar.get(str) : "";
    }

    private static String w(String str) {
        String str2;
        try {
            str2 = jk();
            try {
                if (TextUtils.isEmpty(str2)) {
                    FutureTask futureTask = new FutureTask(new xj(str));
                    y.execute(futureTask);
                    str2 = (String) futureTask.get(1L, TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            str2 = "";
        }
        return str2 == null ? "" : str2;
    }

    public static String xj() {
        if (qt()) {
            return zg();
        }
        if (kd()) {
            return pl();
        }
        if (hf()) {
            return e();
        }
        if (yo()) {
            return v();
        }
        String g = g();
        if (!TextUtils.isEmpty(g)) {
            return g;
        }
        if (c()) {
            return y();
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
}

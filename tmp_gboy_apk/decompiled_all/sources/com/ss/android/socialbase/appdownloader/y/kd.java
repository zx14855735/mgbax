package com.ss.android.socialbase.appdownloader.y;

import ADYaiT.CtFAbx;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.octopus.ad.ADBidEvent;
import com.ss.android.socialbase.appdownloader.c;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class kd {
    private static String c = null;
    private static Boolean f = null;
    public static String hf = "";
    private static String kd = null;
    private static String u = "";
    public static String w;
    public static String xj;
    private static String y;

    public static boolean am() {
        v();
        return "V11".equals(c);
    }

    public static boolean c() {
        return xj("SAMSUNG");
    }

    public static String d() {
        if (y == null) {
            xj("");
        }
        return y;
    }

    public static boolean e() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("honor")) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str2) && str2.toLowerCase().startsWith("honor");
    }

    public static String f() {
        if (kd == null) {
            xj("");
        }
        return kd;
    }

    public static boolean g() {
        v();
        return "V10".equals(c);
    }

    public static boolean hf() {
        return xj("MAGICUI");
    }

    public static boolean kd() {
        yo();
        return xj(xj);
    }

    public static String p() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    public static String pl() {
        String str = Build.DISPLAY;
        return str == null ? "" : str.trim();
    }

    public static boolean qt() {
        v();
        return "V12".equals(c);
    }

    public static String tf() {
        if (w == null) {
            xj("");
        }
        return w;
    }

    public static boolean u() {
        return xj(ADBidEvent.VIVO);
    }

    private static void v() {
        if (c == null) {
            try {
                c = u("ro.miui.ui.version.name");
            } catch (Exception e) {
                pl.xj(e);
            }
            String str = c;
            if (str == null) {
                str = "";
            }
            c = str;
        }
    }

    public static boolean w() {
        return xj("MIUI");
    }

    public static boolean xj() {
        return xj("EMUI") || xj("MAGICUI");
    }

    public static boolean y() {
        return xj("FLYME");
    }

    private static void yo() {
        if (TextUtils.isEmpty(xj)) {
            com.ss.android.socialbase.downloader.downloader.w.l();
            xj = com.ss.android.socialbase.downloader.constants.kd.hf;
            u = CtFAbx.B25kr6(new StringBuilder("ro.build.version."), com.ss.android.socialbase.downloader.constants.kd.w, "rom");
            hf = CtFAbx.B25kr6(new StringBuilder("com."), com.ss.android.socialbase.downloader.constants.kd.w, ".market");
        }
    }

    public static boolean zg() {
        if (f == null) {
            f = Boolean.valueOf(u.c().equals("harmony"));
        }
        return f.booleanValue();
    }

    public static String hf(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            com.ss.android.socialbase.downloader.tf.y.xj(bufferedReader);
            return readLine;
        } catch (Throwable unused2) {
            com.ss.android.socialbase.downloader.tf.y.xj(bufferedReader);
            return null;
        }
    }

    public static String u(String str) {
        if (com.ss.android.socialbase.downloader.f.xj.hf().optBoolean("enable_reflect_system_properties", true)) {
            try {
                return w(str);
            } catch (Throwable th) {
                pl.xj(th);
            }
        }
        return hf(str);
    }

    public static String w(String str) {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
    }

    public static boolean xj(String str) {
        yo();
        String str2 = kd;
        if (str2 != null) {
            return str2.equals(str);
        }
        String u2 = u("ro.miui.ui.version.name");
        y = u2;
        if (TextUtils.isEmpty(u2)) {
            String u3 = u("ro.build.version.emui");
            y = u3;
            if (TextUtils.isEmpty(u3)) {
                String u4 = u("ro.build.version.magic");
                y = u4;
                if (TextUtils.isEmpty(u4)) {
                    String u5 = u(u);
                    y = u5;
                    if (TextUtils.isEmpty(u5)) {
                        String u6 = u("ro.vivo.os.version");
                        y = u6;
                        if (TextUtils.isEmpty(u6)) {
                            String u7 = u("ro.smartisan.version");
                            y = u7;
                            if (TextUtils.isEmpty(u7)) {
                                String u8 = u("ro.gn.sv.version");
                                y = u8;
                                if (TextUtils.isEmpty(u8)) {
                                    String u9 = u("ro.lenovo.lvp.version");
                                    y = u9;
                                    if (!TextUtils.isEmpty(u9)) {
                                        kd = "LENOVO";
                                        w = "com.lenovo.leos.appstore";
                                    } else if (p().toUpperCase().contains("SAMSUNG")) {
                                        kd = "SAMSUNG";
                                        w = "com.sec.android.app.samsungapps";
                                    } else if (p().toUpperCase().contains("ZTE")) {
                                        kd = "ZTE";
                                        w = "zte.com.market";
                                    } else if (p().toUpperCase().contains("NUBIA")) {
                                        kd = "NUBIA";
                                        w = "cn.nubia.neostore";
                                    } else if (pl().toUpperCase().contains("FLYME")) {
                                        kd = "FLYME";
                                        w = "com.meizu.mstore";
                                        y = pl();
                                    } else if (p().toUpperCase().contains("ONEPLUS")) {
                                        kd = "ONEPLUS";
                                        y = u("ro.rom.version");
                                        if (c.xj(hf) >= 0) {
                                            w = hf;
                                        } else {
                                            w = "com.heytap.market";
                                        }
                                    } else {
                                        kd = p().toUpperCase();
                                        w = "";
                                        y = "";
                                    }
                                } else {
                                    kd = "QIONEE";
                                    w = "com.gionee.aora.market";
                                }
                            } else {
                                kd = "SMARTISAN";
                                w = "com.smartisanos.appstore";
                            }
                        } else {
                            kd = ADBidEvent.VIVO;
                            w = "com.bbk.appstore";
                        }
                    } else {
                        kd = xj;
                        if (c.xj(hf) >= 0) {
                            w = hf;
                        } else {
                            w = "com.heytap.market";
                        }
                    }
                } else {
                    kd = "MAGICUI";
                    w = "com.hihonor.appmarket";
                }
            } else {
                String str3 = e() ? "MAGICUI" : "EMUI";
                kd = str3;
                if (TextUtils.equals(str3, "MAGICUI")) {
                    w = "com.hihonor.appmarket";
                } else {
                    w = "com.huawei.appmarket";
                }
            }
        } else {
            kd = "MIUI";
            w = "com.xiaomi.market";
            c = y;
        }
        return kd.equals(str);
    }
}

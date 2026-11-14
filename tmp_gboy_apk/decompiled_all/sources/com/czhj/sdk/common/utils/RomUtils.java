package com.czhj.sdk.common.utils;

import ADYaiT.CtFAbx;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Properties;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class RomUtils {
    private static final String A = "ro.build.uiversion";
    private static final String B = "ro.build.MiFavor_version";
    private static final String C = "ro.rom.version";
    private static final String D = "ro.build.rom.id";
    private static final String E = "hw_sc.build.platform.version";
    private static final String G = "unknown";
    private static final String v = "ro.build.version.emui";
    private static final String w = "ro.vivo.os.build.display.id";
    private static final String x = "ro.build.version.incremental";
    private static final String z = "ro.letv.release.version";

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f10610a = {"huawei"};
    private static final String[] b = {"vivo"};
    private static final String[] c = {MediationConstant.ADN_XIAOMI};
    private static final String[] d = {"oppo"};
    private static final String[] e = {"leeco", "letv"};
    private static final String[] f = {"360", "qiku"};
    private static final String[] g = {"zte"};
    private static final String[] h = {"oneplus"};
    private static final String[] i = {"nubia"};
    private static final String[] j = {"coolpad", "yulong"};
    private static final String[] k = {"lg", "lge"};
    private static final String[] l = {"google"};
    private static final String[] m = {"samsung"};
    private static final String[] n = {"meizu"};
    private static final String[] o = {"lenovo"};
    private static final String[] p = {"SmartisanOS", "deltainno"};
    private static final String[] q = {"Sense", "htc"};
    private static final String[] r = {"sony"};
    private static final String[] s = {"amigo", "gionee"};
    private static final String[] t = {"motorola"};
    private static final String[] u = {"honor"};
    private static final String[] y = {"ro.build.version.opporom", "ro.build.version.oplusrom.display"};
    private static final String[] F = {"msc.config.magic.version", "ro.build.version.magic"};
    private static RomInfo H = null;

    public static class RomInfo {

        /* renamed from: a, reason: collision with root package name */
        private String f10611a;
        private String b;
        private String c;

        public String getName() {
            return this.f10611a;
        }

        public String getOsMarket() {
            return this.c;
        }

        public String getVersion() {
            return this.b;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("RomInfo{name=");
            sb.append(this.f10611a);
            sb.append(", version=");
            sb.append(this.b);
            sb.append(", osMarket=");
            return CtFAbx.B25kr6(sb, this.c, "}");
        }
    }

    static {
        VmBaco();
    }

    private RomUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static /* synthetic */ void VmBaco() {
        char[] charArray = "ùõ÷´ýû÷ÿ´øõã´éòÿöö´ÐôóØèóþýÿ".toCharArray();
        int length = charArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            charArray[i2] = (char) (charArray[i2] ^ 154);
        }
        String str = new String(charArray);
        char[] charArray2 = "ùöóôóî".toCharArray();
        int length2 = charArray2.length;
        for (int i3 = 0; i3 < length2; i3++) {
            charArray2[i3] = (char) (charArray2[i3] ^ 154);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static String a(String str) {
        String b2 = !TextUtils.isEmpty(str) ? b(str) : "";
        if (TextUtils.isEmpty(b2) || b2.equals("unknown")) {
            try {
                String str2 = Build.DISPLAY;
                if (!TextUtils.isEmpty(str2)) {
                    b2 = str2.toLowerCase();
                }
            } catch (Throwable unused) {
            }
        }
        return TextUtils.isEmpty(b2) ? "unknown" : b2;
    }

    private static String b(String str) {
        String c2 = c(str);
        if (!TextUtils.isEmpty(c2)) {
            return c2;
        }
        String d2 = d(str);
        return (TextUtils.isEmpty(d2) && Build.VERSION.SDK_INT < 28) ? e(str) : d2;
    }

    private static String c() {
        try {
            String str = Build.MANUFACTURER;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    private static String d() {
        try {
            String str = Build.BRAND;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    private static String e(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static RomInfo getRomInfo() {
        RomInfo romInfo;
        RomInfo romInfo2;
        String str;
        RomInfo romInfo3;
        String str2;
        RomInfo romInfo4;
        String str3;
        RomInfo romInfo5;
        String str4;
        RomInfo romInfo6;
        String str5;
        RomInfo romInfo7 = H;
        if (romInfo7 != null) {
            return romInfo7;
        }
        H = new RomInfo();
        String d2 = d();
        String c2 = c();
        if (isHarmonyOs()) {
            H.f10611a = "harmony";
            romInfo6 = H;
            str5 = a(E);
        } else {
            if (!a(d2, c2, f10610a)) {
                int i2 = 0;
                if (a(d2, c2, u)) {
                    H.f10611a = "MagicOS";
                    String[] strArr = F;
                    int length = strArr.length;
                    while (i2 < length) {
                        String str6 = strArr[i2];
                        String a2 = a(str6);
                        if (!TextUtils.isEmpty(str6)) {
                            H.b = a2;
                        }
                        i2++;
                    }
                    romInfo4 = H;
                    str3 = "com.hihonor.appmarket";
                } else if (a(d2, c2, b)) {
                    H.f10611a = "OriginOS";
                    H.b = a(w);
                    romInfo4 = H;
                    str3 = "com.bbk.appstore";
                } else {
                    if (!a(d2, c2, c)) {
                        if (a(d2, c2, d)) {
                            H.f10611a = "ColorOS";
                            String[] strArr2 = y;
                            int length2 = strArr2.length;
                            while (i2 < length2) {
                                String str7 = strArr2[i2];
                                String a3 = a(str7);
                                if (!TextUtils.isEmpty(str7)) {
                                    H.b = a3;
                                }
                                i2++;
                            }
                            if (Build.VERSION.SDK_INT < 29) {
                                romInfo5 = H;
                                str4 = "com.oppo.market";
                            } else {
                                romInfo5 = H;
                                str4 = "com.heytap.market";
                            }
                            romInfo5.c = str4;
                            return H;
                        }
                        if (a(d2, c2, e)) {
                            H.f10611a = "EUI";
                            romInfo3 = H;
                            str2 = z;
                        } else {
                            String[] strArr3 = f;
                            if (a(d2, c2, strArr3)) {
                                H.f10611a = strArr3[0];
                                romInfo3 = H;
                                str2 = A;
                            } else {
                                String[] strArr4 = g;
                                if (a(d2, c2, strArr4)) {
                                    H.f10611a = strArr4[0];
                                    romInfo3 = H;
                                    str2 = B;
                                } else {
                                    String[] strArr5 = h;
                                    if (a(d2, c2, strArr5)) {
                                        H.f10611a = strArr5[0];
                                        romInfo3 = H;
                                        str2 = C;
                                    } else if (a(d2, c2, i)) {
                                        H.f10611a = "NubiaUI";
                                        H.b = a(D);
                                        romInfo4 = H;
                                        str3 = "cn.nubia.neostore";
                                    } else {
                                        String[] strArr6 = j;
                                        if (a(d2, c2, strArr6)) {
                                            romInfo = H;
                                            c2 = strArr6[0];
                                        } else {
                                            String[] strArr7 = k;
                                            if (a(d2, c2, strArr7)) {
                                                romInfo = H;
                                                c2 = strArr7[0];
                                            } else {
                                                String[] strArr8 = l;
                                                if (a(d2, c2, strArr8)) {
                                                    romInfo = H;
                                                    c2 = strArr8[0];
                                                } else {
                                                    String[] strArr9 = m;
                                                    if (a(d2, c2, strArr9)) {
                                                        romInfo = H;
                                                        c2 = strArr9[0];
                                                    } else {
                                                        if (a(d2, c2, n)) {
                                                            H.f10611a = "Flyme";
                                                            romInfo2 = H;
                                                            str = "com.meizu.mstore";
                                                        } else {
                                                            String[] strArr10 = o;
                                                            if (a(d2, c2, strArr10)) {
                                                                romInfo = H;
                                                                c2 = strArr10[0];
                                                            } else {
                                                                String[] strArr11 = p;
                                                                if (a(d2, c2, strArr11)) {
                                                                    H.f10611a = strArr11[0];
                                                                    romInfo2 = H;
                                                                    str = "com.smartisanos.appstore";
                                                                } else {
                                                                    String[] strArr12 = q;
                                                                    if (a(d2, c2, strArr12)) {
                                                                        romInfo = H;
                                                                        c2 = strArr12[0];
                                                                    } else {
                                                                        String[] strArr13 = r;
                                                                        if (a(d2, c2, strArr13)) {
                                                                            romInfo = H;
                                                                            c2 = strArr13[0];
                                                                        } else {
                                                                            String[] strArr14 = s;
                                                                            if (a(d2, c2, strArr14)) {
                                                                                romInfo = H;
                                                                                c2 = strArr14[0];
                                                                            } else {
                                                                                String[] strArr15 = t;
                                                                                if (a(d2, c2, strArr15)) {
                                                                                    romInfo = H;
                                                                                    c2 = strArr15[0];
                                                                                } else {
                                                                                    romInfo = H;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        romInfo2.c = str;
                                                        romInfo3 = H;
                                                        str2 = "";
                                                    }
                                                }
                                            }
                                        }
                                        romInfo.f10611a = c2;
                                        romInfo3 = H;
                                        str2 = "";
                                    }
                                }
                            }
                        }
                        romInfo3.b = a(str2);
                        return H;
                    }
                    H.f10611a = "MIUI";
                    H.b = a(x);
                    romInfo4 = H;
                    str3 = "com.xiaomi.market";
                }
                romInfo4.c = str3;
                return H;
            }
            H.f10611a = "EMUI";
            String a4 = a(v);
            String[] split = a4.split("_");
            if (split.length <= 1) {
                H.b = a4;
                H.c = "com.huawei.appmarket";
                return H;
            }
            romInfo6 = H;
            str5 = split[1];
        }
        romInfo6.b = str5;
        H.c = "com.huawei.appmarket";
        return H;
    }

    public static boolean isHarmonyOs() {
        if (Build.VERSION.SDK_INT < 29) {
            return false;
        }
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            Object invoke = cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
            if (invoke == null) {
                return false;
            }
            return "harmony".equalsIgnoreCase(invoke.toString());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isHuawei() {
        return "EMUI".equals(getRomInfo().f10611a) || isHarmonyOs();
    }

    public static boolean a() {
        return a(d(), c(), u);
    }

    private static boolean b() {
        return !TextUtils.isEmpty(b(v));
    }

    private static String c(String str) {
        BufferedReader bufferedReader;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                try {
                    readLine = bufferedReader.readLine();
                } catch (Throwable unused) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 == null) {
                        return "";
                    }
                    bufferedReader2.close();
                    return "";
                }
            } catch (Throwable unused2) {
            }
            if (readLine != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused3) {
                }
                return readLine;
            }
            bufferedReader.close();
            return "";
        } catch (Throwable unused4) {
            return "";
        }
    }

    private static String d(String str) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            return properties.getProperty(str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    private static boolean a(String str, String str2, String... strArr) {
        for (String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }
}

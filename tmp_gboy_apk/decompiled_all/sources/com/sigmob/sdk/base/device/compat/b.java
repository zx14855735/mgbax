package com.sigmob.sdk.base.device.compat;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import io.dcloud.openapi.core.util.Const;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b {
    static final String[] A;
    static final String B = "EMUI";
    static final String C = "ro.build.version.emui";
    static final String D = "OneUI";
    static final String E = "ro.build.version.oneui";
    static final String F = "OxygenOS";
    static final String G = "ro.oxygen.version";
    static final String H = "H2OS";
    static final String I = "ro.rom.version";
    static final String J = "Flyme";
    static final String K = "ro.flyme.version.id";
    static final String L = "ro.build.display.id";
    static final String[] M;
    static final String N = "ro.build.MiFavor_version";
    static final String[] O;
    static final String P = "ro.build.display.id";
    static final String Q = "RedMagicOS";
    static final String R = "MyOS";
    static final String S = "MifavorUI";
    static final String T = "ro.build.MiFavor_version";
    static final String U = "SmartisanOS";
    static final String V = "ro.smartisan.version";
    static final String[] W;
    static final String X = "EUI";
    static final String Y = "ro.letv.release.version";
    static final String[] Z;

    /* renamed from: a, reason: collision with root package name */
    static final String f13171a = "\\d+(?:\\.\\d+)+";
    static final String aa = "ZUXOS";
    static final String[] ab;
    static final String ac = "ro.config.lgsi.os.name";
    static final String ad = "ZUI";
    static final String ae = "ro.com.zui.version";
    static final String[] af;
    static final String ag = "nubiaUI";
    static final String ah = "ro.build.nubia.rom.code";
    static final String ai = "ro.build.nubia.rom.name";
    static final String aj = "360UI";
    static final String ak = "ro.build.uiversion";
    private static String al = null;
    private static String am = null;
    private static String an = null;
    static final String b = "\\d+";
    static final String c = "ro.build.version.incremental";
    static final String d = "ro.build.display.id";
    static final String[] e = {"ro.build.display.id", "ro.build.version.incremental"};
    static final String[] f;
    static final String g = "HyperOS";
    static final String h = "ro.mi.os.version.incremental";
    static final String[] i;
    static final String[] j;
    static final String k = "MIUI";
    static final String l = "ro.build.version.incremental";
    static final String[] m;
    static final String[] n;
    static final String o = "realmeUI";
    static final String p = "ro.build.version.realmeui";
    static final String q = "ColorOS";
    static final String[] r;
    static final String s = "ro.vivo.os.build.display.id";
    static final String t = "OriginOS";
    static final String[] u;
    static final String v = "FuntouchOS";
    static final String[] w;
    static final String x = "MagicOS";
    static final String[] y;
    static final String z = "HarmonyOS";

    /* JADX WARN: Removed duplicated region for block: B:111:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0182 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02d3  */
    static {
        /*
            Method dump skipped, instructions count: 1005
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.device.compat.b.<clinit>():void");
    }

    private b() {
    }

    public static boolean A() {
        return TextUtils.equals(al, ag);
    }

    public static boolean B() {
        return TextUtils.equals(al, aj);
    }

    public static String C() {
        String str = al;
        return str != null ? str : "";
    }

    public static String D() {
        String str = an;
        return str != null ? str : "";
    }

    public static String E() {
        String str = am;
        return str != null ? str : "";
    }

    public static int F() {
        String D2 = D();
        if (TextUtils.isEmpty(D2)) {
            return 0;
        }
        String[] split = D2.split("\\.");
        if (split.length == 0) {
            return 0;
        }
        try {
            return Integer.parseInt(split[0]);
        } catch (Exception unused) {
            return -1;
        }
    }

    @SuppressLint({"PrivateApi"})
    private static boolean G() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return Boolean.parseBoolean(String.valueOf(cls.getMethod("getBoolean", String.class, Boolean.TYPE).invoke(cls, "persist.sys.miui_optimization", Boolean.valueOf(!"1".equals(String.valueOf(cls.getMethod("get", String.class, String.class).invoke(cls, "ro.miui.cts", "")))))));
        } catch (Exception unused) {
            return true;
        }
    }

    private static String a(int i2) {
        int i3 = i2 / 10000;
        int i4 = i2 % 10000;
        int i5 = i2 % 100;
        if (i5 <= 0) {
            return i3 + "." + (i4 / 100);
        }
        return i3 + "." + (i4 / 100) + "." + i5;
    }

    public static boolean b() {
        if (!a()) {
            return false;
        }
        for (String str : c.a(j)) {
            if (str.equalsIgnoreCase("cn")) {
                return true;
            }
        }
        return false;
    }

    public static boolean c() {
        if (!a()) {
            return false;
        }
        for (String str : c.a(j)) {
            if (str.equalsIgnoreCase(Const.PROVIDER_TYPE_GLOBAL)) {
                return true;
            }
        }
        return false;
    }

    public static boolean d() {
        return G();
    }

    public static boolean e() {
        return TextUtils.equals(al, k);
    }

    public static boolean f() {
        if (!e()) {
            return false;
        }
        for (String str : c.a(n)) {
            if (str.equalsIgnoreCase("cn")) {
                return true;
            }
        }
        return false;
    }

    public static boolean g() {
        if (!e()) {
            return false;
        }
        for (String str : c.a(n)) {
            if (str.equalsIgnoreCase(Const.PROVIDER_TYPE_GLOBAL)) {
                return true;
            }
        }
        return false;
    }

    public static boolean h() {
        return G();
    }

    public static boolean i() {
        return TextUtils.equals(al, o);
    }

    public static boolean j() {
        return TextUtils.equals(al, q);
    }

    public static boolean k() {
        return TextUtils.equals(al, t);
    }

    public static boolean l() {
        return TextUtils.equals(al, v);
    }

    public static boolean m() {
        return TextUtils.equals(al, x);
    }

    public static boolean n() {
        return TextUtils.equals(al, z);
    }

    public static boolean o() {
        return TextUtils.equals(al, B);
    }

    public static boolean p() {
        return TextUtils.equals(al, D);
    }

    public static boolean q() {
        return TextUtils.equals(al, F);
    }

    public static boolean r() {
        return TextUtils.equals(al, H);
    }

    public static boolean s() {
        return TextUtils.equals(al, J);
    }

    public static boolean t() {
        return TextUtils.equals(al, Q);
    }

    public static boolean u() {
        return TextUtils.equals(al, R);
    }

    public static boolean v() {
        return TextUtils.equals(al, S);
    }

    public static boolean w() {
        return TextUtils.equals(al, U);
    }

    public static boolean x() {
        return TextUtils.equals(al, X);
    }

    public static boolean y() {
        return TextUtils.equals(al, aa);
    }

    public static boolean z() {
        return TextUtils.equals(al, ad);
    }

    private static String a(String str) {
        String group;
        String group2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Matcher matcher = Pattern.compile("(\\d+(?:\\.\\d+)+)").matcher(str);
        if (matcher.find() && matcher.groupCount() > 0 && (group2 = matcher.group(1)) != null) {
            return group2;
        }
        Matcher matcher2 = Pattern.compile("(\\d+)").matcher(str);
        return (!matcher2.find() || matcher2.groupCount() <= 0 || (group = matcher2.group(1)) == null) ? "" : group.concat(".0");
    }

    public static boolean a() {
        return TextUtils.equals(al, g);
    }
}

package com.sigmob.sdk.base.device.compat;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a {
    private static final String A = "Smartisan";
    private static final String[] B;
    private static final String C = "CoolPad";
    private static final String[] D;
    private static final String E = "LG";
    private static final String[] F;
    private static final String G = "Google";
    private static final String[] H;
    private static final String I = "MeiZu";
    private static final String[] J;
    private static final String K = "Lenovo";
    private static final String[] L;
    private static final String M = "HTC";
    private static final String[] N;
    private static final String O = "Sony";
    private static final String[] P;
    private static final String Q = "Gionee";
    private static final String[] R;
    private static final String S = "Motorola";
    private static final String[] T;
    private static final String U = "Asus";
    private static final String[] V;
    private static final String W = "Transsion";
    private static final String[] X;
    private static final String Y = "DOOV";
    private static final String[] Z;

    /* renamed from: a, reason: collision with root package name */
    private static final String f13170a = "HuaWei";
    private static final String aa = "Philips";
    private static final String[] ab;
    private static final String ac = "BlackShark";
    private static final String[] ad;
    private static final String ae = "Hisense";
    private static final String[] af;
    private static final String ag = "K-Touch";
    private static final String[] ah;
    private static final String ai = "MeiTu";
    private static final String[] aj;
    private static final String ak = "Nokia";
    private static final String[] al;
    private static final String am;
    private static final String[] b;
    private static final String c = "Vivo";
    private static final String[] d;
    private static final String e = "XiaoMi";
    private static final String[] f;
    private static final String g = "RedMi";
    private static final String[] h;
    private static final String i = "Oppo";
    private static final String[] j;
    private static final String k = "RealMe";
    private static final String[] l;
    private static final String m = "LeEco";
    private static final String[] n;
    private static final String o = "360";
    private static final String[] p;
    private static final String q = "ZTE";
    private static final String[] r;
    private static final String s = "OnePlus";
    private static final String[] t;
    private static final String u = "Nubia";
    private static final String[] v;
    private static final String w = "Samsung";
    private static final String[] x;
    private static final String y = "Honor";
    private static final String[] z;

    static {
        String str;
        String[] strArr = {"huawei"};
        b = strArr;
        String[] strArr2 = {"vivo"};
        d = strArr2;
        String[] strArr3 = {MediationConstant.ADN_XIAOMI};
        f = strArr3;
        String[] strArr4 = {"redmi"};
        h = strArr4;
        String[] strArr5 = {"oppo"};
        j = strArr5;
        String[] strArr6 = {"realme"};
        l = strArr6;
        String[] strArr7 = {"leeco", "letv"};
        n = strArr7;
        String[] strArr8 = {o, "qiku"};
        p = strArr8;
        String[] strArr9 = {"zte"};
        r = strArr9;
        String[] strArr10 = {"oneplus"};
        t = strArr10;
        String[] strArr11 = {"nubia"};
        v = strArr11;
        String[] strArr12 = {"samsung"};
        x = strArr12;
        String[] strArr13 = {"honor"};
        z = strArr13;
        String[] strArr14 = {"smartisan", "deltainno"};
        B = strArr14;
        String[] strArr15 = {"coolpad", "yulong", "cp"};
        D = strArr15;
        String[] strArr16 = {"lg", "lge"};
        F = strArr16;
        String[] strArr17 = {"google"};
        H = strArr17;
        String[] strArr18 = {"meizu"};
        J = strArr18;
        String[] strArr19 = {"lenovo", "zuk"};
        L = strArr19;
        String[] strArr20 = {"htc"};
        N = strArr20;
        String[] strArr21 = {"sony"};
        P = strArr21;
        String[] strArr22 = {"gionee", "amigo"};
        R = strArr22;
        String[] strArr23 = {"motorola"};
        T = strArr23;
        String[] strArr24 = {"asus"};
        V = strArr24;
        String[] strArr25 = {"infinix mobility limited", "itel", "tecno"};
        X = strArr25;
        String[] strArr26 = {Y};
        Z = strArr26;
        String[] strArr27 = {"philips"};
        ab = strArr27;
        String[] strArr28 = {"blackshark"};
        ad = strArr28;
        String[] strArr29 = {"hisense"};
        af = strArr29;
        String[] strArr30 = {"k-touch", "ktouch"};
        ah = strArr30;
        String[] strArr31 = {"meitu"};
        aj = strArr31;
        String[] strArr32 = {"nokia"};
        al = strArr32;
        String lowerCase = Build.BRAND.toLowerCase();
        String lowerCase2 = Build.MANUFACTURER.toLowerCase();
        if (a(lowerCase, lowerCase2, strArr)) {
            str = f13170a;
        } else if (a(lowerCase, lowerCase2, strArr2)) {
            str = c;
        } else if (a(lowerCase, lowerCase2, strArr3)) {
            str = e;
        } else if (a(lowerCase, lowerCase2, strArr4)) {
            str = g;
        } else if (a(lowerCase, lowerCase2, strArr5)) {
            str = i;
        } else if (a(lowerCase, lowerCase2, strArr6)) {
            str = k;
        } else if (a(lowerCase, lowerCase2, strArr7)) {
            str = m;
        } else {
            if (a(lowerCase, lowerCase2, strArr8)) {
                am = o;
                return;
            }
            if (a(lowerCase, lowerCase2, strArr9)) {
                str = q;
            } else if (a(lowerCase, lowerCase2, strArr10)) {
                str = s;
            } else if (a(lowerCase, lowerCase2, strArr11)) {
                str = u;
            } else if (a(lowerCase, lowerCase2, strArr12)) {
                str = w;
            } else if (a(lowerCase, lowerCase2, strArr13)) {
                str = y;
            } else if (a(lowerCase, lowerCase2, strArr14)) {
                str = A;
            } else if (a(lowerCase, lowerCase2, strArr15)) {
                str = C;
            } else if (a(lowerCase, lowerCase2, strArr16)) {
                str = E;
            } else if (a(lowerCase, lowerCase2, strArr17)) {
                str = G;
            } else if (a(lowerCase, lowerCase2, strArr18)) {
                str = I;
            } else if (a(lowerCase, lowerCase2, strArr19)) {
                str = K;
            } else if (a(lowerCase, lowerCase2, strArr20)) {
                str = M;
            } else if (a(lowerCase, lowerCase2, strArr21)) {
                str = O;
            } else if (a(lowerCase, lowerCase2, strArr22)) {
                str = Q;
            } else if (a(lowerCase, lowerCase2, strArr23)) {
                str = S;
            } else if (a(lowerCase, lowerCase2, strArr24)) {
                str = U;
            } else if (a(lowerCase, lowerCase2, strArr25)) {
                str = W;
            } else {
                if (a(lowerCase, lowerCase2, strArr26)) {
                    am = Y;
                    return;
                }
                if (a(lowerCase, lowerCase2, strArr27)) {
                    str = aa;
                } else if (a(lowerCase, lowerCase2, strArr28)) {
                    str = ac;
                } else if (a(lowerCase, lowerCase2, strArr29)) {
                    str = ae;
                } else if (a(lowerCase, lowerCase2, strArr30)) {
                    str = ag;
                } else if (a(lowerCase, lowerCase2, strArr31)) {
                    str = ai;
                } else if (a(lowerCase, lowerCase2, strArr32)) {
                    str = ak;
                } else if (!TextUtils.isEmpty(lowerCase)) {
                    am = lowerCase;
                    return;
                } else {
                    if (!TextUtils.isEmpty(lowerCase2)) {
                        am = lowerCase2;
                        return;
                    }
                    str = "Unknown";
                }
            }
        }
        am = str;
    }

    public static boolean A() {
        return TextUtils.equals(am, ac);
    }

    public static boolean B() {
        return TextUtils.equals(am, ae);
    }

    public static boolean C() {
        return TextUtils.equals(am, ag);
    }

    public static boolean D() {
        return TextUtils.equals(am, ai);
    }

    public static boolean E() {
        return TextUtils.equals(am, ak);
    }

    public static String F() {
        return am;
    }

    public static boolean a() {
        return TextUtils.equals(am, f13170a);
    }

    public static boolean b() {
        return TextUtils.equals(am, y);
    }

    public static boolean c() {
        return TextUtils.equals(am, c);
    }

    public static boolean d() {
        return TextUtils.equals(am, e);
    }

    public static boolean e() {
        return TextUtils.equals(am, g);
    }

    public static boolean f() {
        return TextUtils.equals(am, i);
    }

    public static boolean g() {
        return TextUtils.equals(am, k);
    }

    public static boolean h() {
        return TextUtils.equals(am, m);
    }

    public static boolean i() {
        return TextUtils.equals(am, o);
    }

    public static boolean j() {
        return TextUtils.equals(am, q);
    }

    public static boolean k() {
        return TextUtils.equals(am, s);
    }

    public static boolean l() {
        return TextUtils.equals(am, u);
    }

    public static boolean m() {
        return TextUtils.equals(am, C);
    }

    public static boolean n() {
        return TextUtils.equals(am, E);
    }

    public static boolean o() {
        return TextUtils.equals(am, G);
    }

    public static boolean p() {
        return TextUtils.equals(am, w);
    }

    public static boolean q() {
        return TextUtils.equals(am, I);
    }

    public static boolean r() {
        return TextUtils.equals(am, K);
    }

    public static boolean s() {
        return TextUtils.equals(am, A);
    }

    public static boolean t() {
        return TextUtils.equals(am, M);
    }

    public static boolean u() {
        return TextUtils.equals(am, O);
    }

    public static boolean v() {
        return TextUtils.equals(am, Q);
    }

    public static boolean w() {
        return TextUtils.equals(am, S);
    }

    public static boolean x() {
        return TextUtils.equals(am, W);
    }

    public static boolean y() {
        return TextUtils.equals(am, Y);
    }

    public static boolean z() {
        return TextUtils.equals(am, aa);
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

package com.baidu.mobads.sdk.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class bn {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9763a = "mobads_builds";
    public static final String b = "brand_period";
    public static final String c = "version_period";
    public static final long d = 604800000;
    public static final long e = 172800000;
    public static final String f = "sdk_int";
    public static final String g = "sdk";
    public static final String h = "release";
    public static final String i = "model";
    public static final String j = "brand";
    public static final String k = "netopera";
    public static final String l = "tags";
    private int m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private Context t;
    private SharedPreferences u;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final bn f9764a = new bn();

        static {
            auDK();
        }

        private a() {
        }

        private static /* synthetic */ void auDK() {
            char[] charArray = "amo,ecog,`m{,qjgnn,Hlk@pkfeg".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 2);
            }
            String str = new String(charArray);
            char[] charArray2 = "anklkv".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 2);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static bn a(Context context) {
        a.f9764a.b(context);
        return a.f9764a;
    }

    private void h() {
        i();
        j();
    }

    private void i() {
        try {
            if (System.currentTimeMillis() <= b(b).longValue()) {
                this.p = a(i);
                this.q = a(j);
                this.r = a(k);
                this.s = a(l);
                return;
            }
            this.p = Build.MODEL;
            this.q = Build.BRAND;
            this.r = ((TelephonyManager) this.t.getSystemService("phone")).getNetworkOperator();
            this.s = Build.TAGS;
            a(i, this.p);
            a(j, this.q);
            a(k, this.r);
            a(l, this.s);
            a(b, Long.valueOf(System.currentTimeMillis() + d));
        } catch (Throwable th) {
            bv.a().c(th.getMessage());
        }
    }

    private void j() {
        try {
            if (System.currentTimeMillis() <= b(c).longValue()) {
                this.m = c(f);
                this.n = a(g);
                this.o = a("release");
                return;
            }
            int i2 = Build.VERSION.SDK_INT;
            this.m = i2;
            this.n = Build.VERSION.SDK;
            this.o = Build.VERSION.RELEASE;
            a(f, i2);
            a(g, this.n);
            a("release", this.o);
            a(c, Long.valueOf(System.currentTimeMillis() + e));
        } catch (Throwable th) {
            bv.a().c(th.getMessage());
        }
    }

    private SharedPreferences.Editor k() {
        return this.u.edit();
    }

    public void b(Context context) {
        if (this.t != null || context == null) {
            if (a.f9764a == null) {
                bc.a(context);
                return;
            }
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.t = applicationContext;
        try {
            if (this.u == null) {
                this.u = applicationContext.getSharedPreferences(f9763a, 0);
                h();
            }
        } catch (Throwable th) {
            bv.a().c(th.getMessage());
        }
    }

    public String c() {
        return this.o;
    }

    public String d() {
        return this.p;
    }

    public String e() {
        return this.q;
    }

    public String f() {
        return this.r;
    }

    public String g() {
        return this.s;
    }

    private bn() {
        this.m = 0;
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = "";
        this.s = "";
    }

    private int c(String str) {
        try {
            return this.u.getInt(str, 0);
        } catch (Throwable th) {
            bv.a().c(th.getMessage());
            return 0;
        }
    }

    public int a() {
        if (this.m == 0) {
            this.m = Build.VERSION.SDK_INT;
        }
        return this.m;
    }

    private String a(String str) {
        try {
            return this.u.getString(str, "");
        } catch (Throwable th) {
            bv.a().c(th.getMessage());
            return "";
        }
    }

    @TargetApi(9)
    private void a(String str, String str2) {
        try {
            SharedPreferences.Editor k2 = k();
            k2.putString(str, str2);
            k2.apply();
        } catch (Throwable th) {
            bv.a().c(th.getMessage());
        }
    }

    public String b() {
        if (TextUtils.isEmpty(this.n)) {
            this.n = Build.VERSION.SDK;
        }
        return this.n;
    }

    @TargetApi(9)
    private void a(String str, Long l2) {
        try {
            SharedPreferences.Editor k2 = k();
            k2.putLong(str, l2.longValue());
            k2.apply();
        } catch (Throwable th) {
            bv.a().c(th.getMessage());
        }
    }

    private Long b(String str) {
        try {
            return Long.valueOf(this.u.getLong(str, 0L));
        } catch (Throwable th) {
            bv.a().c(th.getMessage());
            return 0L;
        }
    }

    @TargetApi(9)
    private void a(String str, int i2) {
        try {
            SharedPreferences.Editor k2 = k();
            k2.putInt(str, i2);
            k2.apply();
        } catch (Throwable th) {
            bv.a().c(th.getMessage());
        }
    }
}

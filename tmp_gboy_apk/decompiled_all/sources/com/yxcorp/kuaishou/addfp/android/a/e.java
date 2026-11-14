package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f13878a;
    private SharedPreferences.Editor b;

    public e(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("kscfg_outdfp", 0);
            this.f13878a = sharedPreferences;
            this.b = sharedPreferences.edit();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(String str) {
        this.b.putString("kwtk", str);
        this.b.commit();
    }

    public String b() {
        return this.f13878a.getString("kwtk", "");
    }

    public boolean a() {
        return this.f13878a.getBoolean("xytk", true);
    }
}

package com.baidu.mobads.sdk.internal;

import android.util.Log;
import com.baidu.mobads.sdk.internal.az;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class aw extends az.a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9748a = "debug";

    @Override // com.baidu.mobads.sdk.internal.az.a
    public String a() {
        return f9748a;
    }

    @Override // com.baidu.mobads.sdk.internal.az.a
    public boolean a(String str, int i) {
        return az.f9750a.equals(str);
    }

    @Override // com.baidu.mobads.sdk.internal.az.a
    public void a(int i, String str, String str2, Throwable th) {
        a(i, str, str2);
    }

    private static void a(int i, String str, String str2) {
        if (i == 7) {
            try {
                Log.wtf(str, str2);
            } catch (Throwable unused) {
            }
        }
    }
}

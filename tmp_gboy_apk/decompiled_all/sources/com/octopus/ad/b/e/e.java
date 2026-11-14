package com.octopus.ad.b.e;

import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    String f12365a;
    Boolean b;

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f12365a, str);
    }

    public void b(String str) {
        this.f12365a = str;
    }

    public boolean b() {
        Boolean bool = this.b;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public boolean a() {
        return this.b != null;
    }

    public void a(boolean z) {
        this.b = Boolean.valueOf(z);
    }
}

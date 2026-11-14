package com.octopus.ad.b.h;

import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class f implements com.octopus.ad.b.c {

    /* renamed from: a, reason: collision with root package name */
    private boolean f12375a = false;

    @Override // com.octopus.ad.b.c
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.f12375a) {
            e.a(context);
            this.f12375a = true;
        }
        if (e.a()) {
            return e.b(context);
        }
        return null;
    }
}

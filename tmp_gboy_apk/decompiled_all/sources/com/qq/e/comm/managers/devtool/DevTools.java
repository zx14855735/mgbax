package com.qq.e.comm.managers.devtool;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class DevTools {

    /* renamed from: A2egSU, reason: collision with root package name */
    public String f12931A2egSU;

    public String getDemoGameUrl() {
        String str = this.f12931A2egSU;
        this.f12931A2egSU = null;
        return str;
    }

    public void testDemoGame(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context.getPackageName().equals("com.qq.e.union.demo.union")) {
            this.f12931A2egSU = str;
        }
    }
}

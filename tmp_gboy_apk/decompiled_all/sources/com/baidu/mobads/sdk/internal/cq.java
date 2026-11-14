package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class cq extends i {
    final /* synthetic */ cp b;

    public cq(cp cpVar) {
        this.b = cpVar;
    }

    @Override // com.baidu.mobads.sdk.internal.i
    public Object i() {
        String a2;
        String a3;
        Context context;
        String a4;
        try {
            a2 = this.b.a("key_crash_trace");
            a3 = this.b.a("key_crash_ad");
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            cm a5 = cm.a();
            context = this.b.m;
            a5.a(context);
            a4 = this.b.a("key_crash_source");
            a5.a(a4, a2, a3);
            this.b.g();
            return null;
        } catch (Exception e) {
            bv.a().a(e);
            return null;
        }
    }
}

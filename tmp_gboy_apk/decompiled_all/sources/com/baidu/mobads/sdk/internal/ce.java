package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.cp;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class ce implements cp.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ cb f9782a;

    public ce(cb cbVar) {
        this.f9782a = cbVar;
    }

    @Override // com.baidu.mobads.sdk.internal.cp.a
    public void a(String str) {
        try {
            this.f9782a.b();
            this.f9782a.a(str);
        } catch (Throwable th) {
            bv.a().a(th);
        }
    }
}

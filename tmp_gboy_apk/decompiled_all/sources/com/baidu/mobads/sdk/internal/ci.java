package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.ao;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class ci implements ao.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ cb f9784a;

    public ci(cb cbVar) {
        this.f9784a = cbVar;
    }

    @Override // com.baidu.mobads.sdk.internal.ao.a
    public void a() {
        boolean z;
        z = this.f9784a.A;
        if (z) {
            this.f9784a.A = false;
            this.f9784a.a(false, "remote update Network access failed");
        }
    }
}

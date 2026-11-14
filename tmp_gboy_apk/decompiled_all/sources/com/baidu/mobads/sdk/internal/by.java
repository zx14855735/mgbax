package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.ck;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class by implements ck.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bx f9774a;

    public by(bx bxVar) {
        this.f9774a = bxVar;
    }

    @Override // com.baidu.mobads.sdk.internal.ck.a
    public void a(bz bzVar) {
        this.f9774a.a(cb.k, bzVar, "download apk successfully, downloader exit");
        bx unused = bx.h = null;
    }

    @Override // com.baidu.mobads.sdk.internal.ck.a
    public void b(bz bzVar) {
        this.f9774a.a(cb.l, bzVar, "downloadApk failed");
    }
}

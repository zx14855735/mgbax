package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class n implements IOAdEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f9843a;

    public n(m mVar) {
        this.f9843a = mVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        bj.a(new o(this, iOAdEvent));
    }
}

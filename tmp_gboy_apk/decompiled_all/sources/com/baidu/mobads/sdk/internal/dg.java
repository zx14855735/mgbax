package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class dg implements IOAdEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ de f9818a;

    public dg(de deVar) {
        this.f9818a = deVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f9818a.z();
        }
    }
}

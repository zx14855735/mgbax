package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class cx implements IOAdEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ cv f9809a;

    public cx(cv cvVar) {
        this.f9809a = cvVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f9809a.h();
        }
    }
}

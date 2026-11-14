package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class ag implements IOAdEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ae f9732a;

    public ag(ae aeVar) {
        this.f9732a = aeVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f9732a.x();
        }
    }
}

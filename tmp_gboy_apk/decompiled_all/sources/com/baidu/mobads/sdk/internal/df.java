package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class df implements IOAdEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ de f9817a;

    public df(de deVar) {
        this.f9817a = deVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f9817a.c((Map<String, Object>) iOAdEvent.getData());
        }
    }
}

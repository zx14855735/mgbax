package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class dc implements IOAdEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ db f9814a;

    public dc(db dbVar) {
        this.f9814a = dbVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        bj.a(new dd(this, iOAdEvent));
    }
}

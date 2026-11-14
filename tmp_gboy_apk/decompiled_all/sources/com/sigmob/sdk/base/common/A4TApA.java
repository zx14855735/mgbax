package com.sigmob.sdk.base.common;

import com.sigmob.sdk.base.common.j;
import com.sigmob.sdk.base.utils.l;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class A4TApA implements j.a, l.a {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ AdActivity f13047A2egSU;

    public /* synthetic */ A4TApA(AdActivity adActivity) {
        this.f13047A2egSU = adActivity;
    }

    @Override // com.sigmob.sdk.base.common.j.a
    public void onAdClicked() {
        this.f13047A2egSU.d();
    }

    @Override // com.sigmob.sdk.base.utils.l.a
    public void onTimerFinished() {
        this.f13047A2egSU.c();
    }
}

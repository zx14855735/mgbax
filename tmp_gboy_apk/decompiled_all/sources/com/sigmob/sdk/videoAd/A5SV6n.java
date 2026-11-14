package com.sigmob.sdk.videoAd;

import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class A5SV6n implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13688AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ j f13689AlLFFp;

    public /* synthetic */ A5SV6n(j jVar, int i) {
        this.f13688AcNBzu = i;
        this.f13689AlLFFp = jVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f13688AcNBzu) {
            case 0:
                this.f13689AlLFFp.a(view);
                break;
            default:
                this.f13689AlLFFp.b(view);
                break;
        }
    }
}

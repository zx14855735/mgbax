package com.sigmob.sdk.newInterstitial;

import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class A4TApA implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13631AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ i f13632AlLFFp;

    public /* synthetic */ A4TApA(i iVar, int i) {
        this.f13631AcNBzu = i;
        this.f13632AlLFFp = iVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f13631AcNBzu) {
            case 0:
                this.f13632AlLFFp.a(view);
                break;
            case 1:
                this.f13632AlLFFp.d(view);
                break;
            case 2:
                this.f13632AlLFFp.c(view);
                break;
            default:
                this.f13632AlLFFp.b(view);
                break;
        }
    }
}

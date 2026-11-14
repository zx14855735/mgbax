package com.fl.saas.s2s.sdk.util;

import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A2egSU implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10873AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ S2SVideoView f10874AlLFFp;

    public /* synthetic */ A2egSU(S2SVideoView s2SVideoView, int i) {
        this.f10873AcNBzu = i;
        this.f10874AlLFFp = s2SVideoView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f10873AcNBzu) {
            case 0:
                this.f10874AlLFFp.lambda$setVideo$0(view);
                break;
            default:
                this.f10874AlLFFp.lambda$startVideo$3(view);
                break;
        }
    }
}

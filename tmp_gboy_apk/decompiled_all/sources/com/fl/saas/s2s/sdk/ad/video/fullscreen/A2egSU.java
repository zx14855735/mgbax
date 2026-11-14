package com.fl.saas.s2s.sdk.ad.video.fullscreen;

import com.fl.saas.base.widget.ShakeView;
import com.fl.saas.base.widget.YdCommonDialog;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A2egSU implements YdCommonDialog.OnSubmitListener, ShakeView.ShakeListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ S2SFullVideoActivity f10863AcNBzu;

    public /* synthetic */ A2egSU(S2SFullVideoActivity s2SFullVideoActivity) {
        this.f10863AcNBzu = s2SFullVideoActivity;
    }

    @Override // com.fl.saas.base.widget.YdCommonDialog.OnSubmitListener
    public void onClick() {
        this.f10863AcNBzu.lambda$onClick$1();
    }

    @Override // com.fl.saas.base.widget.ShakeView.ShakeListener
    public void onShake(int i, int i2, int i3) {
        this.f10863AcNBzu.lambda$checkShakeView$0(i, i2, i3);
    }
}

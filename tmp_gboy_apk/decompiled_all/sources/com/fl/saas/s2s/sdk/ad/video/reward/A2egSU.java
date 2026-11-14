package com.fl.saas.s2s.sdk.ad.video.reward;

import com.fl.saas.base.widget.ShakeView;
import com.fl.saas.base.widget.YdCommonDialog;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A2egSU implements ShakeView.ShakeListener, YdCommonDialog.OnSubmitListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ S2SRewardVideoActivity f10864AcNBzu;

    public /* synthetic */ A2egSU(S2SRewardVideoActivity s2SRewardVideoActivity) {
        this.f10864AcNBzu = s2SRewardVideoActivity;
    }

    @Override // com.fl.saas.base.widget.YdCommonDialog.OnSubmitListener
    public void onClick() {
        this.f10864AcNBzu.lambda$onClick$0();
    }

    @Override // com.fl.saas.base.widget.ShakeView.ShakeListener
    public void onShake(int i, int i2, int i3) {
        this.f10864AcNBzu.lambda$checkShakeView$1(i, i2, i3);
    }
}

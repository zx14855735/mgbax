package com.fl.saas.base.inner.spread;

import com.fl.saas.base.widget.RainTextureView;
import com.fl.saas.common.widget.InterceptClickLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A4TApA implements AmA8tU.A2egSU, RainTextureView.OnStatusListener, InterceptClickLayout.OnIntercept {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ SpreadViewHelper f10773AcNBzu;

    public /* synthetic */ A4TApA(SpreadViewHelper spreadViewHelper) {
        this.f10773AcNBzu = spreadViewHelper;
    }

    @Override // AmA8tU.A2egSU
    public Object apply(Object obj) {
        String lambda$new$0;
        lambda$new$0 = this.f10773AcNBzu.lambda$new$0((Integer) obj);
        return lambda$new$0;
    }

    @Override // com.fl.saas.common.widget.InterceptClickLayout.OnIntercept
    public boolean isIntercept(float f, float f2) {
        boolean lambda$setInterceptClick$5;
        lambda$setInterceptClick$5 = this.f10773AcNBzu.lambda$setInterceptClick$5(f, f2);
        return lambda$setInterceptClick$5;
    }

    @Override // com.fl.saas.base.widget.RainTextureView.OnStatusListener
    public void onStop() {
        this.f10773AcNBzu.lambda$setRainView$4();
    }
}

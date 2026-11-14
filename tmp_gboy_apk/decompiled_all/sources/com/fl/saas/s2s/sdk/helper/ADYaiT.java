package com.fl.saas.s2s.sdk.helper;

import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.nativead.e;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class ADYaiT implements AmA8tU.A2egSU, ae.a {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10871AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ int f10872AlLFFp;

    public /* synthetic */ ADYaiT(int i, int i2) {
        this.f10871AcNBzu = i;
        this.f10872AlLFFp = i2;
    }

    @Override // AmA8tU.A2egSU
    public Object apply(Object obj) {
        Integer lambda$analyzeResponse$0;
        lambda$analyzeResponse$0 = S2sRequestHelper.lambda$analyzeResponse$0(this.f10871AcNBzu, this.f10872AlLFFp, (Integer) obj);
        return lambda$analyzeResponse$0;
    }

    @Override // com.sigmob.sdk.base.common.ae.a
    public void onAddExtra(Object obj) {
        e.a(this.f10871AcNBzu, this.f10872AlLFFp, obj);
    }
}

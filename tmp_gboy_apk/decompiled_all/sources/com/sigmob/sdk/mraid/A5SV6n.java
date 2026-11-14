package com.sigmob.sdk.mraid;

import com.sigmob.sdk.mraid.h;
import com.sigmob.sdk.mraid.v;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class A5SV6n implements h.e, h.b, v.a {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13450AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f13451AlLFFp;

    public /* synthetic */ A5SV6n(int i, Object obj) {
        this.f13450AcNBzu = i;
        this.f13451AlLFFp = obj;
    }

    @Override // com.sigmob.sdk.mraid.h.b
    public void onReady(v vVar, com.sigmob.sdk.base.common.u uVar) {
        switch (this.f13450AcNBzu) {
            case 1:
                ((s) this.f13451AlLFFp).b(vVar, uVar);
                break;
            default:
                ((s) this.f13451AlLFFp).a(vVar, uVar);
                break;
        }
    }

    @Override // com.sigmob.sdk.mraid.v.a
    public void onVisibilityChanged(boolean z) {
        ((c) this.f13451AlLFFp).b(z);
    }

    @Override // com.sigmob.sdk.mraid.h.e
    public void useCustomCloseChanged(boolean z) {
        ((s) this.f13451AlLFFp).b(z);
    }
}

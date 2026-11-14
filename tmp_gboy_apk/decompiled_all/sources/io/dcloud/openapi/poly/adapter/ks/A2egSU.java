package io.dcloud.openapi.poly.adapter.ks;

import io.dcloud.openapi.core.module.DCBaseAOL;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13978AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ DCBaseAOL f13979AlLFFp;

    public /* synthetic */ A2egSU(DCBaseAOL dCBaseAOL, int i) {
        this.f13978AcNBzu = i;
        this.f13979AlLFFp = dCBaseAOL;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13978AcNBzu) {
            case 0:
                ((KSDrawAOLEntry) this.f13979AlLFFp).a();
                break;
            default:
                ((KSFeedAOLEntry) this.f13979AlLFFp).a();
                break;
        }
    }
}

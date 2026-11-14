package com.sigmob.windad.natives;

import com.sigmob.windad.WindAdError;
import com.sigmob.windad.natives.WindNativeUnifiedAd;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13787AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f13788AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f13789AmA8tU;

    public /* synthetic */ A2egSU(Object obj, int i, Object obj2) {
        this.f13787AcNBzu = i;
        this.f13788AlLFFp = obj;
        this.f13789AmA8tU = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13787AcNBzu) {
            case 0:
                ((WindNativeUnifiedAd.AnonymousClass1) this.f13788AlLFFp).a((List) this.f13789AmA8tU);
                break;
            default:
                ((WindNativeUnifiedAd) this.f13788AlLFFp).b((WindAdError) this.f13789AmA8tU);
                break;
        }
    }
}

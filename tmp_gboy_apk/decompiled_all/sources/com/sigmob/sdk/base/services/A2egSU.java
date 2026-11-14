package com.sigmob.sdk.base.services;

import android.content.Context;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.o;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13205AcNBzu = 0;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Context f13206AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f13207AmA8tU;

    public /* synthetic */ A2egSU(Context context, BaseAdUnit baseAdUnit) {
        this.f13206AlLFFp = context;
        this.f13207AmA8tU = baseAdUnit;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13205AcNBzu) {
            case 0:
                a.a(this.f13206AlLFFp, (BaseAdUnit) this.f13207AmA8tU);
                break;
            default:
                b.a((o) this.f13207AmA8tU, this.f13206AlLFFp);
                break;
        }
    }

    public /* synthetic */ A2egSU(o oVar, Context context) {
        this.f13207AmA8tU = oVar;
        this.f13206AlLFFp = context;
    }
}

package com.sigmob.sdk.base.views;

import android.animation.Animator;
import com.sigmob.sdk.base.views.ac;
import com.sigmob.sdk.base.views.ad;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class A4TApA implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13231AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f13232AlLFFp;

    public /* synthetic */ A4TApA(int i, Object obj) {
        this.f13231AcNBzu = i;
        this.f13232AlLFFp = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13231AcNBzu) {
            case 0:
                ((ac.AnonymousClass2) this.f13232AlLFFp).a();
                break;
            case 1:
                ((ad.AnonymousClass1) this.f13232AlLFFp).a();
                break;
            case 2:
                ((Animator) this.f13232AlLFFp).start();
                break;
            case 3:
                ((an) this.f13232AlLFFp).a();
                break;
            default:
                ((q) this.f13232AlLFFp).i();
                break;
        }
    }
}

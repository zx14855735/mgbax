package com.sigmob.sdk.base.views;

import com.sigmob.sdk.base.views.g;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class AMqCpz implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13236AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ g.AnonymousClass1 f13237AlLFFp;

    public /* synthetic */ AMqCpz(g.AnonymousClass1 anonymousClass1, int i) {
        this.f13236AcNBzu = i;
        this.f13237AlLFFp = anonymousClass1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13236AcNBzu) {
            case 0:
                this.f13237AlLFFp.d();
                break;
            default:
                this.f13237AlLFFp.c();
                break;
        }
    }
}

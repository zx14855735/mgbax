package com.sigmob.sdk.splash;

import com.sigmob.sdk.splash.h;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class ARc23Z implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13661AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f13662AlLFFp;

    public /* synthetic */ ARc23Z(int i, Object obj) {
        this.f13661AcNBzu = i;
        this.f13662AlLFFp = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13661AcNBzu) {
            case 0:
                ((h.AnonymousClass2) this.f13662AlLFFp).b();
                break;
            case 1:
                ((h.AnonymousClass6) this.f13662AlLFFp).b();
                break;
            case 2:
                ((h.AnonymousClass7) this.f13662AlLFFp).b();
                break;
            default:
                ((f) this.f13662AlLFFp).n();
                break;
        }
    }
}

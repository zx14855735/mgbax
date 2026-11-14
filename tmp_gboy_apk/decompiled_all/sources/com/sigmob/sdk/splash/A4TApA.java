package com.sigmob.sdk.splash;

import android.graphics.Bitmap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class A4TApA implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13655AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f13656AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f13657AmA8tU;

    public /* synthetic */ A4TApA(Object obj, int i, Object obj2) {
        this.f13655AcNBzu = i;
        this.f13656AlLFFp = obj;
        this.f13657AmA8tU = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13655AcNBzu) {
            case 0:
                ((c) this.f13656AlLFFp).b((Bitmap) this.f13657AmA8tU);
                break;
            default:
                ((f) this.f13656AlLFFp).a((String) this.f13657AmA8tU);
                break;
        }
    }
}

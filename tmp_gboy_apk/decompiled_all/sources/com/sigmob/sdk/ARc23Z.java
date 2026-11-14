package com.sigmob.sdk;

import com.sigmob.sdk.c;
import com.sigmob.sdk.videoAd.m;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class ARc23Z implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13003AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ c.AnonymousClass1 f13004AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ m f13005AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ String f13006AzWtSf;

    public /* synthetic */ ARc23Z(c.AnonymousClass1 anonymousClass1, m mVar, String str, int i) {
        this.f13003AcNBzu = i;
        this.f13004AlLFFp = anonymousClass1;
        this.f13005AmA8tU = mVar;
        this.f13006AzWtSf = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13003AcNBzu) {
            case 0:
                this.f13004AlLFFp.d(this.f13005AmA8tU, this.f13006AzWtSf);
                break;
            default:
                this.f13004AlLFFp.a(this.f13005AmA8tU, this.f13006AzWtSf);
                break;
        }
    }
}

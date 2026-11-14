package com.sigmob.sdk;

import com.sigmob.sdk.base.utils.c;
import com.sigmob.sdk.c;
import com.sigmob.sdk.videoAd.m;
import com.sigmob.windad.WindAdError;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class AMqCpz implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f12998AcNBzu = 1;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ c.AnonymousClass1 f12999AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ String f13000AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ m f13001AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final /* synthetic */ Object f13002B25kr6;

    public /* synthetic */ AMqCpz(c.AnonymousClass1 anonymousClass1, c.a aVar, String str, m mVar) {
        this.f12999AlLFFp = anonymousClass1;
        this.f13002B25kr6 = aVar;
        this.f13000AmA8tU = str;
        this.f13001AzWtSf = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f12998AcNBzu) {
            case 0:
                this.f12999AlLFFp.a(this.f13001AzWtSf, (WindAdError) this.f13002B25kr6, this.f13000AmA8tU);
                break;
            default:
                this.f12999AlLFFp.a((c.a) this.f13002B25kr6, this.f13000AmA8tU, this.f13001AzWtSf);
                break;
        }
    }

    public /* synthetic */ AMqCpz(c.AnonymousClass1 anonymousClass1, m mVar, WindAdError windAdError, String str) {
        this.f12999AlLFFp = anonymousClass1;
        this.f13001AzWtSf = mVar;
        this.f13002B25kr6 = windAdError;
        this.f13000AmA8tU = str;
    }
}

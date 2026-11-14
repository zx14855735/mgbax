package com.sigmob.sdk;

import com.sigmob.sdk.c;
import com.sigmob.sdk.videoAd.m;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class ASJ6gh implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13007AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ m f13008AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ String f13009AmA8tU;

    public /* synthetic */ ASJ6gh(m mVar, String str, int i) {
        this.f13007AcNBzu = i;
        this.f13008AlLFFp = mVar;
        this.f13009AmA8tU = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13007AcNBzu) {
            case 0:
                c.AnonymousClass1.c(this.f13008AlLFFp, this.f13009AmA8tU);
                break;
            default:
                c.AnonymousClass1.b(this.f13008AlLFFp, this.f13009AmA8tU);
                break;
        }
    }
}

package com.sigmob.sdk.mraid2;

import com.sigmob.sdk.mraid2.i;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class AYUAbz implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13515AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ i.a f13516AlLFFp;

    public /* synthetic */ AYUAbz(i.a aVar, int i) {
        this.f13515AcNBzu = i;
        this.f13516AlLFFp = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13515AcNBzu) {
            case 0:
                this.f13516AlLFFp.a();
                break;
            default:
                this.f13516AlLFFp.b();
                break;
        }
    }
}

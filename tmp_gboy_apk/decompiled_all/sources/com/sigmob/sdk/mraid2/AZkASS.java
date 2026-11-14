package com.sigmob.sdk.mraid2;

import android.widget.FrameLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class AZkASS implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13523AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ int f13524AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ int f13525AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f13526AzWtSf;

    public /* synthetic */ AZkASS(FrameLayout frameLayout, int i, int i2, int i3) {
        this.f13523AcNBzu = i3;
        this.f13526AzWtSf = frameLayout;
        this.f13524AlLFFp = i;
        this.f13525AmA8tU = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13523AcNBzu) {
            case 0:
                ((l) this.f13526AzWtSf).c(this.f13524AlLFFp, this.f13525AmA8tU);
                break;
            default:
                ((r) this.f13526AzWtSf).c(this.f13524AlLFFp, this.f13525AmA8tU);
                break;
        }
    }
}

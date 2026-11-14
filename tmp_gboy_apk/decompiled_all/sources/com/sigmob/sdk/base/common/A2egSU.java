package com.sigmob.sdk.base.common;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13045AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f13046AlLFFp;

    public /* synthetic */ A2egSU(int i, Object obj) {
        this.f13045AcNBzu = i;
        this.f13046AlLFFp = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13045AcNBzu) {
            case 0:
                ((AdActivity) this.f13046AlLFFp).b();
                break;
            default:
                ((com.sigmob.sdk.downloader.f) this.f13046AlLFFp).E();
                break;
        }
    }
}

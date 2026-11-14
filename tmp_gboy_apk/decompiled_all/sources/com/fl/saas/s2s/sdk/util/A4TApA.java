package com.fl.saas.s2s.sdk.util;

import com.fl.saas.s2s.sdk.util.S2SVideoView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A4TApA implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10875AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f10876AlLFFp;

    public /* synthetic */ A4TApA(int i, Object obj) {
        this.f10875AcNBzu = i;
        this.f10876AlLFFp = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10875AcNBzu) {
            case 0:
                ((S2SVideoView.AnonymousClass7) this.f10876AlLFFp).lambda$surfaceCreated$0();
                break;
            default:
                ((S2SVideoView) this.f10876AlLFFp).lambda$startVideo$4();
                break;
        }
    }
}

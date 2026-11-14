package CtFAbx;

import android.view.Choreographer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class A5SV6n implements Choreographer.FrameCallback {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f1877AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Runnable f1878AlLFFp;

    public /* synthetic */ A5SV6n(int i, Runnable runnable) {
        this.f1877AcNBzu = i;
        this.f1878AlLFFp = runnable;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        switch (this.f1877AcNBzu) {
            case 0:
                ((A2egSU) this.f1878AlLFFp).run();
                break;
            default:
                this.f1878AlLFFp.run();
                break;
        }
    }
}

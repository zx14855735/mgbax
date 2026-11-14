package com.sigmob.sdk.videoplayer;

import com.sigmob.sdk.videoplayer.a;
import com.sigmob.sdk.videoplayer.f;
import java.util.TimerTask;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13749AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ TimerTask f13750AlLFFp;

    public /* synthetic */ A2egSU(TimerTask timerTask, int i) {
        this.f13749AcNBzu = i;
        this.f13750AlLFFp = timerTask;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13749AcNBzu) {
            case 0:
                ((a.C0463a) this.f13750AlLFFp).a();
                break;
            default:
                ((f.a) this.f13750AlLFFp).a();
                break;
        }
    }
}

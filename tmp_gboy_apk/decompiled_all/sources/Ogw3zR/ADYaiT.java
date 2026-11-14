package Ogw3zR;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT implements OnBackAnimationCallback {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ A4TApA f6643A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ AMqCpz f6644A4TApA;

    public ADYaiT(AMqCpz aMqCpz, A4TApA a4TApA) {
        this.f6644A4TApA = aMqCpz;
        this.f6643A2egSU = a4TApA;
    }

    @Override // android.window.OnBackAnimationCallback
    public final void onBackCancelled() {
        if (this.f6644A4TApA.f6642A2egSU != null) {
            this.f6643A2egSU.ADYaiT();
        }
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        this.f6643A2egSU.A5SV6n();
    }

    @Override // android.window.OnBackAnimationCallback
    public final void onBackProgressed(BackEvent backEvent) {
        if (this.f6644A4TApA.f6642A2egSU != null) {
            this.f6643A2egSU.A4TApA(new androidx.activity.A4TApA(backEvent));
        }
    }

    @Override // android.window.OnBackAnimationCallback
    public final void onBackStarted(BackEvent backEvent) {
        if (this.f6644A4TApA.f6642A2egSU != null) {
            this.f6643A2egSU.A2egSU(new androidx.activity.A4TApA(backEvent));
        }
    }
}

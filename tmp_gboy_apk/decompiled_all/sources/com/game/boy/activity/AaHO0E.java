package com.game.boy.activity;

import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AaHO0E implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10901AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ EmulatorActivity f10902AlLFFp;

    public /* synthetic */ AaHO0E(EmulatorActivity emulatorActivity, int i) {
        this.f10901AcNBzu = i;
        this.f10902AlLFFp = emulatorActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EmulatorActivity emulatorActivity = this.f10902AlLFFp;
        switch (this.f10901AcNBzu) {
            case 0:
                WeakReference weakReference = EmulatorActivity.f10988DG07BK;
                emulatorActivity.D6DOie();
                break;
            case 1:
                emulatorActivity.f10999BChYOn.BI9f7h("enable_interpolation", true);
                emulatorActivity.f10999BChYOn.BIYEnU("interp_mode", 0);
                if (!LqstKO.A4TApA.f4892CQhlFr) {
                    emulatorActivity.BNL6CD();
                    break;
                } else {
                    LqstKO.A4TApA.f4896Cd8JRx = 0;
                    LqstKO.A4TApA.f4894CTkVKb = true;
                    break;
                }
            case 2:
                emulatorActivity.f10999BChYOn.BI9f7h("enable_interpolation", true);
                emulatorActivity.f10999BChYOn.BIYEnU("interp_mode", 1);
                if (!LqstKO.A4TApA.f4892CQhlFr) {
                    emulatorActivity.BNL6CD();
                    break;
                } else {
                    LqstKO.A4TApA.f4896Cd8JRx = 1;
                    LqstKO.A4TApA.f4894CTkVKb = true;
                    break;
                }
            case 3:
                emulatorActivity.f10999BChYOn.BI9f7h("enable_interpolation", false);
                if (LqstKO.A4TApA.f4892CQhlFr) {
                    emulatorActivity.BNL6CD();
                    break;
                }
                break;
            case 4:
                emulatorActivity.BmvVmW();
                break;
            case 5:
                emulatorActivity.f11001BIYEnU = true;
                emulatorActivity.CtFAbx();
                break;
            default:
                emulatorActivity.C2rE4F();
                break;
        }
    }
}

package com.game.boy.activity;

import android.view.SurfaceView;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BPw6Q8 implements CrfGsy.A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ EmulatorActivity f10924A2egSU;

    public BPw6Q8(EmulatorActivity emulatorActivity) {
        this.f10924A2egSU = emulatorActivity;
    }

    @Override // CrfGsy.A5SV6n
    public final void A2egSU(View view) {
        EmulatorActivity emulatorActivity = this.f10924A2egSU;
        SurfaceView surfaceView = emulatorActivity.f11013COJEAR.f4825AmA8tU;
        surfaceView.setFocusable(false);
        surfaceView.setFocusableInTouchMode(false);
        emulatorActivity.f10993B25kr6.setDrawerLockMode(0);
    }

    @Override // CrfGsy.A5SV6n
    public final void A4TApA(View view) {
        EmulatorActivity emulatorActivity = this.f10924A2egSU;
        SurfaceView surfaceView = emulatorActivity.f11013COJEAR.f4825AmA8tU;
        surfaceView.setFocusable(true);
        surfaceView.setFocusableInTouchMode(true);
        emulatorActivity.f10993B25kr6.setDrawerLockMode(1);
    }
}

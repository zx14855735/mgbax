package com.game.boy.activity;

import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BI9f7h implements BTvldC {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public EmulatorActivity f10917AcNBzu;

    @Override // com.game.boy.activity.BTvldC
    public void A2egSU(ADYaiT.AmA8tU amA8tU) {
        EmulatorActivity emulatorActivity = this.f10917AcNBzu;
        emulatorActivity.f11015CSDoyG = EmulatorActivity.B25kr6(emulatorActivity);
        EmulatorActivity.B2KMhB(emulatorActivity, "bt_server");
        try {
            KpHwm4.B25kr6 b25kr6 = emulatorActivity.f11015CSDoyG;
            b25kr6.AMqCpz = true;
            b25kr6.f4354ARc23Z = false;
            b25kr6.ASJ6gh(new KpHwm4.A4TApA(b25kr6));
        } catch (IOException unused) {
            emulatorActivity.f11015CSDoyG = null;
            amA8tU.dismiss();
        }
    }
}

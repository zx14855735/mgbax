package com.game.boy.activity;

import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B7CMnp implements BTvldC {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10912AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ String f10913AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ EmulatorActivity f10914AmA8tU;

    public /* synthetic */ B7CMnp(EmulatorActivity emulatorActivity, String str, int i) {
        this.f10912AcNBzu = i;
        this.f10914AmA8tU = emulatorActivity;
        this.f10913AlLFFp = str;
    }

    @Override // com.game.boy.activity.BTvldC
    public final void A2egSU(ADYaiT.AmA8tU amA8tU) {
        switch (this.f10912AcNBzu) {
            case 0:
                new Thread(new B4ZgIw(this)).start();
                break;
            case 1:
                EmulatorActivity emulatorActivity = this.f10914AmA8tU;
                emulatorActivity.f11015CSDoyG = EmulatorActivity.B25kr6(emulatorActivity);
                EmulatorActivity.B2KMhB(emulatorActivity, "bt_client");
                try {
                    KpHwm4.B25kr6 b25kr6 = emulatorActivity.f11015CSDoyG;
                    String str = this.f10913AlLFFp;
                    b25kr6.AMqCpz = false;
                    b25kr6.f4354ARc23Z = false;
                    b25kr6.ASJ6gh(new KpHwm4.A2egSU(b25kr6, str));
                    break;
                } catch (IOException unused) {
                    emulatorActivity.f11015CSDoyG = null;
                    amA8tU.dismiss();
                    return;
                }
            default:
                new Thread(new ASJ6gh(2, this)).start();
                break;
        }
    }
}

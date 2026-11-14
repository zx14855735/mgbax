package com.game.boy.activity;

import ADYaiT.CtFAbx;
import android.os.CountDownTimer;
import android.widget.TextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BChYOn extends CountDownTimer {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ EmulatorActivity f10916A2egSU;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BChYOn(EmulatorActivity emulatorActivity, long j) {
        super(j, 1000L);
        this.f10916A2egSU = emulatorActivity;
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long j) {
        try {
            ADYaiT.AmA8tU amA8tU = this.f10916A2egSU.f11018Cd8JRx;
            if (CtFAbx.B9tovu(amA8tU)) {
                String CTkVKb2 = EmulatorActivity.CTkVKb((int) j);
                ADYaiT.AcNBzu acNBzu = amA8tU.f83B2KMhB;
                acNBzu.AMqCpz = CTkVKb2;
                TextView textView = acNBzu.f70BI9f7h;
                if (textView != null) {
                    textView.setText(CTkVKb2);
                }
            }
        } catch (Throwable unused) {
        }
    }
}

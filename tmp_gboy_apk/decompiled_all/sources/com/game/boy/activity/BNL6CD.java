package com.game.boy.activity;

import android.content.SharedPreferences;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BNL6CD implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ EmulatorActivity f10923A2egSU;

    public BNL6CD(EmulatorActivity emulatorActivity) {
        this.f10923A2egSU = emulatorActivity;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        EmulatorActivity emulatorActivity = this.f10923A2egSU;
        KpHwm4.AaHO0E aaHO0E = emulatorActivity.f11011CASmeH;
        if (aaHO0E != null) {
            aaHO0E.ASJ6gh();
            emulatorActivity.AcNBzu(sharedPreferences, str);
            emulatorActivity.f11011CASmeH.AMqCpz();
        }
    }
}

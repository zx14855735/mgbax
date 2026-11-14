package com.game.boy.activity;

import android.content.Intent;
import android.preference.PreferenceManager;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class KeyProfilesActivity extends MkAsKS.AZkASS {

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public static final /* synthetic */ int f11051B4ZgIw = 0;

    public KeyProfilesActivity() {
        super(new File(KpHwm4.AYUAbz.A2egSU("config/keymap"), "keymaps.xml"));
    }

    @Override // MkAsKS.AZkASS
    public final void AYUAbz(String str) {
        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("keyProfile", str).apply();
        KeyMappingSettings.f11040B4ZgIw = true;
    }

    @Override // MkAsKS.AZkASS
    public final void AZOQYO(String str) {
        KeyMappingSettings.AYUAbz(str).delete();
    }

    @Override // MkAsKS.AZkASS
    public final void AaHO0E(String str) {
        Intent intent = new Intent(this, (Class<?>) KeyMappingSettings.class);
        intent.putExtra("profile-name", str);
        startActivity(intent);
    }

    @Override // MkAsKS.AZkASS
    public final String AmA8tU() {
        return PreferenceManager.getDefaultSharedPreferences(this).getString("keyProfile", "Default");
    }
}

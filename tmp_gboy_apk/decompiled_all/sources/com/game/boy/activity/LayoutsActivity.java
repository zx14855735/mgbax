package com.game.boy.activity;

import android.content.Intent;
import android.preference.PreferenceManager;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class LayoutsActivity extends MkAsKS.AZkASS {

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public static final /* synthetic */ int f11061B4ZgIw = 0;

    public LayoutsActivity() {
        super(new File(KpHwm4.AYUAbz.A2egSU("config/layout"), "layouts.xml"));
    }

    @Override // MkAsKS.AZkASS
    public final void AYUAbz(String str) {
        PreferenceManager.getDefaultSharedPreferences(this).edit().putString("layoutProfile", str).apply();
    }

    @Override // MkAsKS.AZkASS
    public final void AZOQYO(String str) {
        File[] listFiles = KpHwm4.AYUAbz.A2egSU("config/layout").listFiles(new CASmeH(str));
        if (listFiles != null) {
            for (File file : listFiles) {
                file.delete();
            }
        }
    }

    @Override // MkAsKS.AZkASS
    public final void AaHO0E(String str) {
        startActivity(new Intent(this, (Class<?>) LayoutEditor.class).putExtra("profile-name", str));
    }

    @Override // MkAsKS.AZkASS
    public final String AmA8tU() {
        return PreferenceManager.getDefaultSharedPreferences(this).getString("layoutProfile", "Default");
    }
}

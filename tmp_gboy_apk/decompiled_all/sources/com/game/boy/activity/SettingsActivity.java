package com.game.boy.activity;

import ADYaiT.DUi7mC;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.CtxOCS;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.google.android.material.appbar.MaterialToolbar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SettingsActivity extends A5SV6n {

    /* renamed from: B25kr6, reason: collision with root package name */
    public A2egSU f11085B25kr6;

    public static class A2egSU extends androidx.lifecycle.CikNvS {

        /* renamed from: ADYaiT, reason: collision with root package name */
        public String f11086ADYaiT;

        @Override // androidx.lifecycle.CikNvS
        public final void A4TApA() {
            this.f11086ADYaiT = null;
        }
    }

    public static MS6BTZ.AlLFFp AYUAbz(String str) {
        return "main".equals(str) ? new MOpbMP.C4FrIb() : "theme".equals(str) ? new MS6BTZ.AmA8tU() : "display".equals(str) ? new MS6BTZ.AZOQYO() : MediaFormat.KEY_AUDIO.equals(str) ? new MS6BTZ.A5SV6n() : "button".equals(str) ? new MS6BTZ.ADYaiT() : "layout".equals(str) ? new MS6BTZ.AZkASS() : "misc".equals(str) ? new MS6BTZ.AaHO0E() : "advanced".equals(str) ? new MS6BTZ.A4TApA() : "about".equals(str) ? new MS6BTZ.A2egSU() : new MOpbMP.C4FrIb();
    }

    public final void AZOQYO() {
        CtxOCS supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.getClass();
        androidx.fragment.app.A2egSU a2egSU = new androidx.fragment.app.A2egSU(supportFragmentManager);
        int i = getResources().getConfiguration().orientation;
        String str = this.f11085B25kr6.f11086ADYaiT;
        if (i == 2) {
            a2egSU.AlLFFp(2131297521, new MOpbMP.C4FrIb(), null);
            a2egSU.f8921ARc23Z = 4099;
            if ("main".equals(str)) {
                str = "theme";
                this.f11085B25kr6.f11086ADYaiT = "theme";
            }
            a2egSU.AlLFFp(2131296527, AYUAbz(str), null);
        } else {
            a2egSU.AlLFFp(2131296527, AYUAbz(str), null);
        }
        a2egSU.AMqCpz();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        if (getResources().getConfiguration().orientation == 2 || "main".equals(this.f11085B25kr6.f11086ADYaiT)) {
            super.onBackPressed();
            return;
        }
        this.f11085B25kr6.f11086ADYaiT = "main";
        CtxOCS supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.getClass();
        androidx.fragment.app.A2egSU a2egSU = new androidx.fragment.app.A2egSU(supportFragmentManager);
        a2egSU.f8921ARc23Z = 8194;
        Fragment BPw6Q82 = getSupportFragmentManager().BPw6Q8(2131296527);
        if (BPw6Q82 != null) {
            a2egSU.AcNBzu(BPw6Q82);
        }
        Fragment BTvldC2 = getSupportFragmentManager().BTvldC("main");
        if (BTvldC2 != null) {
            a2egSU.AzWtSf(BTvldC2);
        } else {
            a2egSU.AlLFFp(2131296527, new MOpbMP.C4FrIb(), "main");
        }
        a2egSU.AMqCpz();
    }

    @Override // ADYaiT.B2KMhB, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        MaterialToolbar materialToolbar = (MaterialToolbar) findViewById(2131298113);
        materialToolbar.setTitle("设置");
        setSupportActionBar(materialToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().AlLFFp(true);
        }
        AZOQYO();
    }

    @Override // com.game.boy.activity.A5SV6n, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.AmA8tU, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131492904);
        A2egSU a2egSU = (A2egSU) new DUi7mC((FragmentActivity) this).AlLFFp(A2egSU.class);
        this.f11085B25kr6 = a2egSU;
        if (a2egSU.f11086ADYaiT == null) {
            a2egSU.f11086ADYaiT = "main";
        }
        MaterialToolbar materialToolbar = (MaterialToolbar) findViewById(2131298113);
        materialToolbar.setTitle("设置");
        setSupportActionBar(materialToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().AlLFFp(true);
        }
        AZOQYO();
        String[] strArr = L2suez.B3GDIM.f4387A2egSU;
        new Thread(new JtTqUo.A4TApA(getApplicationContext(), new Handler(Looper.getMainLooper())), "ShaderInitThread").start();
    }
}

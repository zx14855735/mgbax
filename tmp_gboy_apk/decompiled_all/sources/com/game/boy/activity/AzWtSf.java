package com.game.boy.activity;

import android.content.Context;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.game.boy.MyApp;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AzWtSf {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ EmulatorActivity f10907A2egSU;

    public AzWtSf(EmulatorActivity emulatorActivity) {
        this.f10907A2egSU = emulatorActivity;
    }

    public final void A2egSU(String str) {
        SwipeRefreshLayout swipeRefreshLayout;
        EmulatorActivity emulatorActivity = this.f10907A2egSU;
        Mi9UWv.ASJ6gh aSJ6gh = emulatorActivity.f11032DAk1zC;
        if (aSJ6gh != null && (swipeRefreshLayout = aSJ6gh.f5405B2KMhB) != null) {
            swipeRefreshLayout.post(new LLYwnm.AMqCpz(12, aSJ6gh));
        }
        if (str != null) {
            MyApp.A2egSU(str);
            if (str.contains("登录已失效")) {
                MOpbMP.ARc23Z.AlLFFp(new I3HV03.A4TApA((Context) emulatorActivity));
            }
        }
    }
}

package com.game.boy.activity;

import io.dcloud.ads.core.entry.SplashConfig;
import io.dcloud.ads.core.v2.splash.DCSplashAd;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class CkXcdM implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10959AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ SplashActivity f10960AlLFFp;

    public /* synthetic */ CkXcdM(SplashActivity splashActivity, int i) {
        this.f10959AcNBzu = i;
        this.f10960AlLFFp = splashActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10959AcNBzu) {
            case 0:
                SplashActivity splashActivity = this.f10960AlLFFp;
                if (!splashActivity.f11090B3GDIM) {
                    try {
                        splashActivity.f11088B25kr6 = new DCSplashAd(splashActivity);
                        SplashConfig build = new SplashConfig.Builder().width(splashActivity.getResources().getDisplayMetrics().widthPixels).height((splashActivity.getResources().getDisplayMetrics().heightPixels / 5) * 4).build();
                        splashActivity.f11088B25kr6.setSplashAdListener(new NGepWW.A2egSU(16, splashActivity));
                        splashActivity.f11088B25kr6.load(build, new A2egSU(splashActivity));
                        break;
                    } catch (Throwable unused) {
                        splashActivity.AZOQYO();
                        return;
                    }
                }
                break;
            default:
                SplashActivity splashActivity2 = this.f10960AlLFFp;
                if (!splashActivity2.f11090B3GDIM) {
                    splashActivity2.AZOQYO();
                    break;
                }
                break;
        }
    }
}

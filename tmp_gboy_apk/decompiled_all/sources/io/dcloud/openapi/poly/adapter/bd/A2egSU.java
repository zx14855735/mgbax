package io.dcloud.openapi.poly.adapter.bd;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.ViewGroup;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13928AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ DCBaseAOLLoader f13929AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ KeyEvent.Callback f13930AmA8tU;

    public /* synthetic */ A2egSU(DCBaseAOLLoader dCBaseAOLLoader, KeyEvent.Callback callback, int i) {
        this.f13928AcNBzu = i;
        this.f13929AlLFFp = dCBaseAOLLoader;
        this.f13930AmA8tU = callback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13928AcNBzu) {
            case 0:
                ((BDInterstitialAOL) this.f13929AlLFFp).a((Activity) this.f13930AmA8tU);
                break;
            default:
                ((BDSplashAOL) this.f13929AlLFFp).a((ViewGroup) this.f13930AmA8tU);
                break;
        }
    }
}

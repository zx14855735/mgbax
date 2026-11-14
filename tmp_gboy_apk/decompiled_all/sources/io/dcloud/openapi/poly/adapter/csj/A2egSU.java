package io.dcloud.openapi.poly.adapter.csj;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.ViewGroup;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13937AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ DCBaseAOLLoader f13938AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ KeyEvent.Callback f13939AmA8tU;

    public /* synthetic */ A2egSU(DCBaseAOLLoader dCBaseAOLLoader, KeyEvent.Callback callback, int i) {
        this.f13937AcNBzu = i;
        this.f13938AlLFFp = dCBaseAOLLoader;
        this.f13939AmA8tU = callback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13937AcNBzu) {
            case 0:
                ((CSJFullScreenVideoAOL) this.f13938AlLFFp).a((Activity) this.f13939AmA8tU);
                break;
            default:
                ((CSJSplashAOL2) this.f13938AlLFFp).a((ViewGroup) this.f13939AmA8tU);
                break;
        }
    }
}

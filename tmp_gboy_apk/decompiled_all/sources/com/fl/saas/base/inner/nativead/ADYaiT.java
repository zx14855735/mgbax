package com.fl.saas.base.inner.nativead;

import com.fl.saas.common.pojo.YdNativePojo;
import com.fl.saas.common.util.feature.Consumer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class ADYaiT implements Consumer {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f10767A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ YdNativePojo f10768A4TApA;

    public /* synthetic */ ADYaiT(YdNativePojo ydNativePojo, int i) {
        this.f10767A2egSU = i;
        this.f10768A4TApA = ydNativePojo;
    }

    @Override // com.fl.saas.common.util.feature.Consumer
    public final void accept(Object obj) {
        switch (this.f10767A2egSU) {
            case 0:
                ((YdNativePojo.VideoEventListener) obj).onVideoStart(this.f10768A4TApA);
                break;
            default:
                ((YdNativePojo.VideoEventListener) obj).onVideoComplete(this.f10768A4TApA);
                break;
        }
    }
}

package com.fl.saas.base.adapter;

import com.fl.saas.base.interfaces.AdViewDrawVideoListener;
import com.fl.saas.base.interfaces.AdViewNativeListener;
import com.fl.saas.base.interfaces.AdViewTemplateListener;
import com.fl.saas.common.util.feature.Consumer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A4TApA implements Consumer {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f10713A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ int f10714A4TApA;

    public /* synthetic */ A4TApA(int i, int i2) {
        this.f10713A2egSU = i2;
        this.f10714A4TApA = i;
    }

    @Override // com.fl.saas.common.util.feature.Consumer
    public final void accept(Object obj) {
        switch (this.f10713A2egSU) {
            case 0:
                ((AdViewDrawVideoListener) obj).onAdClick(this.f10714A4TApA);
                break;
            case 1:
                ((AdViewDrawVideoListener) obj).onAdShow(this.f10714A4TApA);
                break;
            case 2:
                ((AdViewNativeListener) obj).onAdClick(this.f10714A4TApA);
                break;
            case 3:
                ((AdViewNativeListener) obj).onAdShow(this.f10714A4TApA);
                break;
            case 4:
                ((AdViewTemplateListener) obj).onAdClick(this.f10714A4TApA, "");
                break;
            default:
                ((AdViewTemplateListener) obj).onAdShow(this.f10714A4TApA);
                break;
        }
    }
}

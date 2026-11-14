package com.fl.saas.base.manager;

import com.fl.saas.base.adapter.AdViewNativeAdapter;
import com.fl.saas.base.adapter.AdViewTemplateAdapter;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.interfaces.AdViewSpreadListener;
import com.fl.saas.common.util.feature.Consumer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A2egSU implements Consumer {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f10791A2egSU;

    public /* synthetic */ A2egSU(int i) {
        this.f10791A2egSU = i;
    }

    @Override // com.fl.saas.common.util.feature.Consumer
    public final void accept(Object obj) {
        switch (this.f10791A2egSU) {
            case 0:
                ((AdViewNativeAdapter) obj).resume();
                break;
            case 1:
                ((AdViewNativeAdapter) obj).stopVideo();
                break;
            case 2:
                ((AdViewSpreadListener) obj).onAdDisplay();
                break;
            case 3:
                ((AdViewTemplateAdapter) obj).reportRequestShow();
                break;
            default:
                ((AdapterAPI) obj).showAd();
                break;
        }
    }
}

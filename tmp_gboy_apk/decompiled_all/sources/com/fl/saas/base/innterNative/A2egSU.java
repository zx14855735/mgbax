package com.fl.saas.base.innterNative;

import android.content.Context;
import com.fl.saas.api.mixNative.NativeEventListener;
import com.fl.saas.api.mixNative.NativePrepareInfo;
import com.fl.saas.base.manager.loader.BaseLoader;
import com.fl.saas.base.manager.loader.BuilderAdLoader;
import com.fl.saas.common.saas.bean.AdPlace;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.exception.YdError;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A2egSU implements Consumer {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f10779A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Object f10780A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ Object f10781A5SV6n;

    public /* synthetic */ A2egSU(Object obj, int i, Object obj2) {
        this.f10779A2egSU = i;
        this.f10780A4TApA = obj;
        this.f10781A5SV6n = obj2;
    }

    @Override // com.fl.saas.common.util.feature.Consumer
    public final void accept(Object obj) {
        switch (this.f10779A2egSU) {
            case 0:
                ((BaseNativeAd) this.f10780A4TApA).lambda$prepare$0((NativePrepareInfo) this.f10781A5SV6n, obj);
                break;
            case 1:
                ((BaseNativeAd) this.f10780A4TApA).lambda$onAdFailedEvent$2((YdError) this.f10781A5SV6n, (NativeEventListener) obj);
                break;
            case 2:
                ((BaseLoader) this.f10780A4TApA).lambda$reqSdkBidAd$1((AdPlace) this.f10781A5SV6n, (Context) obj);
                break;
            default:
                ((BuilderAdLoader) this.f10780A4TApA).lambda$requestAd$0((AdSource) this.f10781A5SV6n, (Context) obj);
                break;
        }
    }
}

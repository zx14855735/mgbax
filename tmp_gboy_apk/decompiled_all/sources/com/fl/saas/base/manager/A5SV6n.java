package com.fl.saas.base.manager;

import com.fl.saas.base.interfaces.VideoVerifyRequstListener;
import com.fl.saas.base.manager.AdViewVideoManager;
import com.fl.saas.base.manager.MixNativeManager;
import com.fl.saas.base.manager.loader.BaseLoader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A5SV6n implements VideoVerifyRequstListener, MixNativeManager.OnNativeReleaseListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ Object f10794A2egSU;

    public /* synthetic */ A5SV6n(Object obj) {
        this.f10794A2egSU = obj;
    }

    @Override // com.fl.saas.base.interfaces.VideoVerifyRequstListener
    public void onResult() {
        ((AdViewVideoManager.AnonymousClass1) this.f10794A2egSU).lambda$onAdShow$0();
    }

    @Override // com.fl.saas.base.manager.MixNativeManager.OnNativeReleaseListener
    public void release() {
        ((BaseLoader) this.f10794A2egSU).destroy();
    }
}

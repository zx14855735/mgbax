package com.fl.saas.common.util;

import com.fl.saas.common.util.ImageLoader;
import com.fl.saas.common.util.feature.Consumer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class ADYaiT implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10816AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Consumer f10817AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Exception f10818AmA8tU;

    public /* synthetic */ ADYaiT(Consumer consumer, Exception exc, int i) {
        this.f10816AcNBzu = i;
        this.f10817AlLFFp = consumer;
        this.f10818AmA8tU = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10816AcNBzu) {
            case 0:
                ImageLoader.AnonymousClass1.lambda$onSuccess$2(this.f10817AlLFFp, this.f10818AmA8tU);
                break;
            default:
                ImageLoader.AnonymousClass1.lambda$onError$3(this.f10817AlLFFp, this.f10818AmA8tU);
                break;
        }
    }
}

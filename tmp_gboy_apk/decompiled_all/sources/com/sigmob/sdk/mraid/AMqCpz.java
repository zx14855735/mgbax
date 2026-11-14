package com.sigmob.sdk.mraid;

import android.webkit.ValueCallback;
import com.sigmob.sdk.mraid.s;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class AMqCpz implements ValueCallback {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f13455A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Object f13456A4TApA;

    public /* synthetic */ AMqCpz(int i, Object obj) {
        this.f13455A2egSU = i;
        this.f13456A4TApA = obj;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object obj) {
        switch (this.f13455A2egSU) {
            case 0:
                ((s.AnonymousClass3) this.f13456A4TApA).b((String) obj);
                break;
            default:
                ((h) this.f13456A4TApA).c((String) obj);
                break;
        }
    }
}

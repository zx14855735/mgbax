package com.sigmob.sdk;

import com.sigmob.sdk.c;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class AYUAbz implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13010AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ c.a f13011AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ String f13012AmA8tU;

    public /* synthetic */ AYUAbz(c.a aVar, String str, int i) {
        this.f13010AcNBzu = i;
        this.f13011AlLFFp = aVar;
        this.f13012AmA8tU = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13010AcNBzu) {
            case 0:
                this.f13011AlLFFp.b(this.f13012AmA8tU);
                break;
            default:
                this.f13011AlLFFp.a(this.f13012AmA8tU);
                break;
        }
    }
}

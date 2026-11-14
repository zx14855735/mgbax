package com.sigmob.sdk;

import com.sigmob.sdk.c;
import com.sigmob.windad.WindAdError;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class AZOQYO implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13013AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ c.a f13014AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ WindAdError f13015AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ String f13016AzWtSf;

    public /* synthetic */ AZOQYO(c.a aVar, WindAdError windAdError, String str, int i) {
        this.f13013AcNBzu = i;
        this.f13014AlLFFp = aVar;
        this.f13015AmA8tU = windAdError;
        this.f13016AzWtSf = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13013AcNBzu) {
            case 0:
                this.f13014AlLFFp.b(this.f13015AmA8tU, this.f13016AzWtSf);
                break;
            default:
                this.f13014AlLFFp.a(this.f13015AmA8tU, this.f13016AzWtSf);
                break;
        }
    }
}

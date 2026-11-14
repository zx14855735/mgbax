package com.sigmob.sdk.base.common;

import com.sigmob.sdk.base.common.ao;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class ASJ6gh implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13063AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ ao.AnonymousClass3 f13064AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ String f13065AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ an f13066AzWtSf;

    public /* synthetic */ ASJ6gh(ao.AnonymousClass3 anonymousClass3, String str, an anVar, int i) {
        this.f13063AcNBzu = i;
        this.f13064AlLFFp = anonymousClass3;
        this.f13065AmA8tU = str;
        this.f13066AzWtSf = anVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13063AcNBzu) {
            case 0:
                this.f13064AlLFFp.b(this.f13065AmA8tU, this.f13066AzWtSf);
                break;
            case 1:
                this.f13064AlLFFp.a(this.f13065AmA8tU, this.f13066AzWtSf);
                break;
            case 2:
                this.f13064AlLFFp.d(this.f13065AmA8tU, this.f13066AzWtSf);
                break;
            default:
                this.f13064AlLFFp.c(this.f13065AmA8tU, this.f13066AzWtSf);
                break;
        }
    }
}

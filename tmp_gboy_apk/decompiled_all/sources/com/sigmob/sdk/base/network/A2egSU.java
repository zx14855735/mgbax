package com.sigmob.sdk.base.network;

import com.sigmob.sdk.base.common.ae;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class A2egSU implements ae.a {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13191AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ String f13192AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f13193AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ int f13194AzWtSf;

    public /* synthetic */ A2egSU(int i, int i2, String str, String str2) {
        this.f13191AcNBzu = i2;
        this.f13192AlLFFp = str;
        this.f13193AmA8tU = str2;
        this.f13194AzWtSf = i;
    }

    @Override // com.sigmob.sdk.base.common.ae.a
    public final void onAddExtra(Object obj) {
        switch (this.f13191AcNBzu) {
            case 0:
                a.a(this.f13192AlLFFp, (String) this.f13193AmA8tU, this.f13194AzWtSf, obj);
                break;
            case 1:
                com.sigmob.sdk.manager.b.a(this.f13192AlLFFp, (String) this.f13193AmA8tU, this.f13194AzWtSf, obj);
                break;
            default:
                ((com.sigmob.sdk.manager.b) this.f13193AmA8tU).a(this.f13192AlLFFp, this.f13194AzWtSf, obj);
                break;
        }
    }

    public /* synthetic */ A2egSU(com.sigmob.sdk.manager.b bVar, String str, int i) {
        this.f13191AcNBzu = 2;
        this.f13193AmA8tU = bVar;
        this.f13192AlLFFp = str;
        this.f13194AzWtSf = i;
    }
}

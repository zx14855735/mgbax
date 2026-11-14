package com.sigmob.sdk.base.common;

import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.i;
import com.sigmob.sdk.base.models.rtb.AndroidMarket;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class AcNBzu implements ae.a {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13073AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ String f13074AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ AndroidMarket f13075AmA8tU;

    public /* synthetic */ AcNBzu(String str, AndroidMarket androidMarket, int i) {
        this.f13073AcNBzu = i;
        this.f13074AlLFFp = str;
        this.f13075AmA8tU = androidMarket;
    }

    @Override // com.sigmob.sdk.base.common.ae.a
    public final void onAddExtra(Object obj) {
        switch (this.f13073AcNBzu) {
            case 0:
                i.AnonymousClass4.b(this.f13074AlLFFp, this.f13075AmA8tU, obj);
                break;
            default:
                i.AnonymousClass4.a(this.f13074AlLFFp, this.f13075AmA8tU, obj);
                break;
        }
    }
}

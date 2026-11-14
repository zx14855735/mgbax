package com.sigmob.sdk.splash;

import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.splash.h;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class ASJ6gh implements ae.a {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13663AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ h.AnonymousClass5 f13664AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ String f13665AmA8tU;

    public /* synthetic */ ASJ6gh(h.AnonymousClass5 anonymousClass5, String str, int i) {
        this.f13663AcNBzu = i;
        this.f13664AlLFFp = anonymousClass5;
        this.f13665AmA8tU = str;
    }

    @Override // com.sigmob.sdk.base.common.ae.a
    public final void onAddExtra(Object obj) {
        switch (this.f13663AcNBzu) {
            case 0:
                this.f13664AlLFFp.a(this.f13665AmA8tU, obj);
                break;
            default:
                this.f13664AlLFFp.b(this.f13665AmA8tU, obj);
                break;
        }
    }
}

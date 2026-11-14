package com.sigmob.sdk.base.common;

import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.i;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class AZkASS implements ae.a {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13069AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ i.AnonymousClass2 f13070AlLFFp;

    public /* synthetic */ AZkASS(i.AnonymousClass2 anonymousClass2, int i) {
        this.f13069AcNBzu = i;
        this.f13070AlLFFp = anonymousClass2;
    }

    @Override // com.sigmob.sdk.base.common.ae.a
    public final void onAddExtra(Object obj) {
        switch (this.f13069AcNBzu) {
            case 0:
                this.f13070AlLFFp.b(obj);
                break;
            case 1:
                this.f13070AlLFFp.a(obj);
                break;
            case 2:
                this.f13070AlLFFp.f(obj);
                break;
            case 3:
                this.f13070AlLFFp.e(obj);
                break;
            case 4:
                this.f13070AlLFFp.d(obj);
                break;
            default:
                this.f13070AlLFFp.c(obj);
                break;
        }
    }
}

package com.sigmob.sdk.videoAd;

import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.videoAd.j;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class ASJ6gh implements ae.a {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13694AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ String f13695AlLFFp;

    public /* synthetic */ ASJ6gh(String str, int i) {
        this.f13694AcNBzu = i;
        this.f13695AlLFFp = str;
    }

    @Override // com.sigmob.sdk.base.common.ae.a
    public final void onAddExtra(Object obj) {
        switch (this.f13694AcNBzu) {
            case 0:
                j.AnonymousClass6.a(this.f13695AlLFFp, obj);
                break;
            default:
                g.a(this.f13695AlLFFp, obj);
                break;
        }
    }
}

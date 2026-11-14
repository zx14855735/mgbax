package com.sigmob.sdk.base.common;

import android.content.pm.PackageInfo;
import com.czhj.volley.VolleyError;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.o;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class ADYaiT implements ae.a {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13055AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f13056AlLFFp;

    public /* synthetic */ ADYaiT(int i, Object obj) {
        this.f13055AcNBzu = i;
        this.f13056AlLFFp = obj;
    }

    @Override // com.sigmob.sdk.base.common.ae.a
    public final void onAddExtra(Object obj) {
        switch (this.f13055AcNBzu) {
            case 0:
                ae.AnonymousClass1.a((PackageInfo) this.f13056AlLFFp, obj);
                break;
            case 1:
                o.AnonymousClass3.a((com.sigmob.sdk.videoAd.d) this.f13056AlLFFp, obj);
                break;
            case 2:
                o.AnonymousClass3.a((Exception) this.f13056AlLFFp, obj);
                break;
            case 3:
                ae.a((VolleyError) this.f13056AlLFFp, obj);
                break;
            default:
                ae.a((ae.a) this.f13056AlLFFp, obj);
                break;
        }
    }
}

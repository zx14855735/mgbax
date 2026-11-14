package com.sigmob.sdk.base.common;

import android.content.Context;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.o;
import java.io.Serializable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class AmA8tU implements ae.a {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13079AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f13080AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Serializable f13081AmA8tU;

    public /* synthetic */ AmA8tU(String str, com.sigmob.sdk.videoAd.d dVar) {
        this.f13079AcNBzu = 1;
        this.f13080AlLFFp = str;
        this.f13081AmA8tU = dVar;
    }

    @Override // com.sigmob.sdk.base.common.ae.a
    public final void onAddExtra(Object obj) {
        switch (this.f13079AcNBzu) {
            case 0:
                o.AnonymousClass2.a((Exception) this.f13081AmA8tU, (String) this.f13080AlLFFp, obj);
                break;
            case 1:
                o.AnonymousClass2.a((String) this.f13080AlLFFp, (com.sigmob.sdk.videoAd.d) this.f13081AmA8tU, obj);
                break;
            default:
                o.a((Throwable) this.f13081AmA8tU, (Context) this.f13080AlLFFp, obj);
                break;
        }
    }

    public /* synthetic */ AmA8tU(Throwable th, Object obj, int i) {
        this.f13079AcNBzu = i;
        this.f13081AmA8tU = th;
        this.f13080AlLFFp = obj;
    }
}

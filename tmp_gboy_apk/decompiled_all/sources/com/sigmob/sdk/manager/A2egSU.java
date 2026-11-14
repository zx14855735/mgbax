package com.sigmob.sdk.manager;

import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.manager.d;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class A2egSU implements ae.a {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13433AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f13434AlLFFp;

    public /* synthetic */ A2egSU(int i, Object obj) {
        this.f13433AcNBzu = i;
        this.f13434AlLFFp = obj;
    }

    @Override // com.sigmob.sdk.base.common.ae.a
    public final void onAddExtra(Object obj) {
        switch (this.f13433AcNBzu) {
            case 0:
                d.a((d.a) this.f13434AlLFFp, obj);
                break;
            default:
                b.a((Map) this.f13434AlLFFp, obj);
                break;
        }
    }
}

package com.sigmob.sdk.base.common;

import com.sigmob.sdk.base.common.ae;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class ARc23Z implements ae.a {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13061AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ HashMap f13062AlLFFp;

    public /* synthetic */ ARc23Z(HashMap hashMap, int i) {
        this.f13061AcNBzu = i;
        this.f13062AlLFFp = hashMap;
    }

    @Override // com.sigmob.sdk.base.common.ae.a
    public final void onAddExtra(Object obj) {
        switch (this.f13061AcNBzu) {
            case 0:
                af.a(this.f13062AlLFFp, obj);
                break;
            default:
                l.a(this.f13062AlLFFp, obj);
                break;
        }
    }
}

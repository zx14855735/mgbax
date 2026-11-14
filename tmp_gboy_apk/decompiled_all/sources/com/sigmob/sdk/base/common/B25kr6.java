package com.sigmob.sdk.base.common;

import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.o;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class B25kr6 implements ae.a {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13086AcNBzu;

    public /* synthetic */ B25kr6(int i) {
        this.f13086AcNBzu = i;
    }

    @Override // com.sigmob.sdk.base.common.ae.a
    public final void onAddExtra(Object obj) {
        switch (this.f13086AcNBzu) {
            case 0:
                o.AnonymousClass3.c(obj);
                break;
            case 1:
                o.AnonymousClass3.b(obj);
                break;
            case 2:
                o.AnonymousClass3.a(obj);
                break;
            case 3:
                AdActivity.a(obj);
                break;
            default:
                o.a(obj);
                break;
        }
    }
}

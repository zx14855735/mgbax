package com.sigmob.sdk.nativead;

import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.mraid.h;
import com.sigmob.sdk.nativead.q;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class AMqCpz implements q.e, ae.a, h.e {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ Object f13577AcNBzu;

    public /* synthetic */ AMqCpz(Object obj) {
        this.f13577AcNBzu = obj;
    }

    @Override // com.sigmob.sdk.base.common.ae.a
    public void onAddExtra(Object obj) {
        y.a((List) this.f13577AcNBzu, obj);
    }

    @Override // com.sigmob.sdk.nativead.q.e
    public void onItemClick(int i, String str) {
        ((b) this.f13577AcNBzu).a(i, str);
    }

    @Override // com.sigmob.sdk.mraid.h.e
    public void useCustomCloseChanged(boolean z) {
        ((z) this.f13577AcNBzu).a(z);
    }
}

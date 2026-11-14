package com.sigmob.sdk.base.views;

import android.view.KeyEvent;
import com.sigmob.sdk.base.views.ae;
import com.sigmob.sdk.mraid.h;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class ADYaiT implements ae.a, h.b {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ KeyEvent.Callback f13235AcNBzu;

    public /* synthetic */ ADYaiT(KeyEvent.Callback callback) {
        this.f13235AcNBzu = callback;
    }

    @Override // com.sigmob.sdk.base.views.ae.a
    public void onApkDownloadProcess() {
        ((g) this.f13235AcNBzu).a();
    }

    @Override // com.sigmob.sdk.mraid.h.b
    public void onReady(com.sigmob.sdk.mraid.v vVar, com.sigmob.sdk.base.common.u uVar) {
        ((z) this.f13235AcNBzu).a(vVar, uVar);
    }
}

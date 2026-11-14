package com.sigmob.sdk.videoAd;

import android.view.MotionEvent;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.views.o;
import com.sigmob.sdk.base.views.z;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class A2egSU implements o.a, z.a, ae.a {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ j f13685AcNBzu;

    public /* synthetic */ A2egSU(j jVar) {
        this.f13685AcNBzu = jVar;
    }

    @Override // com.sigmob.sdk.base.common.ae.a
    public void onAddExtra(Object obj) {
        this.f13685AcNBzu.a(obj);
    }

    @Override // com.sigmob.sdk.base.views.z.a
    public void onCloseClick() {
        this.f13685AcNBzu.Z();
    }

    @Override // com.sigmob.sdk.base.views.o.a
    public void onWebViewClick(MotionEvent motionEvent, MotionEvent motionEvent2) {
        this.f13685AcNBzu.b(motionEvent, motionEvent2);
    }
}

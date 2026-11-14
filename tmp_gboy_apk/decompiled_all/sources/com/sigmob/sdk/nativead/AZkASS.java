package com.sigmob.sdk.nativead;

import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class AZkASS implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13589AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ z f13590AlLFFp;

    public /* synthetic */ AZkASS(z zVar, int i) {
        this.f13589AcNBzu = i;
        this.f13590AlLFFp = zVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f13589AcNBzu) {
            case 0:
                this.f13590AlLFFp.b(view);
                break;
            default:
                this.f13590AlLFFp.a(view);
                break;
        }
    }
}

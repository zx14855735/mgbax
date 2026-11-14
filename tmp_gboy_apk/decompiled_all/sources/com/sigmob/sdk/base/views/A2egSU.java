package com.sigmob.sdk.base.views;

import android.app.Dialog;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class A2egSU implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13229AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Dialog f13230AlLFFp;

    public /* synthetic */ A2egSU(Dialog dialog, int i) {
        this.f13229AcNBzu = i;
        this.f13230AlLFFp = dialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f13229AcNBzu) {
            case 0:
                ((a) this.f13230AlLFFp).a(view);
                break;
            default:
                ((q) this.f13230AlLFFp).a(view);
                break;
        }
    }
}

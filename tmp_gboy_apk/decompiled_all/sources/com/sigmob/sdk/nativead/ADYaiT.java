package com.sigmob.sdk.nativead;

import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class ADYaiT implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13575AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f13576AlLFFp;

    public /* synthetic */ ADYaiT(int i, Object obj) {
        this.f13575AcNBzu = i;
        this.f13576AlLFFp = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f13575AcNBzu) {
            case 0:
                ((b) this.f13576AlLFFp).a(view);
                break;
            default:
                ((w) this.f13576AlLFFp).a(view);
                break;
        }
    }
}

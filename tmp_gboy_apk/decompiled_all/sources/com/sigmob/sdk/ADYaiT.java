package com.sigmob.sdk;

import android.app.Activity;
import com.sigmob.sdk.b;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class ADYaiT implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f12996AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f12997AlLFFp;

    public /* synthetic */ ADYaiT(int i, Object obj) {
        this.f12996AcNBzu = i;
        this.f12997AlLFFp = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f12996AcNBzu) {
            case 0:
                b.b((Activity) this.f12997AlLFFp);
                break;
            default:
                ((b.C0447b) this.f12997AlLFFp).e();
                break;
        }
    }
}

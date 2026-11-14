package com.sigmob.sdk.nativead;

import android.content.Context;
import android.view.ViewGroup;
import com.czhj.volley.VolleyError;
import com.sigmob.sdk.nativead.b;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class ASJ6gh implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13581AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f13582AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f13583AmA8tU;

    public /* synthetic */ ASJ6gh(Object obj, int i, Object obj2) {
        this.f13581AcNBzu = i;
        this.f13582AlLFFp = obj;
        this.f13583AmA8tU = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13581AcNBzu) {
            case 0:
                b.AnonymousClass1.a((VolleyError) this.f13582AlLFFp, (Context) this.f13583AmA8tU);
                break;
            default:
                ((ab) this.f13582AlLFFp).d((ViewGroup) this.f13583AmA8tU);
                break;
        }
    }
}

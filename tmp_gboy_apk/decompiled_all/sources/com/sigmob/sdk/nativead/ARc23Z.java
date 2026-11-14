package com.sigmob.sdk.nativead;

import android.content.Context;
import com.sigmob.sdk.nativead.b;
import com.sigmob.sdk.nativead.x;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class ARc23Z implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13579AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f13580AlLFFp;

    public /* synthetic */ ARc23Z(int i, Object obj) {
        this.f13579AcNBzu = i;
        this.f13580AlLFFp = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13579AcNBzu) {
            case 0:
                b.AnonymousClass1.a((Context) this.f13580AlLFFp);
                break;
            case 1:
                ((x.AnonymousClass1) this.f13580AlLFFp).b();
                break;
            case 2:
                ((x.AnonymousClass2) this.f13580AlLFFp).b();
                break;
            case 3:
                ((x.AnonymousClass3) this.f13580AlLFFp).b();
                break;
            case 4:
                ((x.AnonymousClass4) this.f13580AlLFFp).b();
                break;
            case 5:
                ((LongClickLayout) this.f13580AlLFFp).a();
                break;
            case 6:
                ((f) this.f13580AlLFFp).a();
                break;
            default:
                ((z) this.f13580AlLFFp).v();
                break;
        }
    }
}

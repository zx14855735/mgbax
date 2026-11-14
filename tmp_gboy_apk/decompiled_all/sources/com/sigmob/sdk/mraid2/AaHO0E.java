package com.sigmob.sdk.mraid2;

import com.sigmob.sdk.mraid2.q;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class AaHO0E implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13527AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f13528AlLFFp;

    public /* synthetic */ AaHO0E(int i, Object obj) {
        this.f13527AcNBzu = i;
        this.f13528AlLFFp = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13527AcNBzu) {
            case 0:
                ((q.AnonymousClass1) this.f13528AlLFFp).a();
                break;
            case 1:
                ((d) this.f13528AlLFFp).k();
                break;
            case 2:
                ((e) this.f13528AlLFFp).g();
                break;
            default:
                ((s) this.f13528AlLFFp).p();
                break;
        }
    }
}

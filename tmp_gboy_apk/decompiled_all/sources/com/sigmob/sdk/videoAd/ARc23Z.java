package com.sigmob.sdk.videoAd;

import com.sigmob.sdk.base.common.am;
import com.sigmob.sdk.videoAd.j;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class ARc23Z implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13692AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ am.b f13693AlLFFp;

    public /* synthetic */ ARc23Z(am.b bVar, int i) {
        this.f13692AcNBzu = i;
        this.f13693AlLFFp = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13692AcNBzu) {
            case 0:
                ((j.AnonymousClass10) this.f13693AlLFFp).b();
                break;
            case 1:
                ((j.AnonymousClass11) this.f13693AlLFFp).b();
                break;
            case 2:
                ((j.AnonymousClass12) this.f13693AlLFFp).b();
                break;
            default:
                ((j.AnonymousClass13) this.f13693AlLFFp).b();
                break;
        }
    }
}

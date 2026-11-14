package com.sigmob.sdk.mraid2;

import android.widget.FrameLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class AZOQYO implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f13517AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ boolean f13518AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ int f13519AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ int f13520AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final /* synthetic */ i f13521B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f13522B2KMhB;

    public /* synthetic */ AZOQYO(FrameLayout frameLayout, boolean z, int i, int i2, i iVar, int i3) {
        this.f13517AcNBzu = i3;
        this.f13522B2KMhB = frameLayout;
        this.f13518AlLFFp = z;
        this.f13519AmA8tU = i;
        this.f13520AzWtSf = i2;
        this.f13521B25kr6 = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13517AcNBzu) {
            case 0:
                ((l) this.f13522B2KMhB).a(this.f13518AlLFFp, this.f13519AmA8tU, this.f13520AzWtSf, this.f13521B25kr6);
                break;
            default:
                ((r) this.f13522B2KMhB).a(this.f13518AlLFFp, this.f13519AmA8tU, this.f13520AzWtSf, this.f13521B25kr6);
                break;
        }
    }
}

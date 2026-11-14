package androidx.fragment.app;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BNL6CD extends BTvldC {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ AmA8tU.A2egSU f8772A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f8773A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ A4TApA.A4TApA f8774A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ androidx.activity.result.A4TApA f8775ADYaiT;
    public final /* synthetic */ Fragment AMqCpz;

    public BNL6CD(Fragment fragment, AmA8tU.A2egSU a2egSU, AtomicReference atomicReference, A4TApA.A4TApA a4TApA, androidx.activity.result.A4TApA a4TApA2) {
        this.AMqCpz = fragment;
        this.f8772A2egSU = a2egSU;
        this.f8773A4TApA = atomicReference;
        this.f8774A5SV6n = a4TApA;
        this.f8775ADYaiT = a4TApA2;
    }

    @Override // androidx.fragment.app.BTvldC
    public final void A2egSU() {
        Fragment fragment = this.AMqCpz;
        this.f8773A4TApA.set(((androidx.activity.result.ASJ6gh) this.f8772A2egSU.apply(null)).ADYaiT(fragment.generateActivityResultKey(), fragment, this.f8774A5SV6n, this.f8775ADYaiT));
    }
}

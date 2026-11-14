package androidx.activity;

import MOpbMP.BmvVmW;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B4ZgIw implements A5SV6n {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final BmvVmW f7966AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ OnBackPressedDispatcher f7967AlLFFp;

    public B4ZgIw(OnBackPressedDispatcher onBackPressedDispatcher, BmvVmW bmvVmW) {
        RXb0Sz.ARc23Z.AMqCpz(bmvVmW, "onBackPressedCallback");
        this.f7967AlLFFp = onBackPressedDispatcher;
        this.f7966AcNBzu = bmvVmW;
    }

    @Override // androidx.activity.A5SV6n
    public final void cancel() {
        OnBackPressedDispatcher onBackPressedDispatcher = this.f7967AlLFFp;
        RD2OKB.ARc23Z aRc23Z = onBackPressedDispatcher.f7981A4TApA;
        BmvVmW bmvVmW = this.f7966AcNBzu;
        aRc23Z.remove(bmvVmW);
        if (RXb0Sz.ARc23Z.A2egSU(onBackPressedDispatcher.f7982A5SV6n, bmvVmW)) {
            bmvVmW.getClass();
            onBackPressedDispatcher.f7982A5SV6n = null;
        }
        bmvVmW.f5057A4TApA.remove(this);
        B7CMnp b7CMnp = bmvVmW.f5058A5SV6n;
        if (b7CMnp != null) {
            b7CMnp.invoke();
        }
        bmvVmW.f5058A5SV6n = null;
    }
}

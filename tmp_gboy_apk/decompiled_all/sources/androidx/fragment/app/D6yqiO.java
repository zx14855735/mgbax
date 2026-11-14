package androidx.fragment.app;

import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class D6yqiO implements D6DOie {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final String f8868A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f8869A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final int f8870A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ CtxOCS f8871ADYaiT;

    public D6yqiO(CtxOCS ctxOCS, String str, int i, int i2) {
        this.f8871ADYaiT = ctxOCS;
        this.f8868A2egSU = str;
        this.f8869A4TApA = i;
        this.f8870A5SV6n = i2;
    }

    @Override // androidx.fragment.app.D6DOie
    public final boolean A2egSU(ArrayList arrayList, ArrayList arrayList2) {
        Fragment fragment = this.f8871ADYaiT.f8850BI9f7h;
        if (fragment != null && this.f8869A4TApA < 0 && this.f8868A2egSU == null && fragment.getChildFragmentManager().Cd8JRx()) {
            return false;
        }
        return this.f8871ADYaiT.CkXcdM(arrayList, arrayList2, this.f8868A2egSU, this.f8869A4TApA, this.f8870A5SV6n);
    }
}

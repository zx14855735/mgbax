package DaOi9o;

import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AaHO0E extends BChYOn {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ Object f2224A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2225A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ Object f2226A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2227ADYaiT;
    public final /* synthetic */ AmA8tU AMqCpz;

    public AaHO0E(AmA8tU amA8tU, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2) {
        this.AMqCpz = amA8tU;
        this.f2224A2egSU = obj;
        this.f2225A4TApA = arrayList;
        this.f2226A5SV6n = obj2;
        this.f2227ADYaiT = arrayList2;
    }

    @Override // DaOi9o.BChYOn, DaOi9o.B7CMnp
    public final void ADYaiT(B4ZgIw b4ZgIw) {
        AmA8tU amA8tU = this.AMqCpz;
        Object obj = this.f2224A2egSU;
        if (obj != null) {
            amA8tU.B4ZgIw(obj, this.f2225A4TApA, null);
        }
        Object obj2 = this.f2226A5SV6n;
        if (obj2 != null) {
            amA8tU.B4ZgIw(obj2, this.f2227ADYaiT, null);
        }
    }

    @Override // DaOi9o.BChYOn, DaOi9o.B7CMnp
    public final void ARc23Z(B4ZgIw b4ZgIw) {
        b4ZgIw.BJ7GGh(this);
    }
}

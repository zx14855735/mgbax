package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CQhlFr {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final FG7pZc f9320A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final OLy1FW.AzWtSf f9321A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final RecyclerView.A2egSU f9322A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final COJEAR f9323ADYaiT;
    public int AMqCpz;

    public CQhlFr(RecyclerView.A2egSU a2egSU, COJEAR cojear, F508T2 f508t2, OLy1FW.AzWtSf azWtSf) {
        CNPG0E cnpg0e = new CNPG0E(this);
        this.f9322A5SV6n = a2egSU;
        this.f9323ADYaiT = cojear;
        f508t2.getClass();
        this.f9320A2egSU = new F32kj0(f508t2, this);
        this.f9321A4TApA = azWtSf;
        this.AMqCpz = a2egSU.getItemCount();
        a2egSU.registerAdapterDataObserver(cnpg0e);
    }
}

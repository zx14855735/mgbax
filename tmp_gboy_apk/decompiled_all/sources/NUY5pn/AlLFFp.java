package NUY5pn;

import android.os.Bundle;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AlLFFp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public Boolean f5959A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public boolean f5960A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final BJ7GGh f5961A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final int f5962ADYaiT;
    public final Bundle AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final BJ7GGh f5963ARc23Z;

    public AlLFFp(BJ7GGh bJ7GGh, int i, Bundle bundle) {
        this.f5963ARc23Z = bJ7GGh;
        Boolean bool = Boolean.TRUE;
        this.f5961A5SV6n = bJ7GGh;
        this.f5959A2egSU = bool;
        this.f5960A4TApA = false;
        this.f5962ADYaiT = i;
        this.AMqCpz = bundle;
    }

    public abstract void A2egSU(NOd7IU.A2egSU a2egSU);

    public abstract boolean A4TApA();

    public final void A5SV6n() {
        ADYaiT();
        synchronized (this.f5961A5SV6n.f5997AzWtSf) {
            this.f5961A5SV6n.f5997AzWtSf.remove(this);
        }
    }

    public final void ADYaiT() {
        synchronized (this) {
            this.f5959A2egSU = null;
        }
    }
}

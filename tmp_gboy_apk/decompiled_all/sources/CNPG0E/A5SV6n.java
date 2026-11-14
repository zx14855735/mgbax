package CNPG0E;

import B4ZgIw.AMqCpz;
import RXb0Sz.ARc23Z;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n extends AMqCpz {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Object f1612A5SV6n;

    public A5SV6n(int i) {
        super(i);
        this.f1612A5SV6n = new Object();
    }

    @Override // B4ZgIw.AMqCpz
    public final Object A2egSU() {
        Object A2egSU2;
        synchronized (this.f1612A5SV6n) {
            A2egSU2 = super.A2egSU();
        }
        return A2egSU2;
    }

    @Override // B4ZgIw.AMqCpz
    public final boolean A5SV6n(Object obj) {
        boolean A5SV6n2;
        ARc23Z.AMqCpz(obj, "instance");
        synchronized (this.f1612A5SV6n) {
            A5SV6n2 = super.A5SV6n(obj);
        }
        return A5SV6n2;
    }
}

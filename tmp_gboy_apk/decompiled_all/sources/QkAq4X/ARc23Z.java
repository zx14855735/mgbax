package QkAq4X;

import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ARc23Z implements Iterator {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f7739AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f7740AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f7741AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f7742AzWtSf = false;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final A2egSU f7743B25kr6;

    public ARc23Z(A2egSU a2egSU, int i) {
        this.f7743B25kr6 = a2egSU;
        this.f7739AcNBzu = i;
        this.f7740AlLFFp = a2egSU.A2egSU();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f7741AmA8tU < this.f7740AlLFFp;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object A5SV6n2 = this.f7743B25kr6.A5SV6n(this.f7741AmA8tU, this.f7739AcNBzu);
        this.f7741AmA8tU++;
        this.f7742AzWtSf = true;
        return A5SV6n2;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f7742AzWtSf) {
            throw new IllegalStateException();
        }
        int i = this.f7741AmA8tU - 1;
        this.f7741AmA8tU = i;
        this.f7740AlLFFp--;
        this.f7742AzWtSf = false;
        this.f7743B25kr6.ADYaiT(i);
    }
}

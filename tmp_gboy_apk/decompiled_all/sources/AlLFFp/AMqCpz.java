package AlLFFp;

import AlLFFp.ARc23Z;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AMqCpz extends ARc23Z.A2egSU implements Iterator {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public A5SV6n f951AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public A5SV6n f952AlLFFp;

    @Override // AlLFFp.ARc23Z.A2egSU
    public final void A2egSU(A5SV6n a5SV6n) {
        A5SV6n a5SV6n2 = null;
        if (this.f951AcNBzu == a5SV6n && a5SV6n == this.f952AlLFFp) {
            this.f952AlLFFp = null;
            this.f951AcNBzu = null;
        }
        A5SV6n a5SV6n3 = this.f951AcNBzu;
        if (a5SV6n3 == a5SV6n) {
            this.f951AcNBzu = A4TApA(a5SV6n3);
        }
        A5SV6n a5SV6n4 = this.f952AlLFFp;
        if (a5SV6n4 == a5SV6n) {
            A5SV6n a5SV6n5 = this.f951AcNBzu;
            if (a5SV6n4 != a5SV6n5 && a5SV6n5 != null) {
                a5SV6n2 = A5SV6n(a5SV6n4);
            }
            this.f952AlLFFp = a5SV6n2;
        }
    }

    public abstract A5SV6n A4TApA(A5SV6n a5SV6n);

    public abstract A5SV6n A5SV6n(A5SV6n a5SV6n);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f952AlLFFp != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        A5SV6n a5SV6n = this.f952AlLFFp;
        A5SV6n a5SV6n2 = this.f951AcNBzu;
        this.f952AlLFFp = (a5SV6n == a5SV6n2 || a5SV6n2 == null) ? null : A5SV6n(a5SV6n);
        return a5SV6n;
    }
}

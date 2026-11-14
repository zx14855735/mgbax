package AlLFFp;

import AlLFFp.ARc23Z;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT extends ARc23Z.A2egSU implements Iterator {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public A5SV6n f948AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f949AlLFFp = true;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ ARc23Z f950AmA8tU;

    public ADYaiT(ARc23Z aRc23Z) {
        this.f950AmA8tU = aRc23Z;
    }

    @Override // AlLFFp.ARc23Z.A2egSU
    public final void A2egSU(A5SV6n a5SV6n) {
        A5SV6n a5SV6n2 = this.f948AcNBzu;
        if (a5SV6n == a5SV6n2) {
            A5SV6n a5SV6n3 = a5SV6n2.f947AzWtSf;
            this.f948AcNBzu = a5SV6n3;
            this.f949AlLFFp = a5SV6n3 == null;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f949AlLFFp) {
            return this.f950AmA8tU.f953AcNBzu != null;
        }
        A5SV6n a5SV6n = this.f948AcNBzu;
        return (a5SV6n == null || a5SV6n.f946AmA8tU == null) ? false : true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f949AlLFFp) {
            this.f949AlLFFp = false;
            this.f948AcNBzu = this.f950AmA8tU.f953AcNBzu;
        } else {
            A5SV6n a5SV6n = this.f948AcNBzu;
            this.f948AcNBzu = a5SV6n != null ? a5SV6n.f946AmA8tU : null;
        }
        return this.f948AcNBzu;
    }
}

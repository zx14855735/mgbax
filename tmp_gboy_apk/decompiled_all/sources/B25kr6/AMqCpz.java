package B25kr6;

import RD2OKB.B4ZgIw;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz implements Collection, Set {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int[] f983AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Object[] f984AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f985AmA8tU;

    public AMqCpz() {
        this(0);
    }

    public final void A2egSU(int i) {
        int i2;
        int i3 = this.f985AmA8tU;
        Object[] objArr = this.f984AlLFFp;
        Object obj = objArr[i];
        if (i3 <= 1) {
            clear();
            return;
        }
        int i4 = i3 - 1;
        int[] iArr = this.f983AcNBzu;
        if (iArr.length <= 8 || i3 >= iArr.length / 3) {
            if (i < i4) {
                int i5 = i + 1;
                RD2OKB.AZOQYO.A2egSU(i, i5, iArr, iArr, i3);
                Object[] objArr2 = this.f984AlLFFp;
                RD2OKB.AZOQYO.A4TApA(objArr2, objArr2, i, i5, i3);
            }
            this.f984AlLFFp[i4] = null;
        } else {
            AZOQYO.A4TApA(this, i3 > 8 ? i3 + (i3 >> 1) : 8);
            if (i > 0) {
                RD2OKB.AZOQYO.A2egSU(0, 0, iArr, this.f983AcNBzu, i);
                i2 = i;
                RD2OKB.AZOQYO.A5SV6n(objArr, this.f984AlLFFp, 0, 0, i2, 6);
            } else {
                i2 = i;
            }
            if (i2 < i4) {
                int i6 = i2 + 1;
                RD2OKB.AZOQYO.A2egSU(i2, i6, iArr, this.f983AcNBzu, i3);
                RD2OKB.AZOQYO.A4TApA(objArr, this.f984AlLFFp, i2, i6, i3);
            }
        }
        if (i3 != this.f985AmA8tU) {
            throw new ConcurrentModificationException();
        }
        this.f985AmA8tU = i4;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i;
        int A5SV6n2;
        int i2 = this.f985AmA8tU;
        if (obj == null) {
            A5SV6n2 = AZOQYO.A5SV6n(this, null, 0);
            i = 0;
        } else {
            int hashCode = obj.hashCode();
            i = hashCode;
            A5SV6n2 = AZOQYO.A5SV6n(this, obj, hashCode);
        }
        if (A5SV6n2 >= 0) {
            return false;
        }
        int i3 = ~A5SV6n2;
        int[] iArr = this.f983AcNBzu;
        if (i2 >= iArr.length) {
            int i4 = 8;
            if (i2 >= 8) {
                i4 = (i2 >> 1) + i2;
            } else if (i2 < 4) {
                i4 = 4;
            }
            Object[] objArr = this.f984AlLFFp;
            AZOQYO.A4TApA(this, i4);
            if (i2 != this.f985AmA8tU) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f983AcNBzu;
            if (iArr2.length != 0) {
                RD2OKB.AZOQYO.A2egSU(0, 0, iArr, iArr2, iArr.length);
                RD2OKB.AZOQYO.A5SV6n(objArr, this.f984AlLFFp, 0, 0, objArr.length, 6);
            }
        }
        if (i3 < i2) {
            int[] iArr3 = this.f983AcNBzu;
            int i5 = i3 + 1;
            RD2OKB.AZOQYO.A2egSU(i5, i3, iArr3, iArr3, i2);
            Object[] objArr2 = this.f984AlLFFp;
            RD2OKB.AZOQYO.A4TApA(objArr2, objArr2, i5, i3, i2);
        }
        int i6 = this.f985AmA8tU;
        if (i2 == i6) {
            int[] iArr4 = this.f983AcNBzu;
            if (i3 < iArr4.length) {
                iArr4[i3] = i;
                this.f984AlLFFp[i3] = obj;
                this.f985AmA8tU = i6 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        RXb0Sz.ARc23Z.AMqCpz(collection, "elements");
        int size = collection.size() + this.f985AmA8tU;
        int i = this.f985AmA8tU;
        int[] iArr = this.f983AcNBzu;
        boolean z = false;
        if (iArr.length < size) {
            Object[] objArr = this.f984AlLFFp;
            AZOQYO.A4TApA(this, size);
            int i2 = this.f985AmA8tU;
            if (i2 > 0) {
                RD2OKB.AZOQYO.A2egSU(0, 0, iArr, this.f983AcNBzu, i2);
                RD2OKB.AZOQYO.A5SV6n(objArr, this.f984AlLFFp, 0, 0, this.f985AmA8tU, 6);
            }
        }
        if (this.f985AmA8tU != i) {
            throw new ConcurrentModificationException();
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            z |= add(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        if (this.f985AmA8tU != 0) {
            this.f983AcNBzu = B2KMhB.A2egSU.f1016A2egSU;
            this.f984AlLFFp = B2KMhB.A2egSU.f1017A4TApA;
            this.f985AmA8tU = 0;
        }
        if (this.f985AmA8tU != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return (obj == null ? AZOQYO.A5SV6n(this, null, 0) : AZOQYO.A5SV6n(this, obj, obj.hashCode())) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        RXb0Sz.ARc23Z.AMqCpz(collection, "elements");
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set) || this.f985AmA8tU != ((Set) obj).size()) {
            return false;
        }
        try {
            int i = this.f985AmA8tU;
            for (int i2 = 0; i2 < i; i2++) {
                if (!((Set) obj).contains(this.f984AlLFFp[i2])) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.f983AcNBzu;
        int i = this.f985AmA8tU;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f985AmA8tU <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new A2egSU(this);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int A5SV6n2 = obj == null ? AZOQYO.A5SV6n(this, null, 0) : AZOQYO.A5SV6n(this, obj, obj.hashCode());
        if (A5SV6n2 < 0) {
            return false;
        }
        A2egSU(A5SV6n2);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        RXb0Sz.ARc23Z.AMqCpz(collection, "elements");
        Iterator it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        RXb0Sz.ARc23Z.AMqCpz(collection, "elements");
        boolean z = false;
        for (int i = this.f985AmA8tU - 1; -1 < i; i--) {
            if (!B4ZgIw.AYUAbz(collection, this.f984AlLFFp[i])) {
                A2egSU(i);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.f985AmA8tU;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return RD2OKB.AZOQYO.ADYaiT(this.f984AlLFFp, 0, this.f985AmA8tU);
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f985AmA8tU * 14);
        sb.append('{');
        int i = this.f985AmA8tU;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object obj = this.f984AlLFFp[i2];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        RXb0Sz.ARc23Z.ADYaiT(sb2, "toString(...)");
        return sb2;
    }

    public AMqCpz(int i) {
        this.f983AcNBzu = B2KMhB.A2egSU.f1016A2egSU;
        this.f984AlLFFp = B2KMhB.A2egSU.f1017A4TApA;
        if (i > 0) {
            AZOQYO.A4TApA(this, i);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        RXb0Sz.ARc23Z.AMqCpz(objArr, "array");
        int i = this.f985AmA8tU;
        if (objArr.length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        } else if (objArr.length > i) {
            objArr[i] = null;
        }
        RD2OKB.AZOQYO.A4TApA(this.f984AlLFFp, objArr, 0, 0, this.f985AmA8tU);
        return objArr;
    }
}

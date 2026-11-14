package RFbdkT;

import NOd7IU.AlLFFp;
import RD2OKB.ADYaiT;
import RD2OKB.AZOQYO;
import RXb0Sz.ARc23Z;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A4TApA extends ADYaiT implements RandomAccess, Serializable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public Object[] f7854AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final int f7855AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f7856AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final A4TApA f7857AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final A5SV6n f7858B25kr6;

    public A4TApA(Object[] objArr, int i, int i2, A4TApA a4TApA, A5SV6n a5SV6n) {
        int i3;
        ARc23Z.AMqCpz(objArr, "backing");
        ARc23Z.AMqCpz(a5SV6n, "root");
        this.f7854AcNBzu = objArr;
        this.f7855AlLFFp = i;
        this.f7856AmA8tU = i2;
        this.f7857AzWtSf = a4TApA;
        this.f7858B25kr6 = a5SV6n;
        i3 = ((AbstractList) a5SV6n).modCount;
        ((AbstractList) this).modCount = i3;
    }

    @Override // RD2OKB.ADYaiT
    public final int A2egSU() {
        ARc23Z();
        return this.f7856AmA8tU;
    }

    @Override // RD2OKB.ADYaiT
    public final Object A4TApA(int i) {
        ASJ6gh();
        ARc23Z();
        int i2 = this.f7856AmA8tU;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i, i2, "index: ", ", size: "));
        }
        return AYUAbz(this.f7855AlLFFp + i);
    }

    public final void ADYaiT(int i, Collection collection, int i2) {
        ((AbstractList) this).modCount++;
        A5SV6n a5SV6n = this.f7858B25kr6;
        A4TApA a4TApA = this.f7857AzWtSf;
        if (a4TApA != null) {
            a4TApA.ADYaiT(i, collection, i2);
        } else {
            A5SV6n a5SV6n2 = A5SV6n.f7859AzWtSf;
            a5SV6n.ADYaiT(i, collection, i2);
        }
        this.f7854AcNBzu = a5SV6n.f7860AcNBzu;
        this.f7856AmA8tU += i2;
    }

    public final void AMqCpz(int i, Object obj) {
        ((AbstractList) this).modCount++;
        A5SV6n a5SV6n = this.f7858B25kr6;
        A4TApA a4TApA = this.f7857AzWtSf;
        if (a4TApA != null) {
            a4TApA.AMqCpz(i, obj);
        } else {
            A5SV6n a5SV6n2 = A5SV6n.f7859AzWtSf;
            a5SV6n.AMqCpz(i, obj);
        }
        this.f7854AcNBzu = a5SV6n.f7860AcNBzu;
        this.f7856AmA8tU++;
    }

    public final void ARc23Z() {
        int i;
        i = ((AbstractList) this.f7858B25kr6).modCount;
        if (i != ((AbstractList) this).modCount) {
            throw new ConcurrentModificationException();
        }
    }

    public final void ASJ6gh() {
        if (this.f7858B25kr6.f7862AmA8tU) {
            throw new UnsupportedOperationException();
        }
    }

    public final Object AYUAbz(int i) {
        Object AYUAbz2;
        ((AbstractList) this).modCount++;
        A4TApA a4TApA = this.f7857AzWtSf;
        if (a4TApA != null) {
            AYUAbz2 = a4TApA.AYUAbz(i);
        } else {
            A5SV6n a5SV6n = A5SV6n.f7859AzWtSf;
            AYUAbz2 = this.f7858B25kr6.AYUAbz(i);
        }
        this.f7856AmA8tU--;
        return AYUAbz2;
    }

    public final void AZOQYO(int i, int i2) {
        if (i2 > 0) {
            ((AbstractList) this).modCount++;
        }
        A4TApA a4TApA = this.f7857AzWtSf;
        if (a4TApA != null) {
            a4TApA.AZOQYO(i, i2);
        } else {
            A5SV6n a5SV6n = A5SV6n.f7859AzWtSf;
            this.f7858B25kr6.AZOQYO(i, i2);
        }
        this.f7856AmA8tU -= i2;
    }

    public final int AZkASS(int i, int i2, Collection collection, boolean z) {
        int AZkASS2;
        A4TApA a4TApA = this.f7857AzWtSf;
        if (a4TApA != null) {
            AZkASS2 = a4TApA.AZkASS(i, i2, collection, z);
        } else {
            A5SV6n a5SV6n = A5SV6n.f7859AzWtSf;
            AZkASS2 = this.f7858B25kr6.AZkASS(i, i2, collection, z);
        }
        if (AZkASS2 > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f7856AmA8tU -= AZkASS2;
        return AZkASS2;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        ASJ6gh();
        ARc23Z();
        AMqCpz(this.f7855AlLFFp + this.f7856AmA8tU, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        ARc23Z.AMqCpz(collection, "elements");
        ASJ6gh();
        ARc23Z();
        int size = collection.size();
        ADYaiT(this.f7855AlLFFp + this.f7856AmA8tU, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        ASJ6gh();
        ARc23Z();
        AZOQYO(this.f7855AlLFFp, this.f7856AmA8tU);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        ARc23Z();
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return AlLFFp.AcNBzu(this.f7854AcNBzu, this.f7855AlLFFp, this.f7856AmA8tU, (List) obj);
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        ARc23Z();
        int i2 = this.f7856AmA8tU;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i, i2, "index: ", ", size: "));
        }
        return this.f7854AcNBzu[this.f7855AlLFFp + i];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        ARc23Z();
        Object[] objArr = this.f7854AcNBzu;
        int i = this.f7856AmA8tU;
        int i2 = 1;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[this.f7855AlLFFp + i3];
            i2 = (i2 * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        ARc23Z();
        for (int i = 0; i < this.f7856AmA8tU; i++) {
            if (ARc23Z.A2egSU(this.f7854AcNBzu[this.f7855AlLFFp + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        ARc23Z();
        return this.f7856AmA8tU == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        ARc23Z();
        for (int i = this.f7856AmA8tU - 1; i >= 0; i--) {
            if (ARc23Z.A2egSU(this.f7854AcNBzu[this.f7855AlLFFp + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        ASJ6gh();
        ARc23Z();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            A4TApA(indexOf);
        }
        return indexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        ARc23Z.AMqCpz(collection, "elements");
        ASJ6gh();
        ARc23Z();
        return AZkASS(this.f7855AlLFFp, this.f7856AmA8tU, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        ARc23Z.AMqCpz(collection, "elements");
        ASJ6gh();
        ARc23Z();
        return AZkASS(this.f7855AlLFFp, this.f7856AmA8tU, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        ASJ6gh();
        ARc23Z();
        int i2 = this.f7856AmA8tU;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i, i2, "index: ", ", size: "));
        }
        Object[] objArr = this.f7854AcNBzu;
        int i3 = this.f7855AlLFFp;
        Object obj2 = objArr[i3 + i];
        objArr[i3 + i] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        JrXYwF.A4TApA.B7CMnp(i, i2, this.f7856AmA8tU);
        return new A4TApA(this.f7854AcNBzu, this.f7855AlLFFp + i, i2 - i, this, this.f7858B25kr6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        ARc23Z.AMqCpz(objArr, "array");
        ARc23Z();
        int length = objArr.length;
        int i = this.f7856AmA8tU;
        int i2 = this.f7855AlLFFp;
        if (length < i) {
            Object[] copyOfRange = Arrays.copyOfRange(this.f7854AcNBzu, i2, i + i2, objArr.getClass());
            ARc23Z.ADYaiT(copyOfRange, "copyOfRange(...)");
            return copyOfRange;
        }
        AZOQYO.A4TApA(this.f7854AcNBzu, objArr, 0, i2, i + i2);
        int i3 = this.f7856AmA8tU;
        if (i3 < objArr.length) {
            objArr[i3] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        ARc23Z();
        return AlLFFp.AlLFFp(this.f7854AcNBzu, this.f7855AlLFFp, this.f7856AmA8tU, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        ARc23Z();
        int i2 = this.f7856AmA8tU;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i, i2, "index: ", ", size: "));
        }
        return new A2egSU(this, i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        ASJ6gh();
        ARc23Z();
        int i2 = this.f7856AmA8tU;
        if (i >= 0 && i <= i2) {
            AMqCpz(this.f7855AlLFFp + i, obj);
            return;
        }
        throw new IndexOutOfBoundsException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i, i2, "index: ", ", size: "));
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        ARc23Z.AMqCpz(collection, "elements");
        ASJ6gh();
        ARc23Z();
        int i2 = this.f7856AmA8tU;
        if (i >= 0 && i <= i2) {
            int size = collection.size();
            ADYaiT(this.f7855AlLFFp + i, collection, size);
            return size > 0;
        }
        throw new IndexOutOfBoundsException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i, i2, "index: ", ", size: "));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        ARc23Z();
        Object[] objArr = this.f7854AcNBzu;
        int i = this.f7856AmA8tU;
        int i2 = this.f7855AlLFFp;
        return AZOQYO.ADYaiT(objArr, i2, i + i2);
    }
}

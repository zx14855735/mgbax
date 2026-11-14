package RFbdkT;

import NOd7IU.AlLFFp;
import RD2OKB.ADYaiT;
import RD2OKB.AZOQYO;
import RXb0Sz.ARc23Z;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A5SV6n extends ADYaiT implements List, RandomAccess, Serializable {

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static final A5SV6n f7859AzWtSf;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public Object[] f7860AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f7861AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f7862AmA8tU;

    static {
        A5SV6n a5SV6n = new A5SV6n(0);
        a5SV6n.f7862AmA8tU = true;
        f7859AzWtSf = a5SV6n;
        CvRTUp();
    }

    public A5SV6n() {
        this((Object) null);
    }

    private static /* synthetic */ void CvRTUp() {
        char[] charArray = "<02q8>2:q=0&q,7:33q\u001516\u001d-6;8:".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '_');
        }
        String str = new String(charArray);
        char[] charArray2 = "<3616+".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '_');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // RD2OKB.ADYaiT
    public final int A2egSU() {
        return this.f7861AlLFFp;
    }

    @Override // RD2OKB.ADYaiT
    public final Object A4TApA(int i) {
        ARc23Z();
        int i2 = this.f7861AlLFFp;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i, i2, "index: ", ", size: "));
        }
        return AYUAbz(i);
    }

    public final void ADYaiT(int i, Collection collection, int i2) {
        ((AbstractList) this).modCount++;
        ASJ6gh(i, i2);
        Iterator it = collection.iterator();
        for (int i3 = 0; i3 < i2; i3++) {
            this.f7860AcNBzu[i + i3] = it.next();
        }
    }

    public final void AMqCpz(int i, Object obj) {
        ((AbstractList) this).modCount++;
        ASJ6gh(i, 1);
        this.f7860AcNBzu[i] = obj;
    }

    public final void ARc23Z() {
        if (this.f7862AmA8tU) {
            throw new UnsupportedOperationException();
        }
    }

    public final void ASJ6gh(int i, int i2) {
        int i3 = this.f7861AlLFFp + i2;
        if (i3 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.f7860AcNBzu;
        if (i3 > objArr.length) {
            int length = objArr.length;
            int i4 = length + (length >> 1);
            if (i4 - i3 < 0) {
                i4 = i3;
            }
            if (i4 - 2147483639 > 0) {
                i4 = i3 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            Object[] copyOf = Arrays.copyOf(objArr, i4);
            ARc23Z.ADYaiT(copyOf, "copyOf(...)");
            this.f7860AcNBzu = copyOf;
        }
        Object[] objArr2 = this.f7860AcNBzu;
        AZOQYO.A4TApA(objArr2, objArr2, i + i2, i, this.f7861AlLFFp);
        this.f7861AlLFFp += i2;
    }

    public final Object AYUAbz(int i) {
        ((AbstractList) this).modCount++;
        Object[] objArr = this.f7860AcNBzu;
        Object obj = objArr[i];
        AZOQYO.A4TApA(objArr, objArr, i, i + 1, this.f7861AlLFFp);
        Object[] objArr2 = this.f7860AcNBzu;
        int i2 = this.f7861AlLFFp - 1;
        ARc23Z.AMqCpz(objArr2, "<this>");
        objArr2[i2] = null;
        this.f7861AlLFFp--;
        return obj;
    }

    public final void AZOQYO(int i, int i2) {
        if (i2 > 0) {
            ((AbstractList) this).modCount++;
        }
        Object[] objArr = this.f7860AcNBzu;
        AZOQYO.A4TApA(objArr, objArr, i, i + i2, this.f7861AlLFFp);
        Object[] objArr2 = this.f7860AcNBzu;
        int i3 = this.f7861AlLFFp;
        ARc23Z.AMqCpz(objArr2, "<this>");
        for (int i4 = i3 - i2; i4 < i3; i4++) {
            objArr2[i4] = null;
        }
        this.f7861AlLFFp -= i2;
    }

    public final int AZkASS(int i, int i2, Collection collection, boolean z) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i + i3;
            if (collection.contains(this.f7860AcNBzu[i5]) == z) {
                Object[] objArr = this.f7860AcNBzu;
                i3++;
                objArr[i4 + i] = objArr[i5];
                i4++;
            } else {
                i3++;
            }
        }
        int i6 = i2 - i4;
        Object[] objArr2 = this.f7860AcNBzu;
        AZOQYO.A4TApA(objArr2, objArr2, i + i4, i2 + i, this.f7861AlLFFp);
        Object[] objArr3 = this.f7860AcNBzu;
        int i7 = this.f7861AlLFFp;
        ARc23Z.AMqCpz(objArr3, "<this>");
        for (int i8 = i7 - i6; i8 < i7; i8++) {
            objArr3[i8] = null;
        }
        if (i6 > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f7861AlLFFp -= i6;
        return i6;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        ARc23Z();
        int i = this.f7861AlLFFp;
        ((AbstractList) this).modCount++;
        ASJ6gh(i, 1);
        this.f7860AcNBzu[i] = obj;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        ARc23Z.AMqCpz(collection, "elements");
        ARc23Z();
        int size = collection.size();
        ADYaiT(this.f7861AlLFFp, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        ARc23Z();
        AZOQYO(0, this.f7861AlLFFp);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            if (AlLFFp.AcNBzu(this.f7860AcNBzu, 0, this.f7861AlLFFp, (List) obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int i2 = this.f7861AlLFFp;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i, i2, "index: ", ", size: "));
        }
        return this.f7860AcNBzu[i];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        Object[] objArr = this.f7860AcNBzu;
        int i = this.f7861AlLFFp;
        int i2 = 1;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            i2 = (i2 * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        for (int i = 0; i < this.f7861AlLFFp; i++) {
            if (ARc23Z.A2egSU(this.f7860AcNBzu[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f7861AlLFFp == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        for (int i = this.f7861AlLFFp - 1; i >= 0; i--) {
            if (ARc23Z.A2egSU(this.f7860AcNBzu[i], obj)) {
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
        ARc23Z();
        return AZkASS(0, this.f7861AlLFFp, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        ARc23Z.AMqCpz(collection, "elements");
        ARc23Z();
        return AZkASS(0, this.f7861AlLFFp, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        ARc23Z();
        int i2 = this.f7861AlLFFp;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i, i2, "index: ", ", size: "));
        }
        Object[] objArr = this.f7860AcNBzu;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        JrXYwF.A4TApA.B7CMnp(i, i2, this.f7861AlLFFp);
        return new A4TApA(this.f7860AcNBzu, i, i2 - i, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        ARc23Z.AMqCpz(objArr, "array");
        int length = objArr.length;
        int i = this.f7861AlLFFp;
        if (length < i) {
            Object[] copyOfRange = Arrays.copyOfRange(this.f7860AcNBzu, 0, i, objArr.getClass());
            ARc23Z.ADYaiT(copyOfRange, "copyOfRange(...)");
            return copyOfRange;
        }
        AZOQYO.A4TApA(this.f7860AcNBzu, objArr, 0, 0, i);
        int i2 = this.f7861AlLFFp;
        if (i2 < objArr.length) {
            objArr[i2] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return AlLFFp.AlLFFp(this.f7860AcNBzu, 0, this.f7861AlLFFp, this);
    }

    public /* synthetic */ A5SV6n(Object obj) {
        this(10);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        int i2 = this.f7861AlLFFp;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i, i2, "index: ", ", size: "));
        }
        return new A2egSU(this, i);
    }

    public A5SV6n(int i) {
        if (i >= 0) {
            this.f7860AcNBzu = new Object[i];
            return;
        }
        throw new IllegalArgumentException("capacity must be non-negative.");
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        ARc23Z.AMqCpz(collection, "elements");
        ARc23Z();
        int i2 = this.f7861AlLFFp;
        if (i >= 0 && i <= i2) {
            int size = collection.size();
            ADYaiT(i, collection, size);
            return size > 0;
        }
        throw new IndexOutOfBoundsException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i, i2, "index: ", ", size: "));
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        ARc23Z();
        int i2 = this.f7861AlLFFp;
        if (i >= 0 && i <= i2) {
            ((AbstractList) this).modCount++;
            ASJ6gh(i, 1);
            this.f7860AcNBzu[i] = obj;
            return;
        }
        throw new IndexOutOfBoundsException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i, i2, "index: ", ", size: "));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return AZOQYO.ADYaiT(this.f7860AcNBzu, 0, this.f7861AlLFFp);
    }
}

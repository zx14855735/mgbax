package RD2OKB;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ARc23Z extends ADYaiT {

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static final Object[] f7841AzWtSf = new Object[0];

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f7842AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Object[] f7843AlLFFp = f7841AzWtSf;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f7844AmA8tU;

    static {
        aBoGHN();
    }

    private static /* synthetic */ void aBoGHN() {
        char[] charArray = " ,.m$\".&m!,:m0+&//m\t-*\u00011*'$&".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'C');
        }
        String str = new String(charArray);
        char[] charArray2 = " /*-*7".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'C');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // RD2OKB.ADYaiT
    public final int A2egSU() {
        return this.f7844AmA8tU;
    }

    @Override // RD2OKB.ADYaiT
    public final Object A4TApA(int i) {
        int i2 = this.f7844AmA8tU;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i, i2, "index: ", ", size: "));
        }
        if (i == AaHO0E.ADYaiT(this)) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        AZOQYO();
        int AYUAbz2 = AYUAbz(this.f7842AcNBzu + i);
        Object[] objArr = this.f7843AlLFFp;
        Object obj = objArr[AYUAbz2];
        if (i < (this.f7844AmA8tU >> 1)) {
            int i3 = this.f7842AcNBzu;
            if (AYUAbz2 >= i3) {
                AZOQYO.A4TApA(objArr, objArr, i3 + 1, i3, AYUAbz2);
            } else {
                AZOQYO.A4TApA(objArr, objArr, 1, 0, AYUAbz2);
                Object[] objArr2 = this.f7843AlLFFp;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i4 = this.f7842AcNBzu;
                AZOQYO.A4TApA(objArr2, objArr2, i4 + 1, i4, objArr2.length - 1);
            }
            Object[] objArr3 = this.f7843AlLFFp;
            int i5 = this.f7842AcNBzu;
            objArr3[i5] = null;
            this.f7842AcNBzu = AMqCpz(i5);
        } else {
            int AYUAbz3 = AYUAbz(AaHO0E.ADYaiT(this) + this.f7842AcNBzu);
            if (AYUAbz2 <= AYUAbz3) {
                Object[] objArr4 = this.f7843AlLFFp;
                AZOQYO.A4TApA(objArr4, objArr4, AYUAbz2, AYUAbz2 + 1, AYUAbz3 + 1);
            } else {
                Object[] objArr5 = this.f7843AlLFFp;
                AZOQYO.A4TApA(objArr5, objArr5, AYUAbz2, AYUAbz2 + 1, objArr5.length);
                Object[] objArr6 = this.f7843AlLFFp;
                objArr6[objArr6.length - 1] = objArr6[0];
                AZOQYO.A4TApA(objArr6, objArr6, 0, 1, AYUAbz3 + 1);
            }
            this.f7843AlLFFp[AYUAbz3] = null;
        }
        this.f7844AmA8tU--;
        return obj;
    }

    public final void A5SV6n(int i, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f7843AlLFFp.length;
        while (i < length && it.hasNext()) {
            this.f7843AlLFFp[i] = it.next();
            i++;
        }
        int i2 = this.f7842AcNBzu;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.f7843AlLFFp[i3] = it.next();
        }
        this.f7844AmA8tU = collection.size() + this.f7844AmA8tU;
    }

    public final void ADYaiT(int i) {
        if (i < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f7843AlLFFp;
        if (i <= objArr.length) {
            return;
        }
        if (objArr == f7841AzWtSf) {
            if (i < 10) {
                i = 10;
            }
            this.f7843AlLFFp = new Object[i];
            return;
        }
        int length = objArr.length;
        int i2 = length + (length >> 1);
        if (i2 - i < 0) {
            i2 = i;
        }
        if (i2 - 2147483639 > 0) {
            i2 = i > 2147483639 ? Integer.MAX_VALUE : 2147483639;
        }
        Object[] objArr2 = new Object[i2];
        AZOQYO.A4TApA(objArr, objArr2, 0, this.f7842AcNBzu, objArr.length);
        Object[] objArr3 = this.f7843AlLFFp;
        int length2 = objArr3.length;
        int i3 = this.f7842AcNBzu;
        AZOQYO.A4TApA(objArr3, objArr2, length2 - i3, 0, i3);
        this.f7842AcNBzu = 0;
        this.f7843AlLFFp = objArr2;
    }

    public final int AMqCpz(int i) {
        RXb0Sz.ARc23Z.AMqCpz(this.f7843AlLFFp, "<this>");
        if (i == r0.length - 1) {
            return 0;
        }
        return i + 1;
    }

    public final int ARc23Z(int i) {
        return i < 0 ? i + this.f7843AlLFFp.length : i;
    }

    public final void ASJ6gh(int i, int i2) {
        if (i < i2) {
            Object[] objArr = this.f7843AlLFFp;
            RXb0Sz.ARc23Z.AMqCpz(objArr, "<this>");
            Arrays.fill(objArr, i, i2, (Object) null);
        } else {
            Object[] objArr2 = this.f7843AlLFFp;
            Arrays.fill(objArr2, i, objArr2.length, (Object) null);
            Object[] objArr3 = this.f7843AlLFFp;
            RXb0Sz.ARc23Z.AMqCpz(objArr3, "<this>");
            Arrays.fill(objArr3, 0, i2, (Object) null);
        }
    }

    public final int AYUAbz(int i) {
        Object[] objArr = this.f7843AlLFFp;
        return i >= objArr.length ? i - objArr.length : i;
    }

    public final void AZOQYO() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        int i3 = this.f7844AmA8tU;
        if (i < 0 || i > i3) {
            throw new IndexOutOfBoundsException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i, i3, "index: ", ", size: "));
        }
        if (i == i3) {
            addLast(obj);
            return;
        }
        if (i == 0) {
            addFirst(obj);
            return;
        }
        AZOQYO();
        ADYaiT(this.f7844AmA8tU + 1);
        int AYUAbz2 = AYUAbz(this.f7842AcNBzu + i);
        int i4 = this.f7844AmA8tU;
        if (i < ((i4 + 1) >> 1)) {
            if (AYUAbz2 == 0) {
                Object[] objArr = this.f7843AlLFFp;
                RXb0Sz.ARc23Z.AMqCpz(objArr, "<this>");
                AYUAbz2 = objArr.length;
            }
            int i5 = AYUAbz2 - 1;
            int i6 = this.f7842AcNBzu;
            if (i6 == 0) {
                Object[] objArr2 = this.f7843AlLFFp;
                RXb0Sz.ARc23Z.AMqCpz(objArr2, "<this>");
                i2 = objArr2.length - 1;
            } else {
                i2 = i6 - 1;
            }
            int i7 = this.f7842AcNBzu;
            if (i5 >= i7) {
                Object[] objArr3 = this.f7843AlLFFp;
                objArr3[i2] = objArr3[i7];
                AZOQYO.A4TApA(objArr3, objArr3, i7, i7 + 1, i5 + 1);
            } else {
                Object[] objArr4 = this.f7843AlLFFp;
                AZOQYO.A4TApA(objArr4, objArr4, i7 - 1, i7, objArr4.length);
                Object[] objArr5 = this.f7843AlLFFp;
                objArr5[objArr5.length - 1] = objArr5[0];
                AZOQYO.A4TApA(objArr5, objArr5, 0, 1, i5 + 1);
            }
            this.f7843AlLFFp[i5] = obj;
            this.f7842AcNBzu = i2;
        } else {
            int AYUAbz3 = AYUAbz(i4 + this.f7842AcNBzu);
            if (AYUAbz2 < AYUAbz3) {
                Object[] objArr6 = this.f7843AlLFFp;
                AZOQYO.A4TApA(objArr6, objArr6, AYUAbz2 + 1, AYUAbz2, AYUAbz3);
            } else {
                Object[] objArr7 = this.f7843AlLFFp;
                AZOQYO.A4TApA(objArr7, objArr7, 1, 0, AYUAbz3);
                Object[] objArr8 = this.f7843AlLFFp;
                objArr8[0] = objArr8[objArr8.length - 1];
                AZOQYO.A4TApA(objArr8, objArr8, AYUAbz2 + 1, AYUAbz2, objArr8.length - 1);
            }
            this.f7843AlLFFp[AYUAbz2] = obj;
        }
        this.f7844AmA8tU++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        RXb0Sz.ARc23Z.AMqCpz(collection, "elements");
        int i2 = this.f7844AmA8tU;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i, i2, "index: ", ", size: "));
        }
        if (collection.isEmpty()) {
            return false;
        }
        if (i == this.f7844AmA8tU) {
            return addAll(collection);
        }
        AZOQYO();
        ADYaiT(collection.size() + this.f7844AmA8tU);
        int AYUAbz2 = AYUAbz(this.f7844AmA8tU + this.f7842AcNBzu);
        int AYUAbz3 = AYUAbz(this.f7842AcNBzu + i);
        int size = collection.size();
        if (i >= ((this.f7844AmA8tU + 1) >> 1)) {
            int i3 = AYUAbz3 + size;
            if (AYUAbz3 < AYUAbz2) {
                int i4 = size + AYUAbz2;
                Object[] objArr = this.f7843AlLFFp;
                if (i4 <= objArr.length) {
                    AZOQYO.A4TApA(objArr, objArr, i3, AYUAbz3, AYUAbz2);
                } else if (i3 >= objArr.length) {
                    AZOQYO.A4TApA(objArr, objArr, i3 - objArr.length, AYUAbz3, AYUAbz2);
                } else {
                    int length = AYUAbz2 - (i4 - objArr.length);
                    AZOQYO.A4TApA(objArr, objArr, 0, length, AYUAbz2);
                    Object[] objArr2 = this.f7843AlLFFp;
                    AZOQYO.A4TApA(objArr2, objArr2, i3, AYUAbz3, length);
                }
            } else {
                Object[] objArr3 = this.f7843AlLFFp;
                AZOQYO.A4TApA(objArr3, objArr3, size, 0, AYUAbz2);
                Object[] objArr4 = this.f7843AlLFFp;
                if (i3 >= objArr4.length) {
                    AZOQYO.A4TApA(objArr4, objArr4, i3 - objArr4.length, AYUAbz3, objArr4.length);
                } else {
                    AZOQYO.A4TApA(objArr4, objArr4, 0, objArr4.length - size, objArr4.length);
                    Object[] objArr5 = this.f7843AlLFFp;
                    AZOQYO.A4TApA(objArr5, objArr5, i3, AYUAbz3, objArr5.length - size);
                }
            }
            A5SV6n(AYUAbz3, collection);
            return true;
        }
        int i5 = this.f7842AcNBzu;
        int i6 = i5 - size;
        if (AYUAbz3 < i5) {
            Object[] objArr6 = this.f7843AlLFFp;
            AZOQYO.A4TApA(objArr6, objArr6, i6, i5, objArr6.length);
            if (size >= AYUAbz3) {
                Object[] objArr7 = this.f7843AlLFFp;
                AZOQYO.A4TApA(objArr7, objArr7, objArr7.length - size, 0, AYUAbz3);
            } else {
                Object[] objArr8 = this.f7843AlLFFp;
                AZOQYO.A4TApA(objArr8, objArr8, objArr8.length - size, 0, size);
                Object[] objArr9 = this.f7843AlLFFp;
                AZOQYO.A4TApA(objArr9, objArr9, 0, size, AYUAbz3);
            }
        } else if (i6 >= 0) {
            Object[] objArr10 = this.f7843AlLFFp;
            AZOQYO.A4TApA(objArr10, objArr10, i6, i5, AYUAbz3);
        } else {
            Object[] objArr11 = this.f7843AlLFFp;
            i6 += objArr11.length;
            int i7 = AYUAbz3 - i5;
            int length2 = objArr11.length - i6;
            if (length2 >= i7) {
                AZOQYO.A4TApA(objArr11, objArr11, i6, i5, AYUAbz3);
            } else {
                AZOQYO.A4TApA(objArr11, objArr11, i6, i5, i5 + length2);
                Object[] objArr12 = this.f7843AlLFFp;
                AZOQYO.A4TApA(objArr12, objArr12, 0, this.f7842AcNBzu + length2, AYUAbz3);
            }
        }
        this.f7842AcNBzu = i6;
        A5SV6n(ARc23Z(AYUAbz3 - size), collection);
        return true;
    }

    public final void addFirst(Object obj) {
        AZOQYO();
        ADYaiT(this.f7844AmA8tU + 1);
        int i = this.f7842AcNBzu;
        if (i == 0) {
            Object[] objArr = this.f7843AlLFFp;
            RXb0Sz.ARc23Z.AMqCpz(objArr, "<this>");
            i = objArr.length;
        }
        int i2 = i - 1;
        this.f7842AcNBzu = i2;
        this.f7843AlLFFp[i2] = obj;
        this.f7844AmA8tU++;
    }

    public final void addLast(Object obj) {
        AZOQYO();
        ADYaiT(A2egSU() + 1);
        this.f7843AlLFFp[AYUAbz(A2egSU() + this.f7842AcNBzu)] = obj;
        this.f7844AmA8tU = A2egSU() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            AZOQYO();
            ASJ6gh(this.f7842AcNBzu, AYUAbz(A2egSU() + this.f7842AcNBzu));
        }
        this.f7842AcNBzu = 0;
        this.f7844AmA8tU = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int A2egSU2 = A2egSU();
        if (i < 0 || i >= A2egSU2) {
            throw new IndexOutOfBoundsException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i, A2egSU2, "index: ", ", size: "));
        }
        return this.f7843AlLFFp[AYUAbz(this.f7842AcNBzu + i)];
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i;
        int AYUAbz2 = AYUAbz(A2egSU() + this.f7842AcNBzu);
        int i2 = this.f7842AcNBzu;
        if (i2 < AYUAbz2) {
            while (i2 < AYUAbz2) {
                if (RXb0Sz.ARc23Z.A2egSU(obj, this.f7843AlLFFp[i2])) {
                    i = this.f7842AcNBzu;
                } else {
                    i2++;
                }
            }
            return -1;
        }
        if (i2 < AYUAbz2) {
            return -1;
        }
        int length = this.f7843AlLFFp.length;
        while (true) {
            if (i2 >= length) {
                for (int i3 = 0; i3 < AYUAbz2; i3++) {
                    if (RXb0Sz.ARc23Z.A2egSU(obj, this.f7843AlLFFp[i3])) {
                        i2 = i3 + this.f7843AlLFFp.length;
                        i = this.f7842AcNBzu;
                    }
                }
                return -1;
            }
            if (RXb0Sz.ARc23Z.A2egSU(obj, this.f7843AlLFFp[i2])) {
                i = this.f7842AcNBzu;
                break;
            }
            i2++;
        }
        return i2 - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return A2egSU() == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i;
        int AYUAbz2 = AYUAbz(this.f7844AmA8tU + this.f7842AcNBzu);
        int i2 = this.f7842AcNBzu;
        if (i2 < AYUAbz2) {
            length = AYUAbz2 - 1;
            if (i2 <= length) {
                while (!RXb0Sz.ARc23Z.A2egSU(obj, this.f7843AlLFFp[length])) {
                    if (length != i2) {
                        length--;
                    }
                }
                i = this.f7842AcNBzu;
                return length - i;
            }
            return -1;
        }
        if (i2 > AYUAbz2) {
            int i3 = AYUAbz2 - 1;
            while (true) {
                if (-1 >= i3) {
                    Object[] objArr = this.f7843AlLFFp;
                    RXb0Sz.ARc23Z.AMqCpz(objArr, "<this>");
                    length = objArr.length - 1;
                    int i4 = this.f7842AcNBzu;
                    if (i4 <= length) {
                        while (!RXb0Sz.ARc23Z.A2egSU(obj, this.f7843AlLFFp[length])) {
                            if (length != i4) {
                                length--;
                            }
                        }
                        i = this.f7842AcNBzu;
                    }
                } else {
                    if (RXb0Sz.ARc23Z.A2egSU(obj, this.f7843AlLFFp[i3])) {
                        length = i3 + this.f7843AlLFFp.length;
                        i = this.f7842AcNBzu;
                        break;
                    }
                    i3--;
                }
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        A4TApA(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        int AYUAbz2;
        RXb0Sz.ARc23Z.AMqCpz(collection, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.f7843AlLFFp.length != 0) {
            int AYUAbz3 = AYUAbz(this.f7844AmA8tU + this.f7842AcNBzu);
            int i = this.f7842AcNBzu;
            if (i < AYUAbz3) {
                AYUAbz2 = i;
                while (i < AYUAbz3) {
                    Object obj = this.f7843AlLFFp[i];
                    if (collection.contains(obj)) {
                        z = true;
                    } else {
                        this.f7843AlLFFp[AYUAbz2] = obj;
                        AYUAbz2++;
                    }
                    i++;
                }
                Object[] objArr = this.f7843AlLFFp;
                RXb0Sz.ARc23Z.AMqCpz(objArr, "<this>");
                Arrays.fill(objArr, AYUAbz2, AYUAbz3, (Object) null);
            } else {
                int length = this.f7843AlLFFp.length;
                int i2 = i;
                boolean z2 = false;
                while (i < length) {
                    Object[] objArr2 = this.f7843AlLFFp;
                    Object obj2 = objArr2[i];
                    objArr2[i] = null;
                    if (collection.contains(obj2)) {
                        z2 = true;
                    } else {
                        this.f7843AlLFFp[i2] = obj2;
                        i2++;
                    }
                    i++;
                }
                AYUAbz2 = AYUAbz(i2);
                for (int i3 = 0; i3 < AYUAbz3; i3++) {
                    Object[] objArr3 = this.f7843AlLFFp;
                    Object obj3 = objArr3[i3];
                    objArr3[i3] = null;
                    if (collection.contains(obj3)) {
                        z2 = true;
                    } else {
                        this.f7843AlLFFp[AYUAbz2] = obj3;
                        AYUAbz2 = AMqCpz(AYUAbz2);
                    }
                }
                z = z2;
            }
            if (z) {
                AZOQYO();
                this.f7844AmA8tU = ARc23Z(AYUAbz2 - this.f7842AcNBzu);
            }
        }
        return z;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        AZOQYO();
        Object[] objArr = this.f7843AlLFFp;
        int i = this.f7842AcNBzu;
        Object obj = objArr[i];
        objArr[i] = null;
        this.f7842AcNBzu = AMqCpz(i);
        this.f7844AmA8tU = A2egSU() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        AZOQYO();
        int AYUAbz2 = AYUAbz(AaHO0E.ADYaiT(this) + this.f7842AcNBzu);
        Object[] objArr = this.f7843AlLFFp;
        Object obj = objArr[AYUAbz2];
        objArr[AYUAbz2] = null;
        this.f7844AmA8tU = A2egSU() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        JrXYwF.A4TApA.B7CMnp(i, i2, this.f7844AmA8tU);
        int i3 = i2 - i;
        if (i3 == 0) {
            return;
        }
        if (i3 == this.f7844AmA8tU) {
            clear();
            return;
        }
        if (i3 == 1) {
            A4TApA(i);
            return;
        }
        AZOQYO();
        if (i < this.f7844AmA8tU - i2) {
            int AYUAbz2 = AYUAbz((i - 1) + this.f7842AcNBzu);
            int AYUAbz3 = AYUAbz((i2 - 1) + this.f7842AcNBzu);
            while (i > 0) {
                int i4 = AYUAbz2 + 1;
                int min = Math.min(i, Math.min(i4, AYUAbz3 + 1));
                Object[] objArr = this.f7843AlLFFp;
                int i5 = AYUAbz3 - min;
                int i6 = AYUAbz2 - min;
                AZOQYO.A4TApA(objArr, objArr, i5 + 1, i6 + 1, i4);
                AYUAbz2 = ARc23Z(i6);
                AYUAbz3 = ARc23Z(i5);
                i -= min;
            }
            int AYUAbz4 = AYUAbz(this.f7842AcNBzu + i3);
            ASJ6gh(this.f7842AcNBzu, AYUAbz4);
            this.f7842AcNBzu = AYUAbz4;
        } else {
            int AYUAbz5 = AYUAbz(this.f7842AcNBzu + i2);
            int AYUAbz6 = AYUAbz(this.f7842AcNBzu + i);
            int i7 = this.f7844AmA8tU;
            while (true) {
                i7 -= i2;
                if (i7 <= 0) {
                    break;
                }
                Object[] objArr2 = this.f7843AlLFFp;
                i2 = Math.min(i7, Math.min(objArr2.length - AYUAbz5, objArr2.length - AYUAbz6));
                Object[] objArr3 = this.f7843AlLFFp;
                int i8 = AYUAbz5 + i2;
                AZOQYO.A4TApA(objArr3, objArr3, AYUAbz6, AYUAbz5, i8);
                AYUAbz5 = AYUAbz(i8);
                AYUAbz6 = AYUAbz(AYUAbz6 + i2);
            }
            int AYUAbz7 = AYUAbz(this.f7844AmA8tU + this.f7842AcNBzu);
            ASJ6gh(ARc23Z(AYUAbz7 - i3), AYUAbz7);
        }
        this.f7844AmA8tU -= i3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        int AYUAbz2;
        RXb0Sz.ARc23Z.AMqCpz(collection, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.f7843AlLFFp.length != 0) {
            int AYUAbz3 = AYUAbz(this.f7844AmA8tU + this.f7842AcNBzu);
            int i = this.f7842AcNBzu;
            if (i < AYUAbz3) {
                AYUAbz2 = i;
                while (i < AYUAbz3) {
                    Object obj = this.f7843AlLFFp[i];
                    if (collection.contains(obj)) {
                        this.f7843AlLFFp[AYUAbz2] = obj;
                        AYUAbz2++;
                    } else {
                        z = true;
                    }
                    i++;
                }
                Object[] objArr = this.f7843AlLFFp;
                RXb0Sz.ARc23Z.AMqCpz(objArr, "<this>");
                Arrays.fill(objArr, AYUAbz2, AYUAbz3, (Object) null);
            } else {
                int length = this.f7843AlLFFp.length;
                int i2 = i;
                boolean z2 = false;
                while (i < length) {
                    Object[] objArr2 = this.f7843AlLFFp;
                    Object obj2 = objArr2[i];
                    objArr2[i] = null;
                    if (collection.contains(obj2)) {
                        this.f7843AlLFFp[i2] = obj2;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                AYUAbz2 = AYUAbz(i2);
                for (int i3 = 0; i3 < AYUAbz3; i3++) {
                    Object[] objArr3 = this.f7843AlLFFp;
                    Object obj3 = objArr3[i3];
                    objArr3[i3] = null;
                    if (collection.contains(obj3)) {
                        this.f7843AlLFFp[AYUAbz2] = obj3;
                        AYUAbz2 = AMqCpz(AYUAbz2);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                AZOQYO();
                this.f7844AmA8tU = ARc23Z(AYUAbz2 - this.f7842AcNBzu);
            }
        }
        return z;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        int A2egSU2 = A2egSU();
        if (i < 0 || i >= A2egSU2) {
            throw new IndexOutOfBoundsException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i, A2egSU2, "index: ", ", size: "));
        }
        int AYUAbz2 = AYUAbz(this.f7842AcNBzu + i);
        Object[] objArr = this.f7843AlLFFp;
        Object obj2 = objArr[AYUAbz2];
        objArr[AYUAbz2] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[A2egSU()]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        RXb0Sz.ARc23Z.AMqCpz(objArr, "array");
        int length = objArr.length;
        int i = this.f7844AmA8tU;
        if (length < i) {
            Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), i);
            RXb0Sz.ARc23Z.A5SV6n(newInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            objArr = (Object[]) newInstance;
        }
        Object[] objArr2 = objArr;
        int AYUAbz2 = AYUAbz(this.f7844AmA8tU + this.f7842AcNBzu);
        int i2 = this.f7842AcNBzu;
        if (i2 < AYUAbz2) {
            AZOQYO.A5SV6n(this.f7843AlLFFp, objArr2, 0, i2, AYUAbz2, 2);
        } else if (!isEmpty()) {
            Object[] objArr3 = this.f7843AlLFFp;
            AZOQYO.A4TApA(objArr3, objArr2, 0, this.f7842AcNBzu, objArr3.length);
            Object[] objArr4 = this.f7843AlLFFp;
            AZOQYO.A4TApA(objArr4, objArr2, objArr4.length - this.f7842AcNBzu, 0, AYUAbz2);
        }
        int i3 = this.f7844AmA8tU;
        if (i3 < objArr2.length) {
            objArr2[i3] = null;
        }
        return objArr2;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        RXb0Sz.ARc23Z.AMqCpz(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        AZOQYO();
        ADYaiT(collection.size() + A2egSU());
        A5SV6n(AYUAbz(A2egSU() + this.f7842AcNBzu), collection);
        return true;
    }
}

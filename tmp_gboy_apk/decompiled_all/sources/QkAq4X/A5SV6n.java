package QkAq4X;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A5SV6n implements Collection, Set {

    /* renamed from: B25kr6, reason: collision with root package name */
    public static Object[] f7725B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static int f7726B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public static Object[] f7727B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public static int f7728B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public static final int[] f7729B7CMnp = new int[0];

    /* renamed from: B9tovu, reason: collision with root package name */
    public static final Object[] f7730B9tovu = new Object[0];

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int[] f7731AcNBzu = f7729B7CMnp;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Object[] f7732AlLFFp = f7730B9tovu;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f7733AmA8tU = 0;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public A2egSU f7734AzWtSf;

    static {
        VMgElGQ();
    }

    public static void ADYaiT(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (A5SV6n.class) {
                try {
                    if (f7728B4ZgIw < 10) {
                        objArr[0] = f7727B3GDIM;
                        objArr[1] = iArr;
                        while (true) {
                            i--;
                            if (i < 2) {
                                break;
                            } else {
                                objArr[i] = null;
                            }
                        }
                        f7727B3GDIM = objArr;
                        f7728B4ZgIw++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (A5SV6n.class) {
                try {
                    if (f7726B2KMhB < 10) {
                        objArr[0] = f7725B25kr6;
                        objArr[1] = iArr;
                        while (true) {
                            i--;
                            if (i < 2) {
                                break;
                            } else {
                                objArr[i] = null;
                            }
                        }
                        f7725B25kr6 = objArr;
                        f7726B2KMhB++;
                    }
                } finally {
                }
            }
        }
    }

    private static /* synthetic */ void VMgElGQ() {
        char[] charArray = "²¾¼ÿ¶°¼´ÿ³¾¨ÿ¢¹´½½ÿ\u009b¿¸\u0093£¸µ¶´".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 209);
        }
        String str = new String(charArray);
        char[] charArray2 = "²½¸¿¸¥".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 209);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final int A2egSU() {
        int i = this.f7733AmA8tU;
        if (i == 0) {
            return -1;
        }
        int A2egSU2 = ADYaiT.A2egSU(i, 0, this.f7731AcNBzu);
        if (A2egSU2 < 0 || this.f7732AlLFFp[A2egSU2] == null) {
            return A2egSU2;
        }
        int i2 = A2egSU2 + 1;
        while (i2 < i && this.f7731AcNBzu[i2] == 0) {
            if (this.f7732AlLFFp[i2] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = A2egSU2 - 1; i3 >= 0 && this.f7731AcNBzu[i3] == 0; i3--) {
            if (this.f7732AlLFFp[i3] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    public final int A4TApA(int i, Object obj) {
        int i2 = this.f7733AmA8tU;
        if (i2 == 0) {
            return -1;
        }
        int A2egSU2 = ADYaiT.A2egSU(i2, i, this.f7731AcNBzu);
        if (A2egSU2 < 0 || obj.equals(this.f7732AlLFFp[A2egSU2])) {
            return A2egSU2;
        }
        int i3 = A2egSU2 + 1;
        while (i3 < i2 && this.f7731AcNBzu[i3] == i) {
            if (obj.equals(this.f7732AlLFFp[i3])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = A2egSU2 - 1; i4 >= 0 && this.f7731AcNBzu[i4] == i; i4--) {
            if (obj.equals(this.f7732AlLFFp[i4])) {
                return i4;
            }
        }
        return ~i3;
    }

    public final int A5SV6n(Object obj) {
        return obj == null ? A2egSU() : A4TApA(obj.hashCode(), obj);
    }

    public final void AMqCpz(int i) {
        Object[] objArr = this.f7732AlLFFp;
        Object obj = objArr[i];
        int i2 = this.f7733AmA8tU;
        if (i2 <= 1) {
            ADYaiT(this.f7731AcNBzu, objArr, i2);
            this.f7731AcNBzu = f7729B7CMnp;
            this.f7732AlLFFp = f7730B9tovu;
            this.f7733AmA8tU = 0;
            return;
        }
        int[] iArr = this.f7731AcNBzu;
        if (iArr.length <= 8 || i2 >= iArr.length / 3) {
            int i3 = i2 - 1;
            this.f7733AmA8tU = i3;
            if (i < i3) {
                int i4 = i + 1;
                System.arraycopy(iArr, i4, iArr, i, i3 - i);
                Object[] objArr2 = this.f7732AlLFFp;
                System.arraycopy(objArr2, i4, objArr2, i, this.f7733AmA8tU - i);
            }
            this.f7732AlLFFp[this.f7733AmA8tU] = null;
            return;
        }
        ARc23Z(i2 > 8 ? i2 + (i2 >> 1) : 8);
        this.f7733AmA8tU--;
        if (i > 0) {
            System.arraycopy(iArr, 0, this.f7731AcNBzu, 0, i);
            System.arraycopy(objArr, 0, this.f7732AlLFFp, 0, i);
        }
        int i5 = this.f7733AmA8tU;
        if (i < i5) {
            int i6 = i + 1;
            System.arraycopy(iArr, i6, this.f7731AcNBzu, i, i5 - i);
            System.arraycopy(objArr, i6, this.f7732AlLFFp, i, this.f7733AmA8tU - i);
        }
    }

    public final void ARc23Z(int i) {
        if (i == 8) {
            synchronized (A5SV6n.class) {
                try {
                    Object[] objArr = f7727B3GDIM;
                    if (objArr != null) {
                        this.f7732AlLFFp = objArr;
                        f7727B3GDIM = (Object[]) objArr[0];
                        this.f7731AcNBzu = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f7728B4ZgIw--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i == 4) {
            synchronized (A5SV6n.class) {
                try {
                    Object[] objArr2 = f7725B25kr6;
                    if (objArr2 != null) {
                        this.f7732AlLFFp = objArr2;
                        f7725B25kr6 = (Object[]) objArr2[0];
                        this.f7731AcNBzu = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f7726B2KMhB--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f7731AcNBzu = new int[i];
        this.f7732AlLFFp = new Object[i];
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i;
        int A4TApA2;
        if (obj == null) {
            A4TApA2 = A2egSU();
            i = 0;
        } else {
            int hashCode = obj.hashCode();
            i = hashCode;
            A4TApA2 = A4TApA(hashCode, obj);
        }
        if (A4TApA2 >= 0) {
            return false;
        }
        int i2 = ~A4TApA2;
        int i3 = this.f7733AmA8tU;
        int[] iArr = this.f7731AcNBzu;
        if (i3 >= iArr.length) {
            int i4 = 8;
            if (i3 >= 8) {
                i4 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i4 = 4;
            }
            Object[] objArr = this.f7732AlLFFp;
            ARc23Z(i4);
            int[] iArr2 = this.f7731AcNBzu;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f7732AlLFFp, 0, objArr.length);
            }
            ADYaiT(iArr, objArr, this.f7733AmA8tU);
        }
        int i5 = this.f7733AmA8tU;
        if (i2 < i5) {
            int[] iArr3 = this.f7731AcNBzu;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr2 = this.f7732AlLFFp;
            System.arraycopy(objArr2, i2, objArr2, i6, this.f7733AmA8tU - i2);
        }
        this.f7731AcNBzu[i2] = i;
        this.f7732AlLFFp[i2] = obj;
        this.f7733AmA8tU++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        int size = collection.size() + this.f7733AmA8tU;
        int[] iArr = this.f7731AcNBzu;
        boolean z = false;
        if (iArr.length < size) {
            Object[] objArr = this.f7732AlLFFp;
            ARc23Z(size);
            int i = this.f7733AmA8tU;
            if (i > 0) {
                System.arraycopy(iArr, 0, this.f7731AcNBzu, 0, i);
                System.arraycopy(objArr, 0, this.f7732AlLFFp, 0, this.f7733AmA8tU);
            }
            ADYaiT(iArr, objArr, this.f7733AmA8tU);
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            z |= add(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        int i = this.f7733AmA8tU;
        if (i != 0) {
            ADYaiT(this.f7731AcNBzu, this.f7732AlLFFp, i);
            this.f7731AcNBzu = f7729B7CMnp;
            this.f7732AlLFFp = f7730B9tovu;
            this.f7733AmA8tU = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return A5SV6n(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
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
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (this.f7733AmA8tU != set.size()) {
                return false;
            }
            for (int i = 0; i < this.f7733AmA8tU; i++) {
                try {
                    if (!set.contains(this.f7732AlLFFp[i])) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.f7731AcNBzu;
        int i = this.f7733AmA8tU;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f7733AmA8tU <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        if (this.f7734AzWtSf == null) {
            this.f7734AzWtSf = new A2egSU(1, this);
        }
        A2egSU a2egSU = this.f7734AzWtSf;
        if (a2egSU.f7721A4TApA == null) {
            a2egSU.f7721A4TApA = new ASJ6gh(1, a2egSU);
        }
        return a2egSU.f7721A4TApA.iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int A5SV6n2 = A5SV6n(obj);
        if (A5SV6n2 < 0) {
            return false;
        }
        AMqCpz(A5SV6n2);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        boolean z = false;
        for (int i = this.f7733AmA8tU - 1; i >= 0; i--) {
            if (!collection.contains(this.f7732AlLFFp[i])) {
                AMqCpz(i);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this.f7733AmA8tU;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        int i = this.f7733AmA8tU;
        Object[] objArr = new Object[i];
        System.arraycopy(this.f7732AlLFFp, 0, objArr, 0, i);
        return objArr;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f7733AmA8tU * 14);
        sb.append('{');
        for (int i = 0; i < this.f7733AmA8tU; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object obj = this.f7732AlLFFp[i];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] objArr) {
        if (objArr.length < this.f7733AmA8tU) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.f7733AmA8tU);
        }
        System.arraycopy(this.f7732AlLFFp, 0, objArr, 0, this.f7733AmA8tU);
        int length = objArr.length;
        int i = this.f7733AmA8tU;
        if (length > i) {
            objArr[i] = null;
        }
        return objArr;
    }
}

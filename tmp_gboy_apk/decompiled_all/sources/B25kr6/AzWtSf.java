package B25kr6;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AzWtSf {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int[] f1009AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Object[] f1010AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f1011AmA8tU;

    public AzWtSf() {
        this(0);
    }

    public final int A2egSU(Object obj) {
        int i = this.f1011AmA8tU * 2;
        Object[] objArr = this.f1010AlLFFp;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public final void A4TApA(int i) {
        int i2 = this.f1011AmA8tU;
        int[] iArr = this.f1009AcNBzu;
        if (iArr.length < i) {
            int[] copyOf = Arrays.copyOf(iArr, i);
            RXb0Sz.ARc23Z.ADYaiT(copyOf, "copyOf(...)");
            this.f1009AcNBzu = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f1010AlLFFp, i * 2);
            RXb0Sz.ARc23Z.ADYaiT(copyOf2, "copyOf(...)");
            this.f1010AlLFFp = copyOf2;
        }
        if (this.f1011AmA8tU != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public final int A5SV6n(int i, Object obj) {
        int i2 = this.f1011AmA8tU;
        if (i2 == 0) {
            return -1;
        }
        int A2egSU2 = B2KMhB.A2egSU.A2egSU(i2, i, this.f1009AcNBzu);
        if (A2egSU2 < 0 || RXb0Sz.ARc23Z.A2egSU(obj, this.f1010AlLFFp[A2egSU2 << 1])) {
            return A2egSU2;
        }
        int i3 = A2egSU2 + 1;
        while (i3 < i2 && this.f1009AcNBzu[i3] == i) {
            if (RXb0Sz.ARc23Z.A2egSU(obj, this.f1010AlLFFp[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = A2egSU2 - 1; i4 >= 0 && this.f1009AcNBzu[i4] == i; i4--) {
            if (RXb0Sz.ARc23Z.A2egSU(obj, this.f1010AlLFFp[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    public final int ADYaiT(Object obj) {
        return obj == null ? AMqCpz() : A5SV6n(obj.hashCode(), obj);
    }

    public final int AMqCpz() {
        int i = this.f1011AmA8tU;
        if (i == 0) {
            return -1;
        }
        int A2egSU2 = B2KMhB.A2egSU.A2egSU(i, 0, this.f1009AcNBzu);
        if (A2egSU2 < 0 || this.f1010AlLFFp[A2egSU2 << 1] == null) {
            return A2egSU2;
        }
        int i2 = A2egSU2 + 1;
        while (i2 < i && this.f1009AcNBzu[i2] == 0) {
            if (this.f1010AlLFFp[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = A2egSU2 - 1; i3 >= 0 && this.f1009AcNBzu[i3] == 0; i3--) {
            if (this.f1010AlLFFp[i3 << 1] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    public final Object ARc23Z(int i) {
        boolean z = false;
        if (i >= 0 && i < this.f1011AmA8tU) {
            z = true;
        }
        if (z) {
            return this.f1010AlLFFp[i << 1];
        }
        B2KMhB.A2egSU.A5SV6n("Expected index to be within 0..size()-1, but was " + i);
        throw null;
    }

    public void ASJ6gh(ADYaiT aDYaiT) {
        RXb0Sz.ARc23Z.AMqCpz(aDYaiT, "map");
        int i = aDYaiT.f1011AmA8tU;
        A4TApA(this.f1011AmA8tU + i);
        if (this.f1011AmA8tU != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(aDYaiT.ARc23Z(i2), aDYaiT.AZkASS(i2));
            }
        } else if (i > 0) {
            RD2OKB.AZOQYO.A2egSU(0, 0, aDYaiT.f1009AcNBzu, this.f1009AcNBzu, i);
            RD2OKB.AZOQYO.A4TApA(aDYaiT.f1010AlLFFp, this.f1010AlLFFp, 0, 0, i << 1);
            this.f1011AmA8tU = i;
        }
    }

    public Object AYUAbz(int i) {
        if (!(i >= 0 && i < this.f1011AmA8tU)) {
            B2KMhB.A2egSU.A5SV6n("Expected index to be within 0..size()-1, but was " + i);
            throw null;
        }
        Object[] objArr = this.f1010AlLFFp;
        int i2 = i << 1;
        Object obj = objArr[i2 + 1];
        int i3 = this.f1011AmA8tU;
        if (i3 <= 1) {
            clear();
            return obj;
        }
        int i4 = i3 - 1;
        int[] iArr = this.f1009AcNBzu;
        if (iArr.length <= 8 || i3 >= iArr.length / 3) {
            if (i < i4) {
                int i5 = i + 1;
                RD2OKB.AZOQYO.A2egSU(i, i5, iArr, iArr, i3);
                Object[] objArr2 = this.f1010AlLFFp;
                RD2OKB.AZOQYO.A4TApA(objArr2, objArr2, i2, i5 << 1, i3 << 1);
            }
            Object[] objArr3 = this.f1010AlLFFp;
            int i6 = i4 << 1;
            objArr3[i6] = null;
            objArr3[i6 + 1] = null;
        } else {
            int i7 = i3 > 8 ? i3 + (i3 >> 1) : 8;
            int[] copyOf = Arrays.copyOf(iArr, i7);
            RXb0Sz.ARc23Z.ADYaiT(copyOf, "copyOf(...)");
            this.f1009AcNBzu = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f1010AlLFFp, i7 << 1);
            RXb0Sz.ARc23Z.ADYaiT(copyOf2, "copyOf(...)");
            this.f1010AlLFFp = copyOf2;
            if (i3 != this.f1011AmA8tU) {
                throw new ConcurrentModificationException();
            }
            if (i > 0) {
                RD2OKB.AZOQYO.A2egSU(0, 0, iArr, this.f1009AcNBzu, i);
                RD2OKB.AZOQYO.A4TApA(objArr, this.f1010AlLFFp, 0, 0, i2);
            }
            if (i < i4) {
                int i8 = i + 1;
                RD2OKB.AZOQYO.A2egSU(i, i8, iArr, this.f1009AcNBzu, i3);
                RD2OKB.AZOQYO.A4TApA(objArr, this.f1010AlLFFp, i2, i8 << 1, i3 << 1);
            }
        }
        if (i3 != this.f1011AmA8tU) {
            throw new ConcurrentModificationException();
        }
        this.f1011AmA8tU = i4;
        return obj;
    }

    public Object AZOQYO(int i, Object obj) {
        boolean z = false;
        if (i >= 0 && i < this.f1011AmA8tU) {
            z = true;
        }
        if (!z) {
            B2KMhB.A2egSU.A5SV6n("Expected index to be within 0..size()-1, but was " + i);
            throw null;
        }
        int i2 = (i << 1) + 1;
        Object[] objArr = this.f1010AlLFFp;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }

    public final Object AZkASS(int i) {
        boolean z = false;
        if (i >= 0 && i < this.f1011AmA8tU) {
            z = true;
        }
        if (z) {
            return this.f1010AlLFFp[(i << 1) + 1];
        }
        B2KMhB.A2egSU.A5SV6n("Expected index to be within 0..size()-1, but was " + i);
        throw null;
    }

    public void clear() {
        if (this.f1011AmA8tU > 0) {
            this.f1009AcNBzu = B2KMhB.A2egSU.f1016A2egSU;
            this.f1010AlLFFp = B2KMhB.A2egSU.f1017A4TApA;
            this.f1011AmA8tU = 0;
        }
        if (this.f1011AmA8tU > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return ADYaiT(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return A2egSU(obj) >= 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof AzWtSf) {
                int i = this.f1011AmA8tU;
                if (i != ((AzWtSf) obj).f1011AmA8tU) {
                    return false;
                }
                AzWtSf azWtSf = (AzWtSf) obj;
                for (int i2 = 0; i2 < i; i2++) {
                    Object ARc23Z2 = ARc23Z(i2);
                    Object AZkASS2 = AZkASS(i2);
                    Object obj2 = azWtSf.get(ARc23Z2);
                    if (AZkASS2 == null) {
                        if (obj2 != null || !azWtSf.containsKey(ARc23Z2)) {
                            return false;
                        }
                    } else if (!AZkASS2.equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || this.f1011AmA8tU != ((Map) obj).size()) {
                return false;
            }
            int i3 = this.f1011AmA8tU;
            for (int i4 = 0; i4 < i3; i4++) {
                Object ARc23Z3 = ARc23Z(i4);
                Object AZkASS3 = AZkASS(i4);
                Object obj3 = ((Map) obj).get(ARc23Z3);
                if (AZkASS3 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(ARc23Z3)) {
                        return false;
                    }
                } else if (!AZkASS3.equals(obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public Object get(Object obj) {
        int ADYaiT2 = ADYaiT(obj);
        if (ADYaiT2 >= 0) {
            return this.f1010AlLFFp[(ADYaiT2 << 1) + 1];
        }
        return null;
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        int ADYaiT2 = ADYaiT(obj);
        return ADYaiT2 >= 0 ? this.f1010AlLFFp[(ADYaiT2 << 1) + 1] : obj2;
    }

    public int hashCode() {
        int[] iArr = this.f1009AcNBzu;
        Object[] objArr = this.f1010AlLFFp;
        int i = this.f1011AmA8tU;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj != null ? obj.hashCode() : 0) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public final boolean isEmpty() {
        return this.f1011AmA8tU <= 0;
    }

    public Object put(Object obj, Object obj2) {
        int i = this.f1011AmA8tU;
        int hashCode = obj != null ? obj.hashCode() : 0;
        int A5SV6n2 = obj != null ? A5SV6n(hashCode, obj) : AMqCpz();
        if (A5SV6n2 >= 0) {
            int i2 = (A5SV6n2 << 1) + 1;
            Object[] objArr = this.f1010AlLFFp;
            Object obj3 = objArr[i2];
            objArr[i2] = obj2;
            return obj3;
        }
        int i3 = ~A5SV6n2;
        int[] iArr = this.f1009AcNBzu;
        if (i >= iArr.length) {
            int i4 = 8;
            if (i >= 8) {
                i4 = (i >> 1) + i;
            } else if (i < 4) {
                i4 = 4;
            }
            int[] copyOf = Arrays.copyOf(iArr, i4);
            RXb0Sz.ARc23Z.ADYaiT(copyOf, "copyOf(...)");
            this.f1009AcNBzu = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f1010AlLFFp, i4 << 1);
            RXb0Sz.ARc23Z.ADYaiT(copyOf2, "copyOf(...)");
            this.f1010AlLFFp = copyOf2;
            if (i != this.f1011AmA8tU) {
                throw new ConcurrentModificationException();
            }
        }
        if (i3 < i) {
            int[] iArr2 = this.f1009AcNBzu;
            int i5 = i3 + 1;
            RD2OKB.AZOQYO.A2egSU(i5, i3, iArr2, iArr2, i);
            Object[] objArr2 = this.f1010AlLFFp;
            RD2OKB.AZOQYO.A4TApA(objArr2, objArr2, i5 << 1, i3 << 1, this.f1011AmA8tU << 1);
        }
        int i6 = this.f1011AmA8tU;
        if (i == i6) {
            int[] iArr3 = this.f1009AcNBzu;
            if (i3 < iArr3.length) {
                iArr3[i3] = hashCode;
                Object[] objArr3 = this.f1010AlLFFp;
                int i7 = i3 << 1;
                objArr3[i7] = obj;
                objArr3[i7 + 1] = obj2;
                this.f1011AmA8tU = i6 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    public Object remove(Object obj) {
        int ADYaiT2 = ADYaiT(obj);
        if (ADYaiT2 >= 0) {
            return AYUAbz(ADYaiT2);
        }
        return null;
    }

    public final Object replace(Object obj, Object obj2) {
        int ADYaiT2 = ADYaiT(obj);
        if (ADYaiT2 >= 0) {
            return AZOQYO(ADYaiT2, obj2);
        }
        return null;
    }

    public final int size() {
        return this.f1011AmA8tU;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1011AmA8tU * 28);
        sb.append('{');
        int i = this.f1011AmA8tU;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object ARc23Z2 = ARc23Z(i2);
            if (ARc23Z2 != sb) {
                sb.append(ARc23Z2);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object AZkASS2 = AZkASS(i2);
            if (AZkASS2 != sb) {
                sb.append(AZkASS2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        RXb0Sz.ARc23Z.ADYaiT(sb2, "toString(...)");
        return sb2;
    }

    public AzWtSf(int i) {
        this.f1009AcNBzu = i == 0 ? B2KMhB.A2egSU.f1016A2egSU : new int[i];
        this.f1010AlLFFp = i == 0 ? B2KMhB.A2egSU.f1017A4TApA : new Object[i << 1];
    }

    public final boolean remove(Object obj, Object obj2) {
        int ADYaiT2 = ADYaiT(obj);
        if (ADYaiT2 < 0 || !RXb0Sz.ARc23Z.A2egSU(obj2, AZkASS(ADYaiT2))) {
            return false;
        }
        AYUAbz(ADYaiT2);
        return true;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int ADYaiT2 = ADYaiT(obj);
        if (ADYaiT2 < 0 || !RXb0Sz.ARc23Z.A2egSU(obj2, AZkASS(ADYaiT2))) {
            return false;
        }
        AZOQYO(ADYaiT2, obj3);
        return true;
    }
}

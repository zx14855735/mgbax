package QkAq4X;

import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AYUAbz {

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static Object[] f7746AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public static int f7747B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static Object[] f7748B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public static int f7749B3GDIM;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int[] f7750AcNBzu = ADYaiT.f7735A2egSU;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Object[] f7751AlLFFp = ADYaiT.f7736A4TApA;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f7752AmA8tU = 0;

    public static void ADYaiT(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (A4TApA.class) {
                try {
                    if (f7749B3GDIM < 10) {
                        objArr[0] = f7748B2KMhB;
                        objArr[1] = iArr;
                        for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                            objArr[i2] = null;
                        }
                        f7748B2KMhB = objArr;
                        f7749B3GDIM++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (A4TApA.class) {
                try {
                    if (f7747B25kr6 < 10) {
                        objArr[0] = f7746AzWtSf;
                        objArr[1] = iArr;
                        for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        f7746AzWtSf = objArr;
                        f7747B25kr6++;
                    }
                } finally {
                }
            }
        }
    }

    public final int A2egSU() {
        int i = this.f7752AmA8tU;
        if (i == 0) {
            return -1;
        }
        int A2egSU2 = ADYaiT.A2egSU(i, 0, this.f7750AcNBzu);
        if (A2egSU2 < 0 || this.f7751AlLFFp[A2egSU2 << 1] == null) {
            return A2egSU2;
        }
        int i2 = A2egSU2 + 1;
        while (i2 < i && this.f7750AcNBzu[i2] == 0) {
            if (this.f7751AlLFFp[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = A2egSU2 - 1; i3 >= 0 && this.f7750AcNBzu[i3] == 0; i3--) {
            if (this.f7751AlLFFp[i3 << 1] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    public final int A4TApA(int i, Object obj) {
        int i2 = this.f7752AmA8tU;
        if (i2 == 0) {
            return -1;
        }
        int A2egSU2 = ADYaiT.A2egSU(i2, i, this.f7750AcNBzu);
        if (A2egSU2 < 0 || obj.equals(this.f7751AlLFFp[A2egSU2 << 1])) {
            return A2egSU2;
        }
        int i3 = A2egSU2 + 1;
        while (i3 < i2 && this.f7750AcNBzu[i3] == i) {
            if (obj.equals(this.f7751AlLFFp[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = A2egSU2 - 1; i4 >= 0 && this.f7750AcNBzu[i4] == i; i4--) {
            if (obj.equals(this.f7751AlLFFp[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    public final void A5SV6n(int i) {
        int[] iArr = this.f7750AcNBzu;
        if (iArr.length < i) {
            Object[] objArr = this.f7751AlLFFp;
            AYUAbz(i);
            int i2 = this.f7752AmA8tU;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.f7750AcNBzu, 0, i2);
                System.arraycopy(objArr, 0, this.f7751AlLFFp, 0, this.f7752AmA8tU << 1);
            }
            ADYaiT(iArr, objArr, this.f7752AmA8tU);
        }
    }

    public final int AMqCpz(Object obj) {
        int i = this.f7752AmA8tU * 2;
        Object[] objArr = this.f7751AlLFFp;
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

    public final Object ARc23Z(int i) {
        return this.f7751AlLFFp[(i << 1) + 1];
    }

    public final Object ASJ6gh(int i) {
        Object[] objArr = this.f7751AlLFFp;
        int i2 = i << 1;
        Object obj = objArr[i2 + 1];
        int i3 = this.f7752AmA8tU;
        if (i3 <= 1) {
            ADYaiT(this.f7750AcNBzu, objArr, i3);
            this.f7750AcNBzu = ADYaiT.f7735A2egSU;
            this.f7751AlLFFp = ADYaiT.f7736A4TApA;
            this.f7752AmA8tU = 0;
            return obj;
        }
        int[] iArr = this.f7750AcNBzu;
        if (iArr.length > 8 && i3 < iArr.length / 3) {
            AYUAbz(i3 > 8 ? i3 + (i3 >> 1) : 8);
            this.f7752AmA8tU--;
            if (i > 0) {
                System.arraycopy(iArr, 0, this.f7750AcNBzu, 0, i);
                System.arraycopy(objArr, 0, this.f7751AlLFFp, 0, i2);
            }
            int i4 = this.f7752AmA8tU;
            if (i < i4) {
                int i5 = i + 1;
                System.arraycopy(iArr, i5, this.f7750AcNBzu, i, i4 - i);
                System.arraycopy(objArr, i5 << 1, this.f7751AlLFFp, i2, (this.f7752AmA8tU - i) << 1);
            }
            return obj;
        }
        int i6 = i3 - 1;
        this.f7752AmA8tU = i6;
        if (i < i6) {
            int i7 = i + 1;
            System.arraycopy(iArr, i7, iArr, i, i6 - i);
            Object[] objArr2 = this.f7751AlLFFp;
            System.arraycopy(objArr2, i7 << 1, objArr2, i2, (this.f7752AmA8tU - i) << 1);
        }
        Object[] objArr3 = this.f7751AlLFFp;
        int i8 = this.f7752AmA8tU;
        objArr3[i8 << 1] = null;
        objArr3[(i8 << 1) + 1] = null;
        return obj;
    }

    public final void AYUAbz(int i) {
        if (i == 8) {
            synchronized (A4TApA.class) {
                try {
                    Object[] objArr = f7748B2KMhB;
                    if (objArr != null) {
                        this.f7751AlLFFp = objArr;
                        f7748B2KMhB = (Object[]) objArr[0];
                        this.f7750AcNBzu = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f7749B3GDIM--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i == 4) {
            synchronized (A4TApA.class) {
                try {
                    Object[] objArr2 = f7746AzWtSf;
                    if (objArr2 != null) {
                        this.f7751AlLFFp = objArr2;
                        f7746AzWtSf = (Object[]) objArr2[0];
                        this.f7750AcNBzu = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        f7747B25kr6--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.f7750AcNBzu = new int[i];
        this.f7751AlLFFp = new Object[i << 1];
    }

    public final void clear() {
        int i = this.f7752AmA8tU;
        if (i != 0) {
            ADYaiT(this.f7750AcNBzu, this.f7751AlLFFp, i);
            this.f7750AcNBzu = ADYaiT.f7735A2egSU;
            this.f7751AlLFFp = ADYaiT.f7736A4TApA;
            this.f7752AmA8tU = 0;
        }
    }

    public final boolean containsKey(Object obj) {
        return (obj == null ? A2egSU() : A4TApA(obj.hashCode(), obj)) >= 0;
    }

    public final boolean containsValue(Object obj) {
        return AMqCpz(obj) >= 0;
    }

    public final boolean equals(Object obj) {
        int i;
        int i2;
        if (this == obj) {
            return true;
        }
        if (obj instanceof AYUAbz) {
            AYUAbz aYUAbz = (AYUAbz) obj;
            if (this.f7752AmA8tU == aYUAbz.f7752AmA8tU) {
                while (i2 < this.f7752AmA8tU) {
                    Object obj2 = this.f7751AlLFFp[i2 << 1];
                    Object ARc23Z2 = ARc23Z(i2);
                    Object obj3 = aYUAbz.get(obj2);
                    if (ARc23Z2 == null) {
                        i2 = (obj3 == null && aYUAbz.containsKey(obj2)) ? i2 + 1 : 0;
                    } else if (ARc23Z2.equals(obj3)) {
                    }
                }
                return true;
            }
            return false;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this.f7752AmA8tU == map.size()) {
                while (i < this.f7752AmA8tU) {
                    Object obj4 = this.f7751AlLFFp[i << 1];
                    Object ARc23Z3 = ARc23Z(i);
                    Object obj5 = map.get(obj4);
                    if (ARc23Z3 == null) {
                        i = (obj5 == null && map.containsKey(obj4)) ? i + 1 : 0;
                    } else if (ARc23Z3.equals(obj5)) {
                    }
                }
                return true;
            }
        }
        return false;
        return false;
    }

    public final Object get(Object obj) {
        int A2egSU2 = obj == null ? A2egSU() : A4TApA(obj.hashCode(), obj);
        if (A2egSU2 >= 0) {
            return this.f7751AlLFFp[(A2egSU2 << 1) + 1];
        }
        return null;
    }

    public final int hashCode() {
        int[] iArr = this.f7750AcNBzu;
        Object[] objArr = this.f7751AlLFFp;
        int i = this.f7752AmA8tU;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            int i5 = iArr[i3];
            i3++;
            i2 += 2;
            i4 += (obj == null ? 0 : obj.hashCode()) ^ i5;
        }
        return i4;
    }

    public final boolean isEmpty() {
        return this.f7752AmA8tU <= 0;
    }

    public final Object put(Object obj, Object obj2) {
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
            int i2 = (A4TApA2 << 1) + 1;
            Object[] objArr = this.f7751AlLFFp;
            Object obj3 = objArr[i2];
            objArr[i2] = obj2;
            return obj3;
        }
        int i3 = ~A4TApA2;
        int i4 = this.f7752AmA8tU;
        int[] iArr = this.f7750AcNBzu;
        if (i4 >= iArr.length) {
            int i5 = 8;
            if (i4 >= 8) {
                i5 = (i4 >> 1) + i4;
            } else if (i4 < 4) {
                i5 = 4;
            }
            Object[] objArr2 = this.f7751AlLFFp;
            AYUAbz(i5);
            int[] iArr2 = this.f7750AcNBzu;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f7751AlLFFp, 0, objArr2.length);
            }
            ADYaiT(iArr, objArr2, this.f7752AmA8tU);
        }
        int i6 = this.f7752AmA8tU;
        if (i3 < i6) {
            int[] iArr3 = this.f7750AcNBzu;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr3 = this.f7751AlLFFp;
            System.arraycopy(objArr3, i3 << 1, objArr3, i7 << 1, (this.f7752AmA8tU - i3) << 1);
        }
        this.f7750AcNBzu[i3] = i;
        Object[] objArr4 = this.f7751AlLFFp;
        int i8 = i3 << 1;
        objArr4[i8] = obj;
        objArr4[i8 + 1] = obj2;
        this.f7752AmA8tU++;
        return null;
    }

    public final Object remove(Object obj) {
        int A2egSU2 = obj == null ? A2egSU() : A4TApA(obj.hashCode(), obj);
        if (A2egSU2 >= 0) {
            return ASJ6gh(A2egSU2);
        }
        return null;
    }

    public final int size() {
        return this.f7752AmA8tU;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f7752AmA8tU * 28);
        sb.append('{');
        for (int i = 0; i < this.f7752AmA8tU; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object obj = this.f7751AlLFFp[i << 1];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object ARc23Z2 = ARc23Z(i);
            if (ARc23Z2 != this) {
                sb.append(ARc23Z2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}

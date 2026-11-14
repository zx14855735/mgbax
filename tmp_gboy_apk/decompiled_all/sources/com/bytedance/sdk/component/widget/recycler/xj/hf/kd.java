package com.bytedance.sdk.component.widget.recycler.xj.hf;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd<K, V> {
    static int hf;
    static int u;
    static Object[] w;
    static Object[] xj;
    int[] kd = hf.xj;
    Object[] y = hf.w;
    int c = 0;

    private void u(int i) {
        if (i == 8) {
            synchronized (xj.class) {
                try {
                    Object[] objArr = w;
                    if (objArr != null) {
                        this.y = objArr;
                        w = (Object[]) objArr[0];
                        this.kd = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        u--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i == 4) {
            synchronized (xj.class) {
                try {
                    Object[] objArr2 = xj;
                    if (objArr2 != null) {
                        this.y = objArr2;
                        xj = (Object[]) objArr2[0];
                        this.kd = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        hf--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.kd = new int[i];
        this.y = new Object[i << 1];
    }

    private static int xj(int[] iArr, int i, int i2) {
        try {
            return hf.xj(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i = this.c;
        if (i > 0) {
            int[] iArr = this.kd;
            Object[] objArr = this.y;
            this.kd = hf.xj;
            this.y = hf.w;
            this.c = 0;
            xj(iArr, objArr, i);
        }
        if (this.c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return xj(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return hf(obj) >= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof kd) {
            kd kdVar = (kd) obj;
            if (size() != kdVar.size()) {
                return false;
            }
            for (int i = 0; i < this.c; i++) {
                try {
                    K xj2 = xj(i);
                    V hf2 = hf(i);
                    Object obj2 = kdVar.get(xj2);
                    if (hf2 == null) {
                        if (obj2 != null || !kdVar.containsKey(xj2)) {
                            return false;
                        }
                    } else if (!hf2.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.c; i2++) {
            try {
                K xj3 = xj(i2);
                V hf3 = hf(i2);
                Object obj3 = map.get(xj3);
                if (hf3 == null) {
                    if (obj3 != null || !map.containsKey(xj3)) {
                        return false;
                    }
                } else if (!hf3.equals(obj3)) {
                    return false;
                }
            } catch (ClassCastException | NullPointerException unused2) {
                return false;
            }
        }
        return true;
    }

    public V get(Object obj) {
        int xj2 = xj(obj);
        if (xj2 >= 0) {
            return (V) this.y[(xj2 << 1) + 1];
        }
        return null;
    }

    public int hashCode() {
        int[] iArr = this.kd;
        Object[] objArr = this.y;
        int i = this.c;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public int hf(Object obj) {
        int i = this.c * 2;
        Object[] objArr = this.y;
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

    public boolean isEmpty() {
        return this.c <= 0;
    }

    public V put(K k, V v) {
        int i;
        int xj2;
        int i2 = this.c;
        if (k == null) {
            xj2 = xj();
            i = 0;
        } else {
            int hashCode = k.hashCode();
            i = hashCode;
            xj2 = xj(k, hashCode);
        }
        if (xj2 >= 0) {
            int i3 = (xj2 << 1) + 1;
            Object[] objArr = this.y;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
        int i4 = ~xj2;
        int[] iArr = this.kd;
        if (i2 >= iArr.length) {
            int i5 = 8;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 < 4) {
                i5 = 4;
            }
            Object[] objArr2 = this.y;
            u(i5);
            if (i2 != this.c) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.kd;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.y, 0, objArr2.length);
            }
            xj(iArr, objArr2, i2);
        }
        if (i4 < i2) {
            int[] iArr3 = this.kd;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.y;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.c - i4) << 1);
        }
        int i7 = this.c;
        if (i2 == i7) {
            int[] iArr4 = this.kd;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.y;
                int i8 = i4 << 1;
                objArr4[i8] = k;
                objArr4[i8 + 1] = v;
                this.c = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V remove(Object obj) {
        int xj2 = xj(obj);
        if (xj2 >= 0) {
            return w(xj2);
        }
        return null;
    }

    public int size() {
        return this.c;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.c * 28);
        sb.append('{');
        for (int i = 0; i < this.c; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K xj2 = xj(i);
            if (xj2 != this) {
                sb.append(xj2);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V hf2 = hf(i);
            if (hf2 != this) {
                sb.append(hf2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public V w(int i) {
        Object[] objArr = this.y;
        int i2 = i << 1;
        V v = (V) objArr[i2 + 1];
        int i3 = this.c;
        int i4 = 0;
        if (i3 <= 1) {
            xj(this.kd, objArr, i3);
            this.kd = hf.xj;
            this.y = hf.w;
        } else {
            int i5 = i3 - 1;
            int[] iArr = this.kd;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                if (i < i5) {
                    int i6 = i + 1;
                    int i7 = i5 - i;
                    System.arraycopy(iArr, i6, iArr, i, i7);
                    Object[] objArr2 = this.y;
                    System.arraycopy(objArr2, i6 << 1, objArr2, i2, i7 << 1);
                }
                Object[] objArr3 = this.y;
                int i8 = i5 << 1;
                objArr3[i8] = null;
                objArr3[i8 + 1] = null;
            } else {
                u(i3 > 8 ? i3 + (i3 >> 1) : 8);
                if (i3 != this.c) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.kd, 0, i);
                    System.arraycopy(objArr, 0, this.y, 0, i2);
                }
                if (i < i5) {
                    int i9 = i + 1;
                    int i10 = i5 - i;
                    System.arraycopy(iArr, i9, this.kd, i, i10);
                    System.arraycopy(objArr, i9 << 1, this.y, i2, i10 << 1);
                }
            }
            i4 = i5;
        }
        if (i3 != this.c) {
            throw new ConcurrentModificationException();
        }
        this.c = i4;
        return v;
    }

    public int xj(Object obj, int i) {
        int i2 = this.c;
        if (i2 == 0) {
            return -1;
        }
        int xj2 = xj(this.kd, i2, i);
        if (xj2 < 0 || obj.equals(this.y[xj2 << 1])) {
            return xj2;
        }
        int i3 = xj2 + 1;
        while (i3 < i2 && this.kd[i3] == i) {
            if (obj.equals(this.y[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = xj2 - 1; i4 >= 0 && this.kd[i4] == i; i4--) {
            if (obj.equals(this.y[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    public V hf(int i) {
        return (V) this.y[(i << 1) + 1];
    }

    public int xj() {
        int i = this.c;
        if (i == 0) {
            return -1;
        }
        int xj2 = xj(this.kd, i, 0);
        if (xj2 < 0 || this.y[xj2 << 1] == null) {
            return xj2;
        }
        int i2 = xj2 + 1;
        while (i2 < i && this.kd[i2] == 0) {
            if (this.y[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = xj2 - 1; i3 >= 0 && this.kd[i3] == 0; i3--) {
            if (this.y[i3 << 1] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    private static void xj(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (xj.class) {
                try {
                    if (u < 10) {
                        objArr[0] = w;
                        objArr[1] = iArr;
                        for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                            objArr[i2] = null;
                        }
                        w = objArr;
                        u++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (xj.class) {
                try {
                    if (hf < 10) {
                        objArr[0] = xj;
                        objArr[1] = iArr;
                        for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        xj = objArr;
                        hf++;
                    }
                } finally {
                }
            }
        }
    }

    public int xj(Object obj) {
        return obj == null ? xj() : xj(obj, obj.hashCode());
    }

    public K xj(int i) {
        return (K) this.y[i << 1];
    }
}

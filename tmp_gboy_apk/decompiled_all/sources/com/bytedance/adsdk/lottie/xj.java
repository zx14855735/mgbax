package com.bytedance.adsdk.lottie;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class xj<E> implements Collection<E>, Set<E> {
    private static Object[] c;
    private static int f;
    private static Object[] kd;
    private static int y;
    private int[] d;
    int hf;
    private qt<E, E> tf;
    Object[] xj;
    private static final int[] w = new int[0];
    private static final Object[] u = new Object[0];

    static {
        Elnvy();
    }

    public xj() {
        this(0);
    }

    private static /* synthetic */ void Elnvy() {
        char[] charArray = "¹µ·ô½»·¿ô¸µ£ô©²¿¶¶ô\u0090´³\u0098¨³¾½¿".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 218);
        }
        String str = new String(charArray);
        char[] charArray2 = "¹¶³´³®".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 218);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void u(int i) {
        if (i == 8) {
            synchronized (xj.class) {
                try {
                    Object[] objArr = c;
                    if (objArr != null) {
                        this.xj = objArr;
                        c = (Object[]) objArr[0];
                        this.d = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        f--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i == 4) {
            synchronized (xj.class) {
                try {
                    Object[] objArr2 = kd;
                    if (objArr2 != null) {
                        this.xj = objArr2;
                        kd = (Object[]) objArr2[0];
                        this.d = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        y--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.d = new int[i];
        this.xj = new Object[i];
    }

    private int xj(Object obj, int i) {
        int i2 = this.hf;
        if (i2 == 0) {
            return -1;
        }
        int xj = hf.xj(this.d, i2, i);
        if (xj < 0 || obj.equals(this.xj[xj])) {
            return xj;
        }
        int i3 = xj + 1;
        while (i3 < i2 && this.d[i3] == i) {
            if (obj.equals(this.xj[i3])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = xj - 1; i4 >= 0 && this.d[i4] == i; i4--) {
            if (obj.equals(this.xj[i4])) {
                return i4;
            }
        }
        return ~i3;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int i;
        int xj;
        if (e == null) {
            xj = xj();
            i = 0;
        } else {
            int hashCode = e.hashCode();
            i = hashCode;
            xj = xj(e, hashCode);
        }
        if (xj >= 0) {
            return false;
        }
        int i2 = ~xj;
        int i3 = this.hf;
        int[] iArr = this.d;
        if (i3 >= iArr.length) {
            int i4 = 8;
            if (i3 >= 8) {
                i4 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i4 = 4;
            }
            Object[] objArr = this.xj;
            u(i4);
            int[] iArr2 = this.d;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.xj, 0, objArr.length);
            }
            xj(iArr, objArr, this.hf);
        }
        int i5 = this.hf;
        if (i2 < i5) {
            int[] iArr3 = this.d;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr2 = this.xj;
            System.arraycopy(objArr2, i2, objArr2, i6, this.hf - i2);
        }
        this.d[i2] = i;
        this.xj[i2] = e;
        this.hf++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        xj(collection.size() + this.hf);
        Iterator<? extends E> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= add(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i = this.hf;
        if (i != 0) {
            xj(this.d, this.xj, i);
            this.d = w;
            this.xj = u;
            this.hf = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return xj(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i = 0; i < this.hf; i++) {
                try {
                    if (!set.contains(hf(i))) {
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
    public int hashCode() {
        int[] iArr = this.d;
        int i = this.hf;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public E hf(int i) {
        return (E) this.xj[i];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.hf <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return hf().u().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int xj = xj(obj);
        if (xj < 0) {
            return false;
        }
        w(xj);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.hf - 1; i >= 0; i--) {
            if (!collection.contains(this.xj[i])) {
                w(i);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.hf;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i = this.hf;
        Object[] objArr = new Object[i];
        System.arraycopy(this.xj, 0, objArr, 0, i);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.hf * 14);
        sb.append('{');
        for (int i = 0; i < this.hf; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            E hf = hf(i);
            if (hf != this) {
                sb.append(hf);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public E w(int i) {
        Object[] objArr = this.xj;
        E e = (E) objArr[i];
        int i2 = this.hf;
        if (i2 <= 1) {
            xj(this.d, objArr, i2);
            this.d = w;
            this.xj = u;
            this.hf = 0;
            return e;
        }
        int[] iArr = this.d;
        if (iArr.length <= 8 || i2 >= iArr.length / 3) {
            int i3 = i2 - 1;
            this.hf = i3;
            if (i < i3) {
                int i4 = i + 1;
                System.arraycopy(iArr, i4, iArr, i, i3 - i);
                Object[] objArr2 = this.xj;
                System.arraycopy(objArr2, i4, objArr2, i, this.hf - i);
            }
            this.xj[this.hf] = null;
            return e;
        }
        u(i2 > 8 ? i2 + (i2 >> 1) : 8);
        this.hf--;
        if (i > 0) {
            System.arraycopy(iArr, 0, this.d, 0, i);
            System.arraycopy(objArr, 0, this.xj, 0, i);
        }
        int i5 = this.hf;
        if (i < i5) {
            int i6 = i + 1;
            System.arraycopy(iArr, i6, this.d, i, i5 - i);
            System.arraycopy(objArr, i6, this.xj, i, this.hf - i);
        }
        return e;
    }

    public xj(int i) {
        if (i == 0) {
            this.d = w;
            this.xj = u;
        } else {
            u(i);
        }
        this.hf = 0;
    }

    private qt<E, E> hf() {
        if (this.tf == null) {
            this.tf = new qt<E, E>() { // from class: com.bytedance.adsdk.lottie.xj.1
                @Override // com.bytedance.adsdk.lottie.qt
                public Map<E, E> hf() {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // com.bytedance.adsdk.lottie.qt
                public void w() {
                    xj.this.clear();
                }

                @Override // com.bytedance.adsdk.lottie.qt
                public int xj() {
                    return xj.this.hf;
                }

                @Override // com.bytedance.adsdk.lottie.qt
                public Object xj(int i, int i2) {
                    return xj.this.xj[i];
                }

                @Override // com.bytedance.adsdk.lottie.qt
                public int xj(Object obj) {
                    return xj.this.xj(obj);
                }

                @Override // com.bytedance.adsdk.lottie.qt
                public void xj(int i) {
                    xj.this.w(i);
                }
            };
        }
        return this.tf;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.hf) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.hf));
        }
        System.arraycopy(this.xj, 0, tArr, 0, this.hf);
        int length = tArr.length;
        int i = this.hf;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
    }

    private int xj() {
        int i = this.hf;
        if (i == 0) {
            return -1;
        }
        int xj = hf.xj(this.d, i, 0);
        if (xj < 0 || this.xj[xj] == null) {
            return xj;
        }
        int i2 = xj + 1;
        while (i2 < i && this.d[i2] == 0) {
            if (this.xj[i2] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = xj - 1; i3 >= 0 && this.d[i3] == 0; i3--) {
            if (this.xj[i3] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    private static void xj(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (xj.class) {
                try {
                    if (f < 10) {
                        objArr[0] = c;
                        objArr[1] = iArr;
                        for (int i2 = i - 1; i2 >= 2; i2--) {
                            objArr[i2] = null;
                        }
                        c = objArr;
                        f++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (xj.class) {
                try {
                    if (y < 10) {
                        objArr[0] = kd;
                        objArr[1] = iArr;
                        for (int i3 = i - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        kd = objArr;
                        y++;
                    }
                } finally {
                }
            }
        }
    }

    public void xj(int i) {
        int[] iArr = this.d;
        if (iArr.length < i) {
            Object[] objArr = this.xj;
            u(i);
            int i2 = this.hf;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.d, 0, i2);
                System.arraycopy(objArr, 0, this.xj, 0, this.hf);
            }
            xj(iArr, objArr, this.hf);
        }
    }

    public int xj(Object obj) {
        return obj == null ? xj() : xj(obj, obj.hashCode());
    }
}

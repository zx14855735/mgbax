package com.bytedance.sdk.component.widget.recycler.xj.hf;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w<E> implements Cloneable {
    private static final Object xj = new Object();
    private boolean hf;
    private int kd;
    private Object[] u;
    private long[] w;

    static {
        EvYxGn();
    }

    public w() {
        this(10);
    }

    private static /* synthetic */ void EvYxGn() {
        char[] charArray = "0<>}42>6}1<*} ;6??}\u0019=:\u0011!:746".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'S');
        }
        String str = new String(charArray);
        char[] charArray2 = "0?:=:'".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'S');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void u() {
        int i = this.kd;
        long[] jArr = this.w;
        Object[] objArr = this.u;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != xj) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.hf = false;
        this.kd = i2;
    }

    public void delete(long j) {
        int xj2 = hf.xj(this.w, this.kd, j);
        if (xj2 >= 0) {
            Object[] objArr = this.u;
            Object obj = objArr[xj2];
            Object obj2 = xj;
            if (obj != obj2) {
                objArr[xj2] = obj2;
                this.hf = true;
            }
        }
    }

    public void hf(long j, E e) {
        int xj2 = hf.xj(this.w, this.kd, j);
        if (xj2 >= 0) {
            this.u[xj2] = e;
            return;
        }
        int i = ~xj2;
        int i2 = this.kd;
        if (i < i2) {
            Object[] objArr = this.u;
            if (objArr[i] == xj) {
                this.w[i] = j;
                objArr[i] = e;
                return;
            }
        }
        if (this.hf && i2 >= this.w.length) {
            u();
            i = ~hf.xj(this.w, this.kd, j);
        }
        int i3 = this.kd;
        if (i3 >= this.w.length) {
            int xj3 = hf.xj(i3 + 1);
            long[] jArr = new long[xj3];
            Object[] objArr2 = new Object[xj3];
            long[] jArr2 = this.w;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.u;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.w = jArr;
            this.u = objArr2;
        }
        int i4 = this.kd;
        if (i4 - i != 0) {
            long[] jArr3 = this.w;
            int i5 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i5, i4 - i);
            Object[] objArr4 = this.u;
            System.arraycopy(objArr4, i, objArr4, i5, this.kd - i);
        }
        this.w[i] = j;
        this.u[i] = e;
        this.kd++;
    }

    public String toString() {
        if (hf() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.kd * 28);
        sb.append('{');
        for (int i = 0; i < this.kd; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(hf(i));
            sb.append('=');
            E w = w(i);
            if (w != this) {
                sb.append(w);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public E w(int i) {
        if (this.hf) {
            u();
        }
        return (E) this.u[i];
    }

    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public w<E> clone() {
        try {
            w<E> wVar = (w) super.clone();
            wVar.w = (long[]) this.w.clone();
            wVar.u = (Object[]) this.u.clone();
            return wVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public w(int i) {
        this.hf = false;
        if (i == 0) {
            this.w = hf.hf;
            this.u = hf.w;
        } else {
            int xj2 = hf.xj(i);
            this.w = new long[xj2];
            this.u = new Object[xj2];
        }
        this.kd = 0;
    }

    public void w() {
        int i = this.kd;
        Object[] objArr = this.u;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.kd = 0;
        this.hf = false;
    }

    public E xj(long j) {
        return xj(j, null);
    }

    public E xj(long j, E e) {
        E e2;
        int xj2 = hf.xj(this.w, this.kd, j);
        return (xj2 < 0 || (e2 = (E) this.u[xj2]) == xj) ? e : e2;
    }

    public void xj(int i) {
        Object[] objArr = this.u;
        Object obj = objArr[i];
        Object obj2 = xj;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.hf = true;
        }
    }

    public int hf() {
        if (this.hf) {
            u();
        }
        return this.kd;
    }

    public long hf(int i) {
        if (this.hf) {
            u();
        }
        return this.w[i];
    }
}

package com.bytedance.sdk.component.hf.xj.hf;

import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class f extends u {
    final transient byte[][] c;
    final transient int[] f;

    public f(xj xjVar, int i) {
        super(null);
        tf.xj(xjVar.hf, 0L, i);
        y yVar = xjVar.xj;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = yVar.w;
            int i6 = yVar.hf;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            yVar = yVar.y;
        }
        this.c = new byte[i4][];
        this.f = new int[i4 * 2];
        y yVar2 = xjVar.xj;
        int i7 = 0;
        while (i2 < i) {
            byte[][] bArr = this.c;
            bArr[i7] = yVar2.xj;
            int i8 = yVar2.w;
            int i9 = yVar2.hf;
            int i10 = (i8 - i9) + i2;
            i2 = i10 > i ? i : i10;
            int[] iArr = this.f;
            iArr[i7] = i2;
            iArr[bArr.length + i7] = i9;
            yVar2.u = true;
            i7++;
            yVar2 = yVar2.y;
        }
    }

    private u kd() {
        return new u(u());
    }

    @Override // com.bytedance.sdk.component.hf.xj.hf.u
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof u) {
            u uVar = (u) obj;
            if (uVar.w() == w() && xj(0, uVar, 0, w())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.hf.xj.hf.u
    public int hashCode() {
        int i = this.kd;
        if (i != 0) {
            return i;
        }
        int length = this.c.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.c[i2];
            int[] iArr = this.f;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        this.kd = i4;
        return i4;
    }

    @Override // com.bytedance.sdk.component.hf.xj.hf.u
    public String hf() {
        return kd().hf();
    }

    @Override // com.bytedance.sdk.component.hf.xj.hf.u
    public String toString() {
        return kd().toString();
    }

    @Override // com.bytedance.sdk.component.hf.xj.hf.u
    public byte[] u() {
        int[] iArr = this.f;
        byte[][] bArr = this.c;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.f;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.c[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // com.bytedance.sdk.component.hf.xj.hf.u
    public int w() {
        return this.f[this.c.length - 1];
    }

    @Override // com.bytedance.sdk.component.hf.xj.hf.u
    public String xj() {
        return kd().xj();
    }

    private int hf(int i) {
        int binarySearch = Arrays.binarySearch(this.f, 0, this.c.length, i + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    @Override // com.bytedance.sdk.component.hf.xj.hf.u
    public u xj(int i, int i2) {
        return kd().xj(i, i2);
    }

    @Override // com.bytedance.sdk.component.hf.xj.hf.u
    public byte xj(int i) {
        tf.xj(this.f[this.c.length - 1], i, 1L);
        int hf = hf(i);
        int i2 = hf == 0 ? 0 : this.f[hf - 1];
        int[] iArr = this.f;
        byte[][] bArr = this.c;
        return bArr[hf][(i - i2) + iArr[bArr.length + hf]];
    }

    @Override // com.bytedance.sdk.component.hf.xj.hf.u
    public boolean xj(int i, u uVar, int i2, int i3) {
        if (i < 0 || i > w() - i3) {
            return false;
        }
        int hf = hf(i);
        while (i3 > 0) {
            int i4 = hf == 0 ? 0 : this.f[hf - 1];
            int min = Math.min(i3, ((this.f[hf] - i4) + i4) - i);
            int[] iArr = this.f;
            byte[][] bArr = this.c;
            if (!uVar.xj(i2, bArr[hf], (i - i4) + iArr[bArr.length + hf], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            hf++;
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.hf.xj.hf.u
    public boolean xj(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > w() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int hf = hf(i);
        while (i3 > 0) {
            int i4 = hf == 0 ? 0 : this.f[hf - 1];
            int min = Math.min(i3, ((this.f[hf] - i4) + i4) - i);
            int[] iArr = this.f;
            byte[][] bArr2 = this.c;
            if (!tf.xj(bArr2[hf], (i - i4) + iArr[bArr2.length + hf], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            hf++;
        }
        return true;
    }
}

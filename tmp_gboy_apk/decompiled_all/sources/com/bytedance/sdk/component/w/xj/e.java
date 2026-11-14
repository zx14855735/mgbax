package com.bytedance.sdk.component.w.xj;

import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class e extends y {
    final transient int[] c;
    final transient byte[][] y;

    public e(w wVar, int i) {
        super(null);
        pz.xj(wVar.hf, 0L, i);
        qt qtVar = wVar.xj;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = qtVar.w;
            int i6 = qtVar.hf;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            qtVar = qtVar.y;
        }
        this.y = new byte[i4][];
        this.c = new int[i4 * 2];
        qt qtVar2 = wVar.xj;
        int i7 = 0;
        while (i2 < i) {
            byte[][] bArr = this.y;
            bArr[i7] = qtVar2.xj;
            int i8 = qtVar2.w;
            int i9 = qtVar2.hf;
            int i10 = (i8 - i9) + i2;
            i2 = i10 > i ? i : i10;
            int[] iArr = this.c;
            iArr[i7] = i2;
            iArr[bArr.length + i7] = i9;
            qtVar2.u = true;
            i7++;
            qtVar2 = qtVar2.y;
        }
    }

    private y d() {
        return new y(f());
    }

    @Override // com.bytedance.sdk.component.w.xj.y
    public int c() {
        return this.c[this.y.length - 1];
    }

    @Override // com.bytedance.sdk.component.w.xj.y
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof y) {
            y yVar = (y) obj;
            if (yVar.c() == c() && xj(0, yVar, 0, c())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.w.xj.y
    public byte[] f() {
        int[] iArr = this.c;
        byte[][] bArr = this.y;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.c;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.y[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // com.bytedance.sdk.component.w.xj.y
    public int hashCode() {
        int i = this.u;
        if (i != 0) {
            return i;
        }
        int length = this.y.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.y[i2];
            int[] iArr = this.c;
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
        this.u = i4;
        return i4;
    }

    @Override // com.bytedance.sdk.component.w.xj.y
    public String hf() {
        return d().hf();
    }

    @Override // com.bytedance.sdk.component.w.xj.y
    public String kd() {
        return d().kd();
    }

    @Override // com.bytedance.sdk.component.w.xj.y
    public String toString() {
        return d().toString();
    }

    @Override // com.bytedance.sdk.component.w.xj.y
    public y u() {
        return d().u();
    }

    @Override // com.bytedance.sdk.component.w.xj.y
    public y w() {
        return d().w();
    }

    @Override // com.bytedance.sdk.component.w.xj.y
    public String xj() {
        return d().xj();
    }

    @Override // com.bytedance.sdk.component.w.xj.y
    public y y() {
        return d().y();
    }

    private int hf(int i) {
        int binarySearch = Arrays.binarySearch(this.c, 0, this.y.length, i + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    @Override // com.bytedance.sdk.component.w.xj.y
    public y xj(int i, int i2) {
        return d().xj(i, i2);
    }

    @Override // com.bytedance.sdk.component.w.xj.y
    public byte xj(int i) {
        pz.xj(this.c[this.y.length - 1], i, 1L);
        int hf = hf(i);
        int i2 = hf == 0 ? 0 : this.c[hf - 1];
        int[] iArr = this.c;
        byte[][] bArr = this.y;
        return bArr[hf][(i - i2) + iArr[bArr.length + hf]];
    }

    @Override // com.bytedance.sdk.component.w.xj.y
    public void xj(w wVar) {
        int length = this.y.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.c;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            qt qtVar = new qt(this.y[i], i3, (i3 + i4) - i2, true, false);
            qt qtVar2 = wVar.xj;
            if (qtVar2 == null) {
                qtVar.c = qtVar;
                qtVar.y = qtVar;
                wVar.xj = qtVar;
            } else {
                qtVar2.c.xj(qtVar);
            }
            i++;
            i2 = i4;
        }
        wVar.hf += i2;
    }

    @Override // com.bytedance.sdk.component.w.xj.y
    public boolean xj(int i, y yVar, int i2, int i3) {
        if (i < 0 || i > c() - i3) {
            return false;
        }
        int hf = hf(i);
        while (i3 > 0) {
            int i4 = hf == 0 ? 0 : this.c[hf - 1];
            int min = Math.min(i3, ((this.c[hf] - i4) + i4) - i);
            int[] iArr = this.c;
            byte[][] bArr = this.y;
            if (!yVar.xj(i2, bArr[hf], (i - i4) + iArr[bArr.length + hf], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            hf++;
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.w.xj.y
    public boolean xj(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > c() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int hf = hf(i);
        while (i3 > 0) {
            int i4 = hf == 0 ? 0 : this.c[hf - 1];
            int min = Math.min(i3, ((this.c[hf] - i4) + i4) - i);
            int[] iArr = this.c;
            byte[][] bArr2 = this.y;
            if (!pz.xj(bArr2[hf], (i - i4) + iArr[bArr2.length + hf], bArr, i2, min)) {
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

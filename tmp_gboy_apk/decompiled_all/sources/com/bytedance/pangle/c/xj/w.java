package com.bytedance.pangle.c.xj;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class w {
    private int hf;
    private int w;
    private int[] xj = new int[32];

    private void c() {
        int[] iArr = this.xj;
        int length = iArr.length;
        int i = this.hf;
        int i2 = length - i;
        if (i2 <= 2) {
            int[] iArr2 = new int[(iArr.length + i2) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            this.xj = iArr2;
        }
    }

    public final int hf() {
        int i = this.hf;
        if (i == 0) {
            return 0;
        }
        return this.xj[i - 1];
    }

    public final void kd() {
        c();
        int i = this.hf;
        int[] iArr = this.xj;
        iArr[i] = 0;
        iArr[i + 1] = 0;
        this.hf = i + 2;
        this.w++;
    }

    public final int u() {
        return this.w;
    }

    public final void w() {
        int[] iArr;
        int i;
        int i2 = this.hf;
        if (i2 == 0 || (i = (iArr = this.xj)[i2 - 1]) == 0) {
            return;
        }
        int i3 = i - 1;
        int i4 = i2 - 3;
        iArr[i4] = i3;
        iArr[i4 - ((i3 * 2) + 1)] = i3;
        this.hf = i2 - 2;
    }

    public final void xj() {
        this.hf = 0;
        this.w = 0;
    }

    public final void y() {
        int i = this.hf;
        if (i != 0) {
            int i2 = this.xj[i - 1] * 2;
            if ((i - 2) - i2 != 0) {
                this.hf = i - (i2 + 2);
                this.w--;
            }
        }
    }

    public final void xj(int i, int i2) {
        if (this.w == 0) {
            kd();
        }
        c();
        int i3 = this.hf;
        int i4 = i3 - 1;
        int[] iArr = this.xj;
        int i5 = iArr[i4];
        int i6 = (i3 - 2) - (i5 * 2);
        int i7 = i5 + 1;
        iArr[i6] = i7;
        iArr[i4] = i;
        iArr[i3] = i2;
        iArr[i3 + 1] = i7;
        this.hf = i3 + 2;
    }
}

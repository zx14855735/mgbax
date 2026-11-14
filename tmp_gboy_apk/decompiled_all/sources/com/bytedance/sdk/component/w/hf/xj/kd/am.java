package com.bytedance.sdk.component.w.hf.xj.kd;

import com.sigmob.sdk.base.views.r;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class am {
    private final int[] hf = new int[10];
    private int xj;

    public int hf(int i) {
        return this.hf[i];
    }

    public int u(int i) {
        return (this.xj & 32) != 0 ? this.hf[5] : i;
    }

    public int w() {
        if ((this.xj & 2) != 0) {
            return this.hf[1];
        }
        return -1;
    }

    public void xj() {
        this.xj = 0;
        Arrays.fill(this.hf, 0);
    }

    public int hf() {
        return Integer.bitCount(this.xj);
    }

    public int u() {
        if ((this.xj & r.b.d) != 0) {
            return this.hf[7];
        }
        return 65535;
    }

    public int w(int i) {
        return (this.xj & 16) != 0 ? this.hf[4] : i;
    }

    public am xj(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.hf;
            if (i < iArr.length) {
                this.xj = (1 << i) | this.xj;
                iArr[i] = i2;
            }
        }
        return this;
    }

    public boolean xj(int i) {
        return ((1 << i) & this.xj) != 0;
    }

    public void xj(am amVar) {
        for (int i = 0; i < 10; i++) {
            if (amVar.xj(i)) {
                xj(i, amVar.hf(i));
            }
        }
    }
}

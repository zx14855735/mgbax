package com.bytedance.pangle.c.xj;

import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y {
    private int[] hf;
    private int[] xj;

    private y() {
    }

    public static y xj(hf hfVar) {
        hfVar.hf(1835009);
        int hf = hfVar.hf();
        int hf2 = hfVar.hf();
        int hf3 = hfVar.hf();
        hfVar.hf();
        int hf4 = hfVar.hf();
        int hf5 = hfVar.hf();
        y yVar = new y();
        yVar.xj = hfVar.xj(hf2);
        if (hf3 != 0) {
            hfVar.xj(hf3);
        }
        int i = (hf5 == 0 ? hf : hf5) - hf4;
        if (i % 4 != 0) {
            throw new IOException();
        }
        yVar.hf = hfVar.xj(i / 4);
        if (hf5 == 0) {
            return yVar;
        }
        int i2 = hf - hf5;
        if (i2 % 4 != 0) {
            throw new IOException();
        }
        hfVar.xj(i2 / 4);
        return yVar;
    }

    public String xj(int i) {
        int[] iArr;
        if (i < 0 || (iArr = this.xj) == null || i >= iArr.length) {
            return null;
        }
        int i2 = iArr[i];
        int xj = xj(this.hf, i2);
        StringBuilder sb = new StringBuilder(xj);
        while (xj != 0) {
            i2 += 2;
            sb.append((char) xj(this.hf, i2));
            xj--;
        }
        return sb.toString();
    }

    private static final int xj(int[] iArr, int i) {
        int i2 = iArr[i / 4];
        return (i % 4) / 2 == 0 ? i2 & 65535 : i2 >>> 16;
    }
}

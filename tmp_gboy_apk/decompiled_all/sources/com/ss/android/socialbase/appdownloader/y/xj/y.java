package com.ss.android.socialbase.appdownloader.y.xj;

import ADYaiT.CtFAbx;
import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class y {
    private int[] hf;
    private int[] xj;

    private y() {
    }

    public static y xj(u uVar) {
        hf.xj(uVar, 1835009);
        int hf = uVar.hf();
        int hf2 = uVar.hf();
        int hf3 = uVar.hf();
        uVar.hf();
        int hf4 = uVar.hf();
        int hf5 = uVar.hf();
        y yVar = new y();
        yVar.xj = uVar.hf(hf2);
        if (hf3 != 0) {
            uVar.hf(hf3);
        }
        int i = (hf5 == 0 ? hf : hf5) - hf4;
        if (i % 4 != 0) {
            throw new IOException(CtFAbx.ASJ6gh(i, "String data size is not multiple of 4 (", ")."));
        }
        yVar.hf = uVar.hf(i / 4);
        if (hf5 == 0) {
            return yVar;
        }
        int i2 = hf - hf5;
        if (i2 % 4 != 0) {
            throw new IOException(CtFAbx.ASJ6gh(i2, "Style data size is not multiple of 4 (", ")."));
        }
        uVar.hf(i2 / 4);
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

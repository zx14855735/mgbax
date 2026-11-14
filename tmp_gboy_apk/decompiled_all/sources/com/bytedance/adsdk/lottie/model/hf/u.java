package com.bytedance.adsdk.lottie.model.hf;

import ADYaiT.CtFAbx;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    private final int[] hf;
    private final float[] xj;

    public u(float[] fArr, int[] iArr) {
        this.xj = fArr;
        this.hf = iArr;
    }

    public int[] hf() {
        return this.hf;
    }

    public int w() {
        return this.hf.length;
    }

    public float[] xj() {
        return this.xj;
    }

    public void xj(u uVar, u uVar2, float f) {
        if (uVar.hf.length != uVar2.hf.length) {
            StringBuilder sb = new StringBuilder("Cannot interpolate between gradients. Lengths vary (");
            sb.append(uVar.hf.length);
            sb.append(" vs ");
            throw new IllegalArgumentException(CtFAbx.AZkASS(")", uVar2.hf.length, sb));
        }
        for (int i = 0; i < uVar.hf.length; i++) {
            this.xj[i] = com.bytedance.adsdk.lottie.kd.f.xj(uVar.xj[i], uVar2.xj[i], f);
            this.hf[i] = com.bytedance.adsdk.lottie.kd.w.xj(f, uVar.hf[i], uVar2.hf[i]);
        }
    }

    public u xj(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            iArr[i] = xj(fArr[i]);
        }
        return new u(fArr, iArr);
    }

    private int xj(float f) {
        int binarySearch = Arrays.binarySearch(this.xj, f);
        if (binarySearch >= 0) {
            return this.hf[binarySearch];
        }
        int i = -(binarySearch + 1);
        if (i == 0) {
            return this.hf[0];
        }
        int[] iArr = this.hf;
        if (i == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.xj;
        int i2 = i - 1;
        float f2 = fArr[i2];
        return com.bytedance.adsdk.lottie.kd.w.xj((f - f2) / (fArr[i] - f2), iArr[i2], iArr[i]);
    }
}

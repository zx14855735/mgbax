package com.bytedance.msdk.core.hf;

import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd {
    private final float[] hf;
    private final int[] w;
    private final String xj;

    public kd(String str, JSONArray jSONArray, JSONArray jSONArray2) {
        this.xj = str;
        this.hf = new float[jSONArray.length()];
        this.w = new int[jSONArray2.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            this.hf[i] = (float) jSONArray.optDouble(i);
        }
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            this.w[i2] = jSONArray2.optInt(i2);
        }
    }

    public int xj(float f) {
        int[] iArr;
        int i;
        float[] fArr = this.hf;
        int i2 = -1;
        if (fArr != null && fArr.length != 0 && (iArr = this.w) != null && iArr.length != 0) {
            int length = fArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                float[] fArr2 = this.hf;
                float f2 = fArr2[i3];
                if (f <= f2 || (i = i3 + 1) >= length || f > fArr2[i]) {
                    if (i3 == length - 1 && f > f2) {
                        i2 = this.w[i3];
                    }
                    i3++;
                } else {
                    int[] iArr2 = this.w;
                    if (i3 < iArr2.length) {
                        return iArr2[i3];
                    }
                }
            }
        }
        return i2;
    }
}

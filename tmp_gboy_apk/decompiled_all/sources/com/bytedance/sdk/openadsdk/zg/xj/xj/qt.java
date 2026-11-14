package com.bytedance.sdk.openadsdk.zg.xj.xj;

import ADYaiT.BpkvW3;
import IzHBwY.ARc23Z;
import P8ccfD.AaHO0E;
import android.util.SparseArray;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class qt {
    public static Function<SparseArray<Object>, Object> xj(Object obj) {
        return BpkvW3.BmvVmW(obj) ? AaHO0E.AYUAbz(obj) : ARc23Z.f4112ADYaiT;
    }

    public static Integer[] xj(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return null;
        }
        Integer[] numArr = new Integer[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }
}

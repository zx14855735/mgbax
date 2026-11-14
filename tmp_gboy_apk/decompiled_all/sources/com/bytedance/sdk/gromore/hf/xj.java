package com.bytedance.sdk.gromore.hf;

import IzHBwY.AYUAbz;
import android.util.SparseArray;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj implements Function<SparseArray<Object>, Object> {
    private static Function<SparseArray<Object>, Object> hf;
    private static volatile xj xj;

    private xj() {
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        return null;
    }

    public static void xj(Function<SparseArray<Object>, Object> function) {
        hf = function;
    }

    public static xj xj() {
        if (xj == null) {
            synchronized (xj.class) {
                try {
                    if (xj == null) {
                        xj = new xj();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public void xj(String str, String str2) {
        if (hf != null) {
            AYUAbz A4TApA2 = AYUAbz.A4TApA();
            A4TApA2.ASJ6gh(20000, str);
            A4TApA2.ASJ6gh(20001, str2);
            A4TApA2.AMqCpz(-99999987, 10000);
            A4TApA2.ARc23Z(-99999985, Void.class);
            hf.apply(A4TApA2.A2egSU().sparseArray());
        }
    }
}

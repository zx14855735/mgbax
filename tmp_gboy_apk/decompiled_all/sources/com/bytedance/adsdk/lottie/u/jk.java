package com.bytedance.adsdk.lottie.u;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.SparseArray;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class jk {
    private static SparseArray<WeakReference<Interpolator>> hf;
    private static final Interpolator xj = new LinearInterpolator();

    static {
        ZFJzl();
    }

    private static /* synthetic */ void ZFJzl() {
        char[] charArray = "$(*i &*\"i%(>i4/\"++i\r).\u00055.# \"".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'G');
        }
        String str = new String(charArray);
        char[] charArray2 = "$+.).3".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'G');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:142:0x02aa A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static <T> com.bytedance.adsdk.lottie.y.xj<T> hf(com.bytedance.adsdk.lottie.y r26, android.util.JsonReader r27, float r28, com.bytedance.adsdk.lottie.u.eu<T> r29) {
        /*
            Method dump skipped, instructions count: 774
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.u.jk.hf(com.bytedance.adsdk.lottie.y, android.util.JsonReader, float, com.bytedance.adsdk.lottie.u.eu):com.bytedance.adsdk.lottie.y.xj");
    }

    private static SparseArray<WeakReference<Interpolator>> xj() {
        if (hf == null) {
            hf = new SparseArray<>();
        }
        return hf;
    }

    private static WeakReference<Interpolator> xj(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (jk.class) {
            weakReference = xj().get(i);
        }
        return weakReference;
    }

    private static void xj(int i, WeakReference<Interpolator> weakReference) {
        synchronized (jk.class) {
            hf.put(i, weakReference);
        }
    }

    public static <T> com.bytedance.adsdk.lottie.y.xj<T> xj(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar, float f, eu<T> euVar, boolean z, boolean z2) {
        if (z && z2) {
            return hf(yVar, jsonReader, f, euVar);
        }
        if (z) {
            return xj(yVar, jsonReader, f, euVar);
        }
        return xj(jsonReader, f, euVar);
    }

    private static <T> com.bytedance.adsdk.lottie.y.xj<T> xj(com.bytedance.adsdk.lottie.y yVar, JsonReader jsonReader, float f, eu<T> euVar) {
        Interpolator xj2;
        jsonReader.beginObject();
        PointF pointF = null;
        PointF pointF2 = null;
        T t = null;
        T t2 = null;
        PointF pointF3 = null;
        PointF pointF4 = null;
        boolean z = false;
        float f2 = 0.0f;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "e":
                    t = euVar.hf(jsonReader, f);
                    break;
                case "h":
                    if (jsonReader.nextInt() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case "i":
                    pointF2 = v.hf(jsonReader, 1.0f);
                    break;
                case "o":
                    pointF = v.hf(jsonReader, 1.0f);
                    break;
                case "s":
                    t2 = euVar.hf(jsonReader, f);
                    break;
                case "t":
                    f2 = (float) jsonReader.nextDouble();
                    break;
                case "ti":
                    pointF4 = v.hf(jsonReader, f);
                    break;
                case "to":
                    pointF3 = v.hf(jsonReader, f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z) {
            t = t2;
        } else if (pointF != null && pointF2 != null) {
            xj2 = xj(pointF, pointF2);
            com.bytedance.adsdk.lottie.y.xj<T> xjVar = new com.bytedance.adsdk.lottie.y.xj<>(yVar, t2, t, xj2, f2, null);
            xjVar.f = pointF3;
            xjVar.d = pointF4;
            return xjVar;
        }
        xj2 = xj;
        com.bytedance.adsdk.lottie.y.xj<T> xjVar2 = new com.bytedance.adsdk.lottie.y.xj<>(yVar, t2, t, xj2, f2, null);
        xjVar2.f = pointF3;
        xjVar2.d = pointF4;
        return xjVar2;
    }

    private static Interpolator xj(PointF pointF, PointF pointF2) {
        Interpolator linearInterpolator;
        pointF.x = com.bytedance.adsdk.lottie.kd.f.hf(pointF.x, -1.0f, 1.0f);
        pointF.y = com.bytedance.adsdk.lottie.kd.f.hf(pointF.y, -100.0f, 100.0f);
        pointF2.x = com.bytedance.adsdk.lottie.kd.f.hf(pointF2.x, -1.0f, 1.0f);
        float hf2 = com.bytedance.adsdk.lottie.kd.f.hf(pointF2.y, -100.0f, 100.0f);
        pointF2.y = hf2;
        int xj2 = com.bytedance.adsdk.lottie.kd.d.xj(pointF.x, pointF.y, pointF2.x, hf2);
        WeakReference<Interpolator> xj3 = com.bytedance.adsdk.lottie.kd.xj() ? null : xj(xj2);
        Interpolator interpolator = xj3 != null ? xj3.get() : null;
        if (xj3 != null && interpolator != null) {
            return interpolator;
        }
        try {
            linearInterpolator = com.bytedance.adsdk.lottie.e.xj(pointF.x, pointF.y, pointF2.x, pointF2.y);
        } catch (IllegalArgumentException e) {
            if ("The Path cannot loop back on itself.".equals(e.getMessage())) {
                linearInterpolator = com.bytedance.adsdk.lottie.e.xj(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
            } else {
                linearInterpolator = new LinearInterpolator();
            }
        }
        if (!com.bytedance.adsdk.lottie.kd.xj()) {
            try {
                xj(xj2, (WeakReference<Interpolator>) new WeakReference(linearInterpolator));
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return linearInterpolator;
    }

    private static <T> com.bytedance.adsdk.lottie.y.xj<T> xj(JsonReader jsonReader, float f, eu<T> euVar) {
        return new com.bytedance.adsdk.lottie.y.xj<>(euVar.hf(jsonReader, f));
    }
}

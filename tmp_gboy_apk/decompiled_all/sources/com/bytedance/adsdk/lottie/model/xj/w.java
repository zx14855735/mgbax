package com.bytedance.adsdk.lottie.model.xj;

import java.util.Arrays;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w extends am<com.bytedance.adsdk.lottie.model.hf.u, com.bytedance.adsdk.lottie.model.hf.u> {
    public w(List<com.bytedance.adsdk.lottie.y.xj<com.bytedance.adsdk.lottie.model.hf.u>> list) {
        super(xj(list));
    }

    private static List<com.bytedance.adsdk.lottie.y.xj<com.bytedance.adsdk.lottie.model.hf.u>> xj(List<com.bytedance.adsdk.lottie.y.xj<com.bytedance.adsdk.lottie.model.hf.u>> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, xj(list.get(i)));
        }
        return list;
    }

    @Override // com.bytedance.adsdk.lottie.model.xj.am, com.bytedance.adsdk.lottie.model.xj.g
    public /* bridge */ /* synthetic */ boolean hf() {
        return super.hf();
    }

    @Override // com.bytedance.adsdk.lottie.model.xj.am
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.bytedance.adsdk.lottie.model.xj.am, com.bytedance.adsdk.lottie.model.xj.g
    public /* bridge */ /* synthetic */ List w() {
        return super.w();
    }

    private static com.bytedance.adsdk.lottie.y.xj<com.bytedance.adsdk.lottie.model.hf.u> xj(com.bytedance.adsdk.lottie.y.xj<com.bytedance.adsdk.lottie.model.hf.u> xjVar) {
        com.bytedance.adsdk.lottie.model.hf.u uVar = xjVar.xj;
        com.bytedance.adsdk.lottie.model.hf.u uVar2 = xjVar.hf;
        if (uVar == null || uVar2 == null || uVar.xj().length == uVar2.xj().length) {
            return xjVar;
        }
        float[] xj = xj(uVar.xj(), uVar2.xj());
        return xjVar.xj(uVar.xj(xj), uVar2.xj(xj));
    }

    public static float[] xj(float[] fArr, float[] fArr2) {
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        Arrays.sort(fArr3);
        float f = Float.NaN;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            float f2 = fArr3[i2];
            if (f2 != f) {
                fArr3[i] = f2;
                i++;
                f = fArr3[i2];
            }
        }
        return Arrays.copyOfRange(fArr3, 0, i);
    }

    @Override // com.bytedance.adsdk.lottie.model.xj.g
    public com.bytedance.adsdk.lottie.xj.hf.xj<com.bytedance.adsdk.lottie.model.hf.u, com.bytedance.adsdk.lottie.model.hf.u> xj() {
        return new com.bytedance.adsdk.lottie.xj.hf.kd(this.xj);
    }
}

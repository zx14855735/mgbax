package com.bytedance.adsdk.lottie.xj.xj;

import android.graphics.PointF;
import com.bytedance.adsdk.lottie.xj.hf.xj;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class e implements xj.InterfaceC0024xj, v {
    private final String hf;
    private com.bytedance.adsdk.lottie.model.hf.am u;
    private final com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> w;
    private final com.bytedance.adsdk.lottie.f xj;

    public e(com.bytedance.adsdk.lottie.f fVar, com.bytedance.adsdk.lottie.model.layer.w wVar, com.bytedance.adsdk.lottie.model.hf.g gVar) {
        this.xj = fVar;
        this.hf = gVar.xj();
        com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> xj = gVar.hf().xj();
        this.w = xj;
        wVar.xj(xj);
        xj.xj(this);
    }

    public com.bytedance.adsdk.lottie.xj.hf.xj<Float, Float> hf() {
        return this.w;
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.w
    public void xj(List<w> list, List<w> list2) {
    }

    private com.bytedance.adsdk.lottie.model.hf.am hf(com.bytedance.adsdk.lottie.model.hf.am amVar) {
        List<com.bytedance.adsdk.lottie.model.xj> w = amVar.w();
        boolean hf = amVar.hf();
        int size = w.size() - 1;
        int i = 0;
        while (size >= 0) {
            com.bytedance.adsdk.lottie.model.xj xjVar = w.get(size);
            com.bytedance.adsdk.lottie.model.xj xjVar2 = w.get(xj(size - 1, w.size()));
            PointF w2 = (size != 0 || hf) ? xjVar2.w() : amVar.xj();
            i = (((size != 0 || hf) ? xjVar2.hf() : w2).equals(w2) && xjVar.xj().equals(w2) && !(!amVar.hf() && size == 0 && size == w.size() - 1)) ? i + 2 : i + 1;
            size--;
        }
        com.bytedance.adsdk.lottie.model.hf.am amVar2 = this.u;
        if (amVar2 == null || amVar2.w().size() != i) {
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(new com.bytedance.adsdk.lottie.model.xj());
            }
            this.u = new com.bytedance.adsdk.lottie.model.hf.am(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.u.xj(hf);
        return this.u;
    }

    @Override // com.bytedance.adsdk.lottie.xj.hf.xj.InterfaceC0024xj
    public void xj() {
        this.xj.invalidateSelf();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x009e, code lost:
    
        if (r7 == (r0.size() - 1)) goto L27;
     */
    @Override // com.bytedance.adsdk.lottie.xj.xj.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.bytedance.adsdk.lottie.model.hf.am xj(com.bytedance.adsdk.lottie.model.hf.am r19) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.xj.xj.e.xj(com.bytedance.adsdk.lottie.model.hf.am):com.bytedance.adsdk.lottie.model.hf.am");
    }

    private static int hf(int i, int i2) {
        int i3 = i / i2;
        return ((i ^ i2) >= 0 || i2 * i3 == i) ? i3 : i3 - 1;
    }

    private static int xj(int i, int i2) {
        return i - (hf(i, i2) * i2);
    }
}

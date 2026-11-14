package com.bytedance.adsdk.xj.xj.xj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {

    public static class xj extends IOException {
        public xj() {
            super("APNG Format error");
        }
    }

    private static kd hf(com.bytedance.adsdk.xj.xj.hf.xj xjVar) {
        int w = xjVar.w();
        int hf = xjVar.hf();
        int b_ = xjVar.b_();
        kd xjVar2 = b_ == com.bytedance.adsdk.xj.xj.xj.xj.xj ? new com.bytedance.adsdk.xj.xj.xj.xj() : b_ == y.xj ? new y() : b_ == c.xj ? new c() : b_ == tf.xj ? new tf() : b_ == p.xj ? new p() : b_ == pl.xj ? new pl() : new kd();
        xjVar2.c = w;
        xjVar2.kd = b_;
        xjVar2.u = hf;
        xjVar2.hf(xjVar);
        xjVar2.y = xjVar.hf();
        return xjVar2;
    }

    public static List<kd> xj(com.bytedance.adsdk.xj.xj.hf.xj xjVar) {
        if (!xjVar.xj("\u0089PNG") || !xjVar.xj("\r\n\u001a\n")) {
            throw new xj();
        }
        ArrayList arrayList = new ArrayList();
        while (xjVar.u() > 0) {
            arrayList.add(hf(xjVar));
        }
        return arrayList;
    }
}

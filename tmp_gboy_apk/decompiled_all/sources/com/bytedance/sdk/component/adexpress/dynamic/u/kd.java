package com.bytedance.sdk.component.adexpress.dynamic.u;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.u.hf;
import com.bytedance.sdk.component.adexpress.hf.g;
import com.czhj.sdk.common.Constants;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd {
    protected hf hf;
    private xj u;
    private com.bytedance.sdk.component.adexpress.dynamic.w.f w;
    public com.bytedance.sdk.component.adexpress.dynamic.w.hf xj;

    public static class xj {
        float hf;
        float w;
        float xj;
    }

    public kd(double d, int i, double d2, String str, g gVar) {
        this.hf = new hf(d, i, d2, str, gVar);
    }

    public void xj(xj xjVar) {
        this.u = xjVar;
    }

    public void xj() {
        this.hf.xj();
    }

    public void xj(com.bytedance.sdk.component.adexpress.dynamic.w.f fVar, float f, float f2) {
        if (fVar != null) {
            this.w = fVar;
        }
        com.bytedance.sdk.component.adexpress.dynamic.w.f fVar2 = this.w;
        float f3 = fVar2.f();
        float d = fVar2.d();
        float f4 = TextUtils.equals(fVar2.tf().kd().x(), "fixed") ? d : 65536.0f;
        this.hf.xj();
        this.hf.w(fVar2, f3, f4);
        hf.w xj2 = this.hf.xj(fVar2);
        com.bytedance.sdk.component.adexpress.dynamic.w.hf hfVar = new com.bytedance.sdk.component.adexpress.dynamic.w.hf();
        hfVar.xj = f;
        hfVar.hf = f2;
        if (xj2 != null) {
            f3 = xj2.xj;
        }
        hfVar.w = f3;
        if (xj2 != null) {
            d = xj2.hf;
        }
        hfVar.u = d;
        hfVar.kd = "root";
        hfVar.d = 1280.0f;
        hfVar.y = fVar2;
        fVar2.w(f);
        hfVar.y.u(hfVar.hf);
        hfVar.y.kd(hfVar.w);
        hfVar.y.y(hfVar.u);
        com.bytedance.sdk.component.adexpress.dynamic.w.hf xj3 = xj(hfVar, 0.0f);
        this.xj = xj3;
        xj(xj3);
    }

    public void xj(com.bytedance.sdk.component.adexpress.dynamic.w.hf hfVar) {
        if (hfVar == null) {
            return;
        }
        hfVar.y.tf().getType();
        List<List<com.bytedance.sdk.component.adexpress.dynamic.w.hf>> list = hfVar.c;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (List<com.bytedance.sdk.component.adexpress.dynamic.w.hf> list2 : list) {
            if (list2 != null && list2.size() > 0) {
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.w.hf> it = list2.iterator();
                while (it.hasNext()) {
                    xj(it.next());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0282  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.bytedance.sdk.component.adexpress.dynamic.w.hf xj(com.bytedance.sdk.component.adexpress.dynamic.w.hf r37, float r38) {
        /*
            Method dump skipped, instructions count: 1004
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.u.kd.xj(com.bytedance.sdk.component.adexpress.dynamic.w.hf, float):com.bytedance.sdk.component.adexpress.dynamic.w.hf");
    }

    private com.bytedance.sdk.component.adexpress.dynamic.w.d xj(com.bytedance.sdk.component.adexpress.dynamic.w.y yVar, hf.w wVar, hf.w wVar2) {
        float vl = yVar.vl();
        float ne = yVar.ne();
        float h = yVar.h();
        float se = yVar.se();
        boolean lw = yVar.lw();
        boolean wa = yVar.wa();
        boolean gh = yVar.gh();
        boolean op = yVar.op();
        if (!lw) {
            if (wa) {
                float f = this.u.xj;
                vl = ((f != 0.0f ? Math.min(f, wVar.xj) : wVar.xj) - h) - wVar2.xj;
            } else {
                vl = 0.0f;
            }
        }
        if (!gh) {
            if (op) {
                float f2 = this.u.hf;
                if (f2 == 0.0f) {
                    f2 = wVar.hf;
                }
                ne = (f2 - se) - wVar2.hf;
            } else {
                ne = 0.0f;
            }
        }
        return new com.bytedance.sdk.component.adexpress.dynamic.w.d(vl, ne);
    }

    private com.bytedance.sdk.component.adexpress.dynamic.w.d xj(com.bytedance.sdk.component.adexpress.dynamic.w.hf hfVar, com.bytedance.sdk.component.adexpress.dynamic.w.y yVar, float f, float f2) {
        float f3;
        float f4;
        float f5 = hfVar.xj;
        float f6 = hfVar.hf;
        float vl = yVar.vl();
        float ne = yVar.ne();
        float h = yVar.h();
        float se = yVar.se();
        boolean lw = yVar.lw();
        boolean wa = yVar.wa();
        boolean gh = yVar.gh();
        boolean op = yVar.op();
        String bl = yVar.bl();
        float f7 = hfVar.w;
        float f8 = hfVar.u;
        if (TextUtils.equals(bl, Constants.FAIL)) {
            if (lw) {
                f5 = hfVar.xj + vl;
            } else if (wa) {
                f5 = ((hfVar.xj + f7) - h) - f;
            }
            if (gh) {
                f4 = hfVar.hf;
                f6 = f4 + ne;
            } else if (op) {
                f3 = hfVar.hf;
                f6 = ((f3 + f8) - se) - f2;
            }
        } else if (TextUtils.equals(bl, "1")) {
            f5 = hfVar.xj + ((f7 - f) / 2.0f);
            if (gh) {
                f4 = hfVar.hf;
                f6 = f4 + ne;
            } else if (op) {
                f3 = hfVar.hf;
                f6 = ((f3 + f8) - se) - f2;
            }
        } else if (TextUtils.equals(bl, "2")) {
            f6 = hfVar.hf + ((f8 - f2) / 2.0f);
            if (lw) {
                f5 = hfVar.xj + vl;
            } else if (wa) {
                f5 = ((hfVar.xj + f7) - h) - f;
            }
        } else if (TextUtils.equals(bl, "3")) {
            f5 = hfVar.xj + ((f7 - f) / 2.0f);
            f6 = ((f8 - f2) / 2.0f) + hfVar.hf;
        }
        return new com.bytedance.sdk.component.adexpress.dynamic.w.d(f5, f6);
    }
}

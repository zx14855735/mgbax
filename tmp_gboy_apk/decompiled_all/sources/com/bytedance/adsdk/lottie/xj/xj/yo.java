package com.bytedance.adsdk.lottie.xj.xj;

import android.graphics.Path;
import com.bytedance.adsdk.lottie.model.hf.v;
import com.bytedance.adsdk.lottie.xj.hf.xj;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class yo implements xj.InterfaceC0024xj, g {
    private final String hf;
    private final com.bytedance.adsdk.lottie.xj.hf.g kd;
    private final com.bytedance.adsdk.lottie.f u;
    private final boolean w;
    private boolean y;
    private final Path xj = new Path();
    private final hf c = new hf();

    public yo(com.bytedance.adsdk.lottie.f fVar, com.bytedance.adsdk.lottie.model.layer.w wVar, com.bytedance.adsdk.lottie.model.hf.e eVar) {
        this.hf = eVar.xj();
        this.w = eVar.w();
        this.u = fVar;
        com.bytedance.adsdk.lottie.xj.hf.g xj = eVar.hf().xj();
        this.kd = xj;
        wVar.xj(xj);
        xj.xj(this);
    }

    private void hf() {
        this.y = false;
        this.u.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.g
    public Path u() {
        if (this.y) {
            return this.xj;
        }
        this.xj.reset();
        if (this.w) {
            this.y = true;
            return this.xj;
        }
        Path c = this.kd.c();
        if (c == null) {
            return this.xj;
        }
        this.xj.set(c);
        this.xj.setFillType(Path.FillType.EVEN_ODD);
        this.c.xj(this.xj);
        this.y = true;
        return this.xj;
    }

    @Override // com.bytedance.adsdk.lottie.xj.hf.xj.InterfaceC0024xj
    public void xj() {
        hf();
    }

    @Override // com.bytedance.adsdk.lottie.xj.xj.w
    public void xj(List<w> list, List<w> list2) {
        ArrayList arrayList = null;
        for (int i = 0; i < list.size(); i++) {
            w wVar = list.get(i);
            if (wVar instanceof pz) {
                pz pzVar = (pz) wVar;
                if (pzVar.getType() == v.xj.SIMULTANEOUSLY) {
                    this.c.xj(pzVar);
                    pzVar.xj(this);
                }
            }
            if (wVar instanceof v) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((v) wVar);
            }
        }
        this.kd.xj((List<v>) arrayList);
    }
}

package com.bytedance.msdk.w.u;

import android.content.Context;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.msdk.core.kd.hf.u;
import com.bytedance.msdk.f.j;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd extends hf implements com.bytedance.msdk.core.kd.hf.w {
    private u.w hf;
    private final int xj;
    private List<com.bytedance.msdk.core.tf.tf> zg;

    public kd(Context context, int i) {
        super(context);
        this.xj = i;
    }

    @Override // com.bytedance.msdk.w.u.hf, com.bytedance.msdk.w.hf.xj.xj
    public void c() {
        super.c();
        u.w wVar = this.hf;
        if (wVar != null) {
            com.bytedance.msdk.core.tf.hf hfVar = this.c;
            wVar.xj(hfVar != null ? hfVar.ff() : "", true, 0, this.w.f());
        }
    }

    @Override // com.bytedance.msdk.w.u.hf
    public com.bytedance.msdk.w.w.xj.c d() {
        ArrayList arrayList = new ArrayList();
        int i = this.xj;
        if (i == 3) {
            arrayList.add(new com.bytedance.msdk.w.w.xj.d());
        } else if (i == 4) {
            arrayList.add(new com.bytedance.msdk.w.w.xj.tf(this.w, this.c, this.zg));
        } else {
            arrayList.add(new com.bytedance.msdk.w.w.xj.hf());
        }
        com.bytedance.msdk.w.w.xj.c cVar = new com.bytedance.msdk.w.w.xj.c(arrayList);
        cVar.xj(this.w);
        return cVar;
    }

    @Override // com.bytedance.msdk.w.u.hf, com.bytedance.msdk.w.hf.xj.xj
    public void hf(com.bytedance.msdk.api.xj xjVar) {
        super.hf(xjVar);
        u.w wVar = this.hf;
        if (wVar != null) {
            int i = 20005;
            if (xjVar != null && xjVar.xj == 10003) {
                i = AVMDLDataLoader.KeyIsStoRingBufferSizeKB;
            }
            com.bytedance.msdk.core.tf.hf hfVar = this.c;
            wVar.xj(hfVar != null ? hfVar.ff() : "", false, i, null);
        }
    }

    @Override // com.bytedance.msdk.core.kd.hf.w
    public void xj(com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.hf.w wVar, u.w wVar2) {
        this.hf = wVar2;
        xj(hfVar);
        this.w.xj(true);
        this.w.u(true);
        this.w.v().xj(hfVar.xj());
        com.bytedance.msdk.core.tf.hf xj = xj(this.c, wVar);
        this.c = xj;
        this.w.xj(xj);
        this.y.y(1);
        com.bytedance.msdk.core.tf.hf xj2 = com.bytedance.msdk.core.w.w.xj(this.y, this.c);
        if (xj2 != null) {
            this.c = xj2;
            this.w.xj(xj2);
        }
        com.bytedance.msdk.core.tf.hf hfVar2 = this.c;
        if (hfVar2 == null) {
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 预缓存补充请求未发起，mRitConfig为null");
            u.w wVar3 = this.hf;
            if (wVar3 != null) {
                wVar3.xj(this.kd, false, 0, null);
                return;
            }
            return;
        }
        List<com.bytedance.msdk.core.tf.tf> yy = hfVar2.yy();
        if (yy == null || yy.size() <= 0) {
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 预缓存补充请求未发起，过滤后的waterfall为空");
            u.w wVar4 = this.hf;
            if (wVar4 != null) {
                wVar4.xj(this.kd, false, 0, null);
                return;
            }
            return;
        }
        this.c.y((long) (this.c.u() * r6.b()));
        this.c.kd((long) (this.c.w() * r6.r()));
        this.c.hf(false);
        this.c.xj(false);
        List<com.bytedance.msdk.core.tf.tf> yy2 = this.c.yy();
        this.zg = yy2;
        j.xj(yy2, this.qt);
        if (com.bytedance.msdk.xj.kd.w.hf()) {
            com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, "--==-- 预缓存补充请求，过滤后的waterfall：");
            for (com.bytedance.msdk.core.tf.tf tfVar : this.zg) {
                com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.kd) + "waterfall: " + tfVar.qt() + "adnSlotId: " + tfVar.yo() + ", loadSort: " + tfVar.dk() + ", showSort: " + tfVar.et() + ", eCpm: " + tfVar.ra());
            }
        }
        d();
    }

    private com.bytedance.msdk.core.tf.hf xj(com.bytedance.msdk.core.tf.hf hfVar, com.bytedance.msdk.hf.w wVar) {
        if (hfVar == null || wVar == null) {
            return null;
        }
        double da = wVar.da();
        com.bytedance.msdk.xj.kd.w.hf("TMe", "筛选预缓存 ecpm ".concat(String.valueOf(da)));
        com.bytedance.msdk.core.tf.hf clone = hfVar.clone();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (com.bytedance.msdk.core.tf.tf tfVar : clone.yy()) {
            if (tfVar != null && tfVar.a() && tfVar.ra() > da) {
                copyOnWriteArrayList.add(tfVar);
            }
        }
        if (clone.pl()) {
            clone.hf(copyOnWriteArrayList);
            return clone;
        }
        clone.xj(copyOnWriteArrayList);
        return clone;
    }
}

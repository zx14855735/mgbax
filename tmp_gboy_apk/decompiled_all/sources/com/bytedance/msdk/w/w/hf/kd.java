package com.bytedance.msdk.w.w.hf;

import com.bytedance.msdk.f.q;
import com.bytedance.msdk.w.w.hf.xj;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd implements xj.InterfaceC0081xj {
    private com.bytedance.msdk.w.y.hf.hf hf;
    private com.bytedance.msdk.w.y.xj.hf w;
    private List<xj> xj = new CopyOnWriteArrayList();

    public kd(List<xj> list) {
        if (q.xj(list)) {
            return;
        }
        this.xj.addAll(list);
    }

    @Override // com.bytedance.msdk.w.w.hf.xj.InterfaceC0081xj
    public com.bytedance.msdk.w.y.xj.hf hf() {
        return this.w;
    }

    public void xj(com.bytedance.msdk.w.y.xj.hf hfVar, com.bytedance.msdk.w.y.hf.hf hfVar2) {
        this.w = hfVar;
        this.hf = hfVar2;
        if (q.xj(this.xj)) {
            return;
        }
        com.bytedance.msdk.xj.kd.y.xj(new Runnable() { // from class: com.bytedance.msdk.w.w.hf.kd.1
            @Override // java.lang.Runnable
            public void run() {
                ((xj) kd.this.xj.get(0)).xj(kd.this);
            }
        });
    }

    @Override // com.bytedance.msdk.w.w.hf.xj.InterfaceC0081xj
    public com.bytedance.msdk.w.y.hf.hf xj() {
        return this.hf;
    }

    @Override // com.bytedance.msdk.w.w.hf.xj.InterfaceC0081xj
    public void xj(xj xjVar) {
        int indexOf;
        if (q.xj(this.xj) || xjVar == null || (indexOf = this.xj.indexOf(xjVar)) == -1 || indexOf >= this.xj.size() - 1) {
            return;
        }
        this.xj.get(indexOf + 1).xj(this);
    }
}

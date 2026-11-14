package com.bytedance.sdk.component.f.hf.xj;

import com.bytedance.sdk.component.f.hf.xj.hf.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y implements kd {
    private List<com.bytedance.sdk.component.f.hf.xj.hf.xj> xj = new ArrayList();

    public y(Queue<String> queue, com.bytedance.sdk.component.f.xj.kd kdVar) {
        if (com.bytedance.sdk.component.f.hf.hf.xj.xj(kdVar)) {
            this.xj.add(new com.bytedance.sdk.component.f.hf.xj.hf.w(kdVar.c(), queue, kdVar));
        }
        if (com.bytedance.sdk.component.f.hf.hf.xj.kd(kdVar)) {
            this.xj.add(new com.bytedance.sdk.component.f.hf.xj.hf.u(kdVar.xj() != null ? kdVar.xj() : kdVar.f(), queue, kdVar));
        }
        if (com.bytedance.sdk.component.f.hf.hf.xj.hf(kdVar)) {
            this.xj.add(new com.bytedance.sdk.component.f.hf.xj.hf.kd(kdVar.f(), queue, kdVar));
        }
        if (com.bytedance.sdk.component.f.hf.hf.xj.w(kdVar)) {
            this.xj.add(new com.bytedance.sdk.component.f.hf.xj.hf.y(kdVar.f(), queue, kdVar));
        }
        if (com.bytedance.sdk.component.f.hf.hf.xj.u(kdVar)) {
            this.xj.add(new com.bytedance.sdk.component.f.hf.xj.hf.hf(kdVar.d(), queue, kdVar));
        }
        if (com.bytedance.sdk.component.f.hf.hf.xj.y(kdVar)) {
            this.xj.add(new c(kdVar.y(), queue, kdVar));
        }
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.kd
    public List<com.bytedance.sdk.component.f.xj.hf> xj(int i, com.bytedance.sdk.component.f.xj.hf hfVar, boolean z, String str) {
        return null;
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.kd
    public void xj(com.bytedance.sdk.component.f.xj.hf hfVar) {
        Iterator<com.bytedance.sdk.component.f.hf.xj.hf.xj> it = this.xj.iterator();
        while (it.hasNext()) {
            it.next().hf(hfVar);
        }
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.kd
    public hf xj(int i, List<com.bytedance.sdk.component.f.xj.hf> list, int i2) {
        Iterator<com.bytedance.sdk.component.f.hf.xj.hf.xj> it = this.xj.iterator();
        hf hfVar = null;
        while (it.hasNext()) {
            hfVar = it.next().xj(i, list, i2);
            if (hfVar.xj()) {
                break;
            }
        }
        return hfVar;
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.kd
    public List<com.bytedance.sdk.component.f.xj.hf> xj(int i, com.bytedance.sdk.component.f.xj.hf hfVar, boolean z, List<String> list) {
        Iterator<com.bytedance.sdk.component.f.hf.xj.hf.xj> it = this.xj.iterator();
        while (it.hasNext()) {
            int i2 = i;
            com.bytedance.sdk.component.f.xj.hf hfVar2 = hfVar;
            boolean z2 = z;
            List<String> list2 = list;
            List<com.bytedance.sdk.component.f.xj.hf> xj = it.next().xj(i2, hfVar2, z2, list2, "get");
            if (xj != null && xj.size() != 0) {
                return xj;
            }
            i = i2;
            hfVar = hfVar2;
            z = z2;
            list = list2;
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.kd
    public boolean xj(int i, String str, com.bytedance.sdk.component.f.xj.hf hfVar) {
        Iterator<com.bytedance.sdk.component.f.hf.xj.hf.xj> it = this.xj.iterator();
        while (it.hasNext()) {
            if (it.next().xj(i, str, hfVar)) {
                return true;
            }
        }
        return false;
    }
}

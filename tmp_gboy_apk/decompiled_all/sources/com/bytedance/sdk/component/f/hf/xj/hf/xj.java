package com.bytedance.sdk.component.f.hf.xj.hf;

import com.bytedance.sdk.component.f.xj.hf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class xj<T extends com.bytedance.sdk.component.f.xj.hf> extends com.bytedance.sdk.component.f.hf.xj.xj {
    public String hf;
    private Queue<String> kd;
    private Queue<T> u = new ConcurrentLinkedQueue();
    public com.bytedance.sdk.component.f.xj.kd w;
    public com.bytedance.sdk.component.f.hf.u.hf.xj xj;

    public xj(com.bytedance.sdk.component.f.hf.u.hf.xj xjVar, Queue<String> queue, String str, com.bytedance.sdk.component.f.xj.kd kdVar) {
        this.xj = xjVar;
        this.kd = queue;
        this.w = kdVar;
        this.hf = str;
    }

    public void hf(T t) {
        if (this.u == null || t == null || !xj(t)) {
            return;
        }
        this.u.offer(t);
    }

    public com.bytedance.sdk.component.f.hf.xj.hf xj(int i, List<T> list, int i2) {
        com.bytedance.sdk.component.f.hf.xj.hf hfVar = new com.bytedance.sdk.component.f.hf.xj.hf();
        if (list == null || list.size() == 0 || list.get(0) == null || !xj(list.get(0))) {
            hfVar.xj(false);
            return hfVar;
        }
        hf(i, list, i2);
        hfVar.xj(true);
        return hfVar;
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.xj
    public List<com.bytedance.sdk.component.f.xj.hf> hf(int i, com.bytedance.sdk.component.f.xj.hf hfVar, boolean z, List<String> list, String str) {
        ArrayList arrayList = new ArrayList();
        this.u.size();
        do {
            T poll = this.u.poll();
            if (poll == null) {
                break;
            }
            arrayList.add(poll);
        } while (arrayList.size() != this.xj.hf());
        return arrayList;
    }

    private void hf(int i, List<T> list, int i2) {
        com.bytedance.sdk.component.f.xj.hf hfVar;
        int size = this.u.size();
        if ((i == -1 || i == 200 || i == 509 || i == -3) && list != null && list.size() != 0 && size != 0) {
            HashMap hashMap = new HashMap();
            for (T t : this.u) {
                if (t != null) {
                    hashMap.put(t.w(), t);
                }
            }
            for (T t2 : list) {
                if (t2 != null && (hfVar = (com.bytedance.sdk.component.f.xj.hf) hashMap.get(t2.w())) != null) {
                    this.u.remove(hfVar);
                }
            }
        }
        this.u.size();
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.xj
    public boolean xj(String str) {
        return this.u.size() > 0;
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.xj
    public boolean hf(int i, String str, com.bytedance.sdk.component.f.xj.hf hfVar) {
        int size = this.u.size();
        int xj = this.xj.xj();
        com.bytedance.sdk.component.f.hf.w.xj.hf(i);
        return size >= xj;
    }
}

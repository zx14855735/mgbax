package com.bytedance.adsdk.ugeno.kd.xj;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements w {
    private List<u> xj = new CopyOnWriteArrayList();

    @Override // com.bytedance.adsdk.ugeno.kd.xj.w
    public void xj(u uVar) {
        this.xj.add(uVar);
    }

    @Override // com.bytedance.adsdk.ugeno.kd.xj.w
    public void xj(String str) {
        if (this.xj.isEmpty()) {
            return;
        }
        Iterator<u> it = this.xj.iterator();
        while (it.hasNext()) {
            it.next().xj(str);
        }
    }
}

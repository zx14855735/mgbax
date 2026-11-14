package com.bytedance.adsdk.ugeno.kd.hf;

import com.bytedance.adsdk.ugeno.kd.y;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf extends xj {
    private List<com.bytedance.adsdk.ugeno.kd.xj.u> d;

    public hf(com.bytedance.adsdk.ugeno.hf.w wVar, String str, y.xj xjVar) {
        super(wVar, str, xjVar);
        this.d = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.adsdk.ugeno.kd.hf.xj
    public void xj() {
        com.bytedance.adsdk.ugeno.kd.xj.w xj;
        Map<String, String> map = this.y;
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = this.y.get("name");
        com.bytedance.adsdk.ugeno.kd.xj.xj b = this.w.b();
        if (b == null || (xj = b.xj(str)) == null) {
            return;
        }
        xj.xj(str);
    }
}

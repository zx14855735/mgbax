package com.bytedance.adsdk.ugeno.kd.xj;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private volatile Map<String, w> xj = new HashMap();

    public w xj(String str) {
        if (this.xj.containsKey(str) && this.xj.get(str) != null) {
            return this.xj.get(str);
        }
        hf hfVar = new hf();
        this.xj.put(str, hfVar);
        return hfVar;
    }

    public void xj(String str, w wVar) {
        if (!this.xj.containsKey(str) || this.xj.get(str) == null) {
            this.xj.put(str, wVar);
        }
    }
}

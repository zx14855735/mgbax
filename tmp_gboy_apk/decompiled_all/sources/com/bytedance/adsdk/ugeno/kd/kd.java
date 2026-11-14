package com.bytedance.adsdk.ugeno.kd;

import com.bytedance.adsdk.ugeno.kd.y;
import com.sigmob.sdk.base.n;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd implements w {
    @Override // com.bytedance.adsdk.ugeno.kd.w
    public List<hf> xj() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new hf(n.q) { // from class: com.bytedance.adsdk.ugeno.kd.kd.1
            @Override // com.bytedance.adsdk.ugeno.kd.hf
            public com.bytedance.adsdk.ugeno.kd.hf.xj xj(com.bytedance.adsdk.ugeno.hf.w wVar, String str, y.xj xjVar) {
                return new com.bytedance.adsdk.ugeno.kd.hf.kd(wVar, str, xjVar);
            }
        });
        arrayList.add(new hf("emit") { // from class: com.bytedance.adsdk.ugeno.kd.kd.2
            @Override // com.bytedance.adsdk.ugeno.kd.hf
            public com.bytedance.adsdk.ugeno.kd.hf.xj xj(com.bytedance.adsdk.ugeno.hf.w wVar, String str, y.xj xjVar) {
                return new com.bytedance.adsdk.ugeno.kd.hf.hf(wVar, str, xjVar);
            }
        });
        arrayList.add(new hf("startAnimate") { // from class: com.bytedance.adsdk.ugeno.kd.kd.3
            @Override // com.bytedance.adsdk.ugeno.kd.hf
            public com.bytedance.adsdk.ugeno.kd.hf.xj xj(com.bytedance.adsdk.ugeno.hf.w wVar, String str, y.xj xjVar) {
                return new com.bytedance.adsdk.ugeno.kd.hf.u(wVar, str, xjVar);
            }
        });
        return arrayList;
    }
}

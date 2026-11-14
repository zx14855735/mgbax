package com.bytedance.adsdk.ugeno.kd.hf;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.kd.y;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u extends xj {
    public u(com.bytedance.adsdk.ugeno.hf.w wVar, String str, y.xj xjVar) {
        super(wVar, str, xjVar);
    }

    @Override // com.bytedance.adsdk.ugeno.kd.hf.xj
    public void hf() {
    }

    @Override // com.bytedance.adsdk.ugeno.kd.hf.xj
    public void xj() {
        com.bytedance.adsdk.ugeno.hf.w wVar;
        com.bytedance.adsdk.ugeno.hf.w hf;
        com.bytedance.adsdk.ugeno.xj.xj tf;
        Map<String, String> map = this.y;
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = this.y.get("name");
        if (TextUtils.isEmpty(str) || (hf = (wVar = this.w).hf(wVar)) == null || (tf = hf.y(str).tf(str)) == null) {
            return;
        }
        tf.hf();
        tf.xj(new com.bytedance.adsdk.ugeno.xj.hf() { // from class: com.bytedance.adsdk.ugeno.kd.hf.u.1
            @Override // com.bytedance.adsdk.ugeno.xj.hf
            public void hf() {
                u.this.w();
            }

            @Override // com.bytedance.adsdk.ugeno.xj.hf
            public void xj() {
            }
        });
    }
}

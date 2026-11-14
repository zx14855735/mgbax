package com.bytedance.sdk.openadsdk.core.ugeno;

import android.content.Context;
import com.bytedance.adsdk.ugeno.w.hf.u;
import com.bytedance.sdk.component.utils.ht;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y implements u.xj {
    private com.bytedance.adsdk.ugeno.hf.w hf;
    private ht xj;

    public y(Context context, com.bytedance.adsdk.ugeno.hf.w wVar) {
        this.xj = new ht(context, 1, com.bytedance.sdk.openadsdk.core.f.zg().kd());
        this.hf = wVar;
    }

    private int w() {
        JSONObject tf;
        com.bytedance.adsdk.ugeno.hf.w wVar = this.hf;
        if (wVar == null || (tf = wVar.tf()) == null) {
            return 0;
        }
        return tf.optInt("meta_hashcode", 0);
    }

    @Override // com.bytedance.adsdk.ugeno.w.hf.u.xj
    public void hf() {
        ht htVar = this.xj;
        if (htVar != null) {
            htVar.hf(w());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.w.hf.u.xj
    public void xj() {
        ht htVar = this.xj;
        if (htVar != null) {
            htVar.xj(w());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.w.hf.u.xj
    public void xj(float f) {
        ht htVar = this.xj;
        if (htVar != null) {
            htVar.xj(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.w.hf.u.xj
    public void xj(final u.hf hfVar) {
        ht htVar = this.xj;
        if (htVar != null) {
            htVar.xj(new ht.xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.y.1
                @Override // com.bytedance.sdk.component.utils.ht.xj
                public void xj(int i) {
                    u.hf hfVar2 = hfVar;
                    if (hfVar2 != null) {
                        hfVar2.xj(i);
                    }
                }
            });
        }
    }
}

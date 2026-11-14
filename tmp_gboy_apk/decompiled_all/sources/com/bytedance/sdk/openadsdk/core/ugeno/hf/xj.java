package com.bytedance.sdk.openadsdk.core.ugeno.hf;

import android.content.Context;
import com.bytedance.adsdk.ugeno.w.am;
import com.bytedance.adsdk.ugeno.w.ht;
import com.bytedance.adsdk.ugeno.w.pz;
import com.bytedance.sdk.component.utils.ht;
import com.bytedance.sdk.openadsdk.core.f;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends com.bytedance.adsdk.ugeno.kd.w.hf implements ht {
    private com.bytedance.sdk.component.utils.ht p;

    public xj(Context context) {
        super(context);
        this.p = new com.bytedance.sdk.component.utils.ht(context, 1, f.zg().kd());
    }

    private int d() {
        JSONObject xj;
        com.bytedance.adsdk.ugeno.hf.w wVar = this.hf;
        if (wVar == null) {
            return 0;
        }
        JSONObject tf = wVar.tf();
        if (tf != null) {
            return tf.optInt("meta_hashcode", 0);
        }
        am a2 = this.hf.a();
        if (a2 == null || (xj = a2.xj()) == null) {
            return 0;
        }
        return xj.optInt("meta_hashcode", 0);
    }

    @Override // com.bytedance.adsdk.ugeno.w.ht
    public void hf() {
    }

    @Override // com.bytedance.adsdk.ugeno.w.ht
    public void w() {
    }

    @Override // com.bytedance.adsdk.ugeno.w.ht
    public void xj() {
    }

    @Override // com.bytedance.adsdk.ugeno.w.ht
    public void kd() {
        com.bytedance.sdk.component.utils.ht htVar = this.p;
        if (htVar != null) {
            htVar.hf(d());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.w.ht
    public void u() {
        if (this.p == null || !this.hf.d().isShown()) {
            return;
        }
        this.p.xj(new ht.xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.hf.xj.1
            @Override // com.bytedance.sdk.component.utils.ht.xj
            public void xj(int i) {
                if (((com.bytedance.adsdk.ugeno.kd.w.hf) xj.this).xj == null || i != 1) {
                    return;
                }
                ((com.bytedance.adsdk.ugeno.kd.w.hf) xj.this).xj.xj(((com.bytedance.adsdk.ugeno.kd.w.hf) xj.this).hf, ((com.bytedance.adsdk.ugeno.kd.w.hf) xj.this).y, ((com.bytedance.adsdk.ugeno.kd.w.hf) xj.this).w.hf());
            }
        });
        this.p.xj(d());
    }

    @Override // com.bytedance.adsdk.ugeno.w.ht
    public void xj(pz pzVar) {
    }

    @Override // com.bytedance.adsdk.ugeno.w.ht
    public void xj(JSONObject jSONObject) {
    }

    @Override // com.bytedance.adsdk.ugeno.kd.w.hf
    public boolean xj(Object... objArr) {
        Map<String, Object> hf;
        this.hf.xj(this);
        if (this.p == null) {
            this.p = new com.bytedance.sdk.component.utils.ht(this.tf, 1, f.zg().kd());
        }
        am a2 = this.hf.a();
        if (a2 == null || (hf = a2.hf()) == null) {
            return false;
        }
        Object obj = hf.get("shake_value");
        if (obj instanceof Integer) {
            this.p.xj(((Integer) obj).floatValue());
        }
        Object obj2 = hf.get("calculation_method");
        if (obj2 instanceof Integer) {
            this.p.kd(((Integer) obj2).intValue());
        }
        Object obj3 = hf.get("shake_interact_conf");
        if (obj3 instanceof JSONObject) {
            this.p.w((JSONObject) obj3);
        }
        Object obj4 = hf.get("rotation_angle");
        if (obj4 instanceof Integer) {
            this.p.hf(((Integer) obj4).floatValue());
        }
        Object obj5 = hf.get("twist_config");
        if (obj5 instanceof JSONObject) {
            this.p.xj((JSONObject) obj5);
        }
        Object obj6 = hf.get("twist_interact_conf");
        if (obj6 instanceof JSONObject) {
            this.p.hf((JSONObject) obj6);
        }
        Object obj7 = hf.get("calculation_method_twist");
        if (!(obj7 instanceof Integer)) {
            return false;
        }
        this.p.y(((Integer) obj7).intValue());
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.w.ht
    public void xj(boolean z) {
        com.bytedance.sdk.component.utils.ht htVar = this.p;
        if (htVar != null) {
            if (z) {
                htVar.xj(d());
            } else {
                htVar.hf(d());
            }
        }
    }
}

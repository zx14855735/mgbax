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
public class hf extends com.bytedance.adsdk.ugeno.kd.w.hf implements ht {
    private com.bytedance.sdk.component.utils.ht p;

    public hf(Context context) {
        super(context);
        this.p = new com.bytedance.sdk.component.utils.ht(context, 2, f.zg().kd());
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
        this.hf.xj(this);
        if (this.p == null) {
            this.p = new com.bytedance.sdk.component.utils.ht(this.tf, 2, f.zg().kd());
        }
        am a2 = this.hf.a();
        if (a2 == null) {
            return false;
        }
        Map<String, Object> hf = a2.hf();
        if (hf != null) {
            Object obj = hf.get("rotation_angle");
            if (obj instanceof Integer) {
                this.p.hf(((Integer) obj).floatValue());
            }
            Object obj2 = hf.get("calculation_method_twist");
            if (obj2 instanceof Integer) {
                this.p.y(((Integer) obj2).intValue());
            }
            Object obj3 = hf.get("twist_config");
            if (obj3 instanceof JSONObject) {
                this.p.xj((JSONObject) obj3);
            }
            Object obj4 = hf.get("twist_interact_conf");
            if (obj4 instanceof JSONObject) {
                this.p.hf((JSONObject) obj4);
            }
        }
        this.p.xj(new ht.xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.hf.hf.1
            @Override // com.bytedance.sdk.component.utils.ht.xj
            public void xj(int i) {
                if (((com.bytedance.adsdk.ugeno.kd.w.hf) hf.this).xj == null || i != 2) {
                    return;
                }
                ((com.bytedance.adsdk.ugeno.kd.w.hf) hf.this).xj.xj(((com.bytedance.adsdk.ugeno.kd.w.hf) hf.this).hf, ((com.bytedance.adsdk.ugeno.kd.w.hf) hf.this).y, ((com.bytedance.adsdk.ugeno.kd.w.hf) hf.this).w.hf());
            }
        });
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

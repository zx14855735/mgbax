package com.bytedance.msdk.w.w.hf.xj.hf;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.zg.w.w.hf;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd extends hf {
    private com.bytedance.msdk.api.xj.hf hf;
    private com.bytedance.msdk.w.y.hf.hf w;

    public kd(com.bytedance.msdk.w.xj.hf hfVar) {
        super(hfVar);
    }

    private void xj(z zVar, hf.xj xjVar) {
        if (this.hf.qt() > 0.0f) {
            xjVar.xj(this.hf.am()).hf(this.hf.qt());
        } else {
            xjVar.xj(this.hf.am()).hf(0.0f);
        }
        new u().xj(this.w.xj(), zVar, xjVar.xj(), this);
    }

    @Override // com.bytedance.msdk.w.w.hf.xj.hf
    public void hf(Context context, com.bytedance.msdk.w.y.hf.hf hfVar, com.bytedance.msdk.api.xj.hf hfVar2, Map<String, Object> map) {
        z xj;
        this.w = hfVar;
        this.hf = hfVar2;
        if (hfVar2 == null) {
            xj(new com.bytedance.msdk.api.xj("load ad fail adSlot is null"));
            return;
        }
        if (map == null || (xj = xj(context.getApplicationContext())) == null) {
            return;
        }
        hf.xj xj2 = com.bytedance.msdk.xj.w.hf.xj(this.hf, this.w, false);
        int et = this.hf.et();
        int io2 = this.hf.io();
        if (et > 0 && io2 > 0) {
            xj2.xj(et).hf(io2);
        }
        Object obj = map.get("tt_ad_origin_type");
        if (obj == null) {
            xj(new com.bytedance.msdk.api.xj("渲染类型错误"));
            return;
        }
        int intValue = ((Integer) obj).intValue();
        if (intValue == 1) {
            xj(xj, xj2);
        } else if (intValue == 2) {
            hf(xj, xj2);
        } else {
            xj(new com.bytedance.msdk.api.xj("渲染类型错误"));
        }
    }

    private void hf(z zVar, hf.xj xjVar) {
        new w().xj(this.w.xj(), zVar, xjVar.xj(), this);
    }
}

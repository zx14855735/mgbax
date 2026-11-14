package com.bytedance.adsdk.ugeno.kd.w;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.kd.p;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends hf implements com.bytedance.adsdk.ugeno.xj.hf {
    private String p;

    public xj(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.xj.hf
    public void hf() {
        p pVar;
        if ((TextUtils.equals(this.p, "complete") || TextUtils.isEmpty(this.p)) && (pVar = this.xj) != null) {
            pVar.xj(this.hf, this.y, this.w.hf());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.kd.w.hf
    public boolean xj(Object... objArr) {
        com.bytedance.adsdk.ugeno.hf.w wVar;
        com.bytedance.adsdk.ugeno.hf.w hf;
        com.bytedance.adsdk.ugeno.xj.xj tf;
        Map<String, String> map = this.kd;
        if (map != null && map.size() > 0) {
            String str = this.kd.get("name");
            this.p = this.kd.get("state");
            if (!TextUtils.isEmpty(str) && (hf = (wVar = this.hf).hf(wVar)) != null && (tf = hf.y(str).tf(str)) != null) {
                tf.xj(this);
            }
        }
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.xj.hf
    public void xj() {
        p pVar;
        if ((TextUtils.equals(this.p, "start") || TextUtils.isEmpty(this.p)) && (pVar = this.xj) != null) {
            pVar.xj(this.hf, this.y, this.w.hf());
        }
    }
}

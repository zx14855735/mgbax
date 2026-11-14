package com.bytedance.sdk.openadsdk.core.d.xj.hf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.component.utils.hf;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.sigmob.sdk.base.n;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@com.bytedance.sdk.component.p.hf.hf(xj = "SINGLETON")
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class tf implements com.bytedance.sdk.component.p.xj.xj.w {

    @com.bytedance.sdk.component.p.hf.xj(xj = "convert_from_landing_page")
    private boolean c;

    @com.bytedance.sdk.component.p.hf.xj(xj = "pip_controller")
    private com.bytedance.sdk.openadsdk.core.video.hf.hf f;

    @com.bytedance.sdk.component.p.hf.xj(xj = "context")
    private Context hf;

    @com.bytedance.sdk.component.p.hf.xj(xj = "activity_type")
    private int kd;

    @com.bytedance.sdk.component.p.hf.xj(xj = "interaction_type")
    private int u;

    @com.bytedance.sdk.component.p.hf.xj(xj = "url")
    private String w;

    @com.bytedance.sdk.component.p.hf.xj(xj = "material_meta")
    private ws xj;

    @com.bytedance.sdk.component.p.hf.xj(xj = "is_open_web_page")
    private boolean y;

    @Override // com.bytedance.sdk.component.p.xj.xj.w
    public boolean xj(Map<String, Object> map, final Map<String, Object> map2, final com.bytedance.sdk.component.p.xj.xj xjVar) {
        if (this.y) {
            return true;
        }
        if (this.c) {
            xjVar.hf(map2);
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(n.m, this.xj.jf());
            jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.xj.vu()));
            jSONObject.putOpt("req_id", this.xj.zf());
            jSONObject.putOpt("uchain", Boolean.TRUE);
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.core.ht.am.xj().xj("landing_page", "native", 0, jSONObject);
        if (this.u == 2) {
            boolean xj = xj();
            if (xj) {
                xjVar.xj(map2);
            } else {
                xjVar.hf(map2);
            }
            return xj;
        }
        com.bytedance.sdk.openadsdk.core.video.hf.hf hfVar = this.f;
        if (hfVar != null && new com.bytedance.sdk.openadsdk.core.d.xj.xj.hf.hf(hfVar).xj(new HashMap())) {
            xjVar.xj(map2);
            return true;
        }
        Intent intent = new Intent(this.hf, (Class<?>) wo.y(this.kd));
        if (!(this.hf instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        intent.putExtra("is_outer_click", true);
        ws wsVar = this.xj;
        if (wsVar != null) {
            intent.putExtra("get_phone_num_status", wsVar.w());
        }
        if (map == null) {
            com.bytedance.sdk.component.utils.pl.u("UChain_LP", "param == null");
            xjVar.hf(map2);
        }
        map.putAll(map2);
        map.remove("context");
        map.remove("activity_type");
        Object remove = map.remove(n.l);
        wo.xj(map, this.xj);
        int i = -1;
        if (remove != null && !TextUtils.isEmpty(remove.toString())) {
            try {
                i = Integer.parseInt(remove.toString());
            } catch (Exception unused2) {
            }
        }
        intent.putExtra(n.l, i);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                intent.putExtra(entry.getKey(), value.toString());
            }
        }
        com.bytedance.sdk.component.utils.hf.xj(this.hf, intent, new hf.xj() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.hf.tf.1
            @Override // com.bytedance.sdk.component.utils.hf.xj
            public void xj() {
                xjVar.xj(map2);
                map2.put("is_open_web_page", Boolean.TRUE);
            }

            @Override // com.bytedance.sdk.component.utils.hf.xj
            public void xj(Throwable th) {
                xjVar.hf(map2);
            }
        });
        return true;
    }

    private boolean xj() {
        if (!com.bytedance.sdk.component.utils.am.xj(this.w)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse(this.w));
            if (!(this.hf instanceof Activity)) {
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
            }
            com.bytedance.sdk.component.utils.hf.xj(this.hf, intent, null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}

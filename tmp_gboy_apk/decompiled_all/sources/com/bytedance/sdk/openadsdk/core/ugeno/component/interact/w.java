package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.ra.io;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    ws xj;

    public w(ws wsVar) {
        this.xj = wsVar;
    }

    public void hf(final int i) {
        am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.w.3
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("render_type", Integer.valueOf(i));
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().f(w.this.xj.jf()).xj("stats_easy_playable_inject_view").hf(jSONObject.toString());
            }
        }, "stats_easy_playable_inject_view");
    }

    public void xj(final int i, final boolean z) {
        am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.w.1
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("render_type", Integer.valueOf(i));
                jSONObject.putOpt("is_root_container", Boolean.valueOf(z));
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().f(w.this.xj.jf()).xj("stats_easy_playable_render_start").hf(jSONObject.toString());
            }
        }, "stats_easy_playable_render_start");
    }

    public void xj(final int i) {
        am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.w.2
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("render_type", Integer.valueOf(i));
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().f(w.this.xj.jf()).xj("stats_easy_playable_render_exec").hf(jSONObject.toString());
            }
        }, "stats_easy_playable_render_exec");
    }

    public void xj(boolean z, Map<String, Object> map) {
        int i;
        String w = io.w(this.xj);
        if (map != null) {
            Object obj = map.get("render_type");
            if (obj instanceof Integer) {
                int intValue = ((Integer) obj).intValue();
                i = 1;
                if (intValue != 1) {
                    if (intValue == 0) {
                        i = 2;
                    }
                }
                tf.xj(this.xj, z, w, i, map);
            }
        }
        i = -1;
        tf.xj(this.xj, z, w, i, map);
    }
}

package com.bytedance.sdk.openadsdk.core.dislike;

import android.app.Dialog;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.ra.hl;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.zg.w.hf.y;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements com.bytedance.sdk.openadsdk.core.dislike.hf.xj {
    private final ws xj;

    public xj(ws wsVar) {
        this.xj = wsVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dislike.hf.xj
    public boolean xj(String str, Dialog dialog) {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dislike.hf.xj
    public boolean xj(y yVar, String str, Dialog dialog) {
        if (!"7:1".equals(yVar.xj())) {
            return false;
        }
        am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.dislike.xj.1
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                com.bytedance.sdk.openadsdk.core.ht.xj.hf xj = com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("stats_feedback_cannot_close");
                if (xj.this.xj != null) {
                    xj.y(xj.this.xj.zf()).f(xj.this.xj.jf());
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("render_control", hl.hf(xj.this.xj));
                    jSONObject.put("ad_info", xj.this.xj.og());
                    jSONObject.put("render_sequence", hl.hf(xj.this.xj));
                    xj.hf(jSONObject.toString());
                }
                return xj;
            }
        }, "stats_feedback_cannot_close");
        return true;
    }

    public static void xj(com.bytedance.sdk.openadsdk.core.dislike.ui.xj xjVar, ws wsVar) {
        if (xjVar == null || wsVar == null) {
            return;
        }
        xjVar.xj(new xj(wsVar));
    }
}

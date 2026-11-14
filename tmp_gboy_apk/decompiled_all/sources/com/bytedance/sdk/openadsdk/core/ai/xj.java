package com.bytedance.sdk.openadsdk.core.ai;

import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.live.kd.hf;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.x.c;
import com.bytedance.sdk.openadsdk.x.p;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private final int xj;

    public xj(int i) {
        this.xj = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        c.xj(new d("csj-plugin-check") { // from class: com.bytedance.sdk.openadsdk.core.ai.xj.2
            @Override // java.lang.Runnable
            public void run() {
                if (xj.this.hf() == 5) {
                    hf.xj();
                }
            }
        });
    }

    public int hf() {
        return xj(4);
    }

    public void kd() {
        JSONObject m6if = pz.hf().m6if();
        if (m6if == null) {
            return;
        }
        try {
            xj(m6if, "com.byted.live.lite", 4, true);
            xj(m6if, "com.byted.csj.ext", 8, true);
            xj(m6if, "com.byted.mixed", 0, true);
            xj(m6if, "com.byted.pangle", 0, false);
        } catch (Throwable th) {
            pl.hf("onReceiveServerStatus", th);
        }
    }

    public String toString() {
        return String.valueOf(this.xj);
    }

    public int u() {
        return 2;
    }

    public int w() {
        return xj(8);
    }

    public int xj(int i) {
        int i2 = this.xj >> i;
        int i3 = i2 & 7;
        return i3 == 0 ? u() : ((i2 & 8) >> 3) == 1 ? -i3 : i3;
    }

    public xj(int i, boolean z) {
        this.xj = i;
        f.xj().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ai.xj.1
            @Override // java.lang.Runnable
            public void run() {
                xj.this.y();
            }
        }, PushUIConfig.dismissTime);
    }

    public int xj() {
        return xj(0);
    }

    public int xj(String str) {
        if ("com.byted.live.lite".equals(str)) {
            if (pz.hf().pu()) {
                return hf();
            }
            return 4;
        }
        if ("com.byted.csj.ext".equals(str)) {
            return w();
        }
        if ("com.byted.pangle".equals(str)) {
            return xj();
        }
        return u();
    }

    private void xj(JSONObject jSONObject, String str, int i, boolean z) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return;
        }
        int optInt = optJSONObject.optInt("state", 2);
        if (optInt == 5) {
            int hf = p.hf(str);
            int w = p.w(str);
            int u = p.u(str);
            if (z || w > u) {
                String optString = optJSONObject.optString("api_rule", "=");
                String optString2 = optJSONObject.optString("plugin_rule", "=");
                int optInt2 = optJSONObject.optInt("api_v", 0);
                int optInt3 = optJSONObject.optInt("plugin_v", 0);
                if (xj(hf, optInt2, optString) && xj(w, optInt3, optString2)) {
                    p.xj(str);
                    return;
                }
                return;
            }
            return;
        }
        if (optInt == -1 && xj(i) == 5 && p.w(str) > p.u(str)) {
            p.xj(str);
        }
    }

    private boolean xj(int i, int i2, String str) {
        str.getClass();
        switch (str) {
            case "<":
                return i < i2;
            case "=":
            case "==":
                return i == i2;
            case ">":
                return i > i2;
            case "<=":
                return i <= i2;
            case ">=":
                return i >= i2;
            default:
                return false;
        }
    }
}

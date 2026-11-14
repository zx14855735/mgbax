package com.bytedance.sdk.openadsdk.core.component.reward.view.ugen;

import android.os.Looper;
import android.os.Message;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.adsdk.ugeno.w.ht;
import com.bytedance.sdk.component.adexpress.hf.c;
import com.bytedance.sdk.component.adexpress.hf.f;
import com.bytedance.sdk.component.utils.ai;
import com.bytedance.sdk.openadsdk.core.nativeexpress.yo;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ugeno.express.hf;
import com.bytedance.sdk.openadsdk.core.ugeno.express.xj.hf;
import com.bytedance.sdk.openadsdk.core.ugeno.express.y;
import com.bytedance.sdk.openadsdk.core.ugeno.tf;
import com.bytedance.sdk.openadsdk.core.ugeno.w;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements ai.xj {
    private y hf;
    private f kd;
    private c u;
    private final ws w;
    ai xj = new ai(Looper.getMainLooper(), this);
    private hf y;

    public xj(ws wsVar) {
        this.w = wsVar;
    }

    public void xj(f fVar) {
        this.kd = fVar;
    }

    public void xj(c cVar) {
        this.u = cVar;
    }

    public void xj(hf hfVar) {
        this.y = hfVar;
    }

    public void xj(String str, String str2, final int i, final int i2, int i3) {
        if (i3 > 0) {
            this.xj.sendEmptyMessageDelayed(1, i3);
        }
        tf.xj(str, str2, new w() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.xj.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.w
            public void xj(String str3) {
                try {
                    xj xjVar = xj.this;
                    xjVar.xj(xjVar.w, new JSONObject(str3), i, i2);
                } catch (Throwable unused) {
                    if (xj.this.u != null) {
                        xj.this.u.xj(-1, "render fail");
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.w
            public void xj() {
                if (xj.this.u != null) {
                    xj.this.u.xj(-1, "request fail");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(ws wsVar, JSONObject jSONObject, int i, int i2) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(MediaFormat.KEY_WIDTH, i);
            jSONObject2.put(MediaFormat.KEY_HEIGHT, i2);
        } catch (Throwable unused) {
        }
        hf.xj xjVar = new hf.xj();
        xjVar.xj(com.bytedance.sdk.openadsdk.core.nativeexpress.hf.hf.xj(wsVar, jSONObject2, jSONObject, false, null));
        xjVar.xj((ht) new yo());
        xjVar.xj(i);
        xjVar.hf(0.0f);
        y yVar = new y(pz.getContext(), null, xjVar.xj(), null);
        this.hf = yVar;
        c cVar = this.u;
        if (cVar != null) {
            yVar.xj(cVar);
        }
        f fVar = this.kd;
        if (fVar != null) {
            this.hf.xj(fVar);
        }
        com.bytedance.sdk.openadsdk.core.ugeno.express.xj.hf hfVar = this.y;
        if (hfVar != null) {
            this.hf.xj(hfVar);
        }
    }

    @Override // com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
        c cVar;
        if (message.what == 1 && (cVar = this.u) != null) {
            cVar.xj(-2, "render timeout");
        }
    }
}

package com.bytedance.sdk.openadsdk.core.v.xj;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.xj.u;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ai extends com.bytedance.sdk.component.xj.u<JSONObject, JSONObject> {
    private ws hf;
    private long u;
    private com.bytedance.sdk.openadsdk.core.jk.kd w;
    private WeakReference<com.bytedance.sdk.openadsdk.core.j> xj;

    public ai(com.bytedance.sdk.openadsdk.core.j jVar, ws wsVar) {
        this.xj = new WeakReference<>(jVar);
        this.hf = wsVar;
    }

    @Override // com.bytedance.sdk.component.xj.u
    public void u() {
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, final com.bytedance.sdk.openadsdk.core.j jVar, final ws wsVar) {
        eVar.xj("requestVideoDelayCallback", new u.hf() { // from class: com.bytedance.sdk.openadsdk.core.v.xj.ai.1
            @Override // com.bytedance.sdk.component.xj.u.hf
            public com.bytedance.sdk.component.xj.u xj() {
                return new ai(com.bytedance.sdk.openadsdk.core.j.this, wsVar);
            }
        });
    }

    @Override // com.bytedance.sdk.component.xj.u
    public void xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        com.bytedance.sdk.openadsdk.core.j jVar = this.xj.get();
        if (jVar != null && jSONObject != null) {
            this.w = new com.bytedance.sdk.openadsdk.core.jk.kd() { // from class: com.bytedance.sdk.openadsdk.core.v.xj.ai.2
                @Override // com.bytedance.sdk.openadsdk.core.jk.kd
                public void xj() {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.v.xj.ai.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                ai.this.xj((ai) new JSONObject());
                            } catch (Exception e) {
                                com.bytedance.sdk.component.utils.pl.u("requestVideoDelay", e.getMessage());
                            }
                        }
                    }, ai.this.u);
                }
            };
            int optInt = jSONObject.optInt("delay", -1);
            if (optInt < 0) {
                return;
            }
            this.u = optInt;
            if (jVar.w() != null && jVar.w().E_()) {
                this.w.xj();
                return;
            } else {
                jVar.xj(this.w);
                return;
            }
        }
        w();
    }
}

package com.bytedance.sdk.openadsdk.core.ugeno.c;

import com.bytedance.sdk.openadsdk.core.et.hf;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd {

    public interface xj {
        void xj(JSONObject jSONObject);
    }

    public static void xj(com.bytedance.sdk.openadsdk.core.ugeno.y.xj xjVar, xj xjVar2) {
        if (xjVar == null) {
            if (xjVar2 != null) {
                xjVar2.xj(null);
            }
        } else {
            xj(xjVar.w(), xjVar.xj(), xjVar.hf(), xjVar2);
        }
    }

    public static void xj(String str, String str2, String str3, final xj xjVar) {
        JSONObject xj2 = com.bytedance.sdk.openadsdk.core.ugeno.c.xj().xj(str2, str3);
        if (xj2 == null) {
            com.bytedance.sdk.openadsdk.core.et.hf.xj(str, str2, str3, new hf.InterfaceC0163hf() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.c.kd.1
                @Override // com.bytedance.sdk.openadsdk.core.et.hf.InterfaceC0163hf
                public void xj(JSONObject jSONObject) {
                    xj xjVar2 = xj.this;
                    if (xjVar2 != null) {
                        xjVar2.xj(jSONObject);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.et.hf.InterfaceC0163hf
                public void xj() {
                    xj xjVar2 = xj.this;
                    if (xjVar2 != null) {
                        xjVar2.xj(null);
                    }
                }
            });
        } else if (xjVar != null) {
            xjVar.xj(xj2);
        }
    }
}

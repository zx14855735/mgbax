package com.bytedance.sdk.component.hf.xj.xj.xj;

import com.bytedance.sdk.component.hf.xj.g;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements xj {
    private String hf(com.bytedance.sdk.component.hf.xj.hf hfVar) {
        return hfVar.xj().hf().toString();
    }

    @Override // com.bytedance.sdk.component.hf.xj.xj.xj.xj
    public void xj(com.bytedance.sdk.component.hf.xj.hf hfVar, InetSocketAddress inetSocketAddress, Proxy proxy, g gVar, IOException iOException) {
        try {
            ((com.bytedance.sdk.component.u.c) com.bytedance.sdk.openadsdk.ats.w.xj("event")).onExceptionEvent("okhttp_connectFailed", xj(hfVar), iOException);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.hf.xj.xj.xj.xj
    public void xj(com.bytedance.sdk.component.hf.xj.hf hfVar, IOException iOException) {
        try {
            ((com.bytedance.sdk.component.u.c) com.bytedance.sdk.openadsdk.ats.w.xj("event")).onExceptionEvent("okhttp_callFailed", xj(hfVar), iOException);
        } catch (Exception unused) {
        }
    }

    private JSONObject xj(com.bytedance.sdk.component.hf.xj.hf hfVar) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("url", hf(hfVar));
        return jSONObject;
    }
}

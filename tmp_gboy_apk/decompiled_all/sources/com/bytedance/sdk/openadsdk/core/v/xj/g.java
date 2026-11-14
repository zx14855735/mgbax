package com.bytedance.sdk.openadsdk.core.v.xj;

import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class g extends com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject> {
    private ws hf;
    private WeakReference<com.bytedance.sdk.openadsdk.core.j> xj;

    public g(com.bytedance.sdk.openadsdk.core.j jVar, ws wsVar) {
        this.xj = new WeakReference<>(jVar);
        this.hf = wsVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
    
        r0 = r0.getRootWindowInsets();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.json.JSONObject w() {
        /*
            r4 = this;
            java.lang.ref.WeakReference<com.bytedance.sdk.openadsdk.core.j> r0 = r4.xj
            if (r0 != 0) goto L5
            goto L6b
        L5:
            java.lang.Object r0 = r0.get()
            com.bytedance.sdk.openadsdk.core.j r0 = (com.bytedance.sdk.openadsdk.core.j) r0
            if (r0 != 0) goto Le
            goto L6b
        Le:
            android.content.Context r0 = r0.getContext()
            if (r0 != 0) goto L15
            goto L6b
        L15:
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L6b
            android.app.Activity r0 = (android.app.Activity) r0
            android.view.Window r0 = r0.getWindow()
            if (r0 != 0) goto L22
            goto L6b
        L22:
            android.view.View r0 = r0.getDecorView()
            if (r0 != 0) goto L29
            goto L6b
        L29:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 < r2) goto L6b
            android.view.WindowInsets r0 = com.bytedance.pangle.wrapper.AMqCpz.AaHO0E(r0)
            if (r0 != 0) goto L36
            goto L6b
        L36:
            android.view.DisplayCutout r0 = CASmeH.ASJ6gh.AaHO0E(r0)
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L64
            r1.<init>()     // Catch: org.json.JSONException -> L64
            java.lang.String r2 = "top"
            int r3 = I3HV03.ADYaiT.A5SV6n(r0)     // Catch: org.json.JSONException -> L64
            r1.put(r2, r3)     // Catch: org.json.JSONException -> L64
            java.lang.String r2 = "bottom"
            int r3 = com.bytedance.sdk.openadsdk.core.v.xj.A2egSU.A2egSU(r0)     // Catch: org.json.JSONException -> L64
            r1.put(r2, r3)     // Catch: org.json.JSONException -> L64
            java.lang.String r2 = "left"
            int r3 = com.bytedance.sdk.openadsdk.core.v.xj.A2egSU.ADYaiT(r0)     // Catch: org.json.JSONException -> L64
            r1.put(r2, r3)     // Catch: org.json.JSONException -> L64
            java.lang.String r2 = "right"
            int r0 = com.bytedance.sdk.openadsdk.core.v.xj.A2egSU.AMqCpz(r0)     // Catch: org.json.JSONException -> L64
            r1.put(r2, r0)     // Catch: org.json.JSONException -> L64
            return r1
        L64:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            r1.<init>(r0)
            throw r1
        L6b:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.v.xj.g.w():org.json.JSONObject");
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, ws wsVar, com.bytedance.sdk.openadsdk.core.j jVar) {
        eVar.xj("getDeviceInfo", (com.bytedance.sdk.component.xj.kd<?, ?>) new g(jVar, wsVar));
    }

    @Override // com.bytedance.sdk.component.xj.kd
    public JSONObject xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.putOpt("safeArea", w());
        ws wsVar = this.hf;
        if (wsVar != null) {
            jSONObject2.put("disableSafeArea", wsVar.u());
        }
        return jSONObject2;
    }
}

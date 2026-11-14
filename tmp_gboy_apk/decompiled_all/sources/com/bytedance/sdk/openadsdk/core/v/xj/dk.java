package com.bytedance.sdk.openadsdk.core.v.xj;

import com.baidu.mobads.sdk.internal.cb;
import com.bytedance.sdk.component.widget.SSWebView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class dk extends com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject> {
    private WeakReference<SSWebView> xj;

    public dk(SSWebView sSWebView) {
        this.xj = new WeakReference<>(sSWebView);
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, SSWebView sSWebView) {
        eVar.xj("preventTouchEvent", (com.bytedance.sdk.component.xj.kd<?, ?>) new dk(sSWebView));
    }

    @Override // com.bytedance.sdk.component.xj.kd
    public JSONObject xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            boolean optBoolean = jSONObject.optBoolean("isPrevent", false);
            SSWebView sSWebView = this.xj.get();
            if (sSWebView != null) {
                sSWebView.setIsPreventTouchEvent(optBoolean);
                jSONObject2.put(cb.o, true);
                return jSONObject2;
            }
            jSONObject2.put(cb.o, false);
            return jSONObject2;
        } catch (Throwable unused) {
            jSONObject2.put(cb.o, false);
            return jSONObject2;
        }
    }
}

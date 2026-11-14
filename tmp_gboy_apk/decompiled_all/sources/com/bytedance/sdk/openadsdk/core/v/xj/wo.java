package com.bytedance.sdk.openadsdk.core.v.xj;

import com.baidu.mobads.sdk.internal.cb;
import com.bytedance.sdk.component.widget.SSWebView;
import com.czhj.sdk.common.Database.SQLiteMTAHelper;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class wo extends com.bytedance.sdk.component.xj.kd<JSONObject, JSONObject> {
    private String hf;
    private com.bytedance.sdk.openadsdk.core.j w;
    private SSWebView xj;

    public wo(SSWebView sSWebView, String str, com.bytedance.sdk.openadsdk.core.j jVar) {
        this.xj = sSWebView;
        this.hf = str;
        this.w = jVar;
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, SSWebView sSWebView, com.bytedance.sdk.openadsdk.core.j jVar) {
        eVar.xj("closeWebview", (com.bytedance.sdk.component.xj.kd<?, ?>) new wo(sSWebView, "closeWebview", jVar));
        eVar.xj("makeVisible", (com.bytedance.sdk.component.xj.kd<?, ?>) new wo(sSWebView, "makeVisible", jVar));
        eVar.xj("getCurrentVisibleState", (com.bytedance.sdk.component.xj.kd<?, ?>) new wo(sSWebView, "getCurrentVisibleState", jVar));
        eVar.xj("changeSize", (com.bytedance.sdk.component.xj.kd<?, ?>) new wo(sSWebView, "changeSize", jVar));
        eVar.xj("changeFrame", (com.bytedance.sdk.component.xj.kd<?, ?>) new wo(sSWebView, "changeFrame", jVar));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bytedance.sdk.component.xj.kd
    public JSONObject xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        JSONObject jSONObject2;
        int i;
        int i2;
        int i3;
        jSONObject2 = new JSONObject();
        String str = this.hf;
        str.getClass();
        switch (str) {
            case "changeSize":
                JSONArray optJSONArray = jSONObject.optJSONArray("size");
                if (optJSONArray != null && optJSONArray.length() == 2) {
                    int optInt = optJSONArray.optInt(0);
                    int optInt2 = optJSONArray.optInt(1);
                    com.bytedance.sdk.openadsdk.core.j jVar = this.w;
                    if (jVar != null) {
                        jVar.xj(optInt, optInt2);
                    }
                }
                return jSONObject2;
            case "changeFrame":
                JSONArray optJSONArray2 = jSONObject.optJSONArray(SQLiteMTAHelper.TABLE_POINT);
                JSONArray optJSONArray3 = jSONObject.optJSONArray("size");
                int i4 = Integer.MAX_VALUE;
                if (optJSONArray2 == null || optJSONArray2.length() != 2) {
                    i = Integer.MAX_VALUE;
                    i2 = Integer.MAX_VALUE;
                } else {
                    i2 = optJSONArray2.optInt(0);
                    i = optJSONArray2.optInt(1);
                }
                if (optJSONArray3 == null || optJSONArray3.length() != 2) {
                    i3 = Integer.MAX_VALUE;
                } else {
                    i4 = optJSONArray3.optInt(0);
                    i3 = optJSONArray3.optInt(1);
                }
                com.bytedance.sdk.openadsdk.core.j jVar2 = this.w;
                if (jVar2 != null) {
                    jVar2.xj(i2, i, i4, i3);
                    return jSONObject2;
                }
                return jSONObject2;
            case "getCurrentVisibleState":
                jSONObject2.put("visibleState", !com.bytedance.sdk.openadsdk.core.l.hf(this.xj, 50, 5) ? 1 : 0);
                return jSONObject2;
            case "closeWebview":
                com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.v.xj.wo.1
                    @Override // java.lang.Runnable
                    public void run() {
                        wo.this.xj.setVisibility(8);
                    }
                });
                com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d w = this.w.w();
                if (w != null) {
                    w.hf();
                    jSONObject2.put(cb.o, true);
                    return jSONObject2;
                }
                jSONObject2.put(cb.o, false);
                return jSONObject2;
            case "makeVisible":
                if (this.xj != null) {
                    jSONObject2.put(cb.o, true);
                    com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.v.xj.wo.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (wo.this.xj != null) {
                                wo.this.xj.setVisibility(0);
                            }
                            com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d w2 = wo.this.w.w();
                            if (w2 != null) {
                                w2.F_();
                            }
                        }
                    });
                    return jSONObject2;
                }
                jSONObject2.put(cb.o, false);
                return jSONObject2;
            default:
                return jSONObject2;
        }
    }
}

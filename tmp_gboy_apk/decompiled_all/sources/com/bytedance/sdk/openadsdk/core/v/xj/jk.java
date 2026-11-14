package com.bytedance.sdk.openadsdk.core.v.xj;

import com.bytedance.sdk.component.xj.u;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class jk extends com.bytedance.sdk.component.xj.u<JSONObject, JSONObject> {
    private WeakReference<com.bytedance.sdk.openadsdk.core.j> xj;

    public jk(com.bytedance.sdk.openadsdk.core.j jVar) {
        this.xj = new WeakReference<>(jVar);
    }

    @Override // com.bytedance.sdk.component.xj.u
    public void u() {
        this.xj = null;
    }

    public static void xj(com.bytedance.sdk.component.xj.e eVar, final com.bytedance.sdk.openadsdk.core.j jVar) {
        eVar.xj("mallTopbarClick", new u.hf() { // from class: com.bytedance.sdk.openadsdk.core.v.xj.jk.1
            @Override // com.bytedance.sdk.component.xj.u.hf
            public com.bytedance.sdk.component.xj.u xj() {
                return new jk(com.bytedance.sdk.openadsdk.core.j.this);
            }
        });
    }

    @Override // com.bytedance.sdk.component.xj.u
    public void xj(JSONObject jSONObject, com.bytedance.sdk.component.xj.y yVar) {
        com.bytedance.sdk.openadsdk.core.f.zg().yy();
        WeakReference<com.bytedance.sdk.openadsdk.core.j> weakReference = this.xj;
        if (weakReference == null) {
            return;
        }
        if (weakReference.get() != null && jSONObject != null) {
            String optString = jSONObject.optString("schema");
            if (optString.isEmpty()) {
                w();
                return;
            } else {
                xj(optString, jSONObject.optBoolean("sync_auth", false));
                return;
            }
        }
        w();
    }

    private void xj(final String str, boolean z) {
        final JSONObject jSONObject = new JSONObject();
        if (2 == com.bytedance.sdk.openadsdk.core.live.hf.xj().kd()) {
            xj(str, jSONObject);
            return;
        }
        int xj = com.bytedance.sdk.openadsdk.core.live.hf.xj().xj(new com.bytedance.sdk.openadsdk.core.live.hf.hf() { // from class: com.bytedance.sdk.openadsdk.core.v.xj.jk.2
            @Override // com.bytedance.sdk.openadsdk.core.live.hf.hf
            public void xj(Object obj) {
                if (obj instanceof Map) {
                    Map map = (Map) obj;
                    if (map.containsKey(PluginConstants.KEY_ERROR_CODE)) {
                        Object obj2 = map.get(PluginConstants.KEY_ERROR_CODE);
                        if (obj2 instanceof String) {
                            try {
                                int parseInt = Integer.parseInt((String) obj2);
                                if (parseInt == 1) {
                                    jk.this.xj(str, jSONObject);
                                    return;
                                }
                                try {
                                    jSONObject.putOpt(PluginConstants.KEY_ERROR_CODE, Integer.valueOf(parseInt));
                                } catch (JSONException unused) {
                                }
                                jk.this.xj(parseInt, "授权失败");
                                jk.this.xj((jk) jSONObject);
                                return;
                            } catch (NumberFormatException unused2) {
                            }
                        }
                    }
                }
                try {
                    jSONObject.putOpt(PluginConstants.KEY_ERROR_CODE, -1);
                } catch (JSONException unused3) {
                }
                jk.this.xj(-1, "授权失败");
                jk.this.xj((jk) jSONObject);
            }
        }, z);
        jSONObject.putOpt(PluginConstants.KEY_ERROR_CODE, Integer.valueOf(xj));
        if (xj != 1) {
            xj(xj, "执行授权失败");
            xj((jk) jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(String str, JSONObject jSONObject) {
        int xj = com.bytedance.sdk.openadsdk.core.live.hf.xj().xj(str);
        try {
            jSONObject.putOpt(PluginConstants.KEY_ERROR_CODE, Integer.valueOf(xj));
        } catch (JSONException unused) {
        }
        if (xj != 1) {
            xj(xj, "schema 解析失败");
        }
        xj((jk) jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i, String str) {
        com.bytedance.sdk.component.utils.pl.hf("MallTopBarClickMethod", "code = " + i + ", msg = " + str);
        com.bytedance.sdk.component.utils.x.xj(com.bytedance.sdk.openadsdk.core.pz.getContext(), "努力加载中，请稍后再试", 1);
    }
}

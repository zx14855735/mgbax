package com.kwad.sdk.core.b.a;

import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.kwad.sdk.core.h.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ll implements com.kwad.sdk.core.d<a.C0365a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0365a c0365a, JSONObject jSONObject) {
        a2(c0365a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0365a c0365a, JSONObject jSONObject) {
        return b2(c0365a, jSONObject);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static void a2(a.C0365a c0365a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0365a.aOM = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray(PluginConstants.KEY_SDK_VERSION);
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                c0365a.aOM.add((String) optJSONArray.opt(i));
            }
        }
        c0365a.aON = jSONObject.optInt("os_version");
        c0365a.aOO = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("abi");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                c0365a.aOO.add((String) optJSONArray2.opt(i2));
            }
        }
        c0365a.aOP = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray(com.baidu.mobads.sdk.internal.bn.j);
        if (optJSONArray3 != null) {
            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                c0365a.aOP.add((String) optJSONArray3.opt(i3));
            }
        }
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0365a c0365a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, PluginConstants.KEY_SDK_VERSION, c0365a.aOM);
        int i = c0365a.aON;
        if (i != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "os_version", i);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "abi", c0365a.aOO);
        com.kwad.sdk.utils.aa.putValue(jSONObject, com.baidu.mobads.sdk.internal.bn.j, c0365a.aOP);
        return jSONObject;
    }
}

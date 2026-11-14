package com.bytedance.sdk.openadsdk.core.nativeexpress;

import com.bytedance.sdk.openadsdk.core.j;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class c {
    public static void xj(NativeExpressView nativeExpressView) {
        if (nativeExpressView == null) {
            return;
        }
        j jsObject = nativeExpressView.getJsObject();
        if (jsObject != null) {
            jsObject.xj("notifyAdClicked", (JSONObject) null);
        }
        com.bytedance.sdk.openadsdk.core.ugeno.express.y uGenV3Render = nativeExpressView.getUGenV3Render();
        if (uGenV3Render != null) {
            uGenV3Render.xj("notifyAdClicked", (Map<String, String>) null);
        }
    }
}

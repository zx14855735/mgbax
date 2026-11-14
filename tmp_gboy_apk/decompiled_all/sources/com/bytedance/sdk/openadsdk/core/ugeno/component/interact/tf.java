package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.view.View;
import com.baidu.mobads.sdk.internal.cb;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ra.ra;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class tf {
    private static boolean xj(int i, int i2, int i3, int i4, float f, float f2) {
        return f >= ((float) i) && f <= ((float) (i3 + i)) && f2 >= ((float) i2) && f2 <= ((float) (i4 + i2));
    }

    public static boolean xj(View view, com.bytedance.sdk.component.adexpress.w wVar) {
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int width = view.getWidth();
            int height = view.getHeight();
            if (wVar instanceof ra) {
                ra raVar = (ra) wVar;
                return xj(i, i2, width, height, raVar.xj, raVar.hf);
            }
        }
        return false;
    }

    public static String xj(com.bytedance.sdk.component.adexpress.w wVar) {
        JSONObject xj;
        if (!(wVar instanceof ra) || (xj = ((ra) wVar).xj()) == null) {
            return null;
        }
        return xj.optString("ugen_id");
    }

    public static void xj(ws wsVar, boolean z, String str, int i, Map<String, Object> map) {
        JSONObject xj = wo.xj(map);
        if (xj == null) {
            xj = new JSONObject();
        }
        try {
            xj.put(cb.o, z ? 1 : 0);
            xj.put("style_type", i);
            xj.put("style_id", str);
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.core.am.u.xj(wsVar, "easy_play_show", xj);
    }

    public static void xj(ws wsVar, boolean z, String str, int i, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("area_type", z ? 1 : 2);
            jSONObject.put("style_type", i);
            jSONObject.put("style_id", str);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        com.bytedance.sdk.openadsdk.core.am.u.xj(wsVar, "easy_play_click", jSONObject);
    }
}

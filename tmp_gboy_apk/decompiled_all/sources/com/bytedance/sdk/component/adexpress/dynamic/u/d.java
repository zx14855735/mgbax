package com.bytedance.sdk.component.adexpress.dynamic.u;

import ADYaiT.CtFAbx;
import com.bytedance.sdk.component.utils.pl;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d {
    public static String hf(String str, String str2) {
        if (!com.bytedance.sdk.component.adexpress.u.xj()) {
            return xj.xj(str);
        }
        if (str.indexOf(46) < 0) {
            str = str.concat(".png");
        }
        return CtFAbx.AlLFFp(str2, "static/images/", str);
    }

    public static void xj(String str, JSONObject jSONObject) {
        JSONObject cy = com.bytedance.sdk.component.adexpress.hf.cy(str);
        if (cy == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject optJSONObject = cy.optJSONObject("values");
        if (optJSONObject == null) {
            return;
        }
        xj(optJSONObject, jSONObject);
    }

    public static JSONObject xj(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject cy = com.bytedance.sdk.component.adexpress.hf.cy(str);
        if (cy == null) {
            return null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        return xj(jSONObject2, cy.optJSONObject("themeValues"), jSONObject);
    }

    private static void xj(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        if (jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!jSONObject2.has(next)) {
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    pl.xj(e);
                }
            }
        }
    }

    public static JSONObject xj(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        for (JSONObject jSONObject2 : jSONObjectArr) {
            if (jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        jSONObject.put(next, jSONObject2.opt(next));
                    } catch (JSONException e) {
                        pl.xj(e);
                    }
                }
            }
        }
        return jSONObject;
    }

    public static String xj(String str) {
        JSONObject optJSONObject;
        JSONObject cy = com.bytedance.sdk.component.adexpress.hf.cy(str);
        if (cy == null || (optJSONObject = cy.optJSONObject("values")) == null) {
            return null;
        }
        return optJSONObject.optString(PointParamKey.DATA);
    }

    public static String xj(String str, String str2) {
        JSONObject optJSONObject;
        JSONObject cy = com.bytedance.sdk.component.adexpress.hf.cy(str);
        if (cy == null || (optJSONObject = cy.optJSONObject("values")) == null) {
            return null;
        }
        return optJSONObject.optString(str2);
    }

    public static JSONObject xj(JSONArray jSONArray) {
        JSONObject optJSONObject;
        if (jSONArray == null || jSONArray.length() <= 0 || (optJSONObject = jSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return optJSONObject.optJSONObject("values");
    }
}

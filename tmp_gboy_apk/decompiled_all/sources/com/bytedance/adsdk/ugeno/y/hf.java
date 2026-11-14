package com.bytedance.adsdk.ugeno.y;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    public static void xj(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                jSONObject2.put(next, jSONObject.opt(next));
            } catch (JSONException e) {
                pl.xj(e);
            }
        }
    }

    public static JSONObject xj(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                pl.xj(e);
            }
        }
        return jSONObject;
    }

    public static JSONArray xj(String str, JSONArray jSONArray) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONArray(str);
            } catch (JSONException unused) {
            }
        }
        return jSONArray;
    }

    public static void xj(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray2 == null || jSONArray2.length() <= 0) {
            return;
        }
        if (jSONArray == null) {
            jSONArray = new JSONArray();
        }
        for (int i = 0; i < jSONArray2.length(); i++) {
            Object opt = jSONArray2.opt(i);
            if (opt != null) {
                jSONArray.put(opt);
            }
        }
    }
}

package com.kwad.sdk.collector;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class g {
    public static int PERMISSION_DENIED = 2;
    public static int PERMISSION_GRANTED = 1;
    public static int azs;
    private String azr;
    private int state;

    public g(String str, int i) {
        this.azr = str;
        this.state = i;
    }

    private String Fv() {
        int lastIndexOf;
        String str = this.azr;
        return !TextUtils.isEmpty(str) ? ((str.startsWith("com.android.") || str.startsWith("android.permission")) && (lastIndexOf = str.lastIndexOf(".")) < str.length() + (-1)) ? str.substring(lastIndexOf + 1) : str : str;
    }

    private JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", Fv());
            jSONObject.put("state", this.state);
            return jSONObject;
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return jSONObject;
        }
    }

    public static JSONArray w(List<g> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            Iterator<g> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJson());
            }
        }
        return jSONArray;
    }
}

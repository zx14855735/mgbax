package com.kwad.sdk.liteapi;

import android.content.Context;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a {
    public static String doSign(Context context, String str) {
        return KWEGIDDFP.doSign(context, str);
    }

    public static void handlePolicy(JSONObject jSONObject) {
        KWEGIDDFP.handlePolicy(jSONObject);
    }
}

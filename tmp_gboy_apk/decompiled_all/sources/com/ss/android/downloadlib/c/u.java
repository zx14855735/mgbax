package com.ss.android.downloadlib.c;

import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class u {
    public static String xj(String str, String str2, boolean z, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(BaseConstants.EVENT_LABEL_EXTRA, str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("notification_jump_url", str2);
            }
            jSONObject.put("show_toast", z);
            jSONObject.put("business_type", str3);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        return jSONObject.toString();
    }
}

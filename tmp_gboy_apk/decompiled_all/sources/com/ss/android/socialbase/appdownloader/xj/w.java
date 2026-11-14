package com.ss.android.socialbase.appdownloader.xj;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class w extends xj {
    private final JSONObject u;

    public w(Context context, com.ss.android.socialbase.downloader.f.xj xjVar, String str, JSONObject jSONObject) {
        super(context, xjVar, str);
        this.u = jSONObject;
    }

    private static void xj(Intent intent, JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> keys;
        if (jSONObject == null || jSONObject2 == null || jSONObject.length() != jSONObject2.length() || intent == null || (keys = jSONObject.keys()) == null) {
            return;
        }
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject2.optString(next);
            if (optString != null) {
                xj(jSONObject, next, optString, intent);
            }
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.xj.kd
    public Intent hf() {
        String optString = this.u.optString("action");
        String optString2 = this.u.optString(PointParamKey.CATEGORY);
        int optInt = this.u.optInt("flags", 1342210048);
        String optString3 = this.u.optString("path_extra_key");
        String optString4 = this.u.optString("path_data_key");
        JSONObject optJSONObject = this.u.optJSONObject(BaseConstants.EVENT_LABEL_EXTRA);
        JSONObject optJSONObject2 = this.u.optJSONObject("extra_type");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        Intent intent = new Intent(optString);
        if (!TextUtils.isEmpty(optString2)) {
            intent.addCategory(optString2);
        }
        if (!TextUtils.isEmpty(optString4)) {
            try {
                intent.setData(Uri.parse(String.format(optString4, this.w)));
            } catch (Throwable unused) {
            }
        }
        intent.setFlags(optInt);
        if (!TextUtils.isEmpty(optString3)) {
            intent.putExtra(optString3, this.w);
        }
        xj(intent, optJSONObject, optJSONObject2);
        return intent;
    }

    private static void xj(JSONObject jSONObject, String str, String str2, Intent intent) {
        str2.getClass();
        switch (str2) {
            case "double":
                intent.putExtra(str, jSONObject.optDouble(str));
                break;
            case "string":
                intent.putExtra(str, jSONObject.optString(str));
                break;
            case "int":
                intent.putExtra(str, jSONObject.optInt(str));
                break;
            case "long":
                intent.putExtra(str, jSONObject.optLong(str));
                break;
            case "boolean":
                intent.putExtra(str, jSONObject.optBoolean(str));
                break;
        }
    }
}

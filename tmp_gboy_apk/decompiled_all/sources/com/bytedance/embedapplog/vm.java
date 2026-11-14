package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class vm extends n {
    private final Context kd;

    public vm(Context context) {
        super(false, false);
        this.kd = context;
    }

    public static String hf(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(Base64.decode(str.getBytes("UTF-8"), 0));
        } catch (UnsupportedEncodingException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return str;
        }
    }

    @Override // com.bytedance.embedapplog.n
    public boolean xj(JSONObject jSONObject) {
        SharedPreferences hf = com.bytedance.sdk.openadsdk.api.plugin.hf.hf(this.kd, "snssdk_openudid", 0);
        String hf2 = hf(hf.getString("custom_a", null));
        if (TextUtils.isEmpty(hf2)) {
            hf2 = hf.getString("clientudid", null);
        }
        if (!aq.xj(hf2)) {
            try {
                hf2 = UUID.randomUUID().toString();
                hf2 = xj("clientudid.dat", hf2);
            } catch (Exception unused) {
            }
            String xj = xj(hf2);
            SharedPreferences.Editor edit = hf.edit();
            edit.putString("custom_a", xj);
            edit.apply();
        }
        jSONObject.put("clientudid", hf2);
        return true;
    }

    public static String xj(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Base64.encodeToString(str.getBytes("UTF-8"), 0);
            } catch (UnsupportedEncodingException e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
        }
        return str;
    }
}

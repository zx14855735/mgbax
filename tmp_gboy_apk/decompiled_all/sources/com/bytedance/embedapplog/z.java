package com.bytedance.embedapplog;

import android.content.Context;
import android.net.Uri;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class z {
    public static JSONObject xj(Context context, JSONObject jSONObject, boolean z) {
        byte[] bArr;
        JSONObject jSONObject2;
        byte[] bArr2 = new byte[0];
        try {
            bArr2 = jSONObject.toString().getBytes("UTF-8");
            String clientPackedBase64 = TTEncryptUtils.clientPackedBase64(bArr2, bArr2.length);
            if (v.hf()) {
                v.xj("__kite", "请求体整体进行sword加密：加密内容：".concat(String.valueOf(jSONObject)));
                v.w("__kite", "请求体整体进行sword加密：加密结果：".concat(String.valueOf(clientPackedBase64)));
            }
            bArr = clientPackedBase64.getBytes("UTF-8");
        } catch (Exception e) {
            v.u("__kite", "error: " + e.getMessage());
            bArr = bArr2;
        }
        if (bArr == null) {
            v.w("__kite", "data is null ");
            return new JSONObject();
        }
        try {
            jSONObject2 = xj(context, Uri.parse("https://toblog.ctobsnssdk.com/service/2/device_sdk/kite/").buildUpon().appendQueryParameter("req_id", UUID.randomUUID().toString()).build().toString(), bArr, z);
        } catch (Exception e2) {
            v.hf("__kiteerror " + e2.getMessage());
            jSONObject2 = null;
        }
        return jSONObject2 == null ? new JSONObject() : jSONObject2;
    }

    public static JSONObject xj(Context context, String str, byte[] bArr, boolean z) {
        String str2;
        try {
        } catch (Exception e) {
            v.u("__kite", "network error " + e.getMessage());
        }
        try {
            if (no.kd()) {
                try {
                    str2 = gj.xj(context, str, bArr, null, false, false);
                } catch (RuntimeException e2) {
                    v.u("__kite", "error " + e2.getMessage());
                    str2 = gj.xj(context, str, bArr, "application/json; charset=utf-8", true, true);
                }
                return new JSONObject(str2);
            }
            try {
                str2 = gj.xj(context, str, bArr, "application/json; charset=utf-8", false, true);
            } catch (Exception e3) {
                v.u("__kite", "error " + e3.getMessage());
            }
            return new JSONObject(str2);
            return new JSONObject(str2);
        } catch (Exception e4) {
            v.u("__kite", "error: " + e4.getMessage());
            return new JSONObject();
        }
        v.u("__kite", "network error " + e.getMessage());
        str2 = "";
    }
}

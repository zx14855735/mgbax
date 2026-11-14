package com.fl.saas.config.http;

import android.text.TextUtils;
import com.fl.saas.config.utils.AesUtils;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class NetDataUtils {
    public static JSONObject parseResponseNew(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String decrypt = AesUtils.decrypt(str);
                if (!TextUtils.isEmpty(decrypt) && !"null".equals(decrypt)) {
                    return new JSONObject(decrypt);
                }
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

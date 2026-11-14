package com.bytedance.adsdk.ugeno.u;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.u;
import com.bytedance.adsdk.ugeno.u.xj;
import com.bytedance.sdk.component.utils.pl;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    public static String xj(String str, JSONObject jSONObject) {
        xj w;
        xj.InterfaceC0028xj xj;
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                if (str.startsWith("${") && str.endsWith("}") && (w = u.xj().w()) != null && (xj = w.xj(str.substring(2, str.length() - 1))) != null) {
                    return (String) xj.xj(jSONObject);
                }
                return str;
            } catch (Throwable th) {
                pl.xj(th);
            }
        }
        return str;
    }
}

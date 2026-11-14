package com.bytedance.adsdk.ugeno.kd;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.kd.y;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class pl {
    public static y.xj xj(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        y.xj xjVar = new y.xj();
        String xj = com.bytedance.adsdk.ugeno.u.hf.xj(str, jSONObject);
        Uri parse = Uri.parse(xj);
        if (parse == null) {
            return null;
        }
        xjVar.w(xj);
        if (!TextUtils.isEmpty(parse.getScheme())) {
            xjVar.xj(parse.getScheme());
        }
        String authority = parse.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            authority = parse.getPath();
        }
        xjVar.hf(authority);
        xjVar.u(xjVar.xj() + "://" + xjVar.hf());
        HashMap hashMap = new HashMap();
        Set<String> queryParameterNames = parse.getQueryParameterNames();
        if (queryParameterNames != null && queryParameterNames.size() > 0) {
            for (String str2 : queryParameterNames) {
                hashMap.put(str2, com.bytedance.adsdk.ugeno.u.hf.xj(parse.getQueryParameter(str2), jSONObject));
            }
        }
        xjVar.xj(hashMap);
        return xjVar;
    }
}

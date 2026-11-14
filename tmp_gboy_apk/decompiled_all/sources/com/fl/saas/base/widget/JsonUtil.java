package com.fl.saas.base.widget;

import com.fl.saas.config.utils.LogcatUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class JsonUtil {
    public static Map<String, Object> jsonObjectToMap(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.opt(next));
            }
        } catch (Exception e) {
            if (LogcatUtil.isDebug) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }
}

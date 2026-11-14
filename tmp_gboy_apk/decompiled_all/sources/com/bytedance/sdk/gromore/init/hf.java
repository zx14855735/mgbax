package com.bytedance.sdk.gromore.init;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    public static com.bytedance.msdk.api.u.y xj(com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.w wVar) {
        if (wVar == null) {
            return null;
        }
        com.bytedance.msdk.api.u.y yVar = new com.bytedance.msdk.api.u.y();
        yVar.xj(wVar.hf());
        yVar.u(wVar.y());
        yVar.hf(wVar.w());
        yVar.w(wVar.u());
        yVar.xj(wVar.kd());
        yVar.kd(wVar.c());
        yVar.xj(wVar.xj());
        return yVar;
    }

    public static Map<String, String> xj(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue().toString());
            }
        }
        return hashMap;
    }
}

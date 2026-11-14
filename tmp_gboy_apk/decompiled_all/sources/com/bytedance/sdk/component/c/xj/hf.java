package com.bytedance.sdk.component.c.xj;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    public Map<String, Object> hf(Map<String, Object> map, com.bytedance.sdk.component.u.hf.xj xjVar, boolean z) {
        if (xjVar == null) {
            return map;
        }
        Map<String, Object> concurrentHashMap = z ? new ConcurrentHashMap<>() : map;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (z) {
                key = xjVar.encrypt(key);
            }
            concurrentHashMap.put(key, xjVar.encrypt(value.toString()));
        }
        return concurrentHashMap;
    }

    public Map<String, Object> xj(Map<String, Object> map, com.bytedance.sdk.component.u.hf.xj xjVar, boolean z) {
        if (xjVar == null) {
            return map;
        }
        Map<String, Object> concurrentHashMap = z ? new ConcurrentHashMap<>() : map;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (z) {
                key = xjVar.decrypt(key);
            }
            concurrentHashMap.put(key, xjVar.decrypt(value.toString()));
        }
        return concurrentHashMap;
    }
}

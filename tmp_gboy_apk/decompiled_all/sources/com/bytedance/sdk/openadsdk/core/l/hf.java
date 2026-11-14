package com.bytedance.sdk.openadsdk.core.l;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private ConcurrentHashMap<String, Object> xj = new ConcurrentHashMap<>();

    private String hf(String str, String str2) {
        return (str == null || !this.xj.containsKey(str)) ? str2 : (String) this.xj.get(str);
    }

    public void xj(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.xj.put(str, str2);
    }

    public String xj(String str) {
        return hf(str, "");
    }

    public int hf(String str) {
        return hf(str, 0);
    }

    public void xj(String str, int i) {
        if (str != null) {
            this.xj.put(str, Integer.valueOf(i));
        }
    }

    private int hf(String str, int i) {
        return (str == null || !this.xj.containsKey(str)) ? i : ((Integer) this.xj.get(str)).intValue();
    }
}

package com.bytedance.sdk.openadsdk.x;

import com.kuaishou.weapon.p0.t;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class f {

    public static class xj {
        public Map<String, String> hf;
        public String xj;
    }

    public static String hf(String str) {
        xj xj2 = xj(str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Map<String, String> map = xj2.hf;
        if (map != null) {
            if (map.containsKey(t.c)) {
                linkedHashMap.put(t.c, xj2.hf.get(t.c));
                xj2.hf.remove(t.c);
            }
            for (Map.Entry<String, String> entry : xj2.hf.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return xj(xj2.xj, linkedHashMap);
    }

    public static xj xj(String str) {
        xj xjVar = new xj();
        if (str != null) {
            String trim = str.trim();
            if (!trim.equals("")) {
                String[] split = trim.split("\\?");
                xjVar.xj = split[0];
                if (split.length != 1) {
                    String[] split2 = split[1].split("&");
                    xjVar.hf = new HashMap();
                    for (String str2 : split2) {
                        String[] split3 = str2.split("=");
                        if (split3.length >= 2) {
                            xjVar.hf.put(split3[0], split3[1]);
                        }
                    }
                }
            }
        }
        return xjVar;
    }

    private static String xj(String str, LinkedHashMap<String, String> linkedHashMap) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            return sb.toString();
        }
        sb.append(str);
        boolean z = str.contains("?") || str.contains("&");
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            for (String str2 : linkedHashMap.keySet()) {
                if (!z) {
                    sb.append("?");
                    z = true;
                } else {
                    sb.append("&");
                }
                sb.append(str2);
                sb.append("=");
                sb.append(linkedHashMap.get(str2));
            }
        }
        return sb.toString();
    }
}

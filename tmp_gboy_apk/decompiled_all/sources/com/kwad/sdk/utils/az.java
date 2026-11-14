package com.kwad.sdk.utils;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class az {
    public static String appendUrl(String str, Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = map.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (map.get(next) != null) {
                sb.append(next);
                sb.append("=");
                sb.append(map.get(next));
                sb.append("&");
            }
        }
        String AMqCpz = CtFAbx.AMqCpz(1, 0, sb.toString());
        StringBuilder A4TApA2 = AYUAbz.A4TApA(str);
        A4TApA2.append(str.contains("?") ? "&" : "?");
        return CtFAbx.AcNBzu(A4TApA2.toString(), AMqCpz);
    }
}

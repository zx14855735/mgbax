package com.bytedance.adsdk.lottie.u;

import android.util.JsonReader;
import com.kuaishou.weapon.p0.t;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private static com.bytedance.adsdk.lottie.model.xj.p hf(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar) {
        jsonReader.beginObject();
        com.bytedance.adsdk.lottie.model.xj.xj xjVar = null;
        com.bytedance.adsdk.lottie.model.xj.xj xjVar2 = null;
        com.bytedance.adsdk.lottie.model.xj.hf hfVar = null;
        com.bytedance.adsdk.lottie.model.xj.hf hfVar2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "t":
                    hfVar2 = u.xj(jsonReader, yVar);
                    break;
                case "fc":
                    xjVar = u.c(jsonReader, yVar);
                    break;
                case "sc":
                    xjVar2 = u.c(jsonReader, yVar);
                    break;
                case "sw":
                    hfVar = u.xj(jsonReader, yVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.lottie.model.xj.p(xjVar, xjVar2, hfVar, hfVar2);
    }

    public static com.bytedance.adsdk.lottie.model.xj.p xj(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar) {
        jsonReader.beginObject();
        com.bytedance.adsdk.lottie.model.xj.p pVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            if (nextName.equals(t.f)) {
                pVar = hf(jsonReader, yVar);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return pVar == null ? new com.bytedance.adsdk.lottie.model.xj.p(null, null, null, null) : pVar;
    }
}

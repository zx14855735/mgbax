package com.bytedance.adsdk.lottie.u;

import android.util.JsonReader;
import com.kuaishou.weapon.p0.t;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class kd {
    private static com.bytedance.adsdk.lottie.model.hf.xj hf(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar) {
        jsonReader.beginObject();
        com.bytedance.adsdk.lottie.model.hf.xj xjVar = null;
        while (true) {
            boolean z = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.getClass();
                if (nextName.equals(t.c)) {
                    if (z) {
                        xjVar = new com.bytedance.adsdk.lottie.model.hf.xj(u.xj(jsonReader, yVar));
                    } else {
                        jsonReader.skipValue();
                    }
                } else if (!nextName.equals("ty")) {
                    jsonReader.skipValue();
                } else if (jsonReader.nextInt() == 0) {
                    z = true;
                }
            }
            jsonReader.endObject();
            return xjVar;
        }
    }

    public static com.bytedance.adsdk.lottie.model.hf.xj xj(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar) {
        com.bytedance.adsdk.lottie.model.hf.xj xjVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            if (nextName.equals("ef")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.bytedance.adsdk.lottie.model.hf.xj hf = hf(jsonReader, yVar);
                    if (hf != null) {
                        xjVar = hf;
                    }
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        return xjVar;
    }
}

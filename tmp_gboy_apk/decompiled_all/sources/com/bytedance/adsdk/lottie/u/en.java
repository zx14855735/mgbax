package com.bytedance.adsdk.lottie.u;

import android.util.JsonReader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class en {
    public static com.bytedance.adsdk.lottie.model.hf.g xj(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar) {
        String str = null;
        com.bytedance.adsdk.lottie.model.xj.hf hfVar = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "r":
                    hfVar = u.xj(jsonReader, yVar, true);
                    break;
                case "hd":
                    z = jsonReader.nextBoolean();
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        if (z) {
            return null;
        }
        return new com.bytedance.adsdk.lottie.model.hf.g(str, hfVar);
    }
}

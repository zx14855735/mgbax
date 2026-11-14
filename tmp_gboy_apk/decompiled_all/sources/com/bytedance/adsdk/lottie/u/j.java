package com.bytedance.adsdk.lottie.u;

import android.util.JsonReader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class j {
    public static com.bytedance.adsdk.lottie.model.hf.pl xj(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar) {
        String str = null;
        com.bytedance.adsdk.lottie.model.xj.hf hfVar = null;
        com.bytedance.adsdk.lottie.model.xj.hf hfVar2 = null;
        com.bytedance.adsdk.lottie.model.xj.pl plVar = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "c":
                    hfVar = u.xj(jsonReader, yVar, false);
                    break;
                case "o":
                    hfVar2 = u.xj(jsonReader, yVar, false);
                    break;
                case "hd":
                    z = jsonReader.nextBoolean();
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                case "tr":
                    plVar = w.xj(jsonReader, yVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.hf.pl(str, hfVar, hfVar2, plVar, z);
    }
}

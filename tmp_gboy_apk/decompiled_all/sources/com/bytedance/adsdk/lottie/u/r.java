package com.bytedance.adsdk.lottie.u;

import android.util.JsonReader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class r {
    public static com.bytedance.adsdk.lottie.model.hf.e xj(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar) {
        String str = null;
        com.bytedance.adsdk.lottie.model.xj.f fVar = null;
        int i = 0;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "hd":
                    z = jsonReader.nextBoolean();
                    break;
                case "ks":
                    fVar = u.kd(jsonReader, yVar);
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                case "ind":
                    i = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.hf.e(str, i, fVar, z);
    }
}

package com.bytedance.adsdk.lottie.u;

import android.graphics.PointF;
import android.util.JsonReader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class z {
    public static com.bytedance.adsdk.lottie.model.hf.p xj(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar) {
        String str = null;
        com.bytedance.adsdk.lottie.model.xj.g<PointF, PointF> gVar = null;
        com.bytedance.adsdk.lottie.model.xj.y yVar2 = null;
        com.bytedance.adsdk.lottie.model.xj.hf hfVar = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "p":
                    gVar = xj.hf(jsonReader, yVar);
                    break;
                case "r":
                    hfVar = u.xj(jsonReader, yVar);
                    break;
                case "s":
                    yVar2 = u.w(jsonReader, yVar);
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
        return new com.bytedance.adsdk.lottie.model.hf.p(str, gVar, yVar2, hfVar, z);
    }
}

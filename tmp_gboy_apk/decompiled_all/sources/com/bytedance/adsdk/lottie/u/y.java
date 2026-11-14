package com.bytedance.adsdk.lottie.u;

import android.graphics.PointF;
import android.util.JsonReader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class y {
    public static com.bytedance.adsdk.lottie.model.hf.hf xj(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar, int i) {
        boolean z = i == 3;
        String str = null;
        com.bytedance.adsdk.lottie.model.xj.g<PointF, PointF> gVar = null;
        com.bytedance.adsdk.lottie.model.xj.y yVar2 = null;
        boolean z2 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "d":
                    if (jsonReader.nextInt() != 3) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case "p":
                    gVar = xj.hf(jsonReader, yVar);
                    break;
                case "s":
                    yVar2 = u.w(jsonReader, yVar);
                    break;
                case "hd":
                    z2 = jsonReader.nextBoolean();
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.hf.hf(str, gVar, yVar2, z, z2);
    }
}

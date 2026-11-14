package com.bytedance.adsdk.lottie.u;

import android.util.JsonReader;
import com.bytedance.adsdk.lottie.model.hf.v;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class ws {
    public static com.bytedance.adsdk.lottie.model.hf.v xj(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar) {
        String str = null;
        v.xj xjVar = null;
        com.bytedance.adsdk.lottie.model.xj.hf hfVar = null;
        com.bytedance.adsdk.lottie.model.xj.hf hfVar2 = null;
        com.bytedance.adsdk.lottie.model.xj.hf hfVar3 = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "e":
                    hfVar2 = u.xj(jsonReader, yVar, false);
                    break;
                case "m":
                    xjVar = v.xj.xj(jsonReader.nextInt());
                    break;
                case "o":
                    hfVar3 = u.xj(jsonReader, yVar, false);
                    break;
                case "s":
                    hfVar = u.xj(jsonReader, yVar, false);
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
        return new com.bytedance.adsdk.lottie.model.hf.v(str, xjVar, hfVar, hfVar2, hfVar3, z);
    }
}

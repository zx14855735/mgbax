package com.bytedance.adsdk.lottie.u;

import android.util.JsonReader;
import com.bytedance.adsdk.lottie.model.hf.d;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class et {
    public static com.bytedance.adsdk.lottie.model.hf.d xj(JsonReader jsonReader) {
        String str = null;
        d.xj xjVar = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "hd":
                    z = jsonReader.nextBoolean();
                    break;
                case "mm":
                    xjVar = d.xj.xj(jsonReader.nextInt());
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.hf.d(str, xjVar, z);
    }
}

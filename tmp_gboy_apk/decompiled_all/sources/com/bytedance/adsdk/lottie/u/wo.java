package com.bytedance.adsdk.lottie.u;

import android.util.JsonReader;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class wo {
    public static com.bytedance.adsdk.lottie.model.hf.zg xj(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar) {
        ArrayList arrayList = new ArrayList();
        String str = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "hd":
                    z = jsonReader.nextBoolean();
                    break;
                case "it":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.bytedance.adsdk.lottie.model.hf.w xj = f.xj(jsonReader, yVar);
                        if (xj != null) {
                            arrayList.add(xj);
                        }
                    }
                    jsonReader.endArray();
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.hf.zg(str, arrayList, z);
    }
}

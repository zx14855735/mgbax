package com.bytedance.adsdk.lottie.u;

import android.graphics.Path;
import android.util.JsonReader;
import java.util.Collections;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class a {
    public static com.bytedance.adsdk.lottie.model.hf.qt xj(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar) {
        com.bytedance.adsdk.lottie.model.xj.u uVar = null;
        String str = null;
        com.bytedance.adsdk.lottie.model.xj.xj xjVar = null;
        int i = 1;
        boolean z = false;
        boolean z2 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "fillEnabled":
                    z = jsonReader.nextBoolean();
                    break;
                case "c":
                    xjVar = u.c(jsonReader, yVar);
                    break;
                case "o":
                    uVar = u.hf(jsonReader, yVar);
                    break;
                case "r":
                    i = jsonReader.nextInt();
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
        if (uVar == null) {
            uVar = new com.bytedance.adsdk.lottie.model.xj.u(Collections.singletonList(new com.bytedance.adsdk.lottie.y.xj(100)));
        }
        return new com.bytedance.adsdk.lottie.model.hf.qt(str, z, i == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, xjVar, uVar, z2);
    }
}

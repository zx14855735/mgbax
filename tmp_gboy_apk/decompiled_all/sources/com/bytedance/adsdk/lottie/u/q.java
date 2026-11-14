package com.bytedance.adsdk.lottie.u;

import android.graphics.PointF;
import android.util.JsonReader;
import com.bytedance.adsdk.lottie.model.hf.tf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class q {
    public static com.bytedance.adsdk.lottie.model.hf.tf xj(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar, int i) {
        boolean z = i == 3;
        String str = null;
        tf.xj xjVar = null;
        com.bytedance.adsdk.lottie.model.xj.hf hfVar = null;
        com.bytedance.adsdk.lottie.model.xj.g<PointF, PointF> gVar = null;
        com.bytedance.adsdk.lottie.model.xj.hf hfVar2 = null;
        com.bytedance.adsdk.lottie.model.xj.hf hfVar3 = null;
        com.bytedance.adsdk.lottie.model.xj.hf hfVar4 = null;
        com.bytedance.adsdk.lottie.model.xj.hf hfVar5 = null;
        com.bytedance.adsdk.lottie.model.xj.hf hfVar6 = null;
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
                case "r":
                    hfVar2 = u.xj(jsonReader, yVar, false);
                    break;
                case "hd":
                    z2 = jsonReader.nextBoolean();
                    break;
                case "ir":
                    hfVar3 = u.xj(jsonReader, yVar);
                    break;
                case "is":
                    hfVar5 = u.xj(jsonReader, yVar, false);
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                case "or":
                    hfVar4 = u.xj(jsonReader, yVar);
                    break;
                case "os":
                    hfVar6 = u.xj(jsonReader, yVar, false);
                    break;
                case "pt":
                    hfVar = u.xj(jsonReader, yVar, false);
                    break;
                case "sy":
                    xjVar = tf.xj.xj(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.bytedance.adsdk.lottie.model.hf.tf(str, xjVar, hfVar, gVar, hfVar2, hfVar3, hfVar4, hfVar5, hfVar6, z2, z);
    }
}

package com.bytedance.adsdk.lottie.u;

import android.util.JsonReader;
import com.kuaishou.weapon.p0.t;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class p {
    private com.bytedance.adsdk.lottie.model.xj.hf hf;
    private com.bytedance.adsdk.lottie.model.xj.hf kd;
    private com.bytedance.adsdk.lottie.model.xj.hf u;
    private com.bytedance.adsdk.lottie.model.xj.hf w;
    private com.bytedance.adsdk.lottie.model.xj.xj xj;

    private void hf(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar) {
        jsonReader.beginObject();
        String str = "";
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            if (nextName.equals(t.c)) {
                str.getClass();
                switch (str) {
                    case "Distance":
                        this.u = u.xj(jsonReader, yVar);
                        break;
                    case "Opacity":
                        this.hf = u.xj(jsonReader, yVar, false);
                        break;
                    case "Direction":
                        this.w = u.xj(jsonReader, yVar, false);
                        break;
                    case "Shadow Color":
                        this.xj = u.c(jsonReader, yVar);
                        break;
                    case "Softness":
                        this.kd = u.xj(jsonReader, yVar);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            } else if (nextName.equals("nm")) {
                str = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    public tf xj(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar) {
        com.bytedance.adsdk.lottie.model.xj.hf hfVar;
        com.bytedance.adsdk.lottie.model.xj.hf hfVar2;
        com.bytedance.adsdk.lottie.model.xj.hf hfVar3;
        com.bytedance.adsdk.lottie.model.xj.hf hfVar4;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            if (nextName.equals("ef")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    hf(jsonReader, yVar);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        com.bytedance.adsdk.lottie.model.xj.xj xjVar = this.xj;
        if (xjVar == null || (hfVar = this.hf) == null || (hfVar2 = this.w) == null || (hfVar3 = this.u) == null || (hfVar4 = this.kd) == null) {
            return null;
        }
        return new tf(xjVar, hfVar, hfVar2, hfVar3, hfVar4);
    }
}

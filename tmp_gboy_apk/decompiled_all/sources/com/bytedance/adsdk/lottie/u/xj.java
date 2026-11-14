package com.bytedance.adsdk.lottie.u;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    public static com.bytedance.adsdk.lottie.model.xj.g<PointF, PointF> hf(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar) {
        jsonReader.beginObject();
        com.bytedance.adsdk.lottie.model.xj.kd kdVar = null;
        com.bytedance.adsdk.lottie.model.xj.hf hfVar = null;
        com.bytedance.adsdk.lottie.model.xj.hf hfVar2 = null;
        boolean z = false;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "k":
                    kdVar = xj(jsonReader, yVar);
                    break;
                case "x":
                    if (jsonReader.peek() != JsonToken.STRING) {
                        hfVar = u.xj(jsonReader, yVar);
                        break;
                    } else {
                        z = true;
                        jsonReader.skipValue();
                        break;
                    }
                case "y":
                    if (jsonReader.peek() != JsonToken.STRING) {
                        hfVar2 = u.xj(jsonReader, yVar);
                        break;
                    } else {
                        z = true;
                        jsonReader.skipValue();
                        break;
                    }
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z) {
            yVar.xj("Lottie doesn't support expressions.");
        }
        return kdVar != null ? kdVar : new com.bytedance.adsdk.lottie.model.xj.d(hfVar, hfVar2);
    }

    public static com.bytedance.adsdk.lottie.model.xj.kd xj(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar) {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(io.xj(jsonReader, yVar));
            }
            jsonReader.endArray();
            pz.xj(arrayList);
        } else {
            arrayList.add(new com.bytedance.adsdk.lottie.y.xj(v.hf(jsonReader, com.bytedance.adsdk.lottie.kd.d.xj())));
        }
        return new com.bytedance.adsdk.lottie.model.xj.kd(arrayList);
    }
}

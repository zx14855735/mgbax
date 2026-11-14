package com.bytedance.adsdk.lottie.u;

import android.util.JsonReader;
import android.util.JsonToken;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class pz {
    public static <T> List<com.bytedance.adsdk.lottie.y.xj<T>> xj(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar, float f, eu<T> euVar, boolean z) {
        JsonReader jsonReader2;
        com.bytedance.adsdk.lottie.y yVar2;
        float f2;
        eu<T> euVar2;
        boolean z2;
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            yVar.xj("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            if (!nextName.equals(t.f12297a)) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                if (jsonReader.peek() == JsonToken.NUMBER) {
                    JsonReader jsonReader3 = jsonReader;
                    com.bytedance.adsdk.lottie.y yVar3 = yVar;
                    float f3 = f;
                    eu<T> euVar3 = euVar;
                    boolean z3 = z;
                    com.bytedance.adsdk.lottie.y.xj xj = jk.xj(jsonReader3, yVar3, f3, euVar3, false, z3);
                    jsonReader2 = jsonReader3;
                    yVar2 = yVar3;
                    f2 = f3;
                    euVar2 = euVar3;
                    z2 = z3;
                    arrayList.add(xj);
                } else {
                    jsonReader2 = jsonReader;
                    yVar2 = yVar;
                    f2 = f;
                    euVar2 = euVar;
                    z2 = z;
                    while (jsonReader2.hasNext()) {
                        arrayList.add(jk.xj(jsonReader2, yVar2, f2, euVar2, true, z2));
                    }
                }
                jsonReader2.endArray();
                jsonReader = jsonReader2;
                yVar = yVar2;
                f = f2;
                euVar = euVar2;
                z = z2;
            } else {
                JsonReader jsonReader4 = jsonReader;
                arrayList.add(jk.xj(jsonReader4, yVar, f, euVar, false, z));
                jsonReader = jsonReader4;
            }
        }
        jsonReader.endObject();
        xj(arrayList);
        return arrayList;
    }

    public static <T> void xj(List<? extends com.bytedance.adsdk.lottie.y.xj<T>> list) {
        int i;
        T t;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            com.bytedance.adsdk.lottie.y.xj<T> xjVar = list.get(i2);
            i2++;
            com.bytedance.adsdk.lottie.y.xj<T> xjVar2 = list.get(i2);
            xjVar.c = Float.valueOf(xjVar2.y);
            if (xjVar.hf == null && (t = xjVar2.xj) != null) {
                xjVar.hf = t;
                if (xjVar instanceof com.bytedance.adsdk.lottie.xj.hf.d) {
                    ((com.bytedance.adsdk.lottie.xj.hf.d) xjVar).xj();
                }
            }
        }
        com.bytedance.adsdk.lottie.y.xj<T> xjVar3 = list.get(i);
        if ((xjVar3.xj == null || xjVar3.hf == null) && list.size() > 1) {
            list.remove(xjVar3);
        }
    }
}

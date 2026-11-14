package com.bytedance.adsdk.lottie.u;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ff implements eu<com.bytedance.adsdk.lottie.model.hf.am> {
    public static final ff xj = new ff();

    static {
        BfbzPsu();
    }

    private ff() {
    }

    private static /* synthetic */ void BfbzPsu() {
        char[] charArray = "\u0099\u0095\u0097Ô\u009d\u009b\u0097\u009fÔ\u0098\u0095\u0083Ô\u0089\u0092\u009f\u0096\u0096Ô°\u0094\u0093¸\u0088\u0093\u009e\u009d\u009f".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 250);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0099\u0096\u0093\u0094\u0093\u008e".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 250);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.bytedance.adsdk.lottie.u.eu
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.model.hf.am hf(JsonReader jsonReader, float f) {
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "c":
                    z = jsonReader.nextBoolean();
                    break;
                case "i":
                    list2 = v.xj(jsonReader, f);
                    break;
                case "o":
                    list3 = v.xj(jsonReader, f);
                    break;
                case "v":
                    list = v.xj(jsonReader, f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (jsonReader.peek() == JsonToken.END_ARRAY) {
            jsonReader.endArray();
        }
        if (list == null || list2 == null || list3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (list.isEmpty()) {
            return new com.bytedance.adsdk.lottie.model.hf.am(new PointF(), false, Collections.EMPTY_LIST);
        }
        int size = list.size();
        PointF pointF = list.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i = 1; i < size; i++) {
            PointF pointF2 = list.get(i);
            int i2 = i - 1;
            arrayList.add(new com.bytedance.adsdk.lottie.model.xj(com.bytedance.adsdk.lottie.kd.f.xj(list.get(i2), list3.get(i2)), com.bytedance.adsdk.lottie.kd.f.xj(pointF2, list2.get(i)), pointF2));
        }
        if (z) {
            PointF pointF3 = list.get(0);
            int i3 = size - 1;
            arrayList.add(new com.bytedance.adsdk.lottie.model.xj(com.bytedance.adsdk.lottie.kd.f.xj(list.get(i3), list3.get(i3)), com.bytedance.adsdk.lottie.kd.f.xj(pointF3, list2.get(0)), pointF3));
        }
        return new com.bytedance.adsdk.lottie.model.hf.am(pointF, z, arrayList);
    }
}

package com.bytedance.adsdk.lottie.u;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import com.bytedance.adsdk.lottie.model.layer.f;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ht {

    /* renamed from: com.bytedance.adsdk.lottie.u.ht$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] xj;

        static {
            int[] iArr = new int[f.hf.values().length];
            xj = iArr;
            try {
                iArr[f.hf.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                xj[f.hf.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static com.bytedance.adsdk.lottie.model.layer.f xj(com.bytedance.adsdk.lottie.y yVar) {
        Rect u = yVar.u();
        List list = Collections.EMPTY_LIST;
        return new com.bytedance.adsdk.lottie.model.layer.f(list, yVar, "__container", -1L, f.xj.PRE_COMP, -1L, null, list, new com.bytedance.adsdk.lottie.model.xj.pl(), 0, 0, 0, 0.0f, 0.0f, u.width(), u.height(), null, null, list, f.hf.NONE, null, false, null, null);
    }

    public static com.bytedance.adsdk.lottie.model.layer.f xj(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar) {
        Float f;
        int i;
        f.hf hfVar = f.hf.NONE;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        jsonReader.beginObject();
        String str = "UNSET";
        String str2 = null;
        Float valueOf = Float.valueOf(0.0f);
        Float valueOf2 = Float.valueOf(1.0f);
        f.hf hfVar2 = hfVar;
        com.bytedance.adsdk.lottie.model.xj.p pVar = null;
        com.bytedance.adsdk.lottie.model.xj.hf hfVar3 = null;
        com.bytedance.adsdk.lottie.model.hf.xj xjVar = null;
        tf tfVar = null;
        Float f2 = valueOf;
        long j = -1;
        int i2 = 0;
        float f3 = 1.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        int i3 = 0;
        int i4 = 0;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        boolean z = false;
        com.bytedance.adsdk.lottie.model.xj.pl plVar = null;
        com.bytedance.adsdk.lottie.model.xj.tf tfVar2 = null;
        long j2 = 0;
        f.xj xjVar2 = null;
        String str3 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName) {
                case "parent":
                    j = jsonReader.nextInt();
                    break;
                case "shapes":
                    f = f2;
                    i = i2;
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.bytedance.adsdk.lottie.model.hf.w xj = f.xj(jsonReader, yVar);
                        if (xj != null) {
                            arrayList2.add(xj);
                        }
                    }
                    jsonReader.endArray();
                    f2 = f;
                    i2 = i;
                    break;
                case "h":
                    f = f2;
                    i = i2;
                    f7 = (float) (jsonReader.nextDouble() * com.bytedance.adsdk.lottie.kd.d.xj());
                    f2 = f;
                    i2 = i;
                    break;
                case "t":
                    f = f2;
                    i = i2;
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName2 = jsonReader.nextName();
                        nextName2.getClass();
                        if (nextName2.equals(t.f)) {
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                pVar = hf.xj(jsonReader, yVar);
                            }
                            while (jsonReader.hasNext()) {
                                jsonReader.skipValue();
                            }
                            jsonReader.endArray();
                        } else if (!nextName2.equals(t.t)) {
                            jsonReader.skipValue();
                        } else {
                            tfVar2 = u.y(jsonReader, yVar);
                        }
                    }
                    jsonReader.endObject();
                    f2 = f;
                    i2 = i;
                    break;
                case "w":
                    f = f2;
                    i = i2;
                    f6 = (float) (jsonReader.nextDouble() * com.bytedance.adsdk.lottie.kd.d.xj());
                    f2 = f;
                    i2 = i;
                    break;
                case "cl":
                    str2 = jsonReader.nextString();
                    break;
                case "ef":
                    f = f2;
                    jsonReader.beginArray();
                    ArrayList arrayList3 = new ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String nextName3 = jsonReader.nextName();
                            nextName3.getClass();
                            if (!nextName3.equals("nm")) {
                                if (!nextName3.equals("ty")) {
                                    jsonReader.skipValue();
                                } else {
                                    int nextInt = jsonReader.nextInt();
                                    if (nextInt == 29) {
                                        xjVar = kd.xj(jsonReader, yVar);
                                    } else if (nextInt == 25) {
                                        tfVar = new p().xj(jsonReader, yVar);
                                    }
                                }
                            } else {
                                arrayList3.add(jsonReader.nextString());
                            }
                        }
                        jsonReader.endObject();
                    }
                    jsonReader.endArray();
                    yVar.xj("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: ".concat(String.valueOf(arrayList3)));
                    f2 = f;
                    break;
                case "hd":
                    z = jsonReader.nextBoolean();
                    break;
                case "ip":
                    f4 = (float) jsonReader.nextDouble();
                    break;
                case "ks":
                    plVar = w.xj(jsonReader, yVar);
                    break;
                case "nm":
                    str = jsonReader.nextString();
                    break;
                case "op":
                    f5 = (float) jsonReader.nextDouble();
                    break;
                case "sc":
                    i2 = Color.parseColor(jsonReader.nextString());
                    break;
                case "sh":
                    i4 = (int) (com.bytedance.adsdk.lottie.kd.d.xj() * jsonReader.nextInt());
                    break;
                case "sr":
                    f3 = (float) jsonReader.nextDouble();
                    break;
                case "st":
                    f8 = (float) jsonReader.nextDouble();
                    break;
                case "sw":
                    f = f2;
                    i3 = (int) (jsonReader.nextInt() * com.bytedance.adsdk.lottie.kd.d.xj());
                    f2 = f;
                    break;
                case "tm":
                    hfVar3 = u.xj(jsonReader, yVar, false);
                    break;
                case "tt":
                    f = f2;
                    int nextInt2 = jsonReader.nextInt();
                    if (nextInt2 >= f.hf.values().length) {
                        yVar.xj("Unsupported matte type: ".concat(String.valueOf(nextInt2)));
                        i = i2;
                        f2 = f;
                        i2 = i;
                        break;
                    } else {
                        hfVar2 = f.hf.values()[nextInt2];
                        int i5 = AnonymousClass1.xj[hfVar2.ordinal()];
                        if (i5 == 1) {
                            yVar.xj("Unsupported matte type: Luma");
                        } else if (i5 == 2) {
                            yVar.xj("Unsupported matte type: Luma Inverted");
                        }
                        yVar.xj(1);
                        f2 = f;
                        break;
                    }
                case "ty":
                    f = f2;
                    int nextInt3 = jsonReader.nextInt();
                    xjVar2 = f.xj.UNKNOWN;
                    if (nextInt3 < xjVar2.ordinal()) {
                        xjVar2 = f.xj.values()[nextInt3];
                    }
                    f2 = f;
                    break;
                case "ind":
                    f = f2;
                    j2 = jsonReader.nextInt();
                    f2 = f;
                    break;
                case "refId":
                    str3 = jsonReader.nextString();
                    break;
                case "masksProperties":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList.add(dk.xj(jsonReader, yVar));
                    }
                    yVar.xj(arrayList.size());
                    jsonReader.endArray();
                    f = f2;
                    i = i2;
                    f2 = f;
                    i2 = i;
                    break;
                default:
                    jsonReader.skipValue();
                    f = f2;
                    i = i2;
                    f2 = f;
                    i2 = i;
                    break;
            }
        }
        Float f9 = f2;
        int i6 = i2;
        jsonReader.endObject();
        ArrayList arrayList4 = new ArrayList();
        if (f4 > 0.0f) {
            arrayList4.add(new com.bytedance.adsdk.lottie.y.xj(yVar, f9, f9, null, 0.0f, Float.valueOf(f4)));
        }
        if (f5 <= 0.0f) {
            f5 = yVar.c();
        }
        arrayList4.add(new com.bytedance.adsdk.lottie.y.xj(yVar, valueOf2, valueOf2, null, f4, Float.valueOf(f5)));
        arrayList4.add(new com.bytedance.adsdk.lottie.y.xj(yVar, f9, f9, null, f5, Float.valueOf(Float.MAX_VALUE)));
        if (str.endsWith(".ai") || "ai".equals(str2)) {
            yVar.xj("Convert your Illustrator layers to shape layers.");
        }
        return new com.bytedance.adsdk.lottie.model.layer.f(arrayList2, yVar, str, j2, xjVar2, j, str3, arrayList, plVar, i3, i4, i6, f3, f8, f6, f7, tfVar2, pVar, arrayList4, hfVar2, hfVar3, z, xjVar, tfVar);
    }
}

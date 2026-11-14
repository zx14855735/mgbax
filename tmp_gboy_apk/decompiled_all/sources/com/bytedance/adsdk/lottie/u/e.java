package com.bytedance.adsdk.lottie.u;

import android.util.JsonReader;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.adsdk.lottie.model.hf.yo;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class e {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static com.bytedance.adsdk.lottie.model.hf.y xj(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar) {
        char c;
        int i = 1;
        ArrayList arrayList = new ArrayList();
        String str = null;
        com.bytedance.adsdk.lottie.model.xj.u uVar = null;
        com.bytedance.adsdk.lottie.model.hf.c cVar = null;
        com.bytedance.adsdk.lottie.model.xj.w wVar = null;
        com.bytedance.adsdk.lottie.model.xj.y yVar2 = null;
        com.bytedance.adsdk.lottie.model.xj.y yVar3 = null;
        com.bytedance.adsdk.lottie.model.xj.hf hfVar = null;
        yo.xj xjVar = null;
        yo.hf hfVar2 = null;
        com.bytedance.adsdk.lottie.model.xj.hf hfVar3 = null;
        float f = 0.0f;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName.hashCode()) {
                case 100:
                    if (nextName.equals(t.t)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 101:
                    if (nextName.equals("e")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 103:
                    if (nextName.equals("g")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 111:
                    if (nextName.equals("o")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 115:
                    if (nextName.equals("s")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 116:
                    if (nextName.equals(com.kwad.components.core.s.t.TAG)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 119:
                    if (nextName.equals(IAdInterListener.AdReqParam.WIDTH)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 3324:
                    if (nextName.equals(LiveConfigKey.HIGH)) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 3447:
                    if (nextName.equals("lc")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 3454:
                    if (nextName.equals("lj")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case 3487:
                    if (nextName.equals("ml")) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    JsonReader jsonReader2 = jsonReader;
                    jsonReader2.beginArray();
                    while (jsonReader2.hasNext()) {
                        jsonReader2.beginObject();
                        String str2 = null;
                        com.bytedance.adsdk.lottie.model.xj.hf hfVar4 = null;
                        while (jsonReader2.hasNext()) {
                            String nextName2 = jsonReader2.nextName();
                            nextName2.getClass();
                            if (nextName2.equals("n")) {
                                str2 = jsonReader.nextString();
                            } else if (nextName2.equals(t.c)) {
                                hfVar4 = u.xj(jsonReader, yVar);
                            } else {
                                jsonReader.skipValue();
                            }
                            jsonReader2 = jsonReader;
                        }
                        jsonReader.endObject();
                        if (str2.equals("o")) {
                            jsonReader2 = jsonReader;
                            hfVar3 = hfVar4;
                        } else {
                            if (str2.equals(t.t) || str2.equals("g")) {
                                yVar.xj(true);
                                arrayList.add(hfVar4);
                            }
                            jsonReader2 = jsonReader;
                        }
                    }
                    jsonReader.endArray();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                        i = 1;
                        break;
                    }
                    i = 1;
                    break;
                case 1:
                    yVar3 = u.w(jsonReader, yVar);
                    break;
                case 2:
                    jsonReader.beginObject();
                    int i2 = -1;
                    while (jsonReader.hasNext()) {
                        String nextName3 = jsonReader.nextName();
                        nextName3.getClass();
                        if (nextName3.equals(t.f12297a)) {
                            wVar = u.xj(jsonReader, yVar, i2);
                        } else if (nextName3.equals(t.b)) {
                            i2 = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case 3:
                    uVar = u.hf(jsonReader, yVar);
                    break;
                case 4:
                    yVar2 = u.w(jsonReader, yVar);
                    break;
                case 5:
                    cVar = jsonReader.nextInt() == i ? com.bytedance.adsdk.lottie.model.hf.c.LINEAR : com.bytedance.adsdk.lottie.model.hf.c.RADIAL;
                    break;
                case 6:
                    hfVar = u.xj(jsonReader, yVar);
                    break;
                case 7:
                    z = jsonReader.nextBoolean();
                    break;
                case '\b':
                    xjVar = yo.xj.values()[jsonReader.nextInt() - i];
                    break;
                case '\t':
                    hfVar2 = yo.hf.values()[jsonReader.nextInt() - i];
                    break;
                case '\n':
                    f = (float) jsonReader.nextDouble();
                    break;
                case 11:
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    i = 1;
                    break;
            }
        }
        if (uVar == null) {
            uVar = new com.bytedance.adsdk.lottie.model.xj.u(Collections.singletonList(new com.bytedance.adsdk.lottie.y.xj(100)));
        }
        return new com.bytedance.adsdk.lottie.model.hf.y(str, cVar, wVar, uVar, yVar2, yVar3, hfVar, xjVar, hfVar2, f, arrayList, hfVar3, z);
    }
}

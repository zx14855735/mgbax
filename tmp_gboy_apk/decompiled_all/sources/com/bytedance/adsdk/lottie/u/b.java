package com.bytedance.adsdk.lottie.u;

import android.util.JsonReader;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.adsdk.lottie.model.hf.yo;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class b {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static com.bytedance.adsdk.lottie.model.hf.yo xj(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar) {
        char c;
        com.bytedance.adsdk.lottie.model.xj.u uVar;
        char c2;
        ArrayList arrayList = new ArrayList();
        com.bytedance.adsdk.lottie.model.xj.u uVar2 = null;
        String str = null;
        com.bytedance.adsdk.lottie.model.xj.hf hfVar = null;
        com.bytedance.adsdk.lottie.model.xj.xj xjVar = null;
        com.bytedance.adsdk.lottie.model.xj.hf hfVar2 = null;
        yo.xj xjVar2 = null;
        float f = 0.0f;
        yo.hf hfVar3 = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName.hashCode()) {
                case 99:
                    if (nextName.equals("c")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 100:
                    if (nextName.equals(t.t)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 111:
                    if (nextName.equals("o")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 119:
                    if (nextName.equals(IAdInterListener.AdReqParam.WIDTH)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 3324:
                    if (nextName.equals(LiveConfigKey.HIGH)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 3447:
                    if (nextName.equals("lc")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 3454:
                    if (nextName.equals("lj")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 3487:
                    if (nextName.equals("ml")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c = '\b';
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
                    xjVar = u.c(jsonReader, yVar);
                    break;
                case 1:
                    uVar = uVar2;
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String str2 = null;
                        com.bytedance.adsdk.lottie.model.xj.hf hfVar4 = null;
                        while (jsonReader.hasNext()) {
                            String nextName2 = jsonReader.nextName();
                            nextName2.getClass();
                            if (nextName2.equals("n")) {
                                str2 = jsonReader.nextString();
                            } else if (nextName2.equals(t.c)) {
                                hfVar4 = u.xj(jsonReader, yVar);
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                        str2.getClass();
                        switch (str2.hashCode()) {
                            case 100:
                                if (str2.equals(t.t)) {
                                    c2 = 0;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 103:
                                if (str2.equals("g")) {
                                    c2 = 1;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 111:
                                if (str2.equals("o")) {
                                    c2 = 2;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            default:
                                c2 = 65535;
                                break;
                        }
                        switch (c2) {
                            case 0:
                            case 1:
                                yVar.xj(true);
                                arrayList.add(hfVar4);
                                break;
                            case 2:
                                hfVar = hfVar4;
                                break;
                        }
                    }
                    jsonReader.endArray();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                        uVar2 = uVar;
                        break;
                    }
                    uVar2 = uVar;
                    break;
                case 2:
                    uVar2 = u.hf(jsonReader, yVar);
                    break;
                case 3:
                    hfVar2 = u.xj(jsonReader, yVar);
                    break;
                case 4:
                    z = jsonReader.nextBoolean();
                    break;
                case 5:
                    uVar = uVar2;
                    xjVar2 = yo.xj.values()[jsonReader.nextInt() - 1];
                    uVar2 = uVar;
                    break;
                case 6:
                    uVar = uVar2;
                    hfVar3 = yo.hf.values()[jsonReader.nextInt() - 1];
                    uVar2 = uVar;
                    break;
                case 7:
                    uVar = uVar2;
                    f = (float) jsonReader.nextDouble();
                    uVar2 = uVar;
                    break;
                case '\b':
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    uVar = uVar2;
                    uVar2 = uVar;
                    break;
            }
        }
        com.bytedance.adsdk.lottie.model.xj.u uVar3 = uVar2;
        return new com.bytedance.adsdk.lottie.model.hf.yo(str, hfVar, arrayList, xjVar, uVar3 == null ? new com.bytedance.adsdk.lottie.model.xj.u(Collections.singletonList(new com.bytedance.adsdk.lottie.y.xj(100))) : uVar3, hfVar2, xjVar2, hfVar3, f, z);
    }
}

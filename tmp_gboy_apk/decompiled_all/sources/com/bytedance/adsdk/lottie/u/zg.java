package com.bytedance.adsdk.lottie.u;

import android.graphics.Path;
import android.util.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.kuaishou.weapon.p0.t;
import com.qq.e.comm.adevent.AdEventType;
import java.util.Collections;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class zg {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static com.bytedance.adsdk.lottie.model.hf.kd xj(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar) {
        char c;
        com.bytedance.adsdk.lottie.model.xj.u uVar = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String str = null;
        com.bytedance.adsdk.lottie.model.hf.c cVar = null;
        com.bytedance.adsdk.lottie.model.xj.w wVar = null;
        com.bytedance.adsdk.lottie.model.xj.y yVar2 = null;
        com.bytedance.adsdk.lottie.model.xj.y yVar3 = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName.hashCode()) {
                case 101:
                    if (nextName.equals("e")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 103:
                    if (nextName.equals("g")) {
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
                case AdEventType.AD_ZOOM_OUT_PLAY_FINISH /* 114 */:
                    if (nextName.equals(t.k)) {
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
                case 3324:
                    if (nextName.equals(LiveConfigKey.HIGH)) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c = 7;
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
                    yVar3 = u.w(jsonReader, yVar);
                    break;
                case 1:
                    jsonReader.beginObject();
                    int i = -1;
                    while (jsonReader.hasNext()) {
                        String nextName2 = jsonReader.nextName();
                        nextName2.getClass();
                        if (nextName2.equals(t.f12297a)) {
                            wVar = u.xj(jsonReader, yVar, i);
                        } else if (nextName2.equals(t.b)) {
                            i = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case 2:
                    uVar = u.hf(jsonReader, yVar);
                    break;
                case 3:
                    fillType = jsonReader.nextInt() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 4:
                    yVar2 = u.w(jsonReader, yVar);
                    break;
                case 5:
                    cVar = jsonReader.nextInt() == 1 ? com.bytedance.adsdk.lottie.model.hf.c.LINEAR : com.bytedance.adsdk.lottie.model.hf.c.RADIAL;
                    break;
                case 6:
                    z = jsonReader.nextBoolean();
                    break;
                case 7:
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
        return new com.bytedance.adsdk.lottie.model.hf.kd(str, cVar, fillType, wVar, uVar, yVar2, yVar3, null, null, z);
    }
}

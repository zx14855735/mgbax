package com.bytedance.adsdk.lottie.u;

import android.util.JsonReader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.adsdk.lottie.model.hf.f;
import com.kuaishou.weapon.p0.t;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class dk {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static com.bytedance.adsdk.lottie.model.hf.f xj(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar) {
        char c;
        char c2;
        jsonReader.beginObject();
        f.xj xjVar = null;
        com.bytedance.adsdk.lottie.model.xj.f fVar = null;
        com.bytedance.adsdk.lottie.model.xj.u uVar = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName.hashCode()) {
                case 111:
                    if (nextName.equals("o")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 3588:
                    if (nextName.equals("pt")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 104433:
                    if (nextName.equals("inv")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 3357091:
                    if (nextName.equals("mode")) {
                        c = 3;
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
                    uVar = u.hf(jsonReader, yVar);
                    break;
                case 1:
                    fVar = u.kd(jsonReader, yVar);
                    break;
                case 2:
                    z = jsonReader.nextBoolean();
                    break;
                case 3:
                    String nextString = jsonReader.nextString();
                    nextString.getClass();
                    switch (nextString.hashCode()) {
                        case MediaPlayer.MEDIA_PLAYER_OPTION_USE_MEDIA_CODEC_AUDIO /* 97 */:
                            if (nextString.equals(t.f)) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 105:
                            if (nextString.equals("i")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 110:
                            if (nextString.equals("n")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 115:
                            if (nextString.equals("s")) {
                                c2 = 3;
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
                            xjVar = f.xj.MASK_MODE_ADD;
                            break;
                        case 1:
                            yVar.xj("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            xjVar = f.xj.MASK_MODE_INTERSECT;
                            break;
                        case 2:
                            xjVar = f.xj.MASK_MODE_NONE;
                            break;
                        case 3:
                            xjVar = f.xj.MASK_MODE_SUBTRACT;
                            break;
                        default:
                            com.bytedance.adsdk.lottie.kd.kd.hf("Unknown mask mode " + nextName + ". Defaulting to Add.");
                            xjVar = f.xj.MASK_MODE_ADD;
                            break;
                    }
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.lottie.model.hf.f(xjVar, fVar, uVar, z);
    }
}

package com.bytedance.adsdk.lottie.u;

import android.util.JsonReader;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    public static com.bytedance.adsdk.lottie.model.xj.xj c(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar) {
        return new com.bytedance.adsdk.lottie.model.xj.xj(xj(jsonReader, yVar, c.xj));
    }

    public static com.bytedance.adsdk.lottie.model.xj.u hf(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar) {
        return new com.bytedance.adsdk.lottie.model.xj.u(xj(jsonReader, yVar, yo.xj));
    }

    public static com.bytedance.adsdk.lottie.model.xj.f kd(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar) {
        return new com.bytedance.adsdk.lottie.model.xj.f(xj(jsonReader, com.bytedance.adsdk.lottie.kd.d.xj(), yVar, ff.xj));
    }

    public static com.bytedance.adsdk.lottie.model.xj.c u(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar) {
        return new com.bytedance.adsdk.lottie.model.xj.c(xj(jsonReader, yVar, l.xj));
    }

    public static com.bytedance.adsdk.lottie.model.xj.y w(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar) {
        return new com.bytedance.adsdk.lottie.model.xj.y(pz.xj(jsonReader, yVar, com.bytedance.adsdk.lottie.kd.d.xj(), ai.xj, true));
    }

    public static com.bytedance.adsdk.lottie.model.xj.hf xj(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar) {
        return xj(jsonReader, yVar, true);
    }

    public static com.bytedance.adsdk.lottie.model.xj.tf y(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar) {
        return new com.bytedance.adsdk.lottie.model.xj.tf(xj(jsonReader, com.bytedance.adsdk.lottie.kd.d.xj(), yVar, d.xj));
    }

    public static com.bytedance.adsdk.lottie.model.xj.hf xj(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar, boolean z) {
        return new com.bytedance.adsdk.lottie.model.xj.hf(xj(jsonReader, z ? com.bytedance.adsdk.lottie.kd.d.xj() : 1.0f, yVar, pl.xj));
    }

    public static com.bytedance.adsdk.lottie.model.xj.w xj(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar, int i) {
        return new com.bytedance.adsdk.lottie.model.xj.w(xj(jsonReader, yVar, new qt(i)));
    }

    private static <T> List<com.bytedance.adsdk.lottie.y.xj<T>> xj(JsonReader jsonReader, com.bytedance.adsdk.lottie.y yVar, eu<T> euVar) {
        return pz.xj(jsonReader, yVar, 1.0f, euVar, false);
    }

    private static <T> List<com.bytedance.adsdk.lottie.y.xj<T>> xj(JsonReader jsonReader, float f, com.bytedance.adsdk.lottie.y yVar, eu<T> euVar) {
        return pz.xj(jsonReader, yVar, f, euVar, false);
    }
}

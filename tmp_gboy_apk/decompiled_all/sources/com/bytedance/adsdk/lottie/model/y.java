package com.bytedance.adsdk.lottie.model;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y {
    public final float hf;
    private final String w;
    public final float xj;

    public y(String str, float f, float f2) {
        this.w = str;
        this.hf = f2;
        this.xj = f;
    }

    public boolean xj(String str) {
        if (this.w.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.w.endsWith("\r")) {
            String str2 = this.w;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}

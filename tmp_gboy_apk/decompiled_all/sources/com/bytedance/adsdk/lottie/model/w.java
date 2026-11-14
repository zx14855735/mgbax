package com.bytedance.adsdk.lottie.model;

import android.graphics.Typeface;
import com.bytedance.component.sdk.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private final String hf;
    private Typeface kd;
    private final float u;
    private final String w;
    private final String xj;

    public w(String str, String str2, String str3, float f) {
        this.xj = str;
        this.hf = str2;
        this.w = str3;
        this.u = f;
    }

    public String hf() {
        return this.hf;
    }

    public Typeface u() {
        return this.kd;
    }

    public String w() {
        return this.w;
    }

    public String xj() {
        return this.xj;
    }

    public void xj(Typeface typeface) {
        this.kd = typeface;
    }
}

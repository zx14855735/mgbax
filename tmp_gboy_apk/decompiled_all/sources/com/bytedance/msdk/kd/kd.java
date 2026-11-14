package com.bytedance.msdk.kd;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd {
    public final int hf;
    public final boolean u;
    public final String w;
    public final boolean xj;

    public kd(boolean z, int i, String str, boolean z2) {
        this.xj = z;
        this.hf = i;
        this.w = str;
        this.u = z2;
    }

    public String toString() {
        return "AdEventUploadResult{mSuccess=" + this.xj + ", mStatusCode=" + this.hf + ", mMsg='" + this.w + "', mIsDataError=" + this.u + '}';
    }
}

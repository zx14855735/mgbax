package com.bytedance.pangle.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class e extends Exception {
    public final int xj;

    public e(int i, String str) {
        super(str);
        this.xj = i;
    }

    public e(int i, String str, Throwable th) {
        super(str, th);
        this.xj = i;
    }
}

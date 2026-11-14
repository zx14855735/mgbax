package com.bytedance.msdk.api.u.xj.hf;

import ADYaiT.CtFAbx;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private String hf;
    private int xj;

    public xj(int i, String str) {
        this.xj = i;
        this.hf = str;
    }

    public String hf() {
        return this.hf;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GMCustomAdError{mCode=");
        sb.append(this.xj);
        sb.append(", mMessage='");
        return CtFAbx.B25kr6(sb, this.hf, "'}");
    }

    public int xj() {
        return this.xj;
    }
}

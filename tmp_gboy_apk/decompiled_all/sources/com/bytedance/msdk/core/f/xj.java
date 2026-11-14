package com.bytedance.msdk.core.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private String hf;
    private String u;
    private long w;
    private String xj;

    public xj(String str, String str2, long j) {
        this(str, str2, j, null);
    }

    public String hf() {
        return this.u;
    }

    public String toString() {
        return "AdnLoadFailShowBean{slotId='" + this.xj + "', adnName='" + this.hf + "', effectiveTime=" + this.w + '}';
    }

    public long xj() {
        return this.w;
    }

    public xj(String str, String str2, long j, String str3) {
        this.xj = str2;
        this.hf = str;
        this.w = j;
        this.u = str3;
    }
}

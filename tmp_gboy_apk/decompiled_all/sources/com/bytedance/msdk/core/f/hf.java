package com.bytedance.msdk.core.f;

import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private List<String> hf;
    private long w;
    private List<String> xj;

    public List<String> hf() {
        return this.xj;
    }

    public String toString() {
        return "AdnLoadFailShowConfigBean{ breadRequestErrorCode=" + this.xj + ",ritList=" + this.hf + ",breadRequestDuration=" + this.w + " }";
    }

    public List<String> w() {
        return this.hf;
    }

    public long xj() {
        return this.w;
    }

    public void hf(List<String> list) {
        this.hf = list;
    }

    public void xj(long j) {
        this.w = j;
    }

    public void xj(List<String> list) {
        this.xj = list;
    }
}

package com.bytedance.msdk.f.xj;

import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private String hf;
    private long kd;
    private String u;
    private String w;
    private String xj;

    public void hf(String str) {
        this.hf = str;
    }

    public String toString() {
        return "MediationBehaviorDbData{primeRit='" + this.xj + "', adnRit='" + this.hf + "', adnName='" + this.w + "', adAction='" + this.u + "', timeStamp=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(this.kd)) + '}';
    }

    public void u(String str) {
        this.u = str;
    }

    public void w(String str) {
        this.w = str;
    }

    public void xj(String str) {
        this.xj = str;
    }

    public String xj() {
        return this.u;
    }

    public void xj(long j) {
        this.kd = j;
    }
}

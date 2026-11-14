package com.bytedance.msdk.core.f;

import J3FDQU.A2egSU;
import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class u {
    protected String hf;
    protected int kd;
    protected String u;
    protected String w;
    protected String xj;
    private boolean y;

    public u(String str, String str2, String str3, String str4, int i) {
        this.xj = str;
        this.w = str3;
        this.kd = i;
        this.hf = str2;
        this.y = !TextUtils.isEmpty(str2);
        this.u = str4;
    }

    public int c() {
        return this.kd;
    }

    public boolean f() {
        return this.kd == 1;
    }

    public String hf() {
        return this.xj;
    }

    public String kd() {
        return this.w;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BaseIntervalBean{waterfallId='");
        sb.append(this.xj);
        sb.append("', showRulesVersion='");
        sb.append(this.w);
        sb.append("', timingMode=");
        return A2egSU.B2KMhB(sb, this.kd, '}');
    }

    public String u() {
        if (TextUtils.isEmpty(this.hf)) {
            return this.xj;
        }
        return this.xj + "_" + this.hf;
    }

    public String w() {
        return this.hf;
    }

    public boolean xj() {
        return this.y;
    }

    public String y() {
        return this.u;
    }
}

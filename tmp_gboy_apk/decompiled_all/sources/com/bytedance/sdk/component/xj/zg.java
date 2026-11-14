package com.bytedance.sdk.component.xj;

import ADYaiT.CtFAbx;
import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class zg {
    public final String c;
    public final String f;
    public final String hf;
    public final String kd;
    public final String u;
    public final String w;
    public final int xj;
    public final String y;

    public static final class xj {
        private String c;
        private String hf;
        private String kd;
        private String u;
        private String w;
        private String xj;
        private String y;

        private xj() {
        }

        public xj c(String str) {
            this.c = str;
            return this;
        }

        public xj hf(String str) {
            this.hf = str;
            return this;
        }

        public xj kd(String str) {
            this.kd = str;
            return this;
        }

        public xj u(String str) {
            this.u = str;
            return this;
        }

        public xj w(String str) {
            this.w = str;
            return this;
        }

        public xj xj(String str) {
            this.xj = str;
            return this;
        }

        public xj y(String str) {
            this.y = str;
            return this;
        }

        public zg xj() {
            return new zg(this);
        }
    }

    public static xj xj() {
        return new xj();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("methodName: ");
        sb.append(this.u);
        sb.append(", params: ");
        sb.append(this.kd);
        sb.append(", callbackId: ");
        sb.append(this.y);
        sb.append(", type: ");
        sb.append(this.w);
        sb.append(", version: ");
        return CtFAbx.B25kr6(sb, this.hf, ", ");
    }

    private zg(String str, int i) {
        this.hf = null;
        this.w = null;
        this.u = null;
        this.kd = null;
        this.y = str;
        this.c = null;
        this.xj = i;
        this.f = null;
    }

    public static zg xj(String str, int i) {
        return new zg(str, i);
    }

    public static boolean xj(zg zgVar) {
        return zgVar == null || zgVar.xj != 1 || TextUtils.isEmpty(zgVar.u) || TextUtils.isEmpty(zgVar.kd);
    }

    private zg(xj xjVar) {
        this.hf = xjVar.xj;
        this.w = xjVar.hf;
        this.u = xjVar.w;
        this.kd = xjVar.u;
        this.y = xjVar.kd;
        this.c = xjVar.y;
        this.xj = 1;
        this.f = xjVar.c;
    }
}

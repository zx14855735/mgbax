package com.bytedance.sdk.openadsdk.core.ra;

import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class z {
    private int hf;
    private boolean kd;
    private double u;
    private int w;
    private String xj;
    private String y;

    public static final class xj extends com.bytedance.sdk.openadsdk.zg.w.hf.pl {
        private int hf;
        private double u;
        private String w;
        private int xj;

        public xj(int i, int i2, String str, double d) {
            this.xj = i;
            this.hf = i2;
            this.w = str;
            this.u = d;
        }

        @Override // com.bytedance.sdk.openadsdk.zg.w.hf.pl
        public int hf() {
            return this.hf;
        }

        @Override // com.bytedance.sdk.openadsdk.zg.w.hf.pl
        public boolean kd() {
            String str;
            return this.xj > 0 && this.hf > 0 && (str = this.w) != null && str.length() > 0;
        }

        @Override // com.bytedance.sdk.openadsdk.zg.w.hf.pl
        public double u() {
            return this.u;
        }

        @Override // com.bytedance.sdk.openadsdk.zg.w.hf.pl
        public String w() {
            return this.w;
        }

        @Override // com.bytedance.sdk.openadsdk.zg.w.hf.pl
        public int xj() {
            return this.xj;
        }
    }

    public String c() {
        return this.y;
    }

    public int hf() {
        return this.hf;
    }

    public boolean kd() {
        return !TextUtils.isEmpty(this.xj) && this.hf > 0 && this.w > 0;
    }

    public double u() {
        return this.u;
    }

    public int w() {
        return this.w;
    }

    public String xj() {
        return this.xj;
    }

    public boolean y() {
        return this.kd;
    }

    public void hf(int i) {
        this.w = i;
    }

    public void xj(String str) {
        this.xj = str;
    }

    public void hf(String str) {
        this.y = str;
    }

    public void xj(int i) {
        this.hf = i;
    }

    public void xj(double d) {
        this.u = d;
    }

    public void xj(boolean z) {
        this.kd = z;
    }

    public static com.bytedance.sdk.openadsdk.zg.w.hf.pl xj(z zVar) {
        if (zVar == null || !zVar.kd()) {
            return null;
        }
        return new xj(zVar.w(), zVar.hf(), zVar.xj(), zVar.u());
    }

    public static final com.bytedance.sdk.openadsdk.zg.w.hf.pl xj(int i, int i2, String str, double d) {
        return new xj(i, i2, str, d);
    }
}

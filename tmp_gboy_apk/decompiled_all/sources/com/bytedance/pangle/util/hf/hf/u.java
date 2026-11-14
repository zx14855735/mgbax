package com.bytedance.pangle.util.hf.hf;

import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    private final File u;
    private xj xj = new xj();
    private hf hf = new hf();
    private final com.bytedance.pangle.util.hf.xj.w w = new com.bytedance.pangle.util.hf.xj.w();

    public u(String str) {
        this.u = new File(str);
    }

    public hf hf() {
        return this.hf;
    }

    public com.bytedance.pangle.util.hf.xj.w u() {
        return this.w;
    }

    public File w() {
        return this.u;
    }

    public xj xj() {
        return this.xj;
    }

    public void xj(xj xjVar) {
        this.xj = xjVar;
    }

    public void xj(hf hfVar) {
        this.hf = hfVar;
    }
}

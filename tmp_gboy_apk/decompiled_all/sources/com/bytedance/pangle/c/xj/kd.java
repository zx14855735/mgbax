package com.bytedance.pangle.c.xj;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd {
    public int hf;
    public com.bytedance.pangle.w.xj w;
    public String xj;

    public kd(String str, int i) {
        this.xj = str;
        this.hf = i;
    }

    public kd(com.bytedance.pangle.w.xj xjVar) {
        if (xjVar != null) {
            this.xj = xjVar.hf();
            this.hf = xjVar.w();
            this.w = xjVar;
        }
    }
}

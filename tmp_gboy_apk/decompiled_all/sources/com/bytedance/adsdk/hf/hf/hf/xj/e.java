package com.bytedance.adsdk.hf.hf.hf.xj;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class e implements com.bytedance.adsdk.hf.hf.hf.xj {
    protected com.bytedance.adsdk.hf.hf.hf.xj hf;
    protected com.bytedance.adsdk.hf.hf.u.w w;
    protected com.bytedance.adsdk.hf.hf.hf.xj xj;

    public e(com.bytedance.adsdk.hf.hf.u.w wVar) {
        this.w = wVar;
    }

    public void hf(com.bytedance.adsdk.hf.hf.hf.xj xjVar) {
        this.hf = xjVar;
    }

    public String toString() {
        return hf();
    }

    public void xj(com.bytedance.adsdk.hf.hf.hf.xj xjVar) {
        this.xj = xjVar;
    }

    @Override // com.bytedance.adsdk.hf.hf.hf.xj
    public String hf() {
        return this.xj.hf() + this.w.xj() + this.hf.hf();
    }

    @Override // com.bytedance.adsdk.hf.hf.hf.xj
    public com.bytedance.adsdk.hf.hf.u.kd xj() {
        return com.bytedance.adsdk.hf.hf.u.y.OPERATOR_RESULT;
    }
}

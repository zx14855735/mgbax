package com.bytedance.sdk.openadsdk.core.ra;

import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class pl extends com.bytedance.sdk.openadsdk.zg.w.hf.w {
    private y xj;

    public pl(ws wsVar) {
        if (wsVar == null) {
            return;
        }
        this.xj = wsVar.ut();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.w
    public String c() {
        y yVar = this.xj;
        if (yVar == null) {
            return null;
        }
        return yVar.d();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.w
    public String d() {
        y yVar = this.xj;
        if (yVar == null) {
            return null;
        }
        return yVar.tf();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.w
    public String f() {
        y yVar = this.xj;
        if (yVar == null) {
            return null;
        }
        return yVar.p();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.w
    public String hf() {
        y yVar = this.xj;
        return yVar == null ? "" : yVar.kd();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.w
    public Map<String, String> kd() {
        y yVar = this.xj;
        if (yVar == null) {
            return null;
        }
        return yVar.xj();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.w
    public String u() {
        y yVar = this.xj;
        return yVar == null ? "" : yVar.f();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.w
    public String w() {
        y yVar = this.xj;
        return yVar == null ? "" : yVar.c();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.w
    public String xj() {
        y yVar = this.xj;
        return yVar == null ? "" : yVar.am();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.w
    public String y() {
        y yVar = this.xj;
        if (yVar == null) {
            return null;
        }
        return yVar.hf();
    }
}

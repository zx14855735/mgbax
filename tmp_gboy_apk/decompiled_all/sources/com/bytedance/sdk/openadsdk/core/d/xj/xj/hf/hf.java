package com.bytedance.sdk.openadsdk.core.d.xj.xj.hf;

import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements com.bytedance.sdk.openadsdk.core.d.xj.xj.xj {
    private com.bytedance.sdk.openadsdk.core.d.xj.xj.xj hf;
    private com.bytedance.sdk.openadsdk.core.video.hf.hf xj;

    public hf(com.bytedance.sdk.openadsdk.core.d.xj.xj.xj xjVar, com.bytedance.sdk.openadsdk.core.video.hf.hf hfVar) {
        this.hf = xjVar;
        this.xj = hfVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.d.xj.xj.xj
    public boolean xj(Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.video.hf.hf hfVar = this.xj;
        if (hfVar == null) {
            return this.hf.xj(map);
        }
        if (hfVar.xj()) {
            return true;
        }
        com.bytedance.sdk.openadsdk.core.d.xj.xj.xj xjVar = this.hf;
        if (xjVar == null) {
            return false;
        }
        return xjVar.xj(map);
    }

    public hf(com.bytedance.sdk.openadsdk.core.video.hf.hf hfVar) {
        this.xj = hfVar;
    }
}

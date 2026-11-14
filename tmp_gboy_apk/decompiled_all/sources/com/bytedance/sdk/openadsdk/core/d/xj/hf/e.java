package com.bytedance.sdk.openadsdk.core.d.xj.hf;

import java.util.Map;

@com.bytedance.sdk.component.p.hf.hf
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class e implements com.bytedance.sdk.component.p.xj.xj.w {

    @com.bytedance.sdk.component.p.hf.xj(xj = "reward_dialog_callback")
    private com.bytedance.sdk.openadsdk.core.component.reward.w.tf xj;

    @Override // com.bytedance.sdk.component.p.xj.xj.w
    public boolean xj(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.p.xj.xj xjVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.w.tf tfVar = this.xj;
        if (tfVar == null) {
            xjVar.hf(map2);
            return true;
        }
        tfVar.hf();
        xjVar.xj(map2);
        return true;
    }
}

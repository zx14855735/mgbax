package com.bytedance.sdk.gromore.xj.xj.u;

import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c extends com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.xj {
    private com.bytedance.sdk.gromore.xj.xj.hf xj;

    public c(com.bytedance.sdk.gromore.xj.xj.hf hfVar) {
        this.xj = hfVar;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.xj
    public String getAbTestId() {
        com.bytedance.sdk.gromore.xj.xj.hf hfVar = this.xj;
        return hfVar != null ? hfVar.qt() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.xj
    public String getChannel() {
        com.bytedance.sdk.gromore.xj.xj.hf hfVar = this.xj;
        return hfVar != null ? hfVar.g() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.xj
    public Map<String, String> getCustomData() {
        com.bytedance.sdk.gromore.xj.xj.hf hfVar = this.xj;
        if (hfVar != null) {
            return hfVar.xj();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.xj
    public String getCustomSdkName() {
        com.bytedance.sdk.gromore.xj.xj.hf hfVar = this.xj;
        return hfVar != null ? hfVar.w() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.xj
    public String getEcpm() {
        com.bytedance.sdk.gromore.xj.xj.hf hfVar = this.xj;
        return hfVar != null ? hfVar.y() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.xj
    public String getErrorMsg() {
        com.bytedance.sdk.gromore.xj.xj.hf hfVar = this.xj;
        return hfVar != null ? hfVar.f() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.xj
    public String getLevelTag() {
        com.bytedance.sdk.gromore.xj.xj.hf hfVar = this.xj;
        return hfVar != null ? hfVar.kd() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.xj
    public int getReqBiddingType() {
        com.bytedance.sdk.gromore.xj.xj.hf hfVar = this.xj;
        if (hfVar != null) {
            return hfVar.c();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.xj
    public String getRequestId() {
        com.bytedance.sdk.gromore.xj.xj.hf hfVar = this.xj;
        return hfVar != null ? hfVar.d() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.xj
    public String getRitType() {
        com.bytedance.sdk.gromore.xj.xj.hf hfVar = this.xj;
        return hfVar != null ? hfVar.tf() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.xj
    public String getScenarioId() {
        com.bytedance.sdk.gromore.xj.xj.hf hfVar = this.xj;
        return hfVar != null ? hfVar.zg() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.xj
    public String getSdkName() {
        com.bytedance.sdk.gromore.xj.xj.hf hfVar = this.xj;
        return hfVar != null ? hfVar.hf() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.xj
    public String getSegmentId() {
        com.bytedance.sdk.gromore.xj.xj.hf hfVar = this.xj;
        return hfVar != null ? hfVar.pl() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.xj
    public String getSlotId() {
        com.bytedance.sdk.gromore.xj.xj.hf hfVar = this.xj;
        return hfVar != null ? hfVar.u() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.xj
    public String getSubChannel() {
        com.bytedance.sdk.gromore.xj.xj.hf hfVar = this.xj;
        return hfVar != null ? hfVar.am() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.xj
    public String getSubRitType() {
        com.bytedance.sdk.gromore.xj.xj.hf hfVar = this.xj;
        return hfVar != null ? hfVar.p() : "";
    }
}

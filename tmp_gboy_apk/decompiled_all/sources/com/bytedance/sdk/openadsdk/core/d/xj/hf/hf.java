package com.bytedance.sdk.openadsdk.core.d.xj.hf;

import android.content.Context;
import com.bytedance.sdk.component.p.xj.hf;
import com.bytedance.sdk.openadsdk.core.a.y;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

@com.bytedance.sdk.component.p.hf.hf
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements com.bytedance.sdk.component.p.xj.xj.w {

    @com.bytedance.sdk.component.p.hf.xj(xj = "deny_event")
    private String c;

    @com.bytedance.sdk.component.p.hf.xj(xj = "cancel_event")
    private String f;

    @com.bytedance.sdk.component.p.hf.xj(xj = "material_meta")
    private ws hf;

    @com.bytedance.sdk.component.p.hf.xj(xj = "app_manage_model")
    private String kd;

    @com.bytedance.sdk.component.p.hf.xj(xj = "function_desc_popup_listener")
    private y.xj u;

    @com.bytedance.sdk.component.p.hf.xj(xj = MediationConstant.EXTRA_ADID)
    private String w;

    @com.bytedance.sdk.component.p.hf.xj(xj = "context")
    private Context xj;

    @com.bytedance.sdk.component.p.hf.xj(xj = "confirm_event")
    private String y;

    @Override // com.bytedance.sdk.component.p.xj.xj.w
    public boolean xj(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.p.xj.xj xjVar) {
        com.bytedance.sdk.openadsdk.core.a.y.xj(this.w, xj());
        TTDelegateActivity.w(this.xj, this.w, this.kd);
        xjVar.xj(map2);
        return true;
    }

    private y.xj xj() {
        return new y.xj() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.hf.hf.1
            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnNo() {
                if (hf.this.u == null) {
                    return;
                }
                hf.this.u.onDialogBtnNo();
                hf hfVar = hf.this;
                hfVar.xj(hfVar.c);
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogBtnYes() {
                if (hf.this.u == null) {
                    return;
                }
                hf.this.u.onDialogBtnYes();
                hf hfVar = hf.this;
                hfVar.xj(hfVar.y);
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
            public void onDialogCancel() {
                if (hf.this.u == null) {
                    return;
                }
                hf.this.u.onDialogCancel();
                hf hfVar = hf.this;
                hfVar.xj(hfVar.f);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("material_meta", this.hf);
        hashMap.put("context", this.xj);
        new hf.xj(str).xj(this.hf.ac()).xj(hashMap).xj().xj();
    }
}

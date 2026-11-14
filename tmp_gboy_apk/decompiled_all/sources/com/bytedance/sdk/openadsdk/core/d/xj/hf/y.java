package com.bytedance.sdk.openadsdk.core.d.xj.hf;

import android.app.Dialog;
import android.content.Context;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.Map;

@com.bytedance.sdk.component.p.hf.hf
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y implements com.bytedance.sdk.component.p.xj.xj.w {

    @com.bytedance.sdk.component.p.hf.xj(xj = "ad_dislike")
    private com.bytedance.sdk.openadsdk.core.dislike.ui.xj hf;

    @com.bytedance.sdk.component.p.hf.xj(xj = "material_meta")
    private ws u;

    @com.bytedance.sdk.component.p.hf.xj(xj = "context")
    private Context w;

    @com.bytedance.sdk.component.p.hf.xj(xj = "outer_dislike")
    private Dialog xj;

    @Override // com.bytedance.sdk.component.p.xj.xj.w
    public boolean xj(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.p.xj.xj xjVar) {
        Dialog dialog = this.xj;
        if (dialog != null) {
            dialog.show();
            xjVar.xj(map2);
            return true;
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.xj xjVar2 = this.hf;
        if (xjVar2 != null) {
            xjVar2.xj();
            xjVar.xj(map2);
            return true;
        }
        TTDelegateActivity.xj(this.w, this.u);
        xjVar.xj(map2);
        return true;
    }
}

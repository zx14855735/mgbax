package com.bytedance.sdk.openadsdk.core.d.xj.hf;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import java.util.Map;

@com.bytedance.sdk.component.p.hf.hf
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements com.bytedance.sdk.component.p.xj.xj.w {

    @com.bytedance.sdk.component.p.hf.xj(xj = "title")
    private String hf;

    @com.bytedance.sdk.component.p.hf.xj(xj = "context")
    private Context w;

    @com.bytedance.sdk.component.p.hf.xj(xj = "url")
    private String xj;

    @Override // com.bytedance.sdk.component.p.xj.xj.w
    public boolean xj(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.p.xj.xj xjVar) {
        TTDelegateActivity.u(this.w, this.xj, this.hf);
        xjVar.xj(map2);
        return true;
    }
}

package com.bytedance.sdk.openadsdk.core.d.xj.hf;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.Map;

@com.bytedance.sdk.component.p.hf.hf
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class am implements com.bytedance.sdk.component.p.xj.xj.w {

    @com.bytedance.sdk.component.p.hf.xj(xj = "context")
    private Context hf;

    @com.bytedance.sdk.component.p.hf.xj(xj = "material_meta")
    private ws xj;

    @Override // com.bytedance.sdk.component.p.xj.xj.w
    public boolean xj(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.p.xj.xj xjVar) {
        Context context;
        ws wsVar = this.xj;
        if (wsVar == null || (context = this.hf) == null) {
            xjVar.hf(map2);
            return true;
        }
        com.bytedance.sdk.openadsdk.core.a.y.xj(context, wsVar);
        xjVar.xj(map2);
        return true;
    }
}

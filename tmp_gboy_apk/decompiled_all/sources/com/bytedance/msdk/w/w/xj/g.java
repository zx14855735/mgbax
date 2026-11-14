package com.bytedance.msdk.w.w.xj;

import android.text.TextUtils;
import com.bytedance.msdk.w.w.xj.xj;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class g implements xj {
    @Override // com.bytedance.msdk.w.w.xj.xj
    public void hf(xj.InterfaceC0086xj interfaceC0086xj) {
        interfaceC0086xj.xj((String) null);
    }

    @Override // com.bytedance.msdk.w.w.xj.xj
    public void xj(xj.InterfaceC0086xj interfaceC0086xj) {
        com.bytedance.msdk.w.y.xj.hf xj = interfaceC0086xj.xj();
        com.bytedance.msdk.api.xj.hf v = xj.v();
        String xj2 = com.bytedance.msdk.core.qt.xj.xj(v.a());
        if (!TextUtils.isEmpty(xj2)) {
            v.u(2);
            com.bytedance.msdk.core.tf.hf xj3 = com.bytedance.msdk.core.qt.xj.xj(xj.pl(), xj2);
            if (xj3 == null) {
                com.bytedance.msdk.kd.y.xj(xj.v(), (String) null, !xj.ra(), xj.ff().xj, 81012, (Map<String, Object>) null);
                xj.xj(new com.bytedance.msdk.api.hf.xj(81012, com.bytedance.msdk.api.xj.xj(81012)));
                return;
            }
            xj.xj(xj3);
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(xj3) + "测试工具加载广告........rit_id:" + v.ra() + " ,slot_id:" + xj2);
        }
        interfaceC0086xj.xj(interfaceC0086xj.xj());
    }
}

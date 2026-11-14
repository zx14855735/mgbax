package com.bytedance.sdk.openadsdk.core.component.reward.swiper;

import com.bykv.vk.openvk.component.video.api.w.u;
import com.bytedance.sdk.openadsdk.core.a.ff;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.draw.hf;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.dk;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.x;
import com.bytedance.sdk.openadsdk.x.tf;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends hf {
    private boolean y;

    public xj(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar, String str, boolean z, boolean z2) {
        super(tTBaseVideoActivity, wsVar, str, z, z2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.hf
    public u tf() {
        u xj = h.xj(1, this.hf);
        xj.hf(this.hf.ho());
        xj.hf(100);
        xj.w(100);
        xj.w(this.hf.jf());
        xj.hf(this.u);
        if (tf.xj(this.hf)) {
            xj.xj(true);
        }
        return xj;
    }

    public void w(boolean z) {
        this.y = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.hf
    public void xj(NativeExpressView nativeExpressView) {
        Map<String, Object> xj = this.xj.xj(this.hf);
        if (nativeExpressView.getDynamicShowType() == 0) {
            dk.xj(xj, this.hf, nativeExpressView);
        } else {
            xj.put("dynamic_show_type", Integer.valueOf(nativeExpressView.getDynamicShowType()));
        }
        x lq = this.hf.lq();
        Double d = null;
        if (lq != null) {
            xj.put("refresh_num", Integer.valueOf(lq.w()));
            if (this.y) {
                d = this.xj.n();
            }
        }
        com.bytedance.sdk.openadsdk.core.am.u.xj(this.hf, this.w, xj, d);
        com.bytedance.sdk.openadsdk.core.q.xj.xj().u();
        ff.xj(this.hf.kd());
    }
}

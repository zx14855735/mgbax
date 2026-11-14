package com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.w.hf;
import com.bytedance.sdk.openadsdk.core.component.reward.w.tf;
import com.bytedance.sdk.openadsdk.core.ra.n;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.xv;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u extends xj {
    xj hf;

    public u(Activity activity, ws wsVar) {
        super(activity, wsVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public void hf(String str) {
        super.hf(str);
        xj xjVar = this.hf;
        if (xjVar == null) {
            return;
        }
        xjVar.hf(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.hf.xj.xj, com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public hf.xj xj(tf tfVar) {
        ArrayList<xv> kd = n.kd(this.c);
        if (kd == null) {
            return new hf.xj(false, 0, "");
        }
        Iterator<xv> it = kd.iterator();
        while (it.hasNext()) {
            xv next = it.next();
            if (next.w() == 1) {
                this.hf = new w(this.f, this.c, next);
            }
            xj xjVar = this.hf;
            if (xjVar != null) {
                xjVar.w(this.f10325pl);
                this.hf.u(this.p);
                this.hf.xj(this.xj);
                this.hf.hf(d());
                this.hf.xj(this.zg);
                hf.xj xj = this.hf.xj(tfVar);
                if (xj.w()) {
                    return xj;
                }
            }
        }
        return new hf.xj(false, 0, "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public String xj() {
        xj xjVar = this.hf;
        if (xjVar == null) {
            return null;
        }
        return xjVar.xj();
    }
}

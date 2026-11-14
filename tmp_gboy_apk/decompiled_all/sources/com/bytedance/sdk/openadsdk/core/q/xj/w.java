package com.bytedance.sdk.openadsdk.core.q.xj;

import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.ht;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.x.c;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends xj {
    /* JADX INFO: Access modifiers changed from: private */
    public ht xj() {
        ht htVar = new ht(pz.getContext(), 1, f.zg().kd());
        boolean xj = htVar.xj(0);
        xj(xj ? 1 : 0, System.currentTimeMillis(), 0L);
        try {
            htVar.hf(0);
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public void xj(JSONObject jSONObject, int i) {
        if (System.currentTimeMillis() - com.bytedance.sdk.openadsdk.core.q.xj.xj().hf() > xj(i)) {
            c.xj(new d("reg_sensor") { // from class: com.bytedance.sdk.openadsdk.core.q.xj.w.1
                @Override // java.lang.Runnable
                public void run() {
                    w.this.xj();
                }
            });
        }
    }
}

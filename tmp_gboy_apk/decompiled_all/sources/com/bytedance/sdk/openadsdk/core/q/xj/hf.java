package com.bytedance.sdk.openadsdk.core.q.xj;

import android.os.Message;
import com.bytedance.sdk.component.utils.ai;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.ht;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.pz;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends xj implements ai.xj {
    private ht hf;
    private final ai xj = new ai(f.xj().getLooper(), this);

    public void xj(JSONObject jSONObject, int i) {
        int xj = xj(i);
        if (hf(i)) {
            xj(jSONObject, com.bytedance.sdk.openadsdk.core.q.xj.xj().hf(), xj);
        } else if (w(i)) {
            xj(jSONObject, com.bytedance.sdk.openadsdk.core.q.xj.xj().w(), xj);
        }
    }

    private void xj(JSONObject jSONObject, long j, long j2) {
        if (System.currentTimeMillis() - j > j2) {
            this.hf = xj();
            this.xj.removeCallbacksAndMessages(null);
            this.xj.sendEmptyMessage(1);
        }
    }

    private ht xj() {
        ht htVar = new ht(pz.getContext(), 1, com.bytedance.sdk.openadsdk.core.f.zg().kd());
        boolean xj = htVar.xj(0);
        pl.hf("csj_sen", "reg res:".concat(String.valueOf(xj)));
        if (xj) {
            return htVar;
        }
        xj(0, System.currentTimeMillis(), 0L);
        htVar.hf(0);
        return null;
    }

    @Override // com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            ht htVar = this.hf;
            if (htVar != null) {
                htVar.hf(0);
            }
            xj(3, 0L, System.currentTimeMillis());
            return;
        }
        ht htVar2 = this.hf;
        if (htVar2 == null) {
            return;
        }
        htVar2.xj(new ht.w() { // from class: com.bytedance.sdk.openadsdk.core.q.xj.hf.1
            @Override // com.bytedance.sdk.component.utils.ht.w
            public void xj() {
                hf.this.xj(1, System.currentTimeMillis(), 0L);
                if (hf.this.xj != null) {
                    hf.this.xj.removeCallbacksAndMessages(null);
                }
                if (hf.this.hf != null) {
                    hf.this.hf.hf(0);
                }
            }
        });
        this.xj.sendEmptyMessageDelayed(2, xj(pz.hf().vl()));
    }
}

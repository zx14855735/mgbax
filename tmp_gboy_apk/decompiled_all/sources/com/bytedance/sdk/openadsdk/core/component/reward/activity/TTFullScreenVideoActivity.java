package com.bytedance.sdk.openadsdk.core.component.reward.activity;

import com.bytedance.sdk.openadsdk.core.component.reward.xj;
import com.bytedance.sdk.openadsdk.core.component.reward.xj.hf;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.aq;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class TTFullScreenVideoActivity extends TTBaseVideoActivity {
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public boolean io() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void u(String str) {
        xj.xj(1, this.n, str, null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void w(boolean z) {
        char c = 65535;
        if (this.dk) {
            if (pz.hf().xw() == 1) {
                c = 2000;
            }
        } else if (z) {
            c = 0;
        }
        if (c < 0 || this.pz.get()) {
            return;
        }
        if (c != 0) {
            this.hf.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TTFullScreenVideoActivity.this.pz.getAndSet(true)) {
                        return;
                    }
                    hf.xj().xj(String.valueOf(TTFullScreenVideoActivity.this.tj));
                }
            }, 2000L);
        } else {
            if (this.pz.getAndSet(true)) {
                return;
            }
            hf.xj().xj(String.valueOf(this.tj));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void x() {
        if (this.w.getAndSet(true)) {
            return;
        }
        u("onAdClose");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void yy() {
        String str;
        super.yy();
        if (aq.e(this.kd) || this.l.q()) {
            return;
        }
        if (this.f10297a.l()) {
            this.en.xj(false, null, null, true, true);
            return;
        }
        int z = ((int) this.f10297a.z()) / 1000;
        String str2 = this.b.y(false) + "s";
        boolean z2 = z >= this.b.hl();
        if (z2) {
            str = "跳过";
        } else if (pz.hf().kd(String.valueOf(this.tj))) {
            str = (this.b.hl() - z) + "s后可跳过";
        } else {
            str = null;
        }
        this.en.xj(false, str2, str, false, z2);
    }
}

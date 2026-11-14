package com.bytedance.sdk.openadsdk.core.component.reward.u;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.aq;
import com.bytedance.sdk.openadsdk.core.ra.d;
import com.bytedance.sdk.openadsdk.core.ra.dc;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.wo;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class tf extends xj {
    private boolean j;
    boolean z;

    public tf(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar) {
        super(tTBaseVideoActivity, wsVar);
        this.z = false;
        this.j = false;
        this.j = com.bytedance.sdk.openadsdk.core.live.w.hf.xj(wsVar) == 1;
    }

    private void f(final boolean z) {
        if (this.d instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.d) {
            com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.tf.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.component.reward.layout.hf hfVar = tf.this.d;
                    if (hfVar == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.component.reward.layout.d dVar = (com.bytedance.sdk.openadsdk.core.component.reward.layout.d) hfVar;
                    if (z) {
                        dVar.hf();
                    } else {
                        dVar.w();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nb() {
        if (this.z) {
            return;
        }
        this.z = true;
        f(false);
        this.xj.finish();
    }

    public static int xj(ws wsVar) {
        return 9;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public View d() {
        FrameLayout frameLayout = new FrameLayout(this.xj);
        frameLayout.setId(2114387959);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean dq() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public void gh() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public int q() {
        return xj(this.hf);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean s() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean tu() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj, com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public void w() {
        this.xj.hf(true, true);
        this.d.w(true);
        this.tf.w(false);
        this.yo.xj(false);
        int f = r.f(pz.getContext());
        com.bytedance.sdk.openadsdk.core.am.u.xj("click", this.hf, new d.xj().y(-1.0f).kd(-1.0f).u(-1.0f).w(-1.0f).hf(-1L).xj(-1L).w(-1).u(-1).kd(-1024).hf(com.bytedance.sdk.openadsdk.core.f.zg().w() ? 1 : 2).xj(f).xj(r.y(pz.getContext())).hf(r.c(pz.getContext())).xj(), this.f10322pl, true, this.xj.tj(), -1, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public boolean y() {
        return false;
    }

    public static boolean xj(Context context, ws wsVar) {
        long y;
        if (!dc.u(wsVar)) {
            return false;
        }
        if (wo.xj(wsVar)) {
            y = wo.hf(wsVar) * 1000;
        } else {
            y = h.am(wsVar) != null ? (long) (h.y(wsVar) * 1000.0d) : 0L;
        }
        long min = Math.min(aq.xj(), (long) ((wsVar.tq() / 100.0f) * y));
        HashMap hashMap = new HashMap(3);
        hashMap.put("reward_countdown", Long.valueOf(min));
        hashMap.put("event_tag", "rewarded_video");
        hashMap.put("reward_live_scene", Integer.valueOf(com.bytedance.sdk.openadsdk.core.live.w.hf.xj(wsVar)));
        return com.bytedance.sdk.openadsdk.core.live.hf.xj().hf(context, wsVar, hashMap) == 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.hf xj(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.d dVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.d(this.xj, this.hf, z);
        this.d = dVar;
        return dVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void xj(int i, int i2, Intent intent) {
        super.xj(i, i2, intent);
        if (i != 1) {
            this.xj.finish();
            return;
        }
        if (intent == null || intent.getExtras() == null) {
            this.xj.finish();
            return;
        }
        if (intent.getExtras().getLong("csj.reward_countdown_duration_ms") <= 0) {
            int i3 = intent.getExtras().getInt("csj.reward_auth_status", 0);
            if (this.j && i3 == 1) {
                this.xj.finish();
                return;
            }
            com.bytedance.sdk.component.utils.pl.u("rewardAuthFlag", "verify rew....");
            this.xj.u(0);
            f(true);
            this.xj.wo().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.tf.1
                @Override // java.lang.Runnable
                public void run() {
                    tf.this.nb();
                }
            }, 2000L);
            return;
        }
        this.xj.finish();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void xj(int i) {
        super.xj(i);
        if (i == 0) {
            nb();
        }
    }
}

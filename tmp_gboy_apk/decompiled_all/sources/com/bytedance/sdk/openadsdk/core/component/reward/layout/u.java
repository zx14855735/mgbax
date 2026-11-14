package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.draw.RewardDrawRecyclerView;
import com.bytedance.sdk.openadsdk.core.component.reward.draw.RewardGuideSlideUp;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u extends hf {
    private boolean am;
    private com.bytedance.sdk.openadsdk.core.component.reward.draw.xj e;
    private boolean ht;
    private float jk;
    private boolean pz;
    private RewardGuideSlideUp qt;
    private float v;
    private com.bytedance.sdk.openadsdk.core.component.reward.draw.w yo;
    private RewardDrawRecyclerView zg;

    public u(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar, boolean z) {
        super(tTBaseVideoActivity, wsVar, z);
        this.pz = true;
    }

    public void kd() {
        if (this.am && this.pz) {
            this.c.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.u.1
                @Override // java.lang.Runnable
                public void run() {
                    if (u.this.am && u.this.pz) {
                        u.this.pz = false;
                        r.xj((View) u.this.qt, 0);
                        u.this.qt.getSlideUpAnimatorSet().start();
                        u.this.ht = true;
                        u.this.c.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.u.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                u.this.y();
                            }
                        }, 3000L);
                    }
                }
            }, 0L);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.hf
    public void tf() {
        super.tf();
        y();
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.draw.w u() {
        return this.yo;
    }

    public void y() {
        if (this.am) {
            this.pz = false;
            if (this.ht) {
                r.xj((View) this.qt, 8);
                RewardGuideSlideUp rewardGuideSlideUp = this.qt;
                if (rewardGuideSlideUp != null) {
                    rewardGuideSlideUp.hf();
                }
                this.ht = false;
            }
        }
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.draw.xj w() {
        return this.e;
    }

    public RecyclerView hf() {
        return this.zg;
    }

    public void xj(float[] fArr) {
        this.v = fArr[0];
        this.jk = fArr[1];
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.hf
    public void xj() {
        super.xj();
        this.zg = (RewardDrawRecyclerView) this.c.findViewById(2114387885);
        com.bytedance.sdk.openadsdk.core.component.reward.draw.w wVar = new com.bytedance.sdk.openadsdk.core.component.reward.draw.w(this.hf, 0, false);
        this.yo = wVar;
        this.zg.setLayoutManager(wVar);
        com.bytedance.sdk.openadsdk.core.component.reward.draw.xj xjVar = new com.bytedance.sdk.openadsdk.core.component.reward.draw.xj(this.hf, this.v, this.jk);
        this.e = xjVar;
        this.zg.setAdapter(xjVar);
        if (this.am) {
            RewardGuideSlideUp rewardGuideSlideUp = (RewardGuideSlideUp) this.c.findViewById(2114387966);
            this.qt = rewardGuideSlideUp;
            rewardGuideSlideUp.xj();
        }
    }

    public void xj(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.draw.w wVar = this.yo;
        if (wVar == null) {
            return;
        }
        wVar.hf(false);
    }
}

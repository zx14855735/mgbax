package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.a.xj;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.PlayableEndcardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLpBottomView;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ugeno.c.xj;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends hf {
    private com.bytedance.sdk.openadsdk.core.ugeno.y.xj am;
    private com.bytedance.sdk.openadsdk.core.component.reward.hf.kd dk;
    private com.bytedance.sdk.openadsdk.core.ugeno.f.xj e;
    private boolean et;
    private AtomicBoolean ht;
    private String jk;
    private RewardLpBottomView pz;
    private com.bytedance.sdk.openadsdk.core.am.y qt;
    private AtomicBoolean ra;
    private AtomicBoolean v;
    private com.bytedance.sdk.openadsdk.core.ugeno.d.hf yo;
    private com.bytedance.sdk.openadsdk.core.ugeno.d.u zg;

    public xj(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar, boolean z, com.bytedance.sdk.openadsdk.core.am.y yVar, com.bytedance.sdk.openadsdk.core.component.reward.hf.kd kdVar) {
        super(tTBaseVideoActivity, wsVar, z);
        this.am = wsVar.x();
        this.qt = yVar;
        this.hf.c(0);
        this.v = new AtomicBoolean();
        this.ht = new AtomicBoolean();
        this.ra = new AtomicBoolean();
        this.dk = kdVar;
    }

    private void e() {
        com.bytedance.sdk.openadsdk.core.ugeno.d.u uVar = new com.bytedance.sdk.openadsdk.core.ugeno.d.u(this.hf, this.c, this.qt, this.w, this.jk, wo.hf(this.xj));
        this.zg = uVar;
        uVar.hf(true);
        this.zg.xj(new com.bytedance.sdk.openadsdk.core.ugeno.u.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.xj.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.u.xj
            public void xj(View view) {
                xj.this.hf.c(8);
                xj.this.v.set(true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.u.xj
            public void xj(int i) {
                v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.xj.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        xj.this.hf.c(8);
                        xj.this.hf.v();
                    }
                });
                xj.this.v.set(false);
            }
        });
        this.zg.g();
    }

    private ViewGroup jk() {
        if (this.c == null) {
            return null;
        }
        PlayableEndcardFrameLayout playableEndcardFrameLayout = new PlayableEndcardFrameLayout(this.hf);
        this.c.addView(playableEndcardFrameLayout);
        this.pz = new RewardLpBottomView(this.hf);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.c.addView(this.pz, layoutParams);
        this.pz.xj(this.w, this.jk);
        playableEndcardFrameLayout.xj(new PlayableEndcardFrameLayout.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.xj.9
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.PlayableEndcardFrameLayout.xj
            public void xj() {
                if (xj.this.pz != null) {
                    xj.this.pz.hf();
                }
            }
        });
        return playableEndcardFrameLayout;
    }

    private void v() {
        com.bytedance.sdk.openadsdk.core.ugeno.f.xj xjVar = new com.bytedance.sdk.openadsdk.core.ugeno.f.xj(this.hf, jk(), this.am, this.w);
        this.e = xjVar;
        xjVar.xj(this.hf.tj());
        this.e.xj(new com.bytedance.sdk.openadsdk.core.ugeno.u.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.xj.8
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.u.xj
            public void xj(View view) {
                com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.xj.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        xj.this.hf.c(8);
                        xj.this.v.set(true);
                        if (xj.this.pz != null) {
                            xj.this.pz.xj();
                        }
                    }
                });
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.u.xj
            public void xj(int i) {
                v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.xj.8.2
                    @Override // java.lang.Runnable
                    public void run() {
                        xj.this.hf.c(8);
                        xj.this.hf.v();
                    }
                });
                xj.this.v.set(false);
            }
        });
        this.e.xj();
    }

    private void yo() {
        FrameLayout frameLayout = new FrameLayout(this.hf);
        this.c.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ugeno.d.hf hfVar = new com.bytedance.sdk.openadsdk.core.ugeno.d.hf(this.hf, frameLayout, this.qt, this.w, this.jk, wo.hf(this.xj));
        this.yo = hfVar;
        hfVar.hf(true);
        this.yo.xj(new com.bytedance.sdk.openadsdk.core.ugeno.c.hf() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.xj.3
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.hf
            public void hf() {
                xj.this.hf.eu();
                xj.this.ht.set(true);
                xj.this.yo.jk();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.hf
            public void xj() {
                xj.this.hf.ws();
            }
        });
        this.yo.xj(new com.bytedance.sdk.openadsdk.core.ugeno.u.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.xj.4
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.u.xj
            public void xj(View view) {
                xj.this.hf.c(8);
                xj.this.v.set(true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.u.xj
            public void xj(int i) {
                v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.xj.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        xj.this.hf.c(8);
                        xj.this.yo.e();
                        xj.this.yo.xj(jk.xj(xj.this.hf, "tt_ecomm_page_reward_acquire"));
                        xj.this.hf.u(0);
                    }
                });
                xj.this.v.set(false);
            }
        });
        this.yo.xj(new xj.InterfaceC0184xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.xj.5
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.c.xj.InterfaceC0184xj
            public void xj() {
                v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.xj.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (xj.this.hf.tu()) {
                            xj.this.yo.xj(jk.xj(xj.this.hf, "tt_ecomm_page_reward_acquire"));
                        } else {
                            xj.this.yo.xj(String.format(jk.xj(xj.this.hf, "tt_ecomm_page_reward_tip"), Integer.valueOf(xj.this.hf.aq().a())));
                        }
                    }
                });
            }
        });
        this.yo.g();
        com.bytedance.sdk.openadsdk.core.f.zg().u().hf(new xj.hf() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.xj.6
            @Override // com.bytedance.sdk.openadsdk.core.a.xj.hf
            public void hf() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.xj.hf
            public void xj() {
                if (xj.this.ht.get() || !xj.this.yo.am()) {
                    xj.this.ra.set(false);
                } else {
                    xj.this.ra.set(true);
                }
            }
        });
        if (TextUtils.equals(this.am.xj(), "3")) {
            return;
        }
        hf();
    }

    public void c() {
        com.bytedance.sdk.openadsdk.core.ugeno.d.hf hfVar = this.yo;
        if (hfVar != null) {
            hfVar.v();
        }
    }

    public void d() {
        com.bytedance.sdk.openadsdk.core.ugeno.d.hf hfVar = this.yo;
        if (hfVar != null) {
            hfVar.pz();
        }
    }

    public void f() {
        com.bytedance.sdk.openadsdk.core.ugeno.d.hf hfVar = this.yo;
        if (hfVar != null) {
            hfVar.yo();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.hf
    public void tf() {
        com.bytedance.sdk.openadsdk.core.ugeno.f.xj xjVar = this.e;
        if (xjVar != null) {
            xjVar.hf();
        }
        com.bytedance.sdk.openadsdk.core.ugeno.d.hf hfVar = this.yo;
        if (hfVar != null) {
            hfVar.zg();
        }
        RewardLpBottomView rewardLpBottomView = this.pz;
        if (rewardLpBottomView != null) {
            rewardLpBottomView.hf();
        }
    }

    public void hf() {
        final ImageView imageView = new ImageView(this.hf);
        float w = r.w(this.hf, 18.0f);
        float w2 = r.w(this.hf, 20.0f);
        int i = (int) w;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
        layoutParams.gravity = 53;
        int i2 = (int) w2;
        layoutParams.setMargins(i2, i2, i2, i2);
        this.c.addView(imageView, layoutParams);
        jk.xj((Context) this.hf, "tt_unmute", imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.xj.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                xj.this.et = !r3.et;
                xj xjVar = xj.this;
                jk.xj((Context) xjVar.hf, xjVar.et ? "tt_mute" : "tt_unmute", imageView);
                xj.this.yo.w(xj.this.et);
            }
        });
    }

    public AtomicInteger kd() {
        return new AtomicInteger(0);
    }

    public boolean u() {
        com.bytedance.sdk.openadsdk.core.ugeno.d.hf hfVar = this.yo;
        if (hfVar != null) {
            return hfVar.am();
        }
        return false;
    }

    public boolean w() {
        return this.ra.get();
    }

    public boolean y() {
        return this.v.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.hf
    public void xj() {
        super.xj();
        this.jk = wo.xj(wo.hf(this.xj));
        com.bytedance.sdk.openadsdk.core.ugeno.y.xj xjVar = this.am;
        if (xjVar == null) {
            v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.xj.1
                @Override // java.lang.Runnable
                public void run() {
                    xj.this.hf.c(8);
                    xj.this.hf.v();
                }
            });
            return;
        }
        int u = xjVar.u();
        if (u == 2) {
            e();
            return;
        }
        if (u == 3) {
            yo();
        } else if (u != 4) {
            this.hf.c(8);
            this.hf.v();
        } else {
            v();
        }
    }

    public void hf(boolean z) {
        if (this.yo == null || !com.bytedance.sdk.openadsdk.core.ugeno.tf.u(this.w)) {
            return;
        }
        this.yo.w(z);
    }

    public void xj(boolean z) {
        this.ra.set(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.hf
    public void xj(com.bytedance.sdk.openadsdk.core.hf.hf hfVar, com.bytedance.sdk.openadsdk.core.hf.hf hfVar2) {
        super.xj(hfVar, hfVar2);
        com.bytedance.sdk.openadsdk.core.ugeno.d.u uVar = this.zg;
        if (uVar != null) {
            uVar.xj(this.hf.tj());
        }
        com.bytedance.sdk.openadsdk.core.ugeno.d.hf hfVar3 = this.yo;
        if (hfVar3 != null) {
            hfVar3.xj(this.hf.tj());
        }
        com.bytedance.sdk.openadsdk.core.ugeno.f.xj xjVar = this.e;
        if (xjVar != null) {
            xjVar.xj(hfVar);
        }
    }

    public void xj(int i) {
        if (this.zg == null || !com.bytedance.sdk.openadsdk.core.ugeno.tf.kd(this.w)) {
            return;
        }
        this.zg.u(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.hf
    public void xj(DownloadListener downloadListener) {
        com.bytedance.sdk.openadsdk.core.ugeno.f.xj xjVar = this.e;
        if (xjVar != null) {
            xjVar.xj(downloadListener);
        }
    }
}

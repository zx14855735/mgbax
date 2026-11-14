package com.bytedance.sdk.openadsdk.core.playable;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.ai;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.v;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.yy;
import com.bytedance.sdk.openadsdk.core.video.hf.xj;
import com.bytedance.sdk.openadsdk.x.tf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements ai.xj {
    private final com.bytedance.sdk.openadsdk.core.video.hf.hf am;
    private PlayableVideoContainer c;
    private w f;
    private final Context hf;
    private final int kd;
    private boolean p;
    private final ws w;
    private final String xj;
    private FrameLayout y;
    private final ai u = new ai(Looper.getMainLooper(), this);
    private boolean d = false;
    private boolean tf = true;

    /* renamed from: pl, reason: collision with root package name */
    private boolean f10391pl = false;
    private boolean g = false;

    public xj(String str, Activity activity, ws wsVar, int i, com.bytedance.sdk.openadsdk.core.video.hf.hf hfVar, FrameLayout frameLayout) {
        this.xj = str;
        this.hf = activity;
        this.w = wsVar;
        this.kd = i;
        if (!v.u(wsVar)) {
            this.y = frameLayout;
        }
        kd();
        this.am = hfVar;
    }

    private void d() {
        PlayableVideoContainer playableVideoContainer = this.c;
        if (playableVideoContainer == null) {
            return;
        }
        playableVideoContainer.hf(true);
        this.u.sendEmptyMessageDelayed(1, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f10391pl = true;
        if (this.p) {
            this.p = false;
            hf();
        }
        xj(this.tf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tf() {
        if (this.c == null || this.y == null) {
            return;
        }
        c();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.c, "translationX", -r.w(this.hf, 150.0f), 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.c, "translationY", -r.w(this.hf, 100.0f), 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.c, "alpha", 0.1f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.setDuration(500L);
        animatorSet.start();
    }

    private void c() {
        r.xj((View) this.y, 0);
        r.xj((View) this.c, 0);
    }

    private void kd() {
        if (this.y == null) {
            return;
        }
        if (yy.xj(this.w, this.kd) == 1) {
            PlayableVideoContainer playableVideoContainer = new PlayableVideoContainer(this.hf);
            playableVideoContainer.setBackgroundColor(0);
            playableVideoContainer.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(r.w(this.hf, 156.0f), r.w(this.hf, 87.0f));
            layoutParams.gravity = 8388661;
            layoutParams.topMargin = r.w(this.hf, 55.0f);
            layoutParams.rightMargin = r.w(this.hf, 20.0f);
            this.y.addView(playableVideoContainer, layoutParams);
            this.c = playableVideoContainer;
            return;
        }
        PlayableVideoContainer playableVideoContainer2 = new PlayableVideoContainer(this.hf);
        playableVideoContainer2.setBackgroundColor(0);
        playableVideoContainer2.setVisibility(8);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(r.w(this.hf, 73.0f), r.w(this.hf, 130.0f));
        layoutParams2.gravity = 8388661;
        layoutParams2.topMargin = r.w(this.hf, 55.0f);
        layoutParams2.rightMargin = r.w(this.hf, 30.0f);
        this.y.addView(playableVideoContainer2, layoutParams2);
        this.c = playableVideoContainer2;
    }

    private void y() {
        r.xj((View) this.y, 8);
        r.xj((View) this.c, 8);
    }

    public void hf() {
        if (this.g && this.d && this.f != null) {
            this.u.removeMessages(1);
            if (this.f10391pl) {
                this.f.y();
            } else {
                this.p = true;
            }
        }
    }

    public void u() {
        w wVar = this.f;
        if (wVar == null) {
            return;
        }
        wVar.tf();
        this.f = null;
        this.d = false;
        this.p = false;
        this.f10391pl = false;
    }

    public void w() {
        if (this.g && this.d && this.f != null) {
            this.p = false;
            this.u.sendEmptyMessageDelayed(1, 2000L);
            if (this.f.dq()) {
                return;
            }
            this.f.f();
        }
    }

    public void xj(long j, boolean z) {
        PlayableVideoContainer playableVideoContainer;
        this.g = true;
        this.tf = z;
        xj(j);
        if (this.d) {
            if (this.am != null && (playableVideoContainer = this.c) != null) {
                playableVideoContainer.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.playable.xj.1
                    @Override // java.lang.Runnable
                    public void run() {
                        xj.this.tf();
                    }
                }, 500L);
                this.c.setCustomClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.playable.xj.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (xj.this.y != null) {
                            xj.this.xj();
                            xj.this.am.hf();
                        }
                    }
                });
            } else if (tf.xj(this.w)) {
                y();
            } else {
                c();
            }
        }
    }

    public void xj() {
        this.g = false;
        u();
        y();
    }

    private void xj(long j) {
        if (this.c == null) {
            return;
        }
        if (this.am != null || tf.xj(this.w)) {
            if (this.d) {
                w wVar = this.f;
                if (wVar != null) {
                    wVar.hf(j);
                    this.f.xj(j);
                    return;
                }
                return;
            }
            this.d = true;
            com.bykv.vk.openvk.component.video.api.w.u xj = h.xj(1, this.w, this.kd);
            xj.hf(this.w.ho());
            xj.hf(this.c.getWidth());
            xj.w(this.c.getHeight());
            xj.w(this.w.jf());
            xj.xj(j);
            xj.hf(this.tf);
            if (tf.xj(this.w)) {
                xj.xj(true);
            }
            w wVar2 = new w(this.hf, this.c.getVideoContainer(), this.w, null);
            this.f = wVar2;
            wVar2.xj(new xj.InterfaceC0194xj() { // from class: com.bytedance.sdk.openadsdk.core.playable.xj.3
                @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj.InterfaceC0194xj
                public void hf() {
                    xj.this.c.xj(true);
                    if (xj.this.am != null) {
                        xj.this.am.tf();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj.InterfaceC0194xj
                public void w() {
                    xj.this.f();
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj.InterfaceC0194xj
                public void xj() {
                    if (xj.this.am != null) {
                        xj.this.xj();
                        xj.this.am.w();
                    } else {
                        if (!tf.xj(xj.this.w) || xj.this.f == null || xj.this.f.kd()) {
                            return;
                        }
                        xj.this.xj();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj.InterfaceC0194xj
                public void xj(int i, String str) {
                    if (i == 308) {
                        return;
                    }
                    xj.this.c.xj(true);
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.hf.xj.InterfaceC0194xj
                public void xj(long j2, long j3) {
                    xj.this.c.xj(false);
                    if (xj.this.am != null) {
                        xj.this.am.xj(j2, j3);
                    }
                }
            });
            this.f.hf(j);
            this.f.xj(xj);
            if (this.am != null) {
                this.f.dk();
                this.f.c(false);
                this.c.xj();
            } else {
                if (tf.xj(this.w)) {
                    this.f.c(true);
                }
                d();
            }
        }
    }

    public void xj(boolean z) {
        w wVar = this.f;
        if (wVar == null) {
            return;
        }
        this.tf = z;
        wVar.hf(z);
    }

    @Override // com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
        PlayableVideoContainer playableVideoContainer = this.c;
        if (playableVideoContainer == null) {
            return;
        }
        playableVideoContainer.hf(false);
    }
}

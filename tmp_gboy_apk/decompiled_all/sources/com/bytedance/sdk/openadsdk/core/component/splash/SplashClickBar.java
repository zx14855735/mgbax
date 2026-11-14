package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SplashClickBar extends FrameLayout {
    private boolean c;
    private SplashClickBarBtn d;
    private int f;
    private int hf;
    private int kd;
    private int u;
    private int w;
    private int xj;
    private String y;

    public SplashClickBar(Context context, ws wsVar) {
        super(context);
        xj(context, wsVar);
    }

    public void setBtnLayout(boolean z) {
        int w;
        int i = this.hf + MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS;
        if (this.xj <= i && this.f != 4) {
            this.xj = i;
        }
        int i2 = z ? this.w : this.u;
        if (i2 < 0) {
            i2 = 0;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.d.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        int i3 = this.f;
        if (i3 != 4) {
            if (i3 == 5) {
                layoutParams.height = -50;
                layoutParams.width = -50;
                w = r.w(getContext(), 10.0f);
            } else if (i3 != 7) {
                layoutParams.height = r.w(pz.getContext(), this.hf);
                layoutParams.width = r.w(pz.getContext(), this.xj);
            } else {
                layoutParams.height = -50;
                layoutParams.width = -50;
                w = r.w(getContext(), 20.0f);
            }
            i2 += w;
        } else {
            layoutParams.height = -50;
            layoutParams.width = -50;
        }
        layoutParams.bottomMargin = r.w(pz.getContext(), i2);
        layoutParams.gravity = 81;
        this.d.setLayoutParams(layoutParams);
    }

    public void xj(Context context, ws wsVar) {
        setClipChildren(false);
        SplashClickBarBtn splashClickBarBtn = new SplashClickBarBtn(getContext(), wsVar);
        this.d = splashClickBarBtn;
        addView(splashClickBarBtn);
        this.d.setClipChildren(false);
    }

    public void xj(ws wsVar) {
        this.xj = wsVar.se();
        this.hf = wsVar.ne();
        this.w = wsVar.ft();
        this.u = wsVar.rg();
        this.kd = wsVar.xv();
        this.y = wsVar.vl();
        this.f = wsVar.t();
        this.c = wsVar.h();
        SplashClickBarBtn splashClickBarBtn = this.d;
        if (splashClickBarBtn != null) {
            splashClickBarBtn.setShakeValue(wsVar.ee());
            this.d.setDeepShakeValue(wsVar.pw());
            this.d.setWriggleValue(wsVar.ky());
            this.d.setTwistConfig(wsVar.ki());
            this.d.setShakeInteractConf(wsVar.ya());
            this.d.setTwistInteractConf(wsVar.eg());
            this.d.setCalculationTwistMethod(wsVar.oa());
            this.d.setCalculationMethod(wsVar.le());
        }
        this.d.xj(wsVar.mg());
        if (this.kd == 1 && this.c) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void xj(com.bytedance.sdk.openadsdk.core.hf.xj xjVar) {
        this.d.xj(xjVar);
    }
}

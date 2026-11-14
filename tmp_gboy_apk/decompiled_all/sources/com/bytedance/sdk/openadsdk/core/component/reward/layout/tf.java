package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperView;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class tf extends hf {
    private float am;
    private float qt;
    private FullSwiperView zg;

    public tf(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar, boolean z) {
        super(tTBaseVideoActivity, wsVar, z);
    }

    public void hf() {
        FullSwiperView fullSwiperView = this.zg;
        if (fullSwiperView != null) {
            fullSwiperView.hf();
        }
    }

    public int kd() {
        FullSwiperView fullSwiperView = this.zg;
        if (fullSwiperView != null) {
            return fullSwiperView.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.hf
    public void tf() {
        super.tf();
        FullSwiperView fullSwiperView = this.zg;
        if (fullSwiperView != null) {
            fullSwiperView.kd();
        }
    }

    public void u() {
        FullSwiperView fullSwiperView = this.zg;
        if (fullSwiperView != null) {
            fullSwiperView.u();
        }
    }

    public void w() {
        FullSwiperView fullSwiperView = this.zg;
        if (fullSwiperView != null) {
            fullSwiperView.w();
        }
    }

    public void xj(float[] fArr) {
        this.am = fArr[0];
        this.qt = fArr[1];
    }

    public void y() {
        FullSwiperView fullSwiperView = this.zg;
        if (fullSwiperView != null) {
            fullSwiperView.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.hf
    public void xj() {
        super.xj();
        this.c.setBackgroundColor(0);
        this.zg = new FullSwiperView(this.hf);
    }

    public void xj(List<com.bytedance.sdk.openadsdk.core.component.reward.swiper.xj> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.zg.xj(list).xj(this.am).hf(this.qt).xj(String.valueOf(wo.d(this.w))).xj();
        this.c.addView(this.zg, new FrameLayout.LayoutParams(-1, -1));
    }
}

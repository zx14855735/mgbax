package com.bytedance.adsdk.ugeno.swiper;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.bytedance.adsdk.ugeno.hf.w;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class Swiper extends BaseSwiper<w> {
    private com.bytedance.adsdk.ugeno.w u;

    public Swiper(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.swiper.BaseSwiper
    public View c(int i) {
        return ((w) this.xj.get(i)).d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.adsdk.ugeno.w wVar = this.u;
        if (wVar != null) {
            wVar.kd();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.adsdk.ugeno.w wVar = this.u;
        if (wVar != null) {
            wVar.y();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.w wVar = this.u;
        if (wVar != null) {
            wVar.u();
        }
        super.onLayout(z, i, i2, i3, i4);
        com.bytedance.adsdk.ugeno.w wVar2 = this.u;
        if (wVar2 != null) {
            wVar2.xj(i, i2, i3, i4);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        com.bytedance.adsdk.ugeno.w wVar = this.u;
        if (wVar != null) {
            int[] xj = wVar.xj(i, i2);
            super.onMeasure(xj[0], xj[1]);
        } else {
            super.onMeasure(i, i2);
        }
        com.bytedance.adsdk.ugeno.w wVar2 = this.u;
        if (wVar2 != null) {
            wVar2.w();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.bytedance.adsdk.ugeno.w wVar = this.u;
        if (wVar != null) {
            wVar.hf(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.bytedance.adsdk.ugeno.w wVar = this.u;
        if (wVar != null) {
            wVar.xj(z);
        }
    }

    public void xj(com.bytedance.adsdk.ugeno.w wVar) {
        this.u = wVar;
    }
}

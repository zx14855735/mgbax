package com.bytedance.sdk.openadsdk.core.component.reward.swiper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.swiper.BaseSwiper;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SwiperView extends BaseSwiper<ViewGroup> {
    public SwiperView(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.swiper.BaseSwiper
    public View c(int i) {
        return (ViewGroup) this.xj.get(i);
    }

    @Override // com.bytedance.adsdk.ugeno.swiper.BaseSwiper, com.bytedance.adsdk.ugeno.viewpager.ViewPager.u
    public void d(int i) {
        super.d(i);
    }

    @Override // com.bytedance.adsdk.ugeno.swiper.BaseSwiper, com.bytedance.adsdk.ugeno.viewpager.ViewPager.u
    public void f(int i) {
        super.f(i);
    }

    @Override // com.bytedance.adsdk.ugeno.swiper.BaseSwiper
    public View xj(int i, int i2) {
        if (this.xj.isEmpty()) {
            return new View(getContext());
        }
        View c = c(i2);
        FrameLayout frameLayout = new FrameLayout(getContext());
        if (c instanceof ViewGroup) {
            frameLayout.setClipChildren(true);
        }
        if (c.getParent() instanceof ViewGroup) {
            ((ViewGroup) c.getParent()).removeView(c);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        frameLayout.addView(c, layoutParams);
        frameLayout.addView(new View(getContext()), new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }
}

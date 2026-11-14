package com.bytedance.adsdk.ugeno.swiper.xj;

import android.view.View;
import com.bytedance.adsdk.ugeno.viewpager.ViewPager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj implements ViewPager.kd {
    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.kd
    public void xj(View view, float f) {
        view.setPivotX(f < 0.0f ? view.getWidth() : 0.0f);
        view.setPivotY(view.getHeight() * 0.5f);
        view.setRotationY(f * 90.0f);
    }
}

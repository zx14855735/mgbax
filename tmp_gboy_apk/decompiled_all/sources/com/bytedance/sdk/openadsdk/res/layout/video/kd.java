package com.bytedance.sdk.openadsdk.res.layout.video;

import J3FDQU.A2egSU;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.jk;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd implements com.bytedance.sdk.openadsdk.res.layout.xj {
    @Override // com.bytedance.sdk.openadsdk.res.layout.xj
    public View hf(Context context) {
        RelativeLayout AYUAbz2 = A2egSU.AYUAbz(context, 2114387810);
        AYUAbz2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        AYUAbz2.setVisibility(8);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387954);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        AYUAbz2.addView(imageView);
        ImageView imageView2 = new ImageView(context);
        imageView2.setId(2114387847);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13, -1);
        imageView2.setLayoutParams(layoutParams2);
        imageView2.setVisibility(8);
        jk.xj(context, "tt_new_play_video", (View) imageView2);
        AYUAbz2.addView(imageView2);
        return AYUAbz2;
    }
}

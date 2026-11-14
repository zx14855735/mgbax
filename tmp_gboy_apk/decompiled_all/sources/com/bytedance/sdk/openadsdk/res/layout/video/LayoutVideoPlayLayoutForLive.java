package com.bytedance.sdk.openadsdk.res.layout.video;

import J3FDQU.A2egSU;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class LayoutVideoPlayLayoutForLive extends RelativeLayout {
    public LayoutVideoPlayLayoutForLive(Context context) {
        super(context);
        xj(context);
    }

    private void xj(Context context) {
        RelativeLayout AYUAbz2 = A2egSU.AYUAbz(context, 2114387714);
        AYUAbz2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387900);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(0);
        relativeLayout.setGravity(17);
        ImageView AMqCpz = A2egSU.AMqCpz(context, 2114387651);
        AMqCpz.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        AMqCpz.setScaleType(ImageView.ScaleType.FIT_CENTER);
        TTProgressBar tTProgressBar = new TTProgressBar(context);
        tTProgressBar.setId(2114387631);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(r.w(context, 60.0f), r.w(context, 60.0f));
        layoutParams.addRule(13);
        tTProgressBar.setLayoutParams(layoutParams);
        tTProgressBar.setIndeterminateDrawable(jk.w(context, "tt_video_loading_progress_bar"));
        relativeLayout.addView(AMqCpz);
        relativeLayout.addView(tTProgressBar);
        AYUAbz2.addView(relativeLayout);
        View hf = new w().hf(context);
        hf.setId(2114387888);
        AYUAbz2.addView(hf);
        View hf2 = new u().hf(context);
        hf2.setId(2114387688);
        AYUAbz2.addView(hf2);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387626);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        jk.xj(context, "tt_play_movebar_textpage", imageView);
        imageView.setVisibility(8);
        AYUAbz2.addView(imageView);
        TTProgressBar tTProgressBar2 = new TTProgressBar(context, null, jk.f(context, "tt_Widget_ProgressBar_Horizontal"));
        tTProgressBar2.setId(2114387653);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, r.w(context, 1.5f));
        layoutParams2.addRule(12);
        tTProgressBar2.setBackgroundColor(0);
        tTProgressBar2.setIndeterminateDrawable(null);
        tTProgressBar2.setMax(100);
        GradientDrawable gradientDrawable = new GradientDrawable();
        float A4TApA2 = com.bykv.vk.component.ttvideo.player.A2egSU.A4TApA("#A5FFFFFF", gradientDrawable, context, 1.0f);
        gradientDrawable.setCornerRadius(A4TApA2);
        int w = r.w(context, 2.0f);
        gradientDrawable.setSize(-1, w);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#FFFFFFFF"));
        gradientDrawable2.setCornerRadius(A4TApA2);
        gradientDrawable2.setSize(-1, w);
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable2, 3, 1);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#FFF85959"));
        gradientDrawable3.setCornerRadius(A4TApA2);
        gradientDrawable3.setSize(-1, w);
        tTProgressBar2.setProgressDrawable(new LayerDrawable(new Drawable[]{gradientDrawable, clipDrawable, new ClipDrawable(gradientDrawable3, 3, 1)}));
        tTProgressBar2.setVisibility(8);
        AYUAbz2.addView(tTProgressBar2, layoutParams2);
        View tTViewStub = new TTViewStub(context, new y());
        tTViewStub.setId(2114387744);
        tTViewStub.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        AYUAbz2.addView(tTViewStub);
        View tTViewStub2 = new TTViewStub(context, new hf());
        tTViewStub2.setId(2114387666);
        tTViewStub2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        AYUAbz2.addView(tTViewStub2);
        View tTViewStub3 = new TTViewStub(context, new c());
        tTViewStub3.setId(2114387828);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        tTViewStub3.setLayoutParams(layoutParams3);
        AYUAbz2.addView(tTViewStub3);
        addView(AYUAbz2);
    }
}

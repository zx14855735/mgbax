package com.bytedance.sdk.openadsdk.res.layout.video;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class LayoutVideoDetail extends RelativeLayout {
    public LayoutVideoDetail(Context context) {
        super(context);
        xj(context);
    }

    private View c(Context context) {
        TTProgressBar tTProgressBar = new TTProgressBar(context, null, jk.f(context, "tt_Widget_ProgressBar_Horizontal"));
        tTProgressBar.setId(2114387653);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, r.w(context, 1.5f));
        layoutParams.addRule(12);
        tTProgressBar.setLayoutParams(layoutParams);
        tTProgressBar.setBackground(null);
        tTProgressBar.setMax(100);
        GradientDrawable gradientDrawable = new GradientDrawable();
        float A4TApA2 = A2egSU.A4TApA("#A5FFFFFF", gradientDrawable, context, 1.0f);
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
        com.bytedance.sdk.openadsdk.res.y.xj(tTProgressBar, new LayerDrawable(new Drawable[]{gradientDrawable, clipDrawable, new ClipDrawable(gradientDrawable3, 3, 1)}));
        tTProgressBar.setVisibility(8);
        return tTProgressBar;
    }

    private View d(Context context) {
        TextView textView = new TextView(context);
        textView.setId(2114387759);
        textView.setBackgroundColor(0);
        textView.setMinHeight(r.w(context, 44.0f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = r.w(context, 12.0f);
        textView.setLayoutParams(layoutParams);
        textView.setCompoundDrawablesWithIntrinsicBounds(tf(context), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(tf(context), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setText("关闭");
        return textView;
    }

    private View f(Context context) {
        LinearLayout ARc23Z2 = J3FDQU.A2egSU.ARc23Z(context, 2114387628);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, r.w(context, 40.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        ARc23Z2.setLayoutParams(layoutParams);
        ARc23Z2.setGravity(16);
        ARc23Z2.setOrientation(0);
        ARc23Z2.setVisibility(8);
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams ASJ6gh2 = A2egSU.ASJ6gh(textView, 2114387811, -2, -2);
        ASJ6gh2.setMargins(r.w(context, 16.0f), 0, r.w(context, 12.0f), 0);
        textView.setLayoutParams(ASJ6gh2);
        textView.setText("00:00");
        textView.setTextColor(-1);
        textView.setTextSize(2, 10.0f);
        ARc23Z2.addView(textView);
        SeekBar seekBar = new SeekBar(context);
        seekBar.setId(2114387872);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams2.gravity = 16;
        seekBar.setLayoutParams(layoutParams2);
        seekBar.setBackground(null);
        seekBar.setMax(100);
        if (Build.VERSION.SDK_INT >= 29) {
            seekBar.setMaxHeight(r.w(context, 4.0f));
            seekBar.setMinHeight(r.w(context, 4.0f));
        } else {
            layoutParams2.height = r.w(context, 4.0f);
        }
        seekBar.setPadding(0, 0, 0, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        float A4TApA2 = A2egSU.A4TApA("#A5FFFFFF", gradientDrawable, context, 1.0f);
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
        seekBar.setProgressDrawable(new LayerDrawable(new Drawable[]{gradientDrawable, clipDrawable, new ClipDrawable(gradientDrawable3, 3, 1)}));
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(Color.parseColor("#FFFFFFFF"));
        int w2 = r.w(context, 15.0f);
        shapeDrawable.setIntrinsicWidth(w2);
        shapeDrawable.setIntrinsicHeight(w2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(r.w(context, 1.0f));
        paint.setColor(Color.parseColor("#1E000000"));
        seekBar.setThumb(shapeDrawable);
        seekBar.setThumbOffset(0);
        ARc23Z2.addView(seekBar);
        TextView textView2 = new TextView(context);
        LinearLayout.LayoutParams ASJ6gh3 = A2egSU.ASJ6gh(textView2, 2114387668, -2, -2);
        ASJ6gh3.setMargins(r.w(context, 12.0f), 0, r.w(context, 16.0f), 0);
        textView2.setLayoutParams(ASJ6gh3);
        textView2.setText("00:00");
        textView2.setTextColor(-1);
        textView2.setTextSize(2, 10.0f);
        ARc23Z2.addView(textView2);
        ImageView AMqCpz = J3FDQU.A2egSU.AMqCpz(context, 2114387661);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams3.setMargins(r.w(context, 16.0f), 0, r.w(context, 16.0f), 0);
        AMqCpz.setLayoutParams(layoutParams3);
        AMqCpz.setScaleType(ImageView.ScaleType.CENTER);
        AMqCpz.setVisibility(8);
        jk.xj(context, "tt_enlarge_video", AMqCpz);
        ARc23Z2.addView(AMqCpz);
        return ARc23Z2;
    }

    private View hf(Context context) {
        RelativeLayout AYUAbz2 = J3FDQU.A2egSU.AYUAbz(context, 2114387900);
        AYUAbz2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        AYUAbz2.setBackgroundColor(0);
        AYUAbz2.setGravity(17);
        ImageView AMqCpz = J3FDQU.A2egSU.AMqCpz(context, 2114387651);
        AMqCpz.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        AMqCpz.setScaleType(ImageView.ScaleType.FIT_CENTER);
        TTProgressBar tTProgressBar = new TTProgressBar(context);
        tTProgressBar.setId(2114387631);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(r.w(context, 60.0f), r.w(context, 60.0f));
        layoutParams.addRule(13);
        tTProgressBar.setLayoutParams(layoutParams);
        tTProgressBar.setIndeterminateDrawable(jk.w(context, "tt_video_loading_progress_bar"));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387823);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        linearLayout.setVisibility(8);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387618);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        jk.xj(context, "tt_refreshing_video_textpage", imageView);
        TextView AZOQYO2 = J3FDQU.A2egSU.AZOQYO(context, 2114387860);
        AZOQYO2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        AZOQYO2.setText(jk.xj(context, "tt_video_retry_des_txt"));
        AZOQYO2.setTextColor(jk.tf(context, "tt_heise3"));
        linearLayout.addView(imageView);
        linearLayout.addView(AZOQYO2);
        AYUAbz2.addView(AMqCpz);
        AYUAbz2.addView(tTProgressBar);
        AYUAbz2.addView(linearLayout);
        return AYUAbz2;
    }

    private View kd(Context context) {
        TextView textView = new TextView(context);
        textView.setId(2114387730);
        textView.setGravity(8388659);
        textView.setMaxLines(2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine(false);
        textView.setTextSize(2, 17.0f);
        textView.setTextColor(-1);
        textView.setVisibility(8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setColors(new int[]{Color.parseColor("#FF1A1A1A"), Color.parseColor("#00000000")});
        textView.setBackground(gradientDrawable);
        int w = r.w(context, 15.0f);
        textView.setPadding(w, r.w(context, 14.0f), w, 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(20);
        layoutParams.addRule(10);
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    private StateListDrawable tf(Context context) {
        int parseColor = Color.parseColor("#959595");
        com.bytedance.sdk.openadsdk.res.xj xjVar = new com.bytedance.sdk.openadsdk.res.xj(48);
        xjVar.xj(parseColor);
        float w = r.w(context, 2.0f);
        xjVar.xj(w);
        int parseColor2 = Color.parseColor("#FFFFFF");
        com.bytedance.sdk.openadsdk.res.xj xjVar2 = new com.bytedance.sdk.openadsdk.res.xj(48);
        xjVar2.xj(parseColor2);
        xjVar2.xj(w);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, xjVar);
        stateListDrawable.addState(new int[0], xjVar2);
        return stateListDrawable;
    }

    private View u(Context context) {
        ImageView AMqCpz = J3FDQU.A2egSU.AMqCpz(context, 2114387678);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(A2egSU.A4TApA("#26000000", gradientDrawable, context, 4.0f));
        AMqCpz.setBackground(gradientDrawable);
        AMqCpz.setScaleType(ImageView.ScaleType.CENTER);
        int parseColor = Color.parseColor("#959595");
        com.bytedance.sdk.openadsdk.res.xj xjVar = new com.bytedance.sdk.openadsdk.res.xj(48);
        xjVar.xj(parseColor);
        float w = r.w(context, 2.0f);
        xjVar.xj(w);
        int parseColor2 = Color.parseColor("#FFFFFF");
        com.bytedance.sdk.openadsdk.res.xj xjVar2 = new com.bytedance.sdk.openadsdk.res.xj(48);
        xjVar2.xj(parseColor2);
        xjVar2.xj(w);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, xjVar);
        stateListDrawable.addState(new int[0], xjVar2);
        AMqCpz.setImageDrawable(stateListDrawable);
        int w2 = r.w(context, 30.0f);
        RelativeLayout.LayoutParams BTvldC2 = A2egSU.BTvldC(w2, w2, 21, 11);
        int w3 = r.w(context, 7.0f);
        BTvldC2.setMargins(0, w3, w3, 0);
        AMqCpz.setLayoutParams(BTvldC2);
        return AMqCpz;
    }

    private View w(Context context) {
        ImageView AMqCpz = J3FDQU.A2egSU.AMqCpz(context, 2114387626);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        AMqCpz.setLayoutParams(layoutParams);
        AMqCpz.setScaleType(ImageView.ScaleType.CENTER);
        jk.xj(context, "tt_play_movebar_textpage", AMqCpz);
        AMqCpz.setVisibility(8);
        return AMqCpz;
    }

    private void xj(Context context) {
        setId(2114387714);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        setBackgroundColor(-1);
        addView(hf(context));
        addView(new u().hf(context));
        addView(w(context));
        addView(u(context));
        addView(kd(context));
        addView(y(context));
        addView(c(context));
        addView(f(context));
        TTViewStub tTViewStub = new TTViewStub(context, new y());
        tTViewStub.setId(2114387744);
        tTViewStub.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        addView(tTViewStub);
        TTViewStub tTViewStub2 = new TTViewStub(context, new hf());
        tTViewStub2.setId(2114387666);
        tTViewStub2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        addView(tTViewStub2);
        addView(d(context));
    }

    private View y(Context context) {
        RelativeLayout AYUAbz2 = J3FDQU.A2egSU.AYUAbz(context, 2114387605);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        AYUAbz2.setLayoutParams(layoutParams);
        AYUAbz2.setVisibility(8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setColors(new int[]{Color.parseColor("#FF1A1A1A"), Color.parseColor("#00000000")});
        AYUAbz2.setBackground(gradientDrawable);
        AYUAbz2.setGravity(16);
        ImageView AMqCpz = J3FDQU.A2egSU.AMqCpz(context, 2114387897);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.leftMargin = r.w(context, 12.0f);
        AMqCpz.setLayoutParams(layoutParams2);
        AMqCpz.setScaleType(ImageView.ScaleType.CENTER);
        int parseColor = Color.parseColor("#959595");
        com.bytedance.sdk.openadsdk.res.xj xjVar = new com.bytedance.sdk.openadsdk.res.xj(48);
        xjVar.xj(parseColor);
        float w = r.w(context, 2.0f);
        xjVar.xj(w);
        int parseColor2 = Color.parseColor("#FFFFFF");
        com.bytedance.sdk.openadsdk.res.xj xjVar2 = new com.bytedance.sdk.openadsdk.res.xj(48);
        xjVar2.xj(parseColor2);
        xjVar2.xj(w);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, xjVar);
        stateListDrawable.addState(new int[0], xjVar2);
        AMqCpz.setImageDrawable(stateListDrawable);
        AYUAbz2.addView(AMqCpz);
        TextView textView = new TextView(context);
        textView.setId(2114387706);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        textView.setGravity(16);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine(true);
        textView.setTextSize(2, 17.0f);
        textView.setTextColor(-1);
        int w2 = r.w(context, 15.0f);
        textView.setPadding(w2, 0, w2, 0);
        AYUAbz2.addView(textView);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387797);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(w2, 0, w2, 0);
        TextView AZOQYO2 = J3FDQU.A2egSU.AZOQYO(context, 2114387846);
        AZOQYO2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        AZOQYO2.setGravity(17);
        AZOQYO2.setMaxLines(1);
        AZOQYO2.setSingleLine(true);
        AZOQYO2.setTextSize(2, 12.0f);
        AZOQYO2.setTextColor(-1);
        linearLayout.addView(AZOQYO2);
        AYUAbz2.addView(linearLayout);
        return AYUAbz2;
    }
}

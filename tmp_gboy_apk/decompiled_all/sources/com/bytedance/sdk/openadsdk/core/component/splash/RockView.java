package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.wa;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class RockView extends LinearLayout {
    private TextView hf;
    private TextView w;
    private ImageView xj;

    public static class xj implements Interpolator {
        private xj() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f <= 0.25f ? (f * (-2.0f)) + 0.5f : f <= 0.5f ? (f * 4.0f) - 1.0f : f <= 0.75f ? (f * (-4.0f)) + 3.0f : (f * 2.0f) - 1.5f;
        }
    }

    public RockView(Context context) {
        super(context);
        hf(context);
    }

    private void hf(Context context) {
        if (context == null) {
            context = pz.getContext();
        }
        View xj2 = xj(context);
        if (xj2 == null) {
            return;
        }
        addView(xj2);
    }

    private View xj(Context context) {
        Resources resources = context.getResources();
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 110.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 110.0f, resources.getDisplayMetrics()));
        layoutParams2.gravity = 17;
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        OvalShape ovalShape = new OvalShape();
        int w = r.w(context, 120.0f);
        shapeDrawable.setShape(ovalShape);
        shapeDrawable.setIntrinsicHeight(w);
        shapeDrawable.setIntrinsicWidth(w);
        shapeDrawable.getPaint().setColor(Color.parseColor("#57000000"));
        linearLayout2.setBackground(shapeDrawable);
        linearLayout2.setGravity(17);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout.addView(linearLayout2);
        ImageView imageView = new ImageView(context);
        this.xj = imageView;
        imageView.setId(2114387566);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        Drawable w2 = jk.w(context, "tt_splash_rock");
        if (w2 != null) {
            this.xj.setImageDrawable(w2);
        } else {
            com.bytedance.sdk.openadsdk.f.hf.xj(com.bytedance.sdk.openadsdk.core.f.w.xj("splash_rock.png")).to(this.xj);
        }
        this.xj.setLayoutParams(layoutParams3);
        linearLayout2.addView(this.xj);
        TextView textView = new TextView(context);
        this.hf = textView;
        LinearLayout.LayoutParams ASJ6gh2 = A2egSU.ASJ6gh(textView, 2114387564, -2, -2);
        this.hf.setSingleLine();
        this.hf.setText(jk.xj(context, "tt_splash_rock_top"));
        this.hf.setTextColor(-1);
        this.hf.setTextSize(14.0f);
        this.hf.setLayoutParams(ASJ6gh2);
        linearLayout2.addView(this.hf);
        TextView textView2 = new TextView(context);
        this.w = textView2;
        LinearLayout.LayoutParams ASJ6gh3 = A2egSU.ASJ6gh(textView2, 2114387563, -2, -2);
        ASJ6gh3.gravity = 17;
        ASJ6gh3.topMargin = r.w(context, 12.0f);
        this.w.setLayoutParams(ASJ6gh3);
        this.w.setText(jk.xj(context, "tt_splash_rock_desc"));
        this.w.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
        this.w.setTextColor(-1);
        linearLayout.addView(this.w);
        return linearLayout;
    }

    public void xj(wa waVar) {
        setVisibility(0);
        setAlpha(0.0f);
        TextView textView = this.hf;
        if (textView != null) {
            textView.setText(waVar.p());
            this.hf.setTextSize(2, waVar.g().hf());
        }
        TextView textView2 = this.w;
        if (textView2 != null) {
            textView2.setText(waVar.hf());
            this.w.setTextSize(2, waVar.pl().hf());
            this.w.setTypeface(Typeface.defaultFromStyle(0));
        }
    }

    public void xj() {
        if (this.xj != null) {
            final RotateAnimation rotateAnimation = new RotateAnimation(-14.0f, 14.0f, 1, 0.9f, 1, 0.9f);
            rotateAnimation.setInterpolator(new xj());
            rotateAnimation.setDuration(1000L);
            rotateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.RockView.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RockView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.RockView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RockView.this.xj.startAnimation(rotateAnimation);
                        }
                    }, 250L);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            this.xj.startAnimation(rotateAnimation);
        }
    }
}

package com.bytedance.sdk.openadsdk.core.component.reward.business.insertad;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SmallSlideView extends RelativeLayout {
    private final hf hf;
    private ObjectAnimator u;
    private ObjectAnimator w;
    private final View xj;

    public static class hf extends FrameLayout {
        public hf(Context context) {
            super(context);
            ImageView imageView = new ImageView(context);
            jk.xj(context, "tt_splash_slide_up_bg", (View) imageView);
            addView(imageView);
        }
    }

    public static class xj extends FrameLayout {
        public xj(Context context) {
            super(context);
            ImageView imageView = new ImageView(context);
            jk.xj(context, "tt_splash_slide_up_finger", imageView);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = r.w(context, 38.0f);
            layoutParams.bottomMargin = r.w(context, 10.0f);
            ImageView imageView2 = new ImageView(context);
            jk.xj(context, "tt_splash_slide_up_circle", imageView2);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            int w = r.w(context, 30.0f);
            layoutParams2.setMargins(w, w, w, w);
            addView(imageView2, layoutParams2);
            addView(imageView, layoutParams);
        }
    }

    public SmallSlideView(Context context) {
        super(context);
        View xjVar = new xj(context);
        this.xj = xjVar;
        hf hfVar = new hf(context);
        this.hf = hfVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(r.w(context, 10.0f), 0);
        layoutParams.setMargins(0, r.w(context, 8.0f), 0, r.w(context, 8.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        addView(hfVar, layoutParams);
        addView(xjVar);
        setLayoutParams(new LinearLayout.LayoutParams(r.w(context, 80.0f), r.w(context, 80.0f)));
    }

    public void hf() {
        ObjectAnimator objectAnimator = this.w;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.u;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
    }

    public void xj() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.xj, "translationY", r.w(getContext(), 30.0f), r.w(getContext(), -20.0f));
        this.w = ofFloat;
        ofFloat.setDuration(800L);
        this.w.setRepeatCount(1);
        this.w.setRepeatMode(1);
        this.w.start();
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.hf, "newHeight", r.w(getContext(), 0.0f), r.w(getContext(), 48.0f));
        this.u = ofInt;
        ofInt.setDuration(800L);
        this.u.setRepeatCount(1);
        this.u.setRepeatMode(1);
        this.u.start();
    }
}

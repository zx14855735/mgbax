package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.u.d;
import com.bytedance.sdk.component.adexpress.u.f;
import com.bytedance.sdk.component.utils.q;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class CircleLongPressView extends FrameLayout {
    private ImageView hf;
    private RingProgressView kd;
    private TextView u;
    private ImageView w;
    private Context xj;
    private AnimatorSet y;

    public CircleLongPressView(Context context) {
        super(context);
        this.y = new AnimatorSet();
        this.xj = context;
        kd();
        y();
    }

    private void kd() {
        FrameLayout frameLayout = new FrameLayout(this.xj);
        this.kd = new RingProgressView(this.xj);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) f.xj(this.xj, 95.0f), (int) f.xj(this.xj, 95.0f));
        layoutParams.gravity = 17;
        frameLayout.addView(this.kd, layoutParams);
        this.hf = new ImageView(this.xj);
        int xj = q.xj(this.xj, 60.0f);
        this.hf.setImageDrawable(d.xj(1, null, null, new int[]{xj, xj}, Integer.valueOf(q.xj(this.xj, 1.0f)), Integer.valueOf(Color.parseColor("#80FFFFFF"))));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) f.xj(this.xj, 75.0f), (int) f.xj(this.xj, 75.0f));
        layoutParams2.gravity = 17;
        frameLayout.addView(this.hf, layoutParams2);
        this.w = new ImageView(this.xj);
        int xj2 = q.xj(this.xj, 50.0f);
        this.w.setImageDrawable(d.xj(1, Integer.valueOf(Color.parseColor("#80FFFFFF")), null, new int[]{xj2, xj2}, null, null));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) f.xj(this.xj, 63.0f), (int) f.xj(this.xj, 63.0f));
        layoutParams3.gravity = 17;
        frameLayout.addView(this.w, layoutParams3);
        addView(frameLayout);
        TextView textView = new TextView(this.xj);
        this.u = textView;
        textView.setTextColor(-1);
        this.u.setMaxLines(1);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 81;
        addView(this.u, layoutParams4);
    }

    private void y() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.w, "scaleX", 1.0f, 0.9f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.w, "scaleY", 1.0f, 0.9f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.y.setDuration(800L);
        this.y.playTogether(ofFloat, ofFloat2);
    }

    public void hf() {
        this.y.cancel();
    }

    public void setGuideText(String str) {
        this.u.setText(str);
    }

    public void u() {
        this.kd.hf();
        this.kd.w();
    }

    public void w() {
        this.kd.xj();
    }

    public void xj() {
        this.y.start();
    }
}

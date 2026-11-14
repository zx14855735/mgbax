package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.u.f;
import com.bytedance.sdk.component.utils.jk;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ClickInteractView extends FrameLayout {
    private AnimatorSet hf;
    private ImageView xj;

    public ClickInteractView(Context context) {
        super(context);
        w();
        u();
    }

    private void u() {
        this.hf = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.xj, "scaleX", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        ofFloat.setDuration(2000L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.xj, "scaleY", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        ofFloat2.setDuration(2000L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        this.hf.playTogether(ofFloat, ofFloat2);
    }

    private void w() {
        ImageView imageView = new ImageView(getContext());
        this.xj = imageView;
        imageView.setImageResource(jk.kd(getContext(), "tt_white_hand"));
        int xj = (int) f.xj(getContext(), 20.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(xj, xj);
        layoutParams.gravity = 17;
        addView(this.xj, layoutParams);
    }

    public void hf() {
        AnimatorSet animatorSet = this.hf;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void xj() {
        AnimatorSet animatorSet = this.hf;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }
}

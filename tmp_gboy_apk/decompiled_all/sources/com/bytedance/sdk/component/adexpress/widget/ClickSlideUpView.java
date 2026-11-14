package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.u.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ClickSlideUpView extends SlideUpView {
    private View hf;
    private AnimatorSet w;
    private TextView xj;

    public ClickSlideUpView(Context context) {
        super(context);
        this.w = new AnimatorSet();
        hf(context);
    }

    private void hf(Context context) {
        View xj = com.bytedance.sdk.component.adexpress.w.xj.xj(context);
        this.hf = xj;
        addView(xj);
        setClipChildren(false);
        this.xj = (TextView) findViewById(2097610748);
    }

    private void u() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hf, "translationY", 0.0f, f.xj(getContext(), -3.0f));
        ofFloat.setInterpolator(new CycleInterpolator(1.0f));
        ofFloat.setDuration(1000L);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hf, "alpha", 1.0f, 0.8f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setInterpolator(new CycleInterpolator(1.0f));
        ofFloat2.setRepeatCount(-1);
        this.w.playTogether(ofFloat, ofFloat2);
        this.w.setDuration(1000L);
        this.w.start();
    }

    public void setButtonText(String str) {
        if (this.xj == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.xj.setText(str);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void xj(Context context) {
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void xj() {
        u();
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void hf() {
        this.w.cancel();
    }
}

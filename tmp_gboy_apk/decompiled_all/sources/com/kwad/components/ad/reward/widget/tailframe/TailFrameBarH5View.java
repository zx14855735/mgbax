package com.kwad.components.ad.reward.widget.tailframe;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class TailFrameBarH5View extends LinearLayout {
    protected TextView gC;
    protected TextView gD;
    protected ValueAnimator lI;

    public TailFrameBarH5View(Context context) {
        this(context, null, 0);
    }

    private void f(Context context, int i) {
        m.inflate(context, i, this);
        this.gC = (TextView) findViewById(R.id.ksad_tf_h5_ad_desc);
        this.gD = (TextView) findViewById(R.id.ksad_tf_h5_open_btn);
    }

    private void lF() {
        if (this.lI != null) {
            lG();
            this.lI.start();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
        this.lI = ofFloat;
        ofFloat.setDuration(1200L);
        this.lI.setRepeatCount(-1);
        this.lI.setRepeatMode(1);
        this.lI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.tailframe.TailFrameBarH5View.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TailFrameBarH5View.this.gD.setScaleY(floatValue);
                TailFrameBarH5View.this.gD.setScaleX(floatValue);
            }
        });
        this.lI.start();
    }

    public final void g(boolean z, boolean z2) {
        f(getContext(), z ? z2 ? R.layout.ksad_video_tf_bar_h5_portrait_vertical : R.layout.ksad_video_tf_bar_h5_portrait_horizontal : R.layout.ksad_video_tf_bar_h5_landscape);
    }

    public TextView getH5OpenBtn() {
        return this.gD;
    }

    public final void j(AdTemplate adTemplate) {
        AdInfo er = e.er(adTemplate);
        this.gC.setText(com.kwad.sdk.core.response.b.a.av(er));
        this.gD.setText(com.kwad.sdk.core.response.b.a.aF(er));
        lF();
    }

    public final void lG() {
        ValueAnimator valueAnimator = this.lI;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.lI.cancel();
        this.lI.end();
    }

    public TailFrameBarH5View(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarH5View(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}

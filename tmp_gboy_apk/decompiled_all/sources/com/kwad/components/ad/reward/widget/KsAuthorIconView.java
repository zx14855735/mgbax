package com.kwad.components.ad.reward.widget;

import CSDoyG.A2egSU;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;
import com.kwad.sdk.utils.ca;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class KsAuthorIconView extends FrameLayout implements ca.a {
    private View En;
    private View Eo;
    private final ca bQ;
    private ViewGroup ej;
    private KSCornerImageView ek;
    private KSCornerImageView el;
    private KSCornerImageView em;
    private KSCornerImageView en;
    private TextView eo;
    private ImageView ep;
    private View eq;
    private View er;
    private View es;
    private View et;

    public KsAuthorIconView(Context context) {
        super(context);
        this.bQ = new ca(this);
        A(context);
    }

    private void A(Context context) {
        m.inflate(context, R.layout.ksad_author_icon, this);
        this.ej = (ViewGroup) findViewById(R.id.ksad_author_icon_frame);
        this.el = (KSCornerImageView) findViewById(R.id.ksad_author_icon);
        this.ek = (KSCornerImageView) findViewById(R.id.ksad_author_icon_outer);
        this.em = (KSCornerImageView) findViewById(R.id.ksad_author_animator);
        this.en = (KSCornerImageView) findViewById(R.id.ksad_author_animator2);
        this.eo = (TextView) findViewById(R.id.ksad_fans_count);
        this.Eo = findViewById(R.id.ksad_fans_hot_icon);
        this.En = findViewById(R.id.ksad_author_btn_follow);
        this.ep = (ImageView) findViewById(R.id.ksad_author_arrow_down);
        this.er = findViewById(R.id.ksad_origin_live_bottom_layout);
        this.eq = findViewById(R.id.ksad_top_layout);
        this.et = findViewById(R.id.ksad_author_icon_layout);
        this.es = findViewById(R.id.ksad_top_flag_layout);
    }

    private static Animator a(View view, int i) {
        if (view == null) {
            return null;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.setPivotX(width / 2.0f);
        view.setPivotY(height);
        AnimatorSet animatorSet = new AnimatorSet();
        Interpolator A4TApA2 = A2egSU.A4TApA(0.42f, 0.0f, 1.0f, 1.0f);
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.1f, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.1f, 1.0f));
        animatorSet.setInterpolator(A4TApA2);
        animatorSet.setDuration(250L);
        AnimatorSet animatorSet2 = new AnimatorSet();
        Interpolator A4TApA3 = A2egSU.A4TApA(0.0f, 0.0f, 0.58f, 1.0f);
        animatorSet2.playTogether(ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.1f, 1.0f), ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 1.1f, 1.0f));
        animatorSet2.setInterpolator(A4TApA3);
        animatorSet2.setDuration(250L);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playSequentially(animatorSet, animatorSet2);
        animatorSet3.setDuration(500L);
        return animatorSet3;
    }

    private static ValueAnimator.AnimatorUpdateListener b(final View view, final boolean z) {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.KsAuthorIconView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    int i = (int) floatValue;
                    layoutParams.width = i;
                    if (!z) {
                        layoutParams.height = i;
                    }
                    view.setLayoutParams(layoutParams);
                }
            }
        };
    }

    public final void j(AdTemplate adTemplate) {
        AdInfo er = e.er(adTemplate);
        String cp = a.cp(er);
        if (!TextUtils.isEmpty(cp)) {
            KSImageLoader.loadImage(this.el, cp, adTemplate);
        }
        int bg = a.bg(er);
        if (a.cS(e.er(adTemplate))) {
            this.eo.setText("直播中");
            this.Eo.setVisibility(8);
            this.En.setVisibility(8);
            if (bg == 8) {
                this.es.setVisibility(8);
                this.ep.setVisibility(8);
                this.er.setVisibility(0);
            } else {
                this.er.setVisibility(8);
                this.ep.setVisibility(0);
                this.er.setVisibility(8);
            }
        } else {
            this.eo.setText(a.cN(er));
        }
        this.bQ.sendEmptyMessageAtTime(1, 500L);
    }

    public KsAuthorIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bQ = new ca(this);
        A(context);
    }

    public KsAuthorIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bQ = new ca(this);
        A(context);
    }

    public KsAuthorIconView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.bQ = new ca(this);
        A(context);
    }

    private static Animator a(View view, boolean z) {
        float width = view.getWidth();
        if (width <= 0.0f) {
            return null;
        }
        float f = 0.9f * width;
        c.d("KsAuthorIconView", "getIconScaleAnimator size: " + width + ", endSize: " + f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(width, f);
        ofFloat.addUpdateListener(b(view, false));
        Interpolator A4TApA2 = A2egSU.A4TApA(0.42f, 0.0f, 1.0f, 1.0f);
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(A4TApA2);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(f, width);
        ofFloat2.addUpdateListener(b(view, false));
        Interpolator A4TApA3 = A2egSU.A4TApA(0.0f, 0.0f, 0.58f, 1.0f);
        ofFloat2.setDuration(500L);
        ofFloat2.setInterpolator(A4TApA3);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofFloat2);
        return animatorSet;
    }

    private Animator a(View view, long j) {
        if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(view.getWidth(), getResources().getDimension(R.dimen.ksad_reward_author_icon_width));
        ofFloat.addUpdateListener(b(view, false));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        Interpolator A4TApA2 = A2egSU.A4TApA(0.42f, 0.0f, 1.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(j);
        animatorSet.setInterpolator(A4TApA2);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    public final void a(com.kwad.components.core.widget.e eVar) {
        com.kwad.components.core.s.m.a(eVar, this);
        this.ep.setImageResource(R.drawable.ksad_reward_follow_arrow_down);
        a(eVar, this.em.getBackground());
        a(eVar, this.ek.getBackground());
        a(eVar, this.en.getBackground());
        a(eVar, this.ej.getBackground());
    }

    private void a(com.kwad.components.core.widget.e eVar, Drawable drawable) {
        if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setStroke(getResources().getDimensionPixelSize(R.dimen.ksad_reward_author_icon_stroke_width), eVar.xG());
        }
    }

    @Override // com.kwad.sdk.utils.ca.a
    public final void a(Message message) {
        if (message.what != 1) {
            return;
        }
        final Animator a2 = a((View) this.em, 900L);
        final Animator a3 = a((View) this.en, 1000L);
        final Animator a4 = a((View) this.el, false);
        final Animator a5 = a(this.eq, 500);
        if (a5 != null && a2 != null && a3 != null && a4 != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(a4, a2, a3);
            animatorSet.start();
            a4.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.widget.KsAuthorIconView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a2.start();
                    a3.start();
                    a4.start();
                    a5.start();
                }
            });
            return;
        }
        this.bQ.sendEmptyMessageDelayed(1, 500L);
    }
}

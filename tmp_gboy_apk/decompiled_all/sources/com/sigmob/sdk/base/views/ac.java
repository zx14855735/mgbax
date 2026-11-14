package com.sigmob.sdk.base.views;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ResourceUtil;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ac extends v {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f13246a;
    private ObjectAnimator b;
    private boolean c;
    private f d;

    /* renamed from: com.sigmob.sdk.base.views.ac$2, reason: invalid class name */
    public class AnonymousClass2 implements Animator.AnimatorListener {
        public AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            ac.this.b.start();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (ac.this.c) {
                new Handler(Looper.getMainLooper()).postDelayed(new A4TApA(0, this), 300L);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public ac(Context context) {
        super(context);
        c();
    }

    private void d() {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sigmob.sdk.base.views.ac.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int height = ac.this.getHeight();
                int width = ac.this.getWidth();
                if (height == 0 || width == 0) {
                    return;
                }
                ac.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                ViewGroup.LayoutParams layoutParams = ac.this.f13246a.getLayoutParams();
                int i = height / 2;
                layoutParams.width = i;
                layoutParams.height = i;
                ac.this.f13246a.setLayoutParams(layoutParams);
                float f = height / 2.0f;
                ac.this.f13246a.setPivotX(f);
                ac.this.f13246a.setPivotY(f * 0.8f);
            }
        });
    }

    private void e() {
        if (this.b != null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f13246a, com.sigmob.sdk.base.common.a.B, 0.0f, 18.0f, 0.0f, -18.0f, 0.0f, 18.0f, 0.0f, -18.0f, 0.0f, 18.0f, 0.0f);
        this.b = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.b.addListener(new AnonymousClass2());
        this.b.setDuration(1200L);
    }

    @Override // com.sigmob.sdk.base.views.v
    public void b() {
        ObjectAnimator objectAnimator = this.b;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.c = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        d();
        e();
        if (this.c) {
            this.b.cancel();
            this.b.start();
        }
    }

    public ac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    private void c() {
        ViewGroup.LayoutParams ASJ6gh2 = J3FDQU.A2egSU.ASJ6gh(-1, -1, 13);
        f fVar = new f(getContext());
        this.d = fVar;
        addView(fVar, ASJ6gh2);
        int dipsToIntPixels = Dips.dipsToIntPixels(45.0f, getContext());
        this.f13246a = new ImageView(getContext());
        this.f13246a.setImageDrawable(getResources().getDrawable(ResourceUtil.getDrawableId(getContext(), "sig_image_shake_new")));
        this.f13246a.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
        layoutParams.addRule(13);
        addView(this.f13246a, layoutParams);
        d();
    }

    @Override // com.sigmob.sdk.base.views.v
    public void a() {
        ObjectAnimator objectAnimator = this.b;
        if (objectAnimator != null && !this.c) {
            objectAnimator.start();
        }
        this.c = true;
    }

    public ac(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c();
    }
}

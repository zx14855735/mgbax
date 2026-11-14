package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.w.f;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DynamicVerticalScrollWidgetImp extends DynamicBaseWidgetImp implements kd {
    ObjectAnimator hf;
    private Runnable ht;
    private int jk;
    private boolean pz;
    ObjectAnimator xj;

    public DynamicVerticalScrollWidgetImp(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context, dynamicRootView, fVar);
        this.jk = 0;
        this.pz = false;
        this.ht = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVerticalScrollWidgetImp.1
            @Override // java.lang.Runnable
            public void run() {
                DynamicVerticalScrollWidgetImp.this.d();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        final View view;
        final View childAt = getChildAt(this.jk);
        int i = this.jk;
        if (i == 0) {
            this.pz = false;
        }
        boolean z = i + 1 >= getChildCount() || ((ViewGroup) getChildAt(this.jk + 1)).getChildCount() <= 0;
        if (this.g.tf().kd().xj() || !z) {
            View childAt2 = z ? getChildAt((this.jk + 2) % getChildCount()) : getChildAt((this.jk + 1) % getChildCount());
            this.xj = ObjectAnimator.ofFloat(childAt, "translationY", 0.0f, (-(getChildAt(this.jk).getHeight() + this.f)) / 2);
            if (z) {
                this.jk++;
            }
            view = childAt2;
        } else {
            this.pz = true;
            view = getChildAt(this.jk - 1);
            this.xj = ObjectAnimator.ofFloat(childAt, "translationY", 0.0f, (getChildAt(this.jk).getHeight() + this.f) / 2);
        }
        this.xj.setInterpolator(new LinearInterpolator());
        this.xj.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVerticalScrollWidgetImp.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                childAt.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        if (this.pz) {
            this.hf = ObjectAnimator.ofFloat(view, "translationY", (-(view.getHeight() + this.f)) / 2, 0.0f);
        } else {
            this.hf = ObjectAnimator.ofFloat(view, "translationY", (view.getHeight() + this.f) / 2, 0.0f);
        }
        this.hf.setInterpolator(new LinearInterpolator());
        this.hf.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicVerticalScrollWidgetImp.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                view.setVisibility(0);
            }
        });
        this.xj.setDuration(500L);
        this.hf.setDuration(500L);
        this.xj.start();
        this.hf.start();
        if (this.pz) {
            this.jk--;
        } else {
            int i2 = this.jk + 1;
            this.jk = i2;
            this.jk = i2 % getChildCount();
        }
        postDelayed(this.ht, 3000L);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.kd
    public void hf() {
        removeCallbacks(this.ht);
        ObjectAnimator objectAnimator = this.xj;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.xj.cancel();
        }
        ObjectAnimator objectAnimator2 = this.hf;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllUpdateListeners();
            this.hf.cancel();
        }
        super.hf();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.topMargin = (this.f - layoutParams.height) / 2;
            childAt.setLayoutParams(layoutParams);
            if (i != 0) {
                childAt.setVisibility(8);
            }
        }
        postDelayed(this.ht, 2500L);
    }
}

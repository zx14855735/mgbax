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
public class DynamicBaseInternalScrollWidgetImp extends DynamicBaseWidgetImp implements kd {
    ObjectAnimator hf;
    private Runnable ht;
    private int jk;
    private boolean pz;
    ObjectAnimator xj;

    public DynamicBaseInternalScrollWidgetImp(Context context, DynamicRootView dynamicRootView, f fVar) {
        super(context, dynamicRootView, fVar);
        this.jk = 0;
        this.pz = false;
        this.ht = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseInternalScrollWidgetImp.1
            @Override // java.lang.Runnable
            public void run() {
                DynamicBaseInternalScrollWidgetImp.this.d();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        final View childAt;
        final View childAt2 = getChildAt(this.jk);
        int i = this.jk;
        if (i == 0) {
            this.pz = false;
        }
        if (i + 1 >= getChildCount() || ((ViewGroup) getChildAt(this.jk + 1)).getChildCount() <= 0) {
            this.pz = true;
            childAt = getChildAt(this.jk - 1);
            this.xj = ObjectAnimator.ofFloat(childAt2, "translationX", 0.0f, (getChildAt(this.jk).getWidth() + this.c) / 2);
        } else {
            childAt = getChildAt(this.jk + 1);
            this.xj = ObjectAnimator.ofFloat(childAt2, "translationX", 0.0f, (-(getChildAt(this.jk).getWidth() + this.c)) / 2);
        }
        this.xj.setInterpolator(new LinearInterpolator());
        this.xj.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseInternalScrollWidgetImp.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                childAt2.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        if (this.pz) {
            this.hf = ObjectAnimator.ofFloat(childAt, "translationX", (-(childAt.getWidth() + this.c)) / 2, 0.0f);
        } else {
            this.hf = ObjectAnimator.ofFloat(childAt, "translationX", (childAt.getWidth() + this.c) / 2, 0.0f);
        }
        this.hf.setInterpolator(new LinearInterpolator());
        this.hf.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseInternalScrollWidgetImp.3
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
                childAt.setVisibility(0);
            }
        });
        this.xj.setDuration(500L);
        this.hf.setDuration(500L);
        this.xj.start();
        this.hf.start();
        if (this.pz) {
            this.jk--;
        } else {
            this.jk++;
        }
        postDelayed(this.ht, 2000L);
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

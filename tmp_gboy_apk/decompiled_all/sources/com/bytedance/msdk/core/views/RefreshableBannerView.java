package com.bytedance.msdk.core.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bytedance.msdk.xj.kd.w;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class RefreshableBannerView extends FrameLayout {
    private boolean hf;
    private final ViewTreeObserver.OnScrollChangedListener kd;
    private final Rect u;
    private boolean w;
    private boolean xj;
    private xj y;

    public interface xj {
        void xj(boolean z);
    }

    public RefreshableBannerView(Context context) {
        super(context);
        this.xj = true;
        this.hf = true;
        this.w = true;
        this.u = new Rect();
        this.kd = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.msdk.core.views.RefreshableBannerView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                RefreshableBannerView refreshableBannerView = RefreshableBannerView.this;
                refreshableBannerView.hf = refreshableBannerView.getGlobalVisibleRect(refreshableBannerView.u);
                RefreshableBannerView refreshableBannerView2 = RefreshableBannerView.this;
                refreshableBannerView2.xj(refreshableBannerView2.hf);
            }
        };
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnScrollChangedListener(this.kd);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnScrollChangedListener(this.kd);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        boolean z = i == 0;
        this.xj = z;
        xj(z);
    }

    public void setVisibilityChangeListener(xj xjVar) {
        this.y = xjVar;
    }

    public void xj(View view) {
        view.setTranslationX(getWidth());
        addView(view);
        ObjectAnimator.ofFloat(view, "translationX", 0.0f).setDuration(250L).start();
        if (getChildCount() > 1) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(getChildAt(0), "translationX", -getWidth()).setDuration(250L);
            duration.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.msdk.core.views.RefreshableBannerView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (RefreshableBannerView.this.getChildCount() > 1) {
                        RefreshableBannerView.this.removeViewAt(0);
                        w.xj("TMe", "--==-- after remove, view count: " + RefreshableBannerView.this.getChildCount());
                    }
                }
            });
            duration.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(boolean z) {
        boolean z2 = this.xj && this.hf;
        if (z) {
            if (!z2 || this.w) {
                return;
            }
            this.w = true;
            xj xjVar = this.y;
            if (xjVar != null) {
                xjVar.xj(true);
                return;
            }
            return;
        }
        if (z2 || !this.w) {
            return;
        }
        this.w = false;
        xj xjVar2 = this.y;
        if (xjVar2 != null) {
            xjVar2.xj(false);
        }
    }
}

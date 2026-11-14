package com.fl.saas.base.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.ImageLoader;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.s2s.R;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class NativeSlidingView extends FrameLayout implements View.OnTouchListener {
    private boolean isVisibility;
    private Animator mAnimator;
    private ImageView mImageView;
    private SlidingListener mSlidingListener;

    public interface SlidingListener {
        void onDown(int i, int i2);

        void onSliding();

        void onUp(int i, int i2);
    }

    public NativeSlidingView(Context context) {
        super(context);
        this.isVisibility = false;
    }

    private void cancelAnimator() {
        Animator animator = this.mAnimator;
        if (animator != null) {
            animator.cancel();
        }
    }

    private Animator createAnimatorSet(View view, long j, float f) {
        if (view == null) {
            return null;
        }
        view.setPivotX(view.getMeasuredHeight() / 2.0f);
        view.setPivotY(view.getMeasuredWidth() / 2.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, f);
        ofFloat.setDuration(j);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationX", f, 0.0f);
        ofFloat2.setDuration(j);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, f);
        ofFloat3.setDuration(j);
        ofFloat3.setStartDelay(200L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "translationY", f, 0.0f);
        ofFloat4.setDuration(j);
        float f2 = -f;
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view, "translationX", 0.0f, f2);
        ofFloat5.setDuration(j);
        ofFloat5.setStartDelay(200L);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(view, "translationX", f2, 0.0f);
        ofFloat6.setDuration(j);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, f2);
        ofFloat7.setDuration(j);
        ofFloat7.setStartDelay(200L);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(view, "translationY", f2, 0.0f);
        ofFloat8.setDuration(j);
        animatorSet.playSequentially(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6, ofFloat7, ofFloat8);
        animatorSet.setStartDelay(400L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.fl.saas.base.widget.NativeSlidingView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (NativeSlidingView.this.mImageView != null) {
                    NativeSlidingView.this.mImageView.setRotation(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (NativeSlidingView.this.isVisibility) {
                    animator.start();
                }
            }
        });
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playAnimator() {
        if (this.mAnimator == null) {
            this.mAnimator = createAnimatorSet(this.mImageView, 400L, DeviceUtil.dip2px(10.0f));
        }
        if (this.mAnimator.isRunning()) {
            return;
        }
        this.mAnimator.start();
    }

    public void createView(boolean z) {
        View inflate = ViewHelper.inflate(getContext(), R.layout.yd_saas_view_video_sliding_spread);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_finger);
        this.mImageView = imageView;
        ImageLoader.loadImage(CommConstant.ImageUrl.FINGER_GUIDE, imageView);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ll_tips);
        if (!z) {
            linearLayout.setVisibility(8);
        }
        addView(inflate, new FrameLayout.LayoutParams(-1, -1));
        setOnTouchListener(this);
        setFocusable(true);
        setClickable(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelAnimator();
        this.mAnimator = null;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return true;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        SlidingListener slidingListener = this.mSlidingListener;
        if (slidingListener != null) {
            slidingListener.onDown(x, y);
        }
        SlidingListener slidingListener2 = this.mSlidingListener;
        if (slidingListener2 != null) {
            slidingListener2.onUp(x, y);
        }
        SlidingListener slidingListener3 = this.mSlidingListener;
        if (slidingListener3 == null) {
            return true;
        }
        slidingListener3.onSliding();
        return true;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.isVisibility = i == 0;
        if (i == 0) {
            this.mImageView.post(new CtFAbx.A2egSU(27, this));
        } else {
            cancelAnimator();
        }
    }

    public void setSlidingListener(SlidingListener slidingListener) {
        this.mSlidingListener = slidingListener;
    }

    public NativeSlidingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NativeSlidingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isVisibility = false;
    }
}

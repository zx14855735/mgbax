package com.fl.saas.base.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.fl.saas.config.utils.DeviceUtil;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class FingerSlidingView extends FrameLayout implements View.OnTouchListener {
    private int bgHeight;
    private View bgView;
    private boolean isCallback;
    private boolean isVisibility;
    private Animator mAnimator;
    private GestureDetector mGestureDetector;
    private ImageView mImageView;
    private SlidingListener mSlidingListener;
    private int scale_type;
    private int slidingThreshold;

    public interface SlidingListener {
        void onDown(int i, int i2, View view);

        void onSliding();

        void onUp(int i, int i2, View view);
    }

    public FingerSlidingView(Context context) {
        super(context);
        this.slidingThreshold = 100;
        this.isCallback = false;
        this.isVisibility = false;
    }

    private void cancelAnimator() {
        Animator animator = this.mAnimator;
        if (animator != null) {
            animator.cancel();
        }
        View view = this.bgView;
        if (view != null) {
            view.clearAnimation();
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
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.fl.saas.base.widget.FingerSlidingView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (FingerSlidingView.this.mImageView != null) {
                    FingerSlidingView.this.mImageView.setRotation(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (FingerSlidingView.this.isVisibility) {
                    animator.start();
                }
            }
        });
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playAnimator() {
        if (this.mAnimator == null) {
            this.mAnimator = createAnimatorSet(this.mImageView, 400L, DeviceUtil.dip2px(20.0f));
        }
        if (!this.mAnimator.isRunning()) {
            this.mAnimator.start();
        }
        if (this.bgView != null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.0f, 1.0f, 1.1f, 1, 0.5f, 1, 1.0f);
            scaleAnimation.setDuration(700L);
            scaleAnimation.setRepeatCount(-1);
            scaleAnimation.setRepeatMode(2);
            this.bgView.startAnimation(scaleAnimation);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void createView() {
        /*
            r7 = this;
            android.content.Context r0 = r7.getContext()
            int r1 = com.fl.saas.s2s.R.layout.yd_saas_view_sliding_spread
            android.view.View r0 = com.fl.saas.common.util.ViewHelper.inflate(r0, r1)
            int r1 = com.fl.saas.s2s.R.id.iv_finger
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r7.mImageView = r1
            int r1 = com.fl.saas.s2s.R.id.iv_all_arrow
            android.view.View r1 = r0.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            java.lang.String r2 = "https://creative.medproad.com/medpro/imgs/yd_saas_icon_all_arrow.webp"
            com.fl.saas.common.util.ImageLoader.loadImage(r2, r1)
            android.widget.ImageView r1 = r7.mImageView
            java.lang.String r2 = "https://creative.medproad.com/medpro/imgs/yd_saas_spread_guide.webp"
            com.fl.saas.common.util.ImageLoader.loadImage(r2, r1)
            int r1 = com.fl.saas.config.utils.DeviceUtil.getMobileHeight()
            if (r1 > 0) goto L35
            r1 = 1147207680(0x44610000, float:900.0)
        L30:
            int r1 = com.fl.saas.config.utils.DeviceUtil.dip2px(r1)
            goto L40
        L35:
            r2 = 1140457472(0x43fa0000, float:500.0)
            int r2 = com.fl.saas.config.utils.DeviceUtil.px2dip(r2)
            if (r1 >= r2) goto L40
            r1 = 1145569280(0x44480000, float:800.0)
            goto L30
        L40:
            double r1 = (double) r1
            r3 = 4596373779694328218(0x3fc999999999999a, double:0.2)
            double r3 = r3 * r1
            int r3 = (int) r3
            int r4 = r7.scale_type
            r5 = 1
            if (r4 != r5) goto L57
            r3 = 4599075939470750515(0x3fd3333333333333, double:0.3)
        L53:
            double r1 = r1 * r3
            int r3 = (int) r1
            goto L60
        L57:
            r6 = 2
            if (r4 != r6) goto L60
            r3 = 4600877379321698714(0x3fd999999999999a, double:0.4)
            goto L53
        L60:
            r7.bgHeight = r3
            android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams
            r2 = -1
            r1.<init>(r2, r3)
            r4 = 80
            r1.gravity = r4
            android.view.View r4 = new android.view.View
            android.content.Context r6 = r7.getContext()
            r4.<init>(r6)
            r7.bgView = r4
            int r6 = com.fl.saas.s2s.R.drawable.yd_saas_slide_bg
            r4.setBackgroundResource(r6)
            android.view.View r4 = r7.bgView
            r7.addView(r4, r1)
            r1 = 1124859904(0x430c0000, float:140.0)
            int r1 = com.fl.saas.config.utils.DeviceUtil.dip2px(r1)
            int r1 = r1 + r3
            android.widget.FrameLayout$LayoutParams r3 = new android.widget.FrameLayout$LayoutParams
            r3.<init>(r2, r1)
            r1 = 81
            r3.gravity = r1
            r7.addView(r0, r3)
            android.view.GestureDetector r0 = new android.view.GestureDetector
            android.content.Context r1 = r7.getContext()
            com.fl.saas.base.widget.FingerSlidingView$1 r2 = new com.fl.saas.base.widget.FingerSlidingView$1
            r2.<init>()
            r0.<init>(r1, r2)
            r7.mGestureDetector = r0
            r7.setOnTouchListener(r7)
            r7.setFocusable(r5)
            r7.setClickable(r5)
            r7.setLongClickable(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.base.widget.FingerSlidingView.createView():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelAnimator();
        this.mAnimator = null;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            SlidingListener slidingListener = this.mSlidingListener;
            if (slidingListener != null) {
                slidingListener.onDown(x, y, this);
            }
        }
        if (motionEvent.getAction() == 1) {
            int x2 = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            SlidingListener slidingListener2 = this.mSlidingListener;
            if (slidingListener2 != null) {
                slidingListener2.onUp(x2, y2, this);
            }
        }
        return this.mGestureDetector.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.isVisibility = i == 0;
        if (i == 0) {
            this.mImageView.post(new CtFAbx.A2egSU(25, this));
        } else {
            cancelAnimator();
        }
    }

    public void setScale_type(int i) {
        this.scale_type = i;
    }

    public void setSlidingListener(int i, SlidingListener slidingListener) {
        this.mSlidingListener = slidingListener;
        this.slidingThreshold = i * 4;
    }

    public FingerSlidingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FingerSlidingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.slidingThreshold = 100;
        this.isCallback = false;
        this.isVisibility = false;
        createView();
    }
}

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
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.ImageLoader;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.s2s.R;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class VideoFingerSlidingView extends FrameLayout implements View.OnTouchListener {
    private boolean isCallback;
    private boolean isVisibility;
    private Animator mAnimator;
    private GestureDetector mGestureDetector;
    private ImageView mImageView;
    private SlidingListener mSlidingListener;
    private int slidingThreshold;

    public interface SlidingListener {
        void onSliding();
    }

    public VideoFingerSlidingView(Context context) {
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
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.fl.saas.base.widget.VideoFingerSlidingView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (VideoFingerSlidingView.this.mImageView != null) {
                    VideoFingerSlidingView.this.mImageView.setRotation(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (VideoFingerSlidingView.this.isVisibility) {
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

    public void createView() {
        View inflate = ViewHelper.inflate(getContext(), R.layout.yd_saas_view_video_sliding_spread);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_finger);
        this.mImageView = imageView;
        ImageLoader.loadImage(CommConstant.ImageUrl.FINGER_GUIDE, imageView);
        addView(inflate, new FrameLayout.LayoutParams(-1, -1));
        this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.OnGestureListener() { // from class: com.fl.saas.base.widget.VideoFingerSlidingView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                VideoFingerSlidingView.this.isCallback = false;
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (VideoFingerSlidingView.this.isCallback) {
                    return true;
                }
                float abs = Math.abs(motionEvent2.getX() - motionEvent.getX());
                float abs2 = Math.abs(motionEvent2.getY() - motionEvent.getY());
                if ((abs > VideoFingerSlidingView.this.slidingThreshold || abs2 > VideoFingerSlidingView.this.slidingThreshold) && VideoFingerSlidingView.this.mSlidingListener != null) {
                    VideoFingerSlidingView.this.mSlidingListener.onSliding();
                    VideoFingerSlidingView.this.isCallback = true;
                }
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (VideoFingerSlidingView.this.mSlidingListener != null) {
                    VideoFingerSlidingView.this.mSlidingListener.onSliding();
                    VideoFingerSlidingView.this.isCallback = true;
                }
                return true;
            }
        });
        setOnTouchListener(this);
        setFocusable(true);
        setClickable(true);
        setLongClickable(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelAnimator();
        this.mAnimator = null;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.mGestureDetector.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.isVisibility = i == 0;
        if (i == 0) {
            this.mImageView.post(new CtFAbx.A2egSU(29, this));
        } else {
            cancelAnimator();
        }
    }

    public void setSlidingListener(int i, SlidingListener slidingListener) {
        this.mSlidingListener = slidingListener;
        this.slidingThreshold = i * 2;
    }

    public VideoFingerSlidingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoFingerSlidingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.slidingThreshold = 100;
        this.isCallback = false;
        this.isVisibility = false;
        createView();
    }
}

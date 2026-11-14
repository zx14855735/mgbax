package com.bytedance.sdk.openadsdk.core.playable;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Shader;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.pz;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class PlayableVideoContainer extends FrameLayout {
    private long c;
    private View.OnClickListener f;
    private float hf;
    private View kd;
    private FrameLayout u;
    private float w;
    private final Paint xj;
    private View y;

    public PlayableVideoContainer(Context context) {
        super(context);
        this.xj = new Paint();
        this.c = 0L;
        hf();
    }

    private void hf() {
        int w = r.w(getContext(), 2.0f);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setPadding(w, w, w, w);
        addView(frameLayout, -1, -1);
        FrameLayout frameLayout2 = new FrameLayout(getContext());
        this.u = frameLayout2;
        frameLayout.addView(frameLayout2);
        this.kd = w();
        frameLayout.addView(this.kd, new ViewGroup.MarginLayoutParams(-1, -1));
        this.y = u();
        frameLayout.addView(this.y, new ViewGroup.MarginLayoutParams(-1, -1));
        setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.playable.PlayableVideoContainer.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                if (outline == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), r.w(pz.getContext(), 12.0f));
            }
        });
        setClipToOutline(true);
    }

    private void kd() {
        View.OnClickListener onClickListener = this.f;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    private View u() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setBackgroundColor(Color.parseColor("#77000000"));
        TextView textView = new TextView(getContext());
        textView.setId(2114387593);
        textView.setText("视频异常\n无法播放");
        textView.setTextColor(-1);
        textView.setTextSize(2, 12.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(textView, layoutParams);
        relativeLayout.setVisibility(8);
        return relativeLayout;
    }

    private View w() {
        int w = r.w(getContext(), 8.0f);
        int w2 = r.w(getContext(), 7.0f);
        int w3 = r.w(getContext(), 5.0f);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setBackgroundColor(Color.parseColor("#77000000"));
        TextView textView = new TextView(getContext());
        textView.setId(2114387593);
        textView.setText("可以\n拖动");
        textView.setTextColor(-1);
        textView.setTextSize(2, 12.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(textView, layoutParams);
        ImageView imageView = new ImageView(getContext());
        jk.xj(getContext(), "tt_arrow_up", imageView);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(w2, w3);
        layoutParams2.setMargins(w, w, w, w);
        layoutParams2.addRule(14);
        layoutParams2.addRule(2, textView.getId());
        relativeLayout.addView(imageView, layoutParams2);
        ImageView imageView2 = new ImageView(getContext());
        jk.xj(getContext(), "tt_arrow_down", imageView2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(w2, w3);
        layoutParams3.setMargins(w, w, w, w);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, textView.getId());
        relativeLayout.addView(imageView2, layoutParams3);
        ImageView imageView3 = new ImageView(getContext());
        jk.xj(getContext(), "tt_arrow_left", imageView3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(w3, w2);
        layoutParams4.setMargins(w, w, w, w);
        layoutParams4.addRule(15);
        layoutParams4.addRule(0, textView.getId());
        relativeLayout.addView(imageView3, layoutParams4);
        ImageView imageView4 = new ImageView(getContext());
        jk.xj(getContext(), "tt_arrow_right", imageView4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(w3, w2);
        layoutParams5.setMargins(w, w, w, w);
        layoutParams5.addRule(15);
        layoutParams5.addRule(1, textView.getId());
        relativeLayout.addView(imageView4, layoutParams5);
        relativeLayout.setVisibility(8);
        return relativeLayout;
    }

    private void y() {
        int height;
        final int i;
        final int i2;
        int width;
        int u = r.u(getContext());
        int kd = r.kd(getContext());
        final int left = getLeft();
        final int top = getTop();
        int left2 = getLeft();
        int right = u - getRight();
        int top2 = getTop();
        int bottom = kd - getBottom();
        int w = r.w(getContext(), 20.0f);
        int min = Math.min(Math.min(left2, right), Math.min(top2, bottom));
        if (left2 != min) {
            if (right == min) {
                width = (u - w) - getWidth();
                int top3 = getTop();
                int bottom2 = getBottom();
                if (top3 < 0) {
                    bottom2 = getHeight() + w;
                    top3 = w;
                }
                if (bottom2 <= kd) {
                    i2 = width;
                    i = top3;
                    ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);
                    duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.playable.PlayableVideoContainer.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float animatedFraction = valueAnimator.getAnimatedFraction();
                            int i3 = (int) (((i2 - r0) * animatedFraction) + left);
                            int i4 = (int) (((i - r1) * animatedFraction) + top);
                            PlayableVideoContainer.this.xj(i3, i4, PlayableVideoContainer.this.getWidth() + i3, PlayableVideoContainer.this.getHeight() + i4);
                        }
                    });
                    duration.start();
                }
                w = (kd - w) - getHeight();
                i2 = width;
            } else if (top2 == min) {
                int left3 = getLeft();
                int right2 = getRight();
                getHeight();
                if (left3 < 0) {
                    right2 = getWidth() + w;
                    left3 = w;
                }
                if (right2 > u) {
                    width = (u - w) - getWidth();
                    i2 = width;
                } else {
                    i2 = left3;
                }
            } else {
                int left4 = getLeft();
                int right3 = getRight();
                height = (kd - w) - getHeight();
                if (left4 < 0) {
                    right3 = getWidth() + w;
                    left4 = w;
                }
                if (right3 <= u) {
                    i = height;
                    i2 = left4;
                    ValueAnimator duration2 = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);
                    duration2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.playable.PlayableVideoContainer.3
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float animatedFraction = valueAnimator.getAnimatedFraction();
                            int i3 = (int) (((i2 - r0) * animatedFraction) + left);
                            int i4 = (int) (((i - r1) * animatedFraction) + top);
                            PlayableVideoContainer.this.xj(i3, i4, PlayableVideoContainer.this.getWidth() + i3, PlayableVideoContainer.this.getHeight() + i4);
                        }
                    });
                    duration2.start();
                }
                w = (u - w) - getWidth();
            }
            i = w;
            ValueAnimator duration22 = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);
            duration22.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.playable.PlayableVideoContainer.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    int i3 = (int) (((i2 - r0) * animatedFraction) + left);
                    int i4 = (int) (((i - r1) * animatedFraction) + top);
                    PlayableVideoContainer.this.xj(i3, i4, PlayableVideoContainer.this.getWidth() + i3, PlayableVideoContainer.this.getHeight() + i4);
                }
            });
            duration22.start();
        }
        getWidth();
        int top4 = getTop();
        int bottom3 = getBottom();
        if (top4 < 0) {
            bottom3 = getHeight() + w;
            top4 = w;
        }
        if (bottom3 <= kd) {
            i = top4;
            i2 = w;
            ValueAnimator duration222 = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);
            duration222.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.playable.PlayableVideoContainer.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    int i3 = (int) (((i2 - r0) * animatedFraction) + left);
                    int i4 = (int) (((i - r1) * animatedFraction) + top);
                    PlayableVideoContainer.this.xj(i3, i4, PlayableVideoContainer.this.getWidth() + i3, PlayableVideoContainer.this.getHeight() + i4);
                }
            });
            duration222.start();
        }
        height = (kd - w) - getHeight();
        i = height;
        i2 = w;
        ValueAnimator duration2222 = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);
        duration2222.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.playable.PlayableVideoContainer.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                int i3 = (int) (((i2 - r0) * animatedFraction) + left);
                int i4 = (int) (((i - r1) * animatedFraction) + top);
                PlayableVideoContainer.this.xj(i3, i4, PlayableVideoContainer.this.getWidth() + i3, PlayableVideoContainer.this.getHeight() + i4);
            }
        });
        duration2222.start();
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        this.xj.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredHeight(), new int[]{Color.parseColor("#FFDD42"), Color.parseColor("#FFB744")}, (float[]) null, Shader.TileMode.CLAMP));
        this.xj.setColor(-65536);
        this.xj.setStyle(Paint.Style.STROKE);
        this.xj.setAntiAlias(true);
        this.xj.setStrokeWidth(r.w(getContext(), 4.0f));
        canvas.drawRoundRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), r.w(getContext(), 12.0f), r.w(getContext(), 12.0f), this.xj);
        return drawChild;
    }

    public FrameLayout getVideoContainer() {
        return this.u;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
    
        if (r0 != 3) goto L25;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            super.onTouchEvent(r7)
            int r0 = r7.getAction()
            r1 = 1
            if (r0 == 0) goto L80
            if (r0 == r1) goto L47
            r2 = 2
            if (r0 == r2) goto L14
            r7 = 3
            if (r0 == r7) goto L78
            goto L92
        L14:
            float r0 = r7.getX()
            float r2 = r6.hf
            float r0 = r0 - r2
            float r7 = r7.getY()
            float r2 = r6.w
            float r7 = r7 - r2
            r2 = 0
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 == 0) goto L92
            int r2 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r2 == 0) goto L92
            int r2 = r6.getLeft()
            float r2 = (float) r2
            float r2 = r2 + r0
            int r0 = (int) r2
            int r2 = r6.getWidth()
            int r2 = r2 + r0
            int r3 = r6.getTop()
            float r3 = (float) r3
            float r3 = r3 + r7
            int r7 = (int) r3
            int r3 = r6.getHeight()
            int r3 = r3 + r7
            r6.xj(r0, r7, r2, r3)
            goto L92
        L47:
            float r0 = r7.getX()
            float r2 = r6.hf
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            float r7 = r7.getY()
            float r2 = r6.w
            float r7 = r7 - r2
            float r7 = java.lang.Math.abs(r7)
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r4 = r6.c
            long r2 = r2 - r4
            r4 = 1092616192(0x41200000, float:10.0)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 >= 0) goto L78
            int r7 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r7 >= 0) goto L78
            r4 = 200(0xc8, double:9.9E-322)
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 >= 0) goto L78
            r6.kd()
            return r1
        L78:
            r6.y()
            r7 = 0
            r6.setPressed(r7)
            goto L92
        L80:
            float r0 = r7.getX()
            r6.hf = r0
            float r7 = r7.getY()
            r6.w = r7
            long r2 = android.os.SystemClock.elapsedRealtime()
            r6.c = r2
        L92:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.playable.PlayableVideoContainer.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setCustomClickListener(View.OnClickListener onClickListener) {
        this.f = onClickListener;
    }

    public void xj() {
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.playable.PlayableVideoContainer.2
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup.LayoutParams layoutParams = PlayableVideoContainer.this.getLayoutParams();
                layoutParams.width = r.w(PlayableVideoContainer.this.getContext(), 94.0f);
                layoutParams.height = r.w(PlayableVideoContainer.this.getContext(), 167.0f);
                PlayableVideoContainer.this.setLayoutParams(layoutParams);
            }
        });
    }

    public void xj(boolean z) {
        if (!z) {
            r.xj(this.y, 8);
        } else {
            r.xj(this.y, 0);
            r.xj(this.kd, 8);
        }
    }

    public void xj(int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.topMargin = i2;
        layoutParams.gravity = 0;
        layout(i, i2, i3, i4);
    }

    public void hf(boolean z) {
        if (z) {
            r.xj(this.kd, 0);
            r.xj(this.y, 8);
        } else {
            r.xj(this.kd, 8);
        }
    }
}

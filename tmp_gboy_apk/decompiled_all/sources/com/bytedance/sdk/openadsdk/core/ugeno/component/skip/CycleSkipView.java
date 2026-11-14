package com.bytedance.sdk.openadsdk.core.ugeno.component.skip;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class CycleSkipView extends View {
    private Paint am;
    protected boolean c;
    protected float d;
    private ValueAnimator e;
    protected float f;
    private Paint g;
    protected int hf;
    private float ht;
    private boolean jk;
    protected float kd;
    protected boolean p;

    /* renamed from: pl, reason: collision with root package name */
    private Paint f10433pl;
    private final RectF pz;
    private float qt;
    protected int tf;
    protected float u;
    private ValueAnimator v;
    protected int w;
    protected int xj;
    protected int y;
    private ValueAnimator yo;
    private AnimatorSet zg;

    public CycleSkipView(Context context) {
        super(context);
        this.xj = Color.parseColor("#f9e8b9");
        this.hf = Color.parseColor("#ffffff");
        this.w = Color.parseColor("#7b7b7b");
        this.y = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME;
        this.c = false;
        this.f = 5.0f;
        this.d = 0.0f;
        this.tf = 0;
        this.p = true;
        this.qt = 0.0f;
        this.jk = false;
        this.pz = new RectF();
        this.ht = 1.0f;
        this.u = xj(2.0f);
        this.kd = xj(10.0f);
        this.y %= MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        hf();
        setBackgroundColor(-16711681);
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.yo;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.yo = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.qt, this.ht);
        this.yo = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.yo.setDuration(1000L);
        this.yo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.skip.CycleSkipView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                CycleSkipView.this.qt = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                CycleSkipView.this.postInvalidate();
            }
        });
        return this.yo;
    }

    private int getMinLine() {
        return Math.min(getMeasuredHeight(), getMeasuredWidth());
    }

    private void hf() {
        Paint paint = new Paint(1);
        this.f10433pl = paint;
        paint.setColor(this.xj);
        this.f10433pl.setStrokeWidth(this.u);
        this.f10433pl.setAntiAlias(true);
        this.f10433pl.setStrokeCap(Paint.Cap.ROUND);
        this.f10433pl.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.g = paint2;
        paint2.setColor(this.hf);
        this.g.setAntiAlias(true);
        this.g.setStrokeWidth(this.u);
        this.g.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.am = paint3;
        paint3.setColor(this.w);
        this.am.setTextAlign(Paint.Align.CENTER);
    }

    private int w() {
        return (int) ((((this.u / 2.0f) + this.kd) * 2.0f) + xj(4.0f));
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        try {
            AnimatorSet animatorSet = this.zg;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.zg = null;
            }
            ValueAnimator valueAnimator = this.v;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.v = null;
            }
            ValueAnimator valueAnimator2 = this.e;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.e = null;
            }
            ValueAnimator valueAnimator3 = this.yo;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
                this.yo = null;
            }
            this.qt = 1.0f;
            invalidate();
        } catch (Exception unused) {
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        hf(canvas);
        xj(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            size = w();
        }
        if (mode2 != 1073741824) {
            size2 = w();
        }
        hf(size, size2);
        setMeasuredDimension(size, size2);
        RectF rectF = this.pz;
        float f = this.kd;
        rectF.left = -f;
        rectF.right = f;
        rectF.top = -f;
        rectF.bottom = f;
        this.am.setTextSize(getMinLine() / 3.0f);
    }

    private void xj(Canvas canvas) {
        canvas.save();
        Paint.FontMetrics fontMetrics = this.am.getFontMetrics();
        canvas.drawText("跳过", 0.0f, (getMinLine() / 3.0f) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f), this.am);
        canvas.restore();
    }

    private float xj(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    public void xj() {
        AnimatorSet animatorSet = this.zg;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.zg.cancel();
            this.zg = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.zg = animatorSet2;
        animatorSet2.playTogether(getArcAnim());
        this.zg.setInterpolator(new LinearInterpolator());
        this.zg.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.skip.CycleSkipView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                CycleSkipView.this.jk = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (CycleSkipView.this.jk) {
                    CycleSkipView.this.jk = false;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        this.zg.start();
    }

    private void hf(int i, int i2) {
        this.kd = (Math.min(i, i2) / 2.0f) - this.u;
    }

    private void hf(Canvas canvas) {
        float f;
        float max;
        float f2;
        canvas.save();
        float f3 = this.qt * 360.0f;
        if (this.c) {
            if (this.p) {
                f = this.y;
                f3 = -f3;
            } else {
                f = this.y - f3;
            }
        } else {
            if (this.p) {
                float f4 = this.y + MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
                max = Math.max(0.0f, 360.0f - f3);
                f2 = f4;
                canvas.drawCircle(0.0f, 0.0f, this.kd, this.g);
                canvas.drawArc(this.pz, f2, max, false, this.f10433pl);
                canvas.restore();
            }
            f = this.y;
        }
        max = f3;
        f2 = f;
        canvas.drawCircle(0.0f, 0.0f, this.kd, this.g);
        canvas.drawArc(this.pz, f2, max, false, this.f10433pl);
        canvas.restore();
    }

    public void xj(int i, int i2) {
        if (i == 0) {
            return;
        }
        float f = i;
        this.f = f;
        float f2 = i2;
        this.d = f2;
        this.tf = i - i2;
        this.ht = f2 / f;
        xj();
    }
}

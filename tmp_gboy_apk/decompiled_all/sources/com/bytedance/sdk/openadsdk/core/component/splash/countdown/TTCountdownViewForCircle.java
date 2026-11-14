package com.bytedance.sdk.openadsdk.core.component.splash.countdown;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.pz;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class TTCountdownViewForCircle extends View implements u {
    private boolean ai;
    private boolean am;
    private float c;
    private boolean d;
    private AnimatorSet dk;
    private Paint e;
    private ValueAnimator et;
    private int f;
    private String g;
    private int hf;
    private RectF ht;

    /* renamed from: io, reason: collision with root package name */
    private ValueAnimator f10330io;
    private float jk;
    private float kd;
    private float p;

    /* renamed from: pl, reason: collision with root package name */
    private float f10331pl;
    private float pz;
    private AtomicBoolean q;
    private boolean qt;
    private xj ra;
    private float tf;
    private int u;
    private Paint v;
    private int w;
    private ValueAnimator x;
    private int xj;
    private float y;
    private Paint yo;
    private Paint zg;

    public TTCountdownViewForCircle(Context context) {
        this(context, null);
    }

    private void c() {
        try {
            AnimatorSet animatorSet = this.dk;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.dk = null;
            }
            ValueAnimator valueAnimator = this.x;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.x = null;
            }
            ValueAnimator valueAnimator2 = this.et;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.et = null;
            }
            ValueAnimator valueAnimator3 = this.f10330io;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
                this.f10330io = null;
            }
            this.jk = 1.0f;
            this.pz = 1.0f;
            invalidate();
        } catch (Exception unused) {
        }
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.f10330io;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f10330io = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.jk, 0.0f);
        this.f10330io = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.f10330io.setDuration((long) (xj(this.jk, this.tf) * 1000.0f));
        this.f10330io.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForCircle.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TTCountdownViewForCircle.this.jk = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                TTCountdownViewForCircle.this.invalidate();
            }
        });
        return this.f10330io;
    }

    private ValueAnimator getNumAnim() {
        ValueAnimator valueAnimator = this.et;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.et = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.pz, 0.0f);
        this.et = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.et.setDuration((long) (xj(this.pz, this.p) * 1000.0f));
        this.et.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForCircle.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TTCountdownViewForCircle.this.pz = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                TTCountdownViewForCircle.this.invalidate();
            }
        });
        return this.et;
    }

    private void kd() {
        float f = this.c;
        this.ht = new RectF(-f, -f, f, f);
    }

    private void u() {
        Paint paint = new Paint(1);
        this.zg = paint;
        paint.setColor(this.xj);
        this.zg.setStrokeWidth(this.kd);
        this.zg.setAntiAlias(true);
        Paint paint2 = this.zg;
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        Paint paint3 = new Paint(1);
        this.e = paint3;
        paint3.setColor(this.w);
        this.e.setAntiAlias(true);
        this.e.setStrokeWidth(this.kd);
        this.e.setStyle(Paint.Style.FILL);
        Paint paint4 = new Paint(1);
        this.yo = paint4;
        paint4.setColor(this.hf);
        this.yo.setAntiAlias(true);
        this.yo.setStrokeWidth(this.kd / 2.0f);
        this.yo.setStyle(style);
        Paint paint5 = new Paint(1);
        this.v = paint5;
        paint5.setColor(this.u);
        this.yo.setAntiAlias(true);
        this.v.setTextSize(this.y);
        this.v.setTextAlign(Paint.Align.CENTER);
    }

    private int y() {
        return (int) ((((this.kd / 2.0f) + this.c) * 2.0f) + xj(4.0f));
    }

    public xj getCountdownListener() {
        return this.ra;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.u
    public View getView() {
        return this;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        c();
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
            size = y();
        }
        if (mode2 != 1073741824) {
            size2 = y();
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.q.set(z);
        if (this.qt) {
            return;
        }
        if (this.q.get()) {
            w();
        } else {
            hf();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.u
    public void setCountDownTime(int i) {
        float f = i;
        this.p = f;
        this.tf = f;
        c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.u
    public void setCountdownListener(xj xjVar) {
        this.ra = xjVar;
        this.q.get();
    }

    public void w() {
        AnimatorSet animatorSet;
        try {
            if (this.qt || (animatorSet = this.dk) == null) {
                return;
            }
            animatorSet.resume();
        } catch (Throwable unused) {
        }
    }

    public float xj(float f, float f2) {
        return f * f2;
    }

    public TTCountdownViewForCircle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public float xj(float f, int i) {
        return i * f;
    }

    public TTCountdownViewForCircle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.xj = Color.parseColor("#fce8b6");
        this.hf = Color.parseColor("#f0f0f0");
        this.w = Color.parseColor("#ffffff");
        this.u = Color.parseColor("#7c7c7c");
        this.kd = 2.0f;
        this.y = 12.0f;
        this.c = 18.0f;
        this.f = MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME;
        this.d = false;
        this.tf = 5.0f;
        this.p = 5.0f;
        this.f10331pl = 0.8f;
        this.g = "跳过";
        this.am = false;
        this.qt = false;
        this.jk = 1.0f;
        this.pz = 1.0f;
        this.ai = false;
        this.q = new AtomicBoolean(true);
        this.kd = xj(2.0f);
        this.c = xj(18.0f);
        this.y = hf(12.0f);
        this.f %= MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        u();
        kd();
    }

    private void hf(Canvas canvas) {
        float f;
        canvas.save();
        float xj = xj(this.jk, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL);
        if (this.d) {
            f = this.f - xj;
        } else {
            f = this.f;
        }
        float f2 = f;
        canvas.drawCircle(0.0f, 0.0f, this.c, this.e);
        canvas.drawCircle(0.0f, 0.0f, this.c, this.yo);
        canvas.drawArc(this.ht, f2, xj, false, this.zg);
        canvas.restore();
    }

    private void xj(Canvas canvas) {
        canvas.save();
        Paint.FontMetrics fontMetrics = this.v.getFontMetrics();
        String da = pz.hf().da();
        this.g = da;
        if (TextUtils.isEmpty(da)) {
            this.g = "跳过";
        }
        canvas.drawText(this.g, 0.0f, 0.0f - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f), this.v);
        canvas.restore();
    }

    private float hf(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.u
    public void xj() {
        if (this.qt) {
            return;
        }
        AnimatorSet animatorSet = this.dk;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.dk.cancel();
            this.dk = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.dk = animatorSet2;
        animatorSet2.playTogether(getNumAnim(), getArcAnim());
        this.dk.setInterpolator(new LinearInterpolator());
        this.dk.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForCircle.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                TTCountdownViewForCircle.this.ai = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (TTCountdownViewForCircle.this.ai) {
                    TTCountdownViewForCircle.this.ai = false;
                } else if (TTCountdownViewForCircle.this.ra != null) {
                    TTCountdownViewForCircle.this.ra.xj();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        try {
            Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
            declaredField.setAccessible(true);
            if (declaredField.getFloat(null) < 1.0f) {
                declaredField.setFloat(null, 1.0f);
            }
        } catch (Throwable unused) {
        }
        this.dk.start();
        if (this.q.get()) {
            return;
        }
        hf();
    }

    public void hf() {
        try {
            AnimatorSet animatorSet = this.dk;
            if (animatorSet != null) {
                animatorSet.pause();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.u
    public void xj(boolean z) {
        this.qt = z;
        if (z) {
            c();
        }
    }

    private float xj(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }
}

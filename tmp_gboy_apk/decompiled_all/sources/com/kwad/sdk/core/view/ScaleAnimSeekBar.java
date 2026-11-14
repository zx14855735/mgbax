package com.kwad.sdk.core.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ScaleAnimSeekBar extends View {
    private Paint aQS;
    private int aQT;
    private int aQU;
    private int aQV;
    private int aQW;
    private int aQX;
    private int aQY;
    private int aQZ;
    private ValueAnimator aRA;
    private ValueAnimator aRB;
    private float aRC;
    private float aRD;
    private float aRE;
    private float aRF;
    private int aRG;
    private boolean aRH;
    private int aRa;
    private boolean aRb;
    private int aRc;
    private int aRd;
    private int aRe;
    private int aRf;
    private int aRg;
    private int aRh;
    private int aRi;
    private GradientDrawable aRj;
    private GradientDrawable aRk;
    private GradientDrawable aRl;
    private Rect aRm;
    private Rect aRn;
    private Rect aRo;
    private Rect aRp;
    private Drawable aRq;
    private boolean aRr;
    private boolean aRs;
    private boolean aRt;
    private boolean aRu;
    private boolean aRv;
    private WeakReference<a> aRw;
    private boolean aRx;
    private boolean aRy;
    private ValueAnimator aRz;

    public interface a {
        void a(ScaleAnimSeekBar scaleAnimSeekBar);

        void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z);

        void xE();
    }

    public ScaleAnimSeekBar(Context context) {
        this(context, null);
    }

    private void bA(boolean z) {
        if (this.aRx) {
            if (z) {
                bB(true);
                bC(true);
            } else {
                bB(false);
                bC(false);
            }
        }
    }

    private void bB(boolean z) {
        float f = this.aRC;
        float f2 = z ? this.aRD : 1.0f;
        ValueAnimator valueAnimator = this.aRz;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.aRz = valueAnimator2;
            valueAnimator2.setDuration(250L);
            this.aRz.setInterpolator(new LinearInterpolator());
            this.aRz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ScaleAnimSeekBar.this.aRC = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.aRz.setFloatValues(f, f2);
        this.aRz.start();
    }

    private void bC(boolean z) {
        float f = this.aRE;
        float f2 = z ? this.aRF : 1.0f;
        ValueAnimator valueAnimator = this.aRA;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.aRA = valueAnimator2;
            valueAnimator2.setDuration(250L);
            this.aRA.setInterpolator(new LinearInterpolator());
            this.aRA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    ScaleAnimSeekBar.this.aRE = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar.this.requestLayout();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.aRA.setFloatValues(f, f2);
        this.aRA.start();
    }

    private void cb(Context context) {
        this.aRx = true;
        this.aRG = com.kwad.sdk.c.a.a.a(context, 10.0f);
        this.aQW = com.kwad.sdk.c.a.a.a(context, 3.0f);
        this.aRd = com.kwad.sdk.c.a.a.a(context, 20.0f);
        this.aRq = null;
        this.aRy = false;
        this.aRa = com.kwad.sdk.c.a.a.a(context, 0.5f);
        this.aQZ = com.kwad.sdk.c.a.a.a(context, 1.0f);
        this.aQT = 654311423;
        this.aQU = -1;
        this.aQV = 1090519039;
        this.aQX = 0;
        this.aQY = 100;
        this.aRb = false;
    }

    private boolean d(float f, float f2) {
        int i;
        int i2;
        Rect rect = this.aRp;
        int i3 = rect.left;
        int i4 = rect.right;
        if (i3 >= i4 || (i = rect.top) >= (i2 = rect.bottom)) {
            return false;
        }
        float f3 = this.aRC;
        int i5 = this.aRd;
        return f >= (((float) i3) * f3) - ((float) i5) && f <= (((float) i4) * f3) + ((float) i5) && f2 >= (((float) i) * f3) - ((float) i5) && f2 <= (((float) i2) * f3) + ((float) i5);
    }

    private boolean e(float f, float f2) {
        int i;
        int i2;
        Rect rect = this.aRm;
        int i3 = rect.left;
        int i4 = rect.right;
        if (i3 >= i4 || (i = rect.top) >= (i2 = rect.bottom)) {
            return false;
        }
        float f3 = this.aRE;
        int i5 = this.aRd;
        return f >= (((float) i3) * f3) - ((float) i5) && f <= (((float) i4) * f3) + ((float) i5) && f2 >= (((float) i) * f3) - ((float) i5) && f2 <= (((float) i2) * f3) + ((float) i5);
    }

    private float ei(int i) {
        int i2 = this.aRc;
        int i3 = this.aQX;
        return ((i2 * (i - i3)) / (this.aQY - i3)) - (i2 / 2.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ej(int i) {
        int i2 = this.aRc;
        if (i > i2 / 2) {
            return this.aQY;
        }
        if (i < (-i2) / 2) {
            return this.aQX;
        }
        return Math.round((((i2 / 2.0f) + i) * (this.aQY - this.aQX)) / i2) + this.aQX;
    }

    private a getOnSeekBarChangedListener() {
        WeakReference<a> weakReference = this.aRw;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private void i(boolean z, int i) {
        if (!z) {
            this.aRe = i;
            m(n(ei(i)));
            return;
        }
        float n = n(ei(this.aRe));
        float n2 = n(ei(i));
        ValueAnimator valueAnimator = this.aRB;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.aRB = valueAnimator2;
            valueAnimator2.setDuration(300L);
            this.aRB.setInterpolator(new Interpolator() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.1
                @Override // android.animation.TimeInterpolator
                public final float getInterpolation(float f) {
                    float f2 = f - 1.0f;
                    return (f2 * f2 * f2) + 1.0f;
                }
            });
            this.aRB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.core.view.ScaleAnimSeekBar.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    float floatValue = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                    ScaleAnimSeekBar scaleAnimSeekBar = ScaleAnimSeekBar.this;
                    scaleAnimSeekBar.aRe = scaleAnimSeekBar.ej((int) floatValue);
                    ScaleAnimSeekBar.this.m(floatValue);
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.aRB.setFloatValues(n, n2);
        this.aRB.start();
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            cb(context);
        }
        Paint paint = new Paint();
        this.aQS = paint;
        paint.setStyle(Paint.Style.FILL);
        this.aQS.setAntiAlias(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.aRj = gradientDrawable;
        gradientDrawable.setShape(0);
        this.aRj.setColor(this.aQT);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.aRk = gradientDrawable2;
        gradientDrawable2.setShape(0);
        this.aRk.setColor(this.aQU);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        this.aRl = gradientDrawable3;
        gradientDrawable3.setShape(0);
        this.aRl.setColor(this.aQV);
        this.aRm = new Rect();
        this.aRn = new Rect();
        this.aRp = new Rect();
        this.aRo = new Rect();
        this.aRe = this.aQX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(float f) {
        Rect rect = this.aRp;
        int i = this.aQW;
        rect.left = (int) (f - i);
        rect.right = (int) (i + f);
        this.aRn.right = (int) f;
        invalidate();
    }

    private float n(float f) {
        float f2 = this.aRc / 2;
        if (f > f2) {
            return f2;
        }
        float f3 = -f2;
        return f < f3 ? f3 : f;
    }

    private void z(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        if (this.aRx) {
            this.aRc = (int) (i - ((this.aRD - this.aRC) * (this.aRG * 2)));
        } else {
            this.aRc = i - (this.aRG * 2);
        }
        Rect rect = this.aRm;
        int i3 = this.aRa;
        int i4 = -i3;
        rect.top = i4;
        rect.bottom = -i4;
        boolean z = this.aRb;
        rect.left = (z ? -i : -this.aRc) / 2;
        rect.right = z ? i / 2 : this.aRc / 2;
        Rect rect2 = this.aRn;
        int i5 = -i3;
        rect2.top = i5;
        rect2.bottom = -i5;
        rect2.left = (z ? -i : -this.aRc) / 2;
        int i6 = this.aRc;
        rect2.right = (-i6) / 2;
        Rect rect3 = this.aRo;
        rect3.top = -i3;
        rect3.bottom = -rect2.top;
        rect3.left = (z ? -i : -i6) / 2;
        rect3.right = (-i6) / 2;
        Rect rect4 = this.aRp;
        int i7 = this.aQW;
        rect4.top = -i7;
        rect4.bottom = i7;
        rect4.left = ((-i6) / 2) - i7;
        rect4.right = ((-i6) / 2) + i7;
        setThumbDrawable(this.aRq);
        setProgress(this.aRe);
        setSecondaryProgress(this.aRg);
    }

    public final void bz(boolean z) {
        this.aRH = z;
        bA(z);
    }

    public int getMaxProgress() {
        return this.aQY;
    }

    public int getProgress() {
        return this.aRe;
    }

    public int getProgressLength() {
        return this.aRc;
    }

    public int getProgressX() {
        return (int) ((this.aQW * this.aRD) + getX());
    }

    public int getSecondaryProgress() {
        return this.aRg;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(this.aRi / 2, this.aRh / 2);
        a(canvas, this.aRm, this.aRj);
        a(canvas, this.aRo, this.aRl);
        a(canvas, this.aRn, this.aRk);
        if (this.aRH) {
            c(canvas);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            this.aRi = size;
        } else {
            this.aRi = getWidth();
        }
        if (mode2 == 1073741824) {
            this.aRh = size2;
        } else {
            this.aRh = getHeight();
        }
        z(this.aRi, this.aRh);
        setMeasuredDimension(this.aRi, this.aRh);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX() - (this.aRi / 2);
        float y = motionEvent.getY() - (this.aRh / 2);
        ViewParent parent = getParent();
        a onSeekBarChangedListener = getOnSeekBarChangedListener();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.aRv = false;
                if (this.aRs || this.aRr) {
                    this.aRs = false;
                    this.aRr = false;
                    a(ej((int) x), this.aRy, true);
                    if (onSeekBarChangedListener != null) {
                        onSeekBarChangedListener.a(this);
                    }
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            } else if (action == 2 && (this.aRr || this.aRs)) {
                a(ej((int) x), false, true);
            }
        } else {
            if (!this.aRu) {
                return super.onTouchEvent(motionEvent);
            }
            if (d(x, y)) {
                bA(true);
                this.aRr = true;
                this.aRv = true;
                if (onSeekBarChangedListener != null) {
                    onSeekBarChangedListener.xE();
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if (e(x, y)) {
                bA(true);
                this.aRs = true;
                if (onSeekBarChangedListener != null) {
                    onSeekBarChangedListener.xE();
                }
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
        return true;
    }

    public void setMaxProgress(int i) {
        this.aQY = i;
    }

    public void setMinProgress(int i) {
        this.aQX = i;
        if (this.aRe < i) {
            this.aRe = i;
        }
    }

    public void setOnSeekBarChangeListener(a aVar) {
        this.aRw = new WeakReference<>(aVar);
    }

    public void setProgress(int i) {
        a(i, false, false);
    }

    public void setProgressBackgroundColor(int i) {
        this.aQT = i;
        this.aRj.setColor(i);
    }

    public void setProgressColor(int i) {
        this.aQU = i;
        this.aRk.setColor(i);
    }

    public void setSecondaryProgress(int i) {
        int i2 = this.aQX;
        if (i <= i2 || i >= (i2 = this.aQY)) {
            i = i2;
        }
        this.aRg = i;
        this.aRo.right = (int) n(ei(i));
        invalidate();
    }

    public void setSecondaryProgressColor(int i) {
        this.aQV = i;
        this.aRl.setColor(i);
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        this.aRq = drawable;
    }

    public void setThumbEnable(boolean z) {
        this.aRu = z;
    }

    public void setThumbScale(float f) {
        this.aRC = f;
    }

    public void setThumbTouchOffset(int i) {
        this.aRd = i;
        invalidate();
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Canvas canvas) {
        canvas.save();
        Drawable drawable = this.aRq;
        if (drawable != null) {
            drawable.setBounds(this.aRp);
            this.aRq.draw(canvas);
        } else {
            this.aQS.setColor(this.aQU);
            canvas.drawCircle(this.aRp.centerX(), this.aRp.centerY(), (this.aRp.width() * this.aRC) / 2.0f, this.aQS);
        }
        canvas.restore();
    }

    public ScaleAnimSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aQY = 100;
        this.aRb = false;
        this.aRq = null;
        this.aRr = false;
        this.aRs = false;
        this.aRt = false;
        this.aRu = true;
        this.aRx = true;
        this.aRy = false;
        this.aRC = 1.0f;
        this.aRD = 1.34f;
        this.aRE = 1.0f;
        this.aRF = 2.0f;
        init(context, attributeSet);
    }

    private void a(Canvas canvas, Rect rect, GradientDrawable gradientDrawable) {
        canvas.save();
        Rect rect2 = new Rect();
        float f = rect.top;
        float f2 = this.aRE;
        rect2.top = (int) (f * f2);
        rect2.bottom = (int) (rect.bottom * f2);
        rect2.left = rect.left;
        rect2.right = rect.right;
        gradientDrawable.setBounds(rect2);
        gradientDrawable.setCornerRadius(this.aQZ * this.aRE);
        gradientDrawable.draw(canvas);
        canvas.restore();
    }

    private void a(int i, boolean z, boolean z2) {
        int i2 = this.aQX;
        if (i <= i2 || i >= (i2 = this.aQY)) {
            i = i2;
        }
        i(z, i);
        a onSeekBarChangedListener = getOnSeekBarChangedListener();
        if (onSeekBarChangedListener != null && this.aRf != this.aRe) {
            this.aRt = z2;
            onSeekBarChangedListener.a(this, z2);
            this.aRt = false;
        }
        this.aRf = this.aRe;
    }
}

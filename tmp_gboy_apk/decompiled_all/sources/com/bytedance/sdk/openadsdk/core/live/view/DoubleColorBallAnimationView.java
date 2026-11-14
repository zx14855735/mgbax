package com.bytedance.sdk.openadsdk.core.live.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.openadsdk.core.a.r;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class DoubleColorBallAnimationView extends View {
    private int am;
    private int c;
    private Paint d;
    private int e;
    private int f;
    private boolean g;
    private final float hf;
    private float jk;
    private final float kd;
    private float p;

    /* renamed from: pl, reason: collision with root package name */
    private boolean f10372pl;
    private float pz;
    private boolean qt;
    private final PorterDuffXfermode tf;
    private final float u;
    private float v;
    private final float w;
    private final float xj;
    private final long y;
    private float yo;
    private long zg;

    public DoubleColorBallAnimationView(Context context) {
        this(context, null);
    }

    private void kd() {
        this.zg = -1L;
        if (this.e <= 0) {
            setProgressBarInfo(r.w(getContext(), 60.0f));
        }
        int min = Math.min(getMeasuredHeight(), getMeasuredWidth());
        if (this.e > min && min > 0) {
            setProgressBarInfo(min);
        }
        if (this.d == null) {
            this.d = u();
        }
        this.g = true;
    }

    private Paint u() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
        return paint;
    }

    private float xj(float f) {
        if (f < 0.5d) {
            return 2.0f * f * f;
        }
        return ((2.0f - f) * (f * 2.0f)) - 1.0f;
    }

    public void hf() {
        kd();
        this.qt = true;
        this.f10372pl = true;
        postInvalidate();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if ((xj() || !this.f10372pl) && this.g) {
            if (this.f10372pl) {
                long nanoTime = System.nanoTime() / C.MICROS_PER_SECOND;
                if (this.zg < 0) {
                    this.zg = nanoTime;
                }
                float f = (nanoTime - this.zg) / 400.0f;
                this.p = f;
                int i = (int) f;
                r1 = ((this.am + i) & 1) == 1;
                this.p = f - i;
            }
            try {
                float xj = xj(this.p);
                int i2 = this.e;
                int saveLayer = canvas.saveLayer(0.0f, 0.0f, i2, i2, this.d, 31);
                float f2 = (this.pz * xj) + this.jk;
                float f3 = ((double) xj) < 0.5d ? xj * 2.0f : 2.0f - (xj * 2.0f);
                float f4 = this.v;
                float f5 = (0.25f * f3 * f4) + f4;
                this.d.setColor(r1 ? this.f : this.c);
                canvas.drawCircle(f2, this.yo, f5, this.d);
                float f6 = this.e - f2;
                float f7 = this.v;
                float f8 = f7 - ((f3 * 0.375f) * f7);
                this.d.setColor(r1 ? this.c : this.f);
                this.d.setXfermode(this.tf);
                canvas.drawCircle(f6, this.yo, f8, this.d);
                this.d.setXfermode(null);
                canvas.restoreToCount(saveLayer);
            } catch (Throwable unused) {
            }
            postInvalidateDelayed(17L);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int min = Math.min(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        if (this.e <= min || min <= 0) {
            return;
        }
        setProgressBarInfo(min);
    }

    public void setCycleBias(int i) {
        this.am = i;
    }

    public void setProgress(float f) {
        if (!this.g) {
            kd();
        }
        this.p = f;
        this.qt = false;
        this.f10372pl = false;
        postInvalidate();
    }

    public void setProgressBarInfo(int i) {
        if (i > 0) {
            this.e = i;
            this.yo = i / 2.0f;
            float f = (i >> 1) * 0.32f;
            this.v = f;
            float f2 = (i * 0.16f) + f;
            this.jk = f2;
            this.pz = i - (f2 * 2.0f);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            hf();
        } else {
            w();
        }
    }

    public void w() {
        this.qt = false;
        this.g = false;
        this.p = 0.0f;
    }

    public DoubleColorBallAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public boolean xj() {
        return this.qt;
    }

    public DoubleColorBallAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.xj = 0.25f;
        this.hf = 0.375f;
        this.w = 0.16f;
        this.u = 0.32f;
        this.kd = 400.0f;
        this.y = 17L;
        this.c = -119723;
        this.f = -14289682;
        this.tf = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.f10372pl = false;
        this.g = false;
        this.am = 0;
        this.qt = false;
        this.zg = -1L;
        this.e = -1;
    }
}

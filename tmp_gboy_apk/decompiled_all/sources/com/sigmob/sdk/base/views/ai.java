package com.sigmob.sdk.base.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ai extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f13255a;
    private RectF b;
    private float c;
    private String d;
    private Paint e;
    private Path f;
    private Paint g;
    private Path h;
    private int i;
    private int j;
    private int k;
    private float l;
    private int m;
    private int n;
    private int o;
    private int p;
    private ValueAnimator q;
    private ValueAnimator r;
    private String title;

    public ai(Context context) {
        super(context);
        this.l = 1.0f;
        a();
    }

    private void b() {
        ValueAnimator valueAnimator = this.q;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(-this.k, this.m + this.n);
        this.q = ofInt;
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.base.views.ai.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ai.this.i = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                ai.this.d();
                ai.this.invalidate();
            }
        });
        this.q.setDuration(800L);
        this.q.setRepeatCount(-1);
        this.q.setRepeatMode(1);
        this.q.start();
        ValueAnimator valueAnimator2 = this.r;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.15f);
        this.r = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.base.views.ai.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                ai.this.l = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
            }
        });
        this.r.setDuration(1000L);
        this.r.setRepeatCount(-1);
        this.r.setRepeatMode(2);
        this.r.start();
    }

    private void c() {
        this.f = new Path();
        this.g = new Paint();
        this.j = this.n;
        this.k = Dips.dipsToIntPixels(60.0f, getContext());
        this.g.setShader(new LinearGradient(0.0f, this.j, this.k, 0.0f, new int[]{a(-1, 0.2f), a(-1, 0.5f), a(-1, 0.2f)}, new float[]{0.2f, 0.8f, 1.0f}, Shader.TileMode.MIRROR));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.f.reset();
        this.f.moveTo((this.k / 2.0f) + this.i, 0.0f);
        this.f.lineTo(this.k + this.i, 0.0f);
        this.f.lineTo((this.k / 2.0f) + this.i, this.j);
        this.f.lineTo(this.i + 0.0f, this.j);
        this.f.close();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.q;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.r;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        this.f13255a.setStyle(Paint.Style.STROKE);
        this.f13255a.setColor(-1);
        this.f13255a.setAlpha(204);
        this.f13255a.setStrokeWidth(this.c);
        RectF rectF = this.b;
        float f2 = this.c;
        rectF.set(f2, f2, this.m - (f2 * 2.0f), this.n - (f2 * 2.0f));
        Path path = this.h;
        RectF rectF2 = this.b;
        int i = this.p;
        Path.Direction direction = Path.Direction.CCW;
        path.addRoundRect(rectF2, i, i, direction);
        canvas.drawPath(this.h, this.f13255a);
        Paint paint = this.f13255a;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.f13255a.setColor(com.sigmob.sdk.base.blurkit.d.f13043a);
        this.f13255a.setAlpha(76);
        this.h.reset();
        Path path2 = this.h;
        RectF rectF3 = this.b;
        path2.addRoundRect(rectF3, rectF3.height() / 2.0f, this.b.height() / 2.0f, direction);
        canvas.drawPath(this.h, this.f13255a);
        int i2 = this.n;
        float f3 = i2 * 0.3f * this.l;
        float f4 = this.m - ((i2 * 0.3f) * 2.0f);
        this.f13255a.setColor(-1);
        this.f13255a.setStyle(style);
        canvas.drawCircle(f4, this.n / 2.0f, f3, this.f13255a);
        this.f13255a.setColor(com.sigmob.sdk.base.blurkit.d.f13043a);
        this.f13255a.setTextSize(TypedValue.applyDimension(2, this.l * 16.0f, getResources().getDisplayMetrics()));
        Paint paint2 = this.f13255a;
        Typeface typeface = Typeface.DEFAULT_BOLD;
        paint2.setTypeface(typeface);
        float measureText = f4 - (this.f13255a.measureText("GO") / 1.5f);
        canvas.drawText("GO", measureText, (((this.f13255a.getFontMetrics().bottom - this.f13255a.getFontMetrics().top) / 2.0f) + (this.n / 2.0f)) - this.f13255a.getFontMetrics().bottom, this.f13255a);
        float measureText2 = this.f13255a.measureText("GO") * 0.4f;
        Path path3 = new Path();
        float f5 = measureText2 / 4.0f;
        float f6 = measureText2 / 2.0f;
        path3.moveTo(this.f13255a.measureText("GO") + measureText + f5, (this.n / 2.0f) - f6);
        path3.lineTo(this.f13255a.measureText("GO") + measureText + measureText2, this.n / 2.0f);
        path3.lineTo(this.f13255a.measureText("GO") + measureText + f5, (this.n / 2.0f) + f6);
        path3.close();
        canvas.drawPath(path3, this.f13255a);
        this.e.setStyle(style);
        this.e.setColor(-1);
        int i3 = 5;
        if (TextUtils.isEmpty(this.title)) {
            f = 0.0f;
        } else {
            this.e.setTextSize(TypedValue.applyDimension(2, 20.0f, getResources().getDisplayMetrics()));
            this.e.setTypeface(typeface);
            String str = this.title;
            f = (this.e.getFontMetrics().bottom - this.e.getFontMetrics().top) * 1.5f;
            int i4 = 5;
            while (true) {
                if (i4 >= this.title.length()) {
                    break;
                }
                float measureText3 = this.e.measureText(this.title, 0, i4) + f;
                RectF rectF4 = this.b;
                if (measureText3 > ((rectF4.right - rectF4.left) - f) - f3) {
                    str = this.title.substring(0, i4 - 2) + "...";
                    break;
                }
                i4++;
            }
            canvas.drawText(str, f, ((this.n / 2.0f) - (this.e.getFontMetrics().bottom - this.e.getFontMetrics().top)) - this.e.getFontMetrics().top, this.e);
        }
        if (!TextUtils.isEmpty(this.d)) {
            this.e.setTextSize(TypedValue.applyDimension(2, 16.0f, getResources().getDisplayMetrics()));
            this.e.setTypeface(Typeface.DEFAULT);
            float f7 = f > 0.0f ? f : (this.e.getFontMetrics().bottom - this.e.getFontMetrics().top) * 1.5f;
            String str2 = this.d;
            while (true) {
                if (i3 >= this.d.length()) {
                    break;
                }
                float measureText4 = this.e.measureText(this.d, 0, i3) + f;
                RectF rectF5 = this.b;
                if (measureText4 > ((rectF5.right - rectF5.left) - f) - f3) {
                    str2 = this.d.substring(0, i3 - 2) + "...";
                    break;
                }
                i3++;
            }
            canvas.drawText(str2, f7, (this.e.getFontMetrics().bottom - this.e.getFontMetrics().top) + (this.n / 2.0f), this.e);
        }
        canvas.clipPath(this.h);
        canvas.drawPath(this.f, this.g);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.m = i;
        this.n = (int) (i2 * 0.8f);
        this.o = i / 2;
        this.p = i2 / 2;
        c();
        b();
    }

    public ai(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = 1.0f;
        a();
    }

    private int a(int i, float f) {
        return Color.argb((int) (Color.alpha(i) * f), Color.red(i), Color.green(i), Color.blue(i));
    }

    public ai(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = 1.0f;
        a();
    }

    private void a() {
        setBackgroundColor(-65536);
        this.f13255a = new Paint(1);
        this.e = new Paint(1);
        this.b = new RectF();
        this.h = new Path();
        this.c = Dips.dipsToIntPixels(2.0f, getContext());
        setBackgroundColor(0);
    }

    public void a(String str, String str2) {
        this.title = str;
        this.d = str2;
    }
}

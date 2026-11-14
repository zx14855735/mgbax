package com.sigmob.sdk.base.views;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ab extends Drawable {
    private static final int i = 1;

    /* renamed from: a, reason: collision with root package name */
    private final Paint f13244a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int[] g;
    private RectF h;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f13245a = 1;
        private int b = 12;
        private int c = Color.parseColor("#4d000000");
        private int d = 18;
        private int e = 0;
        private int f = 0;
        private int[] g = {0};

        public a a(int i) {
            this.f13245a = i;
            return this;
        }

        public a b(int i) {
            this.b = i;
            return this;
        }

        public a c(int i) {
            this.c = i;
            return this;
        }

        public a d(int i) {
            this.d = i;
            return this;
        }

        public a e(int i) {
            this.e = i;
            return this;
        }

        public a f(int i) {
            this.f = i;
            return this;
        }

        public a g(int i) {
            this.g[0] = i;
            return this;
        }

        public a a(int[] iArr) {
            this.g = iArr;
            return this;
        }

        public ab a() {
            return new ab(this.f13245a, this.g, this.b, this.c, this.d, this.e, this.f);
        }
    }

    private ab(int i2, int[] iArr, int i3, int i4, int i5, int i6, int i7) {
        this.c = i2;
        this.g = iArr;
        this.d = i3;
        this.b = i5;
        this.e = i6;
        this.f = i7;
        Paint paint = new Paint();
        this.f13244a = paint;
        paint.setColor(0);
        paint.setAntiAlias(true);
        paint.setShadowLayer(i5, i6, i7, i4);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    }

    public static void a(View view, int i2, int i3, int i4, int i5, int i6, int i7) {
        ab a2 = new a().g(i2).b(i3).c(i4).d(i5).e(i6).f(i7).a();
        view.setLayerType(1, null);
        view.setBackground(a2);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        int[] iArr = this.g;
        if (iArr != null) {
            if (iArr.length == 1) {
                paint.setColor(iArr[0]);
            } else {
                RectF rectF = this.h;
                float f = rectF.left;
                float height = rectF.height() / 2.0f;
                RectF rectF2 = this.h;
                paint.setShader(new LinearGradient(f, height, rectF2.right, rectF2.height() / 2.0f, this.g, (float[]) null, Shader.TileMode.CLAMP));
            }
        }
        paint.setAntiAlias(true);
        if (this.c != 1) {
            canvas.drawCircle(this.h.centerX(), this.h.centerY(), Math.min(this.h.width(), this.h.height()) / 2.0f, this.f13244a);
            canvas.drawCircle(this.h.centerX(), this.h.centerY(), Math.min(this.h.width(), this.h.height()) / 2.0f, paint);
            return;
        }
        RectF rectF3 = this.h;
        int i2 = this.d;
        canvas.drawRoundRect(rectF3, i2, i2, this.f13244a);
        RectF rectF4 = this.h;
        int i3 = this.d;
        canvas.drawRoundRect(rectF4, i3, i3, paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f13244a.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i2, int i3, int i4, int i5) {
        super.setBounds(i2, i3, i4, i5);
        int i6 = this.b;
        int i7 = this.e;
        int i8 = this.f;
        this.h = new RectF((i2 + i6) - i7, (i3 + i6) - i8, (i4 - i6) - i7, (i5 - i6) - i8);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f13244a.setColorFilter(colorFilter);
    }
}

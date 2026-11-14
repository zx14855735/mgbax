package com.bytedance.sdk.openadsdk.core.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.pz;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class pl extends Drawable {
    private int c;
    private int d;
    private int f;
    private int hf;
    private LinearGradient kd;
    private Paint p;
    private RectF tf;
    private float[] u;
    private int[] w;
    private int xj;
    private int y;

    public static class xj {
        private int d;
        private int f;
        private LinearGradient kd;
        private float[] u;
        private int[] w;
        private int xj = jk.tf(pz.getContext(), "tt_ssxinmian8");
        private int hf = jk.tf(pz.getContext(), "tt_ssxinxian3");
        private int y = 10;
        private int c = 16;

        public xj() {
            this.f = 0;
            this.d = 0;
            this.f = 0;
            this.d = 0;
        }

        public xj hf(int i) {
            this.hf = i;
            return this;
        }

        public xj kd(int i) {
            this.d = i;
            return this;
        }

        public xj u(int i) {
            this.f = i;
            return this;
        }

        public xj w(int i) {
            this.y = i;
            return this;
        }

        public xj xj(int i) {
            this.xj = i;
            return this;
        }

        public xj xj(int[] iArr) {
            this.w = iArr;
            return this;
        }

        public pl xj() {
            return new pl(this.xj, this.w, this.u, this.hf, this.kd, this.y, this.c, this.f, this.d);
        }
    }

    public pl(int i, int[] iArr, float[] fArr, int i2, LinearGradient linearGradient, int i3, int i4, int i5, int i6) {
        this.xj = i;
        this.w = iArr;
        this.u = fArr;
        this.hf = i2;
        this.kd = linearGradient;
        this.y = i3;
        this.c = i4;
        this.f = i5;
        this.d = i6;
    }

    private void xj() {
        int[] iArr;
        Paint paint = new Paint();
        this.p = paint;
        paint.setAntiAlias(true);
        this.p.setShadowLayer(this.c, this.f, this.d, this.hf);
        if (this.tf == null || (iArr = this.w) == null || iArr.length <= 1) {
            this.p.setColor(this.xj);
            return;
        }
        float[] fArr = this.u;
        boolean z = fArr != null && fArr.length > 0 && fArr.length == iArr.length;
        Paint paint2 = this.p;
        LinearGradient linearGradient = this.kd;
        if (linearGradient == null) {
            RectF rectF = this.tf;
            linearGradient = new LinearGradient(rectF.left, 0.0f, rectF.right, 0.0f, this.w, z ? this.u : null, Shader.TileMode.CLAMP);
        }
        paint2.setShader(linearGradient);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.tf == null) {
            Rect bounds = getBounds();
            int i = bounds.left;
            int i2 = this.c;
            int i3 = this.f;
            int i4 = bounds.top + i2;
            int i5 = this.d;
            this.tf = new RectF((i + i2) - i3, i4 - i5, (bounds.right - i2) - i3, (bounds.bottom - i2) - i5);
        }
        if (this.p == null) {
            xj();
        }
        RectF rectF = this.tf;
        int i6 = this.y;
        canvas.drawRoundRect(rectF, i6, i6, this.p);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Paint paint = this.p;
        if (paint != null) {
            paint.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Paint paint = this.p;
        if (paint != null) {
            paint.setColorFilter(colorFilter);
        }
    }

    public static void xj(View view, xj xjVar) {
        if (view == null || xjVar == null) {
            return;
        }
        view.setLayerType(1, null);
        view.setBackground(xjVar.xj());
    }
}

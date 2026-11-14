package com.bytedance.adsdk.ugeno.widget.image;

import ADYaiT.CtFAbx;
import I3HV03.ADYaiT;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.pl;
import com.sigmob.sdk.base.blurkit.d;
import java.util.HashSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends Drawable {
    private boolean am;
    private final int c;
    private final Paint d;
    private boolean e;
    private final RectF f;
    private Shader.TileMode g;
    private ImageView.ScaleType jk;
    private final Paint kd;
    private final RectF p;

    /* renamed from: pl, reason: collision with root package name */
    private Shader.TileMode f10088pl;
    private float qt;
    private final Matrix tf;
    private final Bitmap u;
    private ColorStateList v;
    private final RectF w;
    private final int y;
    private float yo;
    private final boolean[] zg;
    private final RectF xj = new RectF();
    private final RectF hf = new RectF();

    /* renamed from: com.bytedance.adsdk.ugeno.widget.image.xj$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] xj;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            xj = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                xj[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                xj[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                xj[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                xj[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                xj[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                xj[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public xj(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.w = rectF;
        this.f = new RectF();
        this.tf = new Matrix();
        this.p = new RectF();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f10088pl = tileMode;
        this.g = tileMode;
        this.am = true;
        this.qt = 0.0f;
        this.zg = new boolean[]{true, true, true, true};
        this.e = false;
        this.yo = 0.0f;
        this.v = ColorStateList.valueOf(d.f13043a);
        this.jk = ImageView.ScaleType.FIT_CENTER;
        this.u = bitmap;
        int width = bitmap.getWidth();
        this.y = width;
        int height = bitmap.getHeight();
        this.c = height;
        rectF.set(0.0f, 0.0f, width, height);
        Paint paint = new Paint();
        this.kd = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.d = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.v.getColorForState(getState(), d.f13043a));
        paint2.setStrokeWidth(this.yo);
    }

    public static Bitmap hf(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Throwable th) {
            pl.xj(th);
            pl.hf("RoundedDrawable", "Failed to create bitmap from drawable!");
            return null;
        }
    }

    public static xj xj(Bitmap bitmap) {
        if (bitmap != null) {
            return new xj(bitmap);
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.am) {
            BitmapShader bitmapShader = new BitmapShader(this.u, this.f10088pl, this.g);
            Shader.TileMode tileMode = this.f10088pl;
            Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
            if (tileMode == tileMode2 && this.g == tileMode2) {
                bitmapShader.setLocalMatrix(this.tf);
            }
            this.kd.setShader(bitmapShader);
            this.am = false;
        }
        if (this.e) {
            if (this.yo <= 0.0f) {
                canvas.drawOval(this.hf, this.kd);
                return;
            } else {
                canvas.drawOval(this.hf, this.kd);
                canvas.drawOval(this.f, this.d);
                return;
            }
        }
        if (!xj(this.zg)) {
            canvas.drawRect(this.hf, this.kd);
            if (this.yo > 0.0f) {
                canvas.drawRect(this.f, this.d);
                return;
            }
            return;
        }
        float f = this.qt;
        if (this.yo <= 0.0f) {
            canvas.drawRoundRect(this.hf, f, f, this.kd);
            xj(canvas);
        } else {
            canvas.drawRoundRect(this.hf, f, f, this.kd);
            canvas.drawRoundRect(this.f, f, f, this.d);
            xj(canvas);
            hf(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.kd.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.kd.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.y;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.v.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.xj.set(rect);
        xj();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState = this.v.getColorForState(iArr, 0);
        if (this.d.getColor() == colorForState) {
            return super.onStateChange(iArr);
        }
        this.d.setColor(colorForState);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.kd.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.kd.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.kd.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.kd.setFilterBitmap(z);
        invalidateSelf();
    }

    public static Drawable xj(Drawable drawable) {
        if (drawable != null) {
            if (drawable instanceof xj) {
                return drawable;
            }
            if (Build.VERSION.SDK_INT >= 28 && ADYaiT.BI9f7h(drawable)) {
                return drawable;
            }
            if (drawable instanceof LayerDrawable) {
                Drawable.ConstantState constantState = drawable.mutate().getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i = 0; i < numberOfLayers; i++) {
                    layerDrawable.setDrawableByLayerId(layerDrawable.getId(i), xj(layerDrawable.getDrawable(i)));
                }
                return layerDrawable;
            }
        }
        Bitmap hf = hf(drawable);
        return hf != null ? new xj(hf) : drawable;
    }

    private void hf(Canvas canvas) {
        float f;
        float f2;
        if (hf(this.zg) || this.qt == 0.0f) {
            return;
        }
        RectF rectF = this.hf;
        float f3 = rectF.left;
        float f4 = rectF.top;
        float width = rectF.width() + f3;
        float height = this.hf.height() + f4;
        float f5 = this.qt;
        float f6 = this.yo / 2.0f;
        if (this.zg[0]) {
            f = f4;
        } else {
            f = f4;
            canvas.drawLine(f3 - f6, f4, f3 + f5, f, this.d);
            canvas.drawLine(f3, f - f6, f3, f + f5, this.d);
        }
        if (!this.zg[1]) {
            float f7 = f;
            canvas.drawLine((width - f5) - f6, f7, width, f, this.d);
            canvas.drawLine(width, f7 - f6, width, f7 + f5, this.d);
            width = width;
        }
        if (this.zg[2]) {
            f2 = height;
        } else {
            canvas.drawLine((width - f5) - f6, height, width + f6, height, this.d);
            float f8 = width;
            canvas.drawLine(f8, height - f5, width, height, this.d);
            f2 = height;
        }
        if (this.zg[3]) {
            return;
        }
        canvas.drawLine(f3 - f6, f2, f3 + f5, f2, this.d);
        canvas.drawLine(f3, f2 - f5, f3, f2, this.d);
    }

    private void xj() {
        float width;
        float height;
        int i = AnonymousClass1.xj[this.jk.ordinal()];
        if (i == 1) {
            this.f.set(this.xj);
            RectF rectF = this.f;
            float f = this.yo;
            rectF.inset(f / 2.0f, f / 2.0f);
            this.tf.reset();
            this.tf.setTranslate((int) CtFAbx.A4TApA(this.f.width(), this.y, 0.5f, 0.5f), (int) CtFAbx.A4TApA(this.f.height(), this.c, 0.5f, 0.5f));
        } else if (i == 2) {
            this.f.set(this.xj);
            RectF rectF2 = this.f;
            float f2 = this.yo;
            rectF2.inset(f2 / 2.0f, f2 / 2.0f);
            this.tf.reset();
            float f3 = 0.0f;
            if (this.f.height() * this.y > this.f.width() * this.c) {
                width = this.f.height() / this.c;
                f3 = (this.f.width() - (this.y * width)) * 0.5f;
                height = 0.0f;
            } else {
                width = this.f.width() / this.y;
                height = (this.f.height() - (this.c * width)) * 0.5f;
            }
            this.tf.setScale(width, width);
            Matrix matrix = this.tf;
            float f4 = this.yo;
            matrix.postTranslate((f4 / 2.0f) + ((int) (f3 + 0.5f)), (f4 / 2.0f) + ((int) (height + 0.5f)));
        } else if (i == 3) {
            this.tf.reset();
            float min = (((float) this.y) > this.xj.width() || ((float) this.c) > this.xj.height()) ? Math.min(this.xj.width() / this.y, this.xj.height() / this.c) : 1.0f;
            float width2 = (int) (((this.xj.width() - (this.y * min)) * 0.5f) + 0.5f);
            float height2 = (int) (((this.xj.height() - (this.c * min)) * 0.5f) + 0.5f);
            this.tf.setScale(min, min);
            this.tf.postTranslate(width2, height2);
            this.f.set(this.w);
            this.tf.mapRect(this.f);
            RectF rectF3 = this.f;
            float f5 = this.yo;
            rectF3.inset(f5 / 2.0f, f5 / 2.0f);
            this.tf.setRectToRect(this.w, this.f, Matrix.ScaleToFit.FILL);
        } else if (i == 5) {
            this.f.set(this.w);
            this.tf.setRectToRect(this.w, this.xj, Matrix.ScaleToFit.END);
            this.tf.mapRect(this.f);
            RectF rectF4 = this.f;
            float f6 = this.yo;
            rectF4.inset(f6 / 2.0f, f6 / 2.0f);
            this.tf.setRectToRect(this.w, this.f, Matrix.ScaleToFit.FILL);
        } else if (i == 6) {
            this.f.set(this.w);
            this.tf.setRectToRect(this.w, this.xj, Matrix.ScaleToFit.START);
            this.tf.mapRect(this.f);
            RectF rectF5 = this.f;
            float f7 = this.yo;
            rectF5.inset(f7 / 2.0f, f7 / 2.0f);
            this.tf.setRectToRect(this.w, this.f, Matrix.ScaleToFit.FILL);
        } else if (i != 7) {
            this.f.set(this.w);
            this.tf.setRectToRect(this.w, this.xj, Matrix.ScaleToFit.CENTER);
            this.tf.mapRect(this.f);
            RectF rectF6 = this.f;
            float f8 = this.yo;
            rectF6.inset(f8 / 2.0f, f8 / 2.0f);
            this.tf.setRectToRect(this.w, this.f, Matrix.ScaleToFit.FILL);
        } else {
            this.f.set(this.xj);
            RectF rectF7 = this.f;
            float f9 = this.yo;
            rectF7.inset(f9 / 2.0f, f9 / 2.0f);
            this.tf.reset();
            this.tf.setRectToRect(this.w, this.f, Matrix.ScaleToFit.FILL);
        }
        this.hf.set(this.f);
        this.am = true;
    }

    public xj hf(Shader.TileMode tileMode) {
        if (this.g != tileMode) {
            this.g = tileMode;
            this.am = true;
            invalidateSelf();
        }
        return this;
    }

    private static boolean hf(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return false;
            }
        }
        return true;
    }

    private void xj(Canvas canvas) {
        if (hf(this.zg) || this.qt == 0.0f) {
            return;
        }
        RectF rectF = this.hf;
        float f = rectF.left;
        float f2 = rectF.top;
        float width = rectF.width() + f;
        float height = this.hf.height() + f2;
        float f3 = this.qt;
        if (!this.zg[0]) {
            this.p.set(f, f2, f + f3, f2 + f3);
            canvas.drawRect(this.p, this.kd);
        }
        if (!this.zg[1]) {
            this.p.set(width - f3, f2, width, f3);
            canvas.drawRect(this.p, this.kd);
        }
        if (!this.zg[2]) {
            this.p.set(width - f3, height - f3, width, height);
            canvas.drawRect(this.p, this.kd);
        }
        if (this.zg[3]) {
            return;
        }
        this.p.set(f, height - f3, f3 + f, height);
        canvas.drawRect(this.p, this.kd);
    }

    public xj xj(float f, float f2, float f3, float f4) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f));
        hashSet.add(Float.valueOf(f2));
        hashSet.add(Float.valueOf(f3));
        hashSet.add(Float.valueOf(f4));
        hashSet.remove(Float.valueOf(0.0f));
        if (hashSet.size() <= 1) {
            if (!hashSet.isEmpty()) {
                float floatValue = ((Float) hashSet.iterator().next()).floatValue();
                if (!Float.isInfinite(floatValue) && !Float.isNaN(floatValue) && floatValue >= 0.0f) {
                    this.qt = floatValue;
                } else {
                    throw new IllegalArgumentException("Invalid radius value: ".concat(String.valueOf(floatValue)));
                }
            } else {
                this.qt = 0.0f;
            }
            boolean[] zArr = this.zg;
            zArr[0] = f > 0.0f;
            zArr[1] = f2 > 0.0f;
            zArr[2] = f3 > 0.0f;
            zArr[3] = f4 > 0.0f;
            return this;
        }
        throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
    }

    public xj xj(float f) {
        this.yo = f;
        this.d.setStrokeWidth(f);
        return this;
    }

    public xj xj(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.v = colorStateList;
        this.d.setColor(colorStateList.getColorForState(getState(), d.f13043a));
        return this;
    }

    public xj xj(boolean z) {
        this.e = z;
        return this;
    }

    public xj xj(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.jk != scaleType) {
            this.jk = scaleType;
            xj();
        }
        return this;
    }

    public xj xj(Shader.TileMode tileMode) {
        if (this.f10088pl != tileMode) {
            this.f10088pl = tileMode;
            this.am = true;
            invalidateSelf();
        }
        return this;
    }

    private static boolean xj(boolean[] zArr) {
        for (boolean z : zArr) {
            if (z) {
                return true;
            }
        }
        return false;
    }
}

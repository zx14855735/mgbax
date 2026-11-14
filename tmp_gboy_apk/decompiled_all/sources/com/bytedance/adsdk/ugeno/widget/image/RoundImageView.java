package com.bytedance.adsdk.ugeno.widget.image;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.w;
import com.bytedance.adsdk.ugeno.w.kd;
import com.bytedance.adsdk.ugeno.xj.c;
import com.bytedance.adsdk.ugeno.xj.f;
import com.bytedance.sdk.component.utils.pl;
import com.sigmob.sdk.base.blurkit.d;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class RoundImageView extends ImageView implements kd, c {
    static final /* synthetic */ boolean hf = true;
    private boolean am;
    private ColorStateList c;
    private ColorFilter d;
    private ImageView.ScaleType e;
    private float f;
    private boolean g;
    private w jk;
    private final float[] kd;
    private Drawable p;

    /* renamed from: pl, reason: collision with root package name */
    private boolean f10087pl;
    private f pz;
    private int qt;
    private boolean tf;
    private Shader.TileMode v;
    private float w;
    private Drawable y;
    private Shader.TileMode yo;
    private int zg;
    public static final Shader.TileMode xj = Shader.TileMode.CLAMP;
    private static final ImageView.ScaleType[] u = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: com.bytedance.adsdk.ugeno.widget.image.RoundImageView$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] xj;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            xj = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                xj[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                xj[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                xj[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                xj[ImageView.ScaleType.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                xj[ImageView.ScaleType.CENTER_CROP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                xj[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    static {
        NZfD();
    }

    public RoundImageView(Context context) {
        super(context);
        this.kd = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.c = ColorStateList.valueOf(d.f13043a);
        this.f = 0.0f;
        this.d = null;
        this.tf = false;
        this.f10087pl = false;
        this.g = false;
        this.am = false;
        Shader.TileMode tileMode = xj;
        this.yo = tileMode;
        this.v = tileMode;
        this.pz = new f(this);
    }

    private static /* synthetic */ void NZfD() {
        char[] charArray = "«§¥æ¯©¥\u00adæª§±æ» \u00ad¤¤æ\u0082¦¡\u008aº¡¬¯\u00ad".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 200);
        }
        String str = new String(charArray);
        char[] charArray2 = "«¤¡¦¡¼".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 200);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private Drawable hf() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.zg;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception e) {
                pl.hf("RoundedImageView", "Unable to find resource: " + this.zg, e);
                this.zg = 0;
            }
        }
        return xj.xj(drawable);
    }

    private void u() {
        Drawable drawable = this.p;
        if (drawable == null || !this.tf) {
            return;
        }
        Drawable mutate = drawable.mutate();
        this.p = mutate;
        if (this.f10087pl) {
            mutate.setColorFilter(this.d);
        }
    }

    private void w() {
        xj(this.p, this.e);
    }

    private Drawable xj() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.qt;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception e) {
                pl.hf("RoundedImageView", "Unable to find resource: " + this.qt, e);
                this.qt = 0;
            }
        }
        return xj.xj(drawable);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public int getBorderColor() {
        return this.c.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.c;
    }

    public float getBorderRadius() {
        return this.pz.xj();
    }

    public float getBorderWidth() {
        return this.f;
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float f = 0.0f;
        for (float f2 : this.kd) {
            f = Math.max(f2, f);
        }
        return f;
    }

    @Override // com.bytedance.adsdk.ugeno.w.kd, com.bytedance.adsdk.ugeno.xj.c
    public float getRipple() {
        return this.w;
    }

    @Override // com.bytedance.adsdk.ugeno.xj.c
    public float getRubIn() {
        return this.pz.getRubIn();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.e;
    }

    @Override // com.bytedance.adsdk.ugeno.xj.c
    public float getShine() {
        return this.pz.getShine();
    }

    @Override // com.bytedance.adsdk.ugeno.xj.c
    public float getStretch() {
        return this.pz.getStretch();
    }

    public Shader.TileMode getTileModeX() {
        return this.yo;
    }

    public Shader.TileMode getTileModeY() {
        return this.v;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        w wVar = this.jk;
        if (wVar != null) {
            wVar.kd();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w wVar = this.jk;
        if (wVar != null) {
            wVar.y();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        w wVar = this.jk;
        if (wVar != null) {
            wVar.xj(canvas, this);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        w wVar = this.jk;
        if (wVar != null) {
            wVar.xj(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        w wVar = this.jk;
        if (wVar == null) {
            super.onMeasure(i, i2);
        } else {
            int[] xj2 = wVar.xj(i, i2);
            super.onMeasure(xj2[0], xj2[1]);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        w wVar = this.jk;
        if (wVar != null) {
            wVar.hf(i, i2, i3, i3);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        w wVar = this.jk;
        if (wVar != null) {
            wVar.xj(z);
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        ColorDrawable colorDrawable = new ColorDrawable(i);
        this.y = colorDrawable;
        setBackgroundDrawable(colorDrawable);
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.y = drawable;
        xj(true);
        super.setBackgroundDrawable(this.y);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        if (this.zg != i) {
            this.zg = i;
            Drawable hf2 = hf();
            this.y = hf2;
            setBackgroundDrawable(hf2);
        }
    }

    public void setBorderColor(int i) {
        setBorderColor(ColorStateList.valueOf(i));
    }

    public void setBorderRadius(float f) {
        f fVar = this.pz;
        if (fVar != null) {
            fVar.xj(f);
        }
    }

    public void setBorderWidth(int i) {
        setBorderWidth(getResources().getDimension(i));
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.d != colorFilter) {
            this.d = colorFilter;
            this.f10087pl = true;
            this.tf = true;
            u();
            invalidate();
        }
    }

    public void setCornerRadius(float f) {
        xj(f, f, f, f);
    }

    public void setCornerRadiusDimen(int i) {
        float dimension = getResources().getDimension(i);
        xj(dimension, dimension, dimension, dimension);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.qt = 0;
        this.p = xj.xj(bitmap);
        w();
        super.setImageDrawable(this.p);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.qt = 0;
        this.p = xj.xj(drawable);
        w();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        if (this.qt != i) {
            this.qt = i;
            this.p = xj();
            w();
            super.setImageDrawable(this.p);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    public void setOval(boolean z) {
        this.g = z;
        w();
        xj(false);
        invalidate();
    }

    public void setRipple(float f) {
        this.w = f;
        f fVar = this.pz;
        if (fVar != null) {
            fVar.hf(f);
        }
        postInvalidate();
    }

    public void setRubIn(float f) {
        f fVar = this.pz;
        if (fVar != null) {
            fVar.kd(f);
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!hf && scaleType == null) {
            throw new AssertionError();
        }
        if (this.e != scaleType) {
            this.e = scaleType;
            int i = AnonymousClass1.xj[scaleType.ordinal()];
            if (i == 1 || i == 2 || i == 3 || i == 4) {
                super.setScaleType(scaleType);
            } else {
                super.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            w();
            xj(false);
            invalidate();
        }
    }

    public void setShine(float f) {
        f fVar = this.pz;
        if (fVar != null) {
            fVar.w(f);
        }
    }

    public void setStretch(float f) {
        f fVar = this.pz;
        if (fVar != null) {
            fVar.u(f);
        }
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.yo == tileMode) {
            return;
        }
        this.yo = tileMode;
        w();
        xj(false);
        invalidate();
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.v == tileMode) {
            return;
        }
        this.v = tileMode;
        w();
        xj(false);
        invalidate();
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.c.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(d.f13043a);
        }
        this.c = colorStateList;
        w();
        xj(false);
        if (this.f > 0.0f) {
            invalidate();
        }
    }

    public void setBorderWidth(float f) {
        if (this.f == f) {
            return;
        }
        this.f = f;
        w();
        xj(false);
        invalidate();
    }

    private void xj(boolean z) {
        if (this.am) {
            if (z) {
                this.y = xj.xj(this.y);
            }
            xj(this.y, ImageView.ScaleType.FIT_XY);
        }
    }

    private void xj(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof xj) {
            xj xjVar = (xj) drawable;
            xjVar.xj(scaleType).xj(this.f).xj(this.c).xj(this.g).xj(this.yo).hf(this.v);
            float[] fArr = this.kd;
            if (fArr != null) {
                xjVar.xj(fArr[0], fArr[1], fArr[2], fArr[3]);
            }
            u();
            return;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                xj(layerDrawable.getDrawable(i), scaleType);
            }
        }
    }

    public void xj(float f, float f2, float f3, float f4) {
        float[] fArr = this.kd;
        if (fArr[0] == f && fArr[1] == f2 && fArr[2] == f4 && fArr[3] == f3) {
            return;
        }
        fArr[0] = f;
        fArr[1] = f2;
        fArr[3] = f3;
        fArr[2] = f4;
        w();
        xj(false);
        invalidate();
    }

    public void xj(w wVar) {
        this.jk = wVar;
    }
}

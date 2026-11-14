package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.view.View;
import com.bytedance.sdk.component.adexpress.u.hf;
import com.bytedance.sdk.component.y.am;
import com.bytedance.sdk.component.y.dk;
import com.bytedance.sdk.component.y.tf;
import com.bytedance.sdk.component.y.zg;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ImageFlipSlide extends View {
    private final Rect c;
    private final boolean f;
    private float hf;
    private Path kd;
    private List<String> u;
    private Bitmap w;
    Paint xj;
    private final Rect y;

    public ImageFlipSlide(Context context, boolean z) {
        super(context);
        this.hf = 0.1f;
        this.y = new Rect();
        this.c = new Rect();
        this.f = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBlurPx() {
        if (this.u == null) {
            return 0;
        }
        for (int i = 0; i < this.u.size(); i++) {
            if (this.u.get(i).contains("blur")) {
                return Integer.parseInt(this.u.get(i).split("\\(")[1].split("px")[0]);
            }
        }
        return 0;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.w == null) {
            return;
        }
        if (!this.f) {
            canvas.clipPath(this.kd);
            canvas.drawBitmap(this.w, 0.0f, 0.0f, this.xj);
            return;
        }
        this.y.left = (int) ((1.0f - this.hf) * r0.getWidth());
        this.y.right = this.w.getWidth();
        Rect rect = this.y;
        rect.top = 0;
        rect.bottom = this.w.getHeight();
        this.c.left = (int) ((1.0f - this.hf) * getWidth());
        this.c.right = getWidth();
        Rect rect2 = this.c;
        rect2.top = 0;
        rect2.bottom = getHeight();
        canvas.drawBitmap(this.w, this.y, this.c, this.xj);
    }

    public void xj(String str, String str2, List<String> list) {
        final am key = com.bytedance.sdk.component.adexpress.xj.xj.xj.xj().kd().from(str).key(str2);
        this.u = list;
        key.config(Bitmap.Config.ARGB_4444).type(2);
        if (getBlurPx() != 0) {
            key.converter(new tf() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlide.1
                @Override // com.bytedance.sdk.component.y.tf
                public Bitmap coverterTo(Bitmap bitmap) {
                    try {
                        return hf.xj(ImageFlipSlide.this.getContext(), bitmap, ImageFlipSlide.this.getBlurPx());
                    } catch (Exception unused) {
                        return bitmap;
                    }
                }
            });
        }
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlide.2
            @Override // java.lang.Runnable
            public void run() {
                key.to(new dk<Bitmap>() { // from class: com.bytedance.sdk.component.adexpress.widget.ImageFlipSlide.2.1
                    @Override // com.bytedance.sdk.component.y.dk
                    public void onFailed(int i, String str3, Throwable th) {
                    }

                    @Override // com.bytedance.sdk.component.y.dk
                    public void onSuccess(zg<Bitmap> zgVar) {
                        try {
                            ImageFlipSlide imageFlipSlide = ImageFlipSlide.this;
                            imageFlipSlide.w = imageFlipSlide.xj(zgVar.getResult(), ImageFlipSlide.this.getWidth(), ImageFlipSlide.this.getHeight());
                        } catch (Exception unused) {
                        }
                        ImageFlipSlide.this.invalidate();
                    }
                });
            }
        });
        Paint paint = new Paint();
        this.xj = paint;
        paint.setAntiAlias(true);
        this.xj.setDither(true);
        if (this.f) {
            this.xj.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        }
        List<String> list2 = this.u;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        for (int i = 0; i < this.u.size(); i++) {
            xj(colorMatrix, this.u.get(i));
        }
        this.xj.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }

    private void xj(ColorMatrix colorMatrix, String str) {
        try {
            ColorMatrix colorMatrix2 = new ColorMatrix();
            if (str.startsWith("hue-rotate")) {
                colorMatrix2.setRotate(0, Integer.parseInt(str.split("\\(")[1].split("deg")[0]));
            } else {
                if (!str.startsWith("grayscale") && !str.startsWith("contrast")) {
                    if (str.startsWith("invert")) {
                        float parseInt = (Integer.parseInt(str.split("\\(")[1].split("%")[0]) / 100.0f) * 255.0f;
                        colorMatrix2.set(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, parseInt, 0.0f, -1.0f, 0.0f, 0.0f, parseInt, 0.0f, 0.0f, -1.0f, 0.0f, parseInt, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
                    } else if (str.startsWith("sepia")) {
                        float parseInt2 = Integer.parseInt(str.split("\\(")[1].split("%")[0]) / 100.0f;
                        colorMatrix2.setScale(parseInt2, parseInt2, 1.0f, 1.0f);
                    } else if (str.startsWith("brightness")) {
                        float parseInt3 = Integer.parseInt(str.split("\\(")[1].split("%")[0]) / 100.0f;
                        colorMatrix2.setScale(parseInt3, parseInt3, parseInt3, 1.0f);
                    }
                }
                colorMatrix2.setSaturation(Integer.parseInt(str.split("\\(")[1].split("%")[0]) / 100.0f);
            }
            colorMatrix.postConcat(colorMatrix2);
        } catch (Exception unused) {
        }
    }

    public void xj(float f) {
        this.hf = f;
        invalidate();
    }

    public void xj(Path path) {
        this.kd = path;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap xj(Bitmap bitmap, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = i;
        float f2 = (width * 1.0f) / f;
        float f3 = i2;
        float f4 = (height * 1.0f) / f3;
        Matrix matrix = new Matrix();
        if (f4 > f2) {
            int i7 = (int) (f3 * f2);
            float f5 = 1.0f / f2;
            matrix.setScale(f5, f5);
            i5 = i7;
            i3 = width;
            i6 = (height / 2) - (i7 / 2);
            i4 = 0;
        } else {
            int i8 = (int) (f * f4);
            float f6 = 1.0f / f4;
            matrix.setScale(f6, f6);
            i3 = i8;
            i4 = (width / 2) - (i8 / 2);
            i5 = height;
            i6 = 0;
        }
        return Bitmap.createBitmap(bitmap, i4, i6, i3, i5, matrix, false);
    }
}

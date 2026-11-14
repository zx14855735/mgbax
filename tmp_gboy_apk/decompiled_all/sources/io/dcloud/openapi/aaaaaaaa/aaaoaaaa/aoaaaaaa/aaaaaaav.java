package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aoaaaaaa.aaaaaaaa;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaav extends View {
    int aaaaaaa0;
    Bitmap aaaaaaaa;
    aaaaaaaa.aaaaaaau aaaaaaac;
    RectF aaaaaaae;
    Rect aaaaaaan;
    int aaaaaaao;
    Paint aaaaaaau;
    Bitmap aaaaaaav;
    RectF aaaaaaeo;

    public aaaaaaav(Context context, Bitmap bitmap, aaaaaaaa.aaaaaaau aaaaaaauVar) {
        super(context);
        this.aaaaaaaa = null;
        this.aaaaaaa0 = 0;
        this.aaaaaaao = 0;
        this.aaaaaaac = null;
        this.aaaaaaau = new Paint();
        this.aaaaaaan = null;
        this.aaaaaaae = null;
        this.aaaaaaav = null;
        this.aaaaaaeo = null;
        this.aaaaaaaa = bitmap;
        this.aaaaaaac = aaaaaaauVar;
    }

    private void aaaaaaaa(Canvas canvas) {
        float height = this.aaaaaaaa.getHeight();
        float width = this.aaaaaaaa.getWidth();
        float height2 = getHeight() > 0 ? getHeight() : canvas.getHeight();
        float width2 = getWidth() > 0 ? getWidth() : canvas.getWidth();
        float f = height / width;
        float f2 = (height2 / width2) - f;
        if (f2 <= 0.15d) {
            this.aaaaaaae = new RectF(0.0f, 0.0f, width2, height2);
            return;
        }
        float f3 = (height2 - (f * width2)) / 2.0f;
        this.aaaaaaae = new RectF(0.0f, f3, width2, height2 - f3);
        if (this.aaaaaaeo == null) {
            int i = (int) width;
            int i2 = (int) height;
            this.aaaaaaav = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(this.aaaaaaav);
            canvas2.drawBitmap(this.aaaaaaaa, new Rect(0, 0, i, i2), new Rect(0, 0, i, i2), new Paint());
            canvas2.drawColor(aaaaaaa0(this.aaaaaaaa) >= 128 ? 1711276032 : 1728053247);
            float f4 = (f2 * width) / 2.0f;
            this.aaaaaaeo = new RectF(-f4, 0.0f, width2 + f4, height2);
            aaaaaaaa(this.aaaaaaav);
        }
    }

    public int aaaaaaa0(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < width; i3++) {
            for (int i4 = 0; i4 < height; i4++) {
                i2++;
                int pixel = bitmap.getPixel(i3, i4);
                i = (int) ((((pixel | (-256)) & 255) * 0.114d) + (((((-65281) | pixel) >> 8) & 255) * 0.587d) + (((((-16711681) | pixel) >> 16) & 255) * 0.299d) + i);
            }
        }
        return i / i2;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.aaaaaaav = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap = this.aaaaaaaa;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        aaaaaaaa(canvas);
        Bitmap bitmap2 = this.aaaaaaav;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, this.aaaaaaan, this.aaaaaaeo, this.aaaaaaau);
        }
        canvas.drawBitmap(this.aaaaaaaa, this.aaaaaaan, this.aaaaaaae, this.aaaaaaau);
    }

    private void aaaaaaaa(Bitmap bitmap) {
        RenderScript create = RenderScript.create(getContext());
        Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, createFromBitmap.getElement());
        create2.setInput(createFromBitmap);
        create2.setRadius(20.0f);
        create2.forEach(createFromBitmap);
        createFromBitmap.copyTo(bitmap);
        create.destroy();
    }
}

package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaoa;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaaa extends Drawable {
    Context aaaaaaan;
    Bitmap aaaaaaau;
    Paint aaaaaaaa = new Paint();
    RectF aaaaaaa0 = null;
    Bitmap aaaaaaao = null;
    RectF aaaaaaac = null;

    public aaaaaaaa(Bitmap bitmap, Context context) {
        this.aaaaaaau = bitmap;
        this.aaaaaaan = context;
    }

    private void aaaaaaaa() {
        Rect bounds = getBounds();
        float height = this.aaaaaaau.getHeight();
        float width = this.aaaaaaau.getWidth();
        float height2 = bounds.height();
        float width2 = bounds.width();
        float f = height / width;
        float f2 = (height2 / width2) - f;
        if (f2 <= 0.15d) {
            this.aaaaaaa0 = new RectF(0.0f, 0.0f, width2, height2);
            return;
        }
        float f3 = (height2 - (f * width2)) / 2.0f;
        this.aaaaaaa0 = new RectF(0.0f, f3, width2, height2 - f3);
        if (this.aaaaaaac == null) {
            this.aaaaaaao = this.aaaaaaau.copy(Bitmap.Config.ARGB_8888, true);
            Canvas canvas = new Canvas(this.aaaaaaao);
            canvas.scale(0.25f, 0.25f, width / 2.0f, height / 2.0f);
            canvas.drawColor(1711276032);
            float f4 = (f2 * width) / 2.0f;
            this.aaaaaaac = new RectF(-f4, 0.0f, width2 + f4, height2);
            aaaaaaaa(this.aaaaaaao);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.aaaaaaau;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        if (this.aaaaaaao == null) {
            aaaaaaaa();
        }
        Bitmap bitmap2 = this.aaaaaaao;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, (Rect) null, this.aaaaaaac, this.aaaaaaaa);
        }
        canvas.drawBitmap(this.aaaaaaau, (Rect) null, this.aaaaaaa0, this.aaaaaaaa);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    private void aaaaaaaa(Bitmap bitmap) {
        RenderScript create = RenderScript.create(this.aaaaaaan);
        Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, createFromBitmap.getElement());
        create2.setInput(createFromBitmap);
        create2.setRadius(20.0f);
        create2.forEach(createFromBitmap);
        createFromBitmap.copyTo(bitmap);
        create.destroy();
    }
}

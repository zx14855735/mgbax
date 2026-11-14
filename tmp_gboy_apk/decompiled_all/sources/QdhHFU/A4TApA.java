package QdhHFU;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class A4TApA extends Drawable {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Paint f7485A2egSU;

    public static class A2egSU {
    }

    public A4TApA() {
        Paint paint = new Paint(1);
        this.f7485A2egSU = paint;
        new A2egSU();
        Bitmap createBitmap = Bitmap.createBitmap(50, 50, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Rect rect = new Rect(0, 0, 25, 25);
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(-1);
        rect.offset(0, 0);
        canvas.drawRect(rect, paint2);
        rect.offset(25, 25);
        canvas.drawRect(rect, paint2);
        paint2.setColor(-3421237);
        rect.offset(-25, 0);
        canvas.drawRect(rect, paint2);
        rect.offset(25, -25);
        canvas.drawRect(rect, paint2);
        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
        paint.setShader(new BitmapShader(createBitmap, tileMode, tileMode));
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        canvas.drawPaint(this.f7485A2egSU);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.f7485A2egSU.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f7485A2egSU.setColorFilter(colorFilter);
    }
}

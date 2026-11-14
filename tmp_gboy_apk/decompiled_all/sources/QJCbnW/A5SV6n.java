package QJCbnW;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.drawable.BitmapDrawable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A5SV6n extends BitmapDrawable {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Paint f7469A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Paint f7470A4TApA;

    public A5SV6n(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
        this.f7469A2egSU = new Paint(1);
        this.f7470A4TApA = new Paint(1);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int width = getBounds().width();
        float f = width * 0.5f;
        float height = getBounds().height() * 0.5f;
        float min = Math.min(width, r1) * 0.5f;
        SweepGradient sweepGradient = new SweepGradient(f, height, new int[]{-65536, -65281, -16776961, -16711681, -16711936, -256, -65536}, new float[]{0.0f, 0.166f, 0.333f, 0.499f, 0.666f, 0.833f, 0.999f});
        Paint paint = this.f7469A2egSU;
        paint.setShader(sweepGradient);
        RadialGradient radialGradient = new RadialGradient(f, height, min, -1, 16777215, Shader.TileMode.CLAMP);
        Paint paint2 = this.f7470A4TApA;
        paint2.setShader(radialGradient);
        canvas.drawCircle(f, height, min, paint);
        canvas.drawCircle(f, height, min, paint2);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.f7469A2egSU.setAlpha(i);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f7469A2egSU.setColorFilter(colorFilter);
    }
}

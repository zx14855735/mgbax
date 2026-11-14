package ARc23Z;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.appcompat.R$styleable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZkASS extends Drawable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final float f304AcNBzu = (float) Math.toRadians(45.0d);

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Paint f305A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final float f306A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final float f307A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final float f308ADYaiT;
    public final float AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final boolean f309ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final Path f310ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final int f311AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public float f312AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public final float f313AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public final int f314AaHO0E;

    static {
        aCBqnC();
    }

    public AZkASS(Context context) {
        Paint paint = new Paint();
        this.f305A2egSU = paint;
        this.f310ASJ6gh = new Path();
        this.f314AaHO0E = 2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R$styleable.f8026AmA8tU, 2130969039, 2131951832);
        int color = obtainStyledAttributes.getColor(3, 0);
        if (color != paint.getColor()) {
            paint.setColor(color);
            invalidateSelf();
        }
        float dimension = obtainStyledAttributes.getDimension(7, 0.0f);
        if (paint.getStrokeWidth() != dimension) {
            paint.setStrokeWidth(dimension);
            this.f313AZkASS = (float) (Math.cos(f304AcNBzu) * (dimension / 2.0f));
            invalidateSelf();
        }
        boolean z = obtainStyledAttributes.getBoolean(6, true);
        if (this.f309ARc23Z != z) {
            this.f309ARc23Z = z;
            invalidateSelf();
        }
        float round = Math.round(obtainStyledAttributes.getDimension(5, 0.0f));
        if (round != this.AMqCpz) {
            this.AMqCpz = round;
            invalidateSelf();
        }
        this.f311AYUAbz = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.f307A5SV6n = Math.round(obtainStyledAttributes.getDimension(2, 0.0f));
        this.f306A4TApA = Math.round(obtainStyledAttributes.getDimension(0, 0.0f));
        this.f308ADYaiT = obtainStyledAttributes.getDimension(1, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public static float A2egSU(float f, float f2, float f3) {
        return CtFAbx.A4TApA(f2, f, f3, f);
    }

    private static /* synthetic */ void aCBqnC() {
        char[] charArray = "ÜÐÒ\u0091ØÞÒÚ\u0091ÝÐÆ\u0091Ì×ÚÓÓ\u0091õÑÖýÍÖÛØÚ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 191);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÜÓÖÑÖË".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 191);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i = this.f314AaHO0E;
        boolean z = false;
        if (i != 0 && (i == 1 || (i == 3 ? com.bumptech.glide.A5SV6n.BPw6Q8(this) == 0 : com.bumptech.glide.A5SV6n.BPw6Q8(this) == 1))) {
            z = true;
        }
        float f = this.f306A4TApA;
        float sqrt = (float) Math.sqrt(f * f * 2.0f);
        float f2 = this.f312AZOQYO;
        float f3 = this.f307A5SV6n;
        float A2egSU2 = A2egSU(f3, sqrt, f2);
        float A2egSU3 = A2egSU(f3, this.f308ADYaiT, this.f312AZOQYO);
        float round = Math.round(A2egSU(0.0f, this.f313AZkASS, this.f312AZOQYO));
        float A2egSU4 = A2egSU(0.0f, f304AcNBzu, this.f312AZOQYO);
        float A2egSU5 = A2egSU(z ? 0.0f : -180.0f, z ? 180.0f : 0.0f, this.f312AZOQYO);
        double d = A2egSU2;
        double d2 = A2egSU4;
        boolean z2 = z;
        float round2 = Math.round(Math.cos(d2) * d);
        float round3 = Math.round(Math.sin(d2) * d);
        Path path = this.f310ASJ6gh;
        path.rewind();
        float f4 = this.AMqCpz;
        Paint paint = this.f305A2egSU;
        float A2egSU6 = A2egSU(paint.getStrokeWidth() + f4, -this.f313AZkASS, this.f312AZOQYO);
        float f5 = (-A2egSU3) / 2.0f;
        path.moveTo(f5 + round, 0.0f);
        path.rLineTo(A2egSU3 - (round * 2.0f), 0.0f);
        path.moveTo(f5, A2egSU6);
        path.rLineTo(round2, round3);
        path.moveTo(f5, -A2egSU6);
        path.rLineTo(round2, -round3);
        path.close();
        canvas.save();
        float strokeWidth = paint.getStrokeWidth();
        float height = bounds.height() - (3.0f * strokeWidth);
        canvas.translate(bounds.centerX(), (strokeWidth * 1.5f) + this.AMqCpz + ((((int) (height - (r6 * 2.0f))) / 4) * 2));
        if (this.f309ARc23Z) {
            canvas.rotate(A2egSU5 * (z2 ? -1 : 1));
        } else if (z2) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(path, paint);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f311AYUAbz;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f311AYUAbz;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        Paint paint = this.f305A2egSU;
        if (i != paint.getAlpha()) {
            paint.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f305A2egSU.setColorFilter(colorFilter);
        invalidateSelf();
    }
}

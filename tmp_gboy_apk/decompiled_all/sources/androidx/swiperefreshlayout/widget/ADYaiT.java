package androidx.swiperefreshlayout.widget;

import ADYaiT.CtFAbx;
import Oay4Bh.AaHO0E;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import com.sigmob.sdk.base.blurkit.d;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT extends Drawable implements Animatable {

    /* renamed from: B3GDIM, reason: collision with root package name */
    public static final LinearInterpolator f9510B3GDIM = new LinearInterpolator();

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public static final D8cQ8b.A4TApA f9511B4ZgIw = new D8cQ8b.A4TApA();

    /* renamed from: B7CMnp, reason: collision with root package name */
    public static final int[] f9512B7CMnp = {d.f13043a};

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final A5SV6n f9513AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public float f9514AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Resources f9515AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final ValueAnimator f9516AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public float f9517B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public boolean f9518B2KMhB;

    static {
        gpNptp();
    }

    public ADYaiT(Context context) {
        context.getClass();
        this.f9515AmA8tU = context.getResources();
        A5SV6n a5SV6n = new A5SV6n();
        this.f9513AcNBzu = a5SV6n;
        a5SV6n.f9497AZOQYO = f9512B7CMnp;
        a5SV6n.A2egSU(0);
        a5SV6n.f9496AYUAbz = 2.5f;
        a5SV6n.f9491A4TApA.setStrokeWidth(2.5f);
        invalidateSelf();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new AaHO0E(this, a5SV6n));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f9510B3GDIM);
        ofFloat.addListener(new A4TApA(this, a5SV6n));
        this.f9516AzWtSf = ofFloat;
    }

    public static void ADYaiT(float f, A5SV6n a5SV6n) {
        if (f <= 0.75f) {
            a5SV6n.f9509B9tovu = a5SV6n.f9497AZOQYO[a5SV6n.f9498AZkASS];
            return;
        }
        float f2 = (f - 0.75f) / 0.25f;
        int[] iArr = a5SV6n.f9497AZOQYO;
        int i = a5SV6n.f9498AZkASS;
        int i2 = iArr[i];
        int i3 = iArr[(i + 1) % iArr.length];
        a5SV6n.f9509B9tovu = ((((i2 >> 24) & 255) + ((int) ((((i3 >> 24) & 255) - r1) * f2))) << 24) | ((((i2 >> 16) & 255) + ((int) ((((i3 >> 16) & 255) - r3) * f2))) << 16) | ((((i2 >> 8) & 255) + ((int) ((((i3 >> 8) & 255) - r4) * f2))) << 8) | ((i2 & 255) + ((int) (f2 * ((i3 & 255) - r2))));
    }

    private static /* synthetic */ void gpNptp() {
        char[] charArray = "\u0016\u001a\u0018[\u0012\u0014\u0018\u0010[\u0017\u001a\f[\u0006\u001d\u0010\u0019\u0019[?\u001b\u001c7\u0007\u001c\u0011\u0012\u0010".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'u');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0016\u0019\u001c\u001b\u001c\u0001".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'u');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A2egSU(float f, A5SV6n a5SV6n, boolean z) {
        float interpolation;
        float f2;
        if (this.f9518B2KMhB) {
            ADYaiT(f, a5SV6n);
            float floor = (float) (Math.floor(a5SV6n.f9501AlLFFp / 0.8f) + 1.0d);
            float f3 = a5SV6n.f9499AaHO0E;
            float f4 = a5SV6n.f9500AcNBzu;
            a5SV6n.AMqCpz = (((f4 - 0.01f) - f3) * f) + f3;
            a5SV6n.f9494ARc23Z = f4;
            float f5 = a5SV6n.f9501AlLFFp;
            a5SV6n.f9495ASJ6gh = CtFAbx.A4TApA(floor, f5, f, f5);
            return;
        }
        if (f != 1.0f || z) {
            float f6 = a5SV6n.f9501AlLFFp;
            D8cQ8b.A4TApA a4TApA = f9511B4ZgIw;
            if (f < 0.5f) {
                interpolation = a5SV6n.f9499AaHO0E;
                f2 = (a4TApA.getInterpolation(f / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                float f7 = a5SV6n.f9499AaHO0E + 0.79f;
                interpolation = f7 - (((1.0f - a4TApA.getInterpolation((f - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f2 = f7;
            }
            float f8 = (0.20999998f * f) + f6;
            float f9 = (f + this.f9517B25kr6) * 216.0f;
            a5SV6n.AMqCpz = interpolation;
            a5SV6n.f9494ARc23Z = f2;
            a5SV6n.f9495ASJ6gh = f8;
            this.f9514AlLFFp = f9;
        }
    }

    public final void A4TApA(float f, float f2, float f3, float f4) {
        float f5 = this.f9515AmA8tU.getDisplayMetrics().density;
        float f6 = f2 * f5;
        A5SV6n a5SV6n = this.f9513AcNBzu;
        a5SV6n.f9496AYUAbz = f6;
        a5SV6n.f9491A4TApA.setStrokeWidth(f6);
        a5SV6n.f9505B2KMhB = f * f5;
        a5SV6n.A2egSU(0);
        a5SV6n.f9506B3GDIM = (int) (f3 * f5);
        a5SV6n.f9507B4ZgIw = (int) (f4 * f5);
    }

    public final void A5SV6n(int i) {
        if (i == 0) {
            A4TApA(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            A4TApA(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f9514AlLFFp, bounds.exactCenterX(), bounds.exactCenterY());
        A5SV6n a5SV6n = this.f9513AcNBzu;
        RectF rectF = a5SV6n.f9490A2egSU;
        float f = a5SV6n.f9505B2KMhB;
        float f2 = (a5SV6n.f9496AYUAbz / 2.0f) + f;
        if (f <= 0.0f) {
            f2 = (Math.min(bounds.width(), bounds.height()) / 2.0f) - Math.max((a5SV6n.f9506B3GDIM * a5SV6n.f9504B25kr6) / 2.0f, a5SV6n.f9496AYUAbz / 2.0f);
        }
        rectF.set(bounds.centerX() - f2, bounds.centerY() - f2, bounds.centerX() + f2, bounds.centerY() + f2);
        float f3 = a5SV6n.AMqCpz;
        float f4 = a5SV6n.f9495ASJ6gh;
        float f5 = (f3 + f4) * 360.0f;
        float f6 = ((a5SV6n.f9494ARc23Z + f4) * 360.0f) - f5;
        Paint paint = a5SV6n.f9491A4TApA;
        paint.setColor(a5SV6n.f9509B9tovu);
        paint.setAlpha(a5SV6n.f9508B7CMnp);
        float f7 = a5SV6n.f9496AYUAbz / 2.0f;
        rectF.inset(f7, f7);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, a5SV6n.f9493ADYaiT);
        float f8 = -f7;
        rectF.inset(f8, f8);
        canvas.drawArc(rectF, f5, f6, false, paint);
        if (a5SV6n.f9502AmA8tU) {
            Path path = a5SV6n.f9503AzWtSf;
            if (path == null) {
                Path path2 = new Path();
                a5SV6n.f9503AzWtSf = path2;
                path2.setFillType(Path.FillType.EVEN_ODD);
            } else {
                path.reset();
            }
            float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
            float f9 = (a5SV6n.f9506B3GDIM * a5SV6n.f9504B25kr6) / 2.0f;
            a5SV6n.f9503AzWtSf.moveTo(0.0f, 0.0f);
            a5SV6n.f9503AzWtSf.lineTo(a5SV6n.f9506B3GDIM * a5SV6n.f9504B25kr6, 0.0f);
            Path path3 = a5SV6n.f9503AzWtSf;
            float f10 = a5SV6n.f9506B3GDIM;
            float f11 = a5SV6n.f9504B25kr6;
            path3.lineTo((f10 * f11) / 2.0f, a5SV6n.f9507B4ZgIw * f11);
            a5SV6n.f9503AzWtSf.offset((rectF.centerX() + min) - f9, (a5SV6n.f9496AYUAbz / 2.0f) + rectF.centerY());
            a5SV6n.f9503AzWtSf.close();
            Paint paint2 = a5SV6n.f9492A5SV6n;
            paint2.setColor(a5SV6n.f9509B9tovu);
            paint2.setAlpha(a5SV6n.f9508B7CMnp);
            canvas.save();
            canvas.rotate(f5 + f6, rectF.centerX(), rectF.centerY());
            canvas.drawPath(a5SV6n.f9503AzWtSf, paint2);
            canvas.restore();
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f9513AcNBzu.f9508B7CMnp;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f9516AzWtSf.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.f9513AcNBzu.f9508B7CMnp = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f9513AcNBzu.f9491A4TApA.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        this.f9516AzWtSf.cancel();
        A5SV6n a5SV6n = this.f9513AcNBzu;
        float f = a5SV6n.AMqCpz;
        a5SV6n.f9499AaHO0E = f;
        float f2 = a5SV6n.f9494ARc23Z;
        a5SV6n.f9500AcNBzu = f2;
        a5SV6n.f9501AlLFFp = a5SV6n.f9495ASJ6gh;
        if (f2 != f) {
            this.f9518B2KMhB = true;
            this.f9516AzWtSf.setDuration(666L);
            this.f9516AzWtSf.start();
            return;
        }
        a5SV6n.A2egSU(0);
        a5SV6n.f9499AaHO0E = 0.0f;
        a5SV6n.f9500AcNBzu = 0.0f;
        a5SV6n.f9501AlLFFp = 0.0f;
        a5SV6n.AMqCpz = 0.0f;
        a5SV6n.f9494ARc23Z = 0.0f;
        a5SV6n.f9495ASJ6gh = 0.0f;
        this.f9516AzWtSf.setDuration(1332L);
        this.f9516AzWtSf.start();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f9516AzWtSf.cancel();
        this.f9514AlLFFp = 0.0f;
        A5SV6n a5SV6n = this.f9513AcNBzu;
        if (a5SV6n.f9502AmA8tU) {
            a5SV6n.f9502AmA8tU = false;
        }
        a5SV6n.A2egSU(0);
        a5SV6n.f9499AaHO0E = 0.0f;
        a5SV6n.f9500AcNBzu = 0.0f;
        a5SV6n.f9501AlLFFp = 0.0f;
        a5SV6n.AMqCpz = 0.0f;
        a5SV6n.f9494ARc23Z = 0.0f;
        a5SV6n.f9495ASJ6gh = 0.0f;
        invalidateSelf();
    }
}

package OvgpEe;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AZkASS {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final B25kr6 f6872A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Path f6873A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Path f6874A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final PathMeasure f6875ADYaiT;
    public final Matrix AMqCpz;

    public AZkASS(B25kr6 b25kr6) {
        Path path = new Path();
        this.f6873A4TApA = path;
        this.f6874A5SV6n = new Path();
        this.f6875ADYaiT = new PathMeasure(path, false);
        this.f6872A2egSU = b25kr6;
        this.AMqCpz = new Matrix();
    }

    public static float ADYaiT(float[] fArr) {
        return (float) Math.toDegrees(Math.atan2(fArr[1], fArr[0]));
    }

    public abstract int A2egSU();

    public abstract void A4TApA();

    public final void A5SV6n(Canvas canvas, Rect rect, float f, boolean z, boolean z2) {
        this.f6872A2egSU.ADYaiT();
        AcNBzu acNBzu = (AcNBzu) this;
        if (acNBzu.f6878ARc23Z != rect.width()) {
            acNBzu.f6878ARc23Z = rect.width();
            acNBzu.A4TApA();
        }
        float A2egSU2 = acNBzu.A2egSU();
        canvas.translate((rect.width() / 2.0f) + rect.left, Math.max(0.0f, (rect.height() - A2egSU2) / 2.0f) + (rect.height() / 2.0f) + rect.top);
        B25kr6 b25kr6 = acNBzu.f6872A2egSU;
        if (b25kr6.f6923B2KMhB) {
            canvas.scale(-1.0f, 1.0f);
        }
        float f2 = acNBzu.f6878ARc23Z / 2.0f;
        float f3 = A2egSU2 / 2.0f;
        canvas.clipRect(-f2, -f3, f2, f3);
        acNBzu.f6879ASJ6gh = b25kr6.f6908A2egSU * f;
        acNBzu.f6880AYUAbz = Math.min(r1 / 2, b25kr6.A2egSU()) * f;
        acNBzu.f6882AZkASS = b25kr6.f6918AcNBzu * f;
        acNBzu.f6881AZOQYO = Math.min(b25kr6.f6908A2egSU / 2.0f, b25kr6.A4TApA()) * f;
        if (z || z2) {
            if ((z && b25kr6.f6913ASJ6gh == 2) || (z2 && b25kr6.f6914AYUAbz == 1)) {
                canvas.scale(1.0f, -1.0f);
            }
            if (z || (z2 && b25kr6.f6914AYUAbz != 3)) {
                canvas.translate(0.0f, ((1.0f - f) * b25kr6.f6908A2egSU) / 2.0f);
            }
        }
        if (z2 && b25kr6.f6914AYUAbz == 3) {
            acNBzu.f6886AmA8tU = f;
        } else {
            acNBzu.f6886AmA8tU = 1.0f;
        }
    }
}

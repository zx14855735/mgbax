package PCV8se;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BChYOn extends BNL6CD {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final BIYEnU f7119A5SV6n;

    public BChYOn(BIYEnU bIYEnU) {
        this.f7119A5SV6n = bIYEnU;
    }

    @Override // PCV8se.BNL6CD
    public final void A2egSU(Matrix matrix, P94amq.A2egSU a2egSU, int i, Canvas canvas) {
        BIYEnU bIYEnU = this.f7119A5SV6n;
        float f = bIYEnU.f7126ARc23Z;
        float f2 = bIYEnU.f7127ASJ6gh;
        RectF rectF = new RectF(bIYEnU.f7123A4TApA, bIYEnU.f7124A5SV6n, bIYEnU.f7125ADYaiT, bIYEnU.AMqCpz);
        a2egSU.getClass();
        boolean z = f2 < 0.0f;
        Path path = a2egSU.f7013ASJ6gh;
        int[] iArr = P94amq.A2egSU.f7006AaHO0E;
        if (z) {
            iArr[0] = 0;
            iArr[1] = a2egSU.f7012ARc23Z;
            iArr[2] = a2egSU.AMqCpz;
            iArr[3] = a2egSU.f7011ADYaiT;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f, f2);
            path.close();
            float f3 = -i;
            rectF.inset(f3, f3);
            iArr[0] = 0;
            iArr[1] = a2egSU.f7011ADYaiT;
            iArr[2] = a2egSU.AMqCpz;
            iArr[3] = a2egSU.f7012ARc23Z;
        }
        float width = rectF.width() / 2.0f;
        if (width <= 0.0f) {
            return;
        }
        float f4 = 1.0f - (i / width);
        float[] fArr = P94amq.A2egSU.f7007AcNBzu;
        fArr[1] = f4;
        fArr[2] = ((1.0f - f4) / 2.0f) + f4;
        RadialGradient radialGradient = new RadialGradient(rectF.centerX(), rectF.centerY(), width, iArr, fArr, Shader.TileMode.CLAMP);
        Paint paint = a2egSU.f7009A4TApA;
        paint.setShader(radialGradient);
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, a2egSU.f7014AYUAbz);
        }
        canvas.drawArc(rectF, f, f2, true, paint);
        canvas.restore();
    }
}

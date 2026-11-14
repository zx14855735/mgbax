package PCV8se;

import PCV8se.BJ7GGh;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BI9f7h extends BNL6CD {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final BJ7GGh.A2egSU f7120A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final float f7121ADYaiT;
    public final float AMqCpz;

    public BI9f7h(BJ7GGh.A2egSU a2egSU, float f, float f2) {
        this.f7120A5SV6n = a2egSU;
        this.f7121ADYaiT = f;
        this.AMqCpz = f2;
    }

    @Override // PCV8se.BNL6CD
    public final void A2egSU(Matrix matrix, P94amq.A2egSU a2egSU, int i, Canvas canvas) {
        BJ7GGh.A2egSU a2egSU2 = this.f7120A5SV6n;
        float f = a2egSU2.f7136A5SV6n;
        float f2 = this.AMqCpz;
        float f3 = a2egSU2.f7135A4TApA;
        float f4 = this.f7121ADYaiT;
        RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(f - f2, f3 - f4), 0.0f);
        Matrix matrix2 = this.f7139A2egSU;
        matrix2.set(matrix);
        matrix2.preTranslate(f4, f2);
        matrix2.preRotate(A4TApA());
        a2egSU.getClass();
        rectF.bottom += i;
        rectF.offset(0.0f, -i);
        int[] iArr = P94amq.A2egSU.f7004AZOQYO;
        iArr[0] = a2egSU.f7012ARc23Z;
        iArr[1] = a2egSU.AMqCpz;
        iArr[2] = a2egSU.f7011ADYaiT;
        Paint paint = a2egSU.f7010A5SV6n;
        float f5 = rectF.left;
        paint.setShader(new LinearGradient(f5, rectF.top, f5, rectF.bottom, iArr, P94amq.A2egSU.f7005AZkASS, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix2);
        canvas.drawRect(rectF, paint);
        canvas.restore();
    }

    public final float A4TApA() {
        BJ7GGh.A2egSU a2egSU = this.f7120A5SV6n;
        return (float) Math.toDegrees(Math.atan((a2egSU.f7136A5SV6n - this.AMqCpz) / (a2egSU.f7135A4TApA - this.f7121ADYaiT)));
    }
}

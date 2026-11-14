package OvgpEe;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.util.Pair;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AcNBzu extends AZkASS {

    /* renamed from: ARc23Z, reason: collision with root package name */
    public float f6878ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public float f6879ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public float f6880AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public float f6881AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public float f6882AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public float f6883AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f6884AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f6885AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public float f6886AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public Pair f6887AzWtSf;

    @Override // OvgpEe.AZkASS
    public final int A2egSU() {
        B25kr6 b25kr6 = this.f6872A2egSU;
        return (b25kr6.f6918AcNBzu * 2) + b25kr6.f6908A2egSU;
    }

    @Override // OvgpEe.AZkASS
    public final void A4TApA() {
        Path path = this.f6873A4TApA;
        path.rewind();
        B25kr6 b25kr6 = this.f6872A2egSU;
        if (b25kr6.A5SV6n(this.f6885AlLFFp)) {
            int i = this.f6885AlLFFp ? b25kr6.f6916AZkASS : b25kr6.f6917AaHO0E;
            float f = this.f6878ARc23Z;
            int i2 = (int) (f / i);
            this.f6883AaHO0E = f / i2;
            for (int i3 = 0; i3 <= i2; i3++) {
                int i4 = i3 * 2;
                float f2 = i4 + 1;
                path.cubicTo(i4 + 0.48f, 0.0f, f2 - 0.48f, 1.0f, f2, 1.0f);
                float f3 = f2 + 0.48f;
                float f4 = i4 + 2;
                path.cubicTo(f3, 1.0f, f4 - 0.48f, 0.0f, f4, 0.0f);
            }
            Matrix matrix = this.AMqCpz;
            matrix.reset();
            matrix.setScale(this.f6883AaHO0E / 2.0f, -2.0f);
            matrix.postTranslate(0.0f, 1.0f);
            path.transform(matrix);
        } else {
            path.lineTo(this.f6878ARc23Z, 0.0f);
        }
        this.f6875ADYaiT.setPath(path, false);
    }

    public final void AMqCpz(Canvas canvas, Paint paint, float f, float f2, int i, int i2, int i3, float f3, float f4, boolean z) {
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        Canvas canvas2;
        Pair pair;
        float B2KMhB2 = com.bumptech.glide.AMqCpz.B2KMhB(f, 0.0f, 1.0f);
        float B2KMhB3 = com.bumptech.glide.AMqCpz.B2KMhB(f2, 0.0f, 1.0f);
        float CkXcdM2 = NOd7IU.AlLFFp.CkXcdM(1.0f - this.f6886AmA8tU, 1.0f, B2KMhB2);
        float CkXcdM3 = NOd7IU.AlLFFp.CkXcdM(1.0f - this.f6886AmA8tU, 1.0f, B2KMhB3);
        int B2KMhB4 = (int) ((com.bumptech.glide.AMqCpz.B2KMhB(CkXcdM2, 0.0f, 0.01f) * i2) / 0.01f);
        int B2KMhB5 = (int) (((1.0f - com.bumptech.glide.AMqCpz.B2KMhB(CkXcdM3, 0.99f, 1.0f)) * i3) / 0.01f);
        float f10 = this.f6878ARc23Z;
        int i4 = (int) ((CkXcdM2 * f10) + B2KMhB4);
        int i5 = (int) ((CkXcdM3 * f10) - B2KMhB5);
        float f11 = this.f6880AYUAbz;
        float f12 = this.f6881AZOQYO;
        if (f11 != f12) {
            float max = Math.max(f11, f12);
            float f13 = this.f6878ARc23Z;
            float f14 = max / f13;
            f5 = NOd7IU.AlLFFp.CkXcdM(this.f6880AYUAbz, this.f6881AZOQYO, com.bumptech.glide.AMqCpz.B2KMhB(i4 / f13, 0.0f, f14) / f14);
            float f15 = this.f6880AYUAbz;
            float f16 = this.f6881AZOQYO;
            float f17 = this.f6878ARc23Z;
            f6 = NOd7IU.AlLFFp.CkXcdM(f15, f16, com.bumptech.glide.AMqCpz.B2KMhB((f17 - i5) / f17, 0.0f, f14) / f14);
        } else {
            f5 = f11;
            f6 = f5;
        }
        float f18 = (-this.f6878ARc23Z) / 2.0f;
        B25kr6 b25kr6 = this.f6872A2egSU;
        boolean z2 = b25kr6.A5SV6n(this.f6885AlLFFp) && z && f3 > 0.0f;
        if (i4 <= i5) {
            float f19 = i4 + f5;
            float f20 = i5 - f6;
            float f21 = f5 * 2.0f;
            float f22 = f6 * 2.0f;
            paint.setColor(i);
            paint.setAntiAlias(true);
            paint.setStrokeWidth(this.f6879ASJ6gh);
            Pair pair2 = this.f6887AzWtSf;
            ((AZOQYO) pair2.first).A2egSU();
            ((AZOQYO) pair2.second).A2egSU();
            ((AZOQYO) pair2.first).A5SV6n(f19 + f18);
            ((AZOQYO) pair2.second).A5SV6n(f18 + f20);
            if (i4 == 0 && f20 + f6 < f19 + f5) {
                AZOQYO azoqyo = (AZOQYO) pair2.first;
                float f23 = this.f6879ASJ6gh;
                ARc23Z(canvas, paint, azoqyo, f21, f23, f5, (AZOQYO) pair2.second, f22, f23, f6, true);
                return;
            }
            if (f19 - f5 > f20 - f6) {
                AZOQYO azoqyo2 = (AZOQYO) pair2.second;
                float f24 = this.f6879ASJ6gh;
                ARc23Z(canvas, paint, azoqyo2, f22, f24, f6, (AZOQYO) pair2.first, f21, f24, f5, false);
                return;
            }
            float f25 = f6;
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap((b25kr6.f6911ADYaiT && b25kr6.f6910A5SV6n == 0.5f && b25kr6.A4TApA() == b25kr6.A2egSU()) ? Paint.Cap.ROUND : Paint.Cap.BUTT);
            if (z2) {
                PathMeasure pathMeasure = this.f6875ADYaiT;
                Path path = this.f6874A5SV6n;
                float f26 = this.f6878ARc23Z;
                float f27 = f19 / f26;
                float f28 = f20 / f26;
                int i6 = this.f6885AlLFFp ? b25kr6.f6916AZkASS : b25kr6.f6917AaHO0E;
                f7 = 0.5f;
                if (i6 != this.f6884AcNBzu) {
                    this.f6884AcNBzu = i6;
                    A4TApA();
                }
                path.rewind();
                float f29 = (-this.f6878ARc23Z) / 2.0f;
                boolean A5SV6n2 = b25kr6.A5SV6n(this.f6885AlLFFp);
                if (A5SV6n2) {
                    float f30 = this.f6878ARc23Z;
                    float f31 = this.f6883AaHO0E;
                    float f32 = f30 / f31;
                    float f33 = f4 / f32;
                    float f34 = f32 / (f32 + 1.0f);
                    f27 = (f27 + f33) * f34;
                    f28 = (f28 + f33) * f34;
                    f29 -= f31 * f4;
                }
                float length = pathMeasure.getLength() * f27;
                float length2 = pathMeasure.getLength() * f28;
                pathMeasure.getSegment(length, length2, path, true);
                AZOQYO azoqyo3 = (AZOQYO) pair2.first;
                azoqyo3.A2egSU();
                f8 = f21;
                f9 = f5;
                pathMeasure.getPosTan(length, azoqyo3.f6869A2egSU, azoqyo3.f6870A4TApA);
                AZOQYO azoqyo4 = (AZOQYO) pair2.second;
                azoqyo4.A2egSU();
                pathMeasure.getPosTan(length2, azoqyo4.f6869A2egSU, azoqyo4.f6870A4TApA);
                Matrix matrix = this.AMqCpz;
                matrix.reset();
                matrix.setTranslate(f29, 0.0f);
                azoqyo3.A5SV6n(f29);
                azoqyo4.A5SV6n(f29);
                if (A5SV6n2) {
                    float f35 = this.f6882AZkASS * f3;
                    matrix.postScale(1.0f, f35);
                    azoqyo3.A4TApA(f35);
                    azoqyo4.A4TApA(f35);
                }
                path.transform(matrix);
                canvas2 = canvas;
                canvas2.drawPath(path, paint);
            } else {
                float[] fArr = ((AZOQYO) pair2.first).f6869A2egSU;
                float f36 = fArr[0];
                float f37 = fArr[1];
                float[] fArr2 = ((AZOQYO) pair2.second).f6869A2egSU;
                canvas.drawLine(f36, f37, fArr2[0], fArr2[1], paint);
                canvas2 = canvas;
                f8 = f21;
                f9 = f5;
                f7 = 0.5f;
            }
            if (b25kr6.f6911ADYaiT && b25kr6.f6910A5SV6n == f7 && b25kr6.A4TApA() == b25kr6.A2egSU()) {
                return;
            }
            if (f19 <= 0.0f || f9 <= 0.0f) {
                pair = pair2;
            } else {
                pair = pair2;
                ARc23Z(canvas2, paint, (AZOQYO) pair2.first, f8, this.f6879ASJ6gh, f9, null, 0.0f, 0.0f, 0.0f, false);
            }
            if (f20 >= this.f6878ARc23Z || f25 <= 0.0f) {
                return;
            }
            ARc23Z(canvas, paint, (AZOQYO) pair.second, f22, this.f6879ASJ6gh, f25, null, 0.0f, 0.0f, 0.0f, false);
        }
    }

    public final void ARc23Z(Canvas canvas, Paint paint, AZOQYO azoqyo, float f, float f2, float f3, AZOQYO azoqyo2, float f4, float f5, float f6, boolean z) {
        float f7;
        float f8;
        float min = Math.min(f2, this.f6879ASJ6gh);
        float f9 = (-f) / 2.0f;
        float f10 = (-min) / 2.0f;
        float f11 = f / 2.0f;
        float f12 = min / 2.0f;
        RectF rectF = new RectF(f9, f10, f11, f12);
        paint.setStyle(Paint.Style.FILL);
        canvas.save();
        if (azoqyo2 != null) {
            float min2 = Math.min(f5, this.f6879ASJ6gh);
            float min3 = Math.min(f4 / 2.0f, (f6 * min2) / this.f6879ASJ6gh);
            RectF rectF2 = new RectF();
            float[] fArr = azoqyo2.f6869A2egSU;
            if (z) {
                float f13 = (fArr[0] - min3) - (azoqyo.f6869A2egSU[0] - f3);
                if (f13 > 0.0f) {
                    azoqyo2.A5SV6n((-f13) / 2.0f);
                    f8 = f4 + f13;
                } else {
                    f8 = f4;
                }
                rectF2.set(0.0f, f10, f11, f12);
            } else {
                float f14 = (fArr[0] + min3) - (azoqyo.f6869A2egSU[0] + f3);
                if (f14 < 0.0f) {
                    azoqyo2.A5SV6n((-f14) / 2.0f);
                    f7 = f4 - f14;
                } else {
                    f7 = f4;
                }
                rectF2.set(f9, f10, 0.0f, f12);
                f8 = f7;
            }
            RectF rectF3 = new RectF((-f8) / 2.0f, (-min2) / 2.0f, f8 / 2.0f, min2 / 2.0f);
            canvas.translate(fArr[0], fArr[1]);
            float[] fArr2 = azoqyo2.f6870A4TApA;
            canvas.rotate(AZkASS.ADYaiT(fArr2));
            Path path = new Path();
            path.addRoundRect(rectF3, min3, min3, Path.Direction.CCW);
            canvas.clipPath(path);
            canvas.rotate(-AZkASS.ADYaiT(fArr2));
            canvas.translate(-fArr[0], -fArr[1]);
            float[] fArr3 = azoqyo.f6869A2egSU;
            canvas.translate(fArr3[0], fArr3[1]);
            canvas.rotate(AZkASS.ADYaiT(azoqyo.f6870A4TApA));
            canvas.drawRect(rectF2, paint);
            canvas.drawRoundRect(rectF, f3, f3, paint);
        } else {
            float[] fArr4 = azoqyo.f6869A2egSU;
            canvas.translate(fArr4[0], fArr4[1]);
            canvas.rotate(AZkASS.ADYaiT(azoqyo.f6870A4TApA));
            canvas.drawRoundRect(rectF, f3, f3, paint);
        }
        canvas.restore();
    }

    public final void ASJ6gh(Canvas canvas, Paint paint, float f, float f2, int i, int i2, int i3) {
        int ADYaiT2 = OLy1FW.AYUAbz.ADYaiT(i, i2);
        this.f6885AlLFFp = false;
        AMqCpz(canvas, paint, f, f2, ADYaiT2, i3, i3, 0.0f, 0.0f, false);
    }
}

package PCV8se;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.BitSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class B7CMnp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final BJ7GGh[] f7106A2egSU = new BJ7GGh[4];

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Matrix[] f7107A4TApA = new Matrix[4];

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Matrix[] f7108A5SV6n = new Matrix[4];

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final PointF f7109ADYaiT = new PointF();
    public final Path AMqCpz = new Path();

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final Path f7110ARc23Z = new Path();

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final BJ7GGh f7111ASJ6gh = new BJ7GGh();

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final float[] f7112AYUAbz = new float[2];

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final float[] f7113AZOQYO = new float[2];

    /* renamed from: AZkASS, reason: collision with root package name */
    public final Path f7114AZkASS = new Path();

    /* renamed from: AaHO0E, reason: collision with root package name */
    public final Path f7115AaHO0E = new Path();

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final boolean f7116AcNBzu = true;

    public B7CMnp() {
        for (int i = 0; i < 4; i++) {
            this.f7106A2egSU[i] = new BJ7GGh();
            this.f7107A4TApA[i] = new Matrix();
            this.f7108A5SV6n[i] = new Matrix();
        }
    }

    public final void A2egSU(B2KMhB b2KMhB, float[] fArr, float f, RectF rectF, IQ76hF.AmA8tU amA8tU, Path path) {
        Matrix[] matrixArr;
        Matrix[] matrixArr2;
        BJ7GGh[] bJ7GGhArr;
        char c;
        int i;
        float[] fArr2;
        Matrix[] matrixArr3;
        int i2;
        path.rewind();
        Path path2 = this.AMqCpz;
        path2.rewind();
        Path path3 = this.f7110ARc23Z;
        path3.rewind();
        path3.addRect(rectF, Path.Direction.CW);
        int i3 = 0;
        while (true) {
            matrixArr = this.f7108A5SV6n;
            matrixArr2 = this.f7107A4TApA;
            bJ7GGhArr = this.f7106A2egSU;
            c = 0;
            i = 4;
            fArr2 = this.f7112AYUAbz;
            if (i3 >= 4) {
                break;
            }
            ADYaiT a5SV6n = fArr == null ? i3 != 1 ? i3 != 2 ? i3 != 3 ? b2KMhB.f7087ARc23Z : b2KMhB.AMqCpz : b2KMhB.f7089AYUAbz : b2KMhB.f7088ASJ6gh : new A5SV6n(fArr[i3]);
            AMqCpz aMqCpz = i3 != 1 ? i3 != 2 ? i3 != 3 ? b2KMhB.f7084A4TApA : b2KMhB.f7083A2egSU : b2KMhB.f7086ADYaiT : b2KMhB.f7085A5SV6n;
            BJ7GGh bJ7GGh = bJ7GGhArr[i3];
            aMqCpz.getClass();
            aMqCpz.A2egSU(bJ7GGh, f, a5SV6n.A2egSU(rectF));
            int i4 = i3 + 1;
            float f2 = (i4 % 4) * 90;
            matrixArr2[i3].reset();
            PointF pointF = this.f7109ADYaiT;
            if (i3 == 1) {
                i2 = i3;
                pointF.set(rectF.right, rectF.bottom);
            } else if (i3 == 2) {
                i2 = i3;
                pointF.set(rectF.left, rectF.bottom);
            } else if (i3 != 3) {
                i2 = i3;
                pointF.set(rectF.right, rectF.top);
            } else {
                i2 = i3;
                pointF.set(rectF.left, rectF.top);
            }
            matrixArr2[i2].setTranslate(pointF.x, pointF.y);
            matrixArr2[i2].preRotate(f2);
            BJ7GGh bJ7GGh2 = bJ7GGhArr[i2];
            fArr2[0] = bJ7GGh2.f7130A5SV6n;
            fArr2[1] = bJ7GGh2.f7131ADYaiT;
            matrixArr2[i2].mapPoints(fArr2);
            matrixArr[i2].reset();
            matrixArr[i2].setTranslate(fArr2[0], fArr2[1]);
            matrixArr[i2].preRotate(f2);
            i3 = i4;
        }
        int i5 = 0;
        while (i5 < i) {
            BJ7GGh bJ7GGh3 = bJ7GGhArr[i5];
            fArr2[c] = bJ7GGh3.f7128A2egSU;
            fArr2[1] = bJ7GGh3.f7129A4TApA;
            matrixArr2[i5].mapPoints(fArr2);
            if (i5 == 0) {
                path.moveTo(fArr2[c], fArr2[1]);
            } else {
                path.lineTo(fArr2[c], fArr2[1]);
            }
            bJ7GGhArr[i5].A4TApA(matrixArr2[i5], path);
            if (amA8tU != null) {
                BJ7GGh bJ7GGh4 = bJ7GGhArr[i5];
                Matrix matrix = matrixArr2[i5];
                AaHO0E aaHO0E = (AaHO0E) amA8tU.f3956AlLFFp;
                BitSet bitSet = aaHO0E.f7045B25kr6;
                bJ7GGh4.getClass();
                matrixArr3 = matrixArr;
                bitSet.set(i5, false);
                bJ7GGh4.A2egSU(bJ7GGh4.f7132ARc23Z);
                aaHO0E.f7043AmA8tU[i5] = new B9tovu(new ArrayList(bJ7GGh4.f7134AYUAbz), new Matrix(matrix));
            } else {
                matrixArr3 = matrixArr;
            }
            int i6 = i5 + 1;
            int i7 = i6 % 4;
            BJ7GGh bJ7GGh5 = bJ7GGhArr[i5];
            fArr2[0] = bJ7GGh5.f7130A5SV6n;
            fArr2[1] = bJ7GGh5.f7131ADYaiT;
            matrixArr2[i5].mapPoints(fArr2);
            BJ7GGh bJ7GGh6 = bJ7GGhArr[i7];
            float f3 = bJ7GGh6.f7128A2egSU;
            float[] fArr3 = this.f7113AZOQYO;
            fArr3[0] = f3;
            fArr3[1] = bJ7GGh6.f7129A4TApA;
            matrixArr2[i7].mapPoints(fArr3);
            Matrix[] matrixArr4 = matrixArr2;
            float max = Math.max(((float) Math.hypot(fArr2[0] - fArr3[0], fArr2[1] - fArr3[1])) - 0.001f, 0.0f);
            BJ7GGh bJ7GGh7 = bJ7GGhArr[i5];
            fArr2[0] = bJ7GGh7.f7130A5SV6n;
            fArr2[1] = bJ7GGh7.f7131ADYaiT;
            matrixArr4[i5].mapPoints(fArr2);
            float abs = (i5 == 1 || i5 == 3) ? Math.abs(rectF.centerX() - fArr2[0]) : Math.abs(rectF.centerY() - fArr2[1]);
            BJ7GGh bJ7GGh8 = this.f7111ASJ6gh;
            bJ7GGh8.ADYaiT(0.0f, 0.0f, 270.0f, 0.0f);
            ASJ6gh aSJ6gh = i5 != 1 ? i5 != 2 ? i5 != 3 ? b2KMhB.f7091AZkASS : b2KMhB.f7090AZOQYO : b2KMhB.f7093AcNBzu : b2KMhB.f7092AaHO0E;
            aSJ6gh.A4TApA(max, abs, f, bJ7GGh8);
            Path path4 = this.f7114AZkASS;
            path4.reset();
            bJ7GGh8.A4TApA(matrixArr3[i5], path4);
            if (this.f7116AcNBzu && (aSJ6gh.A2egSU() || A4TApA(path4, i5) || A4TApA(path4, i7))) {
                path4.op(path4, path3, Path.Op.DIFFERENCE);
                fArr2[0] = bJ7GGh8.f7128A2egSU;
                fArr2[1] = bJ7GGh8.f7129A4TApA;
                matrixArr3[i5].mapPoints(fArr2);
                path2.moveTo(fArr2[0], fArr2[1]);
                bJ7GGh8.A4TApA(matrixArr3[i5], path2);
            } else {
                bJ7GGh8.A4TApA(matrixArr3[i5], path);
            }
            if (amA8tU != null) {
                Matrix matrix2 = matrixArr3[i5];
                AaHO0E aaHO0E2 = (AaHO0E) amA8tU.f3956AlLFFp;
                aaHO0E2.f7045B25kr6.set(i5 + 4, false);
                bJ7GGh8.A2egSU(bJ7GGh8.f7132ARc23Z);
                aaHO0E2.f7044AzWtSf[i5] = new B9tovu(new ArrayList(bJ7GGh8.f7134AYUAbz), new Matrix(matrix2));
            }
            i5 = i6;
            matrixArr = matrixArr3;
            matrixArr2 = matrixArr4;
            i = 4;
            c = 0;
        }
        path.close();
        path2.close();
        if (path2.isEmpty()) {
            return;
        }
        path.op(path2, Path.Op.UNION);
    }

    public final boolean A4TApA(Path path, int i) {
        Path path2 = this.f7115AaHO0E;
        path2.reset();
        this.f7106A2egSU[i].A4TApA(this.f7107A4TApA[i], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        return !rectF.isEmpty() || (rectF.width() > 1.0f && rectF.height() > 1.0f);
    }
}

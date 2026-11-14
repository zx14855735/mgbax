package DcUJf1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AzWtSf {

    /* renamed from: B25kr6, reason: collision with root package name */
    public static final Matrix f2355B25kr6 = new Matrix();

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Path f2356A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Path f2357A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Matrix f2358A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public Paint f2359ADYaiT;
    public Paint AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public PathMeasure f2360ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final AcNBzu f2361ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public float f2362AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public float f2363AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public float f2364AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public float f2365AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f2366AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public String f2367AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public Boolean f2368AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final B25kr6.ADYaiT f2369AzWtSf;

    static {
        KASIpuf();
    }

    public AzWtSf() {
        this.f2358A5SV6n = new Matrix();
        this.f2362AYUAbz = 0.0f;
        this.f2363AZOQYO = 0.0f;
        this.f2364AZkASS = 0.0f;
        this.f2365AaHO0E = 0.0f;
        this.f2366AcNBzu = 255;
        this.f2367AlLFFp = null;
        this.f2368AmA8tU = null;
        this.f2369AzWtSf = new B25kr6.ADYaiT();
        this.f2361ASJ6gh = new AcNBzu();
        this.f2356A2egSU = new Path();
        this.f2357A4TApA = new Path();
    }

    private static /* synthetic */ void KASIpuf() {
        char[] charArray = "fjh+bdh`+gj|+vm`ii+OklGwlab`".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 5);
        }
        String str = new String(charArray);
        char[] charArray2 = "filklq".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 5);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A2egSU(AcNBzu acNBzu, Matrix matrix, Canvas canvas, int i, int i2) {
        float f;
        int i3;
        float f2;
        AcNBzu acNBzu2 = acNBzu;
        char c = 1;
        acNBzu2.f2342A2egSU.set(matrix);
        Matrix matrix2 = acNBzu2.f2350AZkASS;
        Matrix matrix3 = acNBzu2.f2342A2egSU;
        matrix3.preConcat(matrix2);
        canvas.save();
        char c2 = 0;
        int i4 = 0;
        while (true) {
            ArrayList arrayList = acNBzu2.f2343A4TApA;
            if (i4 >= arrayList.size()) {
                canvas.restore();
                return;
            }
            AlLFFp alLFFp = (AlLFFp) arrayList.get(i4);
            if (alLFFp instanceof AcNBzu) {
                A2egSU((AcNBzu) alLFFp, matrix3, canvas, i, i2);
            } else if (alLFFp instanceof AmA8tU) {
                AmA8tU amA8tU = (AmA8tU) alLFFp;
                float f3 = i / this.f2364AZkASS;
                float f4 = i2 / this.f2365AaHO0E;
                float min = Math.min(f3, f4);
                Matrix matrix4 = this.f2358A5SV6n;
                matrix4.set(matrix3);
                matrix4.postScale(f3, f4);
                float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                matrix3.mapVectors(fArr);
                float hypot = (float) Math.hypot(fArr[c2], fArr[c]);
                float hypot2 = (float) Math.hypot(fArr[2], fArr[3]);
                float f5 = (fArr[0] * fArr[3]) - (fArr[1] * fArr[2]);
                float max = Math.max(hypot, hypot2);
                float abs = max > 0.0f ? Math.abs(f5) / max : 0.0f;
                if (abs != 0.0f) {
                    amA8tU.getClass();
                    Path path = this.f2356A2egSU;
                    path.reset();
                    BV3sI0.ARc23Z[] aRc23ZArr = amA8tU.f2352A2egSU;
                    if (aRc23ZArr != null) {
                        BV3sI0.ARc23Z.A4TApA(aRc23ZArr, path);
                    }
                    Path path2 = this.f2357A4TApA;
                    path2.reset();
                    if (amA8tU instanceof AZkASS) {
                        path2.setFillType(amA8tU.f2354A5SV6n == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                        path2.addPath(path, matrix4);
                        canvas.clipPath(path2);
                    } else {
                        AaHO0E aaHO0E = (AaHO0E) amA8tU;
                        float f6 = aaHO0E.f2336AZOQYO;
                        if (f6 != 0.0f || aaHO0E.f2337AZkASS != 1.0f) {
                            float f7 = aaHO0E.f2338AaHO0E;
                            float f8 = (f6 + f7) % 1.0f;
                            float f9 = (aaHO0E.f2337AZkASS + f7) % 1.0f;
                            if (this.f2360ARc23Z == null) {
                                this.f2360ARc23Z = new PathMeasure();
                            }
                            this.f2360ARc23Z.setPath(path, false);
                            float length = this.f2360ARc23Z.getLength();
                            float f10 = f8 * length;
                            float f11 = f9 * length;
                            path.reset();
                            if (f10 > f11) {
                                this.f2360ARc23Z.getSegment(f10, length, path, true);
                                f = 0.0f;
                                this.f2360ARc23Z.getSegment(0.0f, f11, path, true);
                            } else {
                                f = 0.0f;
                                this.f2360ARc23Z.getSegment(f10, f11, path, true);
                            }
                            path.rLineTo(f, f);
                        }
                        path2.addPath(path, matrix4);
                        BTvldC.ADYaiT aDYaiT = aaHO0E.f2333ARc23Z;
                        if ((((Shader) aDYaiT.f1448AlLFFp) == null && aDYaiT.f1447AcNBzu == 0) ? false : true) {
                            if (this.AMqCpz == null) {
                                i3 = 16777215;
                                Paint paint = new Paint(1);
                                this.AMqCpz = paint;
                                paint.setStyle(Paint.Style.FILL);
                            } else {
                                i3 = 16777215;
                            }
                            Paint paint2 = this.AMqCpz;
                            Shader shader = (Shader) aDYaiT.f1448AlLFFp;
                            if (shader != null) {
                                shader.setLocalMatrix(matrix4);
                                paint2.setShader(shader);
                                paint2.setAlpha(Math.round(aaHO0E.f2335AYUAbz * 255.0f));
                                f2 = 255.0f;
                            } else {
                                paint2.setShader(null);
                                paint2.setAlpha(255);
                                int i5 = aDYaiT.f1447AcNBzu;
                                float f12 = aaHO0E.f2335AYUAbz;
                                PorterDuff.Mode mode = B3GDIM.f2382B9tovu;
                                f2 = 255.0f;
                                paint2.setColor((i5 & i3) | (((int) (Color.alpha(i5) * f12)) << 24));
                            }
                            paint2.setColorFilter(null);
                            path2.setFillType(aaHO0E.f2354A5SV6n == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                            canvas.drawPath(path2, paint2);
                        } else {
                            i3 = 16777215;
                            f2 = 255.0f;
                        }
                        BTvldC.ADYaiT aDYaiT2 = aaHO0E.f2332ADYaiT;
                        if (((Shader) aDYaiT2.f1448AlLFFp) != null || aDYaiT2.f1447AcNBzu != 0) {
                            if (this.f2359ADYaiT == null) {
                                Paint paint3 = new Paint(1);
                                this.f2359ADYaiT = paint3;
                                paint3.setStyle(Paint.Style.STROKE);
                            }
                            Paint paint4 = this.f2359ADYaiT;
                            Paint.Join join = aaHO0E.f2340AlLFFp;
                            if (join != null) {
                                paint4.setStrokeJoin(join);
                            }
                            Paint.Cap cap = aaHO0E.f2339AcNBzu;
                            if (cap != null) {
                                paint4.setStrokeCap(cap);
                            }
                            paint4.setStrokeMiter(aaHO0E.f2341AmA8tU);
                            Shader shader2 = (Shader) aDYaiT2.f1448AlLFFp;
                            if (shader2 != null) {
                                shader2.setLocalMatrix(matrix4);
                                paint4.setShader(shader2);
                                paint4.setAlpha(Math.round(aaHO0E.f2334ASJ6gh * f2));
                            } else {
                                paint4.setShader(null);
                                paint4.setAlpha(255);
                                int i6 = aDYaiT2.f1447AcNBzu;
                                float f13 = aaHO0E.f2334ASJ6gh;
                                PorterDuff.Mode mode2 = B3GDIM.f2382B9tovu;
                                paint4.setColor((i6 & i3) | (((int) (Color.alpha(i6) * f13)) << 24));
                            }
                            paint4.setColorFilter(null);
                            paint4.setStrokeWidth(aaHO0E.AMqCpz * min * abs);
                            canvas.drawPath(path2, paint4);
                        }
                    }
                }
                i4++;
                acNBzu2 = acNBzu;
                c = 1;
                c2 = 0;
            }
            i4++;
            acNBzu2 = acNBzu;
            c = 1;
            c2 = 0;
        }
    }

    public float getAlpha() {
        return getRootAlpha() / 255.0f;
    }

    public int getRootAlpha() {
        return this.f2366AcNBzu;
    }

    public void setAlpha(float f) {
        setRootAlpha((int) (f * 255.0f));
    }

    public void setRootAlpha(int i) {
        this.f2366AcNBzu = i;
    }

    public AzWtSf(AzWtSf azWtSf) {
        this.f2358A5SV6n = new Matrix();
        this.f2362AYUAbz = 0.0f;
        this.f2363AZOQYO = 0.0f;
        this.f2364AZkASS = 0.0f;
        this.f2365AaHO0E = 0.0f;
        this.f2366AcNBzu = 255;
        this.f2367AlLFFp = null;
        this.f2368AmA8tU = null;
        B25kr6.ADYaiT aDYaiT = new B25kr6.ADYaiT();
        this.f2369AzWtSf = aDYaiT;
        this.f2361ASJ6gh = new AcNBzu(azWtSf.f2361ASJ6gh, aDYaiT);
        this.f2356A2egSU = new Path(azWtSf.f2356A2egSU);
        this.f2357A4TApA = new Path(azWtSf.f2357A4TApA);
        this.f2362AYUAbz = azWtSf.f2362AYUAbz;
        this.f2363AZOQYO = azWtSf.f2363AZOQYO;
        this.f2364AZkASS = azWtSf.f2364AZkASS;
        this.f2365AaHO0E = azWtSf.f2365AaHO0E;
        this.f2366AcNBzu = azWtSf.f2366AcNBzu;
        this.f2367AlLFFp = azWtSf.f2367AlLFFp;
        String str = azWtSf.f2367AlLFFp;
        if (str != null) {
            aDYaiT.put(str, this);
        }
        this.f2368AmA8tU = azWtSf.f2368AmA8tU;
    }
}

package PCV8se;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AlLFFp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final D8MqeW.B4ZgIw f7073A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final D8MqeW.B4ZgIw f7074A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final D8MqeW.B4ZgIw f7075A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final D8MqeW.B4ZgIw f7076ADYaiT;
    public static final D8MqeW.B4ZgIw AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static final D8MqeW.B4ZgIw f7077ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static final D8MqeW.B4ZgIw f7078ASJ6gh;

    static {
        D8MqeW.A2egSU a2egSU = new D8MqeW.A2egSU(0.15f, 0.0f);
        D8MqeW.A2egSU a2egSU2 = new D8MqeW.A2egSU(0.2f, 0.0f);
        D8MqeW.A2egSU a2egSU3 = new D8MqeW.A2egSU(0.3f, 0.0f);
        D8MqeW.A2egSU a2egSU4 = new D8MqeW.A2egSU(0.5f, 0.0f);
        D8MqeW.A2egSU a2egSU5 = new D8MqeW.A2egSU(1.0f, 0.0f);
        A5SV6n(com.bumptech.glide.A5SV6n.B4ZgIw(14));
        A5SV6n(com.bumptech.glide.A5SV6n.CtxOCS(1.0f, a2egSU3, null));
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AcNBzu(new PointF(0.926f, 0.97f), new D8MqeW.A2egSU(0.189f, 0.811f)));
        arrayList.add(new AcNBzu(new PointF(-0.021f, 0.967f), new D8MqeW.A2egSU(0.187f, 0.057f)));
        A5SV6n(A4TApA(2, arrayList, false));
        D8MqeW.A2egSU a2egSU6 = D8MqeW.A2egSU.f2008A5SV6n;
        A5SV6n(com.bumptech.glide.AMqCpz.CrfGsy(NOd7IU.AlLFFp.A4TApA(4, 1.0f, a2egSU6, Arrays.asList(a2egSU5, a2egSU5, a2egSU2, a2egSU2)), A2egSU(-135.0f)));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new AcNBzu(new PointF(1.0f, 1.0f), new D8MqeW.A2egSU(0.148f, 0.417f)));
        arrayList2.add(new AcNBzu(new PointF(0.0f, 1.0f), new D8MqeW.A2egSU(0.151f, 0.0f)));
        arrayList2.add(new AcNBzu(new PointF(0.0f, 0.0f), new D8MqeW.A2egSU(0.148f, 0.0f)));
        arrayList2.add(new AcNBzu(new PointF(0.978f, 0.02f), new D8MqeW.A2egSU(0.803f, 0.0f)));
        A5SV6n(A4TApA(1, arrayList2, false));
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new AcNBzu(new PointF(0.5f, 0.892f), new D8MqeW.A2egSU(0.313f, 0.0f)));
        arrayList3.add(new AcNBzu(new PointF(-0.216f, 1.05f), new D8MqeW.A2egSU(0.207f, 0.0f)));
        arrayList3.add(new AcNBzu(new PointF(0.499f, -0.16f), new D8MqeW.A2egSU(0.215f, 1.0f)));
        arrayList3.add(new AcNBzu(new PointF(1.225f, 1.06f), new D8MqeW.A2egSU(0.211f, 0.0f)));
        A5SV6n(A4TApA(1, arrayList3, false));
        A5SV6n(com.bumptech.glide.A5SV6n.CtxOCS(1.6f, a2egSU6, Arrays.asList(a2egSU2, a2egSU2, a2egSU5, a2egSU5)));
        D8MqeW.B4ZgIw B4ZgIw2 = com.bumptech.glide.A5SV6n.B4ZgIw(15);
        Matrix matrix = new Matrix();
        matrix.setScale(1.0f, 0.64f);
        f7073A2egSU = A5SV6n(com.bumptech.glide.AMqCpz.CrfGsy(com.bumptech.glide.AMqCpz.CrfGsy(B4ZgIw2, matrix), A2egSU(-45.0f)));
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(new AcNBzu(new PointF(0.961f, 0.039f), new D8MqeW.A2egSU(0.426f, 0.0f)));
        arrayList4.add(new AcNBzu(new PointF(1.001f, 0.428f)));
        arrayList4.add(new AcNBzu(new PointF(1.0f, 0.609f), a2egSU5));
        f7074A4TApA = A5SV6n(A4TApA(2, arrayList4, true));
        A5SV6n(com.bumptech.glide.AMqCpz.CrfGsy(NOd7IU.AlLFFp.A4TApA(3, 1.0f, a2egSU2, null), A2egSU(-90.0f)));
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add(new AcNBzu(new PointF(0.5f, 1.096f), new D8MqeW.A2egSU(0.151f, 0.524f)));
        arrayList5.add(new AcNBzu(new PointF(0.04f, 0.5f), new D8MqeW.A2egSU(0.159f, 0.0f)));
        A5SV6n(A4TApA(2, arrayList5, false));
        ArrayList arrayList6 = new ArrayList();
        arrayList6.add(new AcNBzu(new PointF(0.171f, 0.841f), new D8MqeW.A2egSU(0.159f, 0.0f)));
        arrayList6.add(new AcNBzu(new PointF(-0.02f, 0.5f), new D8MqeW.A2egSU(0.14f, 0.0f)));
        arrayList6.add(new AcNBzu(new PointF(0.17f, 0.159f), new D8MqeW.A2egSU(0.159f, 0.0f)));
        A5SV6n(A4TApA(2, arrayList6, false));
        ArrayList arrayList7 = new ArrayList();
        arrayList7.add(new AcNBzu(new PointF(0.5f, -0.009f), new D8MqeW.A2egSU(0.172f, 0.0f)));
        f7075A5SV6n = A5SV6n(A4TApA(5, arrayList7, false));
        ArrayList arrayList8 = new ArrayList();
        arrayList8.add(new AcNBzu(new PointF(0.499f, 1.023f), new D8MqeW.A2egSU(0.241f, 0.778f)));
        arrayList8.add(new AcNBzu(new PointF(-0.005f, 0.792f), new D8MqeW.A2egSU(0.208f, 0.0f)));
        arrayList8.add(new AcNBzu(new PointF(0.073f, 0.258f), new D8MqeW.A2egSU(0.228f, 0.0f)));
        arrayList8.add(new AcNBzu(new PointF(0.433f, -0.0f), new D8MqeW.A2egSU(0.491f, 0.0f)));
        A5SV6n(com.bumptech.glide.AMqCpz.CrfGsy(A4TApA(1, arrayList8, true), A2egSU(-90.0f)));
        f7076ADYaiT = A5SV6n(com.bumptech.glide.A5SV6n.DUi7mC(8, 0.8f, a2egSU));
        ArrayList arrayList9 = new ArrayList();
        arrayList9.add(new AcNBzu(new PointF(0.5f, 1.08f), new D8MqeW.A2egSU(0.085f, 0.0f)));
        arrayList9.add(new AcNBzu(new PointF(0.358f, 0.843f), new D8MqeW.A2egSU(0.085f, 0.0f)));
        A5SV6n(A4TApA(8, arrayList9, false));
        ArrayList arrayList10 = new ArrayList();
        arrayList10.add(new AcNBzu(new PointF(1.237f, 1.236f), new D8MqeW.A2egSU(0.258f, 0.0f)));
        arrayList10.add(new AcNBzu(new PointF(0.5f, 0.918f), new D8MqeW.A2egSU(0.233f, 0.0f)));
        AMqCpz = A5SV6n(A4TApA(4, arrayList10, false));
        ArrayList arrayList11 = new ArrayList();
        arrayList11.add(new AcNBzu(new PointF(0.723f, 0.884f), new D8MqeW.A2egSU(0.394f, 0.0f)));
        arrayList11.add(new AcNBzu(new PointF(0.5f, 1.099f), new D8MqeW.A2egSU(0.398f, 0.0f)));
        A5SV6n(A4TApA(6, arrayList11, false));
        A5SV6n(com.bumptech.glide.AMqCpz.CrfGsy(com.bumptech.glide.A5SV6n.DUi7mC(7, 0.75f, a2egSU4), A2egSU(-90.0f)));
        f7077ARc23Z = A5SV6n(com.bumptech.glide.AMqCpz.CrfGsy(com.bumptech.glide.A5SV6n.DUi7mC(9, 0.8f, a2egSU4), A2egSU(-90.0f)));
        A5SV6n(com.bumptech.glide.AMqCpz.CrfGsy(com.bumptech.glide.A5SV6n.DUi7mC(12, 0.8f, a2egSU4), A2egSU(-90.0f)));
        ArrayList arrayList12 = new ArrayList();
        arrayList12.add(new AcNBzu(new PointF(0.5f, 0.0f), a2egSU5));
        arrayList12.add(new AcNBzu(new PointF(1.0f, 0.0f), a2egSU5));
        arrayList12.add(new AcNBzu(new PointF(1.0f, 1.14f), new D8MqeW.A2egSU(0.254f, 0.106f)));
        arrayList12.add(new AcNBzu(new PointF(0.575f, 0.906f), new D8MqeW.A2egSU(0.253f, 0.0f)));
        A5SV6n(A4TApA(1, arrayList12, true));
        ArrayList arrayList13 = new ArrayList();
        arrayList13.add(new AcNBzu(new PointF(0.5f, 0.074f)));
        arrayList13.add(new AcNBzu(new PointF(0.725f, -0.099f), new D8MqeW.A2egSU(0.476f, 0.0f)));
        A5SV6n(A4TApA(4, arrayList13, true));
        ArrayList arrayList14 = new ArrayList();
        arrayList14.add(new AcNBzu(new PointF(0.5f, 0.036f)));
        arrayList14.add(new AcNBzu(new PointF(0.758f, -0.101f), new D8MqeW.A2egSU(0.209f, 0.0f)));
        A5SV6n(A4TApA(8, arrayList14, false));
        ArrayList arrayList15 = new ArrayList();
        arrayList15.add(new AcNBzu(new PointF(0.5f, -0.006f), new D8MqeW.A2egSU(0.006f, 0.0f)));
        arrayList15.add(new AcNBzu(new PointF(0.592f, 0.158f), new D8MqeW.A2egSU(0.006f, 0.0f)));
        A5SV6n(A4TApA(12, arrayList15, false));
        ArrayList arrayList16 = new ArrayList();
        arrayList16.add(new AcNBzu(new PointF(0.193f, 0.277f), new D8MqeW.A2egSU(0.053f, 0.0f)));
        arrayList16.add(new AcNBzu(new PointF(0.176f, 0.055f), new D8MqeW.A2egSU(0.053f, 0.0f)));
        f7078ASJ6gh = A5SV6n(A4TApA(10, arrayList16, false));
        ArrayList arrayList17 = new ArrayList();
        arrayList17.add(new AcNBzu(new PointF(0.457f, 0.296f), new D8MqeW.A2egSU(0.007f, 0.0f)));
        arrayList17.add(new AcNBzu(new PointF(0.5f, -0.051f), new D8MqeW.A2egSU(0.007f, 0.0f)));
        A5SV6n(A4TApA(15, arrayList17, false));
        ArrayList arrayList18 = new ArrayList();
        arrayList18.add(new AcNBzu(new PointF(0.733f, 0.454f)));
        arrayList18.add(new AcNBzu(new PointF(0.839f, 0.437f), new D8MqeW.A2egSU(0.532f, 0.0f)));
        arrayList18.add(new AcNBzu(new PointF(0.949f, 0.449f), new D8MqeW.A2egSU(0.439f, 1.0f)));
        arrayList18.add(new AcNBzu(new PointF(0.998f, 0.478f), new D8MqeW.A2egSU(0.174f, 0.0f)));
        A5SV6n(A4TApA(16, arrayList18, true));
        ArrayList arrayList19 = new ArrayList();
        arrayList19.add(new AcNBzu(new PointF(0.37f, 0.187f)));
        arrayList19.add(new AcNBzu(new PointF(0.416f, 0.049f), new D8MqeW.A2egSU(0.381f, 0.0f)));
        arrayList19.add(new AcNBzu(new PointF(0.479f, 0.0f), new D8MqeW.A2egSU(0.095f, 0.0f)));
        A5SV6n(A4TApA(8, arrayList19, true));
        ArrayList arrayList20 = new ArrayList();
        arrayList20.add(new AcNBzu(new PointF(0.5f, 0.053f)));
        arrayList20.add(new AcNBzu(new PointF(0.545f, -0.04f), new D8MqeW.A2egSU(0.405f, 0.0f)));
        arrayList20.add(new AcNBzu(new PointF(0.67f, -0.035f), new D8MqeW.A2egSU(0.426f, 0.0f)));
        arrayList20.add(new AcNBzu(new PointF(0.717f, 0.066f), new D8MqeW.A2egSU(0.574f, 0.0f)));
        arrayList20.add(new AcNBzu(new PointF(0.722f, 0.128f)));
        arrayList20.add(new AcNBzu(new PointF(0.777f, 0.002f), new D8MqeW.A2egSU(0.36f, 0.0f)));
        arrayList20.add(new AcNBzu(new PointF(0.914f, 0.149f), new D8MqeW.A2egSU(0.66f, 0.0f)));
        arrayList20.add(new AcNBzu(new PointF(0.926f, 0.289f), new D8MqeW.A2egSU(0.66f, 0.0f)));
        arrayList20.add(new AcNBzu(new PointF(0.881f, 0.346f)));
        arrayList20.add(new AcNBzu(new PointF(0.94f, 0.344f), new D8MqeW.A2egSU(0.126f, 0.0f)));
        arrayList20.add(new AcNBzu(new PointF(1.003f, 0.437f), new D8MqeW.A2egSU(0.255f, 0.0f)));
        D8MqeW.B4ZgIw A4TApA2 = A4TApA(2, arrayList20, true);
        Matrix matrix2 = new Matrix();
        matrix2.setScale(1.0f, 0.742f);
        A5SV6n(com.bumptech.glide.AMqCpz.CrfGsy(A4TApA2, matrix2));
        ArrayList arrayList21 = new ArrayList();
        arrayList21.add(new AcNBzu(new PointF(0.87f, 0.13f), new D8MqeW.A2egSU(0.146f, 0.0f)));
        arrayList21.add(new AcNBzu(new PointF(0.818f, 0.357f)));
        arrayList21.add(new AcNBzu(new PointF(1.0f, 0.332f), new D8MqeW.A2egSU(0.853f, 0.0f)));
        A5SV6n(A4TApA(4, arrayList21, true));
        ArrayList arrayList22 = new ArrayList();
        arrayList22.add(new AcNBzu(new PointF(0.5f, 0.0f)));
        arrayList22.add(new AcNBzu(new PointF(0.704f, 0.0f)));
        arrayList22.add(new AcNBzu(new PointF(0.704f, 0.065f)));
        arrayList22.add(new AcNBzu(new PointF(0.843f, 0.065f)));
        arrayList22.add(new AcNBzu(new PointF(0.843f, 0.148f)));
        arrayList22.add(new AcNBzu(new PointF(0.926f, 0.148f)));
        arrayList22.add(new AcNBzu(new PointF(0.926f, 0.296f)));
        arrayList22.add(new AcNBzu(new PointF(1.0f, 0.296f)));
        A5SV6n(A4TApA(2, arrayList22, true));
        ArrayList arrayList23 = new ArrayList();
        arrayList23.add(new AcNBzu(new PointF(0.11f, 0.5f)));
        arrayList23.add(new AcNBzu(new PointF(0.113f, 0.0f)));
        arrayList23.add(new AcNBzu(new PointF(0.287f, 0.0f)));
        arrayList23.add(new AcNBzu(new PointF(0.287f, 0.087f)));
        arrayList23.add(new AcNBzu(new PointF(0.421f, 0.087f)));
        arrayList23.add(new AcNBzu(new PointF(0.421f, 0.17f)));
        arrayList23.add(new AcNBzu(new PointF(0.56f, 0.17f)));
        arrayList23.add(new AcNBzu(new PointF(0.56f, 0.265f)));
        arrayList23.add(new AcNBzu(new PointF(0.674f, 0.265f)));
        arrayList23.add(new AcNBzu(new PointF(0.675f, 0.344f)));
        arrayList23.add(new AcNBzu(new PointF(0.789f, 0.344f)));
        arrayList23.add(new AcNBzu(new PointF(0.789f, 0.439f)));
        arrayList23.add(new AcNBzu(new PointF(0.888f, 0.439f)));
        A5SV6n(A4TApA(1, arrayList23, true));
        ArrayList arrayList24 = new ArrayList();
        arrayList24.add(new AcNBzu(new PointF(0.796f, 0.5f)));
        arrayList24.add(new AcNBzu(new PointF(0.853f, 0.518f), a2egSU5));
        arrayList24.add(new AcNBzu(new PointF(0.992f, 0.631f), a2egSU5));
        arrayList24.add(new AcNBzu(new PointF(0.968f, 1.0f), a2egSU5));
        A5SV6n(A4TApA(2, arrayList24, true));
        ArrayList arrayList25 = new ArrayList();
        arrayList25.add(new AcNBzu(new PointF(0.5f, 0.268f), new D8MqeW.A2egSU(0.016f, 0.0f)));
        arrayList25.add(new AcNBzu(new PointF(0.792f, -0.066f), new D8MqeW.A2egSU(0.958f, 0.0f)));
        arrayList25.add(new AcNBzu(new PointF(1.064f, 0.276f), a2egSU5));
        arrayList25.add(new AcNBzu(new PointF(0.501f, 0.946f), new D8MqeW.A2egSU(0.129f, 0.0f)));
        A5SV6n(A4TApA(1, arrayList25, true));
        TBWBEI();
    }

    public static Matrix A2egSU(float f) {
        Matrix matrix = new Matrix();
        matrix.setRotate(f);
        return matrix;
    }

    public static D8MqeW.B4ZgIw A4TApA(int i, ArrayList arrayList, boolean z) {
        ArrayList arrayList2 = new ArrayList();
        arrayList2.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            PointF pointF = ((AcNBzu) it.next()).f7071A2egSU;
            pointF.offset(-0.5f, -0.5f);
            float atan2 = (float) Math.atan2(pointF.y, pointF.x);
            float hypot = (float) Math.hypot(pointF.x, pointF.y);
            pointF.x = atan2;
            pointF.y = hypot;
        }
        float f = (float) (6.283185307179586d / i);
        if (z) {
            int i2 = i * 2;
            float f2 = f / 2.0f;
            for (int i3 = 0; i3 < i2; i3++) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    boolean z2 = i3 % 2 != 0;
                    int size = z2 ? (arrayList.size() - 1) - i4 : i4;
                    AcNBzu acNBzu = (AcNBzu) arrayList.get(size);
                    if (size > 0 || !z2) {
                        arrayList2.add(new AcNBzu(new PointF((i3 * f2) + (z2 ? (((AcNBzu) arrayList.get(0)).f7071A2egSU.x * 2.0f) + (f2 - acNBzu.f7071A2egSU.x) : acNBzu.f7071A2egSU.x), acNBzu.f7071A2egSU.y), acNBzu.f7072A4TApA));
                    }
                }
            }
        } else {
            for (int i5 = 0; i5 < i; i5++) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    AcNBzu acNBzu2 = (AcNBzu) it2.next();
                    arrayList2.add(new AcNBzu(new PointF((i5 * f) + acNBzu2.f7071A2egSU.x, acNBzu2.f7071A2egSU.y), acNBzu2.f7072A4TApA));
                }
            }
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            PointF pointF2 = ((AcNBzu) it3.next()).f7071A2egSU;
            double d = 0.5f;
            float cos = (float) ((Math.cos(pointF2.x) * pointF2.y) + d);
            float sin = (float) ((Math.sin(pointF2.x) * pointF2.y) + d);
            pointF2.x = cos;
            pointF2.y = sin;
        }
        float[] fArr = new float[arrayList2.size() * 2];
        for (int i6 = 0; i6 < arrayList2.size(); i6++) {
            int i7 = i6 * 2;
            fArr[i7] = ((AcNBzu) arrayList2.get(i6)).f7071A2egSU.x;
            fArr[i7 + 1] = ((AcNBzu) arrayList2.get(i6)).f7071A2egSU.y;
        }
        ArrayList arrayList3 = new ArrayList();
        for (int i8 = 0; i8 < arrayList2.size(); i8++) {
            arrayList3.add(((AcNBzu) arrayList2.get(i8)).f7072A4TApA);
        }
        return NOd7IU.AlLFFp.A5SV6n(fArr, D8MqeW.A2egSU.f2008A5SV6n, arrayList3, 0.5f, 0.5f);
    }

    public static D8MqeW.B4ZgIw A5SV6n(D8MqeW.B4ZgIw b4ZgIw) {
        return ADYaiT(b4ZgIw, new RectF(0.0f, 0.0f, 1.0f, 1.0f));
    }

    public static D8MqeW.B4ZgIw ADYaiT(D8MqeW.B4ZgIw b4ZgIw, RectF rectF) {
        float[] fArr = new float[4];
        b4ZgIw.getClass();
        RFbdkT.A5SV6n a5SV6n = b4ZgIw.f2043A5SV6n;
        int A2egSU2 = a5SV6n.A2egSU();
        float f = 0.0f;
        int i = 0;
        while (true) {
            long j = b4ZgIw.f2042A4TApA;
            if (i >= A2egSU2) {
                float sqrt = (float) Math.sqrt(f);
                fArr[0] = JrXYwF.A4TApA.COJEAR(j) - sqrt;
                fArr[1] = JrXYwF.A4TApA.CQhlFr(j) - sqrt;
                fArr[2] = JrXYwF.A4TApA.COJEAR(j) + sqrt;
                fArr[3] = JrXYwF.A4TApA.CQhlFr(j) + sqrt;
                RectF rectF2 = new RectF(fArr[0], fArr[1], fArr[2], fArr[3]);
                float min = Math.min(rectF.width() / rectF2.width(), rectF.height() / rectF2.height());
                Matrix matrix = new Matrix();
                matrix.setScale(min, min);
                matrix.preTranslate(-rectF2.centerX(), -rectF2.centerY());
                matrix.postTranslate(rectF.centerX(), rectF.centerY());
                return com.bumptech.glide.AMqCpz.CrfGsy(b4ZgIw, matrix);
            }
            D8MqeW.A4TApA a4TApA = (D8MqeW.A4TApA) a5SV6n.get(i);
            float COJEAR2 = a4TApA.f2011A2egSU[0] - JrXYwF.A4TApA.COJEAR(j);
            float CQhlFr2 = a4TApA.f2011A2egSU[1] - JrXYwF.A4TApA.CQhlFr(j);
            float f2 = D8MqeW.B7CMnp.f2045A4TApA;
            long A5SV6n2 = a4TApA.A5SV6n(0.5f);
            float COJEAR3 = JrXYwF.A4TApA.COJEAR(A5SV6n2) - JrXYwF.A4TApA.COJEAR(j);
            float CQhlFr3 = JrXYwF.A4TApA.CQhlFr(A5SV6n2) - JrXYwF.A4TApA.CQhlFr(j);
            f = Math.max(f, Math.max((CQhlFr2 * CQhlFr2) + (COJEAR2 * COJEAR2), (CQhlFr3 * CQhlFr3) + (COJEAR3 * COJEAR3)));
            i++;
        }
    }

    private static /* synthetic */ void TBWBEI() {
        char[] charArray = "\u0002\u000e\fO\u0006\u0000\f\u0004O\u0003\u000e\u0018O\u0012\t\u0004\r\rO+\u000f\b#\u0013\b\u0005\u0006\u0004".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'a');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0002\r\b\u000f\b\u0015".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'a');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}

package PCV8se;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class BJ7GGh {

    /* renamed from: A2egSU, reason: collision with root package name */
    public float f7128A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public float f7129A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public float f7130A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public float f7131ADYaiT;
    public float AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public float f7132ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final ArrayList f7133ASJ6gh = new ArrayList();

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final ArrayList f7134AYUAbz = new ArrayList();

    public static class A2egSU extends A4TApA {

        /* renamed from: A4TApA, reason: collision with root package name */
        public float f7135A4TApA;

        /* renamed from: A5SV6n, reason: collision with root package name */
        public float f7136A5SV6n;

        @Override // PCV8se.BJ7GGh.A4TApA
        public final void A2egSU(Matrix matrix, Path path) {
            Matrix matrix2 = this.f7137A2egSU;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f7135A4TApA, this.f7136A5SV6n);
            path.transform(matrix);
        }
    }

    public static abstract class A4TApA {

        /* renamed from: A2egSU, reason: collision with root package name */
        public final Matrix f7137A2egSU = new Matrix();

        public abstract void A2egSU(Matrix matrix, Path path);
    }

    public BJ7GGh() {
        ADYaiT(0.0f, 0.0f, 270.0f, 0.0f);
    }

    public final void A2egSU(float f) {
        float f2 = this.AMqCpz;
        if (f2 == f) {
            return;
        }
        float f3 = ((f - f2) + 360.0f) % 360.0f;
        if (f3 > 180.0f) {
            return;
        }
        float f4 = this.f7130A5SV6n;
        float f5 = this.f7131ADYaiT;
        BIYEnU bIYEnU = new BIYEnU(f4, f5, f4, f5);
        bIYEnU.f7126ARc23Z = this.AMqCpz;
        bIYEnU.f7127ASJ6gh = f3;
        this.f7134AYUAbz.add(new BChYOn(bIYEnU));
        this.AMqCpz = f;
    }

    public final void A4TApA(Matrix matrix, Path path) {
        ArrayList arrayList = this.f7133ASJ6gh;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((A4TApA) arrayList.get(i)).A2egSU(matrix, path);
        }
    }

    public final void A5SV6n(float f, float f2) {
        A2egSU a2egSU = new A2egSU();
        a2egSU.f7135A4TApA = f;
        a2egSU.f7136A5SV6n = f2;
        this.f7133ASJ6gh.add(a2egSU);
        BI9f7h bI9f7h = new BI9f7h(a2egSU, this.f7130A5SV6n, this.f7131ADYaiT);
        float A4TApA2 = bI9f7h.A4TApA() + 270.0f;
        float A4TApA3 = bI9f7h.A4TApA() + 270.0f;
        A2egSU(A4TApA2);
        this.f7134AYUAbz.add(bI9f7h);
        this.AMqCpz = A4TApA3;
        this.f7130A5SV6n = f;
        this.f7131ADYaiT = f2;
    }

    public final void ADYaiT(float f, float f2, float f3, float f4) {
        this.f7128A2egSU = f;
        this.f7129A4TApA = f2;
        this.f7130A5SV6n = f;
        this.f7131ADYaiT = f2;
        this.AMqCpz = f3;
        this.f7132ARc23Z = (f3 + f4) % 360.0f;
        this.f7133ASJ6gh.clear();
        this.f7134AYUAbz.clear();
    }
}

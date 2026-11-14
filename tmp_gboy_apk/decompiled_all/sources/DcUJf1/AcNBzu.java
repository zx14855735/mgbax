package DcUJf1;

import android.graphics.Matrix;
import android.graphics.Paint;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AcNBzu extends AlLFFp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Matrix f2342A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ArrayList f2343A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public float f2344A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public float f2345ADYaiT;
    public float AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public float f2346ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public float f2347ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public float f2348AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public float f2349AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public final Matrix f2350AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public String f2351AaHO0E;

    public AcNBzu() {
        this.f2342A2egSU = new Matrix();
        this.f2343A4TApA = new ArrayList();
        this.f2344A5SV6n = 0.0f;
        this.f2345ADYaiT = 0.0f;
        this.AMqCpz = 0.0f;
        this.f2346ARc23Z = 1.0f;
        this.f2347ASJ6gh = 1.0f;
        this.f2348AYUAbz = 0.0f;
        this.f2349AZOQYO = 0.0f;
        this.f2350AZkASS = new Matrix();
        this.f2351AaHO0E = null;
    }

    @Override // DcUJf1.AlLFFp
    public final boolean A2egSU() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f2343A4TApA;
            if (i >= arrayList.size()) {
                return false;
            }
            if (((AlLFFp) arrayList.get(i)).A2egSU()) {
                return true;
            }
            i++;
        }
    }

    @Override // DcUJf1.AlLFFp
    public final boolean A4TApA(int[] iArr) {
        int i = 0;
        boolean z = false;
        while (true) {
            ArrayList arrayList = this.f2343A4TApA;
            if (i >= arrayList.size()) {
                return z;
            }
            z |= ((AlLFFp) arrayList.get(i)).A4TApA(iArr);
            i++;
        }
    }

    public final void A5SV6n() {
        Matrix matrix = this.f2350AZkASS;
        matrix.reset();
        matrix.postTranslate(-this.f2345ADYaiT, -this.AMqCpz);
        matrix.postScale(this.f2346ARc23Z, this.f2347ASJ6gh);
        matrix.postRotate(this.f2344A5SV6n, 0.0f, 0.0f);
        matrix.postTranslate(this.f2348AYUAbz + this.f2345ADYaiT, this.f2349AZOQYO + this.AMqCpz);
    }

    public String getGroupName() {
        return this.f2351AaHO0E;
    }

    public Matrix getLocalMatrix() {
        return this.f2350AZkASS;
    }

    public float getPivotX() {
        return this.f2345ADYaiT;
    }

    public float getPivotY() {
        return this.AMqCpz;
    }

    public float getRotation() {
        return this.f2344A5SV6n;
    }

    public float getScaleX() {
        return this.f2346ARc23Z;
    }

    public float getScaleY() {
        return this.f2347ASJ6gh;
    }

    public float getTranslateX() {
        return this.f2348AYUAbz;
    }

    public float getTranslateY() {
        return this.f2349AZOQYO;
    }

    public void setPivotX(float f) {
        if (f != this.f2345ADYaiT) {
            this.f2345ADYaiT = f;
            A5SV6n();
        }
    }

    public void setPivotY(float f) {
        if (f != this.AMqCpz) {
            this.AMqCpz = f;
            A5SV6n();
        }
    }

    public void setRotation(float f) {
        if (f != this.f2344A5SV6n) {
            this.f2344A5SV6n = f;
            A5SV6n();
        }
    }

    public void setScaleX(float f) {
        if (f != this.f2346ARc23Z) {
            this.f2346ARc23Z = f;
            A5SV6n();
        }
    }

    public void setScaleY(float f) {
        if (f != this.f2347ASJ6gh) {
            this.f2347ASJ6gh = f;
            A5SV6n();
        }
    }

    public void setTranslateX(float f) {
        if (f != this.f2348AYUAbz) {
            this.f2348AYUAbz = f;
            A5SV6n();
        }
    }

    public void setTranslateY(float f) {
        if (f != this.f2349AZOQYO) {
            this.f2349AZOQYO = f;
            A5SV6n();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AcNBzu(AcNBzu acNBzu, B25kr6.ADYaiT aDYaiT) {
        AZkASS aZkASS;
        this.f2342A2egSU = new Matrix();
        this.f2343A4TApA = new ArrayList();
        this.f2344A5SV6n = 0.0f;
        this.f2345ADYaiT = 0.0f;
        this.AMqCpz = 0.0f;
        this.f2346ARc23Z = 1.0f;
        this.f2347ASJ6gh = 1.0f;
        this.f2348AYUAbz = 0.0f;
        this.f2349AZOQYO = 0.0f;
        Matrix matrix = new Matrix();
        this.f2350AZkASS = matrix;
        this.f2351AaHO0E = null;
        this.f2344A5SV6n = acNBzu.f2344A5SV6n;
        this.f2345ADYaiT = acNBzu.f2345ADYaiT;
        this.AMqCpz = acNBzu.AMqCpz;
        this.f2346ARc23Z = acNBzu.f2346ARc23Z;
        this.f2347ASJ6gh = acNBzu.f2347ASJ6gh;
        this.f2348AYUAbz = acNBzu.f2348AYUAbz;
        this.f2349AZOQYO = acNBzu.f2349AZOQYO;
        String str = acNBzu.f2351AaHO0E;
        this.f2351AaHO0E = str;
        if (str != null) {
            aDYaiT.put(str, this);
        }
        matrix.set(acNBzu.f2350AZkASS);
        ArrayList arrayList = acNBzu.f2343A4TApA;
        for (int i = 0; i < arrayList.size(); i++) {
            Object obj = arrayList.get(i);
            if (obj instanceof AcNBzu) {
                this.f2343A4TApA.add(new AcNBzu((AcNBzu) obj, aDYaiT));
            } else {
                if (obj instanceof AaHO0E) {
                    AaHO0E aaHO0E = (AaHO0E) obj;
                    AaHO0E aaHO0E2 = new AaHO0E(aaHO0E);
                    aaHO0E2.AMqCpz = 0.0f;
                    aaHO0E2.f2334ASJ6gh = 1.0f;
                    aaHO0E2.f2335AYUAbz = 1.0f;
                    aaHO0E2.f2336AZOQYO = 0.0f;
                    aaHO0E2.f2337AZkASS = 1.0f;
                    aaHO0E2.f2338AaHO0E = 0.0f;
                    aaHO0E2.f2339AcNBzu = Paint.Cap.BUTT;
                    aaHO0E2.f2340AlLFFp = Paint.Join.MITER;
                    aaHO0E2.f2341AmA8tU = 4.0f;
                    aaHO0E2.f2332ADYaiT = aaHO0E.f2332ADYaiT;
                    aaHO0E2.AMqCpz = aaHO0E.AMqCpz;
                    aaHO0E2.f2334ASJ6gh = aaHO0E.f2334ASJ6gh;
                    aaHO0E2.f2333ARc23Z = aaHO0E.f2333ARc23Z;
                    aaHO0E2.f2354A5SV6n = aaHO0E.f2354A5SV6n;
                    aaHO0E2.f2335AYUAbz = aaHO0E.f2335AYUAbz;
                    aaHO0E2.f2336AZOQYO = aaHO0E.f2336AZOQYO;
                    aaHO0E2.f2337AZkASS = aaHO0E.f2337AZkASS;
                    aaHO0E2.f2338AaHO0E = aaHO0E.f2338AaHO0E;
                    aaHO0E2.f2339AcNBzu = aaHO0E.f2339AcNBzu;
                    aaHO0E2.f2340AlLFFp = aaHO0E.f2340AlLFFp;
                    aaHO0E2.f2341AmA8tU = aaHO0E.f2341AmA8tU;
                    aZkASS = aaHO0E2;
                } else if (obj instanceof AZkASS) {
                    aZkASS = new AZkASS((AZkASS) obj);
                } else {
                    throw new IllegalStateException("Unknown object in the tree!");
                }
                this.f2343A4TApA.add(aZkASS);
                Object obj2 = aZkASS.f2353A4TApA;
                if (obj2 != null) {
                    aDYaiT.put(obj2, aZkASS);
                }
            }
        }
    }
}

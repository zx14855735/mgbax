package DcUJf1;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh implements TypeEvaluator {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f2328A2egSU = 0;

    /* renamed from: A4TApA, reason: collision with root package name */
    public Object f2329A4TApA;

    public /* synthetic */ ASJ6gh() {
    }

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f, Object obj, Object obj2) {
        switch (this.f2328A2egSU) {
            case 0:
                BV3sI0.ARc23Z[] aRc23ZArr = (BV3sI0.ARc23Z[]) obj;
                BV3sI0.ARc23Z[] aRc23ZArr2 = (BV3sI0.ARc23Z[]) obj2;
                if (!com.bumptech.glide.AMqCpz.B25kr6(aRc23ZArr, aRc23ZArr2)) {
                    throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
                }
                if (!com.bumptech.glide.AMqCpz.B25kr6((BV3sI0.ARc23Z[]) this.f2329A4TApA, aRc23ZArr)) {
                    this.f2329A4TApA = com.bumptech.glide.AMqCpz.BIYEnU(aRc23ZArr);
                }
                for (int i = 0; i < aRc23ZArr.length; i++) {
                    BV3sI0.ARc23Z aRc23Z = ((BV3sI0.ARc23Z[]) this.f2329A4TApA)[i];
                    BV3sI0.ARc23Z aRc23Z2 = aRc23ZArr[i];
                    BV3sI0.ARc23Z aRc23Z3 = aRc23ZArr2[i];
                    aRc23Z.getClass();
                    aRc23Z.f1487A2egSU = aRc23Z2.f1487A2egSU;
                    int i2 = 0;
                    while (true) {
                        float[] fArr = aRc23Z2.f1488A4TApA;
                        if (i2 < fArr.length) {
                            aRc23Z.f1488A4TApA[i2] = (aRc23Z3.f1488A4TApA[i2] * f) + ((1.0f - f) * fArr[i2]);
                            i2++;
                        }
                    }
                }
                return (BV3sI0.ARc23Z[]) this.f2329A4TApA;
            default:
                Rect rect = (Rect) obj;
                Rect rect2 = (Rect) obj2;
                int i3 = rect.left + ((int) ((rect2.left - r0) * f));
                int i4 = rect.top + ((int) ((rect2.top - r1) * f));
                int i5 = rect.right + ((int) ((rect2.right - r2) * f));
                int i6 = rect.bottom + ((int) ((rect2.bottom - r10) * f));
                Rect rect3 = (Rect) this.f2329A4TApA;
                rect3.set(i3, i4, i5, i6);
                return rect3;
        }
    }

    public ASJ6gh(Rect rect) {
        this.f2329A4TApA = rect;
    }
}

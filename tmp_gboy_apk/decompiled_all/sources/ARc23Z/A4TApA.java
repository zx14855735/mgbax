package ARc23Z;

import B25kr6.B25kr6;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA extends AaHO0E {

    /* renamed from: CNPG0E, reason: collision with root package name */
    public B25kr6.AYUAbz f276CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public B25kr6 f277COJEAR;

    public A4TApA(A4TApA a4TApA, AMqCpz aMqCpz, Resources resources) {
        super(a4TApA, aMqCpz, resources);
        if (a4TApA != null) {
            this.f276CNPG0E = a4TApA.f276CNPG0E;
            this.f277COJEAR = a4TApA.f277COJEAR;
        } else {
            this.f276CNPG0E = new B25kr6.AYUAbz();
            this.f277COJEAR = new B25kr6();
        }
    }

    @Override // ARc23Z.AaHO0E
    public final void ARc23Z() {
        this.f276CNPG0E = this.f276CNPG0E.clone();
        this.f277COJEAR = this.f277COJEAR.clone();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v3 */
    public final int ASJ6gh(int i) {
        ?? r5;
        if (i < 0) {
            return 0;
        }
        B25kr6 b25kr6 = this.f277COJEAR;
        int i2 = 0;
        int A2egSU2 = B2KMhB.A2egSU.A2egSU(b25kr6.f1015AzWtSf, i, b25kr6.f1013AlLFFp);
        if (A2egSU2 >= 0 && (r5 = b25kr6.f1014AmA8tU[A2egSU2]) != B25kr6.AZOQYO.f993A4TApA) {
            i2 = r5;
        }
        return i2.intValue();
    }

    @Override // ARc23Z.AaHO0E, android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new AMqCpz(this, null);
    }

    @Override // ARc23Z.AaHO0E, android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        return new AMqCpz(this, resources);
    }
}

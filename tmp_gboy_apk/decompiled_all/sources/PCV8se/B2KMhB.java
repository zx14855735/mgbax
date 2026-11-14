package PCV8se;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.android.material.R$styleable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class B2KMhB {

    /* renamed from: A2egSU, reason: collision with root package name */
    public AMqCpz f7083A2egSU = new B25kr6();

    /* renamed from: A4TApA, reason: collision with root package name */
    public AMqCpz f7084A4TApA = new B25kr6();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public AMqCpz f7085A5SV6n = new B25kr6();

    /* renamed from: ADYaiT, reason: collision with root package name */
    public AMqCpz f7086ADYaiT = new B25kr6();
    public ADYaiT AMqCpz = new PCV8se.A2egSU(0.0f);

    /* renamed from: ARc23Z, reason: collision with root package name */
    public ADYaiT f7087ARc23Z = new PCV8se.A2egSU(0.0f);

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public ADYaiT f7088ASJ6gh = new PCV8se.A2egSU(0.0f);

    /* renamed from: AYUAbz, reason: collision with root package name */
    public ADYaiT f7089AYUAbz = new PCV8se.A2egSU(0.0f);

    /* renamed from: AZOQYO, reason: collision with root package name */
    public ASJ6gh f7090AZOQYO = new ASJ6gh();

    /* renamed from: AZkASS, reason: collision with root package name */
    public ASJ6gh f7091AZkASS = new ASJ6gh();

    /* renamed from: AaHO0E, reason: collision with root package name */
    public ASJ6gh f7092AaHO0E = new ASJ6gh();

    /* renamed from: AcNBzu, reason: collision with root package name */
    public ASJ6gh f7093AcNBzu = new ASJ6gh();

    public static final class A2egSU {

        /* renamed from: A2egSU, reason: collision with root package name */
        public AMqCpz f7094A2egSU = new B25kr6();

        /* renamed from: A4TApA, reason: collision with root package name */
        public AMqCpz f7095A4TApA = new B25kr6();

        /* renamed from: A5SV6n, reason: collision with root package name */
        public AMqCpz f7096A5SV6n = new B25kr6();

        /* renamed from: ADYaiT, reason: collision with root package name */
        public AMqCpz f7097ADYaiT = new B25kr6();
        public ADYaiT AMqCpz = new PCV8se.A2egSU(0.0f);

        /* renamed from: ARc23Z, reason: collision with root package name */
        public ADYaiT f7098ARc23Z = new PCV8se.A2egSU(0.0f);

        /* renamed from: ASJ6gh, reason: collision with root package name */
        public ADYaiT f7099ASJ6gh = new PCV8se.A2egSU(0.0f);

        /* renamed from: AYUAbz, reason: collision with root package name */
        public ADYaiT f7100AYUAbz = new PCV8se.A2egSU(0.0f);

        /* renamed from: AZOQYO, reason: collision with root package name */
        public ASJ6gh f7101AZOQYO = new ASJ6gh();

        /* renamed from: AZkASS, reason: collision with root package name */
        public ASJ6gh f7102AZkASS = new ASJ6gh();

        /* renamed from: AaHO0E, reason: collision with root package name */
        public ASJ6gh f7103AaHO0E = new ASJ6gh();

        /* renamed from: AcNBzu, reason: collision with root package name */
        public ASJ6gh f7104AcNBzu = new ASJ6gh();

        public static float A4TApA(AMqCpz aMqCpz) {
            if (aMqCpz instanceof B25kr6) {
                return ((B25kr6) aMqCpz).f7082A2egSU;
            }
            if (aMqCpz instanceof ARc23Z) {
                return ((ARc23Z) aMqCpz).f7019A2egSU;
            }
            return -1.0f;
        }

        public final B2KMhB A2egSU() {
            B2KMhB b2KMhB = new B2KMhB();
            b2KMhB.f7083A2egSU = this.f7094A2egSU;
            b2KMhB.f7084A4TApA = this.f7095A4TApA;
            b2KMhB.f7085A5SV6n = this.f7096A5SV6n;
            b2KMhB.f7086ADYaiT = this.f7097ADYaiT;
            b2KMhB.AMqCpz = this.AMqCpz;
            b2KMhB.f7087ARc23Z = this.f7098ARc23Z;
            b2KMhB.f7088ASJ6gh = this.f7099ASJ6gh;
            b2KMhB.f7089AYUAbz = this.f7100AYUAbz;
            b2KMhB.f7090AZOQYO = this.f7101AZOQYO;
            b2KMhB.f7091AZkASS = this.f7102AZkASS;
            b2KMhB.f7092AaHO0E = this.f7103AaHO0E;
            b2KMhB.f7093AcNBzu = this.f7104AcNBzu;
            return b2KMhB;
        }

        public final void A5SV6n(float f) {
            ARc23Z(f);
            ASJ6gh(f);
            AMqCpz(f);
            ADYaiT(f);
        }

        public final void ADYaiT(float f) {
            this.f7100AYUAbz = new PCV8se.A2egSU(f);
        }

        public final void AMqCpz(float f) {
            this.f7099ASJ6gh = new PCV8se.A2egSU(f);
        }

        public final void ARc23Z(float f) {
            this.AMqCpz = new PCV8se.A2egSU(f);
        }

        public final void ASJ6gh(float f) {
            this.f7098ARc23Z = new PCV8se.A2egSU(f);
        }
    }

    public static A2egSU A2egSU(Context context, int i, int i2) {
        return A4TApA(context, i, i2, new PCV8se.A2egSU(0));
    }

    public static A2egSU A4TApA(Context context, int i, int i2, PCV8se.A2egSU a2egSU) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
        if (i2 != 0) {
            contextThemeWrapper.getTheme().applyStyle(i2, true);
        }
        TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R$styleable.f11255CqNSpT);
        try {
            int i3 = obtainStyledAttributes.getInt(0, 0);
            int i4 = obtainStyledAttributes.getInt(3, i3);
            int i5 = obtainStyledAttributes.getInt(4, i3);
            int i6 = obtainStyledAttributes.getInt(2, i3);
            int i7 = obtainStyledAttributes.getInt(1, i3);
            ADYaiT ADYaiT2 = ADYaiT(obtainStyledAttributes, 5, a2egSU);
            ADYaiT ADYaiT3 = ADYaiT(obtainStyledAttributes, 8, ADYaiT2);
            ADYaiT ADYaiT4 = ADYaiT(obtainStyledAttributes, 9, ADYaiT2);
            ADYaiT ADYaiT5 = ADYaiT(obtainStyledAttributes, 7, ADYaiT2);
            ADYaiT ADYaiT6 = ADYaiT(obtainStyledAttributes, 6, ADYaiT2);
            A2egSU a2egSU2 = new A2egSU();
            AMqCpz BV3sI02 = NOd7IU.AlLFFp.BV3sI0(i4);
            a2egSU2.f7094A2egSU = BV3sI02;
            float A4TApA2 = A2egSU.A4TApA(BV3sI02);
            if (A4TApA2 != -1.0f) {
                a2egSU2.ARc23Z(A4TApA2);
            }
            a2egSU2.AMqCpz = ADYaiT3;
            AMqCpz BV3sI03 = NOd7IU.AlLFFp.BV3sI0(i5);
            a2egSU2.f7095A4TApA = BV3sI03;
            float A4TApA3 = A2egSU.A4TApA(BV3sI03);
            if (A4TApA3 != -1.0f) {
                a2egSU2.ASJ6gh(A4TApA3);
            }
            a2egSU2.f7098ARc23Z = ADYaiT4;
            AMqCpz BV3sI04 = NOd7IU.AlLFFp.BV3sI0(i6);
            a2egSU2.f7096A5SV6n = BV3sI04;
            float A4TApA4 = A2egSU.A4TApA(BV3sI04);
            if (A4TApA4 != -1.0f) {
                a2egSU2.AMqCpz(A4TApA4);
            }
            a2egSU2.f7099ASJ6gh = ADYaiT5;
            AMqCpz BV3sI05 = NOd7IU.AlLFFp.BV3sI0(i7);
            a2egSU2.f7097ADYaiT = BV3sI05;
            float A4TApA5 = A2egSU.A4TApA(BV3sI05);
            if (A4TApA5 != -1.0f) {
                a2egSU2.ADYaiT(A4TApA5);
            }
            a2egSU2.f7100AYUAbz = ADYaiT6;
            return a2egSU2;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static A2egSU A5SV6n(Context context, AttributeSet attributeSet, int i, int i2) {
        PCV8se.A2egSU a2egSU = new PCV8se.A2egSU(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f11241BniPrB, i, i2);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        return A4TApA(context, resourceId, resourceId2, a2egSU);
    }

    public static ADYaiT ADYaiT(TypedArray typedArray, int i, ADYaiT aDYaiT) {
        TypedValue peekValue = typedArray.peekValue(i);
        if (peekValue != null) {
            int i2 = peekValue.type;
            if (i2 == 5) {
                return new PCV8se.A2egSU(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i2 == 6) {
                return new AzWtSf(peekValue.getFraction(1.0f, 1.0f));
            }
        }
        return aDYaiT;
    }

    public final boolean AMqCpz() {
        return (this.f7084A4TApA instanceof B25kr6) && (this.f7083A2egSU instanceof B25kr6) && (this.f7085A5SV6n instanceof B25kr6) && (this.f7086ADYaiT instanceof B25kr6);
    }

    public final boolean ARc23Z(RectF rectF) {
        boolean z = this.f7093AcNBzu.getClass().equals(ASJ6gh.class) && this.f7091AZkASS.getClass().equals(ASJ6gh.class) && this.f7090AZOQYO.getClass().equals(ASJ6gh.class) && this.f7092AaHO0E.getClass().equals(ASJ6gh.class);
        float A2egSU2 = this.AMqCpz.A2egSU(rectF);
        return z && ((this.f7087ARc23Z.A2egSU(rectF) > A2egSU2 ? 1 : (this.f7087ARc23Z.A2egSU(rectF) == A2egSU2 ? 0 : -1)) == 0 && (this.f7089AYUAbz.A2egSU(rectF) > A2egSU2 ? 1 : (this.f7089AYUAbz.A2egSU(rectF) == A2egSU2 ? 0 : -1)) == 0 && (this.f7088ASJ6gh.A2egSU(rectF) > A2egSU2 ? 1 : (this.f7088ASJ6gh.A2egSU(rectF) == A2egSU2 ? 0 : -1)) == 0) && AMqCpz();
    }

    public final A2egSU ASJ6gh() {
        A2egSU a2egSU = new A2egSU();
        a2egSU.f7094A2egSU = new B25kr6();
        a2egSU.f7095A4TApA = new B25kr6();
        a2egSU.f7096A5SV6n = new B25kr6();
        a2egSU.f7097ADYaiT = new B25kr6();
        a2egSU.AMqCpz = new PCV8se.A2egSU(0.0f);
        a2egSU.f7098ARc23Z = new PCV8se.A2egSU(0.0f);
        a2egSU.f7099ASJ6gh = new PCV8se.A2egSU(0.0f);
        a2egSU.f7100AYUAbz = new PCV8se.A2egSU(0.0f);
        a2egSU.f7101AZOQYO = new ASJ6gh();
        a2egSU.f7102AZkASS = new ASJ6gh();
        a2egSU.f7103AaHO0E = new ASJ6gh();
        new ASJ6gh();
        a2egSU.f7094A2egSU = this.f7083A2egSU;
        a2egSU.f7095A4TApA = this.f7084A4TApA;
        a2egSU.f7096A5SV6n = this.f7085A5SV6n;
        a2egSU.f7097ADYaiT = this.f7086ADYaiT;
        a2egSU.AMqCpz = this.AMqCpz;
        a2egSU.f7098ARc23Z = this.f7087ARc23Z;
        a2egSU.f7099ASJ6gh = this.f7088ASJ6gh;
        a2egSU.f7100AYUAbz = this.f7089AYUAbz;
        a2egSU.f7101AZOQYO = this.f7090AZOQYO;
        a2egSU.f7102AZkASS = this.f7091AZkASS;
        a2egSU.f7103AaHO0E = this.f7092AaHO0E;
        a2egSU.f7104AcNBzu = this.f7093AcNBzu;
        return a2egSU;
    }

    public final B2KMhB AYUAbz(B3GDIM b3gdim) {
        A2egSU ASJ6gh2 = ASJ6gh();
        ASJ6gh2.AMqCpz = b3gdim.ARc23Z(this.AMqCpz);
        ASJ6gh2.f7098ARc23Z = b3gdim.ARc23Z(this.f7087ARc23Z);
        ASJ6gh2.f7100AYUAbz = b3gdim.ARc23Z(this.f7089AYUAbz);
        ASJ6gh2.f7099ASJ6gh = b3gdim.ARc23Z(this.f7088ASJ6gh);
        return ASJ6gh2.A2egSU();
    }

    public final String toString() {
        return "[" + this.AMqCpz + ", " + this.f7087ARc23Z + ", " + this.f7088ASJ6gh + ", " + this.f7089AYUAbz + "]";
    }
}

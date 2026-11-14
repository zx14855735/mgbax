package androidx.fragment.app;

import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class DXuj49 {

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f8918A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f8919A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f8920ADYaiT;
    public int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f8921ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public boolean f8922ASJ6gh;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public String f8924AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public int f8925AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public CharSequence f8926AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f8927AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public CharSequence f8928AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public ArrayList f8929AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public ArrayList f8930AzWtSf;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public ArrayList f8932B2KMhB;

    /* renamed from: A2egSU, reason: collision with root package name */
    public ArrayList f8917A2egSU = new ArrayList();

    /* renamed from: AYUAbz, reason: collision with root package name */
    public boolean f8923AYUAbz = true;

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f8931B25kr6 = false;

    @Deprecated
    public DXuj49() {
    }

    public final void A4TApA(DXnQ0V dXnQ0V) {
        this.f8917A2egSU.add(dXnQ0V);
        dXnQ0V.f8912ADYaiT = this.f8918A4TApA;
        dXnQ0V.AMqCpz = this.f8919A5SV6n;
        dXnQ0V.f8913ARc23Z = this.f8920ADYaiT;
        dXnQ0V.f8914ASJ6gh = this.AMqCpz;
    }

    public abstract int A5SV6n();

    public abstract int ADYaiT();

    public abstract void AMqCpz();

    public abstract void ARc23Z();

    public void ASJ6gh(Fragment fragment) {
        A4TApA(new DXnQ0V(fragment, 6));
    }

    public final void AYUAbz() {
        if (this.f8922ASJ6gh) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f8923AYUAbz = false;
    }

    public void AZOQYO(int i, Fragment fragment, String str, int i2) {
        String str2 = fragment.mPreviousWho;
        if (str2 != null) {
            D6yqiO.ADYaiT.A5SV6n(fragment, str2);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = fragment.mTag;
            if (str3 != null && !str.equals(str3)) {
                StringBuilder sb = new StringBuilder("Can't change tag of fragment ");
                sb.append(fragment);
                sb.append(": was ");
                throw new IllegalStateException(J3FDQU.A2egSU.B3GDIM(sb, fragment.mTag, " now ", str));
            }
            fragment.mTag = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i3 = fragment.mFragmentId;
            if (i3 != 0 && i3 != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
            }
            fragment.mFragmentId = i;
            fragment.mContainerId = i;
        }
        A4TApA(new DXnQ0V(fragment, i2));
    }

    public void AZkASS(Fragment fragment) {
        A4TApA(new DXnQ0V(fragment, 4));
    }

    public boolean AaHO0E() {
        return this.f8917A2egSU.isEmpty();
    }

    public void AcNBzu(Fragment fragment) {
        A4TApA(new DXnQ0V(fragment, 3));
    }

    public final void AlLFFp(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        AZOQYO(i, fragment, str, 2);
    }

    public void AmA8tU(Fragment fragment) {
        A4TApA(new DXnQ0V(fragment, 8));
    }

    public void AzWtSf(Fragment fragment) {
        A4TApA(new DXnQ0V(fragment, 5));
    }
}

package QkAq4X;

import java.lang.reflect.Array;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public ASJ6gh f7720A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public ASJ6gh f7721A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public B25kr6.A5SV6n f7722A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ int f7723ADYaiT;
    public final Object AMqCpz;

    public /* synthetic */ A2egSU(int i, Object obj) {
        this.f7723ADYaiT = i;
        this.AMqCpz = obj;
    }

    public static boolean AMqCpz(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (set.size() == set2.size()) {
                return set.containsAll(set2);
            }
            return false;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public final int A2egSU() {
        switch (this.f7723ADYaiT) {
            case 0:
                return ((A4TApA) this.AMqCpz).f7752AmA8tU;
            default:
                return ((A5SV6n) this.AMqCpz).f7733AmA8tU;
        }
    }

    public final int A4TApA(Object obj) {
        switch (this.f7723ADYaiT) {
            case 0:
                A4TApA a4TApA = (A4TApA) this.AMqCpz;
                if (obj == null) {
                    return a4TApA.A2egSU();
                }
                a4TApA.getClass();
                return a4TApA.A4TApA(obj.hashCode(), obj);
            default:
                return ((A5SV6n) this.AMqCpz).A5SV6n(obj);
        }
    }

    public final Object A5SV6n(int i, int i2) {
        switch (this.f7723ADYaiT) {
            case 0:
                return ((A4TApA) this.AMqCpz).f7751AlLFFp[(i << 1) + i2];
            default:
                return ((A5SV6n) this.AMqCpz).f7732AlLFFp[i];
        }
    }

    public final void ADYaiT(int i) {
        switch (this.f7723ADYaiT) {
            case 0:
                ((A4TApA) this.AMqCpz).ASJ6gh(i);
                break;
            default:
                ((A5SV6n) this.AMqCpz).AMqCpz(i);
                break;
        }
    }

    public final Object[] ARc23Z(Object[] objArr, int i) {
        int A2egSU2 = A2egSU();
        if (objArr.length < A2egSU2) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), A2egSU2);
        }
        for (int i2 = 0; i2 < A2egSU2; i2++) {
            objArr[i2] = A5SV6n(i2, i);
        }
        if (objArr.length > A2egSU2) {
            objArr[A2egSU2] = null;
        }
        return objArr;
    }

    public final int ASJ6gh(Object obj) {
        switch (this.f7723ADYaiT) {
            case 0:
                return ((A4TApA) this.AMqCpz).AMqCpz(obj);
            default:
                return ((A5SV6n) this.AMqCpz).A5SV6n(obj);
        }
    }

    public final Map AYUAbz() {
        switch (this.f7723ADYaiT) {
            case 0:
                return (A4TApA) this.AMqCpz;
            default:
                throw new UnsupportedOperationException("not a map");
        }
    }

    public final void AZOQYO() {
        switch (this.f7723ADYaiT) {
            case 0:
                ((A4TApA) this.AMqCpz).clear();
                break;
            default:
                ((A5SV6n) this.AMqCpz).clear();
                break;
        }
    }
}

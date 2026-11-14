package HZUvgL;

import android.util.Log;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AaHO0E implements A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final K1Z3yj.A2egSU f3663A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final AZkASS f3664A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final HashMap f3665A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final HashMap f3666ADYaiT;
    public final int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f3667ARc23Z;

    public AaHO0E() {
        this.f3663A2egSU = new K1Z3yj.A2egSU(28);
        this.f3664A4TApA = new AZkASS(0);
        this.f3665A5SV6n = new HashMap();
        this.f3666ADYaiT = new HashMap();
        this.AMqCpz = 4194304;
    }

    public final synchronized void A2egSU() {
        A5SV6n(0);
    }

    public final void A4TApA(int i, Class cls) {
        NavigableMap ASJ6gh2 = ASJ6gh(cls);
        Integer num = (Integer) ASJ6gh2.get(Integer.valueOf(i));
        if (num != null) {
            if (num.intValue() == 1) {
                ASJ6gh2.remove(Integer.valueOf(i));
                return;
            } else {
                ASJ6gh2.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
    }

    public final void A5SV6n(int i) {
        while (this.f3667ARc23Z > i) {
            Object B4ZgIw2 = this.f3663A2egSU.B4ZgIw();
            ItGa5w.ARc23Z.A4TApA(B4ZgIw2);
            A2egSU AMqCpz = AMqCpz(B4ZgIw2.getClass());
            this.f3667ARc23Z -= AMqCpz.A2egSU() * AMqCpz.A4TApA(B4ZgIw2);
            A4TApA(AMqCpz.A4TApA(B4ZgIw2), B4ZgIw2.getClass());
            if (Log.isLoggable(AMqCpz.getTag(), 2)) {
                AMqCpz.A4TApA(B4ZgIw2);
            }
        }
    }

    public final synchronized Object ADYaiT(int i, Class cls) {
        AZOQYO azoqyo;
        int i2;
        try {
            Integer num = (Integer) ASJ6gh(cls).ceilingKey(Integer.valueOf(i));
            if (num == null || ((i2 = this.f3667ARc23Z) != 0 && this.AMqCpz / i2 < 2 && num.intValue() > i * 8)) {
                AZkASS aZkASS = this.f3664A4TApA;
                AlLFFp alLFFp = (AlLFFp) ((ArrayDeque) aZkASS.f3654AcNBzu).poll();
                if (alLFFp == null) {
                    alLFFp = aZkASS.A5SV6n();
                }
                azoqyo = (AZOQYO) alLFFp;
                azoqyo.f3660A4TApA = i;
                azoqyo.f3661A5SV6n = cls;
            }
            AZkASS aZkASS2 = this.f3664A4TApA;
            int intValue = num.intValue();
            AlLFFp alLFFp2 = (AlLFFp) ((ArrayDeque) aZkASS2.f3654AcNBzu).poll();
            if (alLFFp2 == null) {
                alLFFp2 = aZkASS2.A5SV6n();
            }
            azoqyo = (AZOQYO) alLFFp2;
            azoqyo.f3660A4TApA = intValue;
            azoqyo.f3661A5SV6n = cls;
        } catch (Throwable th) {
            throw th;
        }
        return ARc23Z(azoqyo, cls);
    }

    public final A2egSU AMqCpz(Class cls) {
        A2egSU aRc23Z;
        HashMap hashMap = this.f3666ADYaiT;
        A2egSU a2egSU = (A2egSU) hashMap.get(cls);
        if (a2egSU != null) {
            return a2egSU;
        }
        if (cls.equals(int[].class)) {
            aRc23Z = new AYUAbz();
        } else {
            if (!cls.equals(byte[].class)) {
                throw new IllegalArgumentException("No array pool found for: ".concat(cls.getSimpleName()));
            }
            aRc23Z = new ARc23Z();
        }
        hashMap.put(cls, aRc23Z);
        return aRc23Z;
    }

    public final Object ARc23Z(AZOQYO azoqyo, Class cls) {
        A2egSU AMqCpz = AMqCpz(cls);
        Object AmA8tU2 = this.f3663A2egSU.AmA8tU(azoqyo);
        if (AmA8tU2 != null) {
            this.f3667ARc23Z -= AMqCpz.A2egSU() * AMqCpz.A4TApA(AmA8tU2);
            A4TApA(AMqCpz.A4TApA(AmA8tU2), cls);
        }
        if (AmA8tU2 != null) {
            return AmA8tU2;
        }
        Log.isLoggable(AMqCpz.getTag(), 2);
        return AMqCpz.newArray(azoqyo.f3660A4TApA);
    }

    public final NavigableMap ASJ6gh(Class cls) {
        HashMap hashMap = this.f3665A5SV6n;
        NavigableMap navigableMap = (NavigableMap) hashMap.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        hashMap.put(cls, treeMap);
        return treeMap;
    }

    public final synchronized void AYUAbz(Object obj) {
        Class<?> cls = obj.getClass();
        A2egSU AMqCpz = AMqCpz(cls);
        int A4TApA2 = AMqCpz.A4TApA(obj);
        int A2egSU2 = AMqCpz.A2egSU() * A4TApA2;
        if (A2egSU2 <= this.AMqCpz / 2) {
            AZkASS aZkASS = this.f3664A4TApA;
            AlLFFp alLFFp = (AlLFFp) ((ArrayDeque) aZkASS.f3654AcNBzu).poll();
            if (alLFFp == null) {
                alLFFp = aZkASS.A5SV6n();
            }
            AZOQYO azoqyo = (AZOQYO) alLFFp;
            azoqyo.f3660A4TApA = A4TApA2;
            azoqyo.f3661A5SV6n = cls;
            this.f3663A2egSU.B2KMhB(azoqyo, obj);
            NavigableMap ASJ6gh2 = ASJ6gh(cls);
            Integer num = (Integer) ASJ6gh2.get(Integer.valueOf(azoqyo.f3660A4TApA));
            Integer valueOf = Integer.valueOf(azoqyo.f3660A4TApA);
            int i = 1;
            if (num != null) {
                i = 1 + num.intValue();
            }
            ASJ6gh2.put(valueOf, Integer.valueOf(i));
            this.f3667ARc23Z += A2egSU2;
            A5SV6n(this.AMqCpz);
        }
    }

    public final synchronized void AZOQYO(int i) {
        try {
            if (i >= 40) {
                A2egSU();
            } else if (i >= 20 || i == 15) {
                A5SV6n(this.AMqCpz / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public AaHO0E(int i) {
        this.f3663A2egSU = new K1Z3yj.A2egSU(28);
        this.f3664A4TApA = new AZkASS(0);
        this.f3665A5SV6n = new HashMap();
        this.f3666ADYaiT = new HashMap();
        this.AMqCpz = i;
    }
}

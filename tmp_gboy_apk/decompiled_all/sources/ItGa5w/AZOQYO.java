package ItGa5w;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AZOQYO {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final LinkedHashMap f4084A2egSU = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: A4TApA, reason: collision with root package name */
    public final long f4085A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public long f4086A5SV6n;

    public AZOQYO(long j) {
        this.f4085A4TApA = j;
    }

    public final synchronized Object A2egSU(Object obj) {
        AYUAbz aYUAbz;
        aYUAbz = (AYUAbz) this.f4084A2egSU.get(obj);
        return aYUAbz != null ? aYUAbz.f4082A2egSU : null;
    }

    public int A4TApA(Object obj) {
        return 1;
    }

    public void A5SV6n(Object obj, Object obj2) {
    }

    public final synchronized Object ADYaiT(Object obj, Object obj2) {
        int A4TApA2 = A4TApA(obj2);
        long j = A4TApA2;
        if (j >= this.f4085A4TApA) {
            A5SV6n(obj, obj2);
            return null;
        }
        if (obj2 != null) {
            this.f4086A5SV6n += j;
        }
        AYUAbz aYUAbz = (AYUAbz) this.f4084A2egSU.put(obj, obj2 == null ? null : new AYUAbz(A4TApA2, obj2));
        if (aYUAbz != null) {
            this.f4086A5SV6n -= aYUAbz.f4083A4TApA;
            if (!aYUAbz.f4082A2egSU.equals(obj2)) {
                A5SV6n(obj, aYUAbz.f4082A2egSU);
            }
        }
        AMqCpz(this.f4085A4TApA);
        return aYUAbz != null ? aYUAbz.f4082A2egSU : null;
    }

    public final synchronized void AMqCpz(long j) {
        while (this.f4086A5SV6n > j) {
            Iterator it = this.f4084A2egSU.entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            AYUAbz aYUAbz = (AYUAbz) entry.getValue();
            this.f4086A5SV6n -= aYUAbz.f4083A4TApA;
            Object key = entry.getKey();
            it.remove();
            A5SV6n(key, aYUAbz.f4082A2egSU);
        }
    }
}

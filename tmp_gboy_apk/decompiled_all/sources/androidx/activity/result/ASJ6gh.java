package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.AlLFFp;
import androidx.lifecycle.AmA8tU;
import androidx.lifecycle.AzWtSf;
import androidx.lifecycle.B4ZgIw;
import androidx.lifecycle.B9tovu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class ASJ6gh {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final HashMap f8000A2egSU = new HashMap();

    /* renamed from: A4TApA, reason: collision with root package name */
    public final HashMap f8001A4TApA = new HashMap();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final HashMap f8002A5SV6n = new HashMap();

    /* renamed from: ADYaiT, reason: collision with root package name */
    public ArrayList f8003ADYaiT = new ArrayList();
    public final transient HashMap AMqCpz = new HashMap();

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final HashMap f8004ARc23Z = new HashMap();

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final Bundle f8005ASJ6gh = new Bundle();

    public final boolean A2egSU(int i, int i2, Intent intent) {
        A4TApA a4TApA;
        String str = (String) this.f8000A2egSU.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        AMqCpz aMqCpz = (AMqCpz) this.AMqCpz.get(str);
        if (aMqCpz == null || (a4TApA = aMqCpz.f7996A2egSU) == null || !this.f8003ADYaiT.contains(str)) {
            this.f8004ARc23Z.remove(str);
            this.f8005ASJ6gh.putParcelable(str, new A2egSU(i2, intent));
            return true;
        }
        a4TApA.A5SV6n(aMqCpz.f7997A4TApA.A5SV6n(i2, intent));
        this.f8003ADYaiT.remove(str);
        return true;
    }

    public abstract void A4TApA(int i, A4TApA.A4TApA a4TApA, Object obj);

    public final ADYaiT A5SV6n(String str, A4TApA.A4TApA a4TApA, A4TApA a4TApA2) {
        AMqCpz(str);
        this.AMqCpz.put(str, new AMqCpz(a4TApA, a4TApA2));
        HashMap hashMap = this.f8004ARc23Z;
        if (hashMap.containsKey(str)) {
            Object obj = hashMap.get(str);
            hashMap.remove(str);
            a4TApA2.A5SV6n(obj);
        }
        Bundle bundle = this.f8005ASJ6gh;
        A2egSU a2egSU = (A2egSU) bundle.getParcelable(str);
        if (a2egSU != null) {
            bundle.remove(str);
            a4TApA2.A5SV6n(a4TApA.A5SV6n(a2egSU.f7990AcNBzu, a2egSU.f7991AlLFFp));
        }
        return new ADYaiT(this, str, a4TApA, 1);
    }

    public final ADYaiT ADYaiT(final String str, B9tovu b9tovu, final A4TApA.A4TApA a4TApA, final A4TApA a4TApA2) {
        AzWtSf lifecycle = b9tovu.getLifecycle();
        if (lifecycle.A4TApA().compareTo(AmA8tU.f8980AzWtSf) >= 0) {
            throw new IllegalStateException("LifecycleOwner " + b9tovu + " is attempting to register while current state is " + lifecycle.A4TApA() + ". LifecycleOwners must call register before they are STARTED.");
        }
        AMqCpz(str);
        HashMap hashMap = this.f8002A5SV6n;
        ARc23Z aRc23Z = (ARc23Z) hashMap.get(str);
        if (aRc23Z == null) {
            aRc23Z = new ARc23Z(lifecycle);
        }
        B4ZgIw b4ZgIw = new B4ZgIw() { // from class: androidx.activity.result.ActivityResultRegistry$1
            @Override // androidx.lifecycle.B4ZgIw
            public final void onStateChanged(B9tovu b9tovu2, AlLFFp alLFFp) {
                boolean equals = AlLFFp.ON_START.equals(alLFFp);
                String str2 = str;
                ASJ6gh aSJ6gh = ASJ6gh.this;
                if (!equals) {
                    if (AlLFFp.ON_STOP.equals(alLFFp)) {
                        aSJ6gh.AMqCpz.remove(str2);
                        return;
                    } else {
                        if (AlLFFp.ON_DESTROY.equals(alLFFp)) {
                            aSJ6gh.ARc23Z(str2);
                            return;
                        }
                        return;
                    }
                }
                HashMap hashMap2 = aSJ6gh.AMqCpz;
                A4TApA a4TApA3 = a4TApA2;
                A4TApA.A4TApA a4TApA4 = a4TApA;
                hashMap2.put(str2, new AMqCpz(a4TApA4, a4TApA3));
                HashMap hashMap3 = aSJ6gh.f8004ARc23Z;
                if (hashMap3.containsKey(str2)) {
                    Object obj = hashMap3.get(str2);
                    hashMap3.remove(str2);
                    a4TApA3.A5SV6n(obj);
                }
                Bundle bundle = aSJ6gh.f8005ASJ6gh;
                A2egSU a2egSU = (A2egSU) bundle.getParcelable(str2);
                if (a2egSU != null) {
                    bundle.remove(str2);
                    a4TApA3.A5SV6n(a4TApA4.A5SV6n(a2egSU.f7990AcNBzu, a2egSU.f7991AlLFFp));
                }
            }
        };
        aRc23Z.f7998A2egSU.A2egSU(b4ZgIw);
        aRc23Z.f7999A4TApA.add(b4ZgIw);
        hashMap.put(str, aRc23Z);
        return new ADYaiT(this, str, a4TApA, 0);
    }

    public final void AMqCpz(String str) {
        HashMap hashMap = this.f8001A4TApA;
        if (((Integer) hashMap.get(str)) != null) {
            return;
        }
        RbGtwA.ADYaiT.f7894AcNBzu.getClass();
        int nextInt = RbGtwA.ADYaiT.f7895AlLFFp.A2egSU().nextInt(2147418112);
        while (true) {
            int i = nextInt + 65536;
            HashMap hashMap2 = this.f8000A2egSU;
            if (!hashMap2.containsKey(Integer.valueOf(i))) {
                hashMap2.put(Integer.valueOf(i), str);
                hashMap.put(str, Integer.valueOf(i));
                return;
            } else {
                RbGtwA.ADYaiT.f7894AcNBzu.getClass();
                nextInt = RbGtwA.ADYaiT.f7895AlLFFp.A2egSU().nextInt(2147418112);
            }
        }
    }

    public final void ARc23Z(String str) {
        Integer num;
        if (!this.f8003ADYaiT.contains(str) && (num = (Integer) this.f8001A4TApA.remove(str)) != null) {
            this.f8000A2egSU.remove(num);
        }
        this.AMqCpz.remove(str);
        HashMap hashMap = this.f8004ARc23Z;
        if (hashMap.containsKey(str)) {
            Objects.toString(hashMap.get(str));
            hashMap.remove(str);
        }
        Bundle bundle = this.f8005ASJ6gh;
        if (bundle.containsKey(str)) {
            Objects.toString(bundle.getParcelable(str));
            bundle.remove(str);
        }
        HashMap hashMap2 = this.f8002A5SV6n;
        ARc23Z aRc23Z = (ARc23Z) hashMap2.get(str);
        if (aRc23Z != null) {
            ArrayList arrayList = aRc23Z.f7999A4TApA;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                aRc23Z.f7998A2egSU.A5SV6n((B4ZgIw) it.next());
            }
            arrayList.clear();
            hashMap2.remove(str);
        }
    }
}

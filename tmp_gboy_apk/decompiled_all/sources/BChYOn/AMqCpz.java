package BChYOn;

import BI9f7h.AzWtSf;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz {

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f1124A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public boolean f1125A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final ARc23Z f1126ADYaiT;
    public final ADYaiT AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public AMqCpz f1127ARc23Z;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public B4ZgIw.AZOQYO f1130AZOQYO;

    /* renamed from: A2egSU, reason: collision with root package name */
    public HashSet f1123A2egSU = null;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public int f1128ASJ6gh = 0;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public int f1129AYUAbz = Integer.MIN_VALUE;

    public AMqCpz(ARc23Z aRc23Z, ADYaiT aDYaiT) {
        this.f1126ADYaiT = aRc23Z;
        this.AMqCpz = aDYaiT;
    }

    public final void A2egSU(AMqCpz aMqCpz, int i) {
        A4TApA(aMqCpz, i, Integer.MIN_VALUE, false);
    }

    public final boolean A4TApA(AMqCpz aMqCpz, int i, int i2, boolean z) {
        if (aMqCpz == null) {
            AZkASS();
            return true;
        }
        if (!z && !AZOQYO(aMqCpz)) {
            return false;
        }
        this.f1127ARc23Z = aMqCpz;
        if (aMqCpz.f1123A2egSU == null) {
            aMqCpz.f1123A2egSU = new HashSet();
        }
        HashSet hashSet = this.f1127ARc23Z.f1123A2egSU;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.f1128ASJ6gh = i;
        this.f1129AYUAbz = i2;
        return true;
    }

    public final void A5SV6n(int i, AzWtSf azWtSf, ArrayList arrayList) {
        HashSet hashSet = this.f1123A2egSU;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                BI9f7h.AZOQYO.A2egSU(((AMqCpz) it.next()).f1126ADYaiT, i, arrayList, azWtSf);
            }
        }
    }

    public final int ADYaiT() {
        if (this.f1125A5SV6n) {
            return this.f1124A4TApA;
        }
        return 0;
    }

    public final int AMqCpz() {
        AMqCpz aMqCpz;
        if (this.f1126ADYaiT.f1188DV2E8K == 8) {
            return 0;
        }
        int i = this.f1129AYUAbz;
        return (i == Integer.MIN_VALUE || (aMqCpz = this.f1127ARc23Z) == null || aMqCpz.f1126ADYaiT.f1188DV2E8K != 8) ? this.f1128ASJ6gh : i;
    }

    public final AMqCpz ARc23Z() {
        ADYaiT aDYaiT = this.AMqCpz;
        int ordinal = aDYaiT.ordinal();
        ARc23Z aRc23Z = this.f1126ADYaiT;
        switch (ordinal) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
                return aRc23Z.f1166CQhlFr;
            case 2:
                return aRc23Z.f1167CSDoyG;
            case 3:
                return aRc23Z.f1164CNPG0E;
            case 4:
                return aRc23Z.f1165COJEAR;
            default:
                throw new AssertionError(aDYaiT.name());
        }
    }

    public final boolean ASJ6gh() {
        HashSet hashSet = this.f1123A2egSU;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((AMqCpz) it.next()).ARc23Z().AYUAbz()) {
                return true;
            }
        }
        return false;
    }

    public final boolean AYUAbz() {
        return this.f1127ARc23Z != null;
    }

    public final boolean AZOQYO(AMqCpz aMqCpz) {
        if (aMqCpz == null) {
            return false;
        }
        ADYaiT type = aMqCpz.getType();
        ADYaiT aDYaiT = ADYaiT.f1118B25kr6;
        ADYaiT aDYaiT2 = this.AMqCpz;
        ARc23Z aRc23Z = aMqCpz.f1126ADYaiT;
        if (type == aDYaiT2) {
            return aDYaiT2 != aDYaiT || (aRc23Z.BpkvW3 && this.f1126ADYaiT.BpkvW3);
        }
        int ordinal = aDYaiT2.ordinal();
        ADYaiT aDYaiT3 = ADYaiT.f1120B3GDIM;
        ADYaiT aDYaiT4 = ADYaiT.f1121B4ZgIw;
        ADYaiT aDYaiT5 = ADYaiT.f1116AmA8tU;
        ADYaiT aDYaiT6 = ADYaiT.f1114AcNBzu;
        switch (ordinal) {
            case 0:
            case 7:
            case 8:
                return false;
            case 1:
            case 3:
                boolean z = type == aDYaiT6 || type == aDYaiT5;
                return aRc23Z instanceof AZkASS ? z || type == aDYaiT3 : z;
            case 2:
            case 4:
                boolean z2 = type == ADYaiT.f1115AlLFFp || type == ADYaiT.f1117AzWtSf;
                return aRc23Z instanceof AZkASS ? z2 || type == aDYaiT4 : z2;
            case 5:
                return (type == aDYaiT6 || type == aDYaiT5) ? false : true;
            case 6:
                return (type == aDYaiT || type == aDYaiT3 || type == aDYaiT4) ? false : true;
            default:
                throw new AssertionError(aDYaiT2.name());
        }
    }

    public final void AZkASS() {
        HashSet hashSet;
        AMqCpz aMqCpz = this.f1127ARc23Z;
        if (aMqCpz != null && (hashSet = aMqCpz.f1123A2egSU) != null) {
            hashSet.remove(this);
            if (this.f1127ARc23Z.f1123A2egSU.size() == 0) {
                this.f1127ARc23Z.f1123A2egSU = null;
            }
        }
        this.f1123A2egSU = null;
        this.f1127ARc23Z = null;
        this.f1128ASJ6gh = 0;
        this.f1129AYUAbz = Integer.MIN_VALUE;
        this.f1125A5SV6n = false;
        this.f1124A4TApA = 0;
    }

    public final void AaHO0E() {
        B4ZgIw.AZOQYO azoqyo = this.f1130AZOQYO;
        if (azoqyo == null) {
            this.f1130AZOQYO = new B4ZgIw.AZOQYO(1);
        } else {
            azoqyo.A5SV6n();
        }
    }

    public final void AcNBzu(int i) {
        this.f1124A4TApA = i;
        this.f1125A5SV6n = true;
    }

    public ADYaiT getType() {
        return this.AMqCpz;
    }

    public final String toString() {
        return this.f1126ADYaiT.f1189DXnQ0V + ":" + this.AMqCpz.toString();
    }
}

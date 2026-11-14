package QgOIY0;

import com.sigmob.sdk.base.views.r;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class AaHO0E extends BmvVmW implements BI9f7h {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final BNL6CD f7504A2egSU;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f7506A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f7507ADYaiT;
    public int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f7508ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public int f7509ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public int f7510AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public boolean f7511AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public String f7512AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public boolean f7513AaHO0E;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f7515AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public CharSequence f7516AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f7517AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public CharSequence f7518B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public ArrayList f7519B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public ArrayList f7520B3GDIM;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ArrayList f7505A4TApA = new ArrayList();

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f7514AcNBzu = -1;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f7521B4ZgIw = false;

    public AaHO0E(BNL6CD bnl6cd) {
        this.f7504A2egSU = bnl6cd;
    }

    @Override // QgOIY0.BI9f7h
    public final boolean A2egSU(ArrayList arrayList, ArrayList arrayList2) {
        int i = BNL6CD.f7609BI9f7h;
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f7511AZOQYO) {
            return true;
        }
        BNL6CD bnl6cd = this.f7504A2egSU;
        if (bnl6cd.f7615ASJ6gh == null) {
            bnl6cd.f7615ASJ6gh = new ArrayList();
        }
        bnl6cd.f7615ASJ6gh.add(this);
        return true;
    }

    public final int A4TApA(boolean z) {
        int size;
        if (this.f7513AaHO0E) {
            throw new IllegalStateException("commit already called");
        }
        int i = BNL6CD.f7609BI9f7h;
        this.f7513AaHO0E = true;
        if (this.f7511AZOQYO) {
            BNL6CD bnl6cd = this.f7504A2egSU;
            synchronized (bnl6cd) {
                try {
                    ArrayList arrayList = bnl6cd.f7618AZkASS;
                    if (arrayList != null && arrayList.size() > 0) {
                        ArrayList arrayList2 = bnl6cd.f7618AZkASS;
                        size = ((Integer) arrayList2.remove(arrayList2.size() - 1)).intValue();
                        bnl6cd.f7617AZOQYO.set(size, this);
                    }
                    if (bnl6cd.f7617AZOQYO == null) {
                        bnl6cd.f7617AZOQYO = new ArrayList();
                    }
                    size = bnl6cd.f7617AZOQYO.size();
                    bnl6cd.f7617AZOQYO.add(this);
                } finally {
                }
            }
            this.f7514AcNBzu = size;
        } else {
            this.f7514AcNBzu = -1;
        }
        this.f7504A2egSU.ADYaiT(this, z);
        return this.f7514AcNBzu;
    }

    public final void A5SV6n(int i) {
        if (this.f7511AZOQYO) {
            int i2 = BNL6CD.f7609BI9f7h;
            ArrayList arrayList = this.f7505A4TApA;
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                B2KMhB b2KMhB = ((AZkASS) arrayList.get(i3)).f7500A4TApA;
                if (b2KMhB != null) {
                    b2KMhB.f7585CqNSpT += i;
                    int i4 = BNL6CD.f7609BI9f7h;
                }
            }
        }
    }

    public final void ADYaiT(AZkASS aZkASS) {
        this.f7505A4TApA.add(aZkASS);
        aZkASS.f7501A5SV6n = this.f7506A5SV6n;
        aZkASS.f7502ADYaiT = this.f7507ADYaiT;
        aZkASS.AMqCpz = this.AMqCpz;
        aZkASS.f7503ARc23Z = this.f7508ARc23Z;
    }

    public final boolean AMqCpz(ArrayList arrayList, int i, int i2) {
        if (i2 != i) {
            ArrayList arrayList2 = this.f7505A4TApA;
            int size = arrayList2.size();
            int i3 = -1;
            for (int i4 = 0; i4 < size; i4++) {
                int i5 = ((AZkASS) arrayList2.get(i4)).f7500A4TApA.f7557B2KMhB;
                if (i5 != 0 && i5 != i3) {
                    for (int i6 = i; i6 < i2; i6++) {
                        AaHO0E aaHO0E = (AaHO0E) arrayList.get(i6);
                        int size2 = aaHO0E.f7505A4TApA.size();
                        for (int i7 = 0; i7 < size2; i7++) {
                            if (((AZkASS) aaHO0E.f7505A4TApA.get(i7)).f7500A4TApA.f7557B2KMhB == i5) {
                                return true;
                            }
                        }
                    }
                    i3 = i5;
                }
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(r.b.d);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f7514AcNBzu >= 0) {
            sb.append(" #");
            sb.append(this.f7514AcNBzu);
        }
        if (this.f7512AZkASS != null) {
            sb.append(" ");
            sb.append(this.f7512AZkASS);
        }
        sb.append("}");
        return sb.toString();
    }
}

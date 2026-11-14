package HXc4pW;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ArrayList f3502A2egSU = new ArrayList();

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ArrayList f3503A4TApA = new ArrayList();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public com.bumptech.glide.ARc23Z f3504A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public Object f3505ADYaiT;
    public int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f3506ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public Class f3507ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public AmA8tU f3508AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public HSHyT0.AmA8tU f3509AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public ItGa5w.A5SV6n f3510AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public Class f3511AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f3512AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f3513AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public HSHyT0.AZkASS f3514AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public com.bumptech.glide.AZOQYO f3515AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public AlLFFp f3516B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public boolean f3517B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public boolean f3518B3GDIM;

    public final ArrayList A2egSU() {
        boolean z = this.f3513AlLFFp;
        ArrayList arrayList = this.f3503A4TApA;
        if (!z) {
            this.f3513AlLFFp = true;
            arrayList.clear();
            ArrayList A4TApA2 = A4TApA();
            int size = A4TApA2.size();
            for (int i = 0; i < size; i++) {
                Hjvs0g.BChYOn bChYOn = (Hjvs0g.BChYOn) A4TApA2.get(i);
                if (!arrayList.contains(bChYOn.f3742A2egSU)) {
                    arrayList.add(bChYOn.f3742A2egSU);
                }
                int i2 = 0;
                while (true) {
                    List list = bChYOn.f3743A4TApA;
                    if (i2 < list.size()) {
                        if (!arrayList.contains(list.get(i2))) {
                            arrayList.add(list.get(i2));
                        }
                        i2++;
                    }
                }
            }
        }
        return arrayList;
    }

    public final ArrayList A4TApA() {
        boolean z = this.f3512AcNBzu;
        ArrayList arrayList = this.f3502A2egSU;
        if (!z) {
            this.f3512AcNBzu = true;
            arrayList.clear();
            List ASJ6gh2 = this.f3504A5SV6n.f9920A4TApA.ASJ6gh(this.f3505ADYaiT);
            int size = ASJ6gh2.size();
            for (int i = 0; i < size; i++) {
                Hjvs0g.BChYOn A2egSU2 = ((Hjvs0g.BI9f7h) ASJ6gh2.get(i)).A2egSU(this.f3505ADYaiT, this.AMqCpz, this.f3506ARc23Z, this.f3509AZOQYO);
                if (A2egSU2 != null) {
                    arrayList.add(A2egSU2);
                }
            }
        }
        return arrayList;
    }

    public final BNL6CD A5SV6n(Class cls) {
        BNL6CD bnl6cd;
        Class cls2;
        com.bumptech.glide.AaHO0E aaHO0E = this.f3504A5SV6n.f9920A4TApA;
        Class cls3 = this.f3507ASJ6gh;
        Class cls4 = this.f3511AaHO0E;
        Ifhupb.ADYaiT aDYaiT = aaHO0E.f9941AZOQYO;
        ItGa5w.AaHO0E aaHO0E2 = (ItGa5w.AaHO0E) aDYaiT.f3970A4TApA.getAndSet(null);
        if (aaHO0E2 == null) {
            aaHO0E2 = new ItGa5w.AaHO0E();
        }
        aaHO0E2.f4088A2egSU = cls;
        aaHO0E2.f4089A4TApA = cls3;
        aaHO0E2.f4090A5SV6n = cls4;
        synchronized (aDYaiT.f3969A2egSU) {
            bnl6cd = (BNL6CD) aDYaiT.f3969A2egSU.get(aaHO0E2);
        }
        aDYaiT.f3970A4TApA.set(aaHO0E2);
        aaHO0E.f9941AZOQYO.getClass();
        if (Ifhupb.ADYaiT.f3968A5SV6n.equals(bnl6cd)) {
            return null;
        }
        if (bnl6cd != null) {
            return bnl6cd;
        }
        BNL6CD bnl6cd2 = null;
        ArrayList AMqCpz = aaHO0E.AMqCpz(cls, cls3, cls4);
        if (AMqCpz.isEmpty()) {
            cls2 = cls;
        } else {
            cls2 = cls;
            bnl6cd2 = new BNL6CD(cls2, cls3, cls4, AMqCpz, aaHO0E.f9942AZkASS);
        }
        BNL6CD bnl6cd3 = bnl6cd2;
        aaHO0E.f9941AZOQYO.A2egSU(cls2, cls3, cls4, bnl6cd3);
        return bnl6cd3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
    
        r1 = r3.f3965A4TApA;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final HSHyT0.A4TApA ADYaiT(java.lang.Object r6) {
        /*
            r5 = this;
            com.bumptech.glide.ARc23Z r0 = r5.f3504A5SV6n
            com.bumptech.glide.AaHO0E r0 = r0.f9920A4TApA
            Ifhupb.A4TApA r0 = r0.f9935A4TApA
            java.lang.Class r1 = r6.getClass()
            monitor-enter(r0)
            java.util.ArrayList r2 = r0.f3966A2egSU     // Catch: java.lang.Throwable -> L29
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L29
        L11:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L29
            if (r3 == 0) goto L2b
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L29
            Ifhupb.A2egSU r3 = (Ifhupb.A2egSU) r3     // Catch: java.lang.Throwable -> L29
            java.lang.Class r4 = r3.f3964A2egSU     // Catch: java.lang.Throwable -> L29
            boolean r4 = r4.isAssignableFrom(r1)     // Catch: java.lang.Throwable -> L29
            if (r4 == 0) goto L11
            HSHyT0.A4TApA r1 = r3.f3965A4TApA     // Catch: java.lang.Throwable -> L29
            monitor-exit(r0)
            goto L2d
        L29:
            r6 = move-exception
            goto L48
        L2b:
            monitor-exit(r0)
            r1 = 0
        L2d:
            if (r1 == 0) goto L30
            return r1
        L30:
            com.bumptech.glide.AcNBzu r0 = new com.bumptech.glide.AcNBzu
            java.lang.Class r6 = r6.getClass()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to find source encoder for data class: "
            r1.<init>(r2)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        L48:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L29
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: HXc4pW.AYUAbz.ADYaiT(java.lang.Object):HSHyT0.A4TApA");
    }

    public final HSHyT0.B3GDIM AMqCpz(Class cls) {
        HSHyT0.B3GDIM b3gdim = (HSHyT0.B3GDIM) this.f3510AZkASS.get(cls);
        if (b3gdim == null) {
            Iterator it = ((com.google.gson.internal.AZkASS) this.f3510AZkASS.entrySet()).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    b3gdim = (HSHyT0.B3GDIM) entry.getValue();
                    break;
                }
            }
        }
        if (b3gdim != null) {
            return b3gdim;
        }
        if (!this.f3510AZkASS.isEmpty() || !this.f3517B2KMhB) {
            return HwAeAU.ADYaiT.f3802A4TApA;
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }
}

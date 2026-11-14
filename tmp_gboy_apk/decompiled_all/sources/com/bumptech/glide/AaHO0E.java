package com.bumptech.glide;

import ADYaiT.DUi7mC;
import HSHyT0.B2KMhB;
import Hjvs0g.BI9f7h;
import Hjvs0g.BIYEnU;
import Hjvs0g.BJ7GGh;
import Hjvs0g.BNL6CD;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AaHO0E {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final BNL6CD f9934A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Ifhupb.A4TApA f9935A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Ifhupb.ASJ6gh f9936A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final Ifhupb.AZOQYO f9937ADYaiT;
    public final com.bumptech.glide.load.data.AZOQYO AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final IOxIEW.AMqCpz f9938ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final Ifhupb.A5SV6n f9939ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final Ifhupb.AMqCpz f9940AYUAbz = new Ifhupb.AMqCpz();

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final Ifhupb.ADYaiT f9941AZOQYO = new Ifhupb.ADYaiT();

    /* renamed from: AZkASS, reason: collision with root package name */
    public final DUi7mC f9942AZkASS;

    public static final class A2egSU extends AZkASS {
        public A2egSU() {
            super("Failed to find image header parser.");
        }
    }

    public AaHO0E() {
        DUi7mC dUi7mC = new DUi7mC(new CNPG0E.A5SV6n(20), new Hdahpu.AZOQYO(21), new Hdahpu.AZOQYO(22), 15, false);
        this.f9942AZkASS = dUi7mC;
        this.f9934A2egSU = new BNL6CD(dUi7mC);
        this.f9935A4TApA = new Ifhupb.A4TApA();
        this.f9936A5SV6n = new Ifhupb.ASJ6gh();
        this.f9937ADYaiT = new Ifhupb.AZOQYO();
        this.AMqCpz = new com.bumptech.glide.load.data.AZOQYO();
        this.f9938ARc23Z = new IOxIEW.AMqCpz();
        this.f9939ASJ6gh = new Ifhupb.A5SV6n();
        List asList = Arrays.asList("Gif", "Bitmap", "BitmapDrawable");
        ArrayList arrayList = new ArrayList(asList.size());
        arrayList.add("legacy_prepend_all");
        Iterator it = asList.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        arrayList.add("legacy_append");
        Ifhupb.ASJ6gh aSJ6gh = this.f9936A5SV6n;
        synchronized (aSJ6gh) {
            try {
                ArrayList arrayList2 = new ArrayList(aSJ6gh.f3976A2egSU);
                aSJ6gh.f3976A2egSU.clear();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    aSJ6gh.f3976A2egSU.add((String) it2.next());
                }
                Iterator it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    String str = (String) it3.next();
                    if (!arrayList.contains(str)) {
                        aSJ6gh.f3976A2egSU.add(str);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void A2egSU(Class cls, HSHyT0.A4TApA a4TApA) {
        Ifhupb.A4TApA a4TApA2 = this.f9935A4TApA;
        synchronized (a4TApA2) {
            a4TApA2.f3966A2egSU.add(new Ifhupb.A2egSU(cls, a4TApA));
        }
    }

    public final void A4TApA(Class cls, B2KMhB b2KMhB) {
        Ifhupb.AZOQYO azoqyo = this.f9937ADYaiT;
        synchronized (azoqyo) {
            azoqyo.f3980A2egSU.add(new Ifhupb.AYUAbz(cls, b2KMhB));
        }
    }

    public final void A5SV6n(Class cls, Class cls2, BIYEnU bIYEnU) {
        BNL6CD bnl6cd = this.f9934A2egSU;
        synchronized (bnl6cd) {
            bnl6cd.f3746A2egSU.A2egSU(cls, cls2, bIYEnU);
            bnl6cd.f3747A4TApA.f3619A2egSU.clear();
        }
    }

    public final void ADYaiT(String str, Class cls, Class cls2, HSHyT0.B25kr6 b25kr6) {
        Ifhupb.ASJ6gh aSJ6gh = this.f9936A5SV6n;
        synchronized (aSJ6gh) {
            aSJ6gh.A2egSU(str).add(new Ifhupb.ARc23Z(cls, cls2, b25kr6));
        }
    }

    public final ArrayList AMqCpz(Class cls, Class cls2, Class cls3) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = this.f9936A5SV6n.A4TApA(cls, cls2).iterator();
        while (it.hasNext()) {
            Class cls4 = (Class) it.next();
            Iterator it2 = this.f9938ARc23Z.A4TApA(cls4, cls3).iterator();
            while (it2.hasNext()) {
                Class cls5 = (Class) it2.next();
                Ifhupb.ASJ6gh aSJ6gh = this.f9936A5SV6n;
                synchronized (aSJ6gh) {
                    arrayList = new ArrayList();
                    Iterator it3 = aSJ6gh.f3976A2egSU.iterator();
                    while (it3.hasNext()) {
                        List<Ifhupb.ARc23Z> list = (List) aSJ6gh.f3977A4TApA.get((String) it3.next());
                        if (list != null) {
                            for (Ifhupb.ARc23Z aRc23Z : list) {
                                if (aRc23Z.f3973A2egSU.isAssignableFrom(cls) && cls4.isAssignableFrom(aRc23Z.f3974A4TApA)) {
                                    arrayList.add(aRc23Z.f3975A5SV6n);
                                }
                            }
                        }
                    }
                }
                arrayList2.add(new HXc4pW.AaHO0E(cls, cls4, cls5, arrayList, this.f9938ARc23Z.A2egSU(cls4, cls5), this.f9942AZkASS));
            }
        }
        return arrayList2;
    }

    public final ArrayList ARc23Z() {
        ArrayList arrayList;
        Ifhupb.A5SV6n a5SV6n = this.f9939ASJ6gh;
        synchronized (a5SV6n) {
            arrayList = a5SV6n.f3967A2egSU;
        }
        if (arrayList.isEmpty()) {
            throw new A2egSU();
        }
        return arrayList;
    }

    public final List ASJ6gh(Object obj) {
        List list;
        BNL6CD bnl6cd = this.f9934A2egSU;
        bnl6cd.getClass();
        Class<?> cls = obj.getClass();
        synchronized (bnl6cd) {
            BJ7GGh bJ7GGh = (BJ7GGh) bnl6cd.f3747A4TApA.f3619A2egSU.get(cls);
            list = bJ7GGh == null ? null : bJ7GGh.f3745A2egSU;
            if (list == null) {
                list = Collections.unmodifiableList(bnl6cd.f3746A2egSU.ADYaiT(cls));
                if (((BJ7GGh) bnl6cd.f3747A4TApA.f3619A2egSU.put(cls, new BJ7GGh(list))) != null) {
                    throw new IllegalStateException("Already cached loaders for model: " + cls);
                }
            }
        }
        if (list.isEmpty()) {
            throw new AcNBzu("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }
        int size = list.size();
        List list2 = Collections.EMPTY_LIST;
        boolean z = true;
        for (int i = 0; i < size; i++) {
            BI9f7h bI9f7h = (BI9f7h) list.get(i);
            if (bI9f7h.A4TApA(obj)) {
                if (z) {
                    list2 = new ArrayList(size - i);
                    z = false;
                }
                list2.add(bI9f7h);
            }
        }
        if (!list2.isEmpty()) {
            return list2;
        }
        throw new AcNBzu("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + obj);
    }

    public final void AYUAbz(HSHyT0.ADYaiT aDYaiT) {
        Ifhupb.A5SV6n a5SV6n = this.f9939ASJ6gh;
        synchronized (a5SV6n) {
            a5SV6n.f3967A2egSU.add(aDYaiT);
        }
    }

    public final void AZOQYO(com.bumptech.glide.load.data.ARc23Z aRc23Z) {
        com.bumptech.glide.load.data.AZOQYO azoqyo = this.AMqCpz;
        synchronized (azoqyo) {
            azoqyo.f9984A2egSU.put(aRc23Z.A2egSU(), aRc23Z);
        }
    }

    public final void AZkASS(Class cls, Class cls2, IOxIEW.A5SV6n a5SV6n) {
        IOxIEW.AMqCpz aMqCpz = this.f9938ARc23Z;
        synchronized (aMqCpz) {
            aMqCpz.f3930A2egSU.add(new IOxIEW.ADYaiT(cls, cls2, a5SV6n));
        }
    }
}

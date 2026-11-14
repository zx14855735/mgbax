package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class DaOi9o {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final DjONCG f8933A2egSU = new DjONCG();

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final Dphsd2 f8934A4TApA;

    static {
        Dphsd2 dphsd2;
        try {
            dphsd2 = (Dphsd2) DaOi9o.AmA8tU.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            dphsd2 = null;
        }
        f8934A4TApA = dphsd2;
    }

    public static final void A2egSU(Fragment fragment, Fragment fragment2, boolean z, B25kr6.ADYaiT aDYaiT) {
        RXb0Sz.ARc23Z.AMqCpz(fragment, "inFragment");
        RXb0Sz.ARc23Z.AMqCpz(fragment2, "outFragment");
        if ((z ? fragment2.getEnterTransitionCallback() : fragment.getEnterTransitionCallback()) != null) {
            ArrayList arrayList = new ArrayList(aDYaiT.f1011AmA8tU);
            Iterator it = ((com.google.gson.internal.AZkASS) aDYaiT.entrySet()).iterator();
            while (it.hasNext()) {
                arrayList.add((View) ((Map.Entry) it.next()).getValue());
            }
            ArrayList arrayList2 = new ArrayList(aDYaiT.f1011AmA8tU);
            Iterator it2 = ((com.google.gson.internal.AZkASS) aDYaiT.entrySet()).iterator();
            while (it2.hasNext()) {
                arrayList2.add((String) ((Map.Entry) it2.next()).getKey());
            }
        }
    }

    public static final String A4TApA(B25kr6.ADYaiT aDYaiT, String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = ((com.google.gson.internal.AZkASS) aDYaiT.entrySet()).iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (RXb0Sz.ARc23Z.A2egSU(entry.getValue(), str)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        Iterator it2 = linkedHashMap.entrySet().iterator();
        while (it2.hasNext()) {
            arrayList.add((String) ((Map.Entry) it2.next()).getKey());
        }
        return (String) (arrayList.isEmpty() ? null : arrayList.get(0));
    }

    public static final void A5SV6n(ArrayList arrayList, int i) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setVisibility(i);
        }
    }
}

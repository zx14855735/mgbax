package RD2OKB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class BPw6Q8 extends BNL6CD {
    public static Map A4TApA(ArrayList arrayList) {
        BChYOn bChYOn = BChYOn.f7847AcNBzu;
        int size = arrayList.size();
        if (size == 0) {
            return bChYOn;
        }
        if (size == 1) {
            R8Rbcg.A4TApA a4TApA = (R8Rbcg.A4TApA) arrayList.get(0);
            RXb0Sz.ARc23Z.AMqCpz(a4TApA, "pair");
            Map singletonMap = Collections.singletonMap(a4TApA.f7826AcNBzu, a4TApA.f7827AlLFFp);
            RXb0Sz.ARc23Z.ADYaiT(singletonMap, "singletonMap(...)");
            return singletonMap;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(BNL6CD.A2egSU(arrayList.size()));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            R8Rbcg.A4TApA a4TApA2 = (R8Rbcg.A4TApA) it.next();
            linkedHashMap.put(a4TApA2.f7826AcNBzu, a4TApA2.f7827AlLFFp);
        }
        return linkedHashMap;
    }
}

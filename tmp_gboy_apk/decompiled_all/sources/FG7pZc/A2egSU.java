package FG7pZc;

import B25kr6.AMqCpz;
import H0qugq.ADYaiT;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final HashMap f2572A2egSU = new HashMap(8);

    public final ArrayList A2egSU(GTPRn3.A2egSU a2egSU) {
        ArrayList arrayList;
        synchronized (this) {
            try {
                Collection collection = (Set) this.f2572A2egSU.get(a2egSU);
                if (collection == null) {
                    collection = new AMqCpz();
                    this.f2572A2egSU.put(a2egSU, collection);
                }
                arrayList = new ArrayList(collection.size());
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public final void A4TApA() {
        Iterator it = A2egSU(GTPRn3.A2egSU.f3060B25kr6).iterator();
        while (it.hasNext()) {
            ((ADYaiT) it.next()).A2egSU();
        }
        this.f2572A2egSU.clear();
    }
}

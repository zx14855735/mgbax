package Ifhupb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ASJ6gh {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ArrayList f3976A2egSU = new ArrayList();

    /* renamed from: A4TApA, reason: collision with root package name */
    public final HashMap f3977A4TApA = new HashMap();

    public final synchronized List A2egSU(String str) {
        List list;
        try {
            if (!this.f3976A2egSU.contains(str)) {
                this.f3976A2egSU.add(str);
            }
            list = (List) this.f3977A4TApA.get(str);
            if (list == null) {
                list = new ArrayList();
                this.f3977A4TApA.put(str, list);
            }
        } catch (Throwable th) {
            throw th;
        }
        return list;
    }

    public final synchronized ArrayList A4TApA(Class cls, Class cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f3976A2egSU.iterator();
        while (it.hasNext()) {
            List<ARc23Z> list = (List) this.f3977A4TApA.get((String) it.next());
            if (list != null) {
                for (ARc23Z aRc23Z : list) {
                    if ((aRc23Z.f3973A2egSU.isAssignableFrom(cls) && cls2.isAssignableFrom(aRc23Z.f3974A4TApA)) && !arrayList.contains(aRc23Z.f3974A4TApA)) {
                        arrayList.add(aRc23Z.f3974A4TApA);
                    }
                }
            }
        }
        return arrayList;
    }
}

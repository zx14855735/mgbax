package BNL6CD;

import B25kr6.AzWtSf;
import B4ZgIw.AMqCpz;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AMqCpz f1426A2egSU = new AMqCpz(10);

    /* renamed from: A4TApA, reason: collision with root package name */
    public final AzWtSf f1427A4TApA = new AzWtSf();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final ArrayList f1428A5SV6n = new ArrayList();

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final HashSet f1429ADYaiT = new HashSet();

    public final void A2egSU(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) this.f1427A4TApA.get(obj);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                A2egSU(arrayList2.get(i), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }
}

package B25kr6;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ADYaiT extends AzWtSf implements Map {

    /* renamed from: AzWtSf, reason: collision with root package name */
    public com.google.gson.internal.AZkASS f980AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public QkAq4X.ASJ6gh f981B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public A5SV6n f982B2KMhB;

    public ADYaiT(ADYaiT aDYaiT) {
        super(0);
        if (aDYaiT != null) {
            ASJ6gh(aDYaiT);
        }
    }

    public final boolean AaHO0E(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!super.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean AcNBzu(Collection collection) {
        int i = this.f1011AmA8tU;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            super.remove(it.next());
        }
        return i != this.f1011AmA8tU;
    }

    public final boolean AlLFFp(Collection collection) {
        int i = this.f1011AmA8tU;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (!collection.contains(ARc23Z(i2))) {
                AYUAbz(i2);
            }
        }
        return i != this.f1011AmA8tU;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        com.google.gson.internal.AZkASS aZkASS = this.f980AzWtSf;
        if (aZkASS != null) {
            return aZkASS;
        }
        com.google.gson.internal.AZkASS aZkASS2 = new com.google.gson.internal.AZkASS(this, 2);
        this.f980AzWtSf = aZkASS2;
        return aZkASS2;
    }

    @Override // java.util.Map
    public final Set keySet() {
        QkAq4X.ASJ6gh aSJ6gh = this.f981B25kr6;
        if (aSJ6gh != null) {
            return aSJ6gh;
        }
        QkAq4X.ASJ6gh aSJ6gh2 = new QkAq4X.ASJ6gh(2, this);
        this.f981B25kr6 = aSJ6gh2;
        return aSJ6gh2;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        A4TApA(map.size() + this.f1011AmA8tU);
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        A5SV6n a5SV6n = this.f982B2KMhB;
        if (a5SV6n != null) {
            return a5SV6n;
        }
        A5SV6n a5SV6n2 = new A5SV6n(0, this);
        this.f982B2KMhB = a5SV6n2;
        return a5SV6n2;
    }

    public ADYaiT() {
    }
}

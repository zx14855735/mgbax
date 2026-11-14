package NasM11;

import QkAq4X.ASJ6gh;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class A2egSU extends AbstractSet {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final QkAq4X.A4TApA f6034AcNBzu = new QkAq4X.A4TApA();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        QkAq4X.A4TApA a4TApA = this.f6034AcNBzu;
        if (a4TApA.containsKey(obj)) {
            return false;
        }
        a4TApA.put(obj, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        if (!(collection instanceof A2egSU)) {
            return super.addAll(collection);
        }
        QkAq4X.A4TApA a4TApA = this.f6034AcNBzu;
        int i = a4TApA.f7752AmA8tU;
        QkAq4X.A4TApA a4TApA2 = ((A2egSU) collection).f6034AcNBzu;
        int i2 = a4TApA2.f7752AmA8tU;
        a4TApA.A5SV6n(i + i2);
        if (a4TApA.f7752AmA8tU != 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                a4TApA.put(a4TApA2.f7751AlLFFp[i3 << 1], a4TApA2.ARc23Z(i3));
            }
        } else if (i2 > 0) {
            System.arraycopy(a4TApA2.f7750AcNBzu, 0, a4TApA.f7750AcNBzu, 0, i2);
            System.arraycopy(a4TApA2.f7751AlLFFp, 0, a4TApA.f7751AlLFFp, 0, i2 << 1);
            a4TApA.f7752AmA8tU = i2;
        }
        return a4TApA.f7752AmA8tU > i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f6034AcNBzu.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f6034AcNBzu.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return ((ASJ6gh) this.f6034AcNBzu.keySet()).iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        QkAq4X.A4TApA a4TApA = this.f6034AcNBzu;
        if (!a4TApA.containsKey(obj)) {
            return false;
        }
        a4TApA.remove(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f6034AcNBzu.f7752AmA8tU;
    }
}

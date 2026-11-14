package QkAq4X;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ASJ6gh implements Set {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f7744AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Object f7745AlLFFp;

    public /* synthetic */ ASJ6gh(int i, Object obj) {
        this.f7744AcNBzu = i;
        this.f7745AlLFFp = obj;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        switch (this.f7744AcNBzu) {
            case 0:
                throw new UnsupportedOperationException();
            case 1:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        switch (this.f7744AcNBzu) {
            case 0:
                A2egSU a2egSU = (A2egSU) this.f7745AlLFFp;
                int A2egSU2 = a2egSU.A2egSU();
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    switch (a2egSU.f7723ADYaiT) {
                        case 0:
                            ((A4TApA) a2egSU.AMqCpz).put(key, value);
                            break;
                        default:
                            ((A5SV6n) a2egSU.AMqCpz).add(key);
                            break;
                    }
                }
                return A2egSU2 != a2egSU.A2egSU();
            case 1:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        switch (this.f7744AcNBzu) {
            case 0:
                ((A2egSU) this.f7745AlLFFp).AZOQYO();
                break;
            case 1:
                ((A2egSU) this.f7745AlLFFp).AZOQYO();
                break;
            default:
                ((B25kr6.ADYaiT) this.f7745AlLFFp).clear();
                break;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        switch (this.f7744AcNBzu) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                A2egSU a2egSU = (A2egSU) this.f7745AlLFFp;
                int A4TApA2 = a2egSU.A4TApA(key);
                if (A4TApA2 < 0) {
                    return false;
                }
                Object A5SV6n2 = a2egSU.A5SV6n(A4TApA2, 1);
                Object value = entry.getValue();
                return A5SV6n2 == value || (A5SV6n2 != null && A5SV6n2.equals(value));
            case 1:
                return ((A2egSU) this.f7745AlLFFp).A4TApA(obj) >= 0;
            default:
                return ((B25kr6.ADYaiT) this.f7745AlLFFp).containsKey(obj);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        switch (this.f7744AcNBzu) {
            case 0:
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    if (!contains(it.next())) {
                        return false;
                    }
                }
                return true;
            case 1:
                Map AYUAbz2 = ((A2egSU) this.f7745AlLFFp).AYUAbz();
                Iterator it2 = collection.iterator();
                while (it2.hasNext()) {
                    if (!AYUAbz2.containsKey(it2.next())) {
                        return false;
                    }
                }
                return true;
            default:
                return ((B25kr6.ADYaiT) this.f7745AlLFFp).AaHO0E(collection);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        switch (this.f7744AcNBzu) {
            case 0:
                break;
            case 1:
                break;
            default:
                if (this != obj) {
                    if (obj instanceof Set) {
                        Set set = (Set) obj;
                        B25kr6.ADYaiT aDYaiT = (B25kr6.ADYaiT) this.f7745AlLFFp;
                        try {
                            if (aDYaiT.f1011AmA8tU == set.size()) {
                                if (aDYaiT.AaHO0E(set)) {
                                }
                            }
                        } catch (ClassCastException | NullPointerException unused) {
                            break;
                        }
                    }
                }
                break;
        }
        return A2egSU.AMqCpz(this, obj);
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        switch (this.f7744AcNBzu) {
            case 0:
                A2egSU a2egSU = (A2egSU) this.f7745AlLFFp;
                int A2egSU2 = a2egSU.A2egSU() - 1;
                int i = 0;
                while (A2egSU2 >= 0) {
                    Object A5SV6n2 = a2egSU.A5SV6n(A2egSU2, 0);
                    Object A5SV6n3 = a2egSU.A5SV6n(A2egSU2, 1);
                    A2egSU2--;
                    i += (A5SV6n2 == null ? 0 : A5SV6n2.hashCode()) ^ (A5SV6n3 == null ? 0 : A5SV6n3.hashCode());
                }
                return i;
            case 1:
                A2egSU a2egSU2 = (A2egSU) this.f7745AlLFFp;
                int A2egSU3 = a2egSU2.A2egSU() - 1;
                int i2 = 0;
                while (A2egSU3 >= 0) {
                    Object A5SV6n4 = a2egSU2.A5SV6n(A2egSU3, 0);
                    A2egSU3--;
                    i2 += A5SV6n4 == null ? 0 : A5SV6n4.hashCode();
                }
                return i2;
            default:
                B25kr6.ADYaiT aDYaiT = (B25kr6.ADYaiT) this.f7745AlLFFp;
                int i3 = 0;
                for (int i4 = aDYaiT.f1011AmA8tU - 1; i4 >= 0; i4--) {
                    Object ARc23Z2 = aDYaiT.ARc23Z(i4);
                    i3 += ARc23Z2 == null ? 0 : ARc23Z2.hashCode();
                }
                return i3;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        switch (this.f7744AcNBzu) {
            case 0:
                return ((A2egSU) this.f7745AlLFFp).A2egSU() == 0;
            case 1:
                return ((A2egSU) this.f7745AlLFFp).A2egSU() == 0;
            default:
                return ((B25kr6.ADYaiT) this.f7745AlLFFp).isEmpty();
        }
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f7744AcNBzu) {
            case 0:
                return new B25kr6.A4TApA((A2egSU) this.f7745AlLFFp);
            case 1:
                return new ARc23Z((A2egSU) this.f7745AlLFFp, 0);
            default:
                return new B25kr6.A2egSU((B25kr6.ADYaiT) this.f7745AlLFFp, 0);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        switch (this.f7744AcNBzu) {
            case 0:
                throw new UnsupportedOperationException();
            case 1:
                A2egSU a2egSU = (A2egSU) this.f7745AlLFFp;
                int A4TApA2 = a2egSU.A4TApA(obj);
                if (A4TApA2 < 0) {
                    return false;
                }
                a2egSU.ADYaiT(A4TApA2);
                return true;
            default:
                B25kr6.ADYaiT aDYaiT = (B25kr6.ADYaiT) this.f7745AlLFFp;
                int ADYaiT2 = aDYaiT.ADYaiT(obj);
                if (ADYaiT2 < 0) {
                    return false;
                }
                aDYaiT.AYUAbz(ADYaiT2);
                return true;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection collection) {
        switch (this.f7744AcNBzu) {
            case 0:
                throw new UnsupportedOperationException();
            case 1:
                Map AYUAbz2 = ((A2egSU) this.f7745AlLFFp).AYUAbz();
                int size = AYUAbz2.size();
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    AYUAbz2.remove(it.next());
                }
                return size != AYUAbz2.size();
            default:
                return ((B25kr6.ADYaiT) this.f7745AlLFFp).AcNBzu(collection);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        switch (this.f7744AcNBzu) {
            case 0:
                throw new UnsupportedOperationException();
            case 1:
                Map AYUAbz2 = ((A2egSU) this.f7745AlLFFp).AYUAbz();
                int size = AYUAbz2.size();
                Iterator it = AYUAbz2.keySet().iterator();
                while (it.hasNext()) {
                    if (!collection.contains(it.next())) {
                        it.remove();
                    }
                }
                return size != AYUAbz2.size();
            default:
                return ((B25kr6.ADYaiT) this.f7745AlLFFp).AlLFFp(collection);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        switch (this.f7744AcNBzu) {
            case 0:
                return ((A2egSU) this.f7745AlLFFp).A2egSU();
            case 1:
                return ((A2egSU) this.f7745AlLFFp).A2egSU();
            default:
                return ((B25kr6.ADYaiT) this.f7745AlLFFp).f1011AmA8tU;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        switch (this.f7744AcNBzu) {
            case 0:
                throw new UnsupportedOperationException();
            case 1:
                A2egSU a2egSU = (A2egSU) this.f7745AlLFFp;
                int A2egSU2 = a2egSU.A2egSU();
                Object[] objArr = new Object[A2egSU2];
                for (int i = 0; i < A2egSU2; i++) {
                    objArr[i] = a2egSU.A5SV6n(i, 0);
                }
                return objArr;
            default:
                B25kr6.ADYaiT aDYaiT = (B25kr6.ADYaiT) this.f7745AlLFFp;
                int i2 = aDYaiT.f1011AmA8tU;
                Object[] objArr2 = new Object[i2];
                for (int i3 = 0; i3 < i2; i3++) {
                    objArr2[i3] = aDYaiT.ARc23Z(i3);
                }
                return objArr2;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        switch (this.f7744AcNBzu) {
            case 0:
                throw new UnsupportedOperationException();
            case 1:
                return ((A2egSU) this.f7745AlLFFp).ARc23Z(objArr, 0);
            default:
                B25kr6.ADYaiT aDYaiT = (B25kr6.ADYaiT) this.f7745AlLFFp;
                int i = aDYaiT.f1011AmA8tU;
                if (objArr.length < i) {
                    objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
                }
                for (int i2 = 0; i2 < i; i2++) {
                    objArr[i2] = aDYaiT.ARc23Z(i2);
                }
                if (objArr.length > i) {
                    objArr[i] = null;
                }
                return objArr;
        }
    }
}

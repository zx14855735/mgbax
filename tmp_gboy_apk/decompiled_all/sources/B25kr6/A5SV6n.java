package B25kr6;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n implements Collection {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f978AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Object f979AlLFFp;

    public /* synthetic */ A5SV6n(int i, Object obj) {
        this.f978AcNBzu = i;
        this.f979AlLFFp = obj;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        switch (this.f978AcNBzu) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        switch (this.f978AcNBzu) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Collection
    public final void clear() {
        switch (this.f978AcNBzu) {
            case 0:
                ((ADYaiT) this.f979AlLFFp).clear();
                break;
            default:
                ((QkAq4X.A2egSU) this.f979AlLFFp).AZOQYO();
                break;
        }
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        switch (this.f978AcNBzu) {
            case 0:
                if (((ADYaiT) this.f979AlLFFp).A2egSU(obj) >= 0) {
                }
                break;
            default:
                if (((QkAq4X.A2egSU) this.f979AlLFFp).ASJ6gh(obj) >= 0) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        switch (this.f978AcNBzu) {
            case 0:
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    if (!contains(it.next())) {
                        break;
                    }
                }
                break;
            default:
                Iterator it2 = collection.iterator();
                while (it2.hasNext()) {
                    if (!contains(it2.next())) {
                        break;
                    }
                }
                break;
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        switch (this.f978AcNBzu) {
            case 0:
                return ((ADYaiT) this.f979AlLFFp).isEmpty();
            default:
                return ((QkAq4X.A2egSU) this.f979AlLFFp).A2egSU() == 0;
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f978AcNBzu) {
            case 0:
                return new A2egSU((ADYaiT) this.f979AlLFFp, 1);
            default:
                return new QkAq4X.ARc23Z((QkAq4X.A2egSU) this.f979AlLFFp, 1);
        }
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        switch (this.f978AcNBzu) {
            case 0:
                ADYaiT aDYaiT = (ADYaiT) this.f979AlLFFp;
                int A2egSU2 = aDYaiT.A2egSU(obj);
                if (A2egSU2 >= 0) {
                    aDYaiT.AYUAbz(A2egSU2);
                    break;
                }
                break;
            default:
                QkAq4X.A2egSU a2egSU = (QkAq4X.A2egSU) this.f979AlLFFp;
                int ASJ6gh2 = a2egSU.ASJ6gh(obj);
                if (ASJ6gh2 >= 0) {
                    a2egSU.ADYaiT(ASJ6gh2);
                    break;
                }
                break;
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        switch (this.f978AcNBzu) {
            case 0:
                ADYaiT aDYaiT = (ADYaiT) this.f979AlLFFp;
                int i = aDYaiT.f1011AmA8tU;
                int i2 = 0;
                boolean z = false;
                while (i2 < i) {
                    if (collection.contains(aDYaiT.AZkASS(i2))) {
                        aDYaiT.AYUAbz(i2);
                        i2--;
                        i--;
                        z = true;
                    }
                    i2++;
                }
                return z;
            default:
                QkAq4X.A2egSU a2egSU = (QkAq4X.A2egSU) this.f979AlLFFp;
                int A2egSU2 = a2egSU.A2egSU();
                int i3 = 0;
                boolean z2 = false;
                while (i3 < A2egSU2) {
                    if (collection.contains(a2egSU.A5SV6n(i3, 1))) {
                        a2egSU.ADYaiT(i3);
                        i3--;
                        A2egSU2--;
                        z2 = true;
                    }
                    i3++;
                }
                return z2;
        }
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        switch (this.f978AcNBzu) {
            case 0:
                ADYaiT aDYaiT = (ADYaiT) this.f979AlLFFp;
                int i = aDYaiT.f1011AmA8tU;
                int i2 = 0;
                boolean z = false;
                while (i2 < i) {
                    if (!collection.contains(aDYaiT.AZkASS(i2))) {
                        aDYaiT.AYUAbz(i2);
                        i2--;
                        i--;
                        z = true;
                    }
                    i2++;
                }
                return z;
            default:
                QkAq4X.A2egSU a2egSU = (QkAq4X.A2egSU) this.f979AlLFFp;
                int A2egSU2 = a2egSU.A2egSU();
                int i3 = 0;
                boolean z2 = false;
                while (i3 < A2egSU2) {
                    if (!collection.contains(a2egSU.A5SV6n(i3, 1))) {
                        a2egSU.ADYaiT(i3);
                        i3--;
                        A2egSU2--;
                        z2 = true;
                    }
                    i3++;
                }
                return z2;
        }
    }

    @Override // java.util.Collection
    public final int size() {
        switch (this.f978AcNBzu) {
            case 0:
                return ((ADYaiT) this.f979AlLFFp).f1011AmA8tU;
            default:
                return ((QkAq4X.A2egSU) this.f979AlLFFp).A2egSU();
        }
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        switch (this.f978AcNBzu) {
            case 0:
                ADYaiT aDYaiT = (ADYaiT) this.f979AlLFFp;
                int i = aDYaiT.f1011AmA8tU;
                Object[] objArr = new Object[i];
                for (int i2 = 0; i2 < i; i2++) {
                    objArr[i2] = aDYaiT.AZkASS(i2);
                }
                return objArr;
            default:
                QkAq4X.A2egSU a2egSU = (QkAq4X.A2egSU) this.f979AlLFFp;
                int A2egSU2 = a2egSU.A2egSU();
                Object[] objArr2 = new Object[A2egSU2];
                for (int i3 = 0; i3 < A2egSU2; i3++) {
                    objArr2[i3] = a2egSU.A5SV6n(i3, 1);
                }
                return objArr2;
        }
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        switch (this.f978AcNBzu) {
            case 0:
                ADYaiT aDYaiT = (ADYaiT) this.f979AlLFFp;
                int i = aDYaiT.f1011AmA8tU;
                if (objArr.length < i) {
                    objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
                }
                for (int i2 = 0; i2 < i; i2++) {
                    objArr[i2] = aDYaiT.AZkASS(i2);
                }
                if (objArr.length > i) {
                    objArr[i] = null;
                }
                return objArr;
            default:
                return ((QkAq4X.A2egSU) this.f979AlLFFp).ARc23Z(objArr, 1);
        }
    }
}

package RFbdkT;

import RD2OKB.ADYaiT;
import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A2egSU implements ListIterator {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f7850AlLFFp;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f7852AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final ADYaiT f7853B25kr6;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f7849AcNBzu = 0;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f7851AmA8tU = -1;

    public A2egSU(A5SV6n a5SV6n, int i) {
        int i2;
        this.f7853B25kr6 = a5SV6n;
        this.f7850AlLFFp = i;
        i2 = ((AbstractList) a5SV6n).modCount;
        this.f7852AzWtSf = i2;
    }

    public final void A2egSU() {
        int i;
        int i2;
        switch (this.f7849AcNBzu) {
            case 0:
                i = ((AbstractList) ((A4TApA) this.f7853B25kr6).f7858B25kr6).modCount;
                if (i != this.f7852AzWtSf) {
                    throw new ConcurrentModificationException();
                }
                return;
            default:
                i2 = ((AbstractList) ((A5SV6n) this.f7853B25kr6)).modCount;
                if (i2 != this.f7852AzWtSf) {
                    throw new ConcurrentModificationException();
                }
                return;
        }
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        int i;
        int i2;
        switch (this.f7849AcNBzu) {
            case 0:
                A2egSU();
                int i3 = this.f7850AlLFFp;
                this.f7850AlLFFp = i3 + 1;
                A4TApA a4TApA = (A4TApA) this.f7853B25kr6;
                a4TApA.add(i3, obj);
                this.f7851AmA8tU = -1;
                i = ((AbstractList) a4TApA).modCount;
                this.f7852AzWtSf = i;
                break;
            default:
                A2egSU();
                int i4 = this.f7850AlLFFp;
                this.f7850AlLFFp = i4 + 1;
                A5SV6n a5SV6n = (A5SV6n) this.f7853B25kr6;
                a5SV6n.add(i4, obj);
                this.f7851AmA8tU = -1;
                i2 = ((AbstractList) a5SV6n).modCount;
                this.f7852AzWtSf = i2;
                break;
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        switch (this.f7849AcNBzu) {
            case 0:
                if (this.f7850AlLFFp < ((A4TApA) this.f7853B25kr6).f7856AmA8tU) {
                }
                break;
            default:
                if (this.f7850AlLFFp < ((A5SV6n) this.f7853B25kr6).f7861AlLFFp) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        switch (this.f7849AcNBzu) {
            case 0:
                if (this.f7850AlLFFp > 0) {
                }
                break;
            default:
                if (this.f7850AlLFFp > 0) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        switch (this.f7849AcNBzu) {
            case 0:
                A2egSU();
                int i = this.f7850AlLFFp;
                A4TApA a4TApA = (A4TApA) this.f7853B25kr6;
                if (i >= a4TApA.f7856AmA8tU) {
                    throw new NoSuchElementException();
                }
                this.f7850AlLFFp = i + 1;
                this.f7851AmA8tU = i;
                return a4TApA.f7854AcNBzu[a4TApA.f7855AlLFFp + i];
            default:
                A2egSU();
                int i2 = this.f7850AlLFFp;
                A5SV6n a5SV6n = (A5SV6n) this.f7853B25kr6;
                if (i2 >= a5SV6n.f7861AlLFFp) {
                    throw new NoSuchElementException();
                }
                this.f7850AlLFFp = i2 + 1;
                this.f7851AmA8tU = i2;
                return a5SV6n.f7860AcNBzu[i2];
        }
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        switch (this.f7849AcNBzu) {
        }
        return this.f7850AlLFFp;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        switch (this.f7849AcNBzu) {
            case 0:
                A2egSU();
                int i = this.f7850AlLFFp;
                if (i <= 0) {
                    throw new NoSuchElementException();
                }
                int i2 = i - 1;
                this.f7850AlLFFp = i2;
                this.f7851AmA8tU = i2;
                A4TApA a4TApA = (A4TApA) this.f7853B25kr6;
                return a4TApA.f7854AcNBzu[a4TApA.f7855AlLFFp + i2];
            default:
                A2egSU();
                int i3 = this.f7850AlLFFp;
                if (i3 <= 0) {
                    throw new NoSuchElementException();
                }
                int i4 = i3 - 1;
                this.f7850AlLFFp = i4;
                this.f7851AmA8tU = i4;
                return ((A5SV6n) this.f7853B25kr6).f7860AcNBzu[i4];
        }
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        switch (this.f7849AcNBzu) {
        }
        return this.f7850AlLFFp - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        int i;
        int i2;
        switch (this.f7849AcNBzu) {
            case 0:
                A2egSU();
                int i3 = this.f7851AmA8tU;
                if (i3 == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                A4TApA a4TApA = (A4TApA) this.f7853B25kr6;
                a4TApA.A4TApA(i3);
                this.f7850AlLFFp = this.f7851AmA8tU;
                this.f7851AmA8tU = -1;
                i = ((AbstractList) a4TApA).modCount;
                this.f7852AzWtSf = i;
                return;
            default:
                A2egSU();
                int i4 = this.f7851AmA8tU;
                if (i4 == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                A5SV6n a5SV6n = (A5SV6n) this.f7853B25kr6;
                a5SV6n.A4TApA(i4);
                this.f7850AlLFFp = this.f7851AmA8tU;
                this.f7851AmA8tU = -1;
                i2 = ((AbstractList) a5SV6n).modCount;
                this.f7852AzWtSf = i2;
                return;
        }
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        switch (this.f7849AcNBzu) {
            case 0:
                A2egSU();
                int i = this.f7851AmA8tU;
                if (i == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                ((A4TApA) this.f7853B25kr6).set(i, obj);
                return;
            default:
                A2egSU();
                int i2 = this.f7851AmA8tU;
                if (i2 == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                ((A5SV6n) this.f7853B25kr6).set(i2, obj);
                return;
        }
    }

    public A2egSU(A4TApA a4TApA, int i) {
        int i2;
        this.f7853B25kr6 = a4TApA;
        this.f7850AlLFFp = i;
        i2 = ((AbstractList) a4TApA).modCount;
        this.f7852AzWtSf = i2;
    }
}

package B25kr6;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU implements Iterator {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f968AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f969AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f970AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ int f971AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final /* synthetic */ Object f972B25kr6;

    public A2egSU(int i) {
        this.f968AcNBzu = i;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f969AlLFFp < this.f968AcNBzu;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object ARc23Z2;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.f969AlLFFp;
        switch (this.f971AzWtSf) {
            case 0:
                ARc23Z2 = ((ADYaiT) this.f972B25kr6).ARc23Z(i);
                break;
            case 1:
                ARc23Z2 = ((ADYaiT) this.f972B25kr6).AZkASS(i);
                break;
            default:
                ARc23Z2 = ((AMqCpz) this.f972B25kr6).f984AlLFFp[i];
                break;
        }
        this.f969AlLFFp++;
        this.f970AmA8tU = true;
        return ARc23Z2;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f970AmA8tU) {
            throw new IllegalStateException("Call next() before removing an element.");
        }
        int i = this.f969AlLFFp - 1;
        this.f969AlLFFp = i;
        switch (this.f971AzWtSf) {
            case 0:
                ((ADYaiT) this.f972B25kr6).AYUAbz(i);
                break;
            case 1:
                ((ADYaiT) this.f972B25kr6).AYUAbz(i);
                break;
            default:
                ((AMqCpz) this.f972B25kr6).A2egSU(i);
                break;
        }
        this.f968AcNBzu--;
        this.f970AmA8tU = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public A2egSU(AMqCpz aMqCpz) {
        this(aMqCpz.f985AmA8tU);
        this.f971AzWtSf = 2;
        this.f972B25kr6 = aMqCpz;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public A2egSU(ADYaiT aDYaiT, int i) {
        this(aDYaiT.f1011AmA8tU);
        this.f971AzWtSf = i;
        switch (i) {
            case 1:
                this.f972B25kr6 = aDYaiT;
                this(aDYaiT.f1011AmA8tU);
                break;
            default:
                this.f972B25kr6 = aDYaiT;
                break;
        }
    }
}

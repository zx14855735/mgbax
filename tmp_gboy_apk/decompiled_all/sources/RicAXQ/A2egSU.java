package RicAXQ;

import COJEAR.DcUJf1;
import R8Rbcg.AMqCpz;
import RJJjP9.ADYaiT;
import RXb0Sz.ARc23Z;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A2egSU extends A4TApA implements Iterator, RJJjP9.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f7904AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Object f7905AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public Iterator f7906AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public RJJjP9.A2egSU f7907AzWtSf;

    @Override // RicAXQ.A4TApA
    public final void A2egSU(Object obj, DcUJf1 dcUJf1) {
        this.f7905AlLFFp = obj;
        this.f7904AcNBzu = 3;
        this.f7907AzWtSf = dcUJf1;
    }

    @Override // RicAXQ.A4TApA
    public final Object A4TApA(Iterator it, DcUJf1 dcUJf1) {
        if (!it.hasNext()) {
            return AMqCpz.f7833A5SV6n;
        }
        this.f7906AmA8tU = it;
        this.f7904AcNBzu = 2;
        this.f7907AzWtSf = dcUJf1;
        return RLgVYi.A2egSU.f7865AcNBzu;
    }

    public final RuntimeException A5SV6n() {
        int i = this.f7904AcNBzu;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f7904AcNBzu);
    }

    @Override // RJJjP9.A2egSU
    public ADYaiT getContext() {
        return RJJjP9.AMqCpz.f7864AcNBzu;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            int i = this.f7904AcNBzu;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        return true;
                    }
                    if (i == 4) {
                        return false;
                    }
                    throw A5SV6n();
                }
                Iterator it = this.f7906AmA8tU;
                ARc23Z.A4TApA(it);
                if (it.hasNext()) {
                    this.f7904AcNBzu = 2;
                    return true;
                }
                this.f7906AmA8tU = null;
            }
            this.f7904AcNBzu = 5;
            RJJjP9.A2egSU a2egSU = this.f7907AzWtSf;
            ARc23Z.A4TApA(a2egSU);
            this.f7907AzWtSf = null;
            a2egSU.resumeWith(AMqCpz.f7833A5SV6n);
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.f7904AcNBzu;
        if (i == 0 || i == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        }
        if (i == 2) {
            this.f7904AcNBzu = 1;
            Iterator it = this.f7906AmA8tU;
            ARc23Z.A4TApA(it);
            return it.next();
        }
        if (i != 3) {
            throw A5SV6n();
        }
        this.f7904AcNBzu = 0;
        Object obj = this.f7905AlLFFp;
        this.f7905AlLFFp = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // RJJjP9.A2egSU
    public final void resumeWith(Object obj) {
        com.bumptech.glide.AMqCpz.CqNSpT(obj);
        this.f7904AcNBzu = 4;
    }
}

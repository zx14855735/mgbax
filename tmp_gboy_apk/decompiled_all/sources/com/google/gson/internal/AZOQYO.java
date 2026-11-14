package com.google.gson.internal;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AZOQYO implements Iterator {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public AaHO0E f12037AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public AaHO0E f12038AlLFFp = null;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f12039AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ AcNBzu f12040AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final /* synthetic */ int f12041B25kr6;

    public AZOQYO(AcNBzu acNBzu, int i) {
        this.f12041B25kr6 = i;
        this.f12040AzWtSf = acNBzu;
        this.f12037AcNBzu = acNBzu.f12057B25kr6.f12047AzWtSf;
        this.f12039AmA8tU = acNBzu.f12056AzWtSf;
    }

    public final Object A2egSU() {
        return A4TApA();
    }

    public final AaHO0E A4TApA() {
        AaHO0E aaHO0E = this.f12037AcNBzu;
        AcNBzu acNBzu = this.f12040AzWtSf;
        if (aaHO0E == acNBzu.f12057B25kr6) {
            throw new NoSuchElementException();
        }
        if (acNBzu.f12056AzWtSf != this.f12039AmA8tU) {
            throw new ConcurrentModificationException();
        }
        this.f12037AcNBzu = aaHO0E.f12047AzWtSf;
        this.f12038AlLFFp = aaHO0E;
        return aaHO0E;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f12037AcNBzu != this.f12040AzWtSf.f12057B25kr6;
    }

    @Override // java.util.Iterator
    public Object next() {
        switch (this.f12041B25kr6) {
            case 1:
                return A4TApA().f12049B2KMhB;
            default:
                return A2egSU();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        AaHO0E aaHO0E = this.f12038AlLFFp;
        if (aaHO0E == null) {
            throw new IllegalStateException();
        }
        AcNBzu acNBzu = this.f12040AzWtSf;
        acNBzu.A5SV6n(aaHO0E, true);
        this.f12038AlLFFp = null;
        this.f12039AmA8tU = acNBzu.f12056AzWtSf;
    }
}

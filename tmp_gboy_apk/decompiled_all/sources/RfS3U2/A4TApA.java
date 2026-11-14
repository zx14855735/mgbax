package RfS3U2;

import RD2OKB.BIYEnU;
import java.util.NoSuchElementException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A4TApA extends BIYEnU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f7899AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final int f7900AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f7901AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f7902AzWtSf;

    public A4TApA(int i, int i2, int i3) {
        this.f7899AcNBzu = i3;
        this.f7900AlLFFp = i2;
        boolean z = false;
        if (i3 <= 0 ? i >= i2 : i <= i2) {
            z = true;
        }
        this.f7901AmA8tU = z;
        this.f7902AzWtSf = z ? i : i2;
    }

    @Override // RD2OKB.BIYEnU
    public final int A2egSU() {
        int i = this.f7902AzWtSf;
        if (i != this.f7900AlLFFp) {
            this.f7902AzWtSf = this.f7899AcNBzu + i;
            return i;
        }
        if (!this.f7901AmA8tU) {
            throw new NoSuchElementException();
        }
        this.f7901AmA8tU = false;
        return i;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f7901AmA8tU;
    }
}

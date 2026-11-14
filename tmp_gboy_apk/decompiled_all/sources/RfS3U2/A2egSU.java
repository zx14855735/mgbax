package RfS3U2;

import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class A2egSU implements Iterable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f7896AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final int f7897AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final int f7898AmA8tU;

    public A2egSU(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f7896AcNBzu = i;
        if (i3 > 0) {
            if (i < i2) {
                int i4 = i2 % i3;
                int i5 = i % i3;
                int i6 = ((i4 < 0 ? i4 + i3 : i4) - (i5 < 0 ? i5 + i3 : i5)) % i3;
                i2 -= i6 < 0 ? i6 + i3 : i6;
            }
        } else {
            if (i3 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (i > i2) {
                int i7 = -i3;
                int i8 = i % i7;
                int i9 = i2 % i7;
                int i10 = ((i8 < 0 ? i8 + i7 : i8) - (i9 < 0 ? i9 + i7 : i9)) % i7;
                i2 += i10 < 0 ? i10 + i7 : i10;
            }
        }
        this.f7897AlLFFp = i2;
        this.f7898AmA8tU = i3;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new A4TApA(this.f7896AcNBzu, this.f7897AlLFFp, this.f7898AmA8tU);
    }
}

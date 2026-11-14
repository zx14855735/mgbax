package RD2OKB;

import java.util.RandomAccess;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A4TApA extends A5SV6n implements RandomAccess {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final A5SV6n f7836AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final int f7837AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final int f7838AmA8tU;

    public A4TApA(A5SV6n a5SV6n, int i, int i2) {
        this.f7836AcNBzu = a5SV6n;
        this.f7837AlLFFp = i;
        JrXYwF.A4TApA.B7CMnp(i, i2, a5SV6n.A2egSU());
        this.f7838AmA8tU = i2 - i;
    }

    @Override // RD2OKB.A5SV6n
    public final int A2egSU() {
        return this.f7838AmA8tU;
    }

    @Override // java.util.List
    public final Object get(int i) {
        int i2 = this.f7838AmA8tU;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(i, i2, "index: ", ", size: "));
        }
        return this.f7836AcNBzu.get(this.f7837AlLFFp + i);
    }
}

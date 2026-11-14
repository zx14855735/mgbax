package HXc4pW;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B9tovu implements BTvldC {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final boolean f3604AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final boolean f3605AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final BTvldC f3606AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final AzWtSf f3607AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final B7CMnp f3608B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f3609B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public boolean f3610B3GDIM;

    public B9tovu(BTvldC bTvldC, boolean z, boolean z2, B7CMnp b7CMnp, AzWtSf azWtSf) {
        ItGa5w.ARc23Z.A5SV6n(bTvldC, "Argument must not be null");
        this.f3606AmA8tU = bTvldC;
        this.f3604AcNBzu = z;
        this.f3605AlLFFp = z2;
        this.f3608B25kr6 = b7CMnp;
        ItGa5w.ARc23Z.A5SV6n(azWtSf, "Argument must not be null");
        this.f3607AzWtSf = azWtSf;
    }

    @Override // HXc4pW.BTvldC
    public final synchronized void A2egSU() {
        if (this.f3609B2KMhB > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f3610B3GDIM) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f3610B3GDIM = true;
        if (this.f3605AlLFFp) {
            this.f3606AmA8tU.A2egSU();
        }
    }

    @Override // HXc4pW.BTvldC
    public final Class A4TApA() {
        return this.f3606AmA8tU.A4TApA();
    }

    public final synchronized void A5SV6n() {
        if (this.f3610B3GDIM) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f3609B2KMhB++;
    }

    public final void ADYaiT() {
        boolean z;
        synchronized (this) {
            int i = this.f3609B2KMhB;
            if (i <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z = true;
            int i2 = i - 1;
            this.f3609B2KMhB = i2;
            if (i2 != 0) {
                z = false;
            }
        }
        if (z) {
            this.f3607AzWtSf.AMqCpz(this.f3608B25kr6, this);
        }
    }

    @Override // HXc4pW.BTvldC
    public final Object get() {
        return this.f3606AmA8tU.get();
    }

    @Override // HXc4pW.BTvldC
    public final int getSize() {
        return this.f3606AmA8tU.getSize();
    }

    public final synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f3604AcNBzu + ", listener=" + this.f3607AzWtSf + ", key=" + this.f3608B25kr6 + ", acquired=" + this.f3609B2KMhB + ", isRecycled=" + this.f3610B3GDIM + ", resource=" + this.f3606AmA8tU + '}';
    }
}

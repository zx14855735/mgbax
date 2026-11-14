package IhMMDv;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA implements ADYaiT, A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Object f4001A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Object f4002A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public volatile A5SV6n f4003A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public volatile A5SV6n f4004ADYaiT;
    public int AMqCpz = 3;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f4005ARc23Z = 3;

    public A4TApA(Object obj, ADYaiT aDYaiT) {
        this.f4001A2egSU = obj;
        this.f4002A4TApA = aDYaiT;
    }

    @Override // IhMMDv.ADYaiT, IhMMDv.A5SV6n
    public final boolean A2egSU() {
        boolean z;
        synchronized (this.f4001A2egSU) {
            try {
                z = this.f4003A5SV6n.A2egSU() || this.f4004ADYaiT.A2egSU();
            } finally {
            }
        }
        return z;
    }

    @Override // IhMMDv.A5SV6n
    public final boolean A4TApA(A5SV6n a5SV6n) {
        if (a5SV6n instanceof A4TApA) {
            A4TApA a4TApA = (A4TApA) a5SV6n;
            if (this.f4003A5SV6n.A4TApA(a4TApA.f4003A5SV6n) && this.f4004ADYaiT.A4TApA(a4TApA.f4004ADYaiT)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [IhMMDv.ADYaiT, java.lang.Object] */
    @Override // IhMMDv.ADYaiT
    public final ADYaiT A5SV6n() {
        ADYaiT A5SV6n2;
        synchronized (this.f4001A2egSU) {
            try {
                ?? r1 = this.f4002A4TApA;
                A5SV6n2 = r1 != 0 ? r1.A5SV6n() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return A5SV6n2;
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [IhMMDv.ADYaiT, java.lang.Object] */
    @Override // IhMMDv.ADYaiT
    public final void ADYaiT(A5SV6n a5SV6n) {
        synchronized (this.f4001A2egSU) {
            try {
                if (a5SV6n.equals(this.f4003A5SV6n)) {
                    this.AMqCpz = 4;
                } else if (a5SV6n.equals(this.f4004ADYaiT)) {
                    this.f4005ARc23Z = 4;
                }
                ?? r4 = this.f4002A4TApA;
                if (r4 != 0) {
                    r4.ADYaiT(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [IhMMDv.ADYaiT, java.lang.Object] */
    @Override // IhMMDv.ADYaiT
    public final boolean AMqCpz(A5SV6n a5SV6n) {
        boolean z;
        synchronized (this.f4001A2egSU) {
            ?? r1 = this.f4002A4TApA;
            z = (r1 == 0 || r1.AMqCpz(this)) && AcNBzu(a5SV6n);
        }
        return z;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [IhMMDv.ADYaiT, java.lang.Object] */
    @Override // IhMMDv.ADYaiT
    public final boolean ARc23Z(A5SV6n a5SV6n) {
        boolean z;
        synchronized (this.f4001A2egSU) {
            ?? r1 = this.f4002A4TApA;
            z = (r1 == 0 || r1.ARc23Z(this)) && AcNBzu(a5SV6n);
        }
        return z;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [IhMMDv.ADYaiT, java.lang.Object] */
    @Override // IhMMDv.ADYaiT
    public final boolean ASJ6gh(A5SV6n a5SV6n) {
        boolean z;
        synchronized (this.f4001A2egSU) {
            ?? r1 = this.f4002A4TApA;
            z = (r1 == 0 || r1.ASJ6gh(this)) && AcNBzu(a5SV6n);
        }
        return z;
    }

    @Override // IhMMDv.A5SV6n
    public final boolean AYUAbz() {
        boolean z;
        synchronized (this.f4001A2egSU) {
            try {
                z = this.AMqCpz == 3 && this.f4005ARc23Z == 3;
            } finally {
            }
        }
        return z;
    }

    @Override // IhMMDv.A5SV6n
    public final void AZOQYO() {
        synchronized (this.f4001A2egSU) {
            try {
                if (this.AMqCpz != 1) {
                    this.AMqCpz = 1;
                    this.f4003A5SV6n.AZOQYO();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [IhMMDv.ADYaiT, java.lang.Object] */
    @Override // IhMMDv.ADYaiT
    public final void AZkASS(A5SV6n a5SV6n) {
        synchronized (this.f4001A2egSU) {
            try {
                if (a5SV6n.equals(this.f4004ADYaiT)) {
                    this.f4005ARc23Z = 5;
                    ?? r3 = this.f4002A4TApA;
                    if (r3 != 0) {
                        r3.AZkASS(this);
                    }
                    return;
                }
                this.AMqCpz = 5;
                if (this.f4005ARc23Z != 1) {
                    this.f4005ARc23Z = 1;
                    this.f4004ADYaiT.AZOQYO();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // IhMMDv.A5SV6n
    public final boolean AaHO0E() {
        boolean z;
        synchronized (this.f4001A2egSU) {
            try {
                z = this.AMqCpz == 4 || this.f4005ARc23Z == 4;
            } finally {
            }
        }
        return z;
    }

    public final boolean AcNBzu(A5SV6n a5SV6n) {
        if (a5SV6n.equals(this.f4003A5SV6n)) {
            return true;
        }
        return this.AMqCpz == 5 && a5SV6n.equals(this.f4004ADYaiT);
    }

    @Override // IhMMDv.A5SV6n
    public final void clear() {
        synchronized (this.f4001A2egSU) {
            try {
                this.AMqCpz = 3;
                this.f4003A5SV6n.clear();
                if (this.f4005ARc23Z != 3) {
                    this.f4005ARc23Z = 3;
                    this.f4004ADYaiT.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // IhMMDv.A5SV6n
    public final boolean isRunning() {
        boolean z;
        synchronized (this.f4001A2egSU) {
            try {
                z = true;
                if (this.AMqCpz != 1 && this.f4005ARc23Z != 1) {
                    z = false;
                }
            } finally {
            }
        }
        return z;
    }

    @Override // IhMMDv.A5SV6n
    public final void pause() {
        synchronized (this.f4001A2egSU) {
            try {
                if (this.AMqCpz == 1) {
                    this.AMqCpz = 2;
                    this.f4003A5SV6n.pause();
                }
                if (this.f4005ARc23Z == 1) {
                    this.f4005ARc23Z = 2;
                    this.f4004ADYaiT.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

package IhMMDv;

import ADYaiT.CtFAbx;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AYUAbz implements ADYaiT, A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Object f4039A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Object f4040A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public volatile ASJ6gh f4041A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public volatile A5SV6n f4042ADYaiT;
    public int AMqCpz = 3;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f4043ARc23Z = 3;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public boolean f4044ASJ6gh;

    public AYUAbz(Object obj, ADYaiT aDYaiT) {
        this.f4040A4TApA = obj;
        this.f4039A2egSU = aDYaiT;
    }

    @Override // IhMMDv.ADYaiT, IhMMDv.A5SV6n
    public final boolean A2egSU() {
        boolean z;
        synchronized (this.f4040A4TApA) {
            try {
                z = this.f4042ADYaiT.A2egSU() || this.f4041A5SV6n.A2egSU();
            } finally {
            }
        }
        return z;
    }

    @Override // IhMMDv.A5SV6n
    public final boolean A4TApA(A5SV6n a5SV6n) {
        if (!(a5SV6n instanceof AYUAbz)) {
            return false;
        }
        AYUAbz aYUAbz = (AYUAbz) a5SV6n;
        if (this.f4041A5SV6n == null) {
            if (aYUAbz.f4041A5SV6n != null) {
                return false;
            }
        } else if (!this.f4041A5SV6n.A4TApA(aYUAbz.f4041A5SV6n)) {
            return false;
        }
        return this.f4042ADYaiT == null ? aYUAbz.f4042ADYaiT == null : this.f4042ADYaiT.A4TApA(aYUAbz.f4042ADYaiT);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [IhMMDv.ADYaiT, java.lang.Object] */
    @Override // IhMMDv.ADYaiT
    public final ADYaiT A5SV6n() {
        ADYaiT A5SV6n2;
        synchronized (this.f4040A4TApA) {
            try {
                ?? r1 = this.f4039A2egSU;
                A5SV6n2 = r1 != 0 ? r1.A5SV6n() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return A5SV6n2;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [IhMMDv.ADYaiT, java.lang.Object] */
    @Override // IhMMDv.ADYaiT
    public final void ADYaiT(A5SV6n a5SV6n) {
        synchronized (this.f4040A4TApA) {
            try {
                if (a5SV6n.equals(this.f4042ADYaiT)) {
                    this.f4043ARc23Z = 4;
                    return;
                }
                this.AMqCpz = 4;
                ?? r3 = this.f4039A2egSU;
                if (r3 != 0) {
                    r3.ADYaiT(this);
                }
                if (!CtFAbx.A2egSU(this.f4043ARc23Z)) {
                    this.f4042ADYaiT.clear();
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
        synchronized (this.f4040A4TApA) {
            try {
                ?? r1 = this.f4039A2egSU;
                z = (r1 == 0 || r1.AMqCpz(this)) && a5SV6n.equals(this.f4041A5SV6n) && !A2egSU();
            } finally {
            }
        }
        return z;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [IhMMDv.ADYaiT, java.lang.Object] */
    @Override // IhMMDv.ADYaiT
    public final boolean ARc23Z(A5SV6n a5SV6n) {
        boolean z;
        synchronized (this.f4040A4TApA) {
            try {
                ?? r1 = this.f4039A2egSU;
                z = (r1 == 0 || r1.ARc23Z(this)) && a5SV6n.equals(this.f4041A5SV6n) && this.AMqCpz != 2;
            } finally {
            }
        }
        return z;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [IhMMDv.ADYaiT, java.lang.Object] */
    @Override // IhMMDv.ADYaiT
    public final boolean ASJ6gh(A5SV6n a5SV6n) {
        boolean z;
        synchronized (this.f4040A4TApA) {
            try {
                ?? r1 = this.f4039A2egSU;
                z = (r1 == 0 || r1.ASJ6gh(this)) && (a5SV6n.equals(this.f4041A5SV6n) || this.AMqCpz != 4);
            } finally {
            }
        }
        return z;
    }

    @Override // IhMMDv.A5SV6n
    public final boolean AYUAbz() {
        boolean z;
        synchronized (this.f4040A4TApA) {
            z = this.AMqCpz == 3;
        }
        return z;
    }

    @Override // IhMMDv.A5SV6n
    public final void AZOQYO() {
        synchronized (this.f4040A4TApA) {
            try {
                this.f4044ASJ6gh = true;
                try {
                    if (this.AMqCpz != 4 && this.f4043ARc23Z != 1) {
                        this.f4043ARc23Z = 1;
                        this.f4042ADYaiT.AZOQYO();
                    }
                    if (this.f4044ASJ6gh && this.AMqCpz != 1) {
                        this.AMqCpz = 1;
                        this.f4041A5SV6n.AZOQYO();
                    }
                    this.f4044ASJ6gh = false;
                } catch (Throwable th) {
                    this.f4044ASJ6gh = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [IhMMDv.ADYaiT, java.lang.Object] */
    @Override // IhMMDv.ADYaiT
    public final void AZkASS(A5SV6n a5SV6n) {
        synchronized (this.f4040A4TApA) {
            try {
                if (!a5SV6n.equals(this.f4041A5SV6n)) {
                    this.f4043ARc23Z = 5;
                    return;
                }
                this.AMqCpz = 5;
                ?? r3 = this.f4039A2egSU;
                if (r3 != 0) {
                    r3.AZkASS(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // IhMMDv.A5SV6n
    public final boolean AaHO0E() {
        boolean z;
        synchronized (this.f4040A4TApA) {
            z = this.AMqCpz == 4;
        }
        return z;
    }

    @Override // IhMMDv.A5SV6n
    public final void clear() {
        synchronized (this.f4040A4TApA) {
            this.f4044ASJ6gh = false;
            this.AMqCpz = 3;
            this.f4043ARc23Z = 3;
            this.f4042ADYaiT.clear();
            this.f4041A5SV6n.clear();
        }
    }

    @Override // IhMMDv.A5SV6n
    public final boolean isRunning() {
        boolean z;
        synchronized (this.f4040A4TApA) {
            z = true;
            if (this.AMqCpz != 1) {
                z = false;
            }
        }
        return z;
    }

    @Override // IhMMDv.A5SV6n
    public final void pause() {
        synchronized (this.f4040A4TApA) {
            try {
                if (!CtFAbx.A2egSU(this.f4043ARc23Z)) {
                    this.f4043ARc23Z = 2;
                    this.f4042ADYaiT.pause();
                }
                if (!CtFAbx.A2egSU(this.AMqCpz)) {
                    this.AMqCpz = 2;
                    this.f4041A5SV6n.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

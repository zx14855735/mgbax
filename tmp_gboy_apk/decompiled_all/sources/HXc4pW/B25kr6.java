package HXc4pW;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B25kr6 implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f3568AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final IhMMDv.ASJ6gh f3569AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ B4ZgIw f3570AmA8tU;

    public /* synthetic */ B25kr6(B4ZgIw b4ZgIw, IhMMDv.ASJ6gh aSJ6gh, int i) {
        this.f3568AcNBzu = i;
        this.f3570AmA8tU = b4ZgIw;
        this.f3569AlLFFp = aSJ6gh;
    }

    private final void A2egSU() {
        IhMMDv.ASJ6gh aSJ6gh = this.f3569AlLFFp;
        aSJ6gh.f4013A2egSU.A2egSU();
        synchronized (aSJ6gh.f4014A4TApA) {
            synchronized (this.f3570AmA8tU) {
                try {
                    B3GDIM b3gdim = this.f3570AmA8tU.f3575AcNBzu;
                    IhMMDv.ASJ6gh aSJ6gh2 = this.f3569AlLFFp;
                    b3gdim.getClass();
                    if (b3gdim.f3573AcNBzu.contains(new B2KMhB(aSJ6gh2, ItGa5w.ARc23Z.f4080A4TApA))) {
                        B4ZgIw b4ZgIw = this.f3570AmA8tU;
                        IhMMDv.ASJ6gh aSJ6gh3 = this.f3569AlLFFp;
                        b4ZgIw.getClass();
                        try {
                            aSJ6gh3.ARc23Z(b4ZgIw.f3591BTvldC, 5);
                        } catch (Throwable th) {
                            throw new A5SV6n(th);
                        }
                    }
                    this.f3570AmA8tU.A5SV6n();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3568AcNBzu) {
            case 0:
                A2egSU();
                return;
            default:
                IhMMDv.ASJ6gh aSJ6gh = this.f3569AlLFFp;
                aSJ6gh.f4013A2egSU.A2egSU();
                synchronized (aSJ6gh.f4014A4TApA) {
                    synchronized (this.f3570AmA8tU) {
                        try {
                            B3GDIM b3gdim = this.f3570AmA8tU.f3575AcNBzu;
                            IhMMDv.ASJ6gh aSJ6gh2 = this.f3569AlLFFp;
                            b3gdim.getClass();
                            if (b3gdim.f3573AcNBzu.contains(new B2KMhB(aSJ6gh2, ItGa5w.ARc23Z.f4080A4TApA))) {
                                this.f3570AmA8tU.f3593BmvVmW.A5SV6n();
                                B4ZgIw b4ZgIw = this.f3570AmA8tU;
                                IhMMDv.ASJ6gh aSJ6gh3 = this.f3569AlLFFp;
                                b4ZgIw.getClass();
                                try {
                                    aSJ6gh3.ASJ6gh(b4ZgIw.f3593BmvVmW, b4ZgIw.f3589BNL6CD, b4ZgIw.f3595C2rE4F);
                                    this.f3570AmA8tU.AZkASS(this.f3569AlLFFp);
                                } catch (Throwable th) {
                                    throw new A5SV6n(th);
                                }
                            }
                            this.f3570AmA8tU.A5SV6n();
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
                return;
        }
    }
}

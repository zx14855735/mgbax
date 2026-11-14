package DaOi9o;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BNL6CD extends BChYOn {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f2273A2egSU = 1;

    /* renamed from: A4TApA, reason: collision with root package name */
    public B4ZgIw f2274A4TApA;

    public /* synthetic */ BNL6CD() {
    }

    @Override // DaOi9o.BChYOn, DaOi9o.B7CMnp
    public void ADYaiT(B4ZgIw b4ZgIw) {
        switch (this.f2273A2egSU) {
            case 1:
                BPw6Q8 bPw6Q8 = (BPw6Q8) this.f2274A4TApA;
                if (!bPw6Q8.f2278CkXcdM) {
                    bPw6Q8.CASmeH();
                    bPw6Q8.f2278CkXcdM = true;
                    break;
                }
                break;
        }
    }

    @Override // DaOi9o.BChYOn, DaOi9o.B7CMnp
    public final void ARc23Z(B4ZgIw b4ZgIw) {
        switch (this.f2273A2egSU) {
            case 0:
                this.f2274A4TApA.BTvldC();
                b4ZgIw.BJ7GGh(this);
                break;
            default:
                BPw6Q8 bPw6Q8 = (BPw6Q8) this.f2274A4TApA;
                int i = bPw6Q8.f2277CikNvS - 1;
                bPw6Q8.f2277CikNvS = i;
                if (i == 0) {
                    bPw6Q8.f2278CkXcdM = false;
                    bPw6Q8.AlLFFp();
                }
                b4ZgIw.BJ7GGh(this);
                break;
        }
    }

    public BNL6CD(B4ZgIw b4ZgIw) {
        this.f2274A4TApA = b4ZgIw;
    }
}

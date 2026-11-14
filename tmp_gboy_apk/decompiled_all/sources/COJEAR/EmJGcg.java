package COJEAR;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class EmJGcg {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final FG7pZc f1728A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public BV3sI0.A5SV6n[] f1729A4TApA;

    public EmJGcg() {
        this(new FG7pZc());
    }

    public final void A2egSU() {
        BV3sI0.A5SV6n[] a5SV6nArr = this.f1729A4TApA;
        if (a5SV6nArr != null) {
            BV3sI0.A5SV6n a5SV6n = a5SV6nArr[0];
            BV3sI0.A5SV6n a5SV6n2 = a5SV6nArr[1];
            FG7pZc fG7pZc = this.f1728A2egSU;
            if (a5SV6n2 == null) {
                a5SV6n2 = fG7pZc.f1747A2egSU.ARc23Z(2);
            }
            if (a5SV6n == null) {
                a5SV6n = fG7pZc.f1747A2egSU.ARc23Z(1);
            }
            ASJ6gh(BV3sI0.A5SV6n.A2egSU(a5SV6n, a5SV6n2));
            BV3sI0.A5SV6n a5SV6n3 = this.f1729A4TApA[com.bumptech.glide.AMqCpz.C4FrIb(16)];
            if (a5SV6n3 != null) {
                ARc23Z(a5SV6n3);
            }
            BV3sI0.A5SV6n a5SV6n4 = this.f1729A4TApA[com.bumptech.glide.AMqCpz.C4FrIb(32)];
            if (a5SV6n4 != null) {
                ADYaiT(a5SV6n4);
            }
            BV3sI0.A5SV6n a5SV6n5 = this.f1729A4TApA[com.bumptech.glide.AMqCpz.C4FrIb(64)];
            if (a5SV6n5 != null) {
                AYUAbz(a5SV6n5);
            }
        }
    }

    public abstract FG7pZc A4TApA();

    public void A5SV6n(int i, BV3sI0.A5SV6n a5SV6n) {
        if (this.f1729A4TApA == null) {
            this.f1729A4TApA = new BV3sI0.A5SV6n[9];
        }
        for (int i2 = 1; i2 <= 256; i2 <<= 1) {
            if ((i & i2) != 0) {
                this.f1729A4TApA[com.bumptech.glide.AMqCpz.C4FrIb(i2)] = a5SV6n;
            }
        }
    }

    public void ADYaiT(BV3sI0.A5SV6n a5SV6n) {
    }

    public abstract void AMqCpz(BV3sI0.A5SV6n a5SV6n);

    public void ARc23Z(BV3sI0.A5SV6n a5SV6n) {
    }

    public abstract void ASJ6gh(BV3sI0.A5SV6n a5SV6n);

    public void AYUAbz(BV3sI0.A5SV6n a5SV6n) {
    }

    public EmJGcg(FG7pZc fG7pZc) {
        this.f1728A2egSU = fG7pZc;
    }
}

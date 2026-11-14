package COJEAR;

import android.view.WindowInsets;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class EiK8oA extends EmJGcg {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final WindowInsets.Builder f1727A5SV6n;

    public EiK8oA() {
        this.f1727A5SV6n = AaHO0E.DcUJf1.AMqCpz();
    }

    @Override // COJEAR.EmJGcg
    public FG7pZc A4TApA() {
        WindowInsets build;
        A2egSU();
        build = this.f1727A5SV6n.build();
        FG7pZc ASJ6gh2 = FG7pZc.ASJ6gh(null, build);
        ASJ6gh2.f1747A2egSU.AzWtSf(this.f1729A4TApA);
        return ASJ6gh2;
    }

    @Override // COJEAR.EmJGcg
    public void ADYaiT(BV3sI0.A5SV6n a5SV6n) {
        this.f1727A5SV6n.setMandatorySystemGestureInsets(a5SV6n.ADYaiT());
    }

    @Override // COJEAR.EmJGcg
    public void AMqCpz(BV3sI0.A5SV6n a5SV6n) {
        this.f1727A5SV6n.setStableInsets(a5SV6n.ADYaiT());
    }

    @Override // COJEAR.EmJGcg
    public void ARc23Z(BV3sI0.A5SV6n a5SV6n) {
        this.f1727A5SV6n.setSystemGestureInsets(a5SV6n.ADYaiT());
    }

    @Override // COJEAR.EmJGcg
    public void ASJ6gh(BV3sI0.A5SV6n a5SV6n) {
        this.f1727A5SV6n.setSystemWindowInsets(a5SV6n.ADYaiT());
    }

    @Override // COJEAR.EmJGcg
    public void AYUAbz(BV3sI0.A5SV6n a5SV6n) {
        this.f1727A5SV6n.setTappableElementInsets(a5SV6n.ADYaiT());
    }

    public EiK8oA(FG7pZc fG7pZc) {
        super(fG7pZc);
        WindowInsets.Builder AMqCpz;
        WindowInsets ARc23Z2 = fG7pZc.ARc23Z();
        if (ARc23Z2 != null) {
            AMqCpz = AaHO0E.DcUJf1.ARc23Z(ARc23Z2);
        } else {
            AMqCpz = AaHO0E.DcUJf1.AMqCpz();
        }
        this.f1727A5SV6n = AMqCpz;
    }
}

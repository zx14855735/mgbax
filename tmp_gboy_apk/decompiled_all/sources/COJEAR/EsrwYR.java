package COJEAR;

import android.view.WindowInsets;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class EsrwYR extends ErKPGd {

    /* renamed from: AlLFFp, reason: collision with root package name */
    public BV3sI0.A5SV6n f1739AlLFFp;

    public EsrwYR(FG7pZc fG7pZc, WindowInsets windowInsets) {
        super(fG7pZc, windowInsets);
        this.f1739AlLFFp = null;
    }

    @Override // COJEAR.F32kj0
    public FG7pZc A4TApA() {
        return FG7pZc.ASJ6gh(null, this.f1735A5SV6n.consumeStableInsets());
    }

    @Override // COJEAR.F32kj0
    public FG7pZc A5SV6n() {
        return FG7pZc.ASJ6gh(null, this.f1735A5SV6n.consumeSystemWindowInsets());
    }

    @Override // COJEAR.F32kj0
    public final BV3sI0.A5SV6n AYUAbz() {
        if (this.f1739AlLFFp == null) {
            WindowInsets windowInsets = this.f1735A5SV6n;
            this.f1739AlLFFp = BV3sI0.A5SV6n.A4TApA(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.f1739AlLFFp;
    }

    @Override // COJEAR.F32kj0
    public boolean AlLFFp() {
        return this.f1735A5SV6n.isConsumed();
    }

    @Override // COJEAR.F32kj0
    public void B2KMhB(BV3sI0.A5SV6n a5SV6n) {
        this.f1739AlLFFp = a5SV6n;
    }
}

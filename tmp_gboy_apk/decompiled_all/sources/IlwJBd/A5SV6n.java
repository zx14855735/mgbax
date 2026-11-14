package IlwJBd;

import ItGa5w.AlLFFp;
import android.graphics.drawable.Drawable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A5SV6n implements AYUAbz {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f4050AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final int f4051AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public IhMMDv.A5SV6n f4052AmA8tU;

    public A5SV6n() {
        if (!AlLFFp.AYUAbz(Integer.MIN_VALUE, Integer.MIN_VALUE)) {
            throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: -2147483648 and height: -2147483648");
        }
        this.f4050AcNBzu = Integer.MIN_VALUE;
        this.f4051AlLFFp = Integer.MIN_VALUE;
    }

    @Override // IlwJBd.AYUAbz
    public final void A4TApA(IhMMDv.ASJ6gh aSJ6gh) {
    }

    @Override // IlwJBd.AYUAbz
    public void AMqCpz(Drawable drawable) {
    }

    @Override // IlwJBd.AYUAbz
    public final void ARc23Z(IhMMDv.A5SV6n a5SV6n) {
        this.f4052AmA8tU = a5SV6n;
    }

    @Override // IlwJBd.AYUAbz
    public final void ASJ6gh(Drawable drawable) {
    }

    @Override // IlwJBd.AYUAbz
    public final IhMMDv.A5SV6n AYUAbz() {
        return this.f4052AmA8tU;
    }

    @Override // IlwJBd.AYUAbz
    public final void AZkASS(IhMMDv.ASJ6gh aSJ6gh) {
        aSJ6gh.AcNBzu(this.f4050AcNBzu, this.f4051AlLFFp);
    }

    @Override // IQ76hF.AYUAbz
    public final void onDestroy() {
    }

    @Override // IQ76hF.AYUAbz
    public final void onStart() {
    }

    @Override // IQ76hF.AYUAbz
    public final void onStop() {
    }
}

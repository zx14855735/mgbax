package AaHO0E;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AaHO0E extends EicXu4 {

    /* renamed from: B9tovu, reason: collision with root package name */
    public final /* synthetic */ AcNBzu f607B9tovu;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AaHO0E(AcNBzu acNBzu, AcNBzu acNBzu2) {
        super(acNBzu2);
        this.f607B9tovu = acNBzu;
    }

    @Override // AaHO0E.EicXu4
    public final AZkASS.BmvVmW A4TApA() {
        AYUAbz aYUAbz = this.f607B9tovu.f608AcNBzu.f621BniPrB;
        if (aYUAbz == null) {
            return null;
        }
        return aYUAbz.A2egSU();
    }

    @Override // AaHO0E.EicXu4
    public final boolean A5SV6n() {
        this.f607B9tovu.f608AcNBzu.AmA8tU();
        return true;
    }

    @Override // AaHO0E.EicXu4
    public final boolean ADYaiT() {
        AzWtSf azWtSf = this.f607B9tovu.f608AcNBzu;
        if (azWtSf.f622C2rE4F != null) {
            return false;
        }
        azWtSf.AcNBzu();
        return true;
    }
}

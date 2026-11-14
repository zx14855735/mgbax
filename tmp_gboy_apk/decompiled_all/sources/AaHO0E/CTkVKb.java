package AaHO0E;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CTkVKb extends EicXu4 {

    /* renamed from: B9tovu, reason: collision with root package name */
    public final /* synthetic */ CrfGsy f693B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final /* synthetic */ D07BeM f694BChYOn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CTkVKb(D07BeM d07BeM, D07BeM d07BeM2, CrfGsy crfGsy) {
        super(d07BeM2);
        this.f694BChYOn = d07BeM;
        this.f693B9tovu = crfGsy;
    }

    @Override // AaHO0E.EicXu4
    public final AZkASS.BmvVmW A4TApA() {
        return this.f693B9tovu;
    }

    @Override // AaHO0E.EicXu4
    public final boolean A5SV6n() {
        D07BeM d07BeM = this.f694BChYOn;
        if (d07BeM.getInternalPopup().isShowing()) {
            return true;
        }
        d07BeM.f717B2KMhB.AaHO0E(d07BeM.getTextDirection(), d07BeM.getTextAlignment());
        return true;
    }
}

package PWr3nF;

import Oay4Bh.C2rE4F;
import android.text.Editable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AaHO0E extends C2rE4F {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ AmA8tU f7322AcNBzu;

    public AaHO0E(AmA8tU amA8tU) {
        this.f7322AcNBzu = amA8tU;
    }

    @Override // Oay4Bh.C2rE4F, android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.f7322AcNBzu.A4TApA().A2egSU();
    }

    @Override // Oay4Bh.C2rE4F, android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f7322AcNBzu.A4TApA().A4TApA();
    }
}

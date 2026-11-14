package PWr3nF;

import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AcNBzu {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ AmA8tU f7323A2egSU;

    public AcNBzu(AmA8tU amA8tU) {
        this.f7323A2egSU = amA8tU;
    }

    public final void A2egSU(TextInputLayout textInputLayout) {
        AmA8tU amA8tU = this.f7323A2egSU;
        if (amA8tU.f7346BmvVmW == textInputLayout.getEditText()) {
            return;
        }
        EditText editText = amA8tU.f7346BmvVmW;
        AaHO0E aaHO0E = amA8tU.f7348C2rE4F;
        if (editText != null) {
            editText.removeTextChangedListener(aaHO0E);
            if (amA8tU.f7346BmvVmW.getOnFocusChangeListener() == amA8tU.A4TApA().AMqCpz()) {
                amA8tU.f7346BmvVmW.setOnFocusChangeListener(null);
            }
        }
        EditText editText2 = textInputLayout.getEditText();
        amA8tU.f7346BmvVmW = editText2;
        if (editText2 != null) {
            editText2.addTextChangedListener(aaHO0E);
        }
        amA8tU.A4TApA().AlLFFp(amA8tU.f7346BmvVmW);
        amA8tU.AZkASS(amA8tU.A4TApA());
    }
}

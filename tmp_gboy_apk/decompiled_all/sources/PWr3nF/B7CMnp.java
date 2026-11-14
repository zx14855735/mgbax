package PWr3nF;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B7CMnp extends AzWtSf {
    public final int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public EditText f7388ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final Dphsd2.A2egSU f7389ASJ6gh;

    public B7CMnp(AmA8tU amA8tU, int i) {
        super(amA8tU);
        this.AMqCpz = 2131230944;
        this.f7389ASJ6gh = new Dphsd2.A2egSU(7, this);
        if (i != 0) {
            this.AMqCpz = i;
        }
    }

    @Override // PWr3nF.AzWtSf
    public final void A4TApA() {
        B2KMhB();
    }

    @Override // PWr3nF.AzWtSf
    public final int A5SV6n() {
        return 2131886670;
    }

    @Override // PWr3nF.AzWtSf
    public final int ADYaiT() {
        return this.AMqCpz;
    }

    @Override // PWr3nF.AzWtSf
    public final View.OnClickListener ARc23Z() {
        return this.f7389ASJ6gh;
    }

    @Override // PWr3nF.AzWtSf
    public final boolean AaHO0E() {
        return true;
    }

    @Override // PWr3nF.AzWtSf
    public final boolean AcNBzu() {
        EditText editText = this.f7388ARc23Z;
        return !(editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod));
    }

    @Override // PWr3nF.AzWtSf
    public final void AlLFFp(EditText editText) {
        this.f7388ARc23Z = editText;
        B2KMhB();
    }

    @Override // PWr3nF.AzWtSf
    public final void B3GDIM() {
        EditText editText = this.f7388ARc23Z;
        if (editText != null) {
            if (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224) {
                this.f7388ARc23Z.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    @Override // PWr3nF.AzWtSf
    public final void B4ZgIw() {
        EditText editText = this.f7388ARc23Z;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}

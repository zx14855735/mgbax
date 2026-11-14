package MS6BTZ;

import android.os.Bundle;
import android.view.View;
import androidx.preference.Preference;
import com.game.boy.view.BiosFilePreference;
import java.io.Serializable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class A4TApA extends AlLFFp implements DRlcZ9.AlLFFp {

    /* renamed from: B7CMnp, reason: collision with root package name */
    public androidx.activity.result.A5SV6n f5162B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public BiosFilePreference f5163B9tovu;

    @Override // DRlcZ9.AlLFFp
    public final boolean A2egSU(Preference preference, Serializable serializable) {
        return true;
    }

    @Override // MS6BTZ.AlLFFp
    public final int B25kr6() {
        return 2132082708;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        BiosFilePreference biosFilePreference = this.f5163B9tovu;
        if (biosFilePreference != null) {
            biosFilePreference.BpkvW3();
        }
    }

    @Override // DRlcZ9.B4ZgIw, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f5162B7CMnp = registerForActivityResult(new A4TApA.ADYaiT(), new IQ76hF.AmA8tU(12, this));
        BiosFilePreference biosFilePreference = (BiosFilePreference) AZkASS("biosFile");
        this.f5163B9tovu = biosFilePreference;
        if (biosFilePreference != null) {
            biosFilePreference.f9082B2KMhB = new AZkASS.ARc23Z(26, this);
        }
        Preference AZkASS2 = AZkASS("resetAdvancedSettings");
        if (AZkASS2 != null) {
            AZkASS2.f9082B2KMhB = new Hdahpu.AZOQYO(27);
        }
    }
}

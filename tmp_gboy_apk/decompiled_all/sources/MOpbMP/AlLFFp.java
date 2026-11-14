package MOpbMP;

import android.app.Dialog;
import android.os.Bundle;
import androidx.preference.DialogPreference;
import com.game.boy.view.KeyMappingPreference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AlLFFp extends DRlcZ9.B2KMhB {

    /* renamed from: B7CMnp, reason: collision with root package name */
    public int f5029B7CMnp = 0;

    @Override // DRlcZ9.B2KMhB
    public final void AmA8tU(boolean z) {
        if (z) {
            DialogPreference AcNBzu2 = AcNBzu();
            if (AcNBzu2 instanceof KeyMappingPreference) {
                KeyMappingPreference keyMappingPreference = (KeyMappingPreference) AcNBzu2;
                if (keyMappingPreference.A2egSU(Integer.valueOf(this.f5029B7CMnp))) {
                    keyMappingPreference.BmvVmW(this.f5029B7CMnp);
                }
            }
        }
    }

    @Override // DRlcZ9.B2KMhB, androidx.fragment.app.B4ZgIw
    public final Dialog onCreateDialog(Bundle bundle) {
        OOnEhG.A4TApA a4TApA = new OOnEhG.A4TApA(requireContext());
        a4TApA.AZOQYO(2131886689);
        a4TApA.f81AcNBzu.f35AmA8tU = false;
        a4TApA.AmA8tU(2131886183, new DRlcZ9.ASJ6gh(2, this));
        a4TApA.AaHO0E(2131886161, null);
        ADYaiT.AmA8tU A2egSU2 = a4TApA.A2egSU();
        A2egSU2.setOnShowListener(new AaHO0E(this, 0, A2egSU2));
        return A2egSU2;
    }
}

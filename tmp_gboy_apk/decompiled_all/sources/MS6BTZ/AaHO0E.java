package MS6BTZ;

import OLy1FW.B25kr6;
import OLy1FW.B2KMhB;
import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import java.io.Serializable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AaHO0E extends AlLFFp implements DRlcZ9.AlLFFp {
    @Override // DRlcZ9.AlLFFp
    public final boolean A2egSU(Preference preference, Serializable serializable) {
        if (!"dynamic_colors".equals(preference.f9088BI9f7h)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 31) {
            return true;
        }
        FragmentActivity requireActivity = requireActivity();
        int[] iArr = OLy1FW.AmA8tU.f6371A2egSU;
        OLy1FW.AmA8tU.A2egSU(requireActivity, new B2KMhB(new B25kr6()));
        return true;
    }

    @Override // MS6BTZ.AlLFFp
    public final int B25kr6() {
        return 2132082714;
    }
}

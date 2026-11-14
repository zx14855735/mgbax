package MS6BTZ;

import ADYaiT.BJ7GGh;
import android.os.Bundle;
import android.view.View;
import androidx.preference.Preference;
import androidx.preference.SwitchPreferenceCompat;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.io.Serializable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AmA8tU extends AlLFFp implements DRlcZ9.AlLFFp, DRlcZ9.AmA8tU {

    /* renamed from: B7CMnp, reason: collision with root package name */
    public SwitchPreferenceCompat f5177B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public SwitchPreferenceCompat f5178B9tovu;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // DRlcZ9.AlLFFp
    public final boolean A2egSU(Preference preference, Serializable serializable) {
        char c;
        String str = preference.f9088BI9f7h;
        if (str.equals("dynamic_color")) {
            this.f5178B9tovu.BmvVmW(false);
            this.f5178B9tovu.BIYEnU(!r12.booleanValue());
            ((com.game.boy.activity.A5SV6n) getActivity()).ARc23Z(((Boolean) serializable).booleanValue(), -15108398, true, false, (com.game.boy.activity.A5SV6n) getActivity());
            return true;
        }
        if (!str.equals("theme_mode")) {
            if (!str.equals("themeSwitch")) {
                return false;
            }
            this.f5177B7CMnp.BmvVmW(false);
            this.f5177B7CMnp.BIYEnU(!r12.booleanValue());
            ((com.game.boy.activity.A5SV6n) getActivity()).ARc23Z(false, -15108398, true, ((Boolean) serializable).booleanValue(), (com.game.boy.activity.A5SV6n) getActivity());
            return true;
        }
        String str2 = (String) serializable;
        ((com.game.boy.activity.A5SV6n) getActivity()).getClass();
        str2.getClass();
        switch (str2.hashCode()) {
            case 3005871:
                if (str2.equals(LiveConfigKey.AUTO)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 3075958:
                if (str2.equals("dark")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 102970646:
                if (str2.equals("light")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                BJ7GGh.AaHO0E(0);
                break;
            case 1:
                BJ7GGh.AaHO0E(2);
                break;
            case 2:
                BJ7GGh.AaHO0E(1);
                break;
            default:
                BJ7GGh.AaHO0E(-1);
                break;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // DRlcZ9.AmA8tU
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean AaHO0E(androidx.preference.Preference r7) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: MS6BTZ.AmA8tU.AaHO0E(androidx.preference.Preference):boolean");
    }

    @Override // MS6BTZ.AlLFFp
    public final int B25kr6() {
        return 2132082715;
    }

    @Override // DRlcZ9.B4ZgIw, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        AZkASS("view_logs").f9082B2KMhB = this;
        AZkASS("themeColor").f9082B2KMhB = this;
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) AZkASS("dynamic_color");
        this.f5177B7CMnp = switchPreferenceCompat;
        switchPreferenceCompat.f9081B25kr6 = this;
        SwitchPreferenceCompat switchPreferenceCompat2 = (SwitchPreferenceCompat) AZkASS("themeSwitch");
        this.f5178B9tovu = switchPreferenceCompat2;
        switchPreferenceCompat2.f9081B25kr6 = this;
        this.f5177B7CMnp.BIYEnU(!switchPreferenceCompat2.f9152D6yqiO);
        this.f5178B9tovu.BIYEnU(!this.f5177B7CMnp.f9152D6yqiO);
        AZkASS("theme_mode").f9081B25kr6 = this;
    }
}

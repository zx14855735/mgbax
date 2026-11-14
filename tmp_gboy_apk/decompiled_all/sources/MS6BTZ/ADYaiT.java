package MS6BTZ;

import DRlcZ9.BNL6CD;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import com.game.boy.activity.KeyMappingSettings;
import com.game.boy.activity.KeyProfilesActivity;
import com.game.boy.activity.LayoutsActivity;
import java.io.Serializable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ADYaiT extends AlLFFp implements DRlcZ9.AlLFFp, DRlcZ9.AmA8tU {
    @Override // DRlcZ9.AlLFFp
    public final boolean A2egSU(Preference preference, Serializable serializable) {
        return false;
    }

    @Override // DRlcZ9.AmA8tU
    public final boolean AaHO0E(Preference preference) {
        String str = preference.f9088BI9f7h;
        str.getClass();
        switch (str) {
            case "controlsLayout":
                startActivity(new Intent(getActivity(), (Class<?>) LayoutsActivity.class));
                return true;
            case "keyMappings":
                FragmentActivity requireActivity = requireActivity();
                Intent intent = new Intent(requireActivity(), (Class<?>) KeyMappingSettings.class);
                FragmentActivity requireActivity2 = requireActivity();
                SharedPreferences sharedPreferences = requireActivity2.getSharedPreferences(BNL6CD.A2egSU(requireActivity2), 0);
                int i = KeyProfilesActivity.f11051B4ZgIw;
                requireActivity.startActivity(intent.putExtra("profile-name", sharedPreferences.getString("keyProfile", "Default")));
                return true;
            case "selectInputMethod":
                InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.showInputMethodPicker();
                    return true;
                }
                startActivity(new Intent("android.settings.INPUT_METHOD_SETTINGS"));
                return true;
            case "keyMappingProfiles":
                startActivity(new Intent(getActivity(), (Class<?>) KeyProfilesActivity.class));
                return true;
            default:
                return false;
        }
    }

    @Override // MS6BTZ.AlLFFp
    public final int B25kr6() {
        return 2132082709;
    }

    @Override // DRlcZ9.B4ZgIw, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        AZkASS("selectInputMethod").f9082B2KMhB = this;
        AZkASS("keyMappings").f9082B2KMhB = this;
        AZkASS("keyMappingProfiles").f9082B2KMhB = this;
        AZkASS("controlsLayout").f9082B2KMhB = this;
    }
}

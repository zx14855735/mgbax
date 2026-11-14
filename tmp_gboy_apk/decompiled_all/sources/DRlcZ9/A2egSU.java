package DRlcZ9;

import android.widget.CompoundButton;
import androidx.preference.CheckBoxPreference;
import androidx.preference.SwitchPreference;
import androidx.preference.SwitchPreferenceCompat;
import com.game.boy.view.SwitchRowView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f2070A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Object f2071A4TApA;

    public /* synthetic */ A2egSU(int i, Object obj) {
        this.f2070A2egSU = i;
        this.f2071A4TApA = obj;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        switch (this.f2070A2egSU) {
            case 0:
                Boolean valueOf = Boolean.valueOf(z);
                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.f2071A4TApA;
                if (!checkBoxPreference.A2egSU(valueOf)) {
                    compoundButton.setChecked(!z);
                    break;
                } else {
                    checkBoxPreference.BmvVmW(z);
                    break;
                }
            case 1:
                Boolean valueOf2 = Boolean.valueOf(z);
                SwitchPreference switchPreference = (SwitchPreference) this.f2071A4TApA;
                if (!switchPreference.A2egSU(valueOf2)) {
                    compoundButton.setChecked(!z);
                    break;
                } else {
                    switchPreference.BmvVmW(z);
                    break;
                }
            case 2:
                Boolean valueOf3 = Boolean.valueOf(z);
                SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) this.f2071A4TApA;
                if (!switchPreferenceCompat.A2egSU(valueOf3)) {
                    compoundButton.setChecked(!z);
                    break;
                } else {
                    switchPreferenceCompat.BmvVmW(z);
                    break;
                }
            default:
                ((SwitchRowView) this.f2071A4TApA).A2egSU();
                break;
        }
    }
}

package MS6BTZ;

import android.content.SharedPreferences;
import androidx.fragment.app.FragmentActivity;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AYUAbz implements QTPNDK.A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f5169A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ AlLFFp f5170A4TApA;

    public /* synthetic */ AYUAbz(AlLFFp alLFFp, int i) {
        this.f5169A2egSU = i;
        this.f5170A4TApA = alLFFp;
    }

    @Override // QTPNDK.A2egSU
    public final void A2egSU(QJCbnW.A4TApA a4TApA) {
        switch (this.f5169A2egSU) {
            case 0:
                FragmentActivity requireActivity = ((AZOQYO) this.f5170A4TApA).requireActivity();
                SharedPreferences.Editor edit = requireActivity.getSharedPreferences(requireActivity.getPackageName() + "_preferences", 0).edit();
                edit.apply();
                edit.putInt("game_COLOR", a4TApA.f7468A2egSU).apply();
                break;
            default:
                AmA8tU amA8tU = (AmA8tU) this.f5170A4TApA;
                FragmentActivity requireActivity2 = amA8tU.requireActivity();
                SharedPreferences sharedPreferences = requireActivity2.getSharedPreferences(requireActivity2.getPackageName() + "_preferences", 0);
                SharedPreferences.Editor edit2 = sharedPreferences.edit();
                edit2.apply();
                ((com.game.boy.activity.A5SV6n) amA8tU.getActivity()).ARc23Z(sharedPreferences.getBoolean("dynamic_color", false), a4TApA.f7468A2egSU, true, sharedPreferences.getBoolean("themeSwitch", false), (com.game.boy.activity.A5SV6n) amA8tU.getActivity());
                edit2.putInt("theme_COLOR", a4TApA.f7468A2egSU).apply();
                break;
        }
    }
}

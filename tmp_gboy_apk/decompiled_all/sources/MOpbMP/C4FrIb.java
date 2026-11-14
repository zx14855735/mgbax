package MOpbMP;

import androidx.fragment.app.CtxOCS;
import androidx.fragment.app.Fragment;
import androidx.preference.Preference;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.game.boy.activity.SettingsActivity;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class C4FrIb extends MS6BTZ.AlLFFp {
    @Override // DRlcZ9.B4ZgIw, DRlcZ9.BJ7GGh
    public final boolean A5SV6n(Preference preference) {
        String str = preference.f9088BI9f7h;
        String str2 = "pref_theme".equals(str) ? "theme" : "pref_display".equals(str) ? "display" : "pref_audio".equals(str) ? MediaFormat.KEY_AUDIO : "pref_buttons".equals(str) ? "button" : "pref_layout".equals(str) ? "layout" : "pref_misc".equals(str) ? "misc" : "pref_advanced".equals(str) ? "advanced" : "pref_about".equals(str) ? "about" : null;
        if (str2 == null) {
            return super.A5SV6n(preference);
        }
        SettingsActivity settingsActivity = (SettingsActivity) requireActivity();
        Fragment BPw6Q82 = settingsActivity.getSupportFragmentManager().BPw6Q8(2131296527);
        if (BPw6Q82 != null && str2.equals(BPw6Q82.getTag())) {
            return true;
        }
        settingsActivity.f11085B25kr6.f11086ADYaiT = str2;
        CtxOCS supportFragmentManager = settingsActivity.getSupportFragmentManager();
        supportFragmentManager.getClass();
        androidx.fragment.app.A2egSU a2egSU = new androidx.fragment.app.A2egSU(supportFragmentManager);
        if (settingsActivity.getResources().getConfiguration().orientation != 2) {
            a2egSU.f8921ARc23Z = 4097;
        } else {
            a2egSU.f8921ARc23Z = 4099;
        }
        Fragment BTvldC2 = settingsActivity.getSupportFragmentManager().BTvldC(str2);
        if (BTvldC2 == null) {
            a2egSU.AZOQYO(2131296527, SettingsActivity.AYUAbz(str2), str2, 1);
        } else {
            a2egSU.AzWtSf(BTvldC2);
        }
        if (BPw6Q82 != null) {
            if ("main".equals(BPw6Q82.getTag())) {
                a2egSU.AZkASS(BPw6Q82);
            } else {
                a2egSU.AcNBzu(BPw6Q82);
            }
        }
        a2egSU.AMqCpz();
        return true;
    }

    @Override // MS6BTZ.AlLFFp
    public final int B25kr6() {
        return 2132082713;
    }
}

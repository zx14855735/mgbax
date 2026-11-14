package DRlcZ9;

import MOpbMP.CcAIMM;
import MOpbMP.CmUvjW;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import androidx.fragment.app.FragmentActivity;
import com.game.boy.activity.CheatsActivity;
import com.game.boy.activity.DownLoadActivity;
import com.game.boy.activity.EditCheatActivity;
import com.game.boy.activity.EmulatorActivity;
import com.game.boy.activity.KeyMappingSettings;
import com.game.boy.view.ShaderFilePreference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh implements DialogInterface.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2079AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f2080AlLFFp;

    public /* synthetic */ ASJ6gh(int i, Object obj) {
        this.f2079AcNBzu = i;
        this.f2080AlLFFp = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = 0;
        switch (this.f2079AcNBzu) {
            case 0:
                AYUAbz aYUAbz = (AYUAbz) this.f2080AlLFFp;
                aYUAbz.f2081B7CMnp = i;
                aYUAbz.f2099B4ZgIw = -1;
                dialogInterface.dismiss();
                break;
            case 1:
                ((com.game.boy.activity.A5SV6n) this.f2080AlLFFp).finishAffinity();
                break;
            case 2:
                MOpbMP.AlLFFp alLFFp = (MOpbMP.AlLFFp) this.f2080AlLFFp;
                alLFFp.f5029B7CMnp = 0;
                alLFFp.AmA8tU(true);
                break;
            case 3:
                ((Runnable) this.f2080AlLFFp).run();
                break;
            case 4:
                CmUvjW cmUvjW = ((CcAIMM) this.f2080AlLFFp).f5116AcNBzu;
                MOpbMP.ARc23Z.AlLFFp(cmUvjW.f5123AcNBzu);
                cmUvjW.AmA8tU();
                break;
            case 5:
                MS6BTZ.AZOQYO azoqyo = (MS6BTZ.AZOQYO) this.f2080AlLFFp;
                new I3HV03.A4TApA(azoqyo.requireActivity(), (String) null).BIYEnU("game_COLOR", -15108398);
                new I3HV03.A4TApA(azoqyo.requireActivity(), azoqyo.requireActivity().getPackageName()).BIYEnU("game_COLOR", -15108398);
                break;
            case 6:
                MS6BTZ.AmA8tU amA8tU = (MS6BTZ.AmA8tU) this.f2080AlLFFp;
                FragmentActivity requireActivity = amA8tU.requireActivity();
                SharedPreferences sharedPreferences = requireActivity.getSharedPreferences(requireActivity.getPackageName() + "_preferences", 0);
                sharedPreferences.edit().apply();
                ((com.game.boy.activity.A5SV6n) amA8tU.getActivity()).ARc23Z(sharedPreferences.getBoolean("dynamic_color", false), -15108398, true, sharedPreferences.getBoolean("themeSwitch", false), (com.game.boy.activity.A5SV6n) amA8tU.getActivity());
                FragmentActivity requireActivity2 = amA8tU.requireActivity();
                SharedPreferences.Editor edit = requireActivity2.getSharedPreferences(requireActivity2.getPackageName() + "_preferences", 0).edit();
                edit.apply();
                edit.putInt("theme_COLOR", -15108398).apply();
                FragmentActivity requireActivity3 = amA8tU.requireActivity();
                String packageName = amA8tU.requireActivity().getPackageName();
                if (packageName == null) {
                    packageName = requireActivity3.getPackageName() + "_preferences";
                }
                SharedPreferences.Editor edit2 = requireActivity3.getSharedPreferences(packageName, 0).edit();
                edit2.apply();
                edit2.putInt("theme_COLOR", -15108398).apply();
                break;
            case 7:
                ((I3HV03.A4TApA) this.f2080AlLFFp).BI9f7h("on_line_room", true);
                break;
            case 8:
                ((ShaderFilePreference) this.f2080AlLFFp).BpkvW3();
                break;
            case 9:
                PreferenceManager.getDefaultSharedPreferences((CheatsActivity) this.f2080AlLFFp).edit().putBoolean("enableCheats", true).apply();
                break;
            case 10:
                DownLoadActivity downLoadActivity = (DownLoadActivity) this.f2080AlLFFp;
                SQLiteDatabase writableDatabase = new L5dZB6.A2egSU(downLoadActivity).getWritableDatabase();
                writableDatabase.delete("downloads", null, null);
                writableDatabase.close();
                int i3 = DownLoadActivity.f10972BI9f7h;
                downLoadActivity.f10978B9tovu.execute(new com.game.boy.activity.ASJ6gh(i2, downLoadActivity));
                break;
            case 11:
                ((EditCheatActivity) this.f2080AlLFFp).finish();
                break;
            case 12:
                LHpdLt.BTvldC bTvldC = LHpdLt.BTvldC.f4560CikNvS;
                if (bTvldC != null) {
                    bTvldC.AYUAbz(true);
                }
                EmulatorActivity emulatorActivity = ((com.game.boy.activity.B4ZgIw) ((MOpbMP.A2egSU) this.f2080AlLFFp).f4987AmA8tU).f10911AcNBzu.f10914AmA8tU;
                emulatorActivity.BpkvW3 = null;
                emulatorActivity.C2rE4F();
                break;
            default:
                KeyMappingSettings keyMappingSettings = (KeyMappingSettings) this.f2080AlLFFp;
                int[] AaHO0E2 = KeyMappingSettings.AaHO0E();
                while (i2 < AaHO0E2.length) {
                    keyMappingSettings.f11050B3GDIM[i2].BmvVmW(AaHO0E2[i2]);
                    i2++;
                }
                keyMappingSettings.f11048B25kr6 = true;
                KeyMappingSettings.f11040B4ZgIw = true;
                break;
        }
    }
}

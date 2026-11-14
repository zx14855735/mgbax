package MOpbMP;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.DialogPreference;
import androidx.preference.PreferenceScreen;
import com.game.boy.activity.KeyMappingSettings;
import com.game.boy.view.KeyMappingPreference;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class C2rE4F extends DRlcZ9.B4ZgIw {

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final HashMap f5086B7CMnp = new HashMap();

    /* renamed from: B9tovu, reason: collision with root package name */
    public KeyMappingSettings f5087B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public int[] f5088BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public int[] f5089BI9f7h;

    @Override // DRlcZ9.B4ZgIw, DRlcZ9.BIYEnU
    public final void ADYaiT(DialogPreference dialogPreference) {
        if (!(dialogPreference instanceof KeyMappingPreference)) {
            super.ADYaiT(dialogPreference);
            return;
        }
        if (((androidx.fragment.app.B4ZgIw) getFragmentManager().BTvldC("customDialog")) != null) {
            return;
        }
        String str = dialogPreference.f9088BI9f7h;
        AlLFFp alLFFp = new AlLFFp();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        alLFFp.setArguments(bundle);
        alLFFp.setTargetFragment(this, 0);
        alLFFp.show(getFragmentManager(), "customDialog");
    }

    @Override // DRlcZ9.B4ZgIw
    public final void AlLFFp(String str) {
        DRlcZ9.BNL6CD bnl6cd = this.f2105AlLFFp;
        FragmentActivity activity = getActivity();
        bnl6cd.getClass();
        PreferenceScreen preferenceScreen = new PreferenceScreen(activity, null);
        preferenceScreen.AcNBzu(bnl6cd);
        AmA8tU(preferenceScreen);
        KeyMappingSettings keyMappingSettings = (KeyMappingSettings) getActivity();
        this.f5087B9tovu = keyMappingSettings;
        if (keyMappingSettings == null) {
            return;
        }
        this.f5088BChYOn = KeyMappingSettings.f11043BChYOn;
        this.f5089BI9f7h = KeyMappingSettings.f11042B9tovu;
        new Thread(new A2egSU(this, 11, preferenceScreen)).start();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        HashMap hashMap = this.f5086B7CMnp;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}

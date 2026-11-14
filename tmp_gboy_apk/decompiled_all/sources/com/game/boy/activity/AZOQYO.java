package com.game.boy.activity;

import androidx.preference.Preference;
import com.game.boy.activity.EditCheatActivity;
import com.game.boy.viewUi.MaterialEditTextPreference;
import java.io.Serializable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AZOQYO implements DRlcZ9.AlLFFp {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ EditCheatActivity f10897AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ EditCheatActivity.A2egSU f10898AlLFFp;

    public AZOQYO(EditCheatActivity.A2egSU a2egSU, EditCheatActivity editCheatActivity) {
        this.f10898AlLFFp = a2egSU;
        this.f10897AcNBzu = editCheatActivity;
    }

    @Override // DRlcZ9.AlLFFp
    public final boolean A2egSU(Preference preference, Serializable serializable) {
        String str = (String) serializable;
        EditCheatActivity editCheatActivity = this.f10897AcNBzu;
        editCheatActivity.f10986BChYOn = str;
        editCheatActivity.f10984B7CMnp = true;
        MaterialEditTextPreference materialEditTextPreference = editCheatActivity.f10981B2KMhB;
        EditCheatActivity.A2egSU a2egSU = this.f10898AlLFFp;
        if (str != null) {
            a2egSU.getClass();
            if (!str.isEmpty()) {
                materialEditTextPreference.BNL6CD(str);
                return true;
            }
        }
        materialEditTextPreference.BNL6CD(a2egSU.getString(2131886314));
        return true;
    }
}

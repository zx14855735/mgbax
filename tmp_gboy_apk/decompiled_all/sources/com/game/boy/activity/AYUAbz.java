package com.game.boy.activity;

import androidx.preference.Preference;
import com.game.boy.activity.EditCheatActivity;
import java.io.Serializable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AYUAbz implements DRlcZ9.AlLFFp {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ EditCheatActivity f10895AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ EditCheatActivity.A2egSU f10896AlLFFp;

    public AYUAbz(EditCheatActivity.A2egSU a2egSU, EditCheatActivity editCheatActivity) {
        this.f10896AlLFFp = a2egSU;
        this.f10895AcNBzu = editCheatActivity;
    }

    @Override // DRlcZ9.AlLFFp
    public final boolean A2egSU(Preference preference, Serializable serializable) {
        String str = (String) serializable;
        EditCheatActivity editCheatActivity = this.f10895AcNBzu;
        editCheatActivity.f10985B9tovu = str;
        editCheatActivity.f10984B7CMnp = true;
        this.f10896AlLFFp.B25kr6(editCheatActivity.f10980B25kr6, str);
        return true;
    }
}

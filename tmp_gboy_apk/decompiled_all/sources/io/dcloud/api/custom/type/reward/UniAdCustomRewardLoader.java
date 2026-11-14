package io.dcloud.api.custom.type.reward;

import android.app.Activity;
import io.dcloud.api.custom.type.UniAdCustomBaseLoader;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaaa;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class UniAdCustomRewardLoader extends UniAdCustomBaseLoader {
    public void onReward() {
        aaaaaaaa aaaaaaaaVar = this.aaaaaaaa;
        if (aaaaaaaaVar instanceof aaaaaaaa.InterfaceC0548aaaaaaaa) {
            ((aaaaaaaa.InterfaceC0548aaaaaaaa) aaaaaaaaVar).aaaaaaaa();
        }
    }

    public abstract void show(Activity activity);

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void show(Object obj) {
        show((Activity) obj);
    }
}

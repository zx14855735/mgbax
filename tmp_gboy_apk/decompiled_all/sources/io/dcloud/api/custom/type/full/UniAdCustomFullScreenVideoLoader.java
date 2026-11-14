package io.dcloud.api.custom.type.full;

import android.app.Activity;
import io.dcloud.api.custom.type.UniAdCustomBaseLoader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class UniAdCustomFullScreenVideoLoader extends UniAdCustomBaseLoader {
    public abstract void show(Activity activity);

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void show(Object obj) {
        show((Activity) obj);
    }
}

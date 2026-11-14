package io.dcloud.api.custom.type.splash;

import android.view.ViewGroup;
import io.dcloud.api.custom.type.UniAdCustomBaseLoader;
import io.dcloud.api.custom.type.feed.UniAdCustomNativeAd;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class UniAdCustomSplashLoader extends UniAdCustomBaseLoader {
    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void onLoadSuccess(List<? extends UniAdCustomNativeAd> list) {
        onLoadSuccess();
    }

    public abstract void show(ViewGroup viewGroup);

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void show(Object obj) {
        show((ViewGroup) obj);
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public final void onLoadSuccess() {
        super.onLoadSuccess();
    }
}

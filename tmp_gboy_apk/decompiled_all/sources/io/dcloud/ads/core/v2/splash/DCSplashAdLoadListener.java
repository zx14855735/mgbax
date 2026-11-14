package io.dcloud.ads.core.v2.splash;

import android.view.View;
import android.widget.FrameLayout;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaacaaaa.aaaaaaa0;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface DCSplashAdLoadListener extends aaaaaaa0 {
    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaacaaaa.aaaaaaa0
    /* synthetic */ void onError(int i, String str, JSONArray jSONArray);

    void onSplashAdLoad();

    void redBag(View view, FrameLayout.LayoutParams layoutParams);
}

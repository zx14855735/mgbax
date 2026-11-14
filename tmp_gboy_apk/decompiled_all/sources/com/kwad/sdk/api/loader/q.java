package com.kwad.sdk.api.loader;

import android.content.Context;
import com.kwad.sdk.api.SdkConfig;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface q {
    String getAESKey(Context context);

    void holdSdkConfig(SdkConfig sdkConfig);

    void onInit(Context context);

    void reportDexLoadError(Context context, DexLoadError dexLoadError);
}

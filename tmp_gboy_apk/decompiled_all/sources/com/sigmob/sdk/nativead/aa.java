package com.sigmob.sdk.nativead;

import com.sigmob.windad.natives.WindNativeAdData;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface aa {
    void onNativeAdLoadFail(int i, String str);

    void onNativeAdLoaded(List<WindNativeAdData> list);
}

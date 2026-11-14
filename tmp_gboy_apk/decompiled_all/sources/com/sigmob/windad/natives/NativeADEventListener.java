package com.sigmob.windad.natives;

import com.sigmob.windad.WindAdError;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface NativeADEventListener {
    void onAdClicked();

    void onAdDetailDismiss();

    void onAdDetailShow();

    void onAdError(WindAdError windAdError);

    void onAdExposed();
}

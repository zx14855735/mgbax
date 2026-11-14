package com.fl.saas.s2s.sdk.ad.video.fullscreen;

import com.fl.saas.config.exception.YdError;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface OnS2SFullVideoADListener {
    void onClick(String str);

    void onClose();

    void onComplete(double d);

    void onError(YdError ydError);

    void onFullVideoAdFailed(YdError ydError);

    void onLoad(S2SFullVideoADManager s2SFullVideoADManager);
}

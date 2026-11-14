package com.fl.saas.s2s.sdk.helper;

import com.fl.saas.config.exception.YdError;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface OnYqAdListener {
    void onAdFailed(YdError ydError);

    void onNativeAdReceived(List<AdInfoPoJo> list);
}

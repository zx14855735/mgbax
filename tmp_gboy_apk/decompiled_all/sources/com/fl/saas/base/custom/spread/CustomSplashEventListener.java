package com.fl.saas.base.custom.spread;

import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface CustomSplashEventListener {
    void onDeeplinkCallback(boolean z);

    void onDownloadConfirm(Context context);

    void onSplashAdClicked();

    void onSplashAdDismiss();

    void onSplashAdShow();
}
